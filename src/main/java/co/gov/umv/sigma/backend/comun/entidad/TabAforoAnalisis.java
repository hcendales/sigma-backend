/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_AFORO_ANALISIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAforoAnalisis.findAll", query = "SELECT t FROM TabAforoAnalisis t"),
    @NamedQuery(name = "TabAforoAnalisis.findByIdAforoAnalisis", query = "SELECT t FROM TabAforoAnalisis t WHERE t.idAforoAnalisis = :idAforoAnalisis"),
    @NamedQuery(name = "TabAforoAnalisis.findByPeriodoDisenio", query = "SELECT t FROM TabAforoAnalisis t WHERE t.periodoDisenio = :periodoDisenio"),
    @NamedQuery(name = "TabAforoAnalisis.findByAnio", query = "SELECT t FROM TabAforoAnalisis t WHERE t.anio = :anio"),
    @NamedQuery(name = "TabAforoAnalisis.findByTpd", query = "SELECT t FROM TabAforoAnalisis t WHERE t.tpd = :tpd"),
    @NamedQuery(name = "TabAforoAnalisis.findByBusesVan", query = "SELECT t FROM TabAforoAnalisis t WHERE t.busesVan = :busesVan"),
    @NamedQuery(name = "TabAforoAnalisis.findByBusesBuseta", query = "SELECT t FROM TabAforoAnalisis t WHERE t.busesBuseta = :busesBuseta"),
    @NamedQuery(name = "TabAforoAnalisis.findByBusesSitpAlimentadores", query = "SELECT t FROM TabAforoAnalisis t WHERE t.busesSitpAlimentadores = :busesSitpAlimentadores"),
    @NamedQuery(name = "TabAforoAnalisis.findByCamionesC2p", query = "SELECT t FROM TabAforoAnalisis t WHERE t.camionesC2p = :camionesC2p"),
    @NamedQuery(name = "TabAforoAnalisis.findByCamionesC2g", query = "SELECT t FROM TabAforoAnalisis t WHERE t.camionesC2g = :camionesC2g"),
    @NamedQuery(name = "TabAforoAnalisis.findByCamionesC3C4", query = "SELECT t FROM TabAforoAnalisis t WHERE t.camionesC3C4 = :camionesC3C4"),
    @NamedQuery(name = "TabAforoAnalisis.findByCamionesC5C5", query = "SELECT t FROM TabAforoAnalisis t WHERE t.camionesC5C5 = :camionesC5C5"),
    @NamedQuery(name = "TabAforoAnalisis.findByVcAcumulados", query = "SELECT t FROM TabAforoAnalisis t WHERE t.vcAcumulados = :vcAcumulados"),
    @NamedQuery(name = "TabAforoAnalisis.findByNeeAnios", query = "SELECT t FROM TabAforoAnalisis t WHERE t.neeAnios = :neeAnios"),
    @NamedQuery(name = "TabAforoAnalisis.findByNeeAcumulados", query = "SELECT t FROM TabAforoAnalisis t WHERE t.neeAcumulados = :neeAcumulados"),
    @NamedQuery(name = "TabAforoAnalisis.findByAuditoriaUsuario", query = "SELECT t FROM TabAforoAnalisis t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAforoAnalisis.findByAuditoriaFecha", query = "SELECT t FROM TabAforoAnalisis t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabAforoAnalisis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFORO_ANALISIS")
    private Long idAforoAnalisis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO_DISENIO")
    private short periodoDisenio;
    @Basic(optional = false)
    @NotNull
    private short anio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal tpd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSES_VAN")
    private BigDecimal busesVan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSES_BUSETA")
    private BigDecimal busesBuseta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSES_SITP_ALIMENTADORES")
    private BigDecimal busesSitpAlimentadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C2P")
    private BigDecimal camionesC2p;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C2G")
    private BigDecimal camionesC2g;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C3_C4")
    private BigDecimal camionesC3C4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C5_C5")
    private BigDecimal camionesC5C5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VC_ACUMULADOS")
    private BigDecimal vcAcumulados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NEE_ANIOS")
    private BigDecimal neeAnios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NEE_ACUMULADOS")
    private BigDecimal neeAcumulados;
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
    @JoinColumn(name = "ID_AFORO", referencedColumnName = "ID_AFORO")
    @ManyToOne(optional = false)
    private TabAforo2 idAforo;

    public TabAforoAnalisis() {
    }

    public TabAforoAnalisis(Long idAforoAnalisis) {
        this.idAforoAnalisis = idAforoAnalisis;
    }

    public TabAforoAnalisis(Long idAforoAnalisis, short periodoDisenio, short anio, BigDecimal tpd, BigDecimal busesVan, BigDecimal busesBuseta, BigDecimal busesSitpAlimentadores, BigDecimal camionesC2p, BigDecimal camionesC2g, BigDecimal camionesC3C4, BigDecimal camionesC5C5, BigDecimal vcAcumulados, BigDecimal neeAnios, BigDecimal neeAcumulados, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAforoAnalisis = idAforoAnalisis;
        this.periodoDisenio = periodoDisenio;
        this.anio = anio;
        this.tpd = tpd;
        this.busesVan = busesVan;
        this.busesBuseta = busesBuseta;
        this.busesSitpAlimentadores = busesSitpAlimentadores;
        this.camionesC2p = camionesC2p;
        this.camionesC2g = camionesC2g;
        this.camionesC3C4 = camionesC3C4;
        this.camionesC5C5 = camionesC5C5;
        this.vcAcumulados = vcAcumulados;
        this.neeAnios = neeAnios;
        this.neeAcumulados = neeAcumulados;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAforoAnalisis() {
        return idAforoAnalisis;
    }

    public void setIdAforoAnalisis(Long idAforoAnalisis) {
        this.idAforoAnalisis = idAforoAnalisis;
    }

    public short getPeriodoDisenio() {
        return periodoDisenio;
    }

    public void setPeriodoDisenio(short periodoDisenio) {
        this.periodoDisenio = periodoDisenio;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public BigDecimal getTpd() {
        return tpd;
    }

    public void setTpd(BigDecimal tpd) {
        this.tpd = tpd;
    }

    public BigDecimal getBusesVan() {
        return busesVan;
    }

    public void setBusesVan(BigDecimal busesVan) {
        this.busesVan = busesVan;
    }

    public BigDecimal getBusesBuseta() {
        return busesBuseta;
    }

    public void setBusesBuseta(BigDecimal busesBuseta) {
        this.busesBuseta = busesBuseta;
    }

    public BigDecimal getBusesSitpAlimentadores() {
        return busesSitpAlimentadores;
    }

    public void setBusesSitpAlimentadores(BigDecimal busesSitpAlimentadores) {
        this.busesSitpAlimentadores = busesSitpAlimentadores;
    }

    public BigDecimal getCamionesC2p() {
        return camionesC2p;
    }

    public void setCamionesC2p(BigDecimal camionesC2p) {
        this.camionesC2p = camionesC2p;
    }

    public BigDecimal getCamionesC2g() {
        return camionesC2g;
    }

    public void setCamionesC2g(BigDecimal camionesC2g) {
        this.camionesC2g = camionesC2g;
    }

    public BigDecimal getCamionesC3C4() {
        return camionesC3C4;
    }

    public void setCamionesC3C4(BigDecimal camionesC3C4) {
        this.camionesC3C4 = camionesC3C4;
    }

    public BigDecimal getCamionesC5C5() {
        return camionesC5C5;
    }

    public void setCamionesC5C5(BigDecimal camionesC5C5) {
        this.camionesC5C5 = camionesC5C5;
    }

    public BigDecimal getVcAcumulados() {
        return vcAcumulados;
    }

    public void setVcAcumulados(BigDecimal vcAcumulados) {
        this.vcAcumulados = vcAcumulados;
    }

    public BigDecimal getNeeAnios() {
        return neeAnios;
    }

    public void setNeeAnios(BigDecimal neeAnios) {
        this.neeAnios = neeAnios;
    }

    public BigDecimal getNeeAcumulados() {
        return neeAcumulados;
    }

    public void setNeeAcumulados(BigDecimal neeAcumulados) {
        this.neeAcumulados = neeAcumulados;
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

    public TabAforo2 getIdAforo() {
        return idAforo;
    }

    public void setIdAforo(TabAforo2 idAforo) {
        this.idAforo = idAforo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAforoAnalisis != null ? idAforoAnalisis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAforoAnalisis)) {
            return false;
        }
        TabAforoAnalisis other = (TabAforoAnalisis) object;
        if ((this.idAforoAnalisis == null && other.idAforoAnalisis != null) || (this.idAforoAnalisis != null && !this.idAforoAnalisis.equals(other.idAforoAnalisis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAforoAnalisis[ idAforoAnalisis=" + idAforoAnalisis + " ]";
    }
    
}
