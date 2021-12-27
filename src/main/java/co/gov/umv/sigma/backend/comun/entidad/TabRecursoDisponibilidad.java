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
@Table(name = "TAB_RECURSO_DISPONIBILIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRecursoDisponibilidad.findAll", query = "SELECT t FROM TabRecursoDisponibilidad t"),
    @NamedQuery(name = "TabRecursoDisponibilidad.findByIdRecursoDisponibilidad", query = "SELECT t FROM TabRecursoDisponibilidad t WHERE t.idRecursoDisponibilidad = :idRecursoDisponibilidad"),
    @NamedQuery(name = "TabRecursoDisponibilidad.findByFechaInicio", query = "SELECT t FROM TabRecursoDisponibilidad t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TabRecursoDisponibilidad.findByFechaFin", query = "SELECT t FROM TabRecursoDisponibilidad t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TabRecursoDisponibilidad.findByIdTipoArea", query = "SELECT t FROM TabRecursoDisponibilidad t WHERE t.idTipoArea = :idTipoArea"),
    @NamedQuery(name = "TabRecursoDisponibilidad.findByAuditoriaUsuario", query = "SELECT t FROM TabRecursoDisponibilidad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRecursoDisponibilidad.findByAuditoriaFecha", query = "SELECT t FROM TabRecursoDisponibilidad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRecursoDisponibilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RECURSO_DISPONIBILIDAD")
    private Long idRecursoDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "ID_TIPO_AREA")
    private Long idTipoArea;
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
    @JoinColumn(name = "ID_RECURSO", referencedColumnName = "ID_RECURSO")
    @ManyToOne(optional = false)
    private TabRecurso recurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecursoDisponibilidad")
    private List<TabRecursoAsignacion> tabRecursoAsignacionList;

    public TabRecursoDisponibilidad() {
    }

    public TabRecursoDisponibilidad(Long idRecursoDisponibilidad) {
        this.idRecursoDisponibilidad = idRecursoDisponibilidad;
    }

    public TabRecursoDisponibilidad(Long idRecursoDisponibilidad, Date fechaInicio, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRecursoDisponibilidad = idRecursoDisponibilidad;
        this.fechaInicio = fechaInicio;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRecursoDisponibilidad() {
        return idRecursoDisponibilidad;
    }

    public void setIdRecursoDisponibilidad(Long idRecursoDisponibilidad) {
        this.idRecursoDisponibilidad = idRecursoDisponibilidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(Long idTipoArea) {
        this.idTipoArea = idTipoArea;
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



    public TabRecurso getRecurso() {
		return recurso;
	}

	public void setRecurso(TabRecurso recurso) {
		this.recurso = recurso;
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
        hash += (idRecursoDisponibilidad != null ? idRecursoDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRecursoDisponibilidad)) {
            return false;
        }
        TabRecursoDisponibilidad other = (TabRecursoDisponibilidad) object;
        if ((this.idRecursoDisponibilidad == null && other.idRecursoDisponibilidad != null) || (this.idRecursoDisponibilidad != null && !this.idRecursoDisponibilidad.equals(other.idRecursoDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRecursoDisponibilidad[ idRecursoDisponibilidad=" + idRecursoDisponibilidad + " ]";
    }
    
}
