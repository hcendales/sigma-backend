package co.gov.umv.sigma.backend.comun.servicio;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.DocumentoArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dto.impl.ArchivoDTO;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/archivo")
public class ArchivoServicio {
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertarArchivo(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.insertar(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
		
	}
	
	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarArchivo(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.actualizar(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
	}
	
	@POST
    @Path("/consultar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarArchivo(DocumentoArchivoOE OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.consultarArchivo(OE);
		return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		
	}
	
	@POST
    @Path("/insertarDocumento")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertarDocumentoArchivo(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.insertarDocumento(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
		
	}
	
	@POST
    @Path("/actualizarDocumento")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarDocumentoArchivo(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.actualizarDocumento(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
	}
	
	@POST
    @Path("/consultarDocumento")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarDocumentoArchivo(DocumentoArchivoOE OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.consultarDocumentoArchivo(OE);
		return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
	}
	
	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarArchivo(DocumentoArchivoOE OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.EliminarArchivo(OE);
		return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		
	}
	
	@POST
    @Path("/insertarArchivoDocumento")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertarArchivoDocumento(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.insertarArchivoDocumento(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
		
	}
	
	@POST
    @Path("/actualizarArchivoDocumento")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarArchivoDocumento(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.actualizarArchivoDocumento(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
	}
	
	
	@POST
    @Path("/insertarDocumentoCal")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertarDocumentoCal(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.insertarDocumentoCal(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
		
	}
	
	@POST
    @Path("/actualizarDocumentoCal")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarDocumentoCal(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.actualizarDocumentoCal(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
	}
	
	@POST
    @Path("/consultarArchivoFisico")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM})
	@JWT
	public Response consultarArchivoFisico(DocumentoArchivoOE OE) {
		try {
            ArchivoDTO fac = new ArchivoDTO();
            File adjunto = fac.consultarArchivoFisico(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
            	ObjetoSalida os = new ObjetoSalida();
            	os.setMsgError("No se encuentra el archivo");
            	os.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
            	//return Response.status(Response.Status.FORBIDDEN).build();
            	return Response.status(Response.Status.FORBIDDEN).entity(os).build();                
            }
        }catch(Exception ex){
	        	ObjetoSalida os = new ObjetoSalida();
	        	os.setMsgError("Excepcion " +ex.getMessage());
	        	os.setCodError(CodError.ERROR_INTERNO);
	        	//return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
        }
		/*return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();*/
		
	}
	
	@POST
    @Path("/insertarArchivoCal")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertarArchivoCal(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.insertarArchivoCal(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
		
	}
	
	@POST
    @Path("/actualizarArchivoCal")
    @Consumes({ MediaType.MULTIPART_FORM_DATA})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarArchivoCal(MultipartFormDataInput OE) {
		ArchivoDTO archivo = new ArchivoDTO();
		ObjetoSalida os = archivo.actualizarArchivoCal(OE);
		if (os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
		}
	}
	
	@POST
    @Path("/consultarArchivoCal")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM})
	@JWT
	public Response consultarArchivoCal(DocumentoArchivoOE OE) {
		try {
            ArchivoDTO fac = new ArchivoDTO();
            File adjunto = fac.consultarArchivoCal(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
            	ObjetoSalida os = new ObjetoSalida();
            	os.setMsgError("No se encuentra el archivo");
            	os.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
            	//return Response.status(Response.Status.FORBIDDEN).build();
            	return Response.status(Response.Status.FORBIDDEN).entity(os).build();                
            }
        }catch(Exception ex){
	        	ObjetoSalida os = new ObjetoSalida();
	        	os.setMsgError("Excepcion " +ex.getMessage());
	        	os.setCodError(CodError.ERROR_INTERNO);
	        	//return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
        }
		/*return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();*/
		
	}
	
	@POST
    @Path("/consultarDocumentoAdjunto")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM})
	@JWT
	public Response consultarDocumentoAdjunto(DocumentoArchivoOE OE) {
		try {
            ArchivoDTO fac = new ArchivoDTO();
            File adjunto = fac.consultarDocumentoAdjunto(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Type","application/octet-stream");
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
            	ObjetoSalida os = new ObjetoSalida();
            	os.setMsgError("No se encuentra el archivo");
            	os.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
            	//return Response.status(Response.Status.FORBIDDEN).build();
            	return Response.status(Response.Status.FORBIDDEN).entity(os).build();                
            }
        }catch(Exception ex){
	        	ObjetoSalida os = new ObjetoSalida();
	        	os.setMsgError("Excepcion " +ex.getMessage());
	        	os.setCodError(CodError.ERROR_INTERNO);
	        	//return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
        }
		/*return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
	        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
	        		.header("Access-Control-Max-Age", "3600")
	        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();*/
		
	}
}
