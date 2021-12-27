package co.gov.umv.sigma.backend.administracion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.administracion.cbo.PersonaOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.PersonaDTO;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/persona")
public class PersonaServicio 
{

	@JWT 
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	public Response insertar(PersonaOE OE)
	{
		ICrudDTO Persona = new PersonaDTO();
		ObjetoSalida os = Persona.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	@JWT
	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	public Response actualizar(PersonaOE OE)
	{
		ICrudDTO Persona = new PersonaDTO();
		ObjetoSalida os = Persona.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@JWT
	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	public Response eliminar(PersonaOE OE)
	{
		ICrudDTO Persona = new PersonaDTO();
		ObjetoSalida os = Persona.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@JWT
	@POST
    @Path("/consultarXFiltro") //
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	public Response consultarXFiltro(PersonaOE OE)
	{
		ICrudDTO Persona = new PersonaDTO();
		ObjetoSalida os = Persona.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	
	//public Response insertar(PersonaOE OE) throws Exception {    
	/*IUsuarioDTO usuario = new UsuarioDTO();
        ObjetoSalida validar =  usuario.login(OE);*/
		/*ExternoDTO usuario = new ExternoDTO();
		ObjetoSalida validar = usuario.generarJSONWithoutToken(OE);
        //if (validar.getCodError() != CodError.OPERACION_CORRECTA) {
        if(!validar.esRespuestaOperacionCorrecta()) {
        	return Response.status(Response.Status.UNAUTHORIZED).entity(validar).build();}
        else
            return Response.status(Response.Status.OK).entity(validar).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(validar.getRespuesta())))
            		.header("Access-Control-Allow-Origin", "*")
            		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
            		.header("Access-Control-Max-Age", "3600")
            		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN")            		
            		.build();
        	//return Response.status(Response.Status.OK).entity(validar).build();
        /*response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
		return null;
	}*/
	
}
