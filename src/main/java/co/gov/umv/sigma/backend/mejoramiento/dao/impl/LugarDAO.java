package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.LugarOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class LugarDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_LUGAR";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_tipo_lugar", ((LugarOE)OE).getLugar().getIdTipoLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", ((LugarOE)OE).getLugar().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_contacto_nombre", ((LugarOE)OE).getLugar().getContactoNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_contacto_correo_electronico", ((LugarOE)OE).getLugar().getContactoCorreoElectronico(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_contacto_telefono", ((LugarOE)OE).getLugar().getContactoTelefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_direccion", ((LugarOE)OE).getLugar().getDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_lugar", ((LugarOE)OE).getLugar().getIdTipoEstadoLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_nombre", ((LugarOE)OE).getLugar().getNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_descripcion", ((LugarOE)OE).getLugar().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);        
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_lugar", ((LugarOE)OE).getLugar().getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_lugar", ((LugarOE)OE).getLugar().getIdTipoLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", ((LugarOE)OE).getLugar().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_contacto_nombre", ((LugarOE)OE).getLugar().getContactoNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_contacto_correo_electronico", ((LugarOE)OE).getLugar().getContactoCorreoElectronico(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_contacto_telefono", ((LugarOE)OE).getLugar().getContactoTelefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_direccion", ((LugarOE)OE).getLugar().getDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_lugar", ((LugarOE)OE).getLugar().getIdTipoEstadoLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_nombre", ((LugarOE)OE).getLugar().getNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_descripcion", ((LugarOE)OE).getLugar().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);        
	}


	
	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_Lugar", ((LugarOE)OE).getLugar().getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

}

