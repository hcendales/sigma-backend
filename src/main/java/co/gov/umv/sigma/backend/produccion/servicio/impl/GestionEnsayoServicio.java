package co.gov.umv.sigma.backend.produccion.servicio.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EnsayoApiqueOE;
import co.gov.umv.sigma.backend.produccion.dto.impl.GestionEnsayoDTO;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/gestionEnsayo")
public class GestionEnsayoServicio {
	
	@POST
	@Path("/crearEnsayoApique")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	//@JWT	
	public Response crearGestionEnsayo(EnsayoApiqueOE OE) {
		GestionEnsayoDTO servicio = new GestionEnsayoDTO();
		ObjetoSalida os = servicio.crearGestionEnsayo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}
	
	/*
	@POST
	@Path("/clonarEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	//@JWT	
	public Response clonarEnsayo(EnsayoApiqueOE OE) {
		GestionEnsayoDTO servicio = new GestionEnsayoDTO();
		ObjetoSalida os = servicio.clonarEnsayo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}
	
	@POST
	@Path("/consultarPk")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	//@JWT	
	public Response consultarPk(EnsayoApiqueOE OE) {
		GestionEnsayoDTO servicio = new GestionEnsayoDTO();
		ObjetoSalida os = servicio.consultarPk(OE);
		
		return Response.status(Response.Status.OK).entity(os).build();
		
	}
	*/
}
