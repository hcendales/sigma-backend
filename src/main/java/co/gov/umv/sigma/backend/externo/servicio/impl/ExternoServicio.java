package co.gov.umv.sigma.backend.externo.servicio.impl;

import java.io.File;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dto.impl.ArchivoDTO;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;
import co.gov.umv.sigma.backend.externo.servicio.IExternoServicio;

public class ExternoServicio implements IExternoServicio {

	@Override
	public Response consumirExterno(ObjetoNegocioOE OE) {
		ExternoDTO externo = new ExternoDTO();
		ObjetoSalida os = externo.consumirExterno(OE);
		return Response.status(Response.Status.OK).entity(os).header("Access-Control-Allow-Origin", "*")
        		.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
        		.header("Access-Control-Max-Age", "3600")
        		.header("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN").build();
	}

	@Override
	public Response consumirArchivoExterno(ObjetoNegocioOE OE) {
		try {
			ExternoDTO externo = new ExternoDTO();
            File adjunto = externo.consumirArchivoExterno(OE);
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
	}

}
