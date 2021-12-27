package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import java.util.Calendar;
import java.util.Date;

import co.gov.umv.sigma.backend.administracion.cbo.PersonaOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.entidad.TabActividad;
import co.gov.umv.sigma.backend.comun.entidad.TabPersona;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialGestionOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialGestionDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.MantenimientoVialGestionDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialGestionDTO;
import co.gov.umv.sigma.backend.workflow.cbo.ActividadOE;
import co.gov.umv.sigma.backend.workflow.cbo.GestionProcesoOE;
import co.gov.umv.sigma.backend.workflow.dao.impl.GestionProcesoDAO;
import co.gov.umv.sigma.backend.workflow.dto.impl.ActividadDTO;

public class MantenimientoVialGestionDTO implements IMantenimientoVialGestionDTO {

	@Override
	public ObjetoSalida insertar(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDAO modelo = new MantenimientoVialGestionDAO();
		
		ActividadDTO actividaddto = new ActividadDTO();
		GestionProcesoDAO gestionDAO = new GestionProcesoDAO();
		PersonaOE persona = new PersonaOE();
		ActividadOE actividadoe = new ActividadOE();
		String filtropersona = "lower(usuario) = lower('" + OE.getUsuario() + "')";
		persona.setFiltro(filtropersona);
		persona.setUsuario(OE.getUsuario());
		actividadoe.setFiltro(OE.getFiltro());
		actividadoe.setUsuario(OE.getUsuario());
		PersonaDTO personaDTO = new PersonaDTO();
		ObjetoSalida osPersona = personaDTO.consultarXFiltro(persona);
		ObjetoSalida osActividad = actividaddto.consultarXFiltro(actividadoe);
		
		Long idPersona = (!osPersona.esRespuestaOperacionCorrecta()) ? 0L : Long.parseLong(osPersona.getRespuesta().get(0).get("id_persona").toString());
		Long idActividad = (!osActividad.esRespuestaOperacionCorrecta()) ? 0L : Long.parseLong(osActividad.getRespuesta().get(0).get("id_actividad").toString()); 
		
		TabPersona tabPersona = new TabPersona(idPersona);
		OE.getMantenimientoVialGestion().setIdPersona(tabPersona);
		OE.getMantenimientoVialGestion().setFechaAsignacion(new Date());
		TabActividad actividad = new TabActividad(idActividad);
		
		GestionProcesoOE gestionproceso = new GestionProcesoOE();
		gestionproceso.setIdActividad(idActividad);
		gestionproceso.setIdTipoOrigen(OE.getMantenimientoVialGestion().getIdMantenimientoVial().getIdTipoOrigen());
		ObjetoSalida osGestionProceso = gestionDAO.plazoActividad(gestionproceso);
		Long dias = (!osGestionProceso.esRespuestaOperacionCorrecta()) ? 0L : Long.parseLong(osGestionProceso.getRespuesta().get(0).get("valor").toString()); 
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, dias.intValue());  
		System.out.println("Dias " + dias);
		OE.getMantenimientoVialGestion().setFechaVencimiento(c.getTime());
		//OE.getMantenimientoVialGestion().setIdTipoEstadoGestion(281L);
		OE.getMantenimientoVialGestion().setIdActividad(actividad);
		String observacionGestion = OE.getMantenimientoVialGestion().getObservacion();
		if (idActividad == 1L) {
			OE.getMantenimientoVialGestion().setFechaFin(new Date());		// CREA ESTADO DE LA GESTION EN SIN INICIAR
			OE.getMantenimientoVialGestion().setIdTipoEstadoGestion(283);
		} else {
			OE.getMantenimientoVialGestion().setIdTipoEstadoGestion(281);
		}
		if (observacionGestion != null || !observacionGestion.contains("undefined") || observacionGestion.equals("undefined")) {
			OE.getMantenimientoVialGestion().setObservacion(observacionGestion + " CREACION DE GESTION");
		} else {
			OE.getMantenimientoVialGestion().setObservacion(null + " CREACION DE GESTION");
		}
		
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDAO modelo = new MantenimientoVialGestionDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDAO modelo = new MantenimientoVialGestionDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDAO modelo = new MantenimientoVialGestionDAO();
		return modelo.consultarXFiltro(OE);
	}


}
