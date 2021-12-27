package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TabMantenimientoEquipo {

	private Long 	idMantenimientoEquipo;
	private Integer consecutivo;
	private String 	codigo;
	private Long 	idEquipo;
	private Integer tipo;
	private String 	descripcionFallo;
	private Integer ingresoComoFallo;
	private Integer idVarControlFallo;
	private Double 	valorVarFallo;
	private String 	ubicacion;
	private String 	descripcionMtto;
	private Date 	fecha;
	private Integer idVarControlMtto;
	private Double 	valorVarMtto;
	private Long 	idPersonaReporto;  //la que programa 
	private String 	cargo;
	private Long 	contrato;
	private Integer idTipoMantenimiento;
	private String 	motivoCancelacion;
	private Integer estado;
	private String  sigla;

	private Long 	idUsuarioReportoFallo;  //la que reporta el fallo 

	private Long idLugar;
	
	 public void ajustarParametrosSoloFallo()
	 {
		setTipo(1); //correctivo
		setIngresoComoFallo(1); //si entro como fallo
		setEstado(4771); //esta activo
		setDescripcionMtto(null);
		setFecha(null);
		setIdPersonaReporto(null);
		setCargo(null);
		setContrato(null);
		setIdTipoMantenimiento(null);
		setMotivoCancelacion(null);
		setIdVarControlMtto(null);
		setValorVarMtto(null);
	 }
	 
	 
	public void ingresarComoFallo(boolean estaComoMtto) 
	{
		setTipo(1); //correctivo
		setIngresoComoFallo(1); //si entro como fallo
		setEstado(4771); //esta activo
		setConsecutivo(0);
		
		if(!estaComoMtto) ajustarParametrosSoloFallo();
	}
	
	public void ajustarCodigo()
	{
		Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        setCodigo(getSigla()+"-"+String.valueOf(year)+"-");

	}
	
	public void igresarcomoMantenimiento() 
	{
		ajustarCodigo();
		setIngresoComoFallo(0); //si entro como fallo
		setEstado(4771); //esta activo
	}


	public Long getIdMantenimientoEquipo() {
		return idMantenimientoEquipo;
	}


	public void setIdMantenimientoEquipo(Long idMantenimientoEquipo) {
		this.idMantenimientoEquipo = idMantenimientoEquipo;
	}


	public Integer getConsecutivo() {
		return consecutivo;
	}


	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Long getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public String getDescripcionFallo() {
		return descripcionFallo;
	}


	public void setDescripcionFallo(String descripcionFallo) {
		this.descripcionFallo = descripcionFallo;
	}


	public Integer getIngresoComoFallo() {
		return ingresoComoFallo;
	}


	public void setIngresoComoFallo(Integer ingresoComoFallo) {
		this.ingresoComoFallo = ingresoComoFallo;
	}


	public Integer getIdVarControlFallo() {
		return idVarControlFallo;
	}


	public void setIdVarControlFallo(Integer idVarControlFallo) {
		this.idVarControlFallo = idVarControlFallo;
	}


	public Double getValorVarFallo() {
		return valorVarFallo;
	}


	public void setValorVarFallo(Double valorVarFallo) {
		this.valorVarFallo = valorVarFallo;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getDescripcionMtto() {
		return descripcionMtto;
	}


	public void setDescripcionMtto(String descripcionMtto) {
		this.descripcionMtto = descripcionMtto;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Integer getIdVarControlMtto() {
		return idVarControlMtto;
	}


	public void setIdVarControlMtto(Integer idVarControlMtto) {
		this.idVarControlMtto = idVarControlMtto;
	}


	public Double getValorVarMtto() {
		return valorVarMtto;
	}


	public void setValorVarMtto(Double valorVarMtto) {
		this.valorVarMtto = valorVarMtto;
	}


	public Long getIdPersonaReporto() {
		return idPersonaReporto;
	}


	public void setIdPersonaReporto(Long idPersonaReporto) {
		this.idPersonaReporto = idPersonaReporto;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Long getContrato() {
		return contrato;
	}


	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}


	public Integer getIdTipoMantenimiento() {
		return idTipoMantenimiento;
	}


	public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
		this.idTipoMantenimiento = idTipoMantenimiento;
	}


	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}


	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public Long getIdUsuarioReportoFallo() {
		return idUsuarioReportoFallo;
	}


	public void setIdUsuarioReportoFallo(Long idUsuarioReportoFallo) {
		this.idUsuarioReportoFallo = idUsuarioReportoFallo;
	}


	public Long getIdLugar() {
		return idLugar;
	}


	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}

	
	
	
}
