package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IConsultaGestionDAO;
import oracle.jdbc.OracleTypes;

/**
*
* @author rocio.guio
*/
public class ConsultaGestionDAO extends GenericoDAO implements IConsultaGestionDAO {
	
	@Override
	public ObjetoSalida listarPanelPendiente(GestionOE OE)
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_GESTION.pr_gestion_pendiente_panel", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_id_usuario", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            //el parametro p_usuario es seteado en la clase que hereda GenericoDAO
            sentencia.setParametros(parametros);
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            
        }
        return objetoSalida;
		
	}
	
	@Override
	public ObjetoSalida listarGestionPendiente(GestionOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_GESTION.pr_gestion_pendiente_x_usu_act", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_id_usuario", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            parametros.add(new SentenciaParametroDAO("P_PK_ID_CALZADA", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("P_CIV", OE.getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));      
            parametros.add(new SentenciaParametroDAO("P_ID_LOCALIDAD", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("P_ID_BARRIO", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("P_ID_ORIGEN", OE.getIdOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("P_CODIGO_ACTIVIDAD_AGRUPADA", OE.getCodigoActividadAgrupada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));   
            
            
            //el parametro p_usuario es seteado en la clase que hereda GenericoDAO 
            sentencia.setParametros(parametros);
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida listarPorIdTransicion(GestionOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_GESTION.PR_GESTION_ACTIVIDAD_MASIVA_X_USU_ACT", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("P_ID_USUARIO", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("P_ID_ACTIVIDAD", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("P_ID_ACTIVIDAD_TRANSICION", OE.getIdActividadTransicion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            parametros.add(new SentenciaParametroDAO("P_PK_ID_CALZADA", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("P_CIV", OE.getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));       
			parametros.add(new SentenciaParametroDAO("P_ID_LOCALIDAD", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("P_ID_BARRIO", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("P_ID_ORIGEN", OE.getIdOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("P_CODIGO_ACTIVIDAD_AGRUPADA", OE.getCodigoActividadAgrupada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            sentencia.setParametros(parametros);
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida listarTransicionesPorActividad(GestionOE OE)
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_GESTION.PR_GESTION_ACTIVIDAD_MASIVA_PANEL", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("P_ID_USUARIO", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("P_ID_ACTIVIDAD", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            sentencia.setParametros(parametros);
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            
        }
        return objetoSalida;	
	}

}
