package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.administracion.cbo.PersonaOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class PersonaDAO extends CrudDAO implements ICrudDAO 
{
	private final static String PACKAGE = "pkg_persona";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_regimen", ((PersonaOE)OE).getPersona().getIdTipoRegimen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_categoria_persona", ((PersonaOE)OE).getPersona().getIdTipoCategoriaPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_identificacion", ((PersonaOE)OE).getPersona().getIdentificacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_usuario", ((PersonaOE)OE).getPersona().getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_nombre", ((PersonaOE)OE).getPersona().getNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_telefono", ((PersonaOE)OE).getPersona().getTelefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_email", ((PersonaOE)OE).getPersona().getEmail(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_area", ((PersonaOE)OE).getPersona().getIdTipoArea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo", ((PersonaOE)OE).getPersona().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_rol", ((PersonaOE)OE).getPersona().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_persona", ((PersonaOE)OE).getPersona().getIdTipoEstadoPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    
	    return ejecutar(OE, PACKAGE+".prc_insertar", parametros); 
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
	    parametros.add(new SentenciaParametroDAO("p_id_persona", ((PersonaOE)OE).getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_regimen", ((PersonaOE)OE).getPersona().getIdTipoRegimen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_categoria_persona", ((PersonaOE)OE).getPersona().getIdTipoCategoriaPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_identificacion", ((PersonaOE)OE).getPersona().getIdentificacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_usuario", ((PersonaOE)OE).getPersona().getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_nombre", ((PersonaOE)OE).getPersona().getNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_telefono", ((PersonaOE)OE).getPersona().getTelefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_email", ((PersonaOE)OE).getPersona().getEmail(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_area", ((PersonaOE)OE).getPersona().getIdTipoArea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo", ((PersonaOE)OE).getPersona().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_rol", ((PersonaOE)OE).getPersona().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_persona", ((PersonaOE)OE).getPersona().getIdTipoEstadoPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	       
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros); 
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_persona", ((PersonaOE)OE).getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros); 
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

	
}
