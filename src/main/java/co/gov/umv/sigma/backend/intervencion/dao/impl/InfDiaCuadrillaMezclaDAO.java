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

public class InfDiaCuadrillaMezclaDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_infdiacua_mezcla_conc";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_infdiacua_mezcla_conc     IN   tab_infdiacua_mezcla_conc.id_infdiacua_mezcla_conc%TYPE,
        p_id_informe_diario_cuadrilla  IN   tab_infdiacua_mezcla_conc.id_informe_diario_cuadrilla%TYPE,
        p_id_tipo_material             IN   tab_infdiacua_mezcla_conc.id_tipo_material%TYPE,
        p_id_tipo_clase_material       IN   tab_infdiacua_mezcla_conc.id_tipo_clase_material%TYPE,
        p_movil                        IN   tab_infdiacua_mezcla_conc.movil%TYPE,
        p_placa                        IN   tab_infdiacua_mezcla_conc.placa%TYPE,
        p_volumen                      IN   tab_infdiacua_mezcla_conc.volumen%TYPE,
        p_numero_recibo                IN   tab_infdiacua_mezcla_conc.numero_recibo%TYPE,
        p_id_archivo_recibo            IN   tab_infdiacua_mezcla_conc.id_archivo_recibo%TYPE,
        p_hora_entrada                 IN   tab_infdiacua_mezcla_conc.hora_entrada%TYPE,
        p_hora_instalacion             IN   tab_infdiacua_mezcla_conc.hora_instalacion%TYPE,
        p_hora_salida                  IN   tab_infdiacua_mezcla_conc.hora_salida%TYPE,
        p_abcsisa_inicio               IN   tab_infdiacua_mezcla_conc.abcsisa_inicio%TYPE,
        p_abcsisa_final                IN   tab_infdiacua_mezcla_conc.abcsisa_final%TYPE,
        p_abcsisa_carril               IN   tab_infdiacua_mezcla_conc.abcsisa_carril%TYPE,
        p_temperatura_recibo           IN   tab_infdiacua_mezcla_conc.temperatura_recibo%TYPE,
        p_temperatura_llegada          IN   tab_infdiacua_mezcla_conc.temperatura_llegada%TYPE,
        p_temperatura_extendido        IN   tab_infdiacua_mezcla_conc.temperatura_extendido%TYPE,
        p_temperatura_compactacion     IN   tab_infdiacua_mezcla_conc.temperatura_compactacion%TYPE,
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material",  ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdTipoMaterial() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_movil",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_placa",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_volumen",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getVolumen()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_recibo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getNumeroRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdArchivoRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora_entrada", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getHoraEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_instalacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getHoraInstalacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_salida", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getHoraSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_abcsisa_inicio", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getAbcsisaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_abcsisa_final", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getAbcsisaFinal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_abcsisa_carril", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getAbcsisaCarril()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_temperatura_recibo", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaRecibo()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_temperatura_llegada", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaLlegada()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_temperatura_extendido", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaExtendido()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_temperatura_compactacion", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaCompactacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_mezcla_conc", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdInfdiacuaMezclaConc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material",  ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdTipoMaterial() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_movil",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_placa",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_volumen",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getVolumen()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_recibo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getNumeroRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdArchivoRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora_entrada", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getHoraEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_instalacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getHoraInstalacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_salida", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getHoraSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_abcsisa_inicio", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getAbcsisaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_abcsisa_final", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getAbcsisaFinal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_abcsisa_carril", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getAbcsisaCarril()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_temperatura_recibo", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaRecibo()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_temperatura_llegada", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaLlegada()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_temperatura_extendido", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaExtendido()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_temperatura_compactacion", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getTemperaturaCompactacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_mezcla_conc", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaMezclaConc().getIdInfdiacuaMezclaConc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

}
