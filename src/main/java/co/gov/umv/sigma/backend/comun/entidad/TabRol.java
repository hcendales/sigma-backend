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
@Table(name = "TAB_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRol.findAll", query = "SELECT t FROM TabRol t"),
    @NamedQuery(name = "TabRol.findByIdRol", query = "SELECT t FROM TabRol t WHERE t.idRol = :idRol"),
    @NamedQuery(name = "TabRol.findByNombre", query = "SELECT t FROM TabRol t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabRol.findByDescripcion", query = "SELECT t FROM TabRol t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabRol.findByRegistroActivo", query = "SELECT t FROM TabRol t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabRol.findByAuditoriaUsuario", query = "SELECT t FROM TabRol t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRol.findByAuditoriaFecha", query = "SELECT t FROM TabRol t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL")
    private Long idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REGISTRO_ACTIVO")
    private String registroActivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<TabRolUsuario> tabRolUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<TabRolMenu> tabRolMenuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<TabRolActividad> tabRolActividadList;
    @OneToMany(mappedBy = "idRol")
    private List<TabEventoSubscripcion> tabEventoSubscripcionList;

    public TabRol() {
    }

    public TabRol(Long idRol) {
        this.idRol = idRol;
    }

    public TabRol(Long idRol, String nombre, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
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

    public String getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(String registroActivo) {
        this.registroActivo = registroActivo;
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
    public List<TabRolUsuario> getTabRolUsuarioList() {
        return tabRolUsuarioList;
    }

    public void setTabRolUsuarioList(List<TabRolUsuario> tabRolUsuarioList) {
        this.tabRolUsuarioList = tabRolUsuarioList;
    }

    @XmlTransient
    public List<TabRolMenu> getTabRolMenuList() {
        return tabRolMenuList;
    }

    public void setTabRolMenuList(List<TabRolMenu> tabRolMenuList) {
        this.tabRolMenuList = tabRolMenuList;
    }

    @XmlTransient
    public List<TabRolActividad> getTabRolActividadList() {
        return tabRolActividadList;
    }

    public void setTabRolActividadList(List<TabRolActividad> tabRolActividadList) {
        this.tabRolActividadList = tabRolActividadList;
    }

    @XmlTransient
    public List<TabEventoSubscripcion> getTabEventoSubscripcionList() {
        return tabEventoSubscripcionList;
    }

    public void setTabEventoSubscripcionList(List<TabEventoSubscripcion> tabEventoSubscripcionList) {
        this.tabEventoSubscripcionList = tabEventoSubscripcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRol)) {
            return false;
        }
        TabRol other = (TabRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRol[ idRol=" + idRol + " ]";
    }
    
}
