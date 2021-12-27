package co.gov.umv.sigma.backend.test.servicio;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;


@Path("/testingservice")
public class TestingService {

   /* @POST
    @Path("/listar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response listar (ObjetoEntrada OE) {

        TestingFAC fac = new TestingFAC();
        ObjetoSalida objetoSalida = fac.listar(OE);
        if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA)
            return Response.status(Response.Status.OK).entity(objetoSalida).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(objetoSalida).build();

//    	return null;
    }*/
}