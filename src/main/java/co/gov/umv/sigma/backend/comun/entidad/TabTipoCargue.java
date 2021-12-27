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
@Table(name = "TAB_TIPO_CARGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabTipoCargue.findAll", query = "SELECT t FROM TabTipoCargue t"),
    @NamedQuery(name = "TabTipoCargue.findByIdTipoCargue", query = "SELECT t FROM TabTipoCargue t WHERE t.idTipoCargue = :idTipoCargue"),
    @NamedQuery(name = "TabTipoCargue.findByNombre", query = "SELECT t FROM TabTipoCargue t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabTipoCargue.findByDescripcion", query = "SELECT t FROM TabTipoCargue t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabTipoCargue.findByProgramaPlsql", query = "SELECT t FROM TabTipoCargue t WHERE t.programaPlsql = :programaPlsql"),
    @NamedQuery(name = "TabTipoCargue.findByAuditoriaUsuario", query = "SELECT t FROM TabTipoCargue t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabTipoCargue.findByAuditoriaFecha", query = "SELECT t FROM TabTipoCargue t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabTipoCargue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CARGUE")
    private Long idTipoCargue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "PROGRAMA_PLSQL")
    private String programaPlsql;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCargue")
    private List<TabTipoCargueEstructura> tabTipoCargueEstructuraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCargue")
    private List<TabCargue> tabCargueList;

    public TabTipoCargue() {
    }

    public TabTipoCargue(Long idTipoCargue) {
        this.idTipoCargue = idTipoCargue;
    }

    public TabTipoCargue(Long idTipoCargue, String nombre, String descripcion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idTipoCargue = idTipoCargue;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdTipoCargue() {
        return idTipoCargue;
    }

    public void setIdTipoCargue(Long idTipoCargue) {
        this.idTipoCargue = idTipoCargue;
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

    public String getProgramaPlsql() {
        return programaPlsql;
    }

    public void setProgramaPlsql(String programaPlsql) {
        this.programaPlsql = programaPlsql;
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
    public List<TabTipoCargueEstructura> getTabTipoCargueEstructuraList() {
        return tabTipoCargueEstructuraList;
    }

    public void setTabTipoCargueEstructuraList(List<TabTipoCargueEstructura> tabTipoCargueEstructuraList) {
        this.tabTipoCargueEstructuraList = tabTipoCargueEstructuraList;
    }

    @XmlTransient
    public List<TabCargue> getTabCargueList() {
        return tabCargueList;
    }

    public void setTabCargueList(List<TabCargue> tabCargueList) {
        this.tabCargueList = tabCargueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCargue != null ? idTipoCargue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabTipoCargue)) {
            return false;
        }
        TabTipoCargue other = (TabTipoCargue) object;
        if ((this.idTipoCargue == null && other.idTipoCargue != null) || (this.idTipoCargue != null && !this.idTipoCargue.equals(other.idTipoCargue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabTipoCargue[ idTipoCargue=" + idTipoCargue + " ]";
    }
    
}
