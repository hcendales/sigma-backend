/*
 * Clase para ejecutar sentencias PL/SQL establecidas en el modelo de BD
 */
package co.gov.umv.sigma.backend.comun.dao;

import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.hibernate.engine.internal.Collections;

import co.gov.umv.sigma.backend.comun.cbo.*;
import co.gov.umv.sigma.backend.comun.config.ConexionDS;

public class GenericoDAO {
    /**
     * 
     * @param sentencia
     * @param objetoSalida
     * @return
     * @throws Exception
     */
    public ObjetoSalida ejecutar(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    else{
                        if (parametro.getTipoDato() == OracleTypes.CLOB) {
                            Clob clob = con.createClob();
                            clob.setString(1, parametro.getValor().toString());
                            callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                            } 
                        else {
                            callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                            }
                    }
                } else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
            }

            callableStatement.setInt("p_Usuario", sentencia.getIdUsuario());
            callableStatement.registerOutParameter("p_Respuesta", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("p_codError", OracleTypes.INTEGER);
            callableStatement.registerOutParameter("p_msjError", OracleTypes.VARCHAR);

            callableStatement.execute();

            objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_codError")));
            objetoSalida.setMsgError(callableStatement.getString("p_msjError"));

            if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {
                
                try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_Respuesta"))){
                    ResultSetMetaData infoResultado = datos.getMetaData();
                    Integer columnas = infoResultado.getColumnCount();
                    List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();

                    while (datos.next()) {
                    	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(columnas);
                        for (Integer i = 1; i <= columnas; ++i) {
                            if (infoResultado.getColumnType(i) == OracleTypes.BLOB) {
                                Blob clob = datos.getBlob(i);
                                String theString = "";
                                InputStream blob = null;
                                if(clob != null){
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    StringWriter writer = new StringWriter();
                                    IOUtils.copy(blob, writer, "UTF-8");
                                    theString = writer.toString();
                                
                                }
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                            }
                            else {
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));                                
                            }
                        }
                        respuesta.add(registro);
                    }
                    java.util.Collections.sort((List) respuesta);	
                    objetoSalida.setRespuesta(respuesta);
                    
                }catch(Exception e){
                	e.printStackTrace();
                    objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    objetoSalida.setMsgError("NO SE ENCONTRARON DATOS " +e.getMessage());
                }
                
            }
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString());
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public Connection conectar() throws Exception {

        //return Conexion.obtenerInstancia().obtenerConexion();
        //return ConexionDS.obtenerConexion();
        return ConexionDS.obtenerInstancia();
    }
    
    /**
     * 
     * @param sentencia
     * @return
     */
    private String obtenerSQL(SentenciaDAO sentencia) {

        String parametrosAdicioanles = "";
        for (SentenciaParametroDAO parametro : sentencia.getParametros())
            parametrosAdicioanles += "?, ";

        return "{call " + sentencia.getNombre() + " (?, " + parametrosAdicioanles + " ?, ?, ?)}";
    }
    
    private String obtenerSQLFunction(SentenciaDAO sentencia) {

        String parametrosAdicioanles = "";
        for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
        	if(parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
        		parametrosAdicioanles += "?, ";
        	}        	
        }
            
        System.out.println("{? = call " + sentencia.getNombre() + " (" + parametrosAdicioanles.substring(0,parametrosAdicioanles.length()-2) + ")}");
        return "{? = call " + sentencia.getNombre() + " (" + parametrosAdicioanles.substring(0,parametrosAdicioanles.length()-2) + ")}";
    }
    /**
     * 
     * @param sentencia
     * @param objetoSalida
     * @return
     * @throws Exception
     */
    public ObjetoSalida ejecutarX(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    if (parametro.getTipoDato() == OracleTypes.CLOB) {
                        Clob clob = con.createClob();
                        clob.setString(1, parametro.getValor().toString());
                        callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                    } else {
                    	System.out.println("NOMBRE " + parametro.getNombre() + " VALOR " + parametro.getValor() + " TIPO DATOS " + parametro.getTipoDato());
                    	callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());                   
                    }
                }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
                
            }
            callableStatement.setObject("p_Usuario", sentencia.getUsuario());
            callableStatement.registerOutParameter("p_resultado", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("p_coderror", OracleTypes.INTEGER);
            callableStatement.registerOutParameter("p_msjerror", OracleTypes.VARCHAR);
            callableStatement.execute();
            objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_coderror")));
            objetoSalida.setMsgError(callableStatement.getString("p_msjerror"));
            
            if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {

                try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_resultado"))){
                	ResultSetMetaData infoResultado = datos.getMetaData();
                    Integer columnas = infoResultado.getColumnCount();
                    List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
                    	
                    while (datos.next()) {
                    	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(columnas);
                        HashMap<String, Integer> ordenamiento = new HashMap<String, Integer>(columnas);
                        
                        for (Integer i = 1; i <= columnas; ++i) {
                            if (infoResultado.getColumnType(i) == OracleTypes.BLOB) {
                                Blob clob = datos.getBlob(i);
                                String theString = "";
                                InputStream blob = null;
                                if(clob != null){
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    StringWriter writer = new StringWriter();
                                    IOUtils.copy(blob, writer, "UTF-8");
                                    theString = writer.toString();
                                
                                }
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                                ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                            }
                            else {
                            	if(infoResultado.getColumnType(i) == OracleTypes.TIMESTAMP) {
                            		
                            		if(datos.getObject(i) == null) {
                            			registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            		}else {
                            			java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(datos.getObject(i).toString());
                            			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));
                            			
                            			long tsTime2 = ts2.getTime();
                                		java.time.LocalDateTime momento = ts2.toLocalDateTime();
                                		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(momento);
                                		registro.put(infoResultado.getColumnName(i).toLowerCase(), timestamp);
                                        
                            		}
                            		
                            		
                            	}else {
                            		registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            	}
                                
                                
                                ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                            }

                        }
                        respuesta.add(registro);
                        objetoSalida.setOrden(ordenamiento);
                    }

                    objetoSalida.setRespuesta(respuesta);
                    
                }                
                catch(Exception e){
                	e.printStackTrace();
                    objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    objetoSalida.setMsgError(callableStatement.getString("p_msjerror"));
                    ErrorClass.getMessage(objetoSalida,GenericoDAO.class);                    
                }
            }
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            if(objetoSalida.getRespuesta() != null) {
            	//System.out.println(objetoSalida.getRespuesta().size());               
            	if (objetoSalida.getRespuesta().size() == 0) {
                	objetoSalida.setMsgError("No se encontraron datos en la consulta");
                }
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString());
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida ejecutarProcedure(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    if (parametro.getTipoDato() == OracleTypes.CLOB) {
                        Clob clob = con.createClob();
                        clob.setString(1, parametro.getValor().toString());
                        callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                    } else {
                    	System.out.println("Nombre " + parametro.getNombre() + " Valor " + parametro.getValor());
                        callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                    }
                }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
            }

            callableStatement.setObject("p_Usuario", sentencia.getUsuario());
            callableStatement.registerOutParameter("p_resultado", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("p_cod_error", OracleTypes.INTEGER);
            callableStatement.registerOutParameter("p_msg_error", OracleTypes.VARCHAR);
            callableStatement.execute();
            objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_cod_error")));
            objetoSalida.setMsgError(callableStatement.getString("p_msg_error"));
                
            if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {

                try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_resultado"))){
                    ResultSetMetaData infoResultado = datos.getMetaData();
                    Integer columnas = infoResultado.getColumnCount();
                    List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();

                    while (datos.next()) {
                    	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(columnas);
                        for (Integer i = 1; i <= columnas; ++i) {
                        	if (infoResultado.getColumnType(i) == OracleTypes.BLOB) {
                                Blob clob = datos.getBlob(i);
                                String theString = "";
                                InputStream blob = null;
                                if(clob != null){
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    StringWriter writer = new StringWriter();
                                    IOUtils.copy(blob, writer, "UTF-8");
                                    theString = writer.toString();
                                
                                }
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                            }
                            else {
                            	if(infoResultado.getColumnType(i) == OracleTypes.TIMESTAMP) {
                            		
                            		if(datos.getObject(i) == null) {
                            			registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            		}else {
                            			java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(datos.getObject(i).toString());
                            			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));
                            			
                            			long tsTime2 = ts2.getTime();
                                		java.time.LocalDateTime momento = ts2.toLocalDateTime();
                                		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(momento);
                                		registro.put(infoResultado.getColumnName(i).toLowerCase(), timestamp);
                                        
                            		}
                            		
                            		
                            	}else {
                            		registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            	}
                                
                                
                            }


                        }
                        respuesta.add(registro);
                    }

                    objetoSalida.setRespuesta(respuesta);
                    
                }                
                catch(Exception e){
                	e.printStackTrace();
                    objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    objetoSalida.setMsgError(callableStatement.getString("p_msg_error") + " " + sentencia.getNombre() );
                    ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
                    
                }
            }
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            if(objetoSalida.getRespuesta() != null) {
            	if (objetoSalida.getRespuesta().size() == 0) {
                	objetoSalida.setMsgError("No se encontraron datos en la consulta");
                }
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString() + " " + sentencia.getNombre() );
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }
    
    /**
     * 
     * @param sentencia
     * @param objetoSalida
     * @return
     * @throws Exception
     */
    public ObjetoSalida ejecutarReporte(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

            Connection con = conectar();

            try {

                CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
                for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                    if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                        if (parametro.getTipoDato() == OracleTypes.BLOB) {
                            Blob blob = con.createBlob();
                            blob.setBytes(1, parametro.getValor().toString().getBytes());
                            callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                        }
                        if (parametro.getTipoDato() == OracleTypes.CLOB) {
                            Clob clob = con.createClob();
                            clob.setString(1, parametro.getValor().toString());
                            callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                        } else {
                            callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                        }
                    }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                        callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                    }
                }

                callableStatement.setInt("p_IdUsuario", sentencia.getIdUsuario());
                callableStatement.registerOutParameter("p_resultado", OracleTypes.CURSOR);
                callableStatement.registerOutParameter("p_codError", OracleTypes.INTEGER);
                callableStatement.registerOutParameter("p_msjError", OracleTypes.VARCHAR);

                callableStatement.execute();

                objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_codError")));
                objetoSalida.setMsgError(callableStatement.getString("p_msjError"));
                if (callableStatement.getString("P_A103NOMBREPLANTILLA")!= null){
                    objetoSalida.setNombrePlantilla(callableStatement.getString("P_A103NOMBREPLANTILLA"));
                }
                if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {

                    try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_resultado"))){
                        ResultSetMetaData infoResultado = datos.getMetaData();
                        Integer columnas = infoResultado.getColumnCount();
                        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();

                        while (datos.next()) {
                        	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(columnas);
                            for (Integer i = 1; i <= columnas; ++i) {
                            	if (infoResultado.getColumnType(i) == OracleTypes.BLOB) {
                                    Blob clob = datos.getBlob(i);
                                    String theString = "";
                                    InputStream blob = null;
                                    if(clob != null){
                                        blob = clob.getBinaryStream(1, (int) clob.length()); 
                                        blob = clob.getBinaryStream(1, (int) clob.length()); 
                                        StringWriter writer = new StringWriter();
                                        IOUtils.copy(blob, writer, "UTF-8");
                                        theString = writer.toString();
                                    
                                    }
                                    registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                                }
                                else {
                                	if(infoResultado.getColumnType(i) == OracleTypes.TIMESTAMP) {
                                		
                                		if(datos.getObject(i) == null) {
                                			registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                                		}else {
                                					                                            
                                			java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(datos.getObject(i).toString());
                                			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));
                                			long tsTime2 = ts2.getTime();
                                    		java.time.LocalDateTime momento = ts2.toLocalDateTime();
                                    		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(momento);
                                    		registro.put(infoResultado.getColumnName(i).toLowerCase(), timestamp);
                                            
                                		}
                                		
                                		
                                	}else {
                                		registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                                	}
                                    
                                    
                                }

                            }
                            respuesta.add(registro);
                        }

                        objetoSalida.setRespuesta(respuesta);

                    }catch(Exception e){
                    	e.printStackTrace();
                        objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        objetoSalida.setMsgError(callableStatement.getString("p_msjError"));
                        ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
                        
                    }
                }
                ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            } catch (Exception e) {
            	e.printStackTrace();
                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.toString());
                ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            } finally {
                ConexionDS.desconectar(con);    
                //Conexion.desconectar(con);
            }

            return objetoSalida;
        }
    public ObjetoSalida ejecutarSentenciaSQL(String sentencia) throws Exception {
    	Connection con = conectar();
    	ObjetoSalida objetoSalida = new ObjetoSalida();
    	try {
    		Statement stm = con.createStatement();
    		if(sentencia.contains("select") || sentencia.contains("SELECT")) {
    			
    			ResultSet datos = stm.executeQuery(sentencia);
                try{
                	
                    ResultSetMetaData infoResultado = datos.getMetaData();
                    Integer columnas = infoResultado.getColumnCount();
                    List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
                    while (datos.next()) {
                    	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(columnas);
                        HashMap<String, Integer> ordenamiento = new HashMap<String, Integer>(columnas);
                        for (Integer i = 1; i <= columnas; ++i) {
                        	if (infoResultado.getColumnType(i) == OracleTypes.BLOB) {
                                Blob clob = datos.getBlob(i);
                                String theString = "";
                                InputStream blob = null;
                                if(clob != null){
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    blob = clob.getBinaryStream(1, (int) clob.length()); 
                                    StringWriter writer = new StringWriter();
                                    IOUtils.copy(blob, writer, "UTF-8");
                                    theString = writer.toString();
                                
                                }
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                                ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                        		
                            }
                            else {
                            	if(infoResultado.getColumnType(i) == OracleTypes.TIMESTAMP) {
                            		
                            		if(datos.getObject(i) == null) {
                            			registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            			
                            		}else {
                            					                                            
                            			java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(datos.getObject(i).toString());
                            			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));
                            			long tsTime2 = ts2.getTime();
                                		java.time.LocalDateTime momento = ts2.toLocalDateTime();
                                		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(momento);
                                		
                                		registro.put(infoResultado.getColumnName(i).toLowerCase(), timestamp);
                                		
                            		}
                            		ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                            		
                            	}else {
                            		registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            		ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                            	}
                                
                                
                            }

                        }
                        //String str= DatatypeConverter.printHexBinary(datos.getRowId(1).getBytes());
                    	
                        //registro.put("rowid",str);
                        respuesta.add(registro);
                        objetoSalida.setOrden(ordenamiento);
                    }
                    
                    objetoSalida.setRespuesta(respuesta);

                }catch(Exception e){
                	e.printStackTrace();
                    objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    objetoSalida.setMsgError("No se encontraron Datos");
                    ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
                    
                }

    		}
    		else {
    			Boolean datos = stm.execute(sentencia);
    			if(!datos) {
    				LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(1);
    				registro.put("codigo", 0);
    				List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
    				respuesta.add(registro);
    				objetoSalida.setRespuesta(respuesta);
    				objetoSalida.setCodError(CodError.OPERACION_CORRECTA);
    	            objetoSalida.setMsgError("Operacion exitosa");
    			}else {
    				objetoSalida.setCodError(CodError.ERROR_INTERNO);
    	            objetoSalida.setMsgError("Operacion Incorrecta");
    			}
    		}
    		

    	}catch (Exception e) {
    		e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString());
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);    
            //Conexion.desconectar(con);
        }

    	
    	return objetoSalida;
    }
    
    public ObjetoSalida ejecutarProcedureSinSalida(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    if (parametro.getTipoDato() == OracleTypes.CLOB) {
                        Clob clob = con.createClob();
                        clob.setString(1, parametro.getValor().toString());
                        callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                    } else {
                        callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                    }
                }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
            }

            callableStatement.execute();
            objetoSalida.setCodError(CodError.OPERACION_CORRECTA);
            objetoSalida.setMsgError("Operacion Ejecutada con exito");
                        
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString() + " " + sentencia.getNombre() );
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }
    
    protected java.sql.Date obtenerFecha(java.util.Date fecha){
    	java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));		
    	return (fecha == null) ? null : new java.sql.Date(fecha.getTime());
    }
    
    protected ObjetoSalida ejecutarFuncion(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception{
        Connection con = conectar();
        String salida = "valor";
        int tipoParametro = 0;
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQLFunction(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    if (parametro.getTipoDato() == OracleTypes.CLOB) {
                        Clob clob = con.createClob();
                        clob.setString(1, parametro.getValor().toString());
                        callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                    } else {
                        callableStatement.setObject(parametro.getNumero(), parametro.getValor(), parametro.getTipoDato());
                    }
                }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNumero(), parametro.getTipoDato());
                    //salida = parametro.getNombre();
                    //tipoParametro = parametro.getTipoDato();
                }
            }
            
            //callableStatement.registerOutParameter(1,tipoParametro);
            callableStatement.execute();
            Object salidaS = callableStatement.getObject(1);
            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
            LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
            registro.put(salida,salidaS);
            respuesta.add(registro);
            objetoSalida.setRespuesta(respuesta);
            objetoSalida.setCodError(CodError.OPERACION_CORRECTA);
            objetoSalida.setMsgError("Operacion Ejecutada con exito");
                        
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString() + " " + sentencia.getNombre() );
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }
    
    
    
    
    public ObjetoSalida ejecutarY(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) 
            {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) 
                {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) 
                    {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    if (parametro.getTipoDato() == OracleTypes.CLOB) 
                    {
                        Clob clob = con.createClob();
                        clob.setString(1, parametro.getValor().toString());
                        callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                    } 
                    else {
                    	callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());                   
                    }
                }
                else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
                
            }
            callableStatement.setObject("p_Usuario", sentencia.getUsuario());
            callableStatement.registerOutParameter("p_resultado", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("p_coderror", OracleTypes.INTEGER);
            callableStatement.registerOutParameter("p_msjerror", OracleTypes.VARCHAR);
            callableStatement.execute();
            objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_coderror")));
            objetoSalida.setMsgError(callableStatement.getString("p_msjerror"));
            
            
            try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_resultado")))
            {
            	ResultSetMetaData infoResultado = datos.getMetaData();
                Integer columnas = infoResultado.getColumnCount();
                List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
                	
                while (datos.next()) 
                {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(columnas);
                    HashMap<String, Integer> ordenamiento = new HashMap<String, Integer>(columnas);
                    
                    for (Integer i = 1; i <= columnas; ++i) 
                    {
                        if (infoResultado.getColumnType(i) == OracleTypes.BLOB) 
                        {
                            Blob clob = datos.getBlob(i);
                            String theString = "";
                            InputStream blob = null;
                            if(clob != null){
                                blob = clob.getBinaryStream(1, (int) clob.length()); 
                                blob = clob.getBinaryStream(1, (int) clob.length()); 
                                StringWriter writer = new StringWriter();
                                IOUtils.copy(blob, writer, "UTF-8");
                                theString = writer.toString();
                            
                            }
                            registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                            ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                        }
                        else {
                        	if(infoResultado.getColumnType(i) == OracleTypes.TIMESTAMP) {
                        		
                        		if(datos.getObject(i) == null) {
                        			registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                        		}else {
                        			java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(datos.getObject(i).toString());
                        			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));
                        			
                        			long tsTime2 = ts2.getTime();
                            		java.time.LocalDateTime momento = ts2.toLocalDateTime();
                            		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(momento);
                            		registro.put(infoResultado.getColumnName(i).toLowerCase(), timestamp);
                                    
                        		}
                        		
                        		
                        	}else {
                        		registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                        	}
                            
                            
                            ordenamiento.put(infoResultado.getColumnName(i).toLowerCase(), i);
                        }

                    }
                    respuesta.add(registro);
                    objetoSalida.setOrden(ordenamiento);
                }

                objetoSalida.setRespuesta(respuesta);
                
            }                
            catch(Exception e)
            {
            	e.printStackTrace();
                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(callableStatement.getString("p_msjerror"));
                ErrorClass.getMessage(objetoSalida,GenericoDAO.class);                    
            }

            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            if(objetoSalida.getRespuesta() != null) 
            {
            	if (objetoSalida.getRespuesta().size() == 0) 
            	{
                	objetoSalida.setMsgError("No se encontraron datos en la consulta");
                }
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString());
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }

    public Double convertirBigDecimalaDouble(BigDecimal valor) {
    	return (valor ==  null) ? null : valor.doubleValue();
    }
    
}
