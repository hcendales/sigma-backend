package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabProgramacionDiaria {

	private Long 	idProgramacionDiaria;
	private Long 	idMantenimientoVial;
	private Date 	fecha;
	private Long 	idTipoJornada;
	private Long 	idTipoEstadoProgramacion;
	private String 	horaTrabajoDesde;
	private String 	horaTrabajoHasta;
	private Long 	idPersonaElabora;
	private Long 	idPersonaRevisa;
	private Long 	idPersonaAprueba;
	private String 	observaciones;
	
	public Long getIdProgramacionDiaria() {
		return idProgramacionDiaria;
	}
	public void setIdProgramacionDiaria(Long idProgramacionDiaria) {
		this.idProgramacionDiaria = idProgramacionDiaria;
	}
	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}
	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getIdTipoJornada() {
		return idTipoJornada;
	}
	public void setIdTipoJornada(Long idTipoJornada) {
		this.idTipoJornada = idTipoJornada;
	}
	public Long getIdTipoEstadoProgramacion() {
		return idTipoEstadoProgramacion;
	}
	public void setIdTipoEstadoProgramacion(Long idTipoEstadoProgramacion) {
		this.idTipoEstadoProgramacion = idTipoEstadoProgramacion;
	}
	public String getHoraTrabajoDesde() {
		return horaTrabajoDesde;
	}
	public void setHoraTrabajoDesde(String horaTrabajoDesde) {
		this.horaTrabajoDesde = horaTrabajoDesde;
	}
	public String getHoraTrabajoHasta() {
		return horaTrabajoHasta;
	}
	public void setHoraTrabajoHasta(String horaTrabajoHasta) {
		this.horaTrabajoHasta = horaTrabajoHasta;
	}
	public Long getIdPersonaElabora() {
		return idPersonaElabora;
	}
	public void setIdPersonaElabora(Long idPersonaElabora) {
		this.idPersonaElabora = idPersonaElabora;
	}
	public Long getIdPersonaRevisa() {
		return idPersonaRevisa;
	}
	public void setIdPersonaRevisa(Long idPersonaRevisa) {
		this.idPersonaRevisa = idPersonaRevisa;
	}
	public Long getIdPersonaAprueba() {
		return idPersonaAprueba;
	}
	public void setIdPersonaAprueba(Long idPersonaAprueba) {
		this.idPersonaAprueba = idPersonaAprueba;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
