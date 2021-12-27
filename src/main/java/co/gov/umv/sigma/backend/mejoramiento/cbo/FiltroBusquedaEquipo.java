package co.gov.umv.sigma.backend.mejoramiento.cbo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoDetalle;

public class FiltroBusquedaEquipo extends ObjetoEntrada
{
	private String numeroInterno;
	private Integer tipo;
	private Integer clase;
	private String placa;
	private Integer marca;
	
	private Integer taller;
	private Integer estado;
	
	
	
	
	public Integer getTaller() {
		return taller;
	}
	public void setTaller(Integer taller) {
		this.taller = taller;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getNumeroInterno() {
		return numeroInterno;
	}
	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Integer getClase() {
		return clase;
	}
	public void setClase(Integer clase) {
		this.clase = clase;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getMarca() {
		return marca;
	}
	public void setMarca(Integer marca) {
		this.marca = marca;
	}
	
	
	
	

}
