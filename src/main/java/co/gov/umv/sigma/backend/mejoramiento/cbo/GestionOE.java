package co.gov.umv.sigma.backend.mejoramiento.cbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.umv.sigma.backend.comun.cbo.CodTipoGestion;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
 
/**
*
* @author rocio.guio
*/
public class GestionOE extends ObjetoEntrada {
	
	
	private static final long serialVersionUID = 1L;
	
	private int idActividad ;
	private int idProcesoGestion;
	private CodTipoGestion tipoGestion;
	private int idActividadTransicion;
	private String observacion;
	private String enviarCorreo;
	private List<Integer> ids = new ArrayList<Integer>();
	
	private Long idMantenimientoVial;
	
	private String pkIdCalzada;
	private String Civ;
	private Long idLocalidad;
	private Long idBarrio;
	private Long idOrigen;
	private String codigoActividadAgrupada;
	
	
	
	
	
	public String getPkIdCalzada() {
		return pkIdCalzada;
	}

	public void setPkIdCalzada(String pkIdCalzada) {
		this.pkIdCalzada = pkIdCalzada;
	}

	public String getCiv() {
		return Civ;
	}

	public void setCiv(String civ) {
		Civ = civ;
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Long getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}

	public Long getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Long idOrigen) {
		this.idOrigen = idOrigen;
	}

	public String getCodigoActividadAgrupada() {
		return codigoActividadAgrupada;
	}

	public void setCodigoActividadAgrupada(String codigoActividadAgrupada) {
		this.codigoActividadAgrupada = codigoActividadAgrupada;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}

	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}

	public int getIdProcesoGestion() {
		return idProcesoGestion;
	}

	public void setIdProcesoGestion(int idProcesoGestion) {
		this.idProcesoGestion = idProcesoGestion;
	}
	
	
	public CodTipoGestion getTipoGestion() {
		return tipoGestion;
	}

	public void setTipoGestion(CodTipoGestion tipoGestion) {
		this.tipoGestion = tipoGestion;
	}

    
	public int getIdActividadTransicion() {
		return idActividadTransicion;
	}

	public void setIdActividadTransicion(int idActividadTransicion) {
		this.idActividadTransicion = idActividadTransicion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEnviarCorreo() {
		return enviarCorreo;
	}

	public void setEnviarCorreo(String enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}

	public String getJsonForInicioGestion() 
	{
	    Map<String, Object> m = new HashMap<>();
	    m.put("idProcesoGestion", this.getIdProcesoGestion());
	    m.put("usuario", this.getUsuario());
		    
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString="";
	    
		try {
			jsonString = mapper.writeValueAsString(m);
		} catch (JsonProcessingException e) {
			jsonString="";
		}
	    return jsonString;
	}
	
	public String getJsonForAvanzarGestion() 
	{
	    Map<String, Object> m = new HashMap<>();
	    m.put("enviarCorreo", this.getEnviarCorreo());
	    m.put("observacion", this.getObservacion());
	    m.put("idUsuario", this.getIdUsuario());
	    m.put("idActividadTransicion", this.getIdActividadTransicion());
		m.put("idProcesoGestion", this.getIdProcesoGestion());
		m.put("usuario", this.getUsuario());
		    
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString="";
	    
		try {
			jsonString = mapper.writeValueAsString(m);
		} catch (JsonProcessingException e) {
			jsonString="";
		}
	    return jsonString;
	}

	
	public String getJsonForAvanzarGestion(int idProcesoGestion) 
	{
	    Map<String, Object> m = new HashMap<>();
	    m.put("enviarCorreo", this.getEnviarCorreo());
	    m.put("observacion", this.getObservacion());
	    m.put("idUsuario", this.getIdUsuario());
	    m.put("idActividadTransicion", this.getIdActividadTransicion());
		m.put("idProcesoGestion", idProcesoGestion);
		m.put("usuario", this.getUsuario());
		    
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString="";
	    
		try {
			jsonString = mapper.writeValueAsString(m);
		} catch (JsonProcessingException e) {
			jsonString="";
		}
	    return jsonString;
	}

	
	public String getJsonForEvaluarAsignacion() 
	{
	    Map<String, Object> m = new HashMap<>();
	    m.put("idActividadTransicion", this.getIdActividadTransicion());
		m.put("idProcesoGestion", this.getIdProcesoGestion());
		m.put("usuario", this.getUsuario());
		    
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString="";
	    
		try {
			jsonString = mapper.writeValueAsString(m);
		} catch (JsonProcessingException e) {
			jsonString="";
		}
	    return jsonString;
	}
	
	public String getJson()
	{
		
		ObjectMapper mapper = new ObjectMapper();
	      
	    String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return jsonString;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}



	
	
	
	
}
