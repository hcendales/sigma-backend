/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
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
@Table(name = "TAB_AFORO_DATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAforoDato.findAll", query = "SELECT t FROM TabAforoDato t"),
    @NamedQuery(name = "TabAforoDato.findByIdAforoDato", query = "SELECT t FROM TabAforoDato t WHERE t.idAforoDato = :idAforoDato"),
    @NamedQuery(name = "TabAforoDato.findByFechaHora", query = "SELECT t FROM TabAforoDato t WHERE t.fechaHora = :fechaHora"),
    @NamedQuery(name = "TabAforoDato.findByAutomoviles", query = "SELECT t FROM TabAforoDato t WHERE t.automoviles = :automoviles"),
    @NamedQuery(name = "TabAforoDato.findByBusesVan", query = "SELECT t FROM TabAforoDato t WHERE t.busesVan = :busesVan"),
    @NamedQuery(name = "TabAforoDato.findByBusesBuseta", query = "SELECT t FROM TabAforoDato t WHERE t.busesBuseta = :busesBuseta"),
    @NamedQuery(name = "TabAforoDato.findByBusesSitpAlimentadores", query = "SELECT t FROM TabAforoDato t WHERE t.busesSitpAlimentadores = :busesSitpAlimentadores"),
    @NamedQuery(name = "TabAforoDato.findByCamionesC2p", query = "SELECT t FROM TabAforoDato t WHERE t.camionesC2p = :camionesC2p"),
    @NamedQuery(name = "TabAforoDato.findByCamionesC2g", query = "SELECT t FROM TabAforoDato t WHERE t.camionesC2g = :camionesC2g"),
    @NamedQuery(name = "TabAforoDato.findByCamionesC3C4", query = "SELECT t FROM TabAforoDato t WHERE t.camionesC3C4 = :camionesC3C4"),
    @NamedQuery(name = "TabAforoDato.findByCamionesC5C5", query = "SELECT t FROM TabAforoDato t WHERE t.camionesC5C5 = :camionesC5C5"),
    @NamedQuery(name = "TabAforoDato.findByTpdParcial", query = "SELECT t FROM TabAforoDato t WHERE t.tpdParcial = :tpdParcial"),
    @NamedQuery(name = "TabAforoDato.findByAuditoriaUsuario", query = "SELECT t FROM TabAforoDato t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAforoDato.findByAuditoriaFecha", query = "SELECT t FROM TabAforoDato t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabAforoDato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFORO_DATO")
    private Long idAforoDato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "FECHA_HORA")
    private String fechaHora;
    @Basic(optional = false)
    @NotNull
    private long automoviles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSES_VAN")
    private long busesVan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSES_BUSETA")
    private long busesBuseta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSES_SITP_ALIMENTADORES")
    private long busesSitpAlimentadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C2P")
    private long camionesC2p;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C2G")
    private long camionesC2g;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C3_C4")
    private long camionesC3C4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMIONES_C5_C5")
    private long camionesC5C5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPD_PARCIAL")
    private long tpdParcial;
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

    public TabAforoDato() {
    }

    public TabAforoDato(Long idAforoDato) {
        this.idAforoDato = idAforoDato;
    }

    public TabAforoDato(Long idAforoDato, String fechaHora, long automoviles, long busesVan, long busesBuseta, long busesSitpAlimentadores, long camionesC2p, long camionesC2g, long camionesC3C4, long camionesC5C5, long tpdParcial, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAforoDato = idAforoDato;
        this.fechaHora = fechaHora;
        this.automoviles = automoviles;
        this.busesVan = busesVan;
        this.busesBuseta = busesBuseta;
        this.busesSitpAlimentadores = busesSitpAlimentadores;
        this.camionesC2p = camionesC2p;
        this.camionesC2g = camionesC2g;
        this.camionesC3C4 = camionesC3C4;
        this.camionesC5C5 = camionesC5C5;
        this.tpdParcial = tpdParcial;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAforoDato() {
        return idAforoDato;
    }

    public void setIdAforoDato(Long idAforoDato) {
        this.idAforoDato = idAforoDato;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public long getAutomoviles() {
        return automoviles;
    }

    public void setAutomoviles(long automoviles) {
        this.automoviles = automoviles;
    }

    public long getBusesVan() {
        return busesVan;
    }

    public void setBusesVan(long busesVan) {
        this.busesVan = busesVan;
    }

    public long getBusesBuseta() {
        return busesBuseta;
    }

    public void setBusesBuseta(long busesBuseta) {
        this.busesBuseta = busesBuseta;
    }

    public long getBusesSitpAlimentadores() {
        return busesSitpAlimentadores;
    }

    public void setBusesSitpAlimentadores(long busesSitpAlimentadores) {
        this.busesSitpAlimentadores = busesSitpAlimentadores;
    }

    public long getCamionesC2p() {
        return camionesC2p;
    }

    public void setCamionesC2p(long camionesC2p) {
        this.camionesC2p = camionesC2p;
    }

    public long getCamionesC2g() {
        return camionesC2g;
    }

    public void setCamionesC2g(long camionesC2g) {
        this.camionesC2g = camionesC2g;
    }

    public long getCamionesC3C4() {
        return camionesC3C4;
    }

    public void setCamionesC3C4(long camionesC3C4) {
        this.camionesC3C4 = camionesC3C4;
    }

    public long getCamionesC5C5() {
        return camionesC5C5;
    }

    public void setCamionesC5C5(long camionesC5C5) {
        this.camionesC5C5 = camionesC5C5;
    }

    public long getTpdParcial() {
        return tpdParcial;
    }

    public void setTpdParcial(long tpdParcial) {
        this.tpdParcial = tpdParcial;
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
        hash += (idAforoDato != null ? idAforoDato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAforoDato)) {
            return false;
        }
        TabAforoDato other = (TabAforoDato) object;
        if ((this.idAforoDato == null && other.idAforoDato != null) || (this.idAforoDato != null && !this.idAforoDato.equals(other.idAforoDato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAforoDato[ idAforoDato=" + idAforoDato + " ]";
    }
    
}
