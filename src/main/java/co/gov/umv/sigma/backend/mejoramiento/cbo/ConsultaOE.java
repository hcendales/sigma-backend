package co.gov.umv.sigma.backend.mejoramiento.cbo;

import java.util.Date;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class ConsultaOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3847834134403841583L;

	private Long idMantenimientoGestion;
	
	private Long idActividad;
	
	private String listaRoles;
	
	private Long idMantenimientoVial;
	
	private Date fechaDesde;
	
	private Date fechaHasta;
	
	private String listaUsuarios;
	
	private String usuarioProgramado;
	
	private Long idTipoOrigen;
	
	private String pkIdCalzada;
	
	private Long idLocalidad;
	
	private Long idZona;
	
	private Long idUPZ;
	
	private Long idTipoEstadoPk;
	
	private Long idTipoUsoVia;
	
	private Long idUPLA;
	
	private Long idBarrio;
	
	private Long idCuadrante;
	
	private Long idTipoMalla;
	
	private Long idTipoEstadoProgVisita;
	
	private Long idPersonaResponsableVisit;
	
	private Long idTipoTransitabilidad;
	
	private Long idTipoImpactoSocial;
	
	private Long idTipoDeterminacionInterv;
	
	private Long idTipoAporteMetas;
	
	private Long idTipoCoordinacionInter;
	
	private Long idTipoCalificacionPCI;
	
	private Long idZonaEABESP;
	
	private Long idTipoSeccionVial;
	
	private Long idTipoPrograma;
	
	private Long idTipoEstrategia;
	
	private Long idTipoActividad;
	
	private Long idTipoEjecucion;
	
	private Long idTipoClase;
	
	private Long idPersonaResponsableVerif;
	
	private Long idPersonaDirectorObra;
	
	private Long idPersonaResidenteSocial;
	
	private Long idPersonaResidenteAmbiental;
	
	private Long idPersonaResidenteSST;
	
	private Long idTipoPMT;
	
	private Long idTipoEstadoPMT;
	
	private Long idPersonaResidenteObra;
	
	private Long idTipoSuperficie;
	
	private Long idTipoVia;
	
	private Date fechaVisitaTecnicaDesde;
	
	private Date fechaVisitaTecnicaHasta;
	
	private Date fechaVisitaVerificaDesde;
	
	private Date fechaVisitaVerificaHasta;
	
	private Long civ;
	
	private Date fechaFinGestionDesde;
	
	private Date fechaFinGestionHasta;
	
	private Long idPersona;
	
	private Long idResponsableVisita;
	
	private String codSector;
	private String codUPL;
	private String codLocalidad;
	private Long codCuadrante;

	private Long idMantenimientoVialEvento;
	

	private Long idAlternativaDisenio;
	private Long idProgramacionDiaria;

	private Long idUnidadMuestreo;
	
	private Long diasUltimaVisita;
	
	private String idsMantenimientoVial ;
	
	public Long getIdResponsableVisita() {
		return idResponsableVisita;
	}

	public void setIdResponsableVisita(Long idResponsableVisita) {
		this.idResponsableVisita = idResponsableVisita;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdMantenimientoGestion() {
		return idMantenimientoGestion;
	}

	public void setIdMantenimientoGestion(Long idMantenimientoGestion) {
		this.idMantenimientoGestion = idMantenimientoGestion;
	}

	public String getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(String listaRoles) {
		this.listaRoles = listaRoles;
	}

	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}

	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(String listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String getUsuarioProgramado() {
		return usuarioProgramado;
	}

	public void setUsuarioProgramado(String usuarioProgramado) {
		this.usuarioProgramado = usuarioProgramado;
	}

	public Long getIdTipoOrigen() {
		return idTipoOrigen;
	}

	public void setIdTipoOrigen(Long idTipoOrigen) {
		this.idTipoOrigen = idTipoOrigen;
	}

	public String getPkIdCalzada() {
		return pkIdCalzada;
	}

	public void setPkIdCalzada(String pkIdCalzada) {
		this.pkIdCalzada = pkIdCalzada;
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public Long getIdUPZ() {
		return idUPZ;
	}

	public void setIdUPZ(Long idUPZ) {
		this.idUPZ = idUPZ;
	}

	public Long getIdTipoEstadoPk() {
		return idTipoEstadoPk;
	}

	public void setIdTipoEstadoPk(Long idTipoEstadoPk) {
		this.idTipoEstadoPk = idTipoEstadoPk;
	}

	public Long getIdTipoUsoVia() {
		return idTipoUsoVia;
	}

	public void setIdTipoUsoVia(Long idTipoUsoVia) {
		this.idTipoUsoVia = idTipoUsoVia;
	}

	public Long getIdUPLA() {
		return idUPLA;
	}

	public void setIdUPLA(Long idUPLA) {
		this.idUPLA = idUPLA;
	}

	public Long getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}

	public Long getIdCuadrante() {
		return idCuadrante;
	}

	public void setIdCuadrante(Long idCuadrante) {
		this.idCuadrante = idCuadrante;
	}

	public Long getIdTipoMalla() {
		return idTipoMalla;
	}

	public void setIdTipoMalla(Long idTipoMalla) {
		this.idTipoMalla = idTipoMalla;
	}

	public Long getIdTipoEstadoProgVisita() {
		return idTipoEstadoProgVisita;
	}

	public void setIdTipoEstadoProgVisita(Long idTipoEstadoProgVisita) {
		this.idTipoEstadoProgVisita = idTipoEstadoProgVisita;
	}

	public Long getIdPersonaResponsableVisit() {
		return idPersonaResponsableVisit;
	}

	public void setIdPersonaResponsableVisit(Long idPersonaResponsableVisit) {
		this.idPersonaResponsableVisit = idPersonaResponsableVisit;
	}

	public Long getIdTipoTransitabilidad() {
		return idTipoTransitabilidad;
	}

	public void setIdTipoTransitabilidad(Long idTipoTransitabilidad) {
		this.idTipoTransitabilidad = idTipoTransitabilidad;
	}

	public Long getIdTipoImpactoSocial() {
		return idTipoImpactoSocial;
	}

	public void setIdTipoImpactoSocial(Long idTipoImpactoSocial) {
		this.idTipoImpactoSocial = idTipoImpactoSocial;
	}

	public Long getIdTipoDeterminacionInterv() {
		return idTipoDeterminacionInterv;
	}

	public void setIdTipoDeterminacionInterv(Long idTipoDeterminacionInterv) {
		this.idTipoDeterminacionInterv = idTipoDeterminacionInterv;
	}

	public Long getIdTipoAporteMetas() {
		return idTipoAporteMetas;
	}

	public void setIdTipoAporteMetas(Long idTipoAporteMetas) {
		this.idTipoAporteMetas = idTipoAporteMetas;
	}

	public Long getIdTipoCoordinacionInter() {
		return idTipoCoordinacionInter;
	}

	public void setIdTipoCoordinacionInter(Long idTipoCoordinacionInter) {
		this.idTipoCoordinacionInter = idTipoCoordinacionInter;
	}

	public Long getIdTipoCalificacionPCI() {
		return idTipoCalificacionPCI;
	}

	public void setIdTipoCalificacionPCI(Long idTipoCalificacionPCI) {
		this.idTipoCalificacionPCI = idTipoCalificacionPCI;
	}

	public Long getIdZonaEABESP() {
		return idZonaEABESP;
	}

	public void setIdZonaEABESP(Long idZonaEABESP) {
		this.idZonaEABESP = idZonaEABESP;
	}

	public Long getIdTipoSeccionVial() {
		return idTipoSeccionVial;
	}

	public void setIdTipoSeccionVial(Long idTipoSeccionVial) {
		this.idTipoSeccionVial = idTipoSeccionVial;
	}

	public Long getIdTipoPrograma() {
		return idTipoPrograma;
	}

	public void setIdTipoPrograma(Long idTipoPrograma) {
		this.idTipoPrograma = idTipoPrograma;
	}

	public Long getIdTipoEstrategia() {
		return idTipoEstrategia;
	}

	public void setIdTipoEstrategia(Long idTipoEstrategia) {
		this.idTipoEstrategia = idTipoEstrategia;
	}

	public Long getIdTipoActividad() {
		return idTipoActividad;
	}

	public void setIdTipoActividad(Long idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
	}

	public Long getIdTipoEjecucion() {
		return idTipoEjecucion;
	}

	public void setIdTipoEjecucion(Long idTipoEjecucion) {
		this.idTipoEjecucion = idTipoEjecucion;
	}

	public Long getIdTipoClase() {
		return idTipoClase;
	}

	public void setIdTipoClase(Long idTipoClase) {
		this.idTipoClase = idTipoClase;
	}

	public Long getIdPersonaResponsableVerif() {
		return idPersonaResponsableVerif;
	}

	public void setIdPersonaResponsableVerif(Long idPersonaResponsableVerif) {
		this.idPersonaResponsableVerif = idPersonaResponsableVerif;
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

	public Long getIdPersonaResidenteAmbiental() {
		return idPersonaResidenteAmbiental;
	}

	public void setIdPersonaResidenteAmbiental(Long idPersonaResidenteAmbiental) {
		this.idPersonaResidenteAmbiental = idPersonaResidenteAmbiental;
	}

	public Long getIdTipoPMT() {
		return idTipoPMT;
	}

	public void setIdTipoPMT(Long idTipoPMT) {
		this.idTipoPMT = idTipoPMT;
	}

	public Long getIdTipoEstadoPMT() {
		return idTipoEstadoPMT;
	}

	public void setIdTipoEstadoPMT(Long idTipoEstadoPMT) {
		this.idTipoEstadoPMT = idTipoEstadoPMT;
	}

	public Long getIdPersonaResidenteObra() {
		return idPersonaResidenteObra;
	}

	public void setIdPersonaResidenteObra(Long idPersonaResidenteObra) {
		this.idPersonaResidenteObra = idPersonaResidenteObra;
	}

	public Long getIdTipoSuperficie() {
		return idTipoSuperficie;
	}

	public void setIdTipoSuperficie(Long idTipoSuperficie) {
		this.idTipoSuperficie = idTipoSuperficie;
	}

	public Long getIdTipoVia() {
		return idTipoVia;
	}

	public void setIdTipoVia(Long idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	public Date getFechaVisitaTecnicaDesde() {
		return fechaVisitaTecnicaDesde;
	}

	public void setFechaVisitaTecnicaDesde(Date fechaVisitaTecnicaDesde) {
		this.fechaVisitaTecnicaDesde = fechaVisitaTecnicaDesde;
	}

	public Date getFechaVisitaTecnicaHasta() {
		return fechaVisitaTecnicaHasta;
	}

	public void setFechaVisitaTecnicaHasta(Date fechaVisitaTecnicaHasta) {
		this.fechaVisitaTecnicaHasta = fechaVisitaTecnicaHasta;
	}

	public Date getFechaVisitaVerificaDesde() {
		return fechaVisitaVerificaDesde;
	}

	public void setFechaVisitaVerificaDesde(Date fechaVisitaVerificaDesde) {
		this.fechaVisitaVerificaDesde = fechaVisitaVerificaDesde;
	}

	public Date getFechaVisitaVerificaHasta() {
		return fechaVisitaVerificaHasta;
	}

	public void setFechaVisitaVerificaHasta(Date fechaVisitaVerificaHasta) {
		this.fechaVisitaVerificaHasta = fechaVisitaVerificaHasta;
	}

	public Long getCiv() {
		return civ;
	}

	public void setCiv(Long civ) {
		this.civ = civ;
	}

	public Date getFechaFinGestionDesde() {
		return fechaFinGestionDesde;
	}

	public void setFechaFinGestionDesde(Date fechaFinGestionDesde) {
		this.fechaFinGestionDesde = fechaFinGestionDesde;
	}

	public Date getFechaFinGestionHasta() {
		return fechaFinGestionHasta;
	}

	public void setFechaFinGestionHasta(Date fechaFinGestionHasta) {
		this.fechaFinGestionHasta = fechaFinGestionHasta;
	}

	public Long getIdPersonaResidenteSST() {
		return idPersonaResidenteSST;
	}

	public void setIdPersonaResidenteSST(Long idPersonaResidenteSST) {
		this.idPersonaResidenteSST = idPersonaResidenteSST;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public String getCodSector() {
		return codSector;
	}

	public void setCodSector(String codSector) {
		this.codSector = codSector;
	}

	public String getCodUPL() {
		return codUPL;
	}

	public void setCodUPL(String codUPL) {
		this.codUPL = codUPL;
	}

	public String getCodLocalidad() {
		return codLocalidad;
	}

	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}

	public Long getCodCuadrante() {
		return codCuadrante;
	}

	public void setCodCuadrante(Long codCuadrante) {
		this.codCuadrante = codCuadrante;
	}

	public Long getIdMantenimientoVialEvento() {
		return idMantenimientoVialEvento;
	}

	public void setIdMantenimientoVialEvento(Long idMantenimientoVialEvento) {
		this.idMantenimientoVialEvento = idMantenimientoVialEvento;
	}

	public Long getIdUnidadMuestreo() {
		return idUnidadMuestreo;
	}

	public void setIdUnidadMuestreo(Long idUnidadMuestreo) {
		this.idUnidadMuestreo = idUnidadMuestreo;
	}

	public Long getDiasUltimaVisita() {
		return diasUltimaVisita;
	}

	public void setDiasUltimaVisita(Long diasUltimaVisita) {
		this.diasUltimaVisita = diasUltimaVisita;
	}

	public Long getIdAlternativaDisenio() {
		return idAlternativaDisenio;
	}

	public void setIdAlternativaDisenio(Long idAlternativaDisenio) {
		this.idAlternativaDisenio = idAlternativaDisenio;
	}

	public Long getIdProgramacionDiaria() {
		return idProgramacionDiaria;
	}

	public void setIdProgramacionDiaria(Long idProgramacionDiaria) {
		this.idProgramacionDiaria = idProgramacionDiaria;
	}

	public String getIdsMantenimientoVial() {
		return idsMantenimientoVial;
	}

	public void setIdsMantenimientoVial(String idsMantenimientoVial) {
		this.idsMantenimientoVial = idsMantenimientoVial;
	}

	
	
	
	
	


}
