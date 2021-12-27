package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TabAforo2 implements Serializable {
	private Long idAforo;
    private Date fechaAforo;
    private String digital;
    private Long idCargue;
    private String origenInformacion;
    private String observaciones;
    private BigDecimal tpdTotal;
    private BigDecimal fdSitpAlimentadores;
    private BigDecimal fdVan;
    private BigDecimal fdBusesBusetas;
    private BigDecimal fdC2p;
    private BigDecimal fdC2g;
    private BigDecimal fdC3C4;
    private BigDecimal fdC5C5;
    private BigDecimal tasaCrecimientoR;
    private BigDecimal factorDireccionalFd;
    private BigDecimal factorDistribucionCarrilFdc;
    private String analisisReferencias;
    private String analisisObservaciones;
    private BigDecimal analisisNee82;
    private short anios82;
    private BigDecimal analisis2Nee82;
    private short anios282;
    private BigDecimal analisisTpdVComerciales35;
    private short anios35;
    private BigDecimal automoviles;
    private BigDecimal busesVan;
    private BigDecimal busesBuseta;
    private BigDecimal busesSitpAlimentadores;
	private BigDecimal camionesC2p;
    private BigDecimal camionesC2g;
    private BigDecimal camionesC3C4;
    private BigDecimal camionesC5C5;
    private BigDecimal vcAcumulados;
    private String auditoriaUsuario;
    private Date auditoriaFecha;
    private Long idDocumentoPdf;
    private List<TabAforoAnalisis> tabAforoAnalisisList;
    private List<TabAforoCalzada> tabAforoCalzadaList;
    private List<TabAforoDato> tabAforoDatoList;
   
	public Long getIdAforo() {
		return idAforo;
	}

	public Date getFechaAforo() {
		return fechaAforo;
	}

	public String getDigital() {
		return digital;
	}

	public Long getIdCargue() {
		return idCargue;
	}

	public String getOrigenInformacion() {
		return origenInformacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public BigDecimal getTpdTotal() {
		return tpdTotal;
	}

	public BigDecimal getFdSitpAlimentadores() {
		return fdSitpAlimentadores;
	}

	public BigDecimal getFdVan() {
		return fdVan;
	}

	public BigDecimal getFdBusesBusetas() {
		return fdBusesBusetas;
	}

	public BigDecimal getFdC2p() {
		return fdC2p;
	}

	public BigDecimal getFdC2g() {
		return fdC2g;
	}

	public BigDecimal getFdC3C4() {
		return fdC3C4;
	}

	public BigDecimal getFdC5C5() {
		return fdC5C5;
	}

	public BigDecimal getTasaCrecimientoR() {
		return tasaCrecimientoR;
	}

	public BigDecimal getFactorDireccionalFd() {
		return factorDireccionalFd;
	}

	public BigDecimal getFactorDistribucionCarrilFdc() {
		return factorDistribucionCarrilFdc;
	}

	public String getAnalisisReferencias() {
		return analisisReferencias;
	}

	public String getAnalisisObservaciones() {
		return analisisObservaciones;
	}

	public BigDecimal getAnalisisNee82() {
		return analisisNee82;
	}

	public short getAnios82() {
		return anios82;
	}

	public BigDecimal getAnalisis2Nee82() {
		return analisis2Nee82;
	}

	public short getAnios282() {
		return anios282;
	}

	public BigDecimal getAnalisisTpdVComerciales35() {
		return analisisTpdVComerciales35;
	}

	public short getAnios35() {
		return anios35;
	}


	public String getAuditoriaUsuario() {
		return auditoriaUsuario;
	}

	public Date getAuditoriaFecha() {
		return auditoriaFecha;
	}

	public Long getIdDocumentoPdf() {
		return idDocumentoPdf;
	}

	public List<TabAforoAnalisis> getTabAforoAnalisisList() {
		return tabAforoAnalisisList;
	}

	public List<TabAforoCalzada> getTabAforoCalzadaList() {
		return tabAforoCalzadaList;
	}

	public List<TabAforoDato> getTabAforoDatoList() {
		return tabAforoDatoList;
	}

	public void setIdAforo(Long idAforo) {
		this.idAforo = idAforo;
	}

	public void setFechaAforo(Date fechaAforo) {
		this.fechaAforo = fechaAforo;
	}

	public void setDigital(String digital) {
		this.digital = digital;
	}

	public void setIdCargue(Long idCargue) {
		this.idCargue = idCargue;
	}

	public void setOrigenInformacion(String origenInformacion) {
		this.origenInformacion = origenInformacion;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setTpdTotal(BigDecimal tpdTotal) {
		this.tpdTotal = tpdTotal;
	}

	public void setFdSitpAlimentadores(BigDecimal fdSitpAlimentadores) {
		this.fdSitpAlimentadores = fdSitpAlimentadores;
	}

	public void setFdVan(BigDecimal fdVan) {
		this.fdVan = fdVan;
	}

	public void setFdBusesBusetas(BigDecimal fdBusesBusetas) {
		this.fdBusesBusetas = fdBusesBusetas;
	}

	public void setFdC2p(BigDecimal fdC2p) {
		this.fdC2p = fdC2p;
	}

	public void setFdC2g(BigDecimal fdC2g) {
		this.fdC2g = fdC2g;
	}

	public void setFdC3C4(BigDecimal fdC3C4) {
		this.fdC3C4 = fdC3C4;
	}

	public void setFdC5C5(BigDecimal fdC5C5) {
		this.fdC5C5 = fdC5C5;
	}

	public void setTasaCrecimientoR(BigDecimal tasaCrecimientoR) {
		this.tasaCrecimientoR = tasaCrecimientoR;
	}

	public void setFactorDireccionalFd(BigDecimal factorDireccionalFd) {
		this.factorDireccionalFd = factorDireccionalFd;
	}

	public void setFactorDistribucionCarrilFdc(BigDecimal factorDistribucionCarrilFdc) {
		this.factorDistribucionCarrilFdc = factorDistribucionCarrilFdc;
	}

	public void setAnalisisReferencias(String analisisReferencias) {
		this.analisisReferencias = analisisReferencias;
	}

	public void setAnalisisObservaciones(String analisisObservaciones) {
		this.analisisObservaciones = analisisObservaciones;
	}

	public void setAnalisisNee82(BigDecimal analisisNee82) {
		this.analisisNee82 = analisisNee82;
	}

	public void setAnios82(short anios82) {
		this.anios82 = anios82;
	}

	public void setAnalisis2Nee82(BigDecimal analisis2Nee82) {
		this.analisis2Nee82 = analisis2Nee82;
	}

	public void setAnios282(short anios282) {
		this.anios282 = anios282;
	}

	public void setAnalisisTpdVComerciales35(BigDecimal analisisTpdVComerciales35) {
		this.analisisTpdVComerciales35 = analisisTpdVComerciales35;
	}

	public void setAnios35(short anios35) {
		this.anios35 = anios35;
	}


	public void setAuditoriaUsuario(String auditoriaUsuario) {
		this.auditoriaUsuario = auditoriaUsuario;
	}

	public void setAuditoriaFecha(Date auditoriaFecha) {
		this.auditoriaFecha = auditoriaFecha;
	}

	public void setIdDocumentoPdf(Long idDocumentoPdf) {
		this.idDocumentoPdf = idDocumentoPdf;
	}

	public void setTabAforoAnalisisList(List<TabAforoAnalisis> tabAforoAnalisisList) {
		this.tabAforoAnalisisList = tabAforoAnalisisList;
	}

	public void setTabAforoCalzadaList(List<TabAforoCalzada> tabAforoCalzadaList) {
		this.tabAforoCalzadaList = tabAforoCalzadaList;
	}

	public void setTabAforoDatoList(List<TabAforoDato> tabAforoDatoList) {
		this.tabAforoDatoList = tabAforoDatoList;
	}
	
    public BigDecimal getAutomoviles() {
		return automoviles;
	}

	public BigDecimal getBusesVan() {
		return busesVan;
	}

	public BigDecimal getBusesBuseta() {
		return busesBuseta;
	}

	public BigDecimal getBusesSitpAlimentadores() {
		return busesSitpAlimentadores;
	}

	public BigDecimal getCamionesC2p() {
		return camionesC2p;
	}

	public BigDecimal getCamionesC2g() {
		return camionesC2g;
	}

	public BigDecimal getCamionesC3C4() {
		return camionesC3C4;
	}

	public BigDecimal getCamionesC5C5() {
		return camionesC5C5;
	}

	public BigDecimal getVcAcumulados() {
		return vcAcumulados;
	}

	public void setAutomoviles(BigDecimal automoviles) {
		this.automoviles = automoviles;
	}

	public void setBusesVan(BigDecimal busesVan) {
		this.busesVan = busesVan;
	}

	public void setBusesBuseta(BigDecimal busesBuseta) {
		this.busesBuseta = busesBuseta;
	}

	public void setBusesSitpAlimentadores(BigDecimal busesSitpAlimentadores) {
		this.busesSitpAlimentadores = busesSitpAlimentadores;
	}

	public void setCamionesC2p(BigDecimal camionesC2p) {
		this.camionesC2p = camionesC2p;
	}

	public void setCamionesC2g(BigDecimal camionesC2g) {
		this.camionesC2g = camionesC2g;
	}

	public void setCamionesC3C4(BigDecimal camionesC3C4) {
		this.camionesC3C4 = camionesC3C4;
	}

	public void setCamionesC5C5(BigDecimal camionesC5C5) {
		this.camionesC5C5 = camionesC5C5;
	}

	public void setVcAcumulados(BigDecimal vcAcumulados) {
		this.vcAcumulados = vcAcumulados;
	}
}
