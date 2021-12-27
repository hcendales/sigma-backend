package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionRecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.GestionRecursoDAO;

public class GestionRecursoDTO {

	GestionRecursoDAO dao = new GestionRecursoDAO();

	public ObjetoSalida listarDisponibilidadRecurso(RecursoOE OE)
	{
		return dao.listarDisponibilidadRecurso(OE);
	}

	public ObjetoSalida listarDisponibilidadxTipoRecurso(RecursoOE OE)
	{
		return dao.listarDisponibilidadxTipoRecurso(OE);
	}

	public ObjetoSalida crearRecursoConDisponibilidad(RecursoOE OE) 
	{
		return dao.crearRecursoConDisponibilidad(OE);
	}
	

	public ObjetoSalida relacionaryAsignarRecursoOtraActividad(GestionRecursoOE OE)
	{
		return dao.relacionaryAsignarRecursoOtraActividad(OE);
		
	}
	
	public ObjetoSalida desasociarRecursoOtraActividad(GestionRecursoOE OE)
	{
		return dao.desasociarRecursoOtraActividad(OE);
		
	}
	

	public ObjetoSalida ListarEquiposDisponibles(GestionRecursoOE OE) {
		return dao.ListarEquiposDisponibles(OE);
	}

	public ObjetoSalida listarRelacionEquipos(GestionRecursoOE OE) {
		return dao.listarRelacionEquipos(OE);
	}
	

	public ObjetoSalida listarRecursosRelacionadosParaAsignacion(GestionRecursoOE OE) {
		return dao.listarRecursosRelacionadosParaAsignacion(OE);
	}

	public ObjetoSalida buscarFranjasEquiposPersonas(GestionRecursoOE OE) {
		return dao.buscarFranjasEquiposPersonas(OE);
	}

	public ObjetoSalida crearRecurso(RecursoOE OE) {
		return dao.crearRecurso(OE);
	}

	public ObjetoSalida actualizarRecurso(RecursoOE OE) {
		return dao.actualizarRecurso(OE);
	}

	public ObjetoSalida insertarNovedad(RecursoOE OE) {
		OE.setEliminar(0L);
		OE.getNovedad().setIdRecursoNovedad(0L);
		return dao.gestionarNovedad(OE);
	}

	public ObjetoSalida actualizarNovedad(RecursoOE OE) {
		OE.setEliminar(0L);
		return dao.gestionarNovedad(OE);
	}

	public ObjetoSalida eliminarNovedad(RecursoOE OE) {
		OE.setEliminar(1L);
		return dao.gestionarNovedad(OE);
		
	}

	public ObjetoSalida listarDisponibilidadTotalXTipo(RecursoOE OE) {
		return dao.listarDisponibilidadTotalXTipo(OE);
	}

}
