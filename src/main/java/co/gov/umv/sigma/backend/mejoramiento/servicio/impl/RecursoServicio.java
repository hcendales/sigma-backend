package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import java.util.HashMap;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.entidad.TabEquipo;
import co.gov.umv.sigma.backend.comun.entidad.TabPersona;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FranjaHorariaOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AsignacionDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.DisponibilidadDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.EquipoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.GestionRecursoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.NovedadDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.PersonaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.RecursoDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IRecursoServicio;

public class RecursoServicio  implements IRecursoServicio
{
	@Override
	public Response insertar(RecursoOE OE)
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.crearRecurso(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(RecursoOE OE)
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.actualizarRecurso(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(RecursoOE OE)
	{
		ICrudDTO dto = new RecursoDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(RecursoOE OE)
	{
		ICrudDTO dto = new RecursoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	/*     ASIGNACION    */
	@Override
	public Response insertarAsignacion(RecursoOE OE)
	{
		ICrudDTO dto = new AsignacionDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizarAsignacion(RecursoOE OE)
	{
		ICrudDTO dto = new AsignacionDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminarAsignacion(RecursoOE OE)
	{
		ICrudDTO dto = new AsignacionDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltroAsignacion(RecursoOE OE)
	{
		ICrudDTO dto = new AsignacionDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	/*     DISPONIBILIDAD    */
	@Override
	public Response insertarDisponibilidad(RecursoOE OE)
	{
		ICrudDTO dto = new DisponibilidadDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizarDisponibilidad(RecursoOE OE)
	{
		ICrudDTO dto = new DisponibilidadDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminarDisponibilidad(RecursoOE OE)
	{
		ICrudDTO dto = new DisponibilidadDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltroDisponibilidad(RecursoOE OE)
	{
		ICrudDTO dto = new DisponibilidadDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response insertarNovedad(RecursoOE OE) 
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.insertarNovedad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarNovedad(RecursoOE OE)
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.actualizarNovedad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarNovedad(RecursoOE OE) {
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.eliminarNovedad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroNovedad(RecursoOE OE) {
		ICrudDTO dto = new NovedadDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response generarFranjas(FranjaHorariaOE OE)
	{
		RecursoDTO dto = new RecursoDTO();
		ObjetoSalida os = dto.generarFranjas(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response eliminarFranjas(FranjaHorariaOE OE)
	{
		RecursoDTO dto = new RecursoDTO();
		ObjetoSalida os = dto.eliminarFranjas(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response listarDisponibilidadRecurso(RecursoOE OE)
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.listarDisponibilidadRecurso(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	public Response listarDisponibilidadxTipoRecurso(RecursoOE OE)
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.listarDisponibilidadxTipoRecurso(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response crearRecursoConDisponibilidad(RecursoOE OE) 
	{
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.crearRecursoConDisponibilidad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response crearRecursoConDisponibilidadEq(RecursoOE OE) 
	{
		EquipoDTO dto = new EquipoDTO();
		//OE.setFiltro("DESCRIPCION_CLASE_EQUIPO = 'Vehículo Liviano' and id_equipo not in( SELECT id_equipo FROM TAB_RECURSO WHERE id_equipo IS NOT null) ");
		ObjetoSalida os = dto.consultarXFiltro(OE);
		
		if(OE.getRecurso().getEquipo() == null)
		{
			OE.getRecurso().setEquipo(new TabEquipo());
		}
		
		GestionRecursoDTO dto1 = new GestionRecursoDTO();
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			int index=0;
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				Long id =  Long.parseLong(os.getRespuesta().get(index).get("id_equipo").toString());
				OE.getRecurso().getEquipo().setIdEquipo(id);
				System.out.println("procesando: " + id);
				ObjetoSalida os1 = dto1.crearRecursoConDisponibilidad(OE);	
				index++;
			}
		}
		
		os.setCodError(CodError.OPERACION_CORRECTA);
		
		return Response.status(Response.Status.OK).entity(os).build();
		
	}
	
	public Response crearRecursoConDisponibilidadPe(RecursoOE OE) 
	{
		PersonaDTO dto = new PersonaDTO();
		//OE.setFiltro("id_persona not in( SELECT id_persona FROM TAB_RECURSO WHERE id_persona IS NOT null) ");
		ObjetoSalida os = dto.consultarXFiltro(OE);
		
		
		if(OE.getRecurso().getPersona() == null)
		{
			OE.getRecurso().setPersona(new TabPersona());
		}
	
		
		GestionRecursoDTO dto1 = new GestionRecursoDTO();
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			int index=0;
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				Long id =  Long.parseLong(os.getRespuesta().get(index).get("id_persona").toString());
				OE.getRecurso().getPersona().setIdPersona(id);
				System.out.println("procesando: " + id);
				ObjetoSalida os1 = dto1.crearRecursoConDisponibilidad(OE);	
				index++;
			}
		}
		
		os.setCodError(CodError.OPERACION_CORRECTA);
		
		return Response.status(Response.Status.OK).entity(os).build();
	}

	public Response crearFranjasMasiva(FranjaHorariaOE OE) 
	{
		RecursoDTO dto = new RecursoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
	
		
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			int index=0;
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				Long id =  Long.parseLong(os.getRespuesta().get(index).get("id_recurso").toString());
				OE.setIdRecurso(id);
				System.out.println("procesando: " + id);
				ObjetoSalida os1 = dto.generarFranjas(OE);
				index++;
			}
		}
		
		os.setCodError(CodError.OPERACION_CORRECTA);
		
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

	@Override
	public Response consultarFranjas(FranjaHorariaOE OE) {
		RecursoDTO dto = new RecursoDTO();
		ObjetoSalida os = dto.consultarFranjas(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response listarDisponibilidadTotalXTipo(RecursoOE OE) {
		GestionRecursoDTO dto = new GestionRecursoDTO();
		ObjetoSalida os = dto.listarDisponibilidadTotalXTipo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
}



