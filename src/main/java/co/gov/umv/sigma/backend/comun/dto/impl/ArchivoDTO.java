package co.gov.umv.sigma.backend.comun.dto.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jose4j.lang.JoseException;

import com.google.gson.Gson;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import co.gov.umv.sigma.backend.comun.cbo.ArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.DocumentoArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.comun.config.ArchivoConector;
import co.gov.umv.sigma.backend.comun.dao.ArchivoDAO;
import co.gov.umv.sigma.backend.comun.dto.IArchivoDTO;
import co.gov.umv.sigma.backend.comun.entidad.TabArchivo;
import co.gov.umv.sigma.backend.comun.entidad.TabDocumento;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVial;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialDocu;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialDocuDTO;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;
import co.gov.umv.sigma.backend.workflow.dao.IDocumentoDAO;
import co.gov.umv.sigma.backend.workflow.dao.impl.DocumentoDAO;

public class ArchivoDTO implements IArchivoDTO {
	private final static Logger log = Logger.getLogger(ArchivoDTO.class);	
	private String UPLOAD_DIR = "";
	@Override
	public ObjetoSalida insertar(MultipartFormDataInput OE) {

        Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        String Usuario = "";
        String idTipoArchivo = "";
        String descripcion = "";
		try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			idTipoArchivo = (uploadForm.get("idTiposArchivos") == null) ? "" : uploadForm.get("idTiposArchivos").get(0).getBodyAsString();
			descripcion = (uploadForm.get("descripcion") == null) ? "" : uploadForm.get("descripcion").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] tipoArchivo = (idTipoArchivo.equals("")) ? null : idTipoArchivo.split(",");		
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts size: " + inputParts.size());
        System.out.println("inputParts size: " + inputParts.size());
        UPLOAD_DIR = conector.rutaParametricaMantenimientos();
        System.out.println("UP" + UPLOAD_DIR);
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        Integer tamanio = (tipoArchivo ==  null) ? 0 : tipoArchivo.length; 
        log.info("Tamanio " + tamanio) ;
        System.out.println("Tamanio " + tamanio);
        if(inputParts.size() == tamanio) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    ArchivoOE arch = new ArchivoOE();
                    ArchivoDAO modelo = new ArchivoDAO();
                    TabArchivo archivo = new TabArchivo();
                    archivo.setUrlArchivo(fileName);
                    archivo.setIdDocumento(new TabDocumento(idDocumento));
                    archivo.setNombre(fileName);
                    archivo.setIdTipoArchivo((tipoArchivo == null) ? null : Long.parseLong(tipoArchivo[i]));
                    archivo.setDescripcion(descripcion);
                    arch.setArchivo(archivo);
                    arch.setUsuario(Usuario);
                    ObjetoNegocioOE OEE = new ObjetoNegocioOE();
                    OEE.setUrl(app.getProp().getProperty("caliope.archivo.insertar"));
                    OEE.setUsuario(Usuario);
                    String jsonArchivo = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"urlArchivo\":\""+fileName+"\",\"nombre\":\""+fileName+"\",\"registroActivo\":\"SI\",\"idTipoArchivo\":"+archivo.getIdTipoArchivo()+",\"descripcion\":\"" + archivo.getDescripcion() +"\",\"idDocumento\":{\"idDocumento\":"+idDocumento+"}}}";
                    System.out.println("insertar " + jsonArchivo);
                    OEE.setJson(jsonArchivo);
                    os = dto.generarObjetoSalida(OEE);
                    //os = modelo.insertar(arch);
                    
                    Float idArchivo = (!os.esRespuestaOperacionCorrecta()) ? null : Float.parseFloat(os.getRespuesta().get(0).get("id_archivo").toString());
                    Long idArch = (!os.esRespuestaOperacionCorrecta()) ? null : idArchivo.longValue();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String fileNameNew = idMantenimientoVial + "_" + idDocumento + "_" + idArch + "." + extension;
            		
                    if(os.esRespuestaOperacionCorrecta()) {
                    	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                        byte[] bytes = IOUtils.toByteArray(inputStream);
        //
                        File customDir = new File(UPLOAD_DIR + File.separator + idMantenimientoVial);
                        if(!customDir.exists()) {
                        	customDir.mkdirs();
                        }
                        fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
                        archivo.setIdArchivo(idArch);
                        archivo.setUrlArchivo(fileNameNew);
                        archivo.setNombre(fileNameNew);
                        archivo.setIdDocumento(new TabDocumento(idDocumento));
                        archivo.setIdTipoArchivo((tipoArchivo == null) ? null : Long.parseLong(tipoArchivo[i]));
                        archivo.setDescripcion(descripcion);
                        arch.setArchivo(archivo);
                        ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.actualizar"));
                        
                        String jsonArchivoAc = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"idArchivo\":"+idArch+",\"urlArchivo\":\""+idMantenimientoVial+File.separator+fileNameNew+"\",\"idTipoArchivo\":\""+archivo.getIdTipoArchivo()+"\",\"nombre\":\""+fileNameNew+"\",\"registroActivo\":\"SI\",\"idDocumento\":{\"idDocumento\":"+idDocumento+"},\"descripcion\":\"" + archivo.getDescripcion() +"\"}}";
                        System.out.println("Actualizar " + jsonArchivoAc);
                        OEEE.setJson(jsonArchivoAc);
                        OEEE.setUsuario(Usuario);
                        os = dto.generarObjetoSalida(OEEE);
                        
                        //os = modelo.actualizar(arch);
                        if(os.esRespuestaOperacionCorrecta()) {
                        	registro.put("idArchivo", os.getRespuesta().get(0).get("id_archivo"));
                            respuesta.add(registro);
                            osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            
                            osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
          
                        }else {
                        	osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            
                            osFinal.setMsgError("Falla al actualizar"); 
          
                        }
                        
                    }else {
                    	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
        	
        }
        else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError(" Error La cantidad de archivos no corresponde a la cantidad de tipos de archivos");
    
        }
        osFinal.setRespuesta(respuesta);
        
		return osFinal;
	}

	@Override
	public ObjetoSalida actualizar(MultipartFormDataInput OE) {
		Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        String Usuario = "";
		String idArchivos ="";
		String idTiposArchivos = "";
        String descripcion = "";
		try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			idArchivos = (uploadForm.get("idArchivos") == null) ? "" : uploadForm.get("idArchivos").get(0).getBodyAsString();
			idTiposArchivos = (uploadForm.get("idTiposArchivos") == null) ? "" : uploadForm.get("idTiposArchivos").get(0).getBodyAsString();
			descripcion = (uploadForm.get("descripcion") == null) ? "" : uploadForm.get("descripcion").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String[] archivos = idArchivos.split(",");
        String[] tiposarchivos = (idTiposArchivos.equals("")) ? null : idTiposArchivos.split(",");
        
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts tamanio: " + inputParts.size());
        log.info("idArchivos tamanio: " + archivos.length);
        UPLOAD_DIR = conector.rutaParametricaMantenimientos();
        System.out.println("UP " + UPLOAD_DIR);
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        Integer tamanio = (tiposarchivos ==  null) ? 0 : tiposarchivos.length;
        log.info("Tamanio " +tamanio);
        if(inputParts.size() == archivos.length && inputParts.size() == tamanio) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    ArchivoOE arch = new ArchivoOE();
                    ArchivoDAO modelo = new ArchivoDAO();
                    TabArchivo archivo = new TabArchivo();
                    archivo.setIdDocumento(new TabDocumento(idDocumento));
                    //os = modelo.insertar(arch);
                    Long idArchivo = Long.parseLong(archivos[i]);
                    Long idTipoArchivo = Long.parseLong(tiposarchivos[i]);
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String fileNameNew = idMantenimientoVial + "_" + idDocumento + "_" + idArchivo + "." + extension;
            		
                    
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    File customDir = new File(UPLOAD_DIR + File.separator + idMantenimientoVial);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                    Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE);
                    archivo.setIdArchivo(idArchivo);
                    archivo.setIdTipoArchivo(idTipoArchivo);
                    archivo.setUrlArchivo(fileNameNew);
                    archivo.setNombre(fileNameNew);
                    archivo.setDescripcion(descripcion);
                    arch.setArchivo(archivo);
                    arch.setUsuario(Usuario);
                    ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                    OEEE.setUrl(app.getProp().getProperty("caliope.archivo.actualizar"));
                    
                    String jsonArchivoAc = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"idArchivo\":"+idArchivo+",\"urlArchivo\":\""+idMantenimientoVial+File.separator+fileNameNew+"\",\"nombre\":\""+fileNameNew+"\",\"registroActivo\":\"SI\",\"idTipoArchivo\":"+archivo.getIdTipoArchivo()+",\"idDocumento\":{\"idDocumento\":"+idDocumento+"},\"descripcion\":\"" + archivo.getDescripcion() +"\"}}";
                    System.out.println("Actualizar " + jsonArchivoAc);
                    OEEE.setJson(jsonArchivoAc);
                    OEEE.setUsuario(Usuario);
                    os = dto.generarObjetoSalida(OEEE);
                    //os = modelo.actualizar(arch);
                    if(os.esRespuestaOperacionCorrecta()) {
                    	registro.put("idArchivo", os.getRespuesta().get(0).get("id_archivo"));
                        respuesta.add(registro);
                        osFinal.setCodError(CodError.OPERACION_CORRECTA);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
            osFinal.setRespuesta(respuesta);
        
        }else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError("la cantidad de archivos no corresponde a la cantidad de IDs");
    
        }
            
		return osFinal;		
	}

	@Override
	public ObjetoSalida consultarArchivo(DocumentoArchivoOE OE) {
		ArchivoOE OEE = new ArchivoOE();
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();

		ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.consultar"));
        String filtro = "id_documento = " +OE.getIdDocumento();
        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
        OEEE.setJson(jsonArchivoAc);
        OEEE.setUsuario(OE.getUsuario());
        
		/*OEE.setFiltro("id_documento = " +OE.getIdDocumento());
		OEE.setUsuario(OE.getUsuario());
		ArchivoDAO arch = new ArchivoDAO();
		ObjetoSalida os = arch.consultarXFiltro(OEE);*/
        ObjetoSalida os = dto.generarObjetoSalida(OEEE);
        
		return os;
	}

	@Override
	public ObjetoSalida actualizarDocumento(MultipartFormDataInput OE) {
		Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        Long idTipoDocumento = 0L, idTipoEstadoDocumento = 0L;
        String descripcion = "";
        String Usuario = "";
		String idArchivos ="";
        try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			idTipoDocumento = (uploadForm.get("idTipoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoDocumento").get(0).getBodyAsString()); 
			idTipoEstadoDocumento = (uploadForm.get("idTipoEstadoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoEstadoDocumento").get(0).getBodyAsString());
			descripcion = (uploadForm.get("descripcion") == null) ? "" : uploadForm.get("descripcion").get(0).getBodyAsString();
			
			Usuario = (uploadForm.get("usuario") == null) ? "" : uploadForm.get("usuario").get(0).getBodyAsString();
			//idArchivos = (uploadForm.get("idArchivos") == null) ? "" : uploadForm.get("idArchivos").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String[] archivos = idArchivos.split(",");
        
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts tamanio: " + inputParts.size());
        log.info("idArchivos tamanio: " + archivos.length);
        UPLOAD_DIR = (idMantenimientoVial != 0L) ? conector.rutaParametricaMantenimientos() : conector.rutaParametricaDocumento();
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();

        if(inputParts.size() == archivos.length) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    DocumentoOE arch = new DocumentoOE();
                    DocumentoDAO modelo = new DocumentoDAO();
                    TabDocumento documento = new TabDocumento(idDocumento);
                    //os = modelo.insertar(arch);
                    
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    
                    String fileNameNew = (idMantenimientoVial == 0L) ? idDocumento + File.separator + idDocumento + "." + extension : idMantenimientoVial + File.separator + idMantenimientoVial + "_" + idDocumento + "." + extension;
            		
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    String name = (idMantenimientoVial != 0L ) ? UPLOAD_DIR + File.separator + idMantenimientoVial : UPLOAD_DIR + File.separator + idDocumento;
                    File customDir = new File(name);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                    Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE);
                    //documento.setIdArchivo(idArchivo);
                    documento.setIdTipoEstadoDocumento(idTipoEstadoDocumento);
                    documento.setIdTipoDocumento(idTipoDocumento);
                    documento.setUrlArchivo(fileNameNew);
                    Date date = Calendar.getInstance().getTime();  
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                    String strDate = dateFormat.format(date);  
                    
                    documento.setFecha(strDate);
                    documento.setRegistroActivo("SI");
                    log.info("Fecha: " + documento.getFecha());
                    arch.setDocumento(documento);
                    arch.setUsuario(Usuario);
                    Gson gson = new Gson();    
                    String json = gson.toJson(arch);
                    log.info("JSON " + json);
                    ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                    OEEE.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
                    OEEE.setJson(json);
                    OEEE.setUsuario(Usuario);
                    
                    //os = modelo.actualizar(arch);
                    os = dto.generarObjetoSalida(OEEE);
                    if(os.esRespuestaOperacionCorrecta()) {
                    	registro.put("idDocumento", os.getRespuesta().get(0).get("id_documento"));
                    	osFinal.setCodError(CodError.OPERACION_CORRECTA);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }else {
                    	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        
                        osFinal.setMsgError("Los datos del Id Documento " + idDocumento + " no se pueden modificar"); 
      
                    }
                    respuesta.add(registro);
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
            osFinal.setRespuesta(respuesta);
        
        }else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError("la cantidad de archivos no corresponde a la cantidad de IDs");
    
        }
            
		return osFinal;		
	}

	@Override
	public ObjetoSalida consultarDocumentoArchivo(DocumentoArchivoOE OE) {
		DocumentoOE OEE = new DocumentoOE();
		OEE.setFiltro("id_documento = " +OE.getIdDocumento());
		OEE.setUsuario(OE.getUsuario());
		IDocumentoDAO arch = new DocumentoDAO();
		ObjetoSalida os = arch.consultarXFiltro(OEE); 
		return os;
	}

	@Override
	public ObjetoSalida insertarDocumento(MultipartFormDataInput OE) {
		// TODO Auto-generated method stub
        Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        //Long idDocumento = 0L;
        String Usuario = "";
        Long idTipoDocumento = 0L, idTipoEstadoDocumento = 0L;
        String descripcion = "";
		
        try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			//idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			idTipoDocumento = (uploadForm.get("idTipoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoDocumento").get(0).getBodyAsString()); 
			idTipoEstadoDocumento = (uploadForm.get("idTipoEstadoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoEstadoDocumento").get(0).getBodyAsString());
			descripcion = (uploadForm.get("descripcion") == null) ? "" : uploadForm.get("descripcion").get(0).getBodyAsString();
			Usuario = (uploadForm.get("usuario") == null) ? "" : uploadForm.get("usuario").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts size: " + inputParts.size());
        UPLOAD_DIR = (idMantenimientoVial != 0L) ? conector.rutaParametricaMantenimientos() :conector.rutaParametricaDocumentos();
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();

        for (InputPart inputPart : inputParts) {
        	ObjetoSalida os = new ObjetoSalida();
            
        	try {
            	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = conector.getFileName(header);
                fileNames.add(fileName);
                //System.out.println("File Name: " + fileName);
                DocumentoOE arch = new DocumentoOE();
                DocumentoDAO modelo = new DocumentoDAO();
                TabDocumento archivo = new TabDocumento();
                Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                String strDate = dateFormat.format(date);  
                
                archivo.setFecha(strDate);
                archivo.setUrlArchivo(fileName);
                archivo.setIdTipoDocumento(idTipoDocumento);
                archivo.setIdTipoEstadoDocumento(idTipoEstadoDocumento);
                archivo.setDescripcion(descripcion);
                archivo.setRegistroActivo("SI");
                arch.setDocumento(archivo);
                arch.setUsuario(Usuario);
                
                Gson gson = new Gson();    
                String json = gson.toJson(arch);
                ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                OEEE.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
                System.out.println("JSON" +json);
                OEEE.setJson(json);
                OEEE.setUsuario(Usuario);
                //os = modelo.insertar(arch);
                os = dto.generarObjetoSalida(OEEE);
                Double idDoc = (!os.esRespuestaOperacionCorrecta()) ? null : Double.parseDouble(os.getRespuesta().get(0).get("id_documento").toString());
                Long idDocumento = idDoc.longValue();
                
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                String fileNameNew = (idMantenimientoVial != 0L ) ? idMantenimientoVial + File.separator + idMantenimientoVial + "_" + idDocumento + "." + extension : idDocumento + "." + extension;
                log.info(" ID DOCUMENTO " + idDocumento);
                log.info("Respuesta " + os.getRespuesta());
        		if(os.esRespuestaOperacionCorrecta()) {
                	
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    String name = (idMantenimientoVial != 0L) ? UPLOAD_DIR + File.separator + idMantenimientoVial : UPLOAD_DIR + File.separator + idDocumento; 
                    File customDir = new File(name);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;                    
                    System.out.println(fileName);
                    //Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
                    
                    File archivoS = new File(fileName);
                    FileOutputStream fop = new FileOutputStream(archivoS);

                    fop.write(bytes);
                    fop.flush();
                    fop.close();

                    archivo.setIdDocumento(idDocumento);
                    archivo.setUrlArchivo(fileNameNew);
                    arch.setDocumento(archivo);
                    
                    String jsonAct = gson.toJson(arch);
                    System.out.println("JSON " +jsonAct);
                    OEEE.setJson(jsonAct);
                    os = dto.generarObjetoSalida(OEEE);
                    
                    ObjetoSalida osMvDoc = new ObjetoSalida();
                    if(idMantenimientoVial != 0 && os.esRespuestaOperacionCorrecta()) {
                    	MantenimientoVialDocuOE mvDoc = new MantenimientoVialDocuOE();
                    	TabMantenimientoVialDocu doc = new TabMantenimientoVialDocu();
                    	doc.setIdMantenimientoVial(new TabMantenimientoVial(idMantenimientoVial));
                    	doc.setIdDocumento(idDocumento);
                    	doc.setRegistroActivo("SI");
                    	mvDoc.setMantenimientoVialDocu(doc);
                    	mvDoc.setUsuario(Usuario);
                    	MantenimientoVialDocuDTO dtoDocu = new MantenimientoVialDocuDTO();
                    	osMvDoc = dtoDocu.insertar(mvDoc);
                    	
                    	System.out.println(osMvDoc.getRespuesta());
                    	if(os.esRespuestaOperacionCorrecta()) {
                        	registro.put("idDocumento", idDocumento);
                            registro.put("idMantenimientoVialDocu",osMvDoc.getRespuesta().get(0).get("id_mantenimiento_vial_docu"));
                        	respuesta.add(registro);
                            osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError());
                    	}else {
                    		System.out.println("Fallo al actualizar documento");
                    	} 
      
                    }else {
	                    if(os.esRespuestaOperacionCorrecta()) {
	                    	registro.put("idDocumento", idDocumento);
	                        respuesta.add(registro);
	                        osFinal.setCodError(CodError.OPERACION_CORRECTA);
	                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError());
	                	}else {
	                		System.out.println("Fallo al actualizar documento");
	                	} 
                    }
  
                    
                }else {
                	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    
                    osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
  
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                osFinal.setCodError(CodError.ERROR_INTERNO);
                osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                
            }
        }
        osFinal.setRespuesta(respuesta);
        
		return osFinal;

	}

	@Override
	public ObjetoSalida EliminarArchivo(DocumentoArchivoOE OE) {
		ArchivoOE OEE = new ArchivoOE();
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();

		ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.eliminar"));
        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"archivo\":{\"idArchivo\":"+OE.getIdArchivo()+"}}";
        OEEE.setJson(jsonArchivoAc);
        OEEE.setUsuario(OE.getUsuario());
        
		/*OEE.setFiltro("id_documento = " +OE.getIdDocumento());
		OEE.setUsuario(OE.getUsuario());
		ArchivoDAO arch = new ArchivoDAO();
		ObjetoSalida os = arch.consultarXFiltro(OEE);*/
        ObjetoSalida os = dto.generarObjetoSalida(OEEE);
        
		return os;
	}

	@Override
	public ObjetoSalida insertarArchivoDocumento(MultipartFormDataInput OE) {

        Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        String idMantenimientosViales = "";
        Long idDocumento = 0L;
        String Usuario = "";
        String idTipoArchivo = "";
		try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			idMantenimientosViales = (uploadForm.get("idMantenimientosViales") == null) ? "" : uploadForm.get("idMantenimientosViales").get(0).getBodyAsString();
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			idTipoArchivo = (uploadForm.get("idTiposArchivos") == null) ? "" : uploadForm.get("idTiposArchivos").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] tipoArchivo = (idTipoArchivo.equals("")) ? null : idTipoArchivo.split(",");		
        String[] idMsVs = (idMantenimientosViales.equals("")) ? null : idMantenimientosViales.split(","); 
		List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts size: " + inputParts.size());
        System.out.println("inputParts size: " + inputParts.size());
        
        UPLOAD_DIR = (idMantenimientoVial != 0 ) ? conector.rutaParametricaMantenimientos() : conector.rutaParametricaDocumentos();
        System.out.println("UP" + UPLOAD_DIR);
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        Integer tamanio = (tipoArchivo ==  null) ? 0 : tipoArchivo.length; 
        log.info("Tamanio " + tamanio) ;
        System.out.println("Tamanio " + tamanio);
        if(inputParts.size() == tamanio ) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    ArchivoOE arch = new ArchivoOE();
                    ArchivoDAO modelo = new ArchivoDAO();
                    TabArchivo archivo = new TabArchivo();
                    archivo.setUrlArchivo(fileName);
                    archivo.setIdDocumento(new TabDocumento(idDocumento));
                    archivo.setNombre(fileName);
                    archivo.setIdTipoArchivo((tipoArchivo == null) ? null : Long.parseLong(tipoArchivo[i]));
                    arch.setArchivo(archivo);
                    arch.setUsuario(Usuario);
                    ObjetoNegocioOE OEE = new ObjetoNegocioOE();
                    OEE.setUrl(app.getProp().getProperty("caliope.archivo.insertar"));
                    OEE.setUsuario(Usuario);
                    String jsonArchivo = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"urlArchivo\":\""+fileName+"\",\"nombre\":\""+fileName+"\",\"registroActivo\":\"SI\",\"idTipoArchivo\":"+archivo.getIdTipoArchivo()+",\"idDocumento\":{\"idDocumento\":"+idDocumento+"}}}";
                    OEE.setJson(jsonArchivo);
                    os = dto.generarObjetoSalida(OEE);
                    //os = modelo.insertar(arch);
                    
                    Float idArchivo = (!os.esRespuestaOperacionCorrecta()) ? null : Float.parseFloat(os.getRespuesta().get(0).get("id_archivo").toString());
                    Long idArch = (!os.esRespuestaOperacionCorrecta()) ? null : idArchivo.longValue();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String fileNameNew =  (idMantenimientoVial != 0) ? idMantenimientoVial + "_" + idDocumento + "_" + idArch + "." + extension: idDocumento + "_" + idArch + "." + extension;
            		
                    if(os.esRespuestaOperacionCorrecta()) {
                    	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                        byte[] bytes = IOUtils.toByteArray(inputStream);
        //
                        String folder = (idMantenimientoVial != 0L) ? UPLOAD_DIR + File.separator + idMantenimientoVial : UPLOAD_DIR + File.separator + idDocumento;
                        
                        File customDir = new File(folder);
                        if(!customDir.exists()) {
                        	customDir.mkdirs();
                        }
                        fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
                        archivo.setIdArchivo(idArch);
                        archivo.setUrlArchivo(fileNameNew);
                        archivo.setNombre(fileNameNew);
                        archivo.setIdDocumento(new TabDocumento(idDocumento));
                        archivo.setIdTipoArchivo((tipoArchivo == null) ? null : Long.parseLong(tipoArchivo[i]));
                        arch.setArchivo(archivo);
                        ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.actualizar"));
                        String URL = (idMantenimientoVial != 0L) ? idMantenimientoVial+File.separator+fileNameNew: idDocumento+File.separator+fileNameNew; 
                        		
                        String jsonArchivoAc = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"idArchivo\":"+idArch+",\"urlArchivo\":\""+URL+"\",\"nombre\":\""+fileNameNew+"\",\"registroActivo\":\"SI\",\"idDocumento\":{\"idDocumento\":"+idDocumento+"}}}";
                        OEEE.setJson(jsonArchivoAc);
                        OEEE.setUsuario(Usuario);
                        os = dto.generarObjetoSalida(OEEE);
                        
                        //os = modelo.actualizar(arch);
                        if(os.esRespuestaOperacionCorrecta()) {
                        	registro.put("idArchivo", os.getRespuesta().get(0).get("id_archivo"));
                            respuesta.add(registro);
                            osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            
                            osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
          
                        }else {
                        	osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            
                            osFinal.setMsgError("Falla al actualizar"); 
          
                        }
                        
                    }else {
                    	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
        	
        }
        else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError(" Error La cantidad de archivos no corresponde a la cantidad de tipos de archivos");
    
        }
        osFinal.setRespuesta(respuesta);
        
		return osFinal;
	}

	@Override
	public ObjetoSalida actualizarArchivoDocumento(MultipartFormDataInput OE) {
		Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        String Usuario = "";
		String idArchivos ="";
		String idTiposArchivos = "";
        try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			idArchivos = (uploadForm.get("idArchivos") == null) ? "" : uploadForm.get("idArchivos").get(0).getBodyAsString();
			idTiposArchivos = (uploadForm.get("idTiposArchivos") == null) ? "" : uploadForm.get("idTiposArchivos").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String[] archivos = idArchivos.split(",");
        String[] tiposarchivos = (idTiposArchivos.equals("")) ? null : idTiposArchivos.split(",");
        
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts tamanio: " + inputParts.size());
        log.info("idArchivos tamanio: " + archivos.length);
        UPLOAD_DIR = (idMantenimientoVial != 0  ) ? conector.rutaParametricaMantenimientos() : conector.rutaParametricaDocumentos();
        System.out.println("UP" + UPLOAD_DIR);
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        Integer tamanio = (tiposarchivos ==  null) ? 0 : tiposarchivos.length;
        log.info("Tamanio " +tamanio);
        if(inputParts.size() == archivos.length && inputParts.size() == tamanio) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    ArchivoOE arch = new ArchivoOE();
                    ArchivoDAO modelo = new ArchivoDAO();
                    TabArchivo archivo = new TabArchivo();
                    archivo.setIdDocumento(new TabDocumento(idDocumento));
                    //os = modelo.insertar(arch);
                    Long idArchivo = Long.parseLong(archivos[i]);
                    Long idTipoArchivo = Long.parseLong(tiposarchivos[i]);
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String fileNameNew =  (idMantenimientoVial != 0) ? idMantenimientoVial + "_" + idDocumento + "_" + idArchivo + "." + extension: idDocumento + "_" + idArchivo + "." + extension;
            		
                    
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    String folder = (idMantenimientoVial != 0L) ? UPLOAD_DIR + File.separator + idMantenimientoVial : UPLOAD_DIR + File.separator + idDocumento;	
                    File customDir = new File(folder);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                    Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE);
                    archivo.setIdArchivo(idArchivo);
                    archivo.setIdTipoArchivo(idTipoArchivo);
                    archivo.setUrlArchivo(fileNameNew);
                    archivo.setNombre(fileNameNew);
                    arch.setArchivo(archivo);
                    arch.setUsuario(Usuario);
                    ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                    OEEE.setUrl(app.getProp().getProperty("caliope.archivo.actualizar"));
                    String URL = (idMantenimientoVial != 0L) ? idMantenimientoVial+File.separator+fileNameNew: idDocumento+File.separator+fileNameNew; 
            		
                    String jsonArchivoAc = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"idArchivo\":"+idArchivo+",\"urlArchivo\":\""+URL+"\",\"nombre\":\""+fileNameNew+"\",\"registroActivo\":\"SI\",\"idDocumento\":{\"idDocumento\":"+idDocumento+"}}}";
                    
                    OEEE.setJson(jsonArchivoAc);
                    OEEE.setUsuario(Usuario);
                    os = dto.generarObjetoSalida(OEEE);
                    //os = modelo.actualizar(arch);
                    if(os.esRespuestaOperacionCorrecta()) {
                    	registro.put("idArchivo", os.getRespuesta().get(0).get("id_archivo"));
                        respuesta.add(registro);
                        osFinal.setCodError(CodError.OPERACION_CORRECTA);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
            osFinal.setRespuesta(respuesta);
        
        }else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError("la cantidad de archivos no corresponde a la cantidad de IDs");
    
        }
            
		return osFinal;		
	}

	@Override
	public ObjetoSalida insertarDocumentoCal(MultipartFormDataInput OE) {
        Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        //Long idDocumento = 0L;
        String Usuario = "";
        Long idTipoDocumento = 0L, idTipoEstadoDocumento = 0L;
        String descripcion = "";
		
        try {
			//idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			//idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			idTipoDocumento = (uploadForm.get("idTipoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoDocumento").get(0).getBodyAsString()); 
			idTipoEstadoDocumento = (uploadForm.get("idTipoEstadoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoEstadoDocumento").get(0).getBodyAsString());
			descripcion = (uploadForm.get("descripcion") == null) ? "" : uploadForm.get("descripcion").get(0).getBodyAsString();
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts size: " + inputParts.size());
        UPLOAD_DIR = conector.rutaParametricaDocumentos();
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();

        for (InputPart inputPart : inputParts) {
        	ObjetoSalida os = new ObjetoSalida();
            
        	try {
            	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = conector.getFileName(header);
                fileNames.add(fileName);
                //System.out.println("File Name: " + fileName);
                DocumentoOE arch = new DocumentoOE();
                DocumentoDAO modelo = new DocumentoDAO();
                TabDocumento archivo = new TabDocumento();
                Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                String strDate = dateFormat.format(date);  
                

                archivo.setFecha(strDate);
                archivo.setUrlArchivo(fileName);
                archivo.setIdTipoDocumento(idTipoDocumento);
                archivo.setIdTipoEstadoDocumento(idTipoEstadoDocumento);
                archivo.setDescripcion(descripcion);
                archivo.setRegistroActivo("SI");
                arch.setDocumento(archivo);
                arch.setUsuario(Usuario);
                
                Gson gson = new Gson();    
                String json = gson.toJson(arch);
                ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                OEEE.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
                OEEE.setJson(json);
                OEEE.setUsuario(Usuario);
                //os = modelo.insertar(arch);
                os = dto.generarObjetoSalida(OEEE);
                Double idDocumento = (!os.esRespuestaOperacionCorrecta()) ? null : Double.parseDouble(os.getRespuesta().get(0).get("id_documento").toString());
                Long idDoc = idDocumento.longValue();
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                String fileNameNew = (idMantenimientoVial != 0L ) ? idMantenimientoVial + "_" + idDoc + "." + extension : idDoc + "." + extension;
                log.info(" ID DOCUMENTO " + idDocumento);
                log.info("Respuesta " + os.getRespuesta());
        		if(os.esRespuestaOperacionCorrecta()) {
                	
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    File customDir = new File(UPLOAD_DIR + File.separator + idDocumento);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                    Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
                    
                    archivo.setUrlArchivo(idDocumento + File.separator +fileNameNew);
                    archivo.setIdDocumento(idDoc);
                    arch.setDocumento(archivo);
                    String json1 = gson.toJson(arch);
                    ObjetoNegocioOE OEEE1 = new ObjetoNegocioOE();
                    OEEE.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
                    OEEE.setJson(json1);
                    OEEE.setUsuario(Usuario);
                    //os = modelo.insertar(arch);
                    os = dto.generarObjetoSalida(OEEE);

                    //os = modelo.actualizar(arch);
                    if(os.esRespuestaOperacionCorrecta()) {
                    	registro.put("idDocumento", os.getRespuesta().get(0).get("id_documento"));
                    	osFinal.setCodError(CodError.OPERACION_CORRECTA);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError());
                        respuesta.add(registro);
                    }
                    
                     
  
                }else {
                	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    
                    osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
  
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                osFinal.setCodError(CodError.ERROR_INTERNO);
                osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                
            }
        }
        osFinal.setRespuesta(respuesta);
        
		return osFinal;
	}

	@Override
	public ObjetoSalida actualizarDocumentoCal(MultipartFormDataInput OE) {
		Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        Long idTipoDocumento = 0L, idTipoEstadoDocumento = 0L;
        String descripcion = "";
        String Usuario = "";
		String idArchivos ="";
        try {
			//idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			idTipoDocumento = (uploadForm.get("idTipoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoDocumento").get(0).getBodyAsString()); 
			idTipoEstadoDocumento = (uploadForm.get("idTipoEstadoDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idTipoEstadoDocumento").get(0).getBodyAsString());
			descripcion = (uploadForm.get("descripcion") == null) ? "" : uploadForm.get("descripcion").get(0).getBodyAsString();
			
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			//idArchivos = (uploadForm.get("idArchivos") == null) ? "" : uploadForm.get("idArchivos").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String[] archivos = idArchivos.split(",");
        
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts tamanio: " + inputParts.size());
        log.info("idArchivos tamanio: " + archivos.length);
        UPLOAD_DIR = (idMantenimientoVial != 0L) ? conector.rutaParametrica() : conector.rutaParametricaDocumento();
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();

        if(inputParts.size() == archivos.length) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    DocumentoOE arch = new DocumentoOE();
                    DocumentoDAO modelo = new DocumentoDAO();
                    TabDocumento documento = new TabDocumento(idDocumento);
                    //os = modelo.insertar(arch);
                    
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    
                    String fileNameNew = (idMantenimientoVial == 0L) ? idDocumento + "." + extension : idMantenimientoVial + "_" + idDocumento + "." + extension;
            		
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    String name = (idMantenimientoVial != 0L ) ? UPLOAD_DIR + File.separator + idMantenimientoVial : UPLOAD_DIR + File.separator + idDocumento;
                    System.out.println(name);
                    File customDir = new File(name);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                    Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE);
                    //documento.setIdArchivo(idArchivo);
                    documento.setIdTipoEstadoDocumento(idTipoEstadoDocumento);
                    documento.setIdTipoDocumento(idTipoDocumento);
                    documento.setUrlArchivo(fileNameNew);
                    documento.setRegistroActivo("SI");
                    
                    Date date = Calendar.getInstance().getTime();  
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                    String strDate = dateFormat.format(date);  
                    
                    documento.setFecha(strDate);
                    documento.setIdDocumento(idDocumento);
                    log.info("Fecha: " + documento.getFecha());
                    arch.setDocumento(documento);
                    arch.setUsuario(Usuario);
                    Gson gson = new Gson();    
                    String json = gson.toJson(arch);
                    log.info("JSON " + json);
                    ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                    OEEE.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
                    OEEE.setJson(json);
                    OEEE.setUsuario(Usuario);
                    
                    //os = modelo.actualizar(arch);
                    os = dto.generarObjetoSalida(OEEE);
                    if(os.esRespuestaOperacionCorrecta()) {
                    	registro.put("idDocumento", os.getRespuesta().get(0).get("id_documento"));
                    	osFinal.setCodError(CodError.OPERACION_CORRECTA);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }else {
                    	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        
                        osFinal.setMsgError("Los datos del Id Documento " + idDocumento + " no se pueden modificar"); 
      
                    }
                    respuesta.add(registro);
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
            osFinal.setRespuesta(respuesta);
        
        }else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError("la cantidad de archivos no corresponde a la cantidad de IDs");
    
        }
            
		return osFinal;		
	}

	@Override
	public File consultarArchivoFisico(DocumentoArchivoOE OE) {
		ArchivoOE OEE = new ArchivoOE();
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        ArchivoConector conector = new ArchivoConector();
        UPLOAD_DIR = (OE.getIdMantenimientoVial() != null) ? conector.rutaParametricaMantenimientos()  : conector.rutaParametricaDocumentos() ; 
		System.out.println(UPLOAD_DIR);
        ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.consultar"));
        String filtro = "id_archivo = " +OE.getIdArchivo();
        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
        System.out.println("JSON " + jsonArchivoAc);
        OEEE.setJson(jsonArchivoAc);
        OEEE.setUsuario(OE.getUsuario());
        File archivo = null;
        
		ObjetoSalida os = dto.generarObjetoSalida(OEEE);
		if (os.esRespuestaOperacionCorrecta()){
            String nombreAdjunto = "";
            for (HashMap<String, Object> item : os.getRespuesta()) {
                nombreAdjunto = item.get("url_archivo").toString();
                System.out.println("Nombre Adjunto " + nombreAdjunto);
            }
            archivo = new File(UPLOAD_DIR + File.separator + nombreAdjunto);
            System.out.println(UPLOAD_DIR + File.separator + nombreAdjunto);
        }
		return archivo;

	}

	@Override
	public ObjetoSalida insertarArchivoCal(MultipartFormDataInput OE) {
		Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        String Usuario = "";
        String idTipoArchivo = "";
		try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			idTipoArchivo = (uploadForm.get("idTiposArchivos") == null) ? "" : uploadForm.get("idTiposArchivos").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] tipoArchivo = (idTipoArchivo.equals("")) ? null : idTipoArchivo.split(",");		
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts size: " + inputParts.size());
        System.out.println("inputParts size: " + inputParts.size());
        UPLOAD_DIR = conector.rutaParametricaArchivos();
        System.out.println("UP" + UPLOAD_DIR);
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        Integer tamanio = (tipoArchivo ==  null) ? 0 : tipoArchivo.length; 
        log.info("Tamanio " + tamanio) ;
        System.out.println("Tamanio " + tamanio);
        if(inputParts.size() == tamanio) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    ArchivoOE arch = new ArchivoOE();
                    TabArchivo archivo = new TabArchivo();
                    archivo.setUrlArchivo(fileName);
                    archivo.setIdDocumento(new TabDocumento(idDocumento));
                    archivo.setNombre(fileName);
                    archivo.setIdTipoArchivo((tipoArchivo == null) ? null : Long.parseLong(tipoArchivo[i]));
                    arch.setArchivo(archivo);
                    arch.setUsuario(Usuario);
                    ObjetoNegocioOE OEE = new ObjetoNegocioOE();
                    OEE.setUrl(app.getProp().getProperty("caliope.archivo.insertar"));
                    OEE.setUsuario(Usuario);
                    String jsonArchivo = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"urlArchivo\":\""+fileName+"\",\"nombre\":\""+fileName+"\",\"registroActivo\":\"SI\",\"idTipoArchivo\":"+archivo.getIdTipoArchivo()+",\"idDocumento\":{\"idDocumento\":null}}}";
                    System.out.println("insertar " + jsonArchivo);
                    OEE.setJson(jsonArchivo);
                    os = dto.generarObjetoSalida(OEE);
                    //os = modelo.insertar(arch);
                    
                    Float idArchivo = (!os.esRespuestaOperacionCorrecta()) ? null : Float.parseFloat(os.getRespuesta().get(0).get("id_archivo").toString());
                    Long idArch = (!os.esRespuestaOperacionCorrecta()) ? null : idArchivo.longValue();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String fileNameNew =  idArch + "." + extension;
            		
                    if(os.esRespuestaOperacionCorrecta()) {
                    	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                        byte[] bytes = IOUtils.toByteArray(inputStream);
        //
                        File customDir = new File(UPLOAD_DIR + File.separator + idArch);
                        if(!customDir.exists()) {
                        	customDir.mkdirs();
                        }
                        fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
                        archivo.setIdArchivo(idArch);
                        archivo.setUrlArchivo(fileNameNew);
                        archivo.setNombre(fileNameNew);
                        archivo.setIdDocumento(new TabDocumento(idDocumento));
                        archivo.setIdTipoArchivo((tipoArchivo == null) ? null : Long.parseLong(tipoArchivo[i]));
                        arch.setArchivo(archivo);
                        ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.actualizar"));
                        
                        String jsonArchivoAc = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"idArchivo\":"+idArch+",\"urlArchivo\":\""+idArch+File.separator+fileNameNew+"\",\"idTipoArchivo\":\""+archivo.getIdTipoArchivo()+"\",\"nombre\":\""+fileNameNew+"\",\"registroActivo\":\"SI\",\"idDocumento\":{\"idDocumento\":null}}}";
                        System.out.println("Actualizar " + jsonArchivoAc);
                        OEEE.setJson(jsonArchivoAc);
                        OEEE.setUsuario(Usuario);
                        os = dto.generarObjetoSalida(OEEE);
                        
                        //os = modelo.actualizar(arch);
                        if(os.esRespuestaOperacionCorrecta()) {
                        	registro.put("idArchivo", os.getRespuesta().get(0).get("id_archivo"));
                            respuesta.add(registro);
                            osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            
                            osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
          
                        }else {
                        	osFinal.setCodError(CodError.OPERACION_CORRECTA);
                            
                            osFinal.setMsgError("Falla al actualizar"); 
          
                        }
                        
                    }else {
                    	osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
        	
        }
        else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError(" Error La cantidad de archivos no corresponde a la cantidad de tipos de archivos");
    
        }
        osFinal.setRespuesta(respuesta);
        
		return osFinal;
		
	}

	@Override
	public ObjetoSalida actualizarArchivoCal(MultipartFormDataInput OE) {
		Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
        Long idMantenimientoVial = 0L;
        Long idDocumento = 0L;
        String Usuario = "";
		String idArchivos ="";
		String idTiposArchivos = "";
        try {
			idMantenimientoVial = (uploadForm.get("idMantenimientoVial") == null) ? 0L : Long.parseLong(uploadForm.get("idMantenimientoVial").get(0).getBodyAsString());
			
			idDocumento = (uploadForm.get("idDocumento") == null) ? 0L : Long.parseLong(uploadForm.get("idDocumento").get(0).getBodyAsString());
			Usuario = (uploadForm.get("Usuario") == null) ? "" : uploadForm.get("Usuario").get(0).getBodyAsString();
			idArchivos = (uploadForm.get("idArchivos") == null) ? "" : uploadForm.get("idArchivos").get(0).getBodyAsString();
			idTiposArchivos = (uploadForm.get("idTiposArchivos") == null) ? "" : uploadForm.get("idTiposArchivos").get(0).getBodyAsString();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String[] archivos = idArchivos.split(",");
        String[] tiposarchivos = (idTiposArchivos.equals("")) ? null : idTiposArchivos.split(",");
        
        List<String> fileNames = new ArrayList<>();
        ArchivoConector conector = new ArchivoConector();
        List<InputPart> inputParts = uploadForm.get("file");
        log.info("inputParts tamanio: " + inputParts.size());
        log.info("idArchivos tamanio: " + archivos.length);
        UPLOAD_DIR = conector.rutaParametricaArchivos();
        System.out.println("UP " + UPLOAD_DIR);
        String fileName = null;
        List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();        
        ObjetoSalida osFinal = new ObjetoSalida();
        String msj = "";
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        Integer tamanio = (tiposarchivos ==  null) ? 0 : tiposarchivos.length;
        log.info("Tamanio " +tamanio);
        if(inputParts.size() == archivos.length && inputParts.size() == tamanio) {
        	int i = 0;
        	for (InputPart inputPart : inputParts) {
            	ObjetoSalida os = new ObjetoSalida();
                
            	try {
                	LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();                
                    MultivaluedMap<String, String> header = inputPart.getHeaders();
                    fileName = conector.getFileName(header);
                    fileNames.add(fileName);
                    log.info("File Name: " + fileName);
                    ArchivoOE arch = new ArchivoOE();
                    ArchivoDAO modelo = new ArchivoDAO();
                    TabArchivo archivo = new TabArchivo();
                    archivo.setIdDocumento(new TabDocumento(idDocumento));
                    //os = modelo.insertar(arch);
                    Long idArchivo = Long.parseLong(archivos[i]);
                    Long idTipoArchivo = Long.parseLong(tiposarchivos[i]);
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String fileNameNew = idArchivo + "." + extension;
            		
                    
                	InputStream inputStream = inputPart.getBody(InputStream.class, null);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
    //
                    File customDir = new File(UPLOAD_DIR + File.separator + idArchivo);
                    if(!customDir.exists()) {
                    	customDir.mkdirs();
                    }
                    fileName = customDir.getAbsolutePath() + File.separator + fileNameNew;
                    Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE);
                    archivo.setIdArchivo(idArchivo);
                    archivo.setIdTipoArchivo(idTipoArchivo);
                    archivo.setUrlArchivo(fileNameNew);
                    archivo.setNombre(fileNameNew);
                    arch.setArchivo(archivo);
                    arch.setUsuario(Usuario);
                    ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
                    OEEE.setUrl(app.getProp().getProperty("caliope.archivo.actualizar"));
                    
                    String jsonArchivoAc = "{\"usuario\":\""+Usuario+"\", \"archivo\":{\"idArchivo\":"+idArchivo+",\"urlArchivo\":\""+idArchivo+File.separator+fileNameNew+"\",\"nombre\":\""+fileNameNew+"\",\"registroActivo\":\"SI\",\"idTipoArchivo\":"+archivo.getIdTipoArchivo()+",\"idDocumento\":{\"idDocumento\":null}}}";
                    System.out.println("Actualizar " + jsonArchivoAc);
                    OEEE.setJson(jsonArchivoAc);
                    OEEE.setUsuario(Usuario);
                    os = dto.generarObjetoSalida(OEEE);
                    //os = modelo.actualizar(arch);
                    if(os.esRespuestaOperacionCorrecta()) {
                    	registro.put("idArchivo", os.getRespuesta().get(0).get("id_archivo"));
                        respuesta.add(registro);
                        osFinal.setCodError(CodError.OPERACION_CORRECTA);
                        
                        osFinal.setMsgError(osFinal.getMsgError() + os.getMsgError()); 
      
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    osFinal.setCodError(CodError.ERROR_INTERNO);
                    osFinal.setMsgError(e.getMessage() + " Error cargando fotos");
                    
                }
            	i++;
            }
            osFinal.setRespuesta(respuesta);
        
        }else {
            osFinal.setCodError(CodError.ERROR_INTERNO);
            osFinal.setMsgError("la cantidad de archivos no corresponde a la cantidad de IDs");
    
        }
            
		return osFinal;		
	}

	@Override
	public File consultarArchivoCal(DocumentoArchivoOE OE) {
		ArchivoOE OEE = new ArchivoOE();
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        ArchivoConector conector = new ArchivoConector();
        UPLOAD_DIR = conector.rutaParametricaArchivos(); 
		System.out.println(UPLOAD_DIR);
        ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
        OEEE.setUrl(app.getProp().getProperty("caliope.archivo.consultar"));
        String filtro = "id_archivo = " +OE.getIdArchivo();
        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
        System.out.println("JSON " + jsonArchivoAc);
        OEEE.setJson(jsonArchivoAc);
        OEEE.setUsuario(OE.getUsuario());
        File archivo = null;
        
		ObjetoSalida os = dto.generarObjetoSalida(OEEE);
		if (os.esRespuestaOperacionCorrecta()){
            String nombreAdjunto = "";
            for (HashMap<String, Object> item : os.getRespuesta()) {
                nombreAdjunto = item.get("url_archivo").toString();
                System.out.println("Nombre Adjunto " + nombreAdjunto);
            }
            archivo = new File(UPLOAD_DIR + File.separator + nombreAdjunto);
        }
		return archivo;
	}

	@Override
	public File consultarDocumentoAdjunto(DocumentoArchivoOE OE) {
		ArchivoOE OEE = new ArchivoOE();
        AppConfig app = new AppConfig();
        ExternoDTO dto = new ExternoDTO();
        ArchivoConector conector = new ArchivoConector();
        UPLOAD_DIR = conector.rutaParametricaMantenimientos(); 
        //UPLOAD_DIR = conector.rutaParametricaArchivos();
        System.out.println(UPLOAD_DIR);
        ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
        OEEE.setUrl(app.getProp().getProperty("caliope.documento.consultar"));
        String filtro = "id_documento = " +OE.getIdDocumento();
        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
        System.out.println("JSON " + jsonArchivoAc);
        OEEE.setJson(jsonArchivoAc);
        OEEE.setUsuario(OE.getUsuario());
        File archivo = null;
        
		ObjetoSalida os = dto.generarObjetoSalida(OEEE);
		if (os.esRespuestaOperacionCorrecta()){
            String nombreAdjunto = "";
            for (HashMap<String, Object> item : os.getRespuesta()) {
                nombreAdjunto = item.get("url_archivo").toString();
                System.out.println("Nombre Adjunto " + nombreAdjunto);
            }
            archivo = new File(UPLOAD_DIR + File.separator+ nombreAdjunto);
            //archivo = new File(nombreAdjunto);
        }
		return archivo;
	}

	
}
