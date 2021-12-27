package co.gov.umv.sigma.backend.produccion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EnsayoApiqueOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import oracle.jdbc.OracleTypes;

public class GestionEnsayoDAO extends CrudDAO {
	private final static String PACKAGE = "pkg_gestion_ensayo";
	
	public ObjetoSalida crearGestionEnsayo(EnsayoApiqueOE OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_apiques", OE.getApiques() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_prioridad", OE.getPrioridad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_direccion", OE.getDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".pr_crear_ensayo_apique", parametros);

	}
	
	public ObjetoSalida consultarEnsayo(LaboratorioOE OE) 
	{
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
       
	    parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        	        
        return ejecutar(OE, PACKAGE+".pr_consultar_ensayo", parametros);
	}


	public ObjetoSalida clonarEnsayo(LaboratorioOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayo().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".pr_clonar_ensayo", parametros);
	}
	
	
	public ObjetoSalida consultarEnsayoDetalle(LaboratorioOE OE) 
	{
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
       
	    parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        	        
        return ejecutar(OE, PACKAGE+".pr_consultar_ensayo_detalle", parametros);
	}
	
	public ObjetoSalida consultarTipoServicioEnsayo(LaboratorioOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	       
	    parametros.add(new SentenciaParametroDAO("p_tipo_servicio", ((LaboratorioOE)OE).getTipoServicioEnsayo().getTipoServicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        	        
        return ejecutar(OE, PACKAGE+".pr_consultar_tipo_serv_ensayo", parametros);
	}
	
	
	public ObjetoSalida consultarTipoMaterialEnsayo(LaboratorioOE OE)
	{
		 List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	       
	    parametros.add(new SentenciaParametroDAO("p_tipo_servicio", ((LaboratorioOE)OE).getTipoMaterialEnsayo().getTipoServicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        	        
        return ejecutar(OE, PACKAGE+".pr_consultar_tipo_mate_ensayo", parametros);
	}
	

	public ObjetoSalida consultarPkConMantenimientosActivos(ObjetoEntrada OE)
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".pr_consultar_pk", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}

	public ObjetoSalida insertarEnsayoinforme(LaboratorioOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getInforme().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_resultado", ((LaboratorioOE)OE).getInforme().getIdTipoResultado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_ejecucion", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_resultado", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaResultado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_laboratorio", ((LaboratorioOE)OE).getInforme().getIdUsuarioLaboratorio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((LaboratorioOE)OE).getInforme().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_nombre_ensayo", ((LaboratorioOE)OE).getInforme().getNombreEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_documento_informe", ((LaboratorioOE)OE).getInforme().getIdDocumentoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_novedades", ((LaboratorioOE)OE).getInforme().getNovedades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_programacion", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaProgramacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado", ((LaboratorioOE)OE).getInforme().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_asunto", ((LaboratorioOE)OE).getInforme().getAsunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_documento", ((LaboratorioOE)OE).getInforme().getIdTipoDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_envio", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaEnvio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
			
		return ejecutar(OE, PACKAGE+".prc_insertar_informe", parametros);	
	}
	
}
