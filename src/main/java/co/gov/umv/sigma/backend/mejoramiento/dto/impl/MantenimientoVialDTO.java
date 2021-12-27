package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import co.gov.umv.sigma.backend.comun.entidad.TabDocumento;
import co.gov.umv.sigma.backend.comun.entidad.TabFalla;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialDocu;
import co.gov.umv.sigma.backend.administracion.cbo.PersonaOE;
import co.gov.umv.sigma.backend.administracion.cbo.UsuarioOE;
import co.gov.umv.sigma.backend.administracion.dto.IUsuarioDTO;
import co.gov.umv.sigma.backend.administracion.dto.impl.UsuarioDTO;
import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.comun.entidad.TabActividad;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialGestion;
import co.gov.umv.sigma.backend.comun.entidad.TabPersona;
import co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FallaOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialGestionOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.UnidadMuestreoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.MantenimientoVialDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialDocuDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialGestionDTO;
import co.gov.umv.sigma.backend.pci.mantenimiento.CalculoPciMantenimiento;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.MetodoPci;
import co.gov.umv.sigma.backend.workflow.cbo.ActividadOE;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;
import co.gov.umv.sigma.backend.workflow.cbo.GestionProcesoOE;
import co.gov.umv.sigma.backend.workflow.dao.impl.GestionProcesoDAO;
import co.gov.umv.sigma.backend.workflow.dto.IDocumentoDTO;
import co.gov.umv.sigma.backend.workflow.dto.impl.ActividadDTO;
import co.gov.umv.sigma.backend.workflow.dto.impl.DocumentoDTO;

public class MantenimientoVialDTO implements IMantenimientoVialDTO {
	private final static Logger log = Logger.getLogger(MantenimientoVialOE.class);
	@Override
	public ObjetoSalida insertar(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		OE.getMantenimientovial().setEnSeguimiento("NO");
		ObjetoSalida os = modelo.insertar(OE);
		Long idMantenimientoVial = (!os.esRespuestaOperacionCorrecta()) ? null : Long.parseLong(os.getRespuesta().get(0).get("id_mantenimiento_vial").toString());
		System.out.println("Id Mantenimiento Vial = " + idMantenimientoVial);
		OE.getMantenimientovial().setIdMantenimientoVial(idMantenimientoVial);
		String observacionDiagnostico = "Autoprogramar";
		Long idActividadDest = 1L;
		Long idEstadoPK = 18L;
		Long idActividadTransicion = 0L;
		Long cantidadDocumentosTransicion = 0L;
		
		IMantenimientoVialGestionDTO gestion = new MantenimientoVialGestionDTO();
		IUsuarioDTO usuario = new UsuarioDTO();
		IDocumentoDTO documentodto = new DocumentoDTO();
		IMantenimientoVialDocuDTO mantenimientoDocu = new MantenimientoVialDocuDTO();
		MantenimientoVialGestionOE OEGestion = new MantenimientoVialGestionOE();
		
		TabMantenimientoVialGestion tabgestion = new TabMantenimientoVialGestion();
		//Consumir valores del properties
		TabDocumento tabDocumento = new TabDocumento();
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  

		tabDocumento.setFecha(strDate);
		tabDocumento.setIdTipoDocumento(212);
		tabDocumento.setIdTipoEstadoDocumento(512);
		tabDocumento.setDescripcion("");
		tabDocumento.setUrlArchivo("");
		ObjetoSalida osFinal =  new ObjetoSalida();
		
		
		/*String filtroActividad = "id_actividad = " + idActividadDest;
		tabgestion.setIdMantenimientoVial(OE.getMantenimientovial());
		tabgestion.setObservacion(observacionDiagnostico);
		OEGestion.setMantenimientoVialGestion(tabgestion);
		OEGestion.setUsuario(OE.getUsuario());
		OEGestion.setFiltro(filtroActividad);
		//ObjetoSalida osGestionInicial = gestion.insertar(OEGestion);*/ 
		AppConfig app = new AppConfig();
		ExternoDTO dto =  new ExternoDTO();
		ObjetoNegocioOE OEEE = new ObjetoNegocioOE();
		
		UsuarioOE usuariooe =  new UsuarioOE();
		usuariooe.setFiltro("login='" + OE.getUsuario() +"'");
		usuariooe.setUsuario(OE.getUsuario());
		String filtroUsuario = "login='" + OE.getUsuario() +"'";
		
		String jsonUsuario = "{\"usuario\":\""+ OE.getUsuario() +"\",\"filtro\":\""+filtroUsuario+"\"}";
		OEEE.setUsuario(OE.getUsuario());
		OEEE.setJson(jsonUsuario);
		OEEE.setUrl(app.getProp().getProperty("caliope.consultarusuario"));
		System.out.println(filtroUsuario);
		System.out.println(jsonUsuario);
		
		//ObjetoSalida OSUsuario = usuario.consultarXFiltro(usuariooe);
		ObjetoSalida OSUsuario = dto.generarObjetoSalida(OEEE);
		//Long idTipoOrigen = (!OSUsuario.esRespuestaOperacionCorrecta()) ? null : Long.parseLong(OSUsuario.getRespuesta().get(0).get("id_tipo_origen").toString()); 
		Float idEntidad = (!OSUsuario.esRespuestaOperacionCorrecta()) ? null : Float.parseFloat(OSUsuario.getRespuesta().get(0).get("id_entidad").toString());
		Long idEnt = (!OSUsuario.esRespuestaOperacionCorrecta()) ? 0L : idEntidad.longValue();
		
		//if(idTipoOrigen == 1432) {
			if(idEntidad == 3L) { //si id entidad sec movilidad
				idActividadDest = 53L; //registrar acta diagnostico movilidad
			}else {
				idActividadDest = 43L; //registrar acta diagnostico alcaldia
			} 			
		/*}else {
			idActividadDest = 3L; //registrar acta diagnostico umv
		}*/		
		/*String filtroActividadFinal = "id_actividad = " + idActividadDest;
		OEGestion.setFiltro(filtroActividadFinal);
		
		
		ObjetoSalida osGestionFinal = gestion.insertar(OEGestion);
		
		Long idGestion = (!osGestionFinal.esRespuestaOperacionCorrecta()) ? null : Long.parseLong(osGestionFinal.getRespuesta().get(0).get("idmantenimientovialgestion").toString());
		*/
		DocumentoOE documento = new DocumentoOE();
		documento.setUsuario(OE.getUsuario());
		documento.setDocumento(tabDocumento);
		
		ObjetoNegocioOE OEDocumento = new ObjetoNegocioOE();
		OEDocumento.setUsuario(OE.getUsuario());
		OEDocumento.setUrl(app.getProp().getProperty("caliope.documento.insertar"));
		String jsonDoc = "{\"usuario\":\""+OE.getUsuario()+"\",\"documento\":{\"registroActivo\":\"SI\",\"idTipoDocumento\":212,\"idTipoEstadoDocumento\":512}}"; 
		OEDocumento.setJson(jsonDoc);
		
		ObjetoSalida osDocumento = dto.generarObjetoSalida(OEDocumento);
		
		//ObjetoSalida osDocumento = documentodto.insertar(documento);
		Float idDocumento = (!osDocumento.esRespuestaOperacionCorrecta()) ? null : Float.parseFloat(osDocumento.getRespuesta().get(0).get("id_documento").toString());
		Long idDoc = (!osDocumento.esRespuestaOperacionCorrecta()) ? null : idDocumento.longValue();
		tabDocumento.setIdDocumento(idDoc);
		MantenimientoVialDocuOE OEMantenimientoVialDocu = new MantenimientoVialDocuOE();
		TabMantenimientoVialDocu tabmantenimientovialdocu = new TabMantenimientoVialDocu();
		tabmantenimientovialdocu.setIdMantenimientoVial(OE.getMantenimientovial());
		tabmantenimientovialdocu.setIdDocumento(idDoc);
		tabmantenimientovialdocu.setRegistroActivo("SI");
		OEMantenimientoVialDocu.setMantenimientoVialDocu(tabmantenimientovialdocu);
		OEMantenimientoVialDocu.setUsuario(OE.getUsuario());
		ObjetoSalida osMantDocu = mantenimientoDocu.insertar(OEMantenimientoVialDocu);
		
		List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String,Object>>();
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		
		Long idMantenimientoVialDocu = (!osMantDocu.esRespuestaOperacionCorrecta()) ? null : Long.parseLong(osMantDocu.getRespuesta().get(0).get("id_mantenimiento_vial_docu").toString());
		
		if(os.esRespuestaOperacionCorrecta() &&  osDocumento.esRespuestaOperacionCorrecta() && osMantDocu.esRespuestaOperacionCorrecta()) {
		//if(os.esRespuestaOperacionCorrecta() && osGestionFinal.esRespuestaOperacionCorrecta() && osDocumento.esRespuestaOperacionCorrecta() && osMantDocu.esRespuestaOperacionCorrecta()) {
			//data.put("idGestion",idGestion);
			data.put("idMantenimientoVial",idMantenimientoVial);
			data.put("idDocumento",idDoc);
			data.put("idMantenimientoVialDocu",idMantenimientoVialDocu);
			respuesta.add(data);
			osFinal.setMsgError(os.getMsgError());
			osFinal.setCodError(os.getCodError());
		}else {
			osFinal.setMsgError("Error en la creacion del proceso ");
			osFinal.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
		}
		
		osFinal.setRespuesta(respuesta);
		
		return osFinal;
	}

	@Override
	public ObjetoSalida actualizar(MantenimientoVialOE OE) throws Exception {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida consultarId(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		String filtro = "ID_MANTENIMIENTO_VIAL = " + OE.getMantenimientovial().getIdMantenimientoVial();
		OE.setFiltro(filtro);
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida crearMantenimientoVial(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		
		ObjetoSalida osFinal = modelo.crearMantenimientoVial(OE);
		
		return osFinal;
		
	}

	@Override
	public ObjetoSalida calcularPCI(MantenimientoVialOE OE) {
		
		UnidadMuestreoOE OEUM = new UnidadMuestreoOE();
		UnidadMuestreoDTO dtoUM = new UnidadMuestreoDTO();
		FallaDTO dtoF = new FallaDTO();
		MantenimientoVialOE OEE = OE;
		TabUnidadMuestreo unidadM = new TabUnidadMuestreo();
		
		unidadM.setIdMantenimientoVial(OE.getMantenimientovial());
		OEUM.setUnidadMuestreo(unidadM);
		ObjetoSalida OSUM = dtoUM.consultarIdMantenimiento(OEUM);
		
		if(OSUM.esRespuestaOperacionCorrecta()) {
			List<TabUnidadMuestreo> tabUnidadMuestreoList = new ArrayList<TabUnidadMuestreo>();
		
			for(LinkedHashMap<String , Object> map : OSUM.getRespuesta()) {
				TabUnidadMuestreo unidad = new TabUnidadMuestreo();
				unidad.setIdUnidadMuestreo(Long.parseLong(map.get("id_unidad_muestreo").toString()));
				unidad.setIdMantenimientoVial(OE.getMantenimientovial());
				BigDecimal area = (map.get("area") ==  null ) ? null : new BigDecimal(Double.parseDouble(map.get("area").toString()));
				unidad.setArea(area);
				BigDecimal abscisaInicial = (map.get("abscisa_inicial") == null ) ? null : new BigDecimal(Double.parseDouble(map.get("abscisa_inicial").toString()));  
				unidad.setAbscisaInicial(abscisaInicial);
				BigDecimal abscisaFinal = (map.get("abscisa_final") == null) ? null : new BigDecimal(Double.parseDouble(map.get("abscisa_final").toString()));
				unidad.setAbscisaFinal(abscisaFinal);
				BigDecimal ancho = (map.get("ancho") == null) ? null : new BigDecimal(Double.parseDouble(  map.get("ancho").toString()));
				unidad.setAncho(ancho);
				
				FallaOE OEfalla = new FallaOE();
				TabFalla fallaM = new TabFalla();
				fallaM.setIdUnidadMuestreo(unidad);
				OEfalla.setFalla(fallaM);
				ObjetoSalida OSF = dtoF.consultarIdUnidadMuestreo(OEfalla);
				
				if(OSF.esRespuestaOperacionCorrecta()) {
					List<TabFalla> tabFallaList = new ArrayList<TabFalla>(); 
					for(LinkedHashMap<String , Object> mapum : OSF.getRespuesta()) {
						TabFalla falla = new TabFalla();
						falla.setIdFalla(Long.parseLong(mapum.get("id_falla").toString()));
						BigDecimal distancia = (mapum.get("distancia") == null ) ? null : new BigDecimal(Double.parseDouble(mapum.get("distancia").toString())); 
						falla.setDistancia(distancia);
						BigDecimal areaF = (mapum.get("area") == null) ? null : new BigDecimal(Double.parseDouble(mapum.get("area").toString()));  
						falla.setArea(areaF);
						BigDecimal anchoF = (mapum.get("ancho") == null) ? null : new BigDecimal(Double.parseDouble(mapum.get("ancho").toString()));
						falla.setAncho(anchoF);
						
						falla.setIdTipoFalla(Long.parseLong(mapum.get("id_tipo_falla").toString()));
						
						
						falla.setIdTipoSeveridad(Long.parseLong(mapum.get("id_tipo_severidad").toString()));
						BigDecimal longitudF = (mapum.get("longitud") == null) ? null : new BigDecimal(Double.parseDouble(mapum.get("longitud").toString()));  
						falla.setLongitud(longitudF);
						Long idTipoIntervencion = (mapum.get("id_tipo_intervencion") == null) ? null : Long.parseLong(mapum.get("id_tipo_intervencion").toString());
						falla.setIdTipoIntervencion(idTipoIntervencion);
						Long numeroLosas = (mapum.get("numero_losas") == null) ? null : Long.parseLong(mapum.get("numero_losas").toString()); 
						falla.setNumeroLosas(numeroLosas);
						falla.setIdUnidadMuestreo(unidad);
						tabFallaList.add(falla);
					}
					unidad.setTabFallaList(tabFallaList);
				}
				
				tabUnidadMuestreoList.add(unidad);
				
			}
			OE.getMantenimientovial().setTabUnidadMuestreoList(tabUnidadMuestreoList);
			OEE = OE;
			try {
				//OEE = CalculoPciMantenimiento.calcularPci(OE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ObjetoSalida os = new ObjetoSalida();
		try {
			os = actualizarPCIV(OEE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return os;
	}

	private ObjetoSalida actualizarPCIV(MantenimientoVialOE OE) throws Exception {
		ObjetoSalida os = new ObjetoSalida();
		
		UnidadMuestreoOE OEUM = new UnidadMuestreoOE();
		UnidadMuestreoDTO dtoUM = new UnidadMuestreoDTO();
		TabUnidadMuestreo unidadM = new TabUnidadMuestreo();
		
		unidadM.setIdMantenimientoVial(OE.getMantenimientovial());
		OEUM.setUnidadMuestreo(unidadM);
		ObjetoSalida OSUM = dtoUM.consultarIdMantenimiento(OEUM);

		ObjetoSalida OS = actualizarPCI(OE);
		if(OS.esRespuestaOperacionCorrecta() && OSUM.esRespuestaOperacionCorrecta()) {
			
			List<LinkedHashMap<String , Object>> respuesta = new ArrayList<LinkedHashMap<String,Object>>();
			for(LinkedHashMap<String , Object> map : OSUM.getRespuesta()) {
				LinkedHashMap<String , Object> registro = new LinkedHashMap<String, Object>();
				UnidadMuestreoOE OEE = new UnidadMuestreoOE();
				TabUnidadMuestreo unidad = new TabUnidadMuestreo();
				unidad.setIdUnidadMuestreo(Long.parseLong(map.get("id_unidad_muestreo").toString()));
				unidad.setIdMantenimientoVial(OE.getMantenimientovial());
				BigDecimal area = (map.get("area") ==  null ) ? null : new BigDecimal(Double.parseDouble(map.get("area").toString()));
				unidad.setArea(area);
				BigDecimal abscisaInicial = (map.get("abscisa_inicial") == null ) ? null : new BigDecimal(Double.parseDouble(map.get("abscisa_inicial").toString()));  
				unidad.setAbscisaInicial(abscisaInicial);
				BigDecimal abscisaFinal = (map.get("abscisa_final") == null) ? null : new BigDecimal(Double.parseDouble(map.get("abscisa_final").toString()));
				unidad.setAbscisaFinal(abscisaFinal);
				BigDecimal ancho = (map.get("ancho") == null) ? null : new BigDecimal(Double.parseDouble(  map.get("ancho").toString()));
				unidad.setAncho(ancho);
				unidad.setPci(OE.getMantenimientovial().getPci());
				OEE.setUnidadMuestreo(unidad);
				OEE.setUsuario(OE.getUsuario());
				ObjetoSalida oss = dtoUM.actualizarPCI(OEE);
				
				if(oss.esRespuestaOperacionCorrecta()) {
					registro.put("codError", oss.getCodError());
					registro.put("msjError", oss.getMsgError());
					registro.put("idUnidadMuestreo",oss.getRespuesta().get(0).get("id_unidad_muestreo"));
					registro.put("idMantenimientoVial",OE.getMantenimientovial().getIdMantenimientoVial());
					registro.put("pci",OE.getMantenimientovial().getPci());
					
					
				}
				else {
					registro.put("codError", oss.getCodError());
					registro.put("msjError", oss.getMsgError());
				}
				respuesta.add(registro);
			}
			os.setRespuesta(respuesta);
			os.setCodError(OS.getCodError());
			os.setMsgError(OS.getMsgError());
		}
		return os;
	}

	@Override
	public ObjetoSalida actualizarPCI(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		return modelo.actualizarPCI(OE);
	}

	@Override
	public ObjetoSalida actualizarCampo(MantenimientoVialOE OE) {
		IMantenimientoVialDAO modelo = new MantenimientoVialDAO();
		String [] campos = OE.getNombreCampo().split(";");
		String [] valor = OE.getValorCampo().split(";");
		
		if(campos.length == valor.length) {
			ObjetoSalida os = new ObjetoSalida();
			List<LinkedHashMap<String , Object>> respuesta = new ArrayList<LinkedHashMap<String,Object>>();
			for(int i = 0; i < campos.length; i++) {
				ObjetoSalida oss = new ObjetoSalida();
				LinkedHashMap<String , Object> map =  new LinkedHashMap<String, Object>();
				MantenimientoVialOE OEE = new MantenimientoVialOE();
				OEE.setMantenimientovial(OE.getMantenimientovial());
				OEE.setUsuario(OE.getUsuario());
				OEE.setNombreCampo(campos[i]);
				OEE.setValorCampo(valor[i]);
				
				oss = modelo.actualizarCampo(OEE);
				if(oss.esRespuestaOperacionCorrecta()) {
					map.put("respuesta", oss);
					map.put("MsjError", oss.getMsgError());
					map.put("codError", oss.getCodError());					
					
				}else {
					map.put("MsjError", oss.getMsgError());
					map.put("codError", oss.getCodError());
				}
				respuesta.add(map);
			}
			os.setRespuesta(respuesta);
			return os;
		}else {
			return new ObjetoSalida();
		}

	}
}
