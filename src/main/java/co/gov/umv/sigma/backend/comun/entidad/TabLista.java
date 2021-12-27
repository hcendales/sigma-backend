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
@Table(name = "TAB_LISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabLista.findAll", query = "SELECT t FROM TabLista t"),
    @NamedQuery(name = "TabLista.findByIdLista", query = "SELECT t FROM TabLista t WHERE t.idLista = :idLista"),
    @NamedQuery(name = "TabLista.findByNombre", query = "SELECT t FROM TabLista t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabLista.findByAuditoriaUsuario", query = "SELECT t FROM TabLista t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabLista.findByAuditoriaFecha", query = "SELECT t FROM TabLista t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabLista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LISTA")
    private Long idLista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLista")
    private List<TabTipo> tabTipoList;

    public TabLista() {
    }

    public TabLista(Long idLista) {
        this.idLista = idLista;
    }

    public TabLista(Long idLista, String nombre, String auditoriaUsuario, Date auditoriaFecha) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public List<TabTipo> getTabTipoList() {
        return tabTipoList;
    }

    public void setTabTipoList(List<TabTipo> tabTipoList) {
        this.tabTipoList = tabTipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabLista)) {
            return false;
        }
        TabLista other = (TabLista) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabLista[ idLista=" + idLista + " ]";
    }
    
}
