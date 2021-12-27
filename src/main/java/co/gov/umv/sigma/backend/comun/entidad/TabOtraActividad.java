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
@Table(name = "TAB_OTRA_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabOtraActividad.findAll", query = "SELECT t FROM TabOtraActividad t"),
    @NamedQuery(name = "TabOtraActividad.findByIdOtraActividad", query = "SELECT t FROM TabOtraActividad t WHERE t.idOtraActividad = :idOtraActividad"),
    @NamedQuery(name = "TabOtraActividad.findByOtraActividad", query = "SELECT t FROM TabOtraActividad t WHERE t.otraActividad = :otraActividad"),
    @NamedQuery(name = "TabOtraActividad.findByIdArea", query = "SELECT t FROM TabOtraActividad t WHERE t.idArea = :idArea"),
    @NamedQuery(name = "TabOtraActividad.findByAuditoriaUsuario", query = "SELECT t FROM TabOtraActividad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabOtraActividad.findByAuditoriaFecha", query = "SELECT t FROM TabOtraActividad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabOtraActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OTRA_ACTIVIDAD")
    private Long idOtraActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "OTRA_ACTIVIDAD")
    private String otraActividad;
    @Column(name = "ID_AREA")
    private Long idArea;
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
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private TabPersona idPersona;
    @OneToMany(mappedBy = "idOtraActividad")
    private List<TabRecursoAsignacion> tabRecursoAsignacionList;

    public TabOtraActividad() {
    }

    public TabOtraActividad(Long idOtraActividad) {
        this.idOtraActividad = idOtraActividad;
    }

    public TabOtraActividad(Long idOtraActividad, String otraActividad, String auditoriaUsuario, Date auditoriaFecha) {
        this.idOtraActividad = idOtraActividad;
        this.otraActividad = otraActividad;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdOtraActividad() {
        return idOtraActividad;
    }

    public void setIdOtraActividad(Long idOtraActividad) {
        this.idOtraActividad = idOtraActividad;
    }

    public String getOtraActividad() {
        return otraActividad;
    }

    public void setOtraActividad(String otraActividad) {
        this.otraActividad = otraActividad;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
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

    public TabPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(TabPersona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public List<TabRecursoAsignacion> getTabRecursoAsignacionList() {
        return tabRecursoAsignacionList;
    }

    public void setTabRecursoAsignacionList(List<TabRecursoAsignacion> tabRecursoAsignacionList) {
        this.tabRecursoAsignacionList = tabRecursoAsignacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOtraActividad != null ? idOtraActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabOtraActividad)) {
            return false;
        }
        TabOtraActividad other = (TabOtraActividad) object;
        if ((this.idOtraActividad == null && other.idOtraActividad != null) || (this.idOtraActividad != null && !this.idOtraActividad.equals(other.idOtraActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabOtraActividad[ idOtraActividad=" + idOtraActividad + " ]";
    }
    
}
