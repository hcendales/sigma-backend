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
@Table(name = "TAB_PROGRAMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabProgramacion.findAll", query = "SELECT t FROM TabProgramacion t"),
    @NamedQuery(name = "TabProgramacion.findByIdProgramacion", query = "SELECT t FROM TabProgramacion t WHERE t.idProgramacion = :idProgramacion"),
    @NamedQuery(name = "TabProgramacion.findByIdTipoEvento", query = "SELECT t FROM TabProgramacion t WHERE t.idTipoEvento = :idTipoEvento"),
    @NamedQuery(name = "TabProgramacion.findByFecha", query = "SELECT t FROM TabProgramacion t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabProgramacion.findByAuditoriaUsuario", query = "SELECT t FROM TabProgramacion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabProgramacion.findByAuditoriaFecha", query = "SELECT t FROM TabProgramacion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabProgramacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROGRAMACION")
    private Long idProgramacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_EVENTO")
    private long idTipoEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
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
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL", referencedColumnName = "ID_MANTENIMIENTO_VIAL")
    @ManyToOne(optional = false)
    private TabMantenimientoVial idMantenimientoVial;
    @OneToMany(mappedBy = "idProgramacion")
    private List<TabRecursoAsignacion> tabRecursoAsignacionList;

    public TabProgramacion() {
    }

    public TabProgramacion(Long idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public TabProgramacion(Long idProgramacion, long idTipoEvento, Date fecha, String auditoriaUsuario, Date auditoriaFecha) {
        this.idProgramacion = idProgramacion;
        this.idTipoEvento = idTipoEvento;
        this.fecha = fecha;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Long idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public long getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(long idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public TabMantenimientoVial getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(TabMantenimientoVial idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
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
        hash += (idProgramacion != null ? idProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabProgramacion)) {
            return false;
        }
        TabProgramacion other = (TabProgramacion) object;
        if ((this.idProgramacion == null && other.idProgramacion != null) || (this.idProgramacion != null && !this.idProgramacion.equals(other.idProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabProgramacion[ idProgramacion=" + idProgramacion + " ]";
    }
    
}
