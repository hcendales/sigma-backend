package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.UnidadMuestreoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IUnidadMuestreoDAO;
import oracle.jdbc.OracleTypes;

public class UnidadMuestreoDAO extends GenericoDAO implements IUnidadMuestreoDAO{
	private final static String PACKAGE = "pkg_unidad_muestreo"; 
	@Override
	public ObjetoSalida insertar(UnidadMuestreoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getUnidadMuestreo().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float abscisainicial = (OE.getUnidadMuestreo().getAbscisaInicial() == null) ? null : OE.getUnidadMuestreo().getAbscisaInicial().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_abscisa_inicial", abscisainicial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float abscisafinal = (OE.getUnidadMuestreo().getAbscisaFinal() == null) ? null : OE.getUnidadMuestreo().getAbscisaFinal().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_abscisa_final", abscisafinal, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float area = (OE.getUnidadMuestreo().getArea() ==  null) ? null : OE.getUnidadMuestreo().getArea().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_area", area, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float pci = (OE.getUnidadMuestreo().getPci() == null) ? null : OE.getUnidadMuestreo().getPci().floatValue();
            parametros.add(new SentenciaParametroDAO("p_pci", pci, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float ancho = (OE.getUnidadMuestreo().getAncho() == null) ? null : OE.getUnidadMuestreo().getAncho().floatValue();
            parametros.add(new SentenciaParametroDAO("p_ancho", ancho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizar(UnidadMuestreoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getUnidadMuestreo().getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getUnidadMuestreo().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float abscisainicial = (OE.getUnidadMuestreo().getAbscisaInicial() == null) ? null : OE.getUnidadMuestreo().getAbscisaInicial().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_abscisa_inicial", abscisainicial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float abscisafinal = (OE.getUnidadMuestreo().getAbscisaFinal() == null) ? null : OE.getUnidadMuestreo().getAbscisaFinal().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_abscisa_final", abscisafinal, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float area = (OE.getUnidadMuestreo().getArea() ==  null) ? null : OE.getUnidadMuestreo().getArea().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_area", area, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float pci = (OE.getUnidadMuestreo().getPci() == null) ? null : OE.getUnidadMuestreo().getPci().floatValue();
            parametros.add(new SentenciaParametroDAO("p_pci", pci, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float ancho = (OE.getUnidadMuestreo().getAncho() == null) ? null : OE.getUnidadMuestreo().getAncho().floatValue();
            parametros.add(new SentenciaParametroDAO("p_ancho", ancho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida eliminar(UnidadMuestreoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getUnidadMuestreo().getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                                    
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarXFiltro(UnidadMuestreoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consultarporfiltro", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizarPCI(UnidadMuestreoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_pci", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getUnidadMuestreo().getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            Float pci = (OE.getUnidadMuestreo().getPci() == null) ? null : OE.getUnidadMuestreo().getPci().floatValue();
            parametros.add(new SentenciaParametroDAO("p_pci", pci, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizarCampo(UnidadMuestreoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_campo", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getUnidadMuestreo().getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_nombre_campo", OE.getNombreCampo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_valor_campo", OE.getValorCampo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

}
