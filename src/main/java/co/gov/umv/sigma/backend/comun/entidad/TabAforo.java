/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_AFORO")
@XmlRootElement
//@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQueries({
    @NamedQuery(name = "TabAforo.findAll", query = "SELECT t FROM TabAforo t"),
    @NamedQuery(name = "TabAforo.findByIdAforo", query = "SELECT t FROM TabAforo t WHERE t.idAforo = :idAforo"),
    @NamedQuery(name = "TabAforo.findByFechaAforo", query = "SELECT t FROM TabAforo t WHERE t.fechaAforo = :fechaAforo"),
    @NamedQuery(name = "TabAforo.findByDigital", query = "SELECT t FROM TabAforo t WHERE t.digital = :digital"),
    @NamedQuery(name = "TabAforo.findByIdCargue", query = "SELECT t FROM TabAforo t WHERE t.idCargue = :idCargue"),
    @NamedQuery(name = "TabAforo.findByOrigenInformacion", query = "SELECT t FROM TabAforo t WHERE t.origenInformacion = :origenInformacion"),
    @NamedQuery(name = "TabAforo.findByObservaciones", query = "SELECT t FROM TabAforo t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabAforo.findByTpdTotal", query = "SELECT t FROM TabAforo t WHERE t.tpdTotal = :tpdTotal"),
    @NamedQuery(name = "TabAforo.findByFdSitpAlimentadores", query = "SELECT t FROM TabAforo t WHERE t.fdSitpAlimentadores = :fdSitpAlimentadores"),
    @NamedQuery(name = "TabAforo.findByFdVan", query = "SELECT t FROM TabAforo t WHERE t.fdVan = :fdVan"),
    @NamedQuery(name = "TabAforo.findByFdBusesBusetas", query = "SELECT t FROM TabAforo t WHERE t.fdBusesBusetas = :fdBusesBusetas"),
    @NamedQuery(name = "TabAforo.findByFdC2p", query = "SELECT t FROM TabAforo t WHERE t.fdC2p = :fdC2p"),
    @NamedQuery(name = "TabAforo.findByFdC2g", query = "SELECT t FROM TabAforo t WHERE t.fdC2g = :fdC2g"),
    @NamedQuery(name = "TabAforo.findByFdC3C4", query = "SELECT t FROM TabAforo t WHERE t.fdC3C4 = :fdC3C4"),
    @NamedQuery(name = "TabAforo.findByFdC5C5", query = "SELECT t FROM TabAforo t WHERE t.fdC5C5 = :fdC5C5"),
    @NamedQuery(name = "TabAforo.findByTasaCrecimientoR", query = "SELECT t FROM TabAforo t WHERE t.tasaCrecimientoR = :tasaCrecimientoR"),
    @NamedQuery(name = "TabAforo.findByFactorDireccionalFd", query = "SELECT t FROM TabAforo t WHERE t.factorDireccionalFd = :factorDireccionalFd"),
    @NamedQuery(name = "TabAforo.findByFactorDistribucionCarrilFdc", query = "SELECT t FROM TabAforo t WHERE t.factorDistribucionCarrilFdc = :factorDistribucionCarrilFdc"),
    @NamedQuery(name = "TabAforo.findByAnalisisReferencias", query = "SELECT t FROM TabAforo t WHERE t.analisisReferencias = :analisisReferencias"),
    @NamedQuery(name = "TabAforo.findByAnalisisObservaciones", query = "SELECT t FROM TabAforo t WHERE t.analisisObservaciones = :analisisObservaciones"),
    @NamedQuery(name = "TabAforo.findByAnalisisNee82", query = "SELECT t FROM TabAforo t WHERE t.analisisNee82 = :analisisNee82"),
    @NamedQuery(name = "TabAforo.findByAnios82", query = "SELECT t FROM TabAforo t WHERE t.anios82 = :anios82"),
    @NamedQuery(name = "TabAforo.findByAnalisis2Nee82", query = "SELECT t FROM TabAforo t WHERE t.analisis2Nee82 = :analisis2Nee82"),
    @NamedQuery(name = "TabAforo.findByAnios282", query = "SELECT t FROM TabAforo t WHERE t.anios282 = :anios282"),
    @NamedQuery(name = "TabAforo.findByAnalisisTpdVComerciales35", query = "SELECT t FROM TabAforo t WHERE t.analisisTpdVComerciales35 = :analisisTpdVComerciales35"),
    @NamedQuery(name = "TabAforo.findByAnios35", query = "SELECT t FROM TabAforo t WHERE t.anios35 = :anios35"),
    @NamedQuery(name = "TabAforo.findByTAutomoviles", query = "SELECT t FROM TabAforo t WHERE t.tAutomoviles = :tAutomoviles"),
    @NamedQuery(name = "TabAforo.findByTBusesVan", query = "SELECT t FROM TabAforo t WHERE t.tBusesVan = :tBusesVan"),
    @NamedQuery(name = "TabAforo.findByTBusesBuseta", query = "SELECT t FROM TabAforo t WHERE t.tBusesBuseta = :tBusesBuseta"),
    @NamedQuery(name = "TabAforo.findByTBusesSitpAlimentadores", query = "SELECT t FROM TabAforo t WHERE t.tBusesSitpAlimentadores = :tBusesSitpAlimentadores"),
    @NamedQuery(name = "TabAforo.findByTCamionesC2p", query = "SELECT t FROM TabAforo t WHERE t.tCamionesC2p = :tCamionesC2p"),
    @NamedQuery(name = "TabAforo.findByTCamionesC2g", query = "SELECT t FROM TabAforo t WHERE t.tCamionesC2g = :tCamionesC2g"),
    @NamedQuery(name = "TabAforo.findByTCamionesC3C4", query = "SELECT t FROM TabAforo t WHERE t.tCamionesC3C4 = :tCamionesC3C4"),
    @NamedQuery(name = "TabAforo.findByTCamionesC5C5", query = "SELECT t FROM TabAforo t WHERE t.tCamionesC5C5 = :tCamionesC5C5"),
    @NamedQuery(name = "TabAforo.findByTVcAcumulados", query = "SELECT t FROM TabAforo t WHERE t.tVcAcumulados = :tVcAcumulados"),
    @NamedQuery(name = "TabAforo.findByAuditoriaUsuario", query = "SELECT t FROM TabAforo t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAforo.findByAuditoriaFecha", query = "SELECT t FROM TabAforo t WHERE t.auditoriaFecha = :auditoriaFecha"),
    @NamedQuery(name = "TabAforo.findByIdDocumentoPdf", query = "SELECT t FROM TabAforo t WHERE t.idDocumentoPdf = :idDocumentoPdf")})
public class TabAforo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFORO")
    private Long idAforo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_AFORO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAforo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String digital;
    @Column(name = "ID_CARGUE")
    private Long idCargue;
    @Size(max = 100)
    @Column(name = "ORIGEN_INFORMACION")
    private String origenInformacion;
    @Size(max = 2000)
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TPD_TOTAL")
    private BigDecimal tpdTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_SITP_ALIMENTADORES")
    private BigDecimal fdSitpAlimentadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_VAN")
    private BigDecimal fdVan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_BUSES_BUSETAS")
    private BigDecimal fdBusesBusetas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_C2P")
    private BigDecimal fdC2p;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_C2G")
    private BigDecimal fdC2g;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_C3_C4")
    private BigDecimal fdC3C4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FD_C5_C5")
    private BigDecimal fdC5C5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TASA_CRECIMIENTO_R")
    private BigDecimal tasaCrecimientoR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FACTOR_DIRECCIONAL_FD")
    private BigDecimal factorDireccionalFd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FACTOR_DISTRIBUCION_CARRIL_FDC")
    private BigDecimal factorDistribucionCarrilFdc;
    @Size(max = 2000)
    @Column(name = "ANALISIS_REFERENCIAS")
    private String analisisReferencias;
    @Size(max = 2000)
    @Column(name = "ANALISIS_OBSERVACIONES")
    private String analisisObservaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS_NEE_8_2")
    private BigDecimal analisisNee82;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIOS_8_2")
    private short anios82;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS2_NEE_8_2")
    private BigDecimal analisis2Nee82;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIOS2_8_2")
    private short anios282;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS_TPD_V_COMERCIALES_3_5")
    private BigDecimal analisisTpdVComerciales35;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIOS_3_5")
    private short anios35;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_AUTOMOVILES")
    private BigDecimal tAutomoviles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_BUSES_VAN")
    private BigDecimal tBusesVan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_BUSES_BUSETA")
    private BigDecimal tBusesBuseta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_BUSES_SITP_ALIMENTADORES")
    private BigDecimal tBusesSitpAlimentadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_CAMIONES_C2P")
    private BigDecimal tCamionesC2p;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_CAMIONES_C2G")
    private BigDecimal tCamionesC2g;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_CAMIONES_C3_C4")
    private BigDecimal tCamionesC3C4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_CAMIONES_C5_C5")
    private BigDecimal tCamionesC5C5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "T_VC_ACUMULADOS")
    private BigDecimal tVcAcumulados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AUDITORIA_USUARIO")
    private String auditoriaUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUDITORIA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditoriaFecha;
    @Column(name = "ID_DOCUMENTO_PDF")
    private Long idDocumentoPdf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAforo")
    private List<TabAforoAnalisis> tabAforoAnalisisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAforo")
    private List<TabAforoCalzada> tabAforoCalzadaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAforo")
    private List<TabAforoDato> tabAforoDatoList;

    public TabAforo() {
    }

    public TabAforo(Long idAforo) {
        this.idAforo = idAforo;
    }

    public TabAforo(Long idAforo, Date fechaAforo, String digital, BigDecimal fdSitpAlimentadores, BigDecimal fdVan, BigDecimal fdBusesBusetas, BigDecimal fdC2p, BigDecimal fdC2g, BigDecimal fdC3C4, BigDecimal fdC5C5, BigDecimal tasaCrecimientoR, BigDecimal factorDireccionalFd, BigDecimal factorDistribucionCarrilFdc, BigDecimal analisisNee82, short anios82, BigDecimal analisis2Nee82, short anios282, BigDecimal analisisTpdVComerciales35, short anios35, BigDecimal tAutomoviles, BigDecimal tBusesVan, BigDecimal tBusesBuseta, BigDecimal tBusesSitpAlimentadores, BigDecimal tCamionesC2p, BigDecimal tCamionesC2g, BigDecimal tCamionesC3C4, BigDecimal tCamionesC5C5, BigDecimal tVcAcumulados, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAforo = idAforo;
        this.fechaAforo = fechaAforo;
        this.digital = digital;
        this.fdSitpAlimentadores = fdSitpAlimentadores;
        this.fdVan = fdVan;
        this.fdBusesBusetas = fdBusesBusetas;
        this.fdC2p = fdC2p;
        this.fdC2g = fdC2g;
        this.fdC3C4 = fdC3C4;
        this.fdC5C5 = fdC5C5;
        this.tasaCrecimientoR = tasaCrecimientoR;
        this.factorDireccionalFd = factorDireccionalFd;
        this.factorDistribucionCarrilFdc = factorDistribucionCarrilFdc;
        this.analisisNee82 = analisisNee82;
        this.anios82 = anios82;
        this.analisis2Nee82 = analisis2Nee82;
        this.anios282 = anios282;
        this.analisisTpdVComerciales35 = analisisTpdVComerciales35;
        this.anios35 = anios35;
        this.tAutomoviles = tAutomoviles;
        this.tBusesVan = tBusesVan;
        this.tBusesBuseta = tBusesBuseta;
        this.tBusesSitpAlimentadores = tBusesSitpAlimentadores;
        this.tCamionesC2p = tCamionesC2p;
        this.tCamionesC2g = tCamionesC2g;
        this.tCamionesC3C4 = tCamionesC3C4;
        this.tCamionesC5C5 = tCamionesC5C5;
        this.tVcAcumulados = tVcAcumulados;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAforo() {
        return idAforo;
    }

    public void setIdAforo(Long idAforo) {
        this.idAforo = idAforo;
    }

    public Date getFechaAforo() {
        return fechaAforo;
    }

    public void setFechaAforo(Date fechaAforo) {
        this.fechaAforo = fechaAforo;
    }

    public String getDigital() {
        return digital;
    }

    public void setDigital(String digital) {
        this.digital = digital;
    }

    public Long getIdCargue() {
        return idCargue;
    }

    public void setIdCargue(Long idCargue) {
        this.idCargue = idCargue;
    }

    public String getOrigenInformacion() {
        return origenInformacion;
    }

    public void setOrigenInformacion(String origenInformacion) {
        this.origenInformacion = origenInformacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getTpdTotal() {
        return tpdTotal;
    }

    public void setTpdTotal(BigDecimal tpdTotal) {
        this.tpdTotal = tpdTotal;
    }

    public BigDecimal getFdSitpAlimentadores() {
        return fdSitpAlimentadores;
    }

    public void setFdSitpAlimentadores(BigDecimal fdSitpAlimentadores) {
        this.fdSitpAlimentadores = fdSitpAlimentadores;
    }

    public BigDecimal getFdVan() {
        return fdVan;
    }

    public void setFdVan(BigDecimal fdVan) {
        this.fdVan = fdVan;
    }

    public BigDecimal getFdBusesBusetas() {
        return fdBusesBusetas;
    }

    public void setFdBusesBusetas(BigDecimal fdBusesBusetas) {
        this.fdBusesBusetas = fdBusesBusetas;
    }

    public BigDecimal getFdC2p() {
        return fdC2p;
    }

    public void setFdC2p(BigDecimal fdC2p) {
        this.fdC2p = fdC2p;
    }

    public BigDecimal getFdC2g() {
        return fdC2g;
    }

    public void setFdC2g(BigDecimal fdC2g) {
        this.fdC2g = fdC2g;
    }

    public BigDecimal getFdC3C4() {
        return fdC3C4;
    }

    public void setFdC3C4(BigDecimal fdC3C4) {
        this.fdC3C4 = fdC3C4;
    }

    public BigDecimal getFdC5C5() {
        return fdC5C5;
    }

    public void setFdC5C5(BigDecimal fdC5C5) {
        this.fdC5C5 = fdC5C5;
    }

    public BigDecimal getTasaCrecimientoR() {
        return tasaCrecimientoR;
    }

    public void setTasaCrecimientoR(BigDecimal tasaCrecimientoR) {
        this.tasaCrecimientoR = tasaCrecimientoR;
    }

    public BigDecimal getFactorDireccionalFd() {
        return factorDireccionalFd;
    }

    public void setFactorDireccionalFd(BigDecimal factorDireccionalFd) {
        this.factorDireccionalFd = factorDireccionalFd;
    }

    public BigDecimal getFactorDistribucionCarrilFdc() {
        return factorDistribucionCarrilFdc;
    }

    public void setFactorDistribucionCarrilFdc(BigDecimal factorDistribucionCarrilFdc) {
        this.factorDistribucionCarrilFdc = factorDistribucionCarrilFdc;
    }

    public String getAnalisisReferencias() {
        return analisisReferencias;
    }

    public void setAnalisisReferencias(String analisisReferencias) {
        this.analisisReferencias = analisisReferencias;
    }

    public String getAnalisisObservaciones() {
        return analisisObservaciones;
    }

    public void setAnalisisObservaciones(String analisisObservaciones) {
        this.analisisObservaciones = analisisObservaciones;
    }

    public BigDecimal getAnalisisNee82() {
        return analisisNee82;
    }

    public void setAnalisisNee82(BigDecimal analisisNee82) {
        this.analisisNee82 = analisisNee82;
    }

    public short getAnios82() {
        return anios82;
    }

    public void setAnios82(short anios82) {
        this.anios82 = anios82;
    }

    public BigDecimal getAnalisis2Nee82() {
        return analisis2Nee82;
    }

    public void setAnalisis2Nee82(BigDecimal analisis2Nee82) {
        this.analisis2Nee82 = analisis2Nee82;
    }

    public short getAnios282() {
        return anios282;
    }

    public void setAnios282(short anios282) {
        this.anios282 = anios282;
    }

    public BigDecimal getAnalisisTpdVComerciales35() {
        return analisisTpdVComerciales35;
    }

    public void setAnalisisTpdVComerciales35(BigDecimal analisisTpdVComerciales35) {
        this.analisisTpdVComerciales35 = analisisTpdVComerciales35;
    }

    public short getAnios35() {
        return anios35;
    }

    public void setAnios35(short anios35) {
        this.anios35 = anios35;
    }

    public BigDecimal getTAutomoviles() {
        return tAutomoviles;
    }

    public void setTAutomoviles(BigDecimal tAutomoviles) {
        this.tAutomoviles = tAutomoviles;
    }

    public BigDecimal getTBusesVan() {
        return tBusesVan;
    }

    public void setTBusesVan(BigDecimal tBusesVan) {
        this.tBusesVan = tBusesVan;
    }

    public BigDecimal getTBusesBuseta() {
        return tBusesBuseta;
    }

    public void setTBusesBuseta(BigDecimal tBusesBuseta) {
        this.tBusesBuseta = tBusesBuseta;
    }

    public BigDecimal getTBusesSitpAlimentadores() {
        return tBusesSitpAlimentadores;
    }

    public void setTBusesSitpAlimentadores(BigDecimal tBusesSitpAlimentadores) {
        this.tBusesSitpAlimentadores = tBusesSitpAlimentadores;
    }

    public BigDecimal getTCamionesC2p() {
        return tCamionesC2p;
    }

    public void setTCamionesC2p(BigDecimal tCamionesC2p) {
        this.tCamionesC2p = tCamionesC2p;
    }

    public BigDecimal getTCamionesC2g() {
        return tCamionesC2g;
    }

    public void setTCamionesC2g(BigDecimal tCamionesC2g) {
        this.tCamionesC2g = tCamionesC2g;
    }

    public BigDecimal getTCamionesC3C4() {
        return tCamionesC3C4;
    }

    public void setTCamionesC3C4(BigDecimal tCamionesC3C4) {
        this.tCamionesC3C4 = tCamionesC3C4;
    }

    public BigDecimal getTCamionesC5C5() {
        return tCamionesC5C5;
    }

    public void setTCamionesC5C5(BigDecimal tCamionesC5C5) {
        this.tCamionesC5C5 = tCamionesC5C5;
    }

    public BigDecimal getTVcAcumulados() {
        return tVcAcumulados;
    }

    public void setTVcAcumulados(BigDecimal tVcAcumulados) {
        this.tVcAcumulados = tVcAcumulados;
    }

    public String getAuditoriaUsuario() {
        return auditoriaUsuario;
    }

    public void setAuditoriaUsuario(String auditoriaUsuario) {
        this.auditoriaUsuario = auditoriaUsuario;
    }

    public Date getAuditoriaFecha() {
        return auditoriaFecha;
    }

    public void setAuditoriaFecha(Date auditoriaFecha) {
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdDocumentoPdf() {
        return idDocumentoPdf;
    }

    public void setIdDocumentoPdf(Long idDocumentoPdf) {
        this.idDocumentoPdf = idDocumentoPdf;
    }

    @XmlTransient
//    @JsonIgnore
    public List<TabAforoAnalisis> getTabAforoAnalisisList() {
        return tabAforoAnalisisList;
    }

    public void setTabAforoAnalisisList(List<TabAforoAnalisis> tabAforoAnalisisList) {
        this.tabAforoAnalisisList = tabAforoAnalisisList;
    }

    @XmlTransient
//    @JsonIgnore
    public List<TabAforoCalzada> getTabAforoCalzadaList() {
        return tabAforoCalzadaList;
    }

    public void setTabAforoCalzadaList(List<TabAforoCalzada> tabAforoCalzadaList) {
        this.tabAforoCalzadaList = tabAforoCalzadaList;
    }

    @XmlTransient
//    @JsonIgnore
    public List<TabAforoDato> getTabAforoDatoList() {
        return tabAforoDatoList;
    }

    public void setTabAforoDatoList(List<TabAforoDato> tabAforoDatoList) {
        this.tabAforoDatoList = tabAforoDatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAforo != null ? idAforo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAforo)) {
            return false;
        }
        TabAforo other = (TabAforo) object;
        if ((this.idAforo == null && other.idAforo != null) || (this.idAforo != null && !this.idAforo.equals(other.idAforo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAforo[ idAforo=" + idAforo + " ]";
    }
    
}
