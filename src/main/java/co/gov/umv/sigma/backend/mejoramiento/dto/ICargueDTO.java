package co.gov.umv.sigma.backend.mejoramiento.dto;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.CargueOE;


public interface ICargueDTO {

	public ObjetoSalida procesar(CargueOE OE);
	public ObjetoSalida validar(CargueOE OE);
	

	public ObjetoSalida insertarArchivo(MultipartFormDataInput OE);
	
	public ObjetoSalida eliminarDetalles(CargueOE OE);
}
