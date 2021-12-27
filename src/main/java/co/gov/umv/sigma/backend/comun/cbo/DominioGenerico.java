package co.gov.umv.sigma.backend.comun.cbo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DominioGenerico 
{
	
	private String descripcion;
	private String auditoria_usuario;
	private long id_lista; 
	private String registro_activo; 
	private String valor; 
	private long id_tipo; 
	private long auditoria_fecha; 
	private String nombre_lista;
	private String usuario;
	
	public DominioGenerico()
	{
		super();
	}
	
	public DominioGenerico(String descripcion, String auditoria_usuario, long id_lista, String registro_activo,
			String valor, long id_tipo, long auditoria_fecha, String nombre_lista) {
		super();
		this.descripcion = descripcion;
		this.auditoria_usuario = auditoria_usuario;
		this.id_lista = id_lista;
		this.registro_activo = registro_activo;
		this.valor = valor;
		this.id_tipo = id_tipo;
		
		this.auditoria_fecha = auditoria_fecha ;
		this.nombre_lista = nombre_lista;
	}

	public DominioGenerico(String usuario, int id_lista) {
		super();
		this.usuario = usuario;
		setId_lista(id_lista);
	}
	
	private String getFiltro()
	{
		return "id_lista="+id_lista;
	}
	
	public String getJsonForFiltro() 
	{
	    Map<String, Object> m = new HashMap<>();
	    m.put("usuario", this.getUsuario());
	    m.put("filtro", this.getFiltro());
	        
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAuditoria_usuario() {
		return auditoria_usuario;
	}

	public void setAuditoria_usuario(String auditoria_usuario) {
		this.auditoria_usuario = auditoria_usuario;
	}

	public long getId_lista() {
		return id_lista;
	}

	public void setId_lista(long id_lista) {
		this.id_lista = id_lista;
	}

	public String getRegistro_activo() {
		return registro_activo;
	}

	public void setRegistro_activo(String registro_activo) {
		this.registro_activo = registro_activo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public long getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Date getAuditoria_fecha() 
	{
		Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(auditoria_fecha);
        return calendar.getTime();
		
	}

	public void setAuditoria_fecha(long auditoria_fecha) {
		this.auditoria_fecha = auditoria_fecha;
	}

	public String getNombre_lista() {
		return nombre_lista;
	}

	public void setNombre_lista(String nombre_lista) {
		this.nombre_lista = nombre_lista;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
		
	
}
