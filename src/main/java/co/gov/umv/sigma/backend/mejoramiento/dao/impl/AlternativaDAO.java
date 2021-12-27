package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AlternativaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class AlternativaDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_ALTERNATIVA_DISENIO";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((AlternativaOE)OE).getAlternativa().getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_alternativa", ((AlternativaOE)OE).getAlternativa().getAlternativa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie_disenio", ((AlternativaOE)OE).getAlternativa().getIdTipoSuperficieDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_final_disenio", ((AlternativaOE)OE).getAlternativa().getIdTipoIntervencionFinalDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_metodologia_disenio", ((AlternativaOE)OE).getAlternativa().getIdTipoMetodologiaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material_granular", ((AlternativaOE)OE).getAlternativa().getIdTipoMaterialGranular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_espesor_disenio", ((AlternativaOE)OE).getAlternativa().getEspesorDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cbr_inicial_pct", ((AlternativaOE)OE).getAlternativa().getCbrInicialPct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_geosinteticos", ((AlternativaOE)OE).getAlternativa().getIdTipoGeosinteticos(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_sistema_drenaje", ((AlternativaOE)OE).getAlternativa().getIdTipoSistemaDrenaje(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((AlternativaOE)OE).getAlternativa().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_seleccionada", ((AlternativaOE)OE).getAlternativa().getSeleccionada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_alternativa_disenio", ((AlternativaOE)OE).getAlternativa().getIdAlternativaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((AlternativaOE)OE).getAlternativa().getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_alternativa", ((AlternativaOE)OE).getAlternativa().getAlternativa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie_disenio", ((AlternativaOE)OE).getAlternativa().getIdTipoSuperficieDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_final_disenio", ((AlternativaOE)OE).getAlternativa().getIdTipoIntervencionFinalDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_metodologia_disenio", ((AlternativaOE)OE).getAlternativa().getIdTipoMetodologiaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material_granular", ((AlternativaOE)OE).getAlternativa().getIdTipoMaterialGranular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_espesor_disenio", ((AlternativaOE)OE).getAlternativa().getEspesorDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cbr_inicial_pct", ((AlternativaOE)OE).getAlternativa().getCbrInicialPct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_geosinteticos", ((AlternativaOE)OE).getAlternativa().getIdTipoGeosinteticos(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_sistema_drenaje", ((AlternativaOE)OE).getAlternativa().getIdTipoSistemaDrenaje(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((AlternativaOE)OE).getAlternativa().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_seleccionada", ((AlternativaOE)OE).getAlternativa().getSeleccionada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
			
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	parametros.add(new SentenciaParametroDAO("p_id_alternativa_disenio", ((AlternativaOE)OE).getAlternativa().getIdAlternativaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}

