/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
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

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabEvento.findAll", query = "SELECT t FROM TabEvento t"),
    @NamedQuery(name = "TabEvento.findByIdEvento", query = "SELECT t FROM TabEvento t WHERE t.idEvento = :idEvento"),
    @NamedQuery(name = "TabEvento.findByNombre", query = "SELECT t FROM TabEvento t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabEvento.findByDescripcion", query = "SELECT t FROM TabEvento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabEvento.findByAuditoriaUsuario", query = "SELECT t FROM TabEvento t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabEvento.findByAuditoriaFecha", query = "SELECT t FROM TabEvento t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVENTO")
    private Long idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private List<TabEventoSubscripcion> tabEventoSubscripcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private List<TabEventoSistema> tabEventoSistemaList;

    public TabEvento() {
    }

    public TabEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public TabEvento(Long idEvento, String nombre, String descripcion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<TabEventoSubscripcion> getTabEventoSubscripcionList() {
        return tabEventoSubscripcionList;
    }

    public void setTabEventoSubscripcionList(List<TabEventoSubscripcion> tabEventoSubscripcionList) {
        this.tabEventoSubscripcionList = tabEventoSubscripcionList;
    }

    @XmlTransient
    public List<TabEventoSistema> getTabEventoSistemaList() {
        return tabEventoSistemaList;
    }

    public void setTabEventoSistemaList(List<TabEventoSistema> tabEventoSistemaList) {
        this.tabEventoSistemaList = tabEventoSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabEvento)) {
            return false;
        }
        TabEvento other = (TabEvento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabEvento[ idEvento=" + idEvento + " ]";
    }
    
}
