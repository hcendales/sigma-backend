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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TAB_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMenu.findAll", query = "SELECT t FROM TabMenu t"),
    @NamedQuery(name = "TabMenu.findByIdMenu", query = "SELECT t FROM TabMenu t WHERE t.idMenu = :idMenu"),
    @NamedQuery(name = "TabMenu.findByNombre", query = "SELECT t FROM TabMenu t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabMenu.findByDescripcion", query = "SELECT t FROM TabMenu t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabMenu.findByUrl", query = "SELECT t FROM TabMenu t WHERE t.url = :url"),
    @NamedQuery(name = "TabMenu.findByRegistroActivo", query = "SELECT t FROM TabMenu t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabMenu.findByAuditoriaUsuario", query = "SELECT t FROM TabMenu t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMenu.findByAuditoriaFecha", query = "SELECT t FROM TabMenu t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MENU")
    private Long idMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 300)
    @Column(name = "URL")
    private String url;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<TabRolMenu> tabRolMenuList;
    @OneToMany(mappedBy = "idMenuPadre")
    private List<TabMenu> tabMenuList;
    @JoinColumn(name = "ID_MENU_PADRE", referencedColumnName = "ID_MENU")
    @ManyToOne
    private TabMenu idMenuPadre;

    public TabMenu() {
    }

    public TabMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public TabMenu(Long idMenu, String nombre, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idMenu = idMenu;
        this.nombre = nombre;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public List<TabRolMenu> getTabRolMenuList() {
        return tabRolMenuList;
    }

    public void setTabRolMenuList(List<TabRolMenu> tabRolMenuList) {
        this.tabRolMenuList = tabRolMenuList;
    }

    @XmlTransient
    public List<TabMenu> getTabMenuList() {
        return tabMenuList;
    }

    public void setTabMenuList(List<TabMenu> tabMenuList) {
        this.tabMenuList = tabMenuList;
    }

    public TabMenu getIdMenuPadre() {
        return idMenuPadre;
    }

    public void setIdMenuPadre(TabMenu idMenuPadre) {
        this.idMenuPadre = idMenuPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMenu)) {
            return false;
        }
        TabMenu other = (TabMenu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMenu[ idMenu=" + idMenu + " ]";
    }
    
}
