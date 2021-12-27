package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ApiqueOE;

public class ApiqueDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_PREDISENIO_APIQUE";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((ApiqueOE)OE).getApique().getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_nomenclatura", ((ApiqueOE)OE).getApique().getNomenclatura(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observacion", ((ApiqueOE)OE).getApique().getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		if(((ApiqueOE)OE).getApique().getIdDocumentoResultadoApiques() != null)
			parametros.add(new SentenciaParametroDAO("p_id_documento_resultado_apiques", ((ApiqueOE)OE).getApique().getIdDocumentoResultadoApiques(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		else
			parametros.add(new SentenciaParametroDAO("p_id_documento_resultado_apiques", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_predisenio_apique", ((ApiqueOE)OE).getApique().getIdPredisenioApique(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((ApiqueOE)OE).getApique().getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_nomenclatura", ((ApiqueOE)OE).getApique().getNomenclatura(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observacion", ((ApiqueOE)OE).getApique().getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		if(((ApiqueOE)OE).getApique().getIdDocumentoResultadoApiques() != null)
			parametros.add(new SentenciaParametroDAO("p_id_documento_resultado_apiques", ((ApiqueOE)OE).getApique().getIdDocumentoResultadoApiques(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		else
			parametros.add(new SentenciaParametroDAO("p_id_documento_resultado_apiques", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	parametros.add(new SentenciaParametroDAO("p_id_predisenio_apique", ((ApiqueOE)OE).getApique().getIdPredisenioApique(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}

