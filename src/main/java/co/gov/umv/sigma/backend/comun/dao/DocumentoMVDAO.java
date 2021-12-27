package co.gov.umv.sigma.backend.comun.dao;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;

public class DocumentoMVDAO extends CrudDAO  {

	private final static String PACKAGE = "PKG_GESTION_DOCUMENTO_MV";


	public ObjetoSalida nuevaVersion(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
    	parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((DocumentoOE)OE).getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
       	parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((DocumentoOE)OE).getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
           	parametros.add(new SentenciaParametroDAO("p_id_tipo_documento", ((DocumentoOE)OE).getDocumento().getIdTipoDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	parametros.add(new SentenciaParametroDAO("p_numero", ((DocumentoOE)OE).getDocumento().getNumero(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    	parametros.add(new SentenciaParametroDAO("p_descripcion", ((DocumentoOE)OE).getDocumento().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    	parametros.add(new SentenciaParametroDAO("p_url_archivo", ((DocumentoOE)OE).getDocumento().getUrlArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    	parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_documento", ((DocumentoOE)OE).getDocumento().getIdTipoEstadoDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        return ejecutar(OE, PACKAGE+".pr_generarNuevaVersion", parametros);
	}


	public ObjetoSalida listarXTipo(DocumentoOE OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
    	parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((DocumentoOE)OE).getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	parametros.add(new SentenciaParametroDAO("p_id_tipo_documento", ((DocumentoOE)OE).getDocumento().getIdTipoDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        return ejecutar(OE, PACKAGE+".pr_generarNuevaVersion", parametros);
	}
	
	

	

}