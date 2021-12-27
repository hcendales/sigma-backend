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
@Table(name = "TAB_ROL_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRolMenu.findAll", query = "SELECT t FROM TabRolMenu t"),
    @NamedQuery(name = "TabRolMenu.findByIdRolMenu", query = "SELECT t FROM TabRolMenu t WHERE t.idRolMenu = :idRolMenu"),
    @NamedQuery(name = "TabRolMenu.findByCrear", query = "SELECT t FROM TabRolMenu t WHERE t.crear = :crear"),
    @NamedQuery(name = "TabRolMenu.findByModificar", query = "SELECT t FROM TabRolMenu t WHERE t.modificar = :modificar"),
    @NamedQuery(name = "TabRolMenu.findByBorrar", query = "SELECT t FROM TabRolMenu t WHERE t.borrar = :borrar"),
    @NamedQuery(name = "TabRolMenu.findByAccionesAdicionales", query = "SELECT t FROM TabRolMenu t WHERE t.accionesAdicionales = :accionesAdicionales"),
    @NamedQuery(name = "TabRolMenu.findByRegistroActivo", query = "SELECT t FROM TabRolMenu t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabRolMenu.findByAuditoriaUsuario", query = "SELECT t FROM TabRolMenu t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRolMenu.findByAuditoriaFecha", query = "SELECT t FROM TabRolMenu t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRolMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL_MENU")
    private Long idRolMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CREAR")
    private String crear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MODIFICAR")
    private String modificar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "BORRAR")
    private String borrar;
    @Size(max = 100)
    @Column(name = "ACCIONES_ADICIONALES")
    private String accionesAdicionales;
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
    @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne(optional = false)
    private TabMenu idMenu;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private TabRol idRol;

    public TabRolMenu() {
    }

    public TabRolMenu(Long idRolMenu) {
        this.idRolMenu = idRolMenu;
    }

    public TabRolMenu(Long idRolMenu, String crear, String modificar, String borrar, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRolMenu = idRolMenu;
        this.crear = crear;
        this.modificar = modificar;
        this.borrar = borrar;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRolMenu() {
        return idRolMenu;
    }

    public void setIdRolMenu(Long idRolMenu) {
        this.idRolMenu = idRolMenu;
    }

    public String getCrear() {
        return crear;
    }

    public void setCrear(String crear) {
        this.crear = crear;
    }

    public String getModificar() {
        return modificar;
    }

    public void setModificar(String modificar) {
        this.modificar = modificar;
    }

    public String getBorrar() {
        return borrar;
    }

    public void setBorrar(String borrar) {
        this.borrar = borrar;
    }

    public String getAccionesAdicionales() {
        return accionesAdicionales;
    }

    public void setAccionesAdicionales(String accionesAdicionales) {
        this.accionesAdicionales = accionesAdicionales;
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

    public TabMenu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(TabMenu idMenu) {
        this.idMenu = idMenu;
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
        hash += (idRolMenu != null ? idRolMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRolMenu)) {
            return false;
        }
        TabRolMenu other = (TabRolMenu) object;
        if ((this.idRolMenu == null && other.idRolMenu != null) || (this.idRolMenu != null && !this.idRolMenu.equals(other.idRolMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRolMenu[ idRolMenu=" + idRolMenu + " ]";
    }
    
}
