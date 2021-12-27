package co.gov.umv.sigma.backend.seguridad.dto;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.administracion.cbo.UsuarioOE;
import co.gov.umv.sigma.backend.administracion.dao.IUsuarioDAO;
import co.gov.umv.sigma.backend.administracion.dao.impl.UsuarioDAO;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public class TokenDTO implements ITokenDTO {

	@Override
	public ObjetoSalida generarToken(UMVPersonLogin OE) {
		IUsuarioDAO usr = new UsuarioDAO();
		
		String filtro = "LOWER(login)='"+ OE.getUsername().toLowerCase()+"'";
		UsuarioOE usuarioOE = new UsuarioOE();
		usuarioOE.setUsuario(OE.getUsuario());
		usuarioOE.setIdUsuario(OE.getIdUsuario());
		usuarioOE.setFiltro(filtro);
		ObjetoSalida os = usr.consultarXFiltro(usuarioOE);
		
		return os;
	}

}
