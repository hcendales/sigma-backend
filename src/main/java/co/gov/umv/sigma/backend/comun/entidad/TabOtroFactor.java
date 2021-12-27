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
@Table(name = "TAB_OTRO_FACTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabOtroFactor.findAll", query = "SELECT t FROM TabOtroFactor t"),
    @NamedQuery(name = "TabOtroFactor.findByIdOtroFactor", query = "SELECT t FROM TabOtroFactor t WHERE t.idOtroFactor = :idOtroFactor"),
    @NamedQuery(name = "TabOtroFactor.findByIdTipoOtroFactor", query = "SELECT t FROM TabOtroFactor t WHERE t.idTipoOtroFactor = :idTipoOtroFactor"),
    @NamedQuery(name = "TabOtroFactor.findByAuditoriaUsuario", query = "SELECT t FROM TabOtroFactor t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabOtroFactor.findByAuditoriaFecha", query = "SELECT t FROM TabOtroFactor t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabOtroFactor implements Serializable {

    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL_EVENTO", referencedColumnName = "ID_MANTENIMIENTO_VIAL_EVENTO")
    @ManyToOne(optional = false)
    private TabMantenimientoVialEvento idMantenimientoVialEvento;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OTRO_FACTOR")
    private Long idOtroFactor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_OTRO_FACTOR")
    private long idTipoOtroFactor;
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

    public TabOtroFactor() {
    }

    public TabOtroFactor(Long idOtroFactor) {
        this.idOtroFactor = idOtroFactor;
    }

    public TabOtroFactor(Long idOtroFactor, long idTipoOtroFactor, String auditoriaUsuario, Date auditoriaFecha) {
        this.idOtroFactor = idOtroFactor;
        this.idTipoOtroFactor = idTipoOtroFactor;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdOtroFactor() {
        return idOtroFactor;
    }

    public void setIdOtroFactor(Long idOtroFactor) {
        this.idOtroFactor = idOtroFactor;
    }

    public long getIdTipoOtroFactor() {
        return idTipoOtroFactor;
    }

    public void setIdTipoOtroFactor(long idTipoOtroFactor) {
        this.idTipoOtroFactor = idTipoOtroFactor;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOtroFactor != null ? idOtroFactor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabOtroFactor)) {
            return false;
        }
        TabOtroFactor other = (TabOtroFactor) object;
        if ((this.idOtroFactor == null && other.idOtroFactor != null) || (this.idOtroFactor != null && !this.idOtroFactor.equals(other.idOtroFactor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabOtroFactor[ idOtroFactor=" + idOtroFactor + " ]";
    }

    public TabMantenimientoVialEvento getIdMantenimientoVialEvento() {
        return idMantenimientoVialEvento;
    }

    public void setIdMantenimientoVialEvento(TabMantenimientoVialEvento idMantenimientoVialEvento) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
    }
    
}
