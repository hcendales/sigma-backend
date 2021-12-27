package co.gov.umv.sigma.backend.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.seguridad.dto.ITokenDTO;
import co.gov.umv.sigma.backend.seguridad.dto.TokenDTO;
import co.gov.umv.sigma.backend.seguridad.jwt.JWTFiltro;
import co.gov.umv.sigma.backend.seguridad.servicio.ITokenServicio;
import static co.gov.umv.sigma.backend.seguridad.jwt.JWTFiltro.JWT_HEADER_TOKEN;

public class TokenServicio implements ITokenServicio {

	@Override
	public Response generarToken(UMVPersonLogin OE) throws Exception {
		ITokenDTO usuario = new TokenDTO();
        ObjetoSalida validar =  usuario.generarToken(OE);
        List<LinkedHashMap<String, Object>> salida = new ArrayList<LinkedHashMap<String, Object>>();  
        LinkedHashMap<String, Object> token = new LinkedHashMap<String, Object>();        
        if (!validar.esRespuestaOperacionCorrecta()) {
        	return Response.status(Response.Status.UNAUTHORIZED).entity(validar).build();
        }
        else {
        	token.put(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(validar.getRespuesta())));
            salida.add(token);
            validar.setRespuesta(salida);
            return Response.status(Response.Status.OK).entity(validar).build();
        }
	}

}
