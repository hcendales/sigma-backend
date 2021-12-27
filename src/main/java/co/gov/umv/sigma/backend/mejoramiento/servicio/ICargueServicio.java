package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import co.gov.umv.sigma.backend.mejoramiento.cbo.CargueOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/cargue")
public interface ICargueServicio 
{
	
	@POST
    @Path("/procesar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response procesar(CargueOE OE); //{"usuario":"rocio.guio","idTipoCargue":1,"idCargue":651151}
	
	@POST
    @Path("/validar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response validar(CargueOE OE); //{"usuario":"rocio.guio","idTipoCargue":1,"idCargue":651151}

	
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertar(MultipartFormDataInput OE);
	

	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizar(CargueOE OE);
	

	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminar(CargueOE OE);
	

	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltro(CargueOE OE);
	
	
	@POST
    @Path("/eliminarDetalles")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarDetalles(CargueOE OE);
	
}
