package co.gov.umv.sigma.backend.comun.dto;

import java.io.File;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import co.gov.umv.sigma.backend.comun.cbo.ArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.DocumentoArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public interface IArchivoDTO {
	public ObjetoSalida insertar(MultipartFormDataInput OE);
	public ObjetoSalida actualizar(MultipartFormDataInput OE);
	public ObjetoSalida consultarArchivo(DocumentoArchivoOE OE);
	public ObjetoSalida EliminarArchivo(DocumentoArchivoOE OE);
	
	public ObjetoSalida insertarDocumento(MultipartFormDataInput OE);	
	public ObjetoSalida actualizarDocumento(MultipartFormDataInput OE);
	public ObjetoSalida consultarDocumentoArchivo(DocumentoArchivoOE OE);
	
	public ObjetoSalida insertarArchivoDocumento(MultipartFormDataInput OE);
	public ObjetoSalida actualizarArchivoDocumento(MultipartFormDataInput OE);
	
	public ObjetoSalida insertarDocumentoCal(MultipartFormDataInput OE);	
	public ObjetoSalida actualizarDocumentoCal(MultipartFormDataInput OE);
	public File consultarArchivoFisico(DocumentoArchivoOE OE);
	
	public ObjetoSalida insertarArchivoCal(MultipartFormDataInput OE);	
	public ObjetoSalida actualizarArchivoCal(MultipartFormDataInput OE);
	public File consultarArchivoCal(DocumentoArchivoOE OE);
	
	public File consultarDocumentoAdjunto(DocumentoArchivoOE OE);
}
