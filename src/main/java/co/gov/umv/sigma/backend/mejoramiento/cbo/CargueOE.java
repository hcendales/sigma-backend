package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;

public class CargueOE extends ObjetoEntrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7971138434355892646L;
	
	private int idTipoCargue;
	private Long idCargue;
	private String filtro;

	private String nombreArchivo;
    private Date fechaRecibido;
    private int cantidadRegistros;
    private Date fechaValidado;
    private String validadoCorrecto;
    private int cantidadRegistrosNovalidos;
    private Date fechaProcesado;
    private String procesadoCorrecto;
    private int cantidadRegistrosError; 
    
    
    public boolean crearObjetoDesdeFormulario(Map<String, List<InputPart>> uploadForm) throws NumberFormatException, IOException, ParseException 
    {
    	setIdTipoCargue((uploadForm.get("idTipoCargue") == null) ? 0 : Integer.parseInt(uploadForm.get("idTipoCargue").get(0).getBodyAsString()));
        setNombreArchivo((uploadForm.get("nombreArchivo") == null) ? "" :uploadForm.get("nombreArchivo").get(0).getBodyAsString());
        setUsuario((uploadForm.get("usuario") == null) ? "" :uploadForm.get("usuario").get(0).getBodyAsString());
        
        //setFechaRecibido((uploadForm.get("fechaRecibido") == null) ? null : obtenerFecha(uploadForm.get("fechaRecibido").get(0).getBodyAsString()));
        setFechaRecibido(new Date());
        return validar();
    }
	
    
    private boolean validar()
    {
    	return !(idTipoCargue == 0 || nombreArchivo.equals("") || getUsuario().equals(""));
    }
    
    private Date obtenerFecha(String sDate) throws ParseException
	{
		return new SimpleDateFormat("dd/MM/yyyy").parse(sDate);  
	}
    
    
	public int getIdTipoCargue() {
		return idTipoCargue;
	}

	public void setIdTipoCargue(int idTipoCargue) {
		this.idTipoCargue = idTipoCargue;
	}

	public Long getIdCargue() {
		return idCargue;
	}

	public void setIdCargue(Long idCargue) {
		this.idCargue = idCargue;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public Date getFechaValidado() {
		return fechaValidado;
	}

	public void setFechaValidado(Date fechaValidado) {
		this.fechaValidado = fechaValidado;
	}

	public String getValidadoCorrecto() {
		return validadoCorrecto;
	}

	public void setValidadoCorrecto(String validadoCorrecto) {
		this.validadoCorrecto = validadoCorrecto;
	}

	public int getCantidadRegistrosNovalidos() {
		return cantidadRegistrosNovalidos;
	}

	public void setCantidadRegistrosNovalidos(int cantidadRegistrosNovalidos) {
		this.cantidadRegistrosNovalidos = cantidadRegistrosNovalidos;
	}

	public Date getFechaProcesado() {
		return fechaProcesado;
	}

	public void setFechaProcesado(Date fechaProcesado) {
		this.fechaProcesado = fechaProcesado;
	}

	public String getProcesadoCorrecto() {
		return procesadoCorrecto;
	}

	public void setProcesadoCorrecto(String procesadoCorrecto) {
		this.procesadoCorrecto = procesadoCorrecto;
	}

	public int getCantidadRegistrosError() {
		return cantidadRegistrosError;
	}

	public void setCantidadRegistrosError(int cantidadRegistrosError) {
		this.cantidadRegistrosError = cantidadRegistrosError;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	
	
	

}
