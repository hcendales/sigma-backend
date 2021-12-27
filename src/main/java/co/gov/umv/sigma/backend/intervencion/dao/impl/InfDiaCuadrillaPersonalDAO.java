package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.InformacionDiariaCuadrillaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class InfDiaCuadrillaPersonalDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_infdiacua_personal";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_infdiacua_personal        IN   tab_infdiacua_personal.id_infdiacua_personal%TYPE,
           p_id_informe_diario_cuadrilla  IN   tab_infdiacua_personal.id_informe_diario_cuadrilla%TYPE,
           p_id_tipo_horario              IN   tab_infdiacua_personal.id_tipo_horario%TYPE,
           p_id_persona                   IN   tab_infdiacua_personal.id_persona%TYPE,
           p_id_tipo_categoria_persona    IN   tab_infdiacua_personal.id_tipo_categoria_persona%TYPE,
           p_id_tipo_cargo                IN   tab_infdiacua_personal.id_tipo_cargo%TYPE,
           p_id_tipo_rol                  IN   tab_infdiacua_personal.id_tipo_rol%TYPE,
           p_horario_llegada              IN   tab_infdiacua_personal.horario_llegada%TYPE,
           p_horario_salida               IN   tab_infdiacua_personal.horario_salida%TYPE,
           p_observaciones                IN   tab_infdiacua_personal.observaciones%TYPE,
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_horario", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoHorario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_categoria_persona",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoCategoriaPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_rol",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_horario_llegada",obtenerFecha(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getHorarioLlegada()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_horario_salida", obtenerFecha(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getHorarioSalida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_personal", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdInfdiacuaPersonal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_horario", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoHorario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_categoria_persona",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoCategoriaPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_rol",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_horario_llegada",obtenerFecha(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getHorarioLlegada()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_horario_salida", obtenerFecha(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getHorarioSalida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_personal", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaPersonal().getIdInfdiacuaPersonal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

}
