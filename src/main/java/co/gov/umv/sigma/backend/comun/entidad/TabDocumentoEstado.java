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
@Table(name = "TAB_DOCUMENTO_ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabDocumentoEstado.findAll", query = "SELECT t FROM TabDocumentoEstado t"),
    @NamedQuery(name = "TabDocumentoEstado.findByIdDocumentoEstado", query = "SELECT t FROM TabDocumentoEstado t WHERE t.idDocumentoEstado = :idDocumentoEstado"),
    @NamedQuery(name = "TabDocumentoEstado.findByIdTipoEstadoDocumento", query = "SELECT t FROM TabDocumentoEstado t WHERE t.idTipoEstadoDocumento = :idTipoEstadoDocumento"),
    @NamedQuery(name = "TabDocumentoEstado.findByFechaInicio", query = "SELECT t FROM TabDocumentoEstado t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TabDocumentoEstado.findByFechaFin", query = "SELECT t FROM TabDocumentoEstado t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TabDocumentoEstado.findByObservacion", query = "SELECT t FROM TabDocumentoEstado t WHERE t.observacion = :observacion"),
    @NamedQuery(name = "TabDocumentoEstado.findByAuditoriaUsuario", query = "SELECT t FROM TabDocumentoEstado t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabDocumentoEstado.findByAuditoriaFecha", query = "SELECT t FROM TabDocumentoEstado t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabDocumentoEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO_ESTADO")
    private Long idDocumentoEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_DOCUMENTO")
    private long idTipoEstadoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 300)
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
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @ManyToOne(optional = false)
    private TabDocumento idDocumento;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private TabPersona idPersona;

    public TabDocumentoEstado() {
    }

    public TabDocumentoEstado(Long idDocumentoEstado) {
        this.idDocumentoEstado = idDocumentoEstado;
    }

    public TabDocumentoEstado(Long idDocumentoEstado, long idTipoEstadoDocumento, Date fechaInicio, String auditoriaUsuario, Date auditoriaFecha) {
        this.idDocumentoEstado = idDocumentoEstado;
        this.idTipoEstadoDocumento = idTipoEstadoDocumento;
        this.fechaInicio = fechaInicio;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdDocumentoEstado() {
        return idDocumentoEstado;
    }

    public void setIdDocumentoEstado(Long idDocumentoEstado) {
        this.idDocumentoEstado = idDocumentoEstado;
    }

    public long getIdTipoEstadoDocumento() {
        return idTipoEstadoDocumento;
    }

    public void setIdTipoEstadoDocumento(long idTipoEstadoDocumento) {
        this.idTipoEstadoDocumento = idTipoEstadoDocumento;
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

    public TabDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(TabDocumento idDocumento) {
        this.idDocumento = idDocumento;
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
        hash += (idDocumentoEstado != null ? idDocumentoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabDocumentoEstado)) {
            return false;
        }
        TabDocumentoEstado other = (TabDocumentoEstado) object;
        if ((this.idDocumentoEstado == null && other.idDocumentoEstado != null) || (this.idDocumentoEstado != null && !this.idDocumentoEstado.equals(other.idDocumentoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabDocumentoEstado[ idDocumentoEstado=" + idDocumentoEstado + " ]";
    }
    
}
