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
@Table(name = "TAB_RECURSO_ASIGNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRecursoAsignacion.findAll", query = "SELECT t FROM TabRecursoAsignacion t"),
    @NamedQuery(name = "TabRecursoAsignacion.findByIdRecursoAsignacion", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.idRecursoAsignacion = :idRecursoAsignacion"),
    @NamedQuery(name = "TabRecursoAsignacion.findByIdTipoAsignacion", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.idTipoAsignacion = :idTipoAsignacion"),
    @NamedQuery(name = "TabRecursoAsignacion.findByIdEquipoMantenimiento", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.idEquipoMantenimiento = :idEquipoMantenimiento"),
    @NamedQuery(name = "TabRecursoAsignacion.findByIdTipoEstadoAsignacion", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.idTipoEstadoAsignacion = :idTipoEstadoAsignacion"),
    @NamedQuery(name = "TabRecursoAsignacion.findByIdProduccionMezcla", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.idProduccionMezcla = :idProduccionMezcla"),
    @NamedQuery(name = "TabRecursoAsignacion.findByAuditoriaUsuario", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRecursoAsignacion.findByAuditoriaFecha", query = "SELECT t FROM TabRecursoAsignacion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRecursoAsignacion implements Serializable {

    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL_EVENTO", referencedColumnName = "ID_MANTENIMIENTO_VIAL_EVENTO")
    @ManyToOne
    private TabMantenimientoVialEvento mantenimientoVialEvento;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RECURSO_ASIGNACION")
    private Long idRecursoAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ASIGNACION")
    private long idTipoAsignacion;
    @Column(name = "ID_EQUIPO_MANTENIMIENTO")
    private Long idEquipoMantenimiento;
    @Column(name = "ID_TIPO_ESTADO_ASIGNACION")
    private Long idTipoEstadoAsignacion;
    @Column(name = "ID_PRODUCCION_MEZCLA")
    private Long idProduccionMezcla;
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
    
    @JoinColumn(name = "ID_OTRA_ACTIVIDAD", referencedColumnName = "ID_OTRA_ACTIVIDAD")
    @ManyToOne
    private TabOtraActividad otraActividad;
    
    @JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION")
    @ManyToOne
    private TabProgramacion programacion;
    
    @JoinColumn(name = "ID_RECURSO_DISPONIBILIDAD", referencedColumnName = "ID_RECURSO_DISPONIBILIDAD")
    @ManyToOne(optional = false)
    private TabRecursoDisponibilidad recursoDisponibilidad;

    public TabRecursoAsignacion() {
    }

    public TabRecursoAsignacion(Long idRecursoAsignacion) {
        this.idRecursoAsignacion = idRecursoAsignacion;
    }

    public TabRecursoAsignacion(Long idRecursoAsignacion, long idTipoAsignacion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRecursoAsignacion = idRecursoAsignacion;
        this.idTipoAsignacion = idTipoAsignacion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRecursoAsignacion() {
        return idRecursoAsignacion;
    }

    public void setIdRecursoAsignacion(Long idRecursoAsignacion) {
        this.idRecursoAsignacion = idRecursoAsignacion;
    }

    public long getIdTipoAsignacion() {
        return idTipoAsignacion;
    }

    public void setIdTipoAsignacion(long idTipoAsignacion) {
        this.idTipoAsignacion = idTipoAsignacion;
    }

    public Long getIdEquipoMantenimiento() {
        return idEquipoMantenimiento;
    }

    public void setIdEquipoMantenimiento(Long idEquipoMantenimiento) {
        this.idEquipoMantenimiento = idEquipoMantenimiento;
    }

    public Long getIdTipoEstadoAsignacion() {
        return idTipoEstadoAsignacion;
    }

    public void setIdTipoEstadoAsignacion(Long idTipoEstadoAsignacion) {
        this.idTipoEstadoAsignacion = idTipoEstadoAsignacion;
    }

    public Long getIdProduccionMezcla() {
        return idProduccionMezcla;
    }

    public void setIdProduccionMezcla(Long idProduccionMezcla) {
        this.idProduccionMezcla = idProduccionMezcla;
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

    
    
    
       public TabOtraActividad getOtraActividad() {
		return otraActividad;
	}

	public void setOtraActividad(TabOtraActividad otraActividad) {
		this.otraActividad = otraActividad;
	}

	public TabProgramacion getProgramacion() {
		return programacion;
	}

	public void setProgramacion(TabProgramacion programacion) {
		this.programacion = programacion;
	}

	public TabRecursoDisponibilidad getRecursoDisponibilidad() {
		return recursoDisponibilidad;
	}

	public void setRecursoDisponibilidad(TabRecursoDisponibilidad recursoDisponibilidad) {
		this.recursoDisponibilidad = recursoDisponibilidad;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecursoAsignacion != null ? idRecursoAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRecursoAsignacion)) {
            return false;
        }
        TabRecursoAsignacion other = (TabRecursoAsignacion) object;
        if ((this.idRecursoAsignacion == null && other.idRecursoAsignacion != null) || (this.idRecursoAsignacion != null && !this.idRecursoAsignacion.equals(other.idRecursoAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRecursoAsignacion[ idRecursoAsignacion=" + idRecursoAsignacion + " ]";
    }

	public TabMantenimientoVialEvento getMantenimientoVialEvento() {
		return mantenimientoVialEvento;
	}

	public void setMantenimientoVialEvento(TabMantenimientoVialEvento mantenimientoVialEvento) {
		this.mantenimientoVialEvento = mantenimientoVialEvento;
	}

    
}
