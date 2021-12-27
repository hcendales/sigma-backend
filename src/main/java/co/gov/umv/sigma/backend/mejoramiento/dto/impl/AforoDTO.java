package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dto.impl.DominioDTO;
import co.gov.umv.sigma.backend.comun.entidad.TabAforo;
import co.gov.umv.sigma.backend.comun.entidad.TabAforo2;
import co.gov.umv.sigma.backend.comun.entidad.TabAforoAnalisis;
import co.gov.umv.sigma.backend.comun.entidad.TabAforoCalzada;
import co.gov.umv.sigma.backend.comun.entidad.TabAforoDato;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IAforoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.AforoAnalisisDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.AforoCalzadaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.AforoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.AforoDatoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IAforoDTO;


public class AforoDTO implements IAforoDTO {

	IAforoDAO modelo = new AforoDAO();
	IAforoDAO modeloDetalle = new AforoDatoDAO();
	IAforoDAO modeloDetalleCalzada = new AforoCalzadaDAO();
	IAforoDAO modeloDetalleAnalisis = new AforoAnalisisDAO();//*/
	DominioDTO dominios = new DominioDTO();
	
	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		
		ObjetoSalida aforoOS = modelo.insertar(OE);
		if(aforoOS.esRespuestaOperacionCorrecta()) {
			Long idAforo = Long.parseLong(aforoOS.getRespuesta().get(0).get("id_aforo").toString());
			OE.getAforo().setIdAforo(idAforo);
			if(OE.getAforo().getTabAforoDatoList() != null) {								
				for(TabAforoDato it : OE.getAforo().getTabAforoDatoList()) {
					it.setIdAforo(OE.getAforo());
					OE.setAforodato(it);
					ObjetoSalida AforoDatoOS = modeloDetalle.insertar(OE);
					if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
						LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
						item.put("id_aforo", idAforo);
						item.put("id_aforo_dato", AforoDatoOS.getRespuesta().get(0).get("id_aforo_dato"));
						aforoOS.getRespuesta().add(item);
					}
					else {
						aforoOS.setMsgError(aforoOS.getMsgError()+"<br>" + AforoDatoOS.getMsgError());
					}
				}
			}
			
			if(OE.getAforo().getTabAforoCalzadaList() != null) {
				System.out.println("Ingrese a Aforo Calzada ");
				for(TabAforoCalzada it : OE.getAforo().getTabAforoCalzadaList()) {
					it.setIdAforo(OE.getAforo());
					OE.setAforocalzada(it);
					ObjetoSalida AforoDatoOS = modeloDetalleCalzada.insertar(OE);
					if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
						LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
						item.put("id_aforo", idAforo);						
						item.put("id_aforo_calzada", AforoDatoOS.getRespuesta().get(0).get("id_aforo_calzada"));
						aforoOS.getRespuesta().add(item);
					}else {
						aforoOS.setMsgError(aforoOS.getMsgError()+"<br>" + AforoDatoOS.getMsgError());
					}
				}
			}
			
			if(OE.getAforo().getTabAforoAnalisisList() != null) {
				for(TabAforoAnalisis it : OE.getAforo().getTabAforoAnalisisList()) {
					it.setIdAforo(OE.getAforo());
					OE.setAforoanalisis(it);
					ObjetoSalida AforoDatoOS = modeloDetalleAnalisis.insertar(OE);
					if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
						LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
						item.put("id_aforo", idAforo);						
						item.put("id_aforo_analisis", AforoDatoOS.getRespuesta().get(0).get("id_aforo_analisis"));
						aforoOS.getRespuesta().add(item);
					}else {
						aforoOS.setMsgError(aforoOS.getMsgError()+"<br>" + AforoDatoOS.getMsgError());
					}
				}
			}//*/
			
			
		}
		
		return aforoOS;
	}

	@Override
	public ObjetoSalida actualizar(AforoOE OE) {
		ObjetoSalida aforoOS = modelo.actualizar(OE);
		if(aforoOS.esRespuestaOperacionCorrecta()) {
			Long idAforo = Long.parseLong(aforoOS.getRespuesta().get(0).get("id_aforo").toString());
			OE.getAforo().setIdAforo(idAforo);
			if(OE.getAforo().getTabAforoDatoList() != null) {								
				for(TabAforoDato it : OE.getAforo().getTabAforoDatoList()) {
					if(it.getIdAforoDato() != null) {
						it.setIdAforo(OE.getAforo());
						OE.setAforodato(it);
						ObjetoSalida AforoDatoOS = modeloDetalle.actualizar(OE);
						if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
							LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
							item.put("id_aforo_dato", AforoDatoOS.getRespuesta().get(0).get("id_aforo_dato"));
							aforoOS.getRespuesta().add(item);
						}

					}else {
						it.setIdAforo(OE.getAforo());
						OE.setAforodato(it);
						ObjetoSalida AforoDatoOS = modeloDetalle.insertar(OE);
						if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
							LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
							item.put("id_aforo_dato", AforoDatoOS.getRespuesta().get(0).get("id_aforo_dato"));
							aforoOS.getRespuesta().add(item);
						}

					}
									}
			}
			
			if(OE.getAforo().getTabAforoCalzadaList() != null) {
				for(TabAforoCalzada it : OE.getAforo().getTabAforoCalzadaList()) {
					if(it.getIdAforoCalzada() != null) {
						it.setIdAforo(OE.getAforo());
						OE.setAforocalzada(it);
						ObjetoSalida AforoDatoOS = modeloDetalleCalzada.actualizar(OE);
						if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
							LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
							item.put("id_aforo_calzada", AforoDatoOS.getRespuesta().get(0).get("id_aforo_calzada"));
							aforoOS.getRespuesta().add(item);
						}
					}
					else {
						it.setIdAforo(OE.getAforo());
						OE.setAforocalzada(it);
						ObjetoSalida AforoDatoOS = modeloDetalleCalzada.insertar(OE);
						if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
							LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
							item.put("id_aforo_calzada", AforoDatoOS.getRespuesta().get(0).get("id_aforo_calzada"));
							aforoOS.getRespuesta().add(item);
						}
					}
				}
			}
			
			if(OE.getAforo().getTabAforoAnalisisList() != null) {
				for(TabAforoAnalisis it : OE.getAforo().getTabAforoAnalisisList()) {
					if(it.getIdAforoAnalisis() != null) {
						it.setIdAforo(OE.getAforo());
						OE.setAforoanalisis(it);
						ObjetoSalida AforoDatoOS = modeloDetalleAnalisis.actualizar(OE);
						if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
							LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
							item.put("id_aforo_analisis", AforoDatoOS.getRespuesta().get(0).get("id_aforo_analisis"));
							aforoOS.getRespuesta().add(item);
						}
					}
					else {
						it.setIdAforo(OE.getAforo());
						OE.setAforoanalisis(it);
						ObjetoSalida AforoDatoOS = modeloDetalleAnalisis.insertar(OE);
						if(AforoDatoOS.esRespuestaOperacionCorrecta()) {
							LinkedHashMap<String, Object> item = new LinkedHashMap<String, Object>();
							
							item.put("id_aforo_analisis", AforoDatoOS.getRespuesta().get(0).get("id_aforo_analisis"));
							aforoOS.getRespuesta().add(item);
						}
					}
					
				}
			}//*/
			
			
		}
		
		return aforoOS;
		
	}

	@Override
	public ObjetoSalida eliminar(AforoOE OE) {
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(AforoOE OE) {
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida nuevoAforo(AforoOE OE) {
		
		TabAforo2 aforo = OE.getAforo();
		
		if(aforo.getTasaCrecimientoR() == null || aforo.getTasaCrecimientoR().intValue() == 0) {
			//List <GenericItemDomain> tasas = this.callProceduresDAO.consultarDominios("UMV_LOCALIDAD_TASA_DE_CRECIMIENTO", aforo.getAuditoriausuario());
			ObjetoSalida tasas = dominios.consultarDominios(OE.getUsuario(), 1004); 
			String idLocalidad = aforo.getTabAforoCalzadaList().iterator().next().getIdLocalidad().toString();
			idLocalidad =idLocalidad.substring(idLocalidad.length()-2); 
			for(LinkedHashMap<String,Object> a: tasas.getRespuesta()) {
				String valor = (tasas.esRespuestaOperacionCorrecta()) ? a.get("valor").toString() : "";
				String descripcion = (tasas.esRespuestaOperacionCorrecta()) ? a.get("descripcion").toString() : "";
				if(valor.equals(idLocalidad)) {
					aforo.setTasaCrecimientoR(new BigDecimal(Double.valueOf(descripcion)/100));
					break;
				}
			}
		}
		
		//ObjetoSalida configuraciones = dominios.consultarDominios("CONFIGURACIONES", aforo.getAuditoriausuario());
		ObjetoSalida configuraciones = dominios.consultarDominios(OE.getUsuario(), 1000);
		if(aforo.getAnalisisReferencias() == null) {
			
			String referencias = "";
			for(LinkedHashMap<String,Object> a: configuraciones.getRespuesta()) {
				String valor = (configuraciones.esRespuestaOperacionCorrecta()) ? a.get("valor").toString() : "";
				String descripcion = (configuraciones.esRespuestaOperacionCorrecta()) ? a.get("descripcion").toString() : "";
				
				if(valor.contains("AFORO_REFERENCIA")) {
					referencias += descripcion+ "\n";
				}
			}
			aforo.setAnalisisReferencias(referencias);
		}
		
		for(LinkedHashMap<String,Object> a: configuraciones.getRespuesta()) {
			String valor = (configuraciones.esRespuestaOperacionCorrecta()) ? a.get("valor").toString() : "";
			String descripcion = (configuraciones.esRespuestaOperacionCorrecta()) ? a.get("descripcion").toString() : "";
			
			if(valor.contains("AFORO_FD_")) {
				BigDecimal valorFactorDano = new BigDecimal(Double.valueOf(descripcion)/100);
				switch(valor) {
					case "AFORO_FD_SITP":
						aforo.setFdSitpAlimentadores(valorFactorDano);
					case "AFORO_FD_VAN":
						aforo.setFdVan(valorFactorDano); break;
					case "AFORO_FD_BUSES":
						aforo.setFdBusesBusetas(valorFactorDano); break;
					case "AFORO_FD_C2P":
						aforo.setFdC2p(valorFactorDano); break;
					case "AFORO_FD_C2G":
						aforo.setFdC2g(valorFactorDano); break;
					case "AFORO_FD_C3C4":
						aforo.setFdC3C4(valorFactorDano); break;
					case "AFORO_FD_C5":
						aforo.setFdC5C5(valorFactorDano); break;
				}
			}else
				if(valor.equals("AFORO_FAC_DIR") && aforo.getFactorDireccionalFd() == null) {
					aforo.setFactorDireccionalFd(new BigDecimal(Double.valueOf(descripcion)/100));
				}else
				if(valor.equals("AFORO_FAC_DIS_CARR") && aforo.getFactorDistribucionCarrilFdc() == null) {
					aforo.setFactorDistribucionCarrilFdc(new BigDecimal(Double.valueOf(descripcion)/100));
				}
		}
		
		OE.setAforo(aforo);
		System.out.println("Aforo " + aforo);
		// */
		return insertar(OE);
	}

	@Override
	public ObjetoSalida analisisAforo(AforoOE OE) {
		AforoDAO aforo = new AforoDAO();
		return aforo.calcularAnalisisTransito(OE);
	}
	
}
