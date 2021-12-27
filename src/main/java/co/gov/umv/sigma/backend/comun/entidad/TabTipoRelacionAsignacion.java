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
@Table(name = "TAB_TIPO_RELACION_ASIGNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabTipoRelacionAsignacion.findAll", query = "SELECT t FROM TabTipoRelacionAsignacion t"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByIdTipoRelacionAsignacion", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.idTipoRelacionAsignacion = :idTipoRelacionAsignacion"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByEvento", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.evento = :evento"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByIdTipoAsignacion", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.idTipoAsignacion = :idTipoAsignacion"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByIdTipoRecurso", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.idTipoRecurso = :idTipoRecurso"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByIdTipoRol", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.idTipoRol = :idTipoRol"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByIdTipoClaseEquipo", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.idTipoClaseEquipo = :idTipoClaseEquipo"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByIdTipoLugar", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.idTipoLugar = :idTipoLugar"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByAuditoriaUsuario", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabTipoRelacionAsignacion.findByAuditoriaFecha", query = "SELECT t FROM TabTipoRelacionAsignacion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabTipoRelacionAsignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_RELACION_ASIGNACION")
    private Long idTipoRelacionAsignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVENTO")
    private String evento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ASIGNACION")
    private long idTipoAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_RECURSO")
    private long idTipoRecurso;
    @Column(name = "ID_TIPO_ROL")
    private Long idTipoRol;
    @Column(name = "ID_TIPO_CLASE_EQUIPO")
    private Long idTipoClaseEquipo;
    @Column(name = "ID_TIPO_LUGAR")
    private Long idTipoLugar;
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

    public TabTipoRelacionAsignacion() {
    }

    public TabTipoRelacionAsignacion(Long idTipoRelacionAsignacion) {
        this.idTipoRelacionAsignacion = idTipoRelacionAsignacion;
    }

    public TabTipoRelacionAsignacion(Long idTipoRelacionAsignacion, String evento, long idTipoAsignacion, long idTipoRecurso, String auditoriaUsuario, Date auditoriaFecha) {
        this.idTipoRelacionAsignacion = idTipoRelacionAsignacion;
        this.evento = evento;
        this.idTipoAsignacion = idTipoAsignacion;
        this.idTipoRecurso = idTipoRecurso;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdTipoRelacionAsignacion() {
        return idTipoRelacionAsignacion;
    }

    public void setIdTipoRelacionAsignacion(Long idTipoRelacionAsignacion) {
        this.idTipoRelacionAsignacion = idTipoRelacionAsignacion;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public long getIdTipoAsignacion() {
        return idTipoAsignacion;
    }

    public void setIdTipoAsignacion(long idTipoAsignacion) {
        this.idTipoAsignacion = idTipoAsignacion;
    }

    public long getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(long idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public Long getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Long idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public Long getIdTipoClaseEquipo() {
        return idTipoClaseEquipo;
    }

    public void setIdTipoClaseEquipo(Long idTipoClaseEquipo) {
        this.idTipoClaseEquipo = idTipoClaseEquipo;
    }

    public Long getIdTipoLugar() {
        return idTipoLugar;
    }

    public void setIdTipoLugar(Long idTipoLugar) {
        this.idTipoLugar = idTipoLugar;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRelacionAsignacion != null ? idTipoRelacionAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabTipoRelacionAsignacion)) {
            return false;
        }
        TabTipoRelacionAsignacion other = (TabTipoRelacionAsignacion) object;
        if ((this.idTipoRelacionAsignacion == null && other.idTipoRelacionAsignacion != null) || (this.idTipoRelacionAsignacion != null && !this.idTipoRelacionAsignacion.equals(other.idTipoRelacionAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabTipoRelacionAsignacion[ idTipoRelacionAsignacion=" + idTipoRelacionAsignacion + " ]";
    }
    
}
