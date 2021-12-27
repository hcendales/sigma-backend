package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FranjaHorariaOE;
import oracle.jdbc.OracleTypes;

public class FranjasHorariasDAO  extends CrudDAO{


	public ObjetoSalida generarFranjas(FranjaHorariaOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso", OE.getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_intervalo", OE.getIntervalo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_horaInicio", OE.getHoraInicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_horaFin", OE.getHoraFin(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
             
        return ejecutar(OE, "PKG_PROGRAMACION"+".prc_generar_franjas_recurso", parametros); 
	}
	
	public ObjetoSalida eliminarFranjas(FranjaHorariaOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso", OE.getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
        System.out.println(obtenerFecha( OE.getFechaDesde() ));
        System.out.println(obtenerFecha( OE.getFechaHasta() ));
        
        return ejecutar(OE, "PKG_PROGRAMACION"+".prc_eliminar_franjas_recurso", parametros); 
	}
	
	
	public ObjetoSalida consultarFranjas(FranjaHorariaOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso", OE.getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_horaInicio", OE.getHoraInicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_horaFin", OE.getHoraFin(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
             
        return ejecutar(OE, "PKG_PROGRAMACION"+".prc_consultar_franjas_recurso", parametros); 
	}
}
