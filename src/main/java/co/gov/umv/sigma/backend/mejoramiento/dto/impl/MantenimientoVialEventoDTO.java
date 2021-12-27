package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.entidad.TabFalla;
import co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FallaOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.UnidadMuestreoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialEventoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.MantenimientoVialEventoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialEventoDTO;
import co.gov.umv.sigma.backend.pci.CargaMapeoPci;
import co.gov.umv.sigma.backend.pci.mantenimiento.CalculoPciMantenimiento;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.MetodoPci;

public class MantenimientoVialEventoDTO implements IMantenimientoVialEventoDTO {

	@Override
	public ObjetoSalida crearMantenimientoVialEvento(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		return modelo.crearMantenimientoVialEvento(OE);
	}

	@Override
	public ObjetoSalida insertar(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida actualizarPCI(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		return modelo.actualizarPCI(OE);
	}

	@Override
	public ObjetoSalida consultarId(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();		
		String filtro = "ID_MANTENIMIENTO_VIAL_EVENTO = " + OE.getMantenimientoVialEvento().getIdMantenimientoVialEvento();
		OE.setFiltro(filtro);
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida calcularPCI(MantenimientoVialEventoOE OE) {
		System.out.println("CALCULAR PCI");
		UnidadMuestreoOE OEUM = new UnidadMuestreoOE();
		UnidadMuestreoDTO dtoUM = new UnidadMuestreoDTO();
		FallaDTO dtoF = new FallaDTO();
		MantenimientoVialEventoOE OEE = OE;
		TabUnidadMuestreo unidadM = new TabUnidadMuestreo();
		
		unidadM.setIdMantenimientoVialEvento(OE.getMantenimientoVialEvento());
		OEUM.setUnidadMuestreo(unidadM);
		ObjetoSalida OSUM = dtoUM.consultarIdMantenimiento(OEUM);
		
		if(OSUM.esRespuestaOperacionCorrecta()) {
			List<TabUnidadMuestreo> tabUnidadMuestreoList = new ArrayList<TabUnidadMuestreo>();
			for(LinkedHashMap<String , Object> map : OSUM.getRespuesta()) {
				TabUnidadMuestreo unidad = new TabUnidadMuestreo();
				unidad.setIdUnidadMuestreo(Long.parseLong(map.get("id_unidad_muestreo").toString()));
				unidad.setIdMantenimientoVialEvento(OE.getMantenimientoVialEvento());
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
					try {
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				tabUnidadMuestreoList.add(unidad);
				
			}
			OE.getMantenimientoVialEvento().setTabUnidadMuestreoList(tabUnidadMuestreoList);
			OEE = OE;
			try {
				OEE = CalculoPciMantenimiento.calcularPci(OE);
				System.out.println("PCI Mantenimiento Vial " + OEE.getMantenimientoVialEvento().getPci());
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
	
	private ObjetoSalida actualizarPCIV(MantenimientoVialEventoOE OE) throws Exception {
		ObjetoSalida os = new ObjetoSalida();
		
		UnidadMuestreoOE OEUM = new UnidadMuestreoOE();
		UnidadMuestreoDTO dtoUM = new UnidadMuestreoDTO();
		FallaDTO dtoF = new FallaDTO();
		TabUnidadMuestreo unidadM = new TabUnidadMuestreo();
		
		unidadM.setIdMantenimientoVialEvento(OE.getMantenimientoVialEvento());
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
				unidad.setIdMantenimientoVialEvento(OE.getMantenimientoVialEvento());
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
				
				Map<Long,Long> map1 = CargaMapeoPci.getMapeoTipoSuperficie(OE.getUsuario());
				Long tipoSuperficie = map1.get(OE.getMantenimientoVialEvento().getIdTipoSuperficie());
				unidad.setPci((long) MetodoPci.calcularPci(unidad, tipoSuperficie, OE.getUsuario()));
				System.out.println("PCI: " + unidad.getPci() + " Unidad Muestreo " + unidad.getIdUnidadMuestreo());
				OEE.setUnidadMuestreo(unidad);
				OEE.setUsuario(OE.getUsuario());
				ObjetoSalida oss = dtoUM.actualizarPCI(OEE);
				
				if(oss.esRespuestaOperacionCorrecta()) {
					registro.put("codError", oss.getCodError());
					registro.put("msjError", oss.getMsgError());
					registro.put("idUnidadMuestreo",oss.getRespuesta().get(0).get("id_unidad_muestreo"));
					registro.put("idMantenimientoVialEvento",OE.getMantenimientoVialEvento().getIdMantenimientoVialEvento());
					registro.put("pci",OE.getMantenimientoVialEvento().getPci());
					registro.put("pci_um", unidad.getPci());
					
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
	public ObjetoSalida actualizarCampo(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDAO modelo = new MantenimientoVialEventoDAO();
		
		String [] campos = OE.getNombreCampo().split(";");
		String [] valor = OE.getValorCampo().split(";");
		
		if(campos.length == valor.length) {
			ObjetoSalida os = new ObjetoSalida();
			List<LinkedHashMap<String , Object>> respuesta = new ArrayList<LinkedHashMap<String,Object>>();
			for(int i = 0; i < campos.length; i++) {
				ObjetoSalida oss = new ObjetoSalida();
				LinkedHashMap<String , Object> map =  new LinkedHashMap<String, Object>();
				MantenimientoVialEventoOE OEE = new MantenimientoVialEventoOE();
				OEE.setMantenimientoVialEvento(OE.getMantenimientoVialEvento());
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
