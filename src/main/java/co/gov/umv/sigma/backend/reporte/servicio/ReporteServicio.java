package co.gov.umv.sigma.backend.reporte.servicio;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import co.gov.umv.sigma.backend.reporte.cbo.GenerarFichaOE;
import co.gov.umv.sigma.backend.reporte.dto.impl.ReporteDTO;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/reporte")
public class ReporteServicio {
	@POST
    @Path("/generarFicha")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response generarFicha(GenerarFichaOE OE) {
		try {
            ReporteDTO fac = new ReporteDTO();
            File adjunto = fac.generarFichaWord(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch(Exception ex){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
		
	}
	
	
	@POST
    @Path("/generarFichaIntervencion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response generarFichaIntervencion(GenerarFichaOE OE) {
		try {
            ReporteDTO fac = new ReporteDTO();
            File adjunto = fac.generarFichaIntervencion(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch(Exception ex){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
		
	}
	
	@POST
    @Path("/generarFichaAforo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response generarFichaAforo(GenerarFichaOE OE) {
		try {
            ReporteDTO fac = new ReporteDTO();
            File adjunto = fac.generarFichaWordAforo(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch(Exception ex){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
		
	}
	
	@POST
    @Path("/generarFichaAnalisis")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response generarFichaAnalisis(GenerarFichaOE OE) {
		try {
            ReporteDTO fac = new ReporteDTO();
            File adjunto = fac.generarFichaWordAnalisis(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch(Exception ex){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
		
	}
	
	@POST
    @Path("/generarFichaMantenimientosFallos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response generarFichaMantenimientosFallos(GenerarFichaOE OE) {
		try {
            ReporteDTO fac = new ReporteDTO();
            File adjunto = fac.generarFichaMantenimientosFallos(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch(Exception ex){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
		
	}
}
