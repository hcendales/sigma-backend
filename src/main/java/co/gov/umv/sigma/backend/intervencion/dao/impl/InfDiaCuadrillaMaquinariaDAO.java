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

public class InfDiaCuadrillaMaquinariaDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_infdiacua_maquinaria";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_infdiacua_maquinaria      IN   tab_infdiacua_maquinaria.id_infdiacua_maquinaria%TYPE,
        p_id_informe_diario_cuadrilla  IN   tab_infdiacua_maquinaria.id_informe_diario_cuadrilla%TYPE,
        p_id_equipo                    IN   tab_infdiacua_maquinaria.id_equipo%TYPE,
        p_descripcion                  IN   tab_infdiacua_maquinaria.descripcion%TYPE,
        p_movil                        IN   tab_infdiacua_maquinaria.movil%TYPE,
        p_placa                        IN   tab_infdiacua_maquinaria.placa%TYPE,
        p_hora_inicial                 IN   tab_infdiacua_maquinaria.hora_inicial%TYPE,
        p_hora_final                   IN   tab_infdiacua_maquinaria.hora_final%TYPE,
        p_horas_trabajadas             IN   tab_infdiacua_maquinaria.horas_trabajadas%TYPE,
        p_stand_by                     IN   tab_infdiacua_maquinaria.stand_by%TYPE,
        p_numero_recibo                IN   tab_infdiacua_maquinaria.numero_recibo%TYPE,
        p_id_archivo_recibo            IN   tab_infdiacua_maquinaria.id_archivo_recibo%TYPE,
        p_viajes                       IN   tab_infdiacua_maquinaria.viajes%TYPE,
        p_actividad_observacion        IN   tab_infdiacua_maquinaria.actividad_observacion%TYPE,
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_equipo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_descripcion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_movil",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_placa",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_inicial",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getHoraInicial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_final",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getHoraFinal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_horas_trabajadas", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getHorasTrabajadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_stand_by", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getStandBy(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getNumeroRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
		parametros.add(new SentenciaParametroDAO("p_id_archivo_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdArchivoRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_viajes", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getViajes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_actividad_observacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getActividadObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_maquinaria", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdInfdiacuaMaquinaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_equipo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_descripcion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_movil",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_placa",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_inicial",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getHoraInicial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_final",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getHoraFinal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_horas_trabajadas", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getHorasTrabajadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_stand_by", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getStandBy(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getNumeroRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
		parametros.add(new SentenciaParametroDAO("p_id_archivo_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdArchivoRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_viajes", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getViajes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_actividad_observacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getActividadObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_maquinaria", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMaquinaria().getIdInfdiacuaMaquinaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
}
