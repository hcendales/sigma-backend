package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.ArchivoConector;
import co.gov.umv.sigma.backend.mejoramiento.cbo.CargueOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICargueDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CargueDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICargueDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.comun.entidad.TabCargueDetalle;

public class CargueDTO implements ICargueDTO, ICrudDTO
{
	private static final String EXTENSION_CSV = ".csv";
	private String UPLOAD_DIR = "";
	private static final String SEPARADOR_CSV = ";"; //separador de columnas en el archivo csv

	@Override
	public ObjetoSalida procesar(CargueOE OE)
	{
		ICargueDAO modelo = new CargueDAO();
		
		if(OE.getIdTipoCargue() == 1 )
			return modelo.procesarCargueTipo1(OE);
		else if(OE.getIdTipoCargue() == 2 )
			return modelo.procesarCargueTipo2(OE);
		else if(OE.getIdTipoCargue() == 4 )
			return modelo.procesarCargueTipo4(OE);
		else
			return null ;
	}
	
	@Override
	public ObjetoSalida validar(CargueOE OE)
	{
		ICargueDAO modelo = new CargueDAO();
		
		ObjetoSalida OS = new ObjetoSalida();
		
		if(OE.getIdTipoCargue() == 1 )
			OS = modelo.validarCargueTipo1(OE);
		else if(OE.getIdTipoCargue() == 2 )
			OS = modelo.validarCargueTipo2(OE);
		else if(OE.getIdTipoCargue() == 4 )
			OS = modelo.validarCargueTipo4(OE);
		
		/*if(OS.getRespuesta() == null)
		{
			OS.setCodError(CodError.PROCESADO_CON_ERRORES);
			
			//la respuesta de este metodo, sera los registrado en tab_cargue_detalle_log
			OE.setFiltro(" id_cargue_detalle IN ( SELECT id_cargue_detalle FROM tab_cargue_detalle WHERE id_cargue = "+OE.getIdCargue()+")");
			ObjetoSalida OElog = modelo.consultarPorFiltro(OE);
			OS.setRespuesta(OElog.getRespuesta());
		}*/

		return OS;
	}
	
	private String cargarArchivoTemporal(InputPart inputPart) throws Exception
	{
		List<String> fileNames = new ArrayList<>();
		String fileName = null;
		ArchivoConector conector = new ArchivoConector();
		
		MultivaluedMap<String, String> header = inputPart.getHeaders();
        fileName = conector.getFileName(header);
        
        if(!fileName.endsWith(EXTENSION_CSV))
        	throw new Exception("El archivo debe ser de tipo CSV.");
        
        fileNames.add(fileName);
        
    	InputStream inputStream = inputPart.getBody(InputStream.class, null);
        byte[] bytes = IOUtils.toByteArray(inputStream);

        File customDir = new File(UPLOAD_DIR);
        fileName = customDir.getAbsolutePath() + File.separator + fileName;
        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
        
        return fileName;
	}
	
	private TabCargueDetalle procesarRenglon(String renglon) 
	{
		String[] splitted = renglon.split(SEPARADOR_CSV);
		TabCargueDetalle resultado = new TabCargueDetalle();
		
		for (int i = 0; i < splitted.length; i++) {
			String valor = splitted[i];
			switch(i) {
				case 0:
					resultado.setCampo1(valor); //pkIDCalzada (tipo1)
					break;
				case 1:
					resultado.setCampo2(valor); //responsable (tipo1)
					break;
				case 2:
					resultado.setCampo3(valor); //origen (tipo1)
					break;
				case 3:
					resultado.setCampo4(valor); //radicado orfeo (tipo1)
					break;
				case 4:
					resultado.setCampo5(valor); //
					break;
				case 5:
					resultado.setCampo6(valor); //
					break;
				case 6:
					resultado.setCampo7(valor); //
					break;
				case 7:
					resultado.setCampo8(valor); //
					break;
				case 8:
					resultado.setCampo9(valor); //
					break;
				case 9:
					resultado.setCampo10(valor); //
					break;
				case 10:
					resultado.setCampo11(valor); // 
					break;
				case 11:
					resultado.setCampo12(valor); //
					break;
				case 12:
					resultado.setCampo13(valor); //
					break;
				case 13:
					resultado.setCampo14(valor); //
					break;
				case 14:
					resultado.setCampo15(valor); //
					break;
				case 15:
					resultado.setCampo16(valor); //
					break;
				case 16:
					resultado.setCampo17(valor); //
					break;
				case 18:
					resultado.setCampo19(valor); //
					break;
				case 19:
					resultado.setCampo20(valor); //
					break;
				default:
					break;
			}
		}
		return resultado;
	}
	
	private int procesarDetalles(File archivo,Long idCargue, String usuario) throws Exception
	{
		ICargueDAO modelo = new CargueDAO();
		int cantidadRegistros = 0;  
		try 
		{	
			FileReader fr = new FileReader(archivo);
			try(BufferedReader br = new BufferedReader(fr)){
				
				//ignora el primer renglon (cabecera) //OJOOOOOOOOOOO
				String renglon = br.readLine(); 
				
				//agrega un nuevo registro (programación) por renglón
	            while ((renglon = br.readLine()) != null)
	            { 
	            	cantidadRegistros++;
	            	ObjetoSalida osDet = modelo.insertaDetalle(procesarRenglon(renglon), idCargue, usuario);
	            	if(!osDet.esRespuestaOperacionCorrecta())
	            	{
	            		throw new Exception(osDet.getMsgError());
	            	}
	            }
	            
			}
            fr.close();
            Files.delete(archivo.toPath());
            
		} catch (Exception e) {
			try {
				Files.delete(archivo.toPath());
			} catch (IOException e1) {
				throw e1 ;
			}
			throw e ;
		}
		
		return cantidadRegistros;
	}
	
	@Override
	public ObjetoSalida insertarArchivo(MultipartFormDataInput OE)
	{	
		ObjetoSalida OS = new ObjetoSalida();
		ICrudDAO modelo = new CargueDAO();
		int cantidadRegistros=0;
		
		try 
		{
			Map<String, List<InputPart>> uploadForm = OE.getFormDataMap();
			CargueOE obj = new CargueOE();
			obj.crearObjetoDesdeFormulario(uploadForm);
			
			OS = modelo.insertar(obj);
			
			if(OS.getCodError().equals(CodError.OPERACION_CORRECTA))
			{
				try
				{
					LinkedHashMap<String, Object> rta = OS.getRespuesta().get(0);
					List list = new ArrayList(rta.values());
					obj.setIdCargue(Long.parseLong(list.get(0).toString() ));
					
				}
				catch(Exception e)
				{
					throw new Exception("No se pudo determinar el id del cargue. Aunque el registro fue creado en la BD");
				}
				
				List<InputPart> inputParts = uploadForm.get("file");
				if(inputParts.size() == 0) throw new Exception("No se envio el arhivo para ser cargado");
				if(inputParts.size() > 1)  throw new Exception("Se envio varios arhivos para ser cargados. Solo puede ser procesado 1 archivo en este cargue.");
				
				for (InputPart inputPart : inputParts) 
		        {
					
	               String filename = cargarArchivoTemporal(inputPart);
	               cantidadRegistros = procesarDetalles(new File(filename), obj.getIdCargue(), obj.getUsuario());
	               
	               break ; //se supone que es uno solo valiar?
		        }
			}
			obj.setCantidadRegistros(cantidadRegistros);
			modelo.actualizar(obj);
			
			OS.setMsgError("Cargue creado en la BD y procesado el archivo");
			
		}
		catch (Exception e)
		{
			OS.setCodError(CodError.ERROR_INTERNO);
			OS.setMsgError(e.getMessage());
			OS.setRespuesta(null);
		}
		
		return OS;
	}
	
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE)
	{
		ICrudDAO modelo = new CargueDAO();
		return modelo.actualizar(OE);
	}
	
	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE)
	{
		ICrudDAO modelo = new CargueDAO();
		return modelo.eliminar(OE);
	}
	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE)
	{
		ICrudDAO modelo = new CargueDAO();
		return modelo.consultarXFiltro(OE);
	}
	
	public ObjetoSalida eliminarDetalles(CargueOE OE)
	{
		ICargueDAO modelo = new CargueDAO();
		return modelo.eliminarDetalles(OE);
	}

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return null;
	}

}
