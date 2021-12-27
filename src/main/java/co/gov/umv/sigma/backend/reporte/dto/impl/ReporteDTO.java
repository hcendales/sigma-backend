package co.gov.umv.sigma.backend.reporte.dto.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.io.FileUtils;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;

import co.gov.umv.sigma.backend.comun.cbo.DocumentoArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.comun.config.ArchivoConector;
import co.gov.umv.sigma.backend.comun.dto.impl.ArchivoDTO;
import co.gov.umv.sigma.backend.comun.entidad.TabDocumento;
import co.gov.umv.sigma.backend.comun.entidad.TabIntervencionNovedad;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialEvento;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionNovedadOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.IntervencionNovedadDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.IntervencionNovedadServicio;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.OtroFactorOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforoanalisisDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforocalzadaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforodatoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.ConsultaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.FallaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialEventoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.OtroFactorDTO;
import co.gov.umv.sigma.backend.produccion.cbo.ProduccionOE;
import co.gov.umv.sigma.backend.produccion.dto.impl.MantenimientoEquipoDTO;
import co.gov.umv.sigma.backend.reporte.cbo.GenerarFichaOE;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;
/*import org.gov.umv.core.domain.entity.TabDocumento;
import org.gov.umv.core.domain.entity.TabMantenimientoVial;
import org.gov.umv.core.domain.entity.TabMantenimientoVialGestion;
import org.gov.umv.core.domain.entity.TabOtroFactor;
import org.gov.umv.core.domain.entity.VisDocumentoArchivo;
import org.gov.umv.core.domain.entity.VisFallas;
import org.gov.umv.core.domain.entity.VisMantenimientoVial;
import org.gov.umv.core.util.generaciondocumentos.actaVisitaTecnica.GeneradorFichaDiagnostico;
*/
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReporteDTO {
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.filesStorage}")                                                                                                                                                                   
	private String filesStorage; 
	
	@NotNull
	@Value("${org.gov.umv.tempFiles}")
	private String tempFiles;
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.logoURL}")                                                                                                                                                                   
	private String logoUrl;   
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.noPicURL}")                                                                                                                                                                   
	private String noPicURL;
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.photosDiagnosticoURL}")                                                                                                                                                           
	private String photoUrlDiagnostico;
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.defaultMap}")
	private String defaultMapa;
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.mapExportURL}")                                                                                                                                                                   
	private String mapExport;
			
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.timeoutConexionServicioMapas}")
	private int timeoutConexionServicioMapas;
	
	@NotNull                                                                                                                                                                                                
	@Value("${org.gov.umv.timeoutLecturaServicioMapas}")
	private int timeoutLecturaServicioMapas;
	
	
	public ReporteDTO() {
		AppConfig config = new AppConfig();
		//logoUrl = config.getProp().getProperty("org.gov.umv.logoURL");
		noPicURL = config.getProp().getProperty("org.gov.umv.noPicURL");
		defaultMapa = config.getProp().getProperty("org.gov.umv.defaultMap");
		photoUrlDiagnostico = config.getProp().getProperty("org.gov.umv.photosDiagnosticoURL");
		mapExport = config.getProp().getProperty("org.gov.umv.mapExportURL");
	}
	
	public File generarFichaWord(GenerarFichaOE OE) {
		File archivoSalida =  null;
		JasperReport report = null;
		//InputStream inputStream = ReporteDTO.class.getResourceAsStream("fichaV9_report.jasper");
		ConsultaDTO fallas = new ConsultaDTO();
		ConsultaOE consultaOE = new ConsultaOE();
		ArchivoConector archivo = new ArchivoConector();
		String fileName = null;
		try {
			
			consultaOE.setIdMantenimientoVialEvento(OE.getIdMantenimientoVialEvento());
			consultaOE.setUsuario(OE.getUsuario());
			consultaOE.setIdMantenimientoVial(OE.getIdMantenimientoVial());
			consultaOE.setIdActividad(OE.getIdActividad());
			ObjetoSalida osFalla = fallas.consultarFallas(consultaOE);
			ExternoDTO ext = new ExternoDTO();
			ObjetoNegocioOE OENegocio = new ObjetoNegocioOE();
			AppConfig config = new AppConfig();
			String filtroReporte = config.getProp().getProperty("org.gov.umv.filtro");
			
			String urlReporte = config.getProp().getProperty("caliope.consultarReporte");
			String json = "{\"usuario\":\""+OE.getUsuario()+"\",\"filtro\":\""+ filtroReporte +"\"}";
			OENegocio.setUrl(urlReporte);
			OENegocio.setJson(json);
			OENegocio.setUsuario(OE.getUsuario());
			
			ObjetoSalida Reporte = ext.generarObjetoSalida(OENegocio);
			
			String plantilla =  "";
			String nuevaPlantilla = config.getProp().getProperty("org.gov.umv.Mantenimientos") + File.separator + OE.getIdMantenimientoVial() +  File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			
			
			
			if(Reporte.esRespuestaOperacionCorrecta()) {
				plantilla = Reporte.getRespuesta().get(0).get("url_archivo").toString();
				//plantilla = "D:\\Instaladores\\Acta_Visita_SIGMA (3) (1).docx";
			}
			
			File customDir = new File(config.getProp().getProperty("org.gov.umv.Mantenimientos")+ File.separator + OE.getIdMantenimientoVial());
			
			if(!customDir.exists()) {
				customDir.mkdirs();
			}
			List<LinkedHashMap<String, Object>> os = new ArrayList<LinkedHashMap<String,Object>>(); 
			
			
			
			//print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(fallasList));
			
			
			AppConfig app = new AppConfig();
	        ExternoDTO Exdto = new ExternoDTO();

			ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
	        OEEE.setUrl(app.getProp().getProperty("caliope.documento.consultar"));
	        String filtro = "id_documento = " +OE.getIdDocumento();
	        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
	        OEEE.setJson(jsonArchivoAc);
	        OEEE.setUsuario(OE.getUsuario());
	        
	        ObjetoSalida osDocumento = Exdto.generarObjetoSalida(OEEE);

			MantenimientoVialEventoOE OEMVE = new MantenimientoVialEventoOE();
			MantenimientoVialEventoDTO dto = new MantenimientoVialEventoDTO();
			OtroFactorOE OEOF = new OtroFactorOE();
			OtroFactorDTO dtoOF = new OtroFactorDTO();
			OEOF.setFiltro("id_mantenimiento_vial_evento=" + OE.getIdMantenimientoVialEvento());
			ObjetoSalida osOtroFactor = dtoOF.consultarXFiltro(OEOF);
			OEMVE.setUsuario(OE.getUsuario());
			OEMVE.setFiltro("id_mantenimiento_vial_evento=" + OE.getIdMantenimientoVialEvento());
			ObjetoSalida osMantenimentoVialEvento = dto.consultarXFiltro(OEMVE);
			ArchivoDTO dtoArchivo = new ArchivoDTO();
			DocumentoArchivoOE OEArchivo = new DocumentoArchivoOE();
			OEArchivo.setUsuario(OE.getUsuario());
			OEArchivo.setIdDocumento(OE.getIdDocumento());
			ObjetoSalida archivos =  dtoArchivo.consultarArchivo(OEArchivo);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			ArrayList<List<LinkedHashMap<String,Object>>> respuestaM = new ArrayList<List<LinkedHashMap<String,Object>>>();
			URL url;
	        LinkedHashMap<String, Object> res = new LinkedHashMap<String, Object>();
	        System.out.println("Otro Factor " + osOtroFactor.getRespuesta());
	        System.out.println("Falla " + osFalla.getRespuesta());
	        
	        List<LinkedHashMap<String,Object>> resp = osMantenimentoVialEvento.getRespuesta();
			
	        HttpURLConnection httpConn = null;                                                                                                                                                                
			String urls[] = obtenerUrlsFotos(archivos);
	        
	        if(archivos.esRespuestaOperacionCorrecta()) {
		        for (int i = 0; i < urls.length; i++) {                                                                                                                                                             
		        	if(i > 2) {                                                                                                                                                                                     
		        		break;                                                                                                                                                                                      
		        	}                                                                                                                                                                                               
					String urlImg = urls[i];                                                                                                                                                                        
					
					resp.get(0).put("url_"+Integer.toString(i+1), urlImg);
					System.out.println("url_"+Integer.toString(i+1) + " - " + urlImg);
				}
	        }
	        String extent = (OE.getExtent() == null) ? "" : OE.getExtent();
	        String bboxSR = (OE.getBboxSR() == null) ? "" : OE.getBboxSR();
	        if (!extent.contains("%26b")) {                                                                                                                                                                     
				extent = extent + "&bboxSR=" + bboxSR + "&size=560,300&format=jpg&f=image";                                                                                                                     
			}    
	        String testStr1 = getURLMapa(extent);
	        System.out.println("Map " +testStr1);
	        String testStr = "";
	        long startTime = System.currentTimeMillis();
			
	        int responseCode = 0; 
	        try {
				url = new URL(mapExport + extent);
				
				httpConn = (HttpURLConnection) url.openConnection();
				httpConn.setConnectTimeout(this.timeoutConexionServicioMapas);
				httpConn.setReadTimeout(this.timeoutLecturaServicioMapas);
				responseCode = httpConn.getResponseCode();
				long endTime = System.currentTimeMillis() - startTime; 
				System.out.println("Tiempo de ejecucion " + endTime);
				System.out.println("URL: " + url.toString());
				System.out.println("Mapa respuesta: " + responseCode);
				httpConn.disconnect();
			} catch (Exception e1) {
				httpConn.disconnect();
				e1.printStackTrace();
				System.out.println("Error " + e1.getMessage());
				long endTime = System.currentTimeMillis() - startTime; 
				System.out.println("Tiempo de ejecucion " + endTime);
				
				testStr = defaultMapa;
				System.out.println("URL MAPA" + testStr);
			}
			if (responseCode == HttpURLConnection.HTTP_OK) {
				testStr = mapExport + extent;
			} else {
				testStr = defaultMapa;
			}
			resp.get(0).put("url_mapa",testStr);
			//*/
			
			if(osOtroFactor.esRespuestaOperacionCorrecta()) {
				Log.info("Otros Factores " + osOtroFactor.getRespuesta().size());
	        	for (int j = 0; j < osOtroFactor.getRespuesta().size(); j++) {
					if(j > 11) {                                                                                                                                                                                     
		        		break;                                                                                                                                                                                      
		        	}
					resp.get(0).put("otrofactor_"+Integer.toString(j+1), osOtroFactor.getRespuesta().get(j).get("descripcion_otro_factor").toString());
				}
			}
			
			TabDocumento documento = new TabDocumento(OE.getIdDocumento());
			Format format =  new SimpleDateFormat("yyyy-MM-dd");
			ObjetoNegocioOE OEDocumento = new ObjetoNegocioOE();
	        DocumentoOE documentoOE = new DocumentoOE();
	        documentoOE.setUsuario(OE.getUsuario());
	        
			if(osDocumento.esRespuestaOperacionCorrecta()) {
				resp.get(0).put("tipo_visita", osDocumento.getRespuesta().get(0).get("nombre_tipo_documento").toString());
				Double idTipoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_documento").toString());
				Double idTipoEstadoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_estado_documento").toString());
				Double numeroVersion = (osDocumento.getRespuesta().get(0).get("numero_version") == null) ? 1 : Double.parseDouble(osDocumento.getRespuesta().get(0).get("numero_version").toString());
				String numero = (osDocumento.getRespuesta().get(0).get("numero") == null) ? null : osDocumento.getRespuesta().get(0).get("numero").toString();
				String clave1 = (osDocumento.getRespuesta().get(0).get("clave_1") == null) ? null : osDocumento.getRespuesta().get(0).get("clave_1").toString();
				String clave2 = (osDocumento.getRespuesta().get(0).get("clave_2") == null) ? null : osDocumento.getRespuesta().get(0).get("clave_2").toString();
				String clave3 = (osDocumento.getRespuesta().get(0).get("clave_3") == null) ? null : osDocumento.getRespuesta().get(0).get("clave_3").toString();
				String descripcion = (osDocumento.getRespuesta().get(0).get("descripcion") == null) ? null : osDocumento.getRespuesta().get(0).get("descripcion").toString();
				String registroActivo = osDocumento.getRespuesta().get(0).get("registro_activo").toString();
				Object fecha1 = (Object)osDocumento.getRespuesta().get(0).get("fecha");  
				
				Long idTipDoc = idTipoDocumento.longValue();
				Long idTipEstDoc = idTipoEstadoDocumento.longValue();
				short numeroVers = numeroVersion.shortValue();
				documento.setIdTipoDocumento(idTipDoc);
				documento.setIdTipoEstadoDocumento(idTipEstDoc);
				documento.setFecha(format.format(fecha1));
				documento.setRegistroActivo(registroActivo);
				documento.setNumero(numero);
				documento.setDescripcion(descripcion);
				documento.setClave1(clave1);
				documento.setClave2(clave2);
				documento.setClave3(clave3);
				documento.setNumeroVersion(numeroVers);
			}
			Long idActividadRegistra = 0L;
			Long idActividadRevisa = 0L;
			int caso = (OE.getIdActividad() == null) ? 0 : OE.getIdActividad().intValue(); 
			switch(caso) {
				case 3:{
					Log.info("Actividad " + osOtroFactor.getRespuesta().size());
					consultaOE.setIdActividad(5L);					
					ObjetoSalida osUsuarioValida = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioValida.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_valida", osUsuarioValida.getRespuesta().get(0).get("nombre").toString());
					}
					idActividadRegistra = OE.getIdActividad(); idActividadRevisa = 4L;
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_registra", osUsuarioRegistra.getRespuesta().get(0).get("nombre").toString());
					}else {
						resp.get(0).put("usuario_registra", resp.get(0).get("nombre_responsable_visita").toString());
						
					}
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_revisa", osUsuarioRevisa.getRespuesta().get(0).get("nombre").toString());
					}
					break;
				}
				case 4:{
					Log.info("Actividad " + osOtroFactor.getRespuesta().size());
					consultaOE.setIdActividad(5L);					
					ObjetoSalida osUsuarioValida = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioValida.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_valida", osUsuarioValida.getRespuesta().get(0).get("nombre").toString());
					}
					idActividadRegistra = 3L; idActividadRevisa = OE.getIdActividad();
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_registra", osUsuarioRegistra.getRespuesta().get(0).get("nombre").toString());
					}else {
						resp.get(0).put("usuario_registra", resp.get(0).get("nombre_responsable_visita").toString());
						
					}
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_revisa", osUsuarioRevisa.getRespuesta().get(0).get("nombre").toString());
					}
					break;
				}	
			
				
			
				case 5:{
					Log.info("Actividad " + osOtroFactor.getRespuesta().size());
					consultaOE.setIdActividad(OE.getIdActividad());					
					ObjetoSalida osUsuarioValida = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioValida.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_valida", osUsuarioValida.getRespuesta().get(0).get("nombre").toString());
					}
					idActividadRegistra = 3L; idActividadRevisa = 4L;
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_registra", osUsuarioRegistra.getRespuesta().get(0).get("nombre").toString());
					}else {
						resp.get(0).put("usuario_registra", resp.get(0).get("nombre_responsable_visita").toString());
						
					}
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_revisa", osUsuarioRevisa.getRespuesta().get(0).get("nombre").toString());
					}
					break;
				}
				/*case 12:{
					idActividadRegistra = 3L; idActividadRevisa = 4L;
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						
					}
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						
					}
				}*/
				case 15:{
					Log.info("Actividad " + osOtroFactor.getRespuesta().size());
					consultaOE.setIdActividad(OE.getIdActividad());					
					ObjetoSalida osUsuarioValida = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioValida.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_valida", osUsuarioValida.getRespuesta().get(0).get("nombre").toString());
					}
					
					idActividadRegistra = 13L; idActividadRevisa = 14L;					
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_registra", osUsuarioRegistra.getRespuesta().get(0).get("nombre").toString());
					}
					
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_revisa", osUsuarioRevisa.getRespuesta().get(0).get("nombre").toString());
					}
					break;
				}
				case 44:{
					consultaOE.setIdActividad(OE.getIdActividad());
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_registra", osUsuarioRegistra.getRespuesta().get(0).get("nombre").toString());
					}
					
					break;
				}
				/*case 16:{
					idActividadRegistra = 3L; idActividadRevisa = 4L;							
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						
					}
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						
					}
				}*/
				case 1540:{								
					consultaOE.setIdActividad(OE.getIdActividad());					
					ObjetoSalida osUsuarioValida = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioValida.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_valida", osUsuarioValida.getRespuesta().get(0).get("nombre").toString());
					}
					
					idActividadRegistra = 1500L; idActividadRevisa = 1521L;
					consultaOE.setIdActividad(idActividadRegistra);
					ObjetoSalida osUsuarioRegistra = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRegistra.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_registra", osUsuarioRegistra.getRespuesta().get(0).get("nombre").toString());
					}
					
					consultaOE.setIdActividad(idActividadRevisa);
					ObjetoSalida osUsuarioRevisa = fallas.consultarUsuarioGestionPrevia(consultaOE);
					if(osUsuarioRevisa.esRespuestaOperacionCorrecta()) {
						resp.get(0).put("usuario_revisa", osUsuarioRevisa.getRespuesta().get(0).get("nombre").toString());
					}
					break;
				}				
				default:{
					System.out.println("La actividad no corresponde ");
				}
			}
			
			if(osFalla.esRespuestaOperacionCorrecta()) {
				List<LinkedHashMap<String, Object>> resps = new ArrayList<LinkedHashMap<String,Object>>();
				for(LinkedHashMap<String, Object> item : osFalla.getRespuesta()) {
					LinkedHashMap<String, Object> a = new LinkedHashMap<String, Object>();
					a.put("consecutivo_falla",((item.get("consecutivo_falla") == null) ? "" : item.get("consecutivo_falla").toString()));
					a.put("unidad_muestreo",((item.get("unidad_muestreo") == null) ? "" : item.get("unidad_muestreo").toString()));
					a.put("descripcion_falla",((item.get("descripcion_falla") == null ) ? "" : item.get("descripcion_falla").toString()));
					a.put("descripcion_severidad",((item.get("descripcion_severidad") == null) ? "" : item.get("descripcion_severidad").toString()));
					a.put("num_losas",((item.get("numero_losas") == null) ? "" : item.get("numero_losas")));
					a.put("longitud",((item.get("longitud") == null ) ? "" : item.get("longitud").toString()));
					a.put("ancho",((item.get("ancho") == null ) ? "" : item.get("ancho").toString()));					
					a.put("area",((item.get("area") == null ) ? "" : item.get("area").toString()));
					a.put("descripcion_intervencion",((item.get("descripcion_intervencion") == null) ? "" : item.get("descripcion_intervencion").toString()));
					
					resps.add(a);
				}
				osFalla.setRespuesta(resps);
				respuestaM.add(osFalla.getRespuesta());
				
			}else {
				
				System.out.println("No tengo fallas");
			}
	        //System.out.println("RES: " + res);
			//respuestaM.add(osOtroFactor.getRespuesta());
			osMantenimentoVialEvento.setRespuestaM(respuestaM);
			
			osMantenimentoVialEvento.setRespuesta(resp);
			archivoSalida = ArchivoConector.generateDoc(osMantenimentoVialEvento, osMantenimentoVialEvento.getOrden(), plantilla, nuevaPlantilla, 0, OE.getAnchoImagen(), OE.getLargoImagen());
			if(OE.getGuardar()) {
				System.out.println("Guardando Ficha ...");
				System.out.println("Archivo Salida es " + archivoSalida.getAbsolutePath());
				System.out.println("Archivo Salida es " + archivoSalida.getCanonicalFile());
				System.out.println("Archivo Salida es " + archivoSalida.getCanonicalPath());
				System.out.println("Archivo Salida es " + archivoSalida.getName());
				if(archivoSalida.exists()) {
					documento.setIdTipoEstadoDocumento(1044L);
					//documento.setUrlArchivo(archivoSalida.getAbsolutePath());
					documento.setUrlArchivo(OE.getIdMantenimientoVial() + File.separator + archivoSalida.getName());
					documentoOE.setDocumento(documento);
					Gson gson = new Gson();
					String jsonDoc = gson.toJson(documentoOE);
					System.out.println("JSON NUEVO " + jsonDoc);
					System.out.println("NUEVA URL" + app.getProp().getProperty("caliope.documento.insertar"));
					OEDocumento.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
			        OEDocumento.setJson(jsonDoc);
			        OEDocumento.setUsuario(OE.getUsuario());
			        
			        ObjetoSalida osDocumentoAct = Exdto.generarObjetoSalida(OEDocumento);
			        if(osDocumentoAct.esRespuestaOperacionCorrecta()) {
			        	System.out.println(" ID DOCUMENTO " + osDocumentoAct.getRespuesta().get(0));
			        }
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return archivoSalida;
	}
	
	public static void main(String[] args) {
		ReporteDTO dto = new ReporteDTO();
		GenerarFichaOE OE =  new GenerarFichaOE();
		/*
		 * {"usuario":"felipe.molina",
 "idDocumento":7974942,
 "idMantenimientoVial":1000124,
 "idMantenimientoVialEvento":1000124,
 "extent":"export?bbox=-8281812.2,496938.2,-8219704.1,539396.1",
 "bboxSR":"102100"
}
		 */
		
		OE.setIdDocumento(7974942L);
		OE.setUsuario("felipe.molina");
		OE.setBboxSR("102100");
		OE.setExtent("export?bbox=-8281812.2,496938.2,-8219704.1,539396.1");
		OE.setIdMantenimientoVial(1000124L);
		OE.setIdMantenimientoVialEvento(1000124L);
		
		File f = dto.generarFicha(OE);
		
		
		
		
	}
	
	public File generarFicha(GenerarFichaOE OE) {
		byte[] bytePdf = null;
		File archivoSalida =  null;
		JasperReport report = null;
		//InputStream inputStream = ReporteDTO.class.getResourceAsStream("fichaV9_report.jasper");
		InputStream inputStream = ReporteDTO.class.getClassLoader().getResourceAsStream("plantillas/fichaV9_report.jasper");
		ConsultaDTO fallas = new ConsultaDTO();
		ConsultaOE consultaOE = new ConsultaOE();
		String fileName = null;
		try {
			
			consultaOE.setIdMantenimientoVialEvento(OE.getIdMantenimientoVialEvento());
			consultaOE.setUsuario(OE.getUsuario());
			ObjetoSalida osFalla = fallas.consultarFallas(consultaOE);
			
			List<LinkedHashMap<String, Object>> os = new ArrayList<LinkedHashMap<String,Object>>(); 
			
			if(osFalla.esRespuestaOperacionCorrecta()) {
				os = osFalla.getRespuesta();
				for (LinkedHashMap<String, Object> item : os) {
					System.out.println(item.toString());
				}
				
			}
			Log.info("Coleccion " + os.toString());
			Map<String,Object> parametros = this.obtenerParametros(OE);
			
			//print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(fallasList));
			
			fileName = OE.getIdDocumento() +".pdf";
			int in = (inputStream != null ) ? inputStream.available() : 0;
			System.out.println("IN " + in);
			report = (JasperReport) JRLoader.loadObject(inputStream);
			archivoSalida = new File(fileName);
			bytePdf = JasperRunManager.runReportToPdf(report, parametros,new JRBeanCollectionDataSource(os,false));
			FileUtils.writeByteArrayToFile(archivoSalida, bytePdf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return archivoSalida;
	}
	
	private String[] obtenerUrlsFotos(ObjetoSalida archivo) {
		
		//Obtención de fotos
        String[] urls = {noPicURL,noPicURL,noPicURL};  		
        URL url; 
        HttpURLConnection httpConn = null;
                                                                                                                                                                             
		// VALIDAR SI EXISTEN LAS FOTOS, SI NO EXISTEN SE PONE LA RUTA DE LA IMAGEN POR DEFECTO                                                                                                             
		try {                                                                                                                                                                                           
			for (int i = 0; i < archivo.getRespuesta().size(); i++) {                                                                                                                                                 
				if(i>2) {
					break;
				}
				System.out.println(photoUrlDiagnostico + archivo.getRespuesta().get(i).get("url_archivo").toString());
				url = new URL(photoUrlDiagnostico + archivo.getRespuesta().get(i).get("url_archivo").toString());                                                                                                            
				httpConn = (HttpURLConnection) url.openConnection();
				System.out.println(archivo.getRespuesta().get(i).get("url_archivo").toString() + " img: " + httpConn.getResponseCode());
				if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {                                                                                                                          
					urls[i] = photoUrlDiagnostico + archivo.getRespuesta().get(i).get("url_archivo").toString();                                                                                                             
				}else {                                                                                                                                                                                 
					urls[i] = noPicURL;                                                                                                                                        
				}
				httpConn.disconnect();
			}                                                                                                                                                                                           

		} catch (IOException e) {
			System.err.println ("ERROR CONSULTANDO LAS IMAGENES");                           
			e.printStackTrace();                                                                                                                                                                        
		} finally {
			if(httpConn != null) {
				httpConn.disconnect();
			}                     
		}
		
		return urls;
	}

	
	private Map<String,Object> obtenerParametros(GenerarFichaOE OE) {
		String testStr = "", sdStr = "Sin Dato";
		Map<String,Object> res = new HashMap<>();
		MantenimientoVialEventoOE OEMVE = new MantenimientoVialEventoOE();
		MantenimientoVialEventoDTO dto = new MantenimientoVialEventoDTO();
		OEMVE.setUsuario(OE.getUsuario());
		OEMVE.setFiltro("id_mantenimiento_vial_evento=" + OE.getIdMantenimientoVialEvento());
		ObjetoSalida os = dto.consultarXFiltro(OEMVE);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		if(os.esRespuestaOperacionCorrecta()) {
			res.put("LOGO", logoUrl);
			
			//testStr = os.getRespuesta().get(0).get("").toString();
			//res.put("TIPOACTA", testStr);
			
			//localidad
			testStr = (os.getRespuesta().get(0).get("id_localidad") == null ) ? "" : os.getRespuesta().get(0).get("valor_localidad").toString() + " - " + os.getRespuesta().get(0).get("descripcion_localidad").toString();                        
			System.out.println("localidad" + testStr);
			res.put("LOCALIDAD", testStr);    
			
			//Zona
			testStr = (os.getRespuesta().get(0).get("id_zona") == null ) ? "" : os.getRespuesta().get(0).get("valor_zona").toString() + " - " + os.getRespuesta().get(0).get("descripcion_zona").toString();                                                                                                                       
			System.out.println("zona" + testStr);
			res.put("ZONA", testStr) ; 
		    
		    //Fecha de visita técnica
		    testStr = (os.getRespuesta().get(0).get("fecha_visita") == null ) ? "" :(os.getRespuesta().get(0).get("fecha_visita") == null ) ? "" : simpleDateFormat.format(os.getRespuesta().get(0).get("fecha_visita"));                                                                                                           
		    System.out.println("fecha visita" + testStr);
		    res.put("FV", testStr);
		    
		    //UPZ
		    testStr = (os.getRespuesta().get(0).get("id_upz") == null ) ? "" : os.getRespuesta().get(0).get("valor_upz").toString();                                                                                                      
		    System.out.println("upz" + testStr);
		    res.put("UPZ", testStr);
		    
		    //Sección vial
		    testStr = (os.getRespuesta().get(0).get("id_tipo_seccion_vial") == null ) ? "":os.getRespuesta().get(0).get("descripcion_seccion_vial").toString();
		    System.out.println("seccion vial" + testStr);
	        res.put("SECV", testStr);
	        
	        //Barrio
	        testStr = (os.getRespuesta().get(0).get("id_barrio") == null ) ? "":os.getRespuesta().get(0).get("descripcion_barrio").toString();                                                                                                
	        System.out.println("Barrio" + testStr);
	        res.put("BARRIO", testStr);
	        
	        //Origen
	        testStr = (os.getRespuesta().get(0).get("id_tipo_origen") == null ) ? "":os.getRespuesta().get(0).get("descripcion_origen").toString();
	        System.out.println("Origen" + testStr);	        
	        res.put("ORIGEN", testStr); 
	        
	        //Numero de radicado
	        testStr = (os.getRespuesta().get(0).get("solicitud_radicado_entrada") == null ) ? "No Aplica" : os.getRespuesta().get(0).get("solicitud_radicado_entrada").toString();                                                                                                                   
	        System.out.println("Radicado" + testStr);	        
	        res.put("RAD", testStr); 
	        
	        //CIV
	        testStr = (os.getRespuesta().get(0).get("civ") == null )?"":os.getRespuesta().get(0).get("civ").toString();                                                                                                                                                    
	        System.out.println("CIV" + testStr);	        
	        res.put("CIV", testStr); 
	        
	        //Uso de la vía
	        testStr = (os.getRespuesta().get(0).get("descripcion_uso_via") == null )?"":os.getRespuesta().get(0).get("descripcion_uso_via").toString();                                                                                        
	        System.out.println("USOV" + testStr);	        
	        res.put("USOV", testStr); 
	        
	        //Eje vial
	        testStr = (os.getRespuesta().get(0).get("eje_vial") == null )?"":os.getRespuesta().get(0).get("eje_vial").toString();                                                                                                                                            
	        System.out.println("EJEV" + testStr);	        
	        res.put("EJEV", testStr);  
	        
	        //Desde
	        testStr = (os.getRespuesta().get(0).get("desde") == null )?"":os.getRespuesta().get(0).get("desde").toString();                                                                                                                                                
	        System.out.println("DESDE" + testStr);	        
	        res.put("DESDE", testStr); 
	        
	        //Hasta
	        testStr = (os.getRespuesta().get(0).get("hasta") == null )?"":os.getRespuesta().get(0).get("hasta").toString();                                                                                                                                                
	        System.out.println("Hasta" + testStr);	        
	        res.put("HASTA", testStr); 
	        
	        //Tipo de malla
	        testStr = (os.getRespuesta().get(0).get("descripcion_malla") == null )?"":os.getRespuesta().get(0).get("descripcion_malla").toString();                                                                                          
	        System.out.println("TIPOMV" + testStr);	        
	        res.put("TIPOMV", testStr); 
	        
	        //PCI
	        testStr = (os.getRespuesta().get(0).get("pci") == null )?"":os.getRespuesta().get(0).get("pci").toString();                                                                        
	        System.out.println("PCI" + testStr);
	        res.put("PCI", testStr);
	        
	        //Intervención total
	        testStr = (os.getRespuesta().get(0).get("descripcion_tipo_intervencion") == null )?"":os.getRespuesta().get(0).get("descripcion_tipo_intervencion").toString();                                                                                                                                               
	        System.out.println("TIT" + testStr);
	        res.put("TIT", testStr);
	        
	        //¿Tiene rutas de transporte?
	        testStr = (os.getRespuesta().get(0).get("rutas_transporte") == null )?"":os.getRespuesta().get(0).get("rutas_transporte").toString();
	        System.out.println("RUTAS" + testStr);
	        res.put("RUTAS", testStr); 
	        
	        //PK_ID
	        testStr = (os.getRespuesta().get(0).get("pk_id_calzada") == null )?"":os.getRespuesta().get(0).get("pk_id_calzada").toString();                                                             
	        System.out.println("PKID" + testStr);
	        res.put("PKID", testStr); 
	        
	        //Area PK
	        testStr = (os.getRespuesta().get(0).get("area_pk") == null )?"":os.getRespuesta().get(0).get("area_pk").toString();                                                                     
	        System.out.println("AREAPK" + testStr);
	        res.put("AREAPK", testStr);  
	        
	        //Programa
	        testStr = (os.getRespuesta().get(0).get("descripcion_programa") == null )?"":os.getRespuesta().get(0).get("descripcion_programa").toString();                                                                                 
	        System.out.println("PROG" + testStr);
	        res.put("PROG", testStr); 
	        
	        //Nombre de solicitud
	        testStr = (os.getRespuesta().get(0).get("solicitud_nombre") == null )?"":os.getRespuesta().get(0).get("solicitud_nombre").toString();                                                                                    
	        System.out.println("SOLICITANTE" + testStr);
	        res.put("SOLICITANTE", testStr);
	        
	        //Actividad
	        testStr = (os.getRespuesta().get(0).get("descripcion_actividad_detallada") == null )?"":os.getRespuesta().get(0).get("descripcion_actividad_detallada").toString();                                                                                    
	        System.out.println("ACTIVIDAD" + testStr);
	        res.put("ACTIVIDAD", testStr);
	        
	        //Actividad agrupada
	        testStr = (os.getRespuesta().get(0).get("codigo_actividad_agrupada") == null )?"":os.getRespuesta().get(0).get("codigo_actividad_agrupada").toString();                   
	        System.out.println("ACTG" + testStr);
	        res.put("ACTG", testStr);
	        //Descripcion elemento
	        testStr = (os.getRespuesta().get(0).get("descripcion_elemento") == null )?"":os.getRespuesta().get(0).get("descripcion_elemento").toString();                             
	        res.put("TE", testStr);
	        
	        //tipo de superficie
	        testStr = (os.getRespuesta().get(0).get("descripcion_superficie") == null )?"":os.getRespuesta().get(0).get("descripcion_superficie").toString();                                                     
	        System.out.println("TS" + testStr);
	        res.put("TS", testStr);
	        
	        //Transitabilidad
	        testStr = (os.getRespuesta().get(0).get("descripcion_transitabilidad") == null )?"":os.getRespuesta().get(0).get("descripcion_transitabilidad").toString();                                                               
	        System.out.println("TRS" + testStr);
	        res.put("TRS", testStr);  
	        
	        //iIdice de priorizacion relativo (ipr)
	        testStr = (os.getRespuesta().get(0).get("ip_relativo") == null )?"":os.getRespuesta().get(0).get("ip_relativo").toString();      
	        System.out.println("ipRelativo" + testStr);
	        res.put("ipRelativo", testStr);
	        
	        //Densisdad poblacional general
	        testStr = (os.getRespuesta().get(0).get("puntaje_dpg") == null )?"":os.getRespuesta().get(0).get("puntaje_dpg").toString();      
	        System.out.println("puntajeDPG" + testStr);
	        res.put("puntajeDpg", testStr);
	        
	        //Densisdad poblacional con movilidad restringida
	        testStr = (os.getRespuesta().get(0).get("puntaje_dpmr") == null )?"":os.getRespuesta().get(0).get("puntaje_dpmr").toString();        
	        System.out.println("puntajeDpmr" + testStr);
	        res.put("puntajeDpmr", testStr);
	        
	        //Solicitudes y/o requerimientos de la ciudadanía
	        testStr = (os.getRespuesta().get(0).get("puntaje_peticion") == null )?"":os.getRespuesta().get(0).get("puntaje_peticion").toString();                
	        System.out.println("puntajePeticion" + testStr);
	        res.put("puntajePeticion", testStr);
	        
	        //Accesibilidad a infraestructura con función social
	        testStr = (os.getRespuesta().get(0).get("puntaje_sitio_social") == null )?"":os.getRespuesta().get(0).get("puntaje_sitio_social").toString();                      
	        System.out.println("puntajeSitioSocial" + testStr);
	        res.put("puntajeSitioSocial", testStr);
	        
	        //Uso del suelo enfocado a la función social
	        testStr = (os.getRespuesta().get(0).get("puntaje_uso_social") == null )?"":os.getRespuesta().get(0).get("puntaje_uso_social").toString();                  
	        System.out.println("puntajeUsoSocial" + testStr);
	        res.put("puntajeUsoSocial", testStr);
	        
	        //Dimensión social
	        testStr = (os.getRespuesta().get(0).get("puntaje_dimen_social") == null )?"":os.getRespuesta().get(0).get("puntaje_dimen_social").toString();                      
	        System.out.println("puntajeDimenSocial" + testStr);
	        res.put("puntajeDimenSocial", testStr);
	        
	        //Uso del suelo enfocado a la función economica
	        testStr = (os.getRespuesta().get(0).get("puntaje_sitio_econom") == null )?"":os.getRespuesta().get(0).get("puntaje_sitio_econom").toString();                      
	        System.out.println("puntajeSitioEconom" + testStr);
	        res.put("puntajeSitioEconom", testStr);
	        
	        //Accesibilidad a infraestructura con función economica
	        testStr = (os.getRespuesta().get(0).get("puntaje_uso_econom") == null )?"":os.getRespuesta().get(0).get("puntaje_uso_econom").toString();                        
	        System.out.println("puntajeUsoEconom" + testStr);
	        res.put("puntajeUsoEconomico", testStr);
	        
	        //Dimension Economica
	        testStr = (os.getRespuesta().get(0).get("puntaje_dimen_econom") == null )?"":os.getRespuesta().get(0).get("puntaje_dimen_econom").toString();
	        System.out.println("puntajeDimenEconom" + testStr);
	        res.put("puntajeDimenEconom", testStr);
	        
	        //Determinación del tipo de malla vial
	        testStr = (os.getRespuesta().get(0).get("puntaje_malla") == null )?"":os.getRespuesta().get(0).get("puntaje_malla").toString();                                                                          
	        System.out.println("puntajeMalla" + testStr);
	        res.put("puntajeMalla", testStr);
	        
	        //Circulación de rutas de transporte en el segmento
	        testStr = (os.getRespuesta().get(0).get("puntaje_rutas") == null )?"":os.getRespuesta().get(0).get("puntaje_rutas").toString();          
	        System.out.println("puntajeRutas" + testStr);
	        res.put("puntajeRutas", testStr);
	        
	        //Seguridad vial
	        testStr = (os.getRespuesta().get(0).get("puntaje_siniest") == null )?"":os.getRespuesta().get(0).get("puntaje_siniest").toString();              
	        System.out.println("puntajeSiniest" + testStr);
	        res.put("puntajeSiniest", testStr);
	        
	        //Dimensión técnica
	        testStr = (os.getRespuesta().get(0).get("puntaje_dimen_tecnica") == null )?"":os.getRespuesta().get(0).get("puntaje_dimen_tecnica").toString();                        
	        System.out.println("puntajeDimenTecnica" + testStr);
	        res.put("puntajeDimenTecnica", testStr);
	        
	        //Indice de priorización
	        testStr = (os.getRespuesta().get(0).get("puntaje_ip") == null )?"":os.getRespuesta().get(0).get("puntaje_ip").toString();    
	        res.put("puntajeIp", testStr);
	        
	        //Indice de priorización maximo encontrado
	        testStr = (os.getRespuesta().get(0).get("puntaje_ip_max") == null )?"":os.getRespuesta().get(0).get("puntaje_ip_max").toString();          
	        System.out.println("puntajeIpMax" + testStr);
	        res.put("puntajeIpMax", testStr);
	        
		}
		
		return res;
	}
	
	
	
	public File generarFichaIntervencion(GenerarFichaOE OE)
	{
		File archivoSalida =  null;
		Double sumLong=0D, sumArea=0D;
		try {
			
			
			ExternoDTO ext = new ExternoDTO();
			ObjetoNegocioOE OENegocio = new ObjetoNegocioOE();
			AppConfig config = new AppConfig();
			String filtroReporte = config.getProp().getProperty("org.gov.umv.filtroFichaInt");
			
			String urlReporte = config.getProp().getProperty("caliope.consultarReporte");
			String json = "{\"usuario\":\""+OE.getUsuario()+"\",\"filtro\":\""+ filtroReporte +"\"}";
			OENegocio.setUrl(urlReporte);
			OENegocio.setJson(json);
			OENegocio.setUsuario(OE.getUsuario());
			
			ObjetoSalida Reporte = ext.generarObjetoSalida(OENegocio);
			
			String plantilla =  "";
			String nuevaPlantilla = config.getProp().getProperty("org.gov.umv.Mantenimientos")+ File.separator + OE.getIdMantenimientoVial() + File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			
			
			if(Reporte.esRespuestaOperacionCorrecta()) {
				plantilla = Reporte.getRespuesta().get(0).get("url_archivo").toString();
				
			}
			//ojooooooooooo plantilla = "C:\\\\Desarrollo\\Acta_Visita_Intervencion_SIGMA.docx";
			
			File customDir = new File(config.getProp().getProperty("org.gov.umv.Mantenimientos")+ File.separator + OE.getIdMantenimientoVial());
			
			if(!customDir.exists()) {
				customDir.mkdirs();
			}
			List<LinkedHashMap<String, Object>> os = new ArrayList<LinkedHashMap<String,Object>>(); 
			
			
			
			//print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(fallasList));
			
			
			AppConfig app = new AppConfig();
	        ExternoDTO Exdto = new ExternoDTO();

			ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
	        OEEE.setUrl(app.getProp().getProperty("caliope.documento.consultar"));
	        String filtro = "id_documento = " +OE.getIdDocumento();
	        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
	        OEEE.setJson(jsonArchivoAc);
	        OEEE.setUsuario(OE.getUsuario());
	        
	        ObjetoNegocioOE OEDocumento = new ObjetoNegocioOE();
	        DocumentoOE documentoOE = new DocumentoOE();
	        documentoOE.setUsuario(OE.getUsuario());
	        
	        
	        ObjetoSalida osDocumento = Exdto.generarObjetoSalida(OEEE);

			MantenimientoVialEventoOE OEMVE = new MantenimientoVialEventoOE();
			MantenimientoVialEventoDTO dto = new MantenimientoVialEventoDTO();
			OEMVE.setUsuario(OE.getUsuario());
			OEMVE.setFiltro("id_mantenimiento_vial_evento=" + OE.getIdMantenimientoVialEvento());
			
			ObjetoSalida osMantenimentoVialEvento = dto.consultarXFiltro(OEMVE);
			
			ArchivoDTO dtoArchivo = new ArchivoDTO();
			DocumentoArchivoOE OEArchivo = new DocumentoArchivoOE();
			OEArchivo.setUsuario(OE.getUsuario());
			OEArchivo.setIdDocumento(OE.getIdDocumento());
			ObjetoSalida archivos =  dtoArchivo.consultarArchivo(OEArchivo);
								
			ArrayList<List<LinkedHashMap<String,Object>>> respuestaM = new ArrayList<List<LinkedHashMap<String,Object>>>();
			URL url;
	        
	        List<LinkedHashMap<String,Object>> resp = osMantenimentoVialEvento.getRespuesta();
			
	        HttpURLConnection httpConn = null;                                                                                                                                                                
			String urls[] = obtenerUrlsFotos(archivos);
	        
	        if(archivos.esRespuestaOperacionCorrecta()) {
		        for (int i = 0; i < urls.length; i++) {                                                                                                                                                             
		        	if(i > 2) {                                                                                                                                                                                     
		        		break;                                                                                                                                                                                      
		        	}                                                                                                                                                                                               
					String urlImg = urls[i];                                                                                                                                                                        
					
					resp.get(0).put("url_"+Integer.toString(i+1), urlImg);
					System.out.println("url_"+Integer.toString(i+1) + " - " + urlImg);
				}
	        }
	        String extent = (OE.getExtent() == null) ? "" : OE.getExtent();
	        String bboxSR = (OE.getBboxSR() == null) ? "" : OE.getBboxSR();
	        if (!extent.contains("%26b")) {                                                                                                                                                                     
				extent = extent + "&bboxSR=" + bboxSR + "&size=560,300&format=jpg&f=image";                                                                                                                     
			}    
	        String testStr = "";
	        int responseCode = 0; 
	        try {
				url = new URL(mapExport + extent);
				
				httpConn = (HttpURLConnection) url.openConnection();
				httpConn.setConnectTimeout(this.timeoutConexionServicioMapas);
				httpConn.setReadTimeout(this.timeoutLecturaServicioMapas);
				responseCode = httpConn.getResponseCode();
				System.out.println("URL: " + url.toString());
				System.out.println("Mapa respuesta: " + responseCode);
				httpConn.disconnect();
			} catch (Exception e1) {
				if(httpConn != null) {
					httpConn.disconnect();
				}
				System.out.println(e1.getMessage());
				testStr = defaultMapa;
			}
			if (responseCode == HttpURLConnection.HTTP_OK) {
				testStr = mapExport + extent;
			} else {
				testStr = defaultMapa;
			}
			resp.get(0).put("url_mapa",testStr);
			//*/
			
			TabDocumento documento = new TabDocumento(OE.getIdDocumento());
			Format format =  new SimpleDateFormat("yyyy-MM-dd");
            
			if(osDocumento.esRespuestaOperacionCorrecta()) {
				resp.get(0).put("tipo_visita", osDocumento.getRespuesta().get(0).get("nombre_tipo_documento").toString());
				Double idTipoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_documento").toString());
				Double idTipoEstadoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_estado_documento").toString());
				Double numeroVersion = Double.parseDouble(osDocumento.getRespuesta().get(0).get("numero_version").toString());
				String numero = (osDocumento.getRespuesta().get(0).get("numero") == null) ? "" : osDocumento.getRespuesta().get(0).get("numero").toString();
				String clave1 = (osDocumento.getRespuesta().get(0).get("clave_1") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_1").toString();
				String clave2 = (osDocumento.getRespuesta().get(0).get("clave_2") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_2").toString();
				String clave3 = (osDocumento.getRespuesta().get(0).get("clave_3") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_3").toString();
				String descripcion = (osDocumento.getRespuesta().get(0).get("descripcion") == null) ? "" : osDocumento.getRespuesta().get(0).get("descripcion").toString();
				String registroActivo = osDocumento.getRespuesta().get(0).get("registro_activo").toString();
				Object fecha1 = (Object)osDocumento.getRespuesta().get(0).get("fecha");  
				
				Long idTipDoc = idTipoDocumento.longValue();
				Long idTipEstDoc = idTipoEstadoDocumento.longValue();
				short numeroVers = numeroVersion.shortValue();
				documento.setIdTipoDocumento(idTipDoc);
				documento.setIdTipoEstadoDocumento(idTipEstDoc);
				documento.setFecha(format.format(fecha1));
				documento.setRegistroActivo(registroActivo);
				documento.setNumero(numero);
				documento.setDescripcion(descripcion);
				documento.setClave1(clave1);
				documento.setClave2(clave2);
				documento.setClave3(clave3);
				documento.setNumeroVersion(numeroVers);
			}
			
			ConsultaOE consultaOE = new ConsultaOE();
			consultaOE.setIdMantenimientoVialEvento(OE.getIdMantenimientoVialEvento());
			consultaOE.setUsuario(OE.getUsuario());
			ConsultaDTO consulta = new ConsultaDTO();
			ObjetoSalida osAreasInt = consulta.consultarAreaIntervencion(consultaOE);
			
			List<LinkedHashMap<String, Object>> resps = new ArrayList<LinkedHashMap<String,Object>>();
			
			if(osAreasInt.esRespuestaOperacionCorrecta()) 
			{
				for(LinkedHashMap<String, Object> item : osAreasInt.getRespuesta()) 
				{
					LinkedHashMap<String, Object> a = new LinkedHashMap<String, Object>();
					a.put("elemento",((item.get("elemento") == null) ? "" : item.get("elemento").toString()));
					a.put("desripcion_superficie",((item.get("desripcion_superficie") == null) ? "" : item.get("desripcion_superficie").toString()));
					a.put("longitud",((item.get("longitud") == null ) ? "" : item.get("longitud").toString()));
					a.put("ancho",((item.get("ancho") == null) ? "" : item.get("ancho").toString()));
					a.put("area",((item.get("area") == null) ? "" : item.get("area").toString()));
					a.put("desripcion_intervencion",((item.get("desripcion_intervencion") == null ) ? "" : item.get("desripcion_intervencion").toString()));
				
					sumLong = (item.get("sum_long") == null ) ? 0D : new Double(item.get("sum_long").toString());
					sumArea = (item.get("sum_area") == null ) ? 0D : new Double(item.get("sum_area").toString());
					
					resps.add(a);
				}
				osAreasInt.setRespuesta(resps);
				respuestaM.add(osAreasInt.getRespuesta());
				osMantenimentoVialEvento.setRespuestaM(respuestaM);
				
			}else {
				System.out.println("No tengo areas de intervencion");
			}
	        
			
			IntervencionNovedadOE novedad = new IntervencionNovedadOE();
			novedad.setIntervencionNovedad(new TabIntervencionNovedad());
			novedad.getIntervencionNovedad().setIdMantenimientoVialEvento(new TabMantenimientoVialEvento(OE.getIdMantenimientoVialEvento()));
			IntervencionNovedadDTO dtoN = new IntervencionNovedadDTO();
			ObjetoSalida osNovedad = dtoN.consultarIdMantenimientoVialEvento(novedad);
			
			if(osNovedad.esRespuestaOperacionCorrecta()) 
			{
				for(LinkedHashMap<String, Object> item : osNovedad.getRespuesta()) 
				{
					String indice = (item.get("valor_novedad") == null ) ? "" : item.get("valor_novedad").toString();
					resp.get(0).put("n"+indice, "X");
				}
			}
			
			
			resp.get(0).put("sumLong", sumLong);
			resp.get(0).put("sumArea", sumArea);
			
			resp.get(0).put("numeroInforme", documento.getNumero());
			
			osMantenimentoVialEvento.setRespuesta(resp);
			
			archivoSalida = ArchivoConector.generateDoc(osMantenimentoVialEvento, osMantenimentoVialEvento.getOrden(), plantilla, nuevaPlantilla, 0, OE.getAnchoImagen(), OE.getLargoImagen());
			
			if(OE.getGuardar()) {
				if(archivoSalida.exists()) 
				{
					if(OE.getPasarAFirme())
						documento.setIdTipoEstadoDocumento(1044L);
					
					documento.setUrlArchivo(archivoSalida.getAbsolutePath());
					documentoOE.setDocumento(documento);
					Gson gson = new Gson();
					String jsonDoc = gson.toJson(documentoOE);
					OEDocumento.setUrl(app.getProp().getProperty("caliope.documento.insertar"));//ESTE METODO EN CALIOPE, Y SI ESTA SETEADO EL IDDOCUMENTO, LO QUE HACE ES ACTUALIZAR
			        OEDocumento.setJson(jsonDoc);
			        OEDocumento.setUsuario(OE.getUsuario());
			        
			        ObjetoSalida osDocumentoAct = Exdto.generarObjetoSalida(OEDocumento);
			        if(osDocumentoAct.esRespuestaOperacionCorrecta()) {
			        	System.out.println(" ID DOCUMENTO " + osDocumentoAct.getRespuesta().get(0));
			        }					
				}
				
                
    
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return archivoSalida;
	}

	
	public File generarFichaWordAforo(GenerarFichaOE OE) {
		File archivoSalida =  null;
		JasperReport report = null;
		//InputStream inputStream = ReporteDTO.class.getResourceAsStream("fichaV9_report.jasper");
		ConsultaDTO fallas = new ConsultaDTO();
		ConsultaOE consultaOE = new ConsultaOE();
		ArchivoConector archivo = new ArchivoConector();
		String fileName = null;
		try {
			
			ExternoDTO ext = new ExternoDTO();
			ObjetoNegocioOE OENegocio = new ObjetoNegocioOE();
			AppConfig config = new AppConfig();
			String filtroReporte = config.getProp().getProperty("org.gov.umv.filtroAforo");
			
			String urlReporte = config.getProp().getProperty("caliope.consultarReporte");
			String json = "{\"usuario\":\""+OE.getUsuario()+"\",\"filtro\":\""+ filtroReporte +"\"}";
			OENegocio.setUrl(urlReporte);
			OENegocio.setJson(json);
			OENegocio.setUsuario(OE.getUsuario());
			
			ObjetoSalida Reporte = ext.generarObjetoSalida(OENegocio);
			
			String plantilla =  "";
			//String nuevaPlantilla = config.getProp().getProperty("org.gov.umv.Archivos") + File.separator + OE.getIdAforo() +  File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			String nuevaPlantilla = (OE.getIdMantenimientoVial()!= null ) ? config.getProp().getProperty("org.gov.umv.Mantenimientos") + File.separator + OE.getIdMantenimientoVial() + File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx" : config.getProp().getProperty("org.gov.umv.Archivos") + File.separator + OE.getIdAforo() +  File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			
			
			if(Reporte.esRespuestaOperacionCorrecta()) {
				plantilla = Reporte.getRespuesta().get(0).get("url_archivo").toString();
				//plantilla = "D:\\Instaladores\\FORMATO DIGITAL DE AFORO VEHICULAR.docx";
			}
			String FolderName = (OE.getIdMantenimientoVial()!= null ) ? config.getProp().getProperty("org.gov.umv.Mantenimientos") + File.separator + OE.getIdMantenimientoVial() : config.getProp().getProperty("org.gov.umv.Archivos")+ File.separator + OE.getIdAforo(); 
			File customDir = new File(FolderName);
			
			if(!customDir.exists()) {
				customDir.mkdirs();
			}
			List<LinkedHashMap<String, Object>> os = new ArrayList<LinkedHashMap<String,Object>>(); 

			AppConfig app = new AppConfig();
	        ExternoDTO Exdto = new ExternoDTO();

			ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
	        OEEE.setUrl(app.getProp().getProperty("caliope.documento.consultar"));
	        String filtro = "id_documento = " +OE.getIdDocumento();
	        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
	        OEEE.setJson(jsonArchivoAc);
	        OEEE.setUsuario(OE.getUsuario());
	        ObjetoNegocioOE OEDocumento = new ObjetoNegocioOE();
	        DocumentoOE documentoOE = new DocumentoOE();
	        documentoOE.setUsuario(OE.getUsuario());
	        
	        ObjetoSalida osDocumento = Exdto.generarObjetoSalida(OEEE);
	        
	        TabDocumento documento = new TabDocumento(OE.getIdDocumento());
			Format format =  new SimpleDateFormat("yyyy-MM-dd");
            
			if(osDocumento.esRespuestaOperacionCorrecta()) {
				Double idTipoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_documento").toString());
				Double idTipoEstadoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_estado_documento").toString());
				Double numeroVersion = (osDocumento.getRespuesta().get(0).get("numero_version") == null) ? 0 : Double.parseDouble(osDocumento.getRespuesta().get(0).get("numero_version").toString());
				String numero = (osDocumento.getRespuesta().get(0).get("numero") == null) ? "" : osDocumento.getRespuesta().get(0).get("numero").toString();
				String clave1 = (osDocumento.getRespuesta().get(0).get("clave_1") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_1").toString();
				String clave2 = (osDocumento.getRespuesta().get(0).get("clave_2") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_2").toString();
				String clave3 = (osDocumento.getRespuesta().get(0).get("clave_3") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_3").toString();
				String descripcion = (osDocumento.getRespuesta().get(0).get("descripcion") == null) ? "" : osDocumento.getRespuesta().get(0).get("descripcion").toString();
				String registroActivo = osDocumento.getRespuesta().get(0).get("registro_activo").toString();
				Object fecha1 = (Object)osDocumento.getRespuesta().get(0).get("fecha");  
				
				Long idTipDoc = idTipoDocumento.longValue();
				Long idTipEstDoc = idTipoEstadoDocumento.longValue();
				short numeroVers = numeroVersion.shortValue();
				documento.setIdTipoDocumento(idTipDoc);
				documento.setIdTipoEstadoDocumento(idTipEstDoc);
				documento.setFecha(format.format(fecha1));
				documento.setRegistroActivo(registroActivo);
				documento.setNumero(numero);
				documento.setDescripcion(descripcion);
				documento.setClave1(clave1);
				documento.setClave2(clave2);
				documento.setClave3(clave3);
				documento.setNumeroVersion(numeroVers);
			}
	        
	        AforoOE aforoOE = new AforoOE();
	        aforoOE.setUsuario(OE.getUsuario());
	        AforoDTO dtoAforo = new AforoDTO();
	        AforocalzadaDTO AforoCalzada = new AforocalzadaDTO();
	        AforoanalisisDTO dtoAforoAnalisis = new AforoanalisisDTO();
	        AforodatoDTO dtoAforoDato = new AforodatoDTO();
	        
	        aforoOE.setFiltro("id_aforo=" + OE.getIdAforo());
	        
	        ArrayList<List<LinkedHashMap<String,Object>>> respuestaM = new ArrayList<List<LinkedHashMap<String,Object>>>();
	        
	        ObjetoSalida AforoOs = dtoAforo.consultarXFiltro(aforoOE);
	        ObjetoSalida AforoCalzadaOs = AforoCalzada.consultarXFiltro(aforoOE);
	        ObjetoSalida AforoDatoOs = dtoAforoDato.consultarXFiltro(aforoOE);
	        
	        System.out.println("Aforo " + AforoOs.getRespuesta());
	        System.out.println("AforoCalzada " + AforoCalzadaOs.getRespuesta());
	        System.out.println("AforoDato " + AforoDatoOs.getRespuesta());
	        
	        if(AforoOs.esRespuestaOperacionCorrecta()) {
	        	List<LinkedHashMap<String,Object>> resp = new ArrayList<LinkedHashMap<String,Object>>();
	        	AforoOs.getRespuesta().get(0).put("tipo_info",(AforoOs.getRespuesta().get(0).get("origen_informacion") == null) ? "PRIMARIA" : "SECUNDARIA");
	        	AforoOs.getRespuesta().get(0).put("tipo_aforo",(AforoOs.getRespuesta().get(0).get("digital").equals("SI")) ? "DIGITAL" : "MANUAL");
	        }
	        
	        if(AforoCalzadaOs.esRespuestaOperacionCorrecta()) {
				List<LinkedHashMap<String, Object>> resps = new ArrayList<LinkedHashMap<String,Object>>();
				for(LinkedHashMap<String, Object> item : AforoCalzadaOs.getRespuesta()) {
					LinkedHashMap<String, Object> a = new LinkedHashMap<String, Object>();
					a.put("pk_id_calzada",((item.get("pk_id_calzada") == null) ? "" : item.get("pk_id_calzada").toString()));
					a.put("civ",((item.get("civ") == null) ? "" : item.get("civ").toString()));
					a.put("aledanio",((item.get("aledanio") == null ) ? "" : item.get("aledanio").toString()));
					a.put("eje_vial",((item.get("eje_vial") == null) ? "" : item.get("eje_vial").toString()));
					a.put("desde",((item.get("desde") == null) ? "" : item.get("desde").toString()));
					a.put("hasta",((item.get("hasta") == null ) ? "" : item.get("hasta").toString()));
					a.put("id_localidad",((item.get("id_localidad") == null ) ? "" : item.get("id_localidad").toString()));					
					a.put("descripcion_localidad",((item.get("descripcion_localidad") == null ) ? "" : item.get("descripcion_localidad").toString()));
					resps.add(a);
				}
				AforoCalzadaOs.setRespuesta(resps);
				respuestaM.add(AforoCalzadaOs.getRespuesta());
				
			}else {
				
				System.out.println("No tengo Calzadas Asociadas");
			}
	        
	        if(AforoDatoOs.esRespuestaOperacionCorrecta()) {
				List<LinkedHashMap<String, Object>> resps = new ArrayList<LinkedHashMap<String,Object>>();
				for(LinkedHashMap<String, Object> item : AforoDatoOs.getRespuesta()) {
					LinkedHashMap<String, Object> a = new LinkedHashMap<String, Object>();
					/*BUSES_VAN, BUSES_BUSETA, BUSES_SITP_ALIMENTADORES, CAMIONES_C2P, CAMIONES_C2G, CAMIONES_C3_C4, CAMIONES_C5_C5*/
					a.put("fecha_hora",((item.get("fecha_hora") == null) ? "" : item.get("fecha_hora").toString()));
					a.put("automoviles",((item.get("automoviles") == null) ? "" : item.get("automoviles").toString()));
					a.put("buses_van",((item.get("buses_van") == null ) ? "" : item.get("buses_van").toString()));
					a.put("buses_buseta",((item.get("buses_buseta") == null) ? "" : item.get("buses_buseta").toString()));
					a.put("buses_sitp_alimentadores",((item.get("buses_sitp_alimentadores") == null) ? "" : item.get("buses_sitp_alimentadores").toString()));
					a.put("camiones_c2p",((item.get("camiones_c2p") == null ) ? "" : item.get("camiones_c2p").toString()));
					a.put("camiones_c2g",((item.get("camiones_c2g") == null ) ? "" : item.get("camiones_c2g").toString()));					
					a.put("camiones_c3_c4",((item.get("camiones_c3_c4") == null ) ? "" : item.get("camiones_c3_c4").toString()));
					a.put("camiones_c5_c5",((item.get("camiones_c5_c5") == null ) ? "" : item.get("camiones_c5_c5").toString()));
					resps.add(a);
				}
				AforoCalzadaOs.setRespuesta(resps);
				respuestaM.add(AforoCalzadaOs.getRespuesta());
				
			}else {
				
				System.out.println("No tengo Aforo Vehicular");
			}
			AforoOs.setRespuestaM(respuestaM);
			
			//osMantenimentoVialEvento.setRespuesta(resp);
			
			archivoSalida = ArchivoConector.generateDoc(AforoOs, AforoOs.getOrden(), plantilla, nuevaPlantilla, 0, OE.getAnchoImagen(), OE.getLargoImagen());
			
			if(OE.getGuardar()) {
				if(archivoSalida.exists()) {
					documento.setIdTipoEstadoDocumento(1044L);
					documento.setUrlArchivo(archivoSalida.getAbsolutePath());
					documentoOE.setDocumento(documento);
					Gson gson = new Gson();
					String jsonDoc = gson.toJson(documentoOE);
					OEDocumento.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
			        OEDocumento.setJson(jsonDoc);
			        OEDocumento.setUsuario(OE.getUsuario());
			        
			        ObjetoSalida osDocumentoAct = Exdto.generarObjetoSalida(OEDocumento);
			        if(osDocumentoAct.esRespuestaOperacionCorrecta()) {
			        	System.out.println(" ID DOCUMENTO " + osDocumentoAct.getRespuesta().get(0));
			        }
			        
			        
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return archivoSalida;
	}
	
	public File generarFichaWordAnalisis(GenerarFichaOE OE) {
		File archivoSalida =  null;
		JasperReport report = null;
		//InputStream inputStream = ReporteDTO.class.getResourceAsStream("fichaV9_report.jasper");
		ConsultaDTO fallas = new ConsultaDTO();
		ConsultaOE consultaOE = new ConsultaOE();
		ArchivoConector archivo = new ArchivoConector();
		String fileName = null;
		try {
			
			
			ExternoDTO ext = new ExternoDTO();
			ObjetoNegocioOE OENegocio = new ObjetoNegocioOE();
			AppConfig config = new AppConfig();
			String filtroReporte = config.getProp().getProperty("org.gov.umv.filtroAnalisis");
			
			String urlReporte = config.getProp().getProperty("caliope.consultarReporte");
			String json = "{\"usuario\":\""+OE.getUsuario()+"\",\"filtro\":\""+ filtroReporte +"\"}";
			OENegocio.setUrl(urlReporte);
			OENegocio.setJson(json);
			OENegocio.setUsuario(OE.getUsuario());
			
			ObjetoSalida Reporte = ext.generarObjetoSalida(OENegocio);
			
			String plantilla =  "";
			//String nuevaPlantilla = config.getProp().getProperty("org.gov.umv.Archivos") + File.separator + OE.getIdAforo() +  File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			String nuevaPlantilla = (OE.getIdMantenimientoVial()!= null ) ? config.getProp().getProperty("org.gov.umv.Mantenimientos") + File.separator + OE.getIdMantenimientoVial() + File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx" : config.getProp().getProperty("org.gov.umv.Archivos") + File.separator + OE.getIdAforo() +  File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			
			
			if(Reporte.esRespuestaOperacionCorrecta()) {
				plantilla = Reporte.getRespuesta().get(0).get("url_archivo").toString();
				//plantilla = "D:\\Instaladores\\FORMATO DIGITAL ANALISIS DE TRANSITO.docx";
			}
			String FolderName = (OE.getIdMantenimientoVial()!= null ) ? config.getProp().getProperty("org.gov.umv.Mantenimientos") + File.separator + OE.getIdMantenimientoVial() : config.getProp().getProperty("org.gov.umv.Archivos")+ File.separator + OE.getIdAforo(); 
			File customDir = new File(FolderName);
			
			if(!customDir.exists()) {
				customDir.mkdirs();
			}
			List<LinkedHashMap<String, Object>> os = new ArrayList<LinkedHashMap<String,Object>>(); 
			
			
			
			//print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(fallasList));
			
			
			AppConfig app = new AppConfig();
	        ExternoDTO Exdto = new ExternoDTO();

			ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
	        OEEE.setUrl(app.getProp().getProperty("caliope.documento.consultar"));
	        String filtro = "id_documento = " +OE.getIdDocumento();
	        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
	        OEEE.setJson(jsonArchivoAc);
	        OEEE.setUsuario(OE.getUsuario());
	        
	        ObjetoSalida osDocumento = Exdto.generarObjetoSalida(OEEE);

	        AforoOE aforoOE = new AforoOE();
	        AforoDTO dtoAforo = new AforoDTO();
	        AforocalzadaDTO AforoCalzada = new AforocalzadaDTO();
	        AforoanalisisDTO dtoAforoAnalisis = new AforoanalisisDTO();
	        AforodatoDTO dtoAforoDato = new AforodatoDTO();
	        
	        aforoOE.setFiltro("id_aforo=" + OE.getIdAforo());
	        aforoOE.setUsuario(OE.getUsuario());
	        ArrayList<List<LinkedHashMap<String,Object>>> respuestaM = new ArrayList<List<LinkedHashMap<String,Object>>>();
			
	        ObjetoSalida AforoOs = dtoAforo.consultarXFiltro(aforoOE);
	        ObjetoSalida AforoCalzadaOs = AforoCalzada.consultarXFiltro(aforoOE);
	        ObjetoSalida AforoAnalisisOs = dtoAforoAnalisis.consultarXFiltro(aforoOE);
	        
	        TabDocumento documento = new TabDocumento(OE.getIdDocumento());
			Format format =  new SimpleDateFormat("yyyy-MM-dd");
			ObjetoNegocioOE OEDocumento = new ObjetoNegocioOE();
	        DocumentoOE documentoOE = new DocumentoOE();
	        documentoOE.setUsuario(OE.getUsuario());
	        
			if(osDocumento.esRespuestaOperacionCorrecta()) {
				Double idTipoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_documento").toString());
				Double idTipoEstadoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_estado_documento").toString());
				Double numeroVersion = (osDocumento.getRespuesta().get(0).get("numero_version") == null) ? 0 : Double.parseDouble(osDocumento.getRespuesta().get(0).get("numero_version").toString());				
				String numero = (osDocumento.getRespuesta().get(0).get("numero") == null) ? "" : osDocumento.getRespuesta().get(0).get("numero").toString();
				String clave1 = (osDocumento.getRespuesta().get(0).get("clave_1") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_1").toString();
				String clave2 = (osDocumento.getRespuesta().get(0).get("clave_2") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_2").toString();
				String clave3 = (osDocumento.getRespuesta().get(0).get("clave_3") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_3").toString();
				String descripcion = (osDocumento.getRespuesta().get(0).get("descripcion") == null) ? "" : osDocumento.getRespuesta().get(0).get("descripcion").toString();
				String registroActivo = osDocumento.getRespuesta().get(0).get("registro_activo").toString();
				Object fecha1 = (Object)osDocumento.getRespuesta().get(0).get("fecha");  
				
				Long idTipDoc = idTipoDocumento.longValue();
				Long idTipEstDoc = idTipoEstadoDocumento.longValue();
				short numeroVers = numeroVersion.shortValue();
				documento.setIdTipoDocumento(idTipDoc);
				documento.setIdTipoEstadoDocumento(idTipEstDoc);
				documento.setFecha(format.format(fecha1));
				documento.setRegistroActivo(registroActivo);
				documento.setNumero(numero);
				documento.setDescripcion(descripcion);
				documento.setClave1(clave1);
				documento.setClave2(clave2);
				documento.setClave3(clave3);
				documento.setNumeroVersion(numeroVers);
			}
	        
	        System.out.println("Aforo " + AforoOs.getRespuesta());
	        System.out.println("AforoCalzada " + AforoCalzadaOs.getRespuesta());
	        System.out.println("AforoDato " + AforoAnalisisOs.getRespuesta());
	        
	        if(AforoOs.esRespuestaOperacionCorrecta()) {
	        	List<LinkedHashMap<String,Object>> resp = new ArrayList<LinkedHashMap<String,Object>>();
	        	AforoOs.getRespuesta().get(0).put("tipo_info",(AforoOs.getRespuesta().get(0).get("origen_informacion") == null) ? "PRIMARIA" : "SECUNDARIA");
	        	AforoOs.getRespuesta().get(0).put("tipo_aforo",(AforoOs.getRespuesta().get(0).get("digital").equals("SI")) ? "DIGITAL" : "MANUAL");
	        }
	        
	        if(AforoCalzadaOs.esRespuestaOperacionCorrecta()) {
				List<LinkedHashMap<String, Object>> resps = new ArrayList<LinkedHashMap<String,Object>>();
				for(LinkedHashMap<String, Object> item : AforoCalzadaOs.getRespuesta()) {
					LinkedHashMap<String, Object> a = new LinkedHashMap<String, Object>();
					a.put("pk_id_calzada",((item.get("pk_id_calzada") == null) ? "" : item.get("pk_id_calzada").toString()));
					a.put("civ",((item.get("civ") == null) ? "" : item.get("civ").toString()));
					a.put("aledanio",((item.get("aledanio") == null ) ? "" : item.get("aledanio").toString()));
					a.put("eje_vial",((item.get("eje_vial") == null) ? "" : item.get("eje_vial").toString()));
					a.put("desde",((item.get("desde") == null) ? "" : item.get("desde").toString()));
					a.put("hasta",((item.get("hasta") == null ) ? "" : item.get("hasta").toString()));
					a.put("id_localidad",((item.get("id_localidad") == null ) ? "" : item.get("id_localidad").toString()));					
					a.put("descripcion_localidad",((item.get("descripcion_localidad") == null ) ? "" : item.get("descripcion_localidad").toString()));
					resps.add(a);
				}
				AforoCalzadaOs.setRespuesta(resps);
				respuestaM.add(AforoCalzadaOs.getRespuesta());
				
			}else {
				
				System.out.println("No tengo fallas");
			}
	        
	        if(AforoAnalisisOs.esRespuestaOperacionCorrecta()) {
				List<LinkedHashMap<String, Object>> resps = new ArrayList<LinkedHashMap<String,Object>>();
				for(LinkedHashMap<String, Object> item : AforoAnalisisOs.getRespuesta()) {
					LinkedHashMap<String, Object> a = new LinkedHashMap<String, Object>();
					/* PERIODO_DISENIO, 
					 * ANIO, 
					 * TPD, 
					 * BUSES_VAN, 
					 * BUSES_BUSETA, 
					 * BUSES_SITP_ALIMENTADORES, 
					 * CAMIONES_C2P, 
					 * CAMIONES_C2G, 
					 * CAMIONES_C3_C4, 
					 * CAMIONES_C5_C5, 
					 * VC_ACUMULADOS, 
					 * NEE_ANIOS, 
					 * NEE_ACUMULADOS
					 * */
					
					a.put("periodo_disenio",((item.get("periodo_disenio") == null) ? "" : item.get("periodo_disenio").toString()));
					a.put("tpd",((item.get("tpd") == null) ? "" : Math.ceil(Double.parseDouble(item.get("tpd").toString()))));
					a.put("buses_van",((item.get("buses_van") == null ) ? "" : Math.ceil(Double.parseDouble(item.get("buses_van").toString()))));
					a.put("buses_buseta",((item.get("buses_buseta") == null) ? "" : Math.ceil(Double.parseDouble(item.get("buses_buseta").toString()))));
					a.put("buses_sitp_alimentadores",((item.get("buses_sitp_alimentadores") == null) ? "" : Math.ceil(Double.parseDouble(item.get("buses_sitp_alimentadores").toString()))));
					a.put("camiones_c2p",((item.get("camiones_c2p") == null ) ? "" : Math.ceil(Double.parseDouble(item.get("camiones_c2p").toString()))));
					a.put("camiones_c2g",((item.get("camiones_c2g") == null ) ? "" : Math.ceil(Double.parseDouble(item.get("camiones_c2g").toString()))));					
					a.put("camiones_c3_c4",((item.get("camiones_c3_c4") == null ) ? "" : Math.ceil(Double.parseDouble(item.get("camiones_c3_c4").toString()))));
					a.put("camiones_c5_c5",((item.get("camiones_c5_c5") == null ) ? "" : Math.ceil(Double.parseDouble(item.get("camiones_c5_c5").toString()))));
					a.put("vc_acumulados",((item.get("vc_acumulados") == null ) ? "" : Math.ceil(Double.parseDouble(item.get("vc_acumulados").toString()))));					
					a.put("nee_anios",((item.get("nee_anios") == null ) ? "" : item.get("nee_anios").toString()));
					a.put("nee_acumulados",((item.get("nee_acumulados") == null ) ? "" : item.get("nee_acumulados").toString()));
					
					resps.add(a);
				}
				AforoCalzadaOs.setRespuesta(resps);
				respuestaM.add(AforoCalzadaOs.getRespuesta());
				
			}else {
				
				System.out.println("No tengo fallas");
			}
			AforoOs.setRespuestaM(respuestaM);
			
			//osMantenimentoVialEvento.setRespuesta(resp);
			
			archivoSalida = ArchivoConector.generateDoc(AforoOs, AforoOs.getOrden(), plantilla, nuevaPlantilla, 0, OE.getAnchoImagen(), OE.getLargoImagen());
			if(OE.getGuardar()) {
				if(archivoSalida.exists()) {
					documento.setUrlArchivo(archivoSalida.getAbsolutePath());
					documento.setIdTipoEstadoDocumento(1044L);
					documentoOE.setDocumento(documento);
					Gson gson = new Gson();
					String jsonDoc = gson.toJson(documentoOE);
					OEDocumento.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
			        OEDocumento.setJson(jsonDoc);
			        OEDocumento.setUsuario(OE.getUsuario());
			        
			        ObjetoSalida osDocumentoAct = Exdto.generarObjetoSalida(OEDocumento);
			        if(osDocumentoAct.esRespuestaOperacionCorrecta()) {
			        	System.out.println(" ID DOCUMENTO " + osDocumentoAct.getRespuesta().get(0));
			        }
			        
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return archivoSalida;
	}

	
	public String getURLMapa(String extent) {
		HttpURLConnection httpConn = null;                                                                                                                                                                		
		URL url = null;
		int responseCode = 0;
		String testStr = "";
        try {
			url = new URL(mapExport + extent);
			
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(this.timeoutConexionServicioMapas);
			httpConn.setReadTimeout(this.timeoutLecturaServicioMapas);
			responseCode = httpConn.getResponseCode();
			System.out.println("URL: " + url.toString());
			System.out.println("Mapa respuesta: " + responseCode);
			httpConn.disconnect();
		} catch (Exception e1) {
			if(httpConn != null) {
				httpConn.disconnect();
			}
			System.out.println("Error " + e1.getMessage());
			testStr = defaultMapa;
		}
		if (responseCode == HttpURLConnection.HTTP_OK) {
			testStr = mapExport + extent;
		} else {
			testStr = defaultMapa;
		}
		return testStr;
	}
	
	public File generarFichaMantenimientosFallos(GenerarFichaOE OE) {
		File archivoSalida =  null;
		JasperReport report = null;
		//InputStream inputStream = ReporteDTO.class.getResourceAsStream("fichaV9_report.jasper");
		ConsultaDTO fallas = new ConsultaDTO();
		ConsultaOE consultaOE = new ConsultaOE();
		ArchivoConector archivo = new ArchivoConector();
		String fileName = null;
		try {
			
			
			ExternoDTO ext = new ExternoDTO();
			ObjetoNegocioOE OENegocio = new ObjetoNegocioOE();
			AppConfig config = new AppConfig();
			String filtroReporte = config.getProp().getProperty("org.gov.umv.filtroMantenimientoFallo");
			
			String urlReporte = config.getProp().getProperty("caliope.consultarReporte");
			String json = "{\"usuario\":\""+OE.getUsuario()+"\",\"filtro\":\""+ filtroReporte +"\"}";
			OENegocio.setUrl(urlReporte);
			OENegocio.setJson(json);
			OENegocio.setUsuario(OE.getUsuario());
			
			ObjetoSalida Reporte = ext.generarObjetoSalida(OENegocio);
			
			String plantilla =  "";
			//String nuevaPlantilla = config.getProp().getProperty("org.gov.umv.Archivos") + File.separator + OE.getIdAforo() +  File.separator + OE.getIdMantenimientoVial() + "_" + OE.getIdDocumento() +".docx";
			String nuevaPlantilla = (OE.getIdDocumento()!= null ) ? config.getProp().getProperty("org.gov.umv.Documentos") + File.separator + OE.getIdDocumento() + File.separator +  OE.getIdDocumento() +".docx" : config.getProp().getProperty("org.gov.umv.Archivos") + File.separator + OE.getIdAforo() +  File.separator + OE.getIdDocumento() +".docx";
			
			
			if(Reporte.esRespuestaOperacionCorrecta()) {
				plantilla = Reporte.getRespuesta().get(0).get("url_archivo").toString();
				//plantilla = "D:\\Instaladores\\FORMATO DE REPORTE DE NECESIDADES DE MANTENIMIENTO V1.docx";
			}
			String FolderName = (OE.getIdMantenimientoVial()!= null ) ? config.getProp().getProperty("org.gov.umv.Mantenimientos") + File.separator + OE.getIdMantenimientoVial() : config.getProp().getProperty("org.gov.umv.Archivos")+ File.separator + OE.getIdAforo(); 
			File customDir = new File(FolderName);
			
			if(!customDir.exists()) {
				customDir.mkdirs();
			}
			List<LinkedHashMap<String, Object>> os = new ArrayList<LinkedHashMap<String,Object>>(); 
			
			
			
			//print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(fallasList));
			
			
			AppConfig app = new AppConfig();
	        ExternoDTO Exdto = new ExternoDTO();

			ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
	        OEEE.setUrl(app.getProp().getProperty("caliope.documento.consultar"));
	        String filtro = "id_documento = " +OE.getIdDocumento();
	        String jsonArchivoAc = "{\"usuario\":\""+OE.getUsuario()+"\", \"filtro\":\""+filtro+"\"}";
	        OEEE.setJson(jsonArchivoAc);
	        OEEE.setUsuario(OE.getUsuario());
	        
	        ObjetoSalida osDocumento = Exdto.generarObjetoSalida(OEEE);

	        ProduccionOE prodOE = new ProduccionOE();
	        
	        prodOE.setUsuario(OE.getUsuario());
	        prodOE.setFiltro("id_mantenimiento_equipo = " + OE.getIdMantenimientoEquipo());
	        
	        MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
	        
	        
	        
	        ArrayList<List<LinkedHashMap<String,Object>>> respuestaM = new ArrayList<List<LinkedHashMap<String,Object>>>();
			
	        ObjetoSalida AforoOs = dto.reporteMantenimientoFallos(prodOE);
	        
	        TabDocumento documento = new TabDocumento(OE.getIdDocumento());
			Format format =  new SimpleDateFormat("yyyy-MM-dd");
			ObjetoNegocioOE OEDocumento = new ObjetoNegocioOE();
	        DocumentoOE documentoOE = new DocumentoOE();
	        documentoOE.setUsuario(OE.getUsuario());
	        
			if(osDocumento.esRespuestaOperacionCorrecta()) {
				Double idTipoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_documento").toString());
				Double idTipoEstadoDocumento = Double.parseDouble(osDocumento.getRespuesta().get(0).get("id_tipo_estado_documento").toString());
				Double numeroVersion = (osDocumento.getRespuesta().get(0).get("numero_version") == null) ? 0 : Double.parseDouble(osDocumento.getRespuesta().get(0).get("numero_version").toString());				
				String numero = (osDocumento.getRespuesta().get(0).get("numero") == null) ? "" : osDocumento.getRespuesta().get(0).get("numero").toString();
				String clave1 = (osDocumento.getRespuesta().get(0).get("clave_1") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_1").toString();
				String clave2 = (osDocumento.getRespuesta().get(0).get("clave_2") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_2").toString();
				String clave3 = (osDocumento.getRespuesta().get(0).get("clave_3") == null) ? "" :osDocumento.getRespuesta().get(0).get("clave_3").toString();
				String descripcion = (osDocumento.getRespuesta().get(0).get("descripcion") == null) ? "" : osDocumento.getRespuesta().get(0).get("descripcion").toString();
				String registroActivo = osDocumento.getRespuesta().get(0).get("registro_activo").toString();
				Object fecha1 = (Object)osDocumento.getRespuesta().get(0).get("fecha");  
				
				Long idTipDoc = idTipoDocumento.longValue();
				Long idTipEstDoc = idTipoEstadoDocumento.longValue();
				short numeroVers = numeroVersion.shortValue();
				documento.setIdTipoDocumento(idTipDoc);
				documento.setIdTipoEstadoDocumento(idTipEstDoc);
				documento.setFecha(format.format(fecha1));
				documento.setRegistroActivo(registroActivo);
				documento.setNumero(numero);
				documento.setDescripcion(descripcion);
				documento.setClave1(clave1);
				documento.setClave2(clave2);
				documento.setClave3(clave3);
				documento.setNumeroVersion(numeroVers);
			}
	        
	        AforoOs.setRespuestaM(respuestaM);
			//osMantenimentoVialEvento.setRespuesta(resp);
			
			archivoSalida = ArchivoConector.generateDoc(AforoOs, AforoOs.getOrden(), plantilla, nuevaPlantilla, 0, OE.getAnchoImagen(), OE.getLargoImagen());
			if(OE.getGuardar()) {
				if(archivoSalida.exists()) {
					documento.setUrlArchivo(archivoSalida.getAbsolutePath());
					documento.setIdTipoEstadoDocumento(1044L);
					documentoOE.setDocumento(documento);
					Gson gson = new Gson();
					String jsonDoc = gson.toJson(documentoOE);
					OEDocumento.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
			        OEDocumento.setJson(jsonDoc);
			        OEDocumento.setUsuario(OE.getUsuario());
			        
			        ObjetoSalida osDocumentoAct = Exdto.generarObjetoSalida(OEDocumento);
			        if(osDocumentoAct.esRespuestaOperacionCorrecta()) {
			        	System.out.println(" ID DOCUMENTO " + osDocumentoAct.getRespuesta().get(0));
			        }
			        
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return archivoSalida;
	
		
	}
}
