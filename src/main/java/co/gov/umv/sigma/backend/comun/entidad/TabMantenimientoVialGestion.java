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
@Table(name = "TAB_MANTENIMIENTO_VIAL_GESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMantenimientoVialGestion.findAll", query = "SELECT t FROM TabMantenimientoVialGestion t"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByIdMantenimientoVialGestion", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.idMantenimientoVialGestion = :idMantenimientoVialGestion"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByFechaAsignacion", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByFechaVencimiento", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByIdTipoEstadoGestion", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.idTipoEstadoGestion = :idTipoEstadoGestion"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByIdTipoArea", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.idTipoArea = :idTipoArea"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByIdTipoCargo", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.idTipoCargo = :idTipoCargo"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByFechaInicio", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByFechaFin", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByObservacion", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.observacion = :observacion"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByAuditoriaUsuario", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMantenimientoVialGestion.findByAuditoriaFecha", query = "SELECT t FROM TabMantenimientoVialGestion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabMantenimientoVialGestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO_VIAL_GESTION")
    private Long idMantenimientoVialGestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_GESTION")
    private long idTipoEstadoGestion;
    @Column(name = "ID_TIPO_AREA")
    private Long idTipoArea;
    @Column(name = "ID_TIPO_CARGO")
    private Long idTipoCargo;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 600)
    @Column(name = "OBSERVACION")
    private String observacion;
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
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(optional = false)
    private TabActividad idActividad;
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL", referencedColumnName = "ID_MANTENIMIENTO_VIAL")
    @ManyToOne(optional = false)
    private TabMantenimientoVial idMantenimientoVial;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private TabPersona idPersona;

    public TabMantenimientoVialGestion() {
    }

    public TabMantenimientoVialGestion(Long idMantenimientoVialGestion) {
        this.idMantenimientoVialGestion = idMantenimientoVialGestion;
    }

    public TabMantenimientoVialGestion(Long idMantenimientoVialGestion, Date fechaAsignacion, long idTipoEstadoGestion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idMantenimientoVialGestion = idMantenimientoVialGestion;
        this.fechaAsignacion = fechaAsignacion;
        this.idTipoEstadoGestion = idTipoEstadoGestion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdMantenimientoVialGestion() {
        return idMantenimientoVialGestion;
    }

    public void setIdMantenimientoVialGestion(Long idMantenimientoVialGestion) {
        this.idMantenimientoVialGestion = idMantenimientoVialGestion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public long getIdTipoEstadoGestion() {
        return idTipoEstadoGestion;
    }

    public void setIdTipoEstadoGestion(long idTipoEstadoGestion) {
        this.idTipoEstadoGestion = idTipoEstadoGestion;
    }

    public Long getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(Long idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public Long getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(Long idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public TabActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(TabActividad idActividad) {
        this.idActividad = idActividad;
    }

    public TabMantenimientoVial getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(TabMantenimientoVial idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
    }

    public TabPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(TabPersona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimientoVialGestion != null ? idMantenimientoVialGestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMantenimientoVialGestion)) {
            return false;
        }
        TabMantenimientoVialGestion other = (TabMantenimientoVialGestion) object;
        if ((this.idMantenimientoVialGestion == null && other.idMantenimientoVialGestion != null) || (this.idMantenimientoVialGestion != null && !this.idMantenimientoVialGestion.equals(other.idMantenimientoVialGestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialGestion[ idMantenimientoVialGestion=" + idMantenimientoVialGestion + " ]";
    }
    
}
