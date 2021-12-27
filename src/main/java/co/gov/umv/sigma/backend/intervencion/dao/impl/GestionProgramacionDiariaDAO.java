package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.ProgramacionDiariaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class GestionProgramacionDiariaDAO  extends CrudDAO   
{
	
	private final static String PACKAGE = "PKG_GESTION_PROGRAMACION_DIARIA";
	
	public ObjetoSalida eliminarProgDiaria(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
    	parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		
        return ejecutar(OE, PACKAGE+".prc_eliminarProgDiaria", parametros);
	}

	public ObjetoSalida gestionarProgDiaria(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	    	
		parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha", obtenerFecha( ((ProgramacionDiariaOE)OE).getProgDiaria().getFecha() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_jornada", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdTipoJornada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_programacion", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdTipoEstadoProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora_trabajo_desde", ((ProgramacionDiariaOE)OE).getProgDiaria().getHoraTrabajoDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_trabajo_hasta", ((ProgramacionDiariaOE)OE).getProgDiaria().getHoraTrabajoHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_persona_elabora", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdPersonaElabora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_revisa", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdPersonaRevisa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_aprueba", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdPersonaAprueba(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((ProgramacionDiariaOE)OE).getProgDiaria().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

		return ejecutar(OE, PACKAGE+".prc_gestionarProgDiaria", parametros);
	}

	public ObjetoSalida gestionarPersonal(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_progdiaria_personal", ((ProgramacionDiariaOE)OE).getPersonal().getIdProgdiariaPersonal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", ((ProgramacionDiariaOE)OE).getPersonal().getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_rol", ((ProgramacionDiariaOE)OE).getPersonal().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", ((ProgramacionDiariaOE)OE).getPersonal().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad", ((ProgramacionDiariaOE)OE).getPersonal().getCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona", ((ProgramacionDiariaOE)OE).getPersonal().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_gestionPersonal", parametros);
	}

	public ObjetoSalida gestionarMaterial(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_progdiaria_material", ((ProgramacionDiariaOE)OE).getMaterial().getIdProgdiariaMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", ((ProgramacionDiariaOE)OE).getMaterial().getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((ProgramacionDiariaOE)OE).getMaterial().getIdTipoMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material", ((ProgramacionDiariaOE)OE).getMaterial().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", ((ProgramacionDiariaOE)OE).getMaterial().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad", ((ProgramacionDiariaOE)OE).getMaterial().getCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_unidad_medida", ((ProgramacionDiariaOE)OE).getMaterial().getIdTipoUnidadMedida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora", ((ProgramacionDiariaOE)OE).getMaterial().getHora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_unidadejecutora", ((ProgramacionDiariaOE)OE).getMaterial().getIdTipoUnidadEjecutora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_gestionMaterial", parametros);
	
	}

	public ObjetoSalida gestionarMaquinaria(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_progdiaria_maquinaria", ((ProgramacionDiariaOE)OE).getMaquinaria().getIdProgdiariaMaquinaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", ((ProgramacionDiariaOE)OE).getMaquinaria().getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_equipo", ((ProgramacionDiariaOE)OE).getMaquinaria().getIdTipoClaseEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_equipo", ((ProgramacionDiariaOE)OE).getMaquinaria().getIdTipoEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", ((ProgramacionDiariaOE)OE).getMaquinaria().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad", ((ProgramacionDiariaOE)OE).getMaquinaria().getCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora", ((ProgramacionDiariaOE)OE).getMaquinaria().getHora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_movil", ((ProgramacionDiariaOE)OE).getMaquinaria().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_unidadejecutora", ((ProgramacionDiariaOE)OE).getMaquinaria().getIdTipoUnidadEjecutora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_gestionMaquinaria", parametros);
	}

	public ObjetoSalida listarProgramacionesDiarias(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

		return ejecutar(OE, PACKAGE+".prc_ListarProgDiarias", parametros);
	}
	
	public ObjetoSalida copiarProgDiaria(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_mv", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha", obtenerFecha( ((ProgramacionDiariaOE)OE).getProgDiaria().getFecha() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_jornada", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdTipoJornada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora_desde", ((ProgramacionDiariaOE)OE).getProgDiaria().getHoraTrabajoDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_hasta", ((ProgramacionDiariaOE)OE).getProgDiaria().getHoraTrabajoHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_usuario", ((ProgramacionDiariaOE)OE).getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	
		parametros.add(new SentenciaParametroDAO("p_id_persona", ((ProgramacionDiariaOE)OE).getProgDiaria().getIdPersonaElabora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((ProgramacionDiariaOE)OE).getProgDiaria().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_copiarProgDiaria", parametros);
	}
	
	public ObjetoSalida consultarUE(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarUE");
	}
}
