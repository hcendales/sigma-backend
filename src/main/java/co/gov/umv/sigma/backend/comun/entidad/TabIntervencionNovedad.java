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
@Table(name = "TAB_INTERVENCION_NOVEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabIntervencionNovedad.findAll", query = "SELECT t FROM TabIntervencionNovedad t"),
    @NamedQuery(name = "TabIntervencionNovedad.findByIdIntervencionNovedad", query = "SELECT t FROM TabIntervencionNovedad t WHERE t.idIntervencionNovedad = :idIntervencionNovedad"),
    @NamedQuery(name = "TabIntervencionNovedad.findByIdTipoNovedad", query = "SELECT t FROM TabIntervencionNovedad t WHERE t.idTipoNovedad = :idTipoNovedad"),
    @NamedQuery(name = "TabIntervencionNovedad.findByAuditoriaUsuario", query = "SELECT t FROM TabIntervencionNovedad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabIntervencionNovedad.findByAuditoriaFecha", query = "SELECT t FROM TabIntervencionNovedad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabIntervencionNovedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INTERVENCION_NOVEDAD")
    private Long idIntervencionNovedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_NOVEDAD")
    private long idTipoNovedad;
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
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL_EVENTO", referencedColumnName = "ID_MANTENIMIENTO_VIAL_EVENTO")
    @ManyToOne(optional = false)
    private TabMantenimientoVialEvento idMantenimientoVialEvento;

    public TabIntervencionNovedad() {
    }

    public TabIntervencionNovedad(Long idIntervencionNovedad) {
        this.idIntervencionNovedad = idIntervencionNovedad;
    }

    public TabIntervencionNovedad(Long idIntervencionNovedad, long idTipoNovedad, String auditoriaUsuario, Date auditoriaFecha) {
        this.idIntervencionNovedad = idIntervencionNovedad;
        this.idTipoNovedad = idTipoNovedad;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdIntervencionNovedad() {
        return idIntervencionNovedad;
    }

    public void setIdIntervencionNovedad(Long idIntervencionNovedad) {
        this.idIntervencionNovedad = idIntervencionNovedad;
    }

    public long getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(long idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
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

    public TabMantenimientoVialEvento getIdMantenimientoVialEvento() {
        return idMantenimientoVialEvento;
    }

    public void setIdMantenimientoVialEvento(TabMantenimientoVialEvento idMantenimientoVialEvento) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIntervencionNovedad != null ? idIntervencionNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabIntervencionNovedad)) {
            return false;
        }
        TabIntervencionNovedad other = (TabIntervencionNovedad) object;
        if ((this.idIntervencionNovedad == null && other.idIntervencionNovedad != null) || (this.idIntervencionNovedad != null && !this.idIntervencionNovedad.equals(other.idIntervencionNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabIntervencionNovedad[ idIntervencionNovedad=" + idIntervencionNovedad + " ]";
    }
    
}
