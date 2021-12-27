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

public class InfDiaCuadrillaCantidadObraDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_infdiacua_cant_obra";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_infdiacua_cant_obra       IN   tab_infdiacua_cant_obra.id_infdiacua_cant_obra%TYPE,
        p_id_informe_diario_cuadrilla  IN   tab_infdiacua_cant_obra.id_informe_diario_cuadrilla%TYPE,
        p_id_tipo_actividad            IN   tab_infdiacua_cant_obra.id_tipo_actividad%TYPE,
        p_id_tipo_material             IN   tab_infdiacua_cant_obra.id_tipo_material%TYPE,
        p_id_tipo_clase_material       IN   tab_infdiacua_cant_obra.id_tipo_clase_material%TYPE,
        p_id_tipo_unidad_medida        IN   tab_infdiacua_cant_obra.id_tipo_unidad_medida%TYPE,
        p_cantidad                     IN   tab_infdiacua_cant_obra.cantidad%TYPE,
        p_largo                        IN   tab_infdiacua_cant_obra.largo%TYPE,
        p_ancho                        IN   tab_infdiacua_cant_obra.ancho%TYPE,
        p_espesor                      IN   tab_infdiacua_cant_obra.espesor%TYPE,
        p_volumen_material_compacto    IN   tab_infdiacua_cant_obra.volumen_material_compacto%TYPE,
        p_porcentaje_compactacion      IN   tab_infdiacua_cant_obra.porcentaje_compactacion%TYPE,
        p_manual                       IN   tab_infdiacua_cant_obra.manual%TYPE,
        p_mecanica                     IN   tab_infdiacua_cant_obra.mecanica%TYPE,
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_unidad_medida",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoUnidadMedida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getCantidad()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_largo",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getLargo()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_ancho", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getAncho()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_espesor", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getEspesor()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_volumen_material_compacto", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getVolumenMaterialCompacto()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		parametros.add(new SentenciaParametroDAO("p_porcentaje_compactacion", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getPorcentajeCompactacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_manual", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getManual(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		parametros.add(new SentenciaParametroDAO("p_mecanica", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getMecanica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_cant_obra", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdInfdiacuaCantObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_unidad_medida",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdTipoUnidadMedida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getCantidad()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_largo",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getLargo()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_ancho", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getAncho()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_espesor", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getEspesor()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_volumen_material_compacto", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getVolumenMaterialCompacto()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		parametros.add(new SentenciaParametroDAO("p_porcentaje_compactacion", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getPorcentajeCompactacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_manual", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getManual(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		parametros.add(new SentenciaParametroDAO("p_mecanica", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getMecanica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_cant_obra", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCantObra().getIdInfdiacuaCantObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
}
