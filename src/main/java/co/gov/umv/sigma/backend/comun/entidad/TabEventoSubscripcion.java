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
@Table(name = "TAB_EVENTO_SUBSCRIPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabEventoSubscripcion.findAll", query = "SELECT t FROM TabEventoSubscripcion t"),
    @NamedQuery(name = "TabEventoSubscripcion.findByIdEventoSubscripcion", query = "SELECT t FROM TabEventoSubscripcion t WHERE t.idEventoSubscripcion = :idEventoSubscripcion"),
    @NamedQuery(name = "TabEventoSubscripcion.findByFechaDesde", query = "SELECT t FROM TabEventoSubscripcion t WHERE t.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "TabEventoSubscripcion.findByFechaHasta", query = "SELECT t FROM TabEventoSubscripcion t WHERE t.fechaHasta = :fechaHasta"),
    @NamedQuery(name = "TabEventoSubscripcion.findByUsuario", query = "SELECT t FROM TabEventoSubscripcion t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TabEventoSubscripcion.findByAuditoriaUsuario", query = "SELECT t FROM TabEventoSubscripcion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabEventoSubscripcion.findByAuditoriaFecha", query = "SELECT t FROM TabEventoSubscripcion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabEventoSubscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVENTO_SUBSCRIPCION")
    private Long idEventoSubscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
    @Column(name = "FECHA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuario;
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
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne(optional = false)
    private TabEvento idEvento;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne
    private TabRol idRol;

    public TabEventoSubscripcion() {
    }

    public TabEventoSubscripcion(Long idEventoSubscripcion) {
        this.idEventoSubscripcion = idEventoSubscripcion;
    }

    public TabEventoSubscripcion(Long idEventoSubscripcion, Date fechaDesde, String auditoriaUsuario, Date auditoriaFecha) {
        this.idEventoSubscripcion = idEventoSubscripcion;
        this.fechaDesde = fechaDesde;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdEventoSubscripcion() {
        return idEventoSubscripcion;
    }

    public void setIdEventoSubscripcion(Long idEventoSubscripcion) {
        this.idEventoSubscripcion = idEventoSubscripcion;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public TabEvento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TabEvento idEvento) {
        this.idEvento = idEvento;
    }

    public TabRol getIdRol() {
        return idRol;
    }

    public void setIdRol(TabRol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventoSubscripcion != null ? idEventoSubscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabEventoSubscripcion)) {
            return false;
        }
        TabEventoSubscripcion other = (TabEventoSubscripcion) object;
        if ((this.idEventoSubscripcion == null && other.idEventoSubscripcion != null) || (this.idEventoSubscripcion != null && !this.idEventoSubscripcion.equals(other.idEventoSubscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabEventoSubscripcion[ idEventoSubscripcion=" + idEventoSubscripcion + " ]";
    }
    
}
