package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import java.util.HashMap;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.entidad.TabRecursoDisponibleRelacionado;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionRecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.GestionRecursoDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IGestionRecursoService;

public class GestionRecursoService implements IGestionRecursoService{

	GestionRecursoDTO dto = new GestionRecursoDTO();
	
	@Override
	public Response asignarRecursoOtraActividad(GestionRecursoOE OE) 
	{
		ObjetoSalida os = dto.relacionaryAsignarRecursoOtraActividad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response desasociarRecursoOtraActividad(GestionRecursoOE OE) 
	{
		ObjetoSalida os = dto.desasociarRecursoOtraActividad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	@Override
	public Response ListarEquiposDisponibles(GestionRecursoOE OE) 
	{
		ObjetoSalida os = dto.ListarEquiposDisponibles(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	@Override
	public Response listarRelacionEquipos(GestionRecursoOE OE) 
	{
		ObjetoSalida os = dto.listarRelacionEquipos(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response listarRecursosRelacionadosParaAsignacion(GestionRecursoOE OE) {
		ObjetoSalida os = dto.listarRecursosRelacionadosParaAsignacion(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response asignarMasivaRecursoOtraActividad(GestionRecursoOE OE) 
	{
		ObjetoSalida os = dto.buscarFranjasEquiposPersonas(OE);
		
		
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			if(OE.getRelacion() == null)
				OE.setRelacion(new TabRecursoDisponibleRelacionado());
		
			int index=0;
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				Long idDispEquipo =  Long.parseLong(os.getRespuesta().get(index).get("id_recurso_disponibilidad").toString());
				Long idDispPersona =  Long.parseLong(os.getRespuesta().get(index).get("id_recurso_disponibilidad_relacionado").toString());
				Long idPersona =  Long.parseLong(os.getRespuesta().get(index).get("id_persona").toString());
				
				OE.getRelacion().setIdPersona(idPersona) ;
				OE.getRelacion().setIdRecursoDisponibilidad(idDispEquipo);
				OE.getRelacion().setIdRecursoDisponibilidadRelacionado(idDispPersona);
				OE.getRelacion().setIdTipoAsignacion(1277L);
				
				dto.relacionaryAsignarRecursoOtraActividad(OE);
				
				index++;
			}
		}
		
		return Response.status(Response.Status.OK).entity(os).build();
		
	}


	
}
