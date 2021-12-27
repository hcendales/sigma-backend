package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.util.Date;

public class TabEnsayo implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8171052329645314543L;
	
	private Long 	idEnsayo;
	private Long 	idDocumento;
	private Long 	idTipoServicio;
	private Long 	idTipoGrupo;
	private String 	subgrupo;
	private Long 	idTipoIntervencion;
	private String 	codigoEnsayo;
	private Date 	fechaSolicitud;
	private Date 	fechaProgramada;
	private Date 	fechaRecepcion;
	private Date 	fechaInstalacionMezcla;
	private Long 	version;
	private String 	hora;
	private Long 	idPersonaDirectorObra;
	private Long 	idPersonaResidenteSocial;
	private Long 	telefonoDirectorObra;
	private Long 	telefonoResidenteSocial;
	private String 	direccion;
	private Long 	mes;
	private Long 	anio;
	private String 	consecutivo;
	private String 	placa;
	private String 	idLote;
	private String 	idJornada;
	private Long 	idCapas;
	private String 	idFrecuencia;
	private String 	idPerfil;
	private String 	idPlanta;
	private String 	idObra;
	private String 	idUsuarioSolicitud;
	private String 	idUsuarioRecibeMuestra;
	private String 	procedenciaMuestra;
	private Long 	cantidadFrecuencia;
	private String 	idTipoObservacion;
	private Long 	apiques;
	private String 	actividad;
	private Long 	espesor;
	private String 	origen;
	private String 	mezclaFormula;
	private String 	descripcion;
	private String 	observacion;
	private String 	novedades;
	private String 	idTipoCantidad;
	private Long 	prioridad;
	private String 	idResponsableToma;
	private Date 	fechaToma;
	private String  situacion;
	
	public Long getIdEnsayo() {
		return idEnsayo;
	}
	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	public Long getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}
	public Long getIdTipoServicio() {
		return idTipoServicio;
	}
	public void setIdTipoServicio(Long idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}
	public Long getIdTipoGrupo() {
		return idTipoGrupo;
	}
	public void setIdTipoGrupo(Long idTipoGrupo) {
		this.idTipoGrupo = idTipoGrupo;
	}
	public String getSubgrupo() {
		return subgrupo;
	}
	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}
	public Long getIdTipoIntervencion() {
		return idTipoIntervencion;
	}
	public void setIdTipoIntervencion(Long idTipoIntervencion) {
		this.idTipoIntervencion = idTipoIntervencion;
	}
	public String getCodigoEnsayo() {
		return codigoEnsayo;
	}
	public void setCodigoEnsayo(String codigoEnsayo) {
		this.codigoEnsayo = codigoEnsayo;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaProgramada() {
		return fechaProgramada;
	}
	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public Date getFechaInstalacionMezcla() {
		return fechaInstalacionMezcla;
	}
	public void setFechaInstalacionMezcla(Date fechaInstalacionMezcla) {
		this.fechaInstalacionMezcla = fechaInstalacionMezcla;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Long getIdPersonaDirectorObra() {
		return idPersonaDirectorObra;
	}
	public void setIdPersonaDirectorObra(Long idPersonaDirectorObra) {
		this.idPersonaDirectorObra = idPersonaDirectorObra;
	}
	public Long getIdPersonaResidenteSocial() {
		return idPersonaResidenteSocial;
	}
	public void setIdPersonaResidenteSocial(Long idPersonaResidenteSocial) {
		this.idPersonaResidenteSocial = idPersonaResidenteSocial;
	}
	public Long getTelefonoDirectorObra() {
		return telefonoDirectorObra;
	}
	public void setTelefonoDirectorObra(Long telefonoDirectorObra) {
		this.telefonoDirectorObra = telefonoDirectorObra;
	}
	public Long getTelefonoResidenteSocial() {
		return telefonoResidenteSocial;
	}
	public void setTelefonoResidenteSocial(Long telefonoResidenteSocial) {
		this.telefonoResidenteSocial = telefonoResidenteSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getMes() {
		return mes;
	}
	public void setMes(Long mes) {
		this.mes = mes;
	}
	public Long getAnio() {
		return anio;
	}
	public void setAnio(Long anio) {
		this.anio = anio;
	}
	public String getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getIdLote() {
		return idLote;
	}
	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}
	public String getIdJornada() {
		return idJornada;
	}
	public void setIdJornada(String idJornada) {
		this.idJornada = idJornada;
	}
	public Long getIdCapas() {
		return idCapas;
	}
	public void setIdCapas(Long idCapas) {
		this.idCapas = idCapas;
	}
	public String getIdFrecuencia() {
		return idFrecuencia;
	}
	public void setIdFrecuencia(String idFrecuencia) {
		this.idFrecuencia = idFrecuencia;
	}
	public String getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getIdPlanta() {
		return idPlanta;
	}
	public void setIdPlanta(String idPlanta) {
		this.idPlanta = idPlanta;
	}
	public String getIdObra() {
		return idObra;
	}
	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}
	public String getIdUsuarioSolicitud() {
		return idUsuarioSolicitud;
	}
	public void setIdUsuarioSolicitud(String idUsuarioSolicitud) {
		this.idUsuarioSolicitud = idUsuarioSolicitud;
	}
	public String getIdUsuarioRecibeMuestra() {
		return idUsuarioRecibeMuestra;
	}
	public void setIdUsuarioRecibeMuestra(String idUsuarioRecibeMuestra) {
		this.idUsuarioRecibeMuestra = idUsuarioRecibeMuestra;
	}
	public String getProcedenciaMuestra() {
		return procedenciaMuestra;
	}
	public void setProcedenciaMuestra(String procedenciaMuestra) {
		this.procedenciaMuestra = procedenciaMuestra;
	}
	public Long getCantidadFrecuencia() {
		return cantidadFrecuencia;
	}
	public void setCantidadFrecuencia(Long cantidadFrecuencia) {
		this.cantidadFrecuencia = cantidadFrecuencia;
	}
	public String getIdTipoObservacion() {
		return idTipoObservacion;
	}
	public void setIdTipoObservacion(String idTipoObservacion) {
		this.idTipoObservacion = idTipoObservacion;
	}
	public Long getApiques() {
		return apiques;
	}
	public void setApiques(Long apiques) {
		this.apiques = apiques;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public Long getEspesor() {
		return espesor;
	}
	public void setEspesor(Long espesor) {
		this.espesor = espesor;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getMezclaFormula() {
		return mezclaFormula;
	}
	public void setMezclaFormula(String mezclaFormula) {
		this.mezclaFormula = mezclaFormula;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getNovedades() {
		return novedades;
	}
	public void setNovedades(String novedades) {
		this.novedades = novedades;
	}
	public String getIdTipoCantidad() {
		return idTipoCantidad;
	}
	public void setIdTipoCantidad(String idTipoCantidad) {
		this.idTipoCantidad = idTipoCantidad;
	}
	public Long getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}
	public String getIdResponsableToma() {
		return idResponsableToma;
	}
	public void setIdResponsableToma(String idResponsableToma) {
		this.idResponsableToma = idResponsableToma;
	}
	public Date getFechaToma() {
		return fechaToma;
	}
	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}
	public String getSituacion() {
		return situacion;
	}
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
		
	
	

}
