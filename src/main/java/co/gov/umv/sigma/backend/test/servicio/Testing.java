package co.gov.umv.sigma.backend.test.servicio;

import java.sql.Connection;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.ConexionDS;
@RequestScoped
@Path("/testing")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class Testing {
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("F Value", f); 
		jsonObject.put("C Value", celsius);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
	  
	  @Path("/connect")
	  @GET
	  @Produces("application/json")
	  public Response connectionDB() throws JSONException {
		ObjetoSalida os = new ObjetoSalida();		
		Connection con = null;
		try {
			con = ConexionDS.obtenerInstancia();
			
			os.setMsgError("Conexion Exitosa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			os.setMsgError("Conexion Fallida");
			e.printStackTrace();
		}
		  
		return  Response.status(200).entity(os).build();
		  
	  }
}
