package co.gov.umv.sigma.backend.administracion.dto.impl;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.administracion.cbo.UsuarioOE;
import co.gov.umv.sigma.backend.administracion.dao.IUsuarioDAO;
import co.gov.umv.sigma.backend.administracion.dao.impl.UsuarioDAO;
import co.gov.umv.sigma.backend.administracion.dto.IUsuarioDTO;
import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public class UsuarioDTO implements IUsuarioDTO {

	
	//Código de error que devuelve LDAP cuando hay alguna excepción al momento de autenticarse el usuario
	private static final String ERRLDAPAUTHCODE = "49";
	
	@Override
	public ObjetoSalida login(UMVPersonLogin OE) {
		IUsuarioDAO usr = new UsuarioDAO();
		
		String filtro = "LOWER(login)='"+ OE.getUsername().toLowerCase()+"'";
		UsuarioOE usuarioOE = new UsuarioOE();
		usuarioOE.setUsuario(OE.getUsuario());
		usuarioOE.setIdUsuario(OE.getIdUsuario());
		usuarioOE.setFiltro(filtro);
		ObjetoSalida os = usr.consultarXFiltro(usuarioOE);
		if (os.esRespuestaOperacionCorrecta()) {
			try {
				if(usr.correctLogin(OE)) {
					//os.setMsgError("LOGIN EXITOSO!!!");					
					return os;
				}else {
					String clave = (os.getRespuesta().get(0).get("clave") == null) ? "" : os.getRespuesta().get(0).get("clave").toString();
					clave = digestPassword(clave);
					if(clave.equals(OE.getPassword())) {
						return os;			
					}else {
						os.setRespuesta(null);
						os.setCodError(CodError.USUARIO_O_CONTRASENA_INVALIDOS);
						os.setMsgError("Login Fallido");
						return os;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				os.setMsgError(e.getMessage());
				os.setCodError(CodError.ERROR_INTERNO);
				return os;
			}
			
		}else {			
				os.setCodError(CodError.USUARIO_O_CONTRASENA_INVALIDOS);
				os.setMsgError("USUARIO NO EXISTE EN SIGMA");
				return os;
		}//*/
		//return null;
	}

	@Override
	public ObjetoSalida insertar(UsuarioOE OE) {
		IUsuarioDAO usr = new UsuarioDAO();
		return usr.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(UsuarioOE OE) {
		IUsuarioDAO usr = new UsuarioDAO();
		return usr.actualizar(OE);
	}

	@Override
	public ObjetoSalida borrar(UsuarioOE OE) {
		IUsuarioDAO usr = new UsuarioDAO();
		return usr.borrar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(UsuarioOE OE) {
		IUsuarioDAO usr = new UsuarioDAO();
		return usr.consultarXFiltro(OE);
	}
	
	private String digestPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest cifrador = null;
		cifrador = java.security.MessageDigest.getInstance("SHA-256");
		String randomChunk = ""; 
		String digestedPasswd = DatatypeConverter.printHexBinary(cifrador.digest((randomChunk + password).getBytes())).toUpperCase();
		return digestedPasswd;
	}
}
