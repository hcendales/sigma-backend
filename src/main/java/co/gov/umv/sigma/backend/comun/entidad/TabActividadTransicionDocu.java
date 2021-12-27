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
@Table(name = "TAB_ACTIVIDAD_TRANSICION_DOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabActividadTransicionDocu.findAll", query = "SELECT t FROM TabActividadTransicionDocu t"),
    @NamedQuery(name = "TabActividadTransicionDocu.findByIdActividadTransicionDocu", query = "SELECT t FROM TabActividadTransicionDocu t WHERE t.idActividadTransicionDocu = :idActividadTransicionDocu"),
    @NamedQuery(name = "TabActividadTransicionDocu.findByIdTipoDocumento", query = "SELECT t FROM TabActividadTransicionDocu t WHERE t.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "TabActividadTransicionDocu.findByIdTipoEstadoDocumentoIni", query = "SELECT t FROM TabActividadTransicionDocu t WHERE t.idTipoEstadoDocumentoIni = :idTipoEstadoDocumentoIni"),
    @NamedQuery(name = "TabActividadTransicionDocu.findByIdTipoEstadoDocumentoFin", query = "SELECT t FROM TabActividadTransicionDocu t WHERE t.idTipoEstadoDocumentoFin = :idTipoEstadoDocumentoFin"),
    @NamedQuery(name = "TabActividadTransicionDocu.findByAuditoriaUsuario", query = "SELECT t FROM TabActividadTransicionDocu t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabActividadTransicionDocu.findByAuditoriaFecha", query = "SELECT t FROM TabActividadTransicionDocu t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabActividadTransicionDocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTIVIDAD_TRANSICION_DOCU")
    private Long idActividadTransicionDocu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DOCUMENTO")
    private long idTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_DOCUMENTO_INI")
    private long idTipoEstadoDocumentoIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_DOCUMENTO_FIN")
    private long idTipoEstadoDocumentoFin;
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
    @JoinColumn(name = "ID_ACTIVIDAD_TRANSICION", referencedColumnName = "ID_ACTIVIDAD_TRANSICION")
    @ManyToOne(optional = false)
    private TabActividadTransicion idActividadTransicion;

    public TabActividadTransicionDocu() {
    }

    public TabActividadTransicionDocu(Long idActividadTransicionDocu) {
        this.idActividadTransicionDocu = idActividadTransicionDocu;
    }

    public TabActividadTransicionDocu(Long idActividadTransicionDocu, long idTipoDocumento, long idTipoEstadoDocumentoIni, long idTipoEstadoDocumentoFin, String auditoriaUsuario, Date auditoriaFecha) {
        this.idActividadTransicionDocu = idActividadTransicionDocu;
        this.idTipoDocumento = idTipoDocumento;
        this.idTipoEstadoDocumentoIni = idTipoEstadoDocumentoIni;
        this.idTipoEstadoDocumentoFin = idTipoEstadoDocumentoFin;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdActividadTransicionDocu() {
        return idActividadTransicionDocu;
    }

    public void setIdActividadTransicionDocu(Long idActividadTransicionDocu) {
        this.idActividadTransicionDocu = idActividadTransicionDocu;
    }

    public long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public long getIdTipoEstadoDocumentoIni() {
        return idTipoEstadoDocumentoIni;
    }

    public void setIdTipoEstadoDocumentoIni(long idTipoEstadoDocumentoIni) {
        this.idTipoEstadoDocumentoIni = idTipoEstadoDocumentoIni;
    }

    public long getIdTipoEstadoDocumentoFin() {
        return idTipoEstadoDocumentoFin;
    }

    public void setIdTipoEstadoDocumentoFin(long idTipoEstadoDocumentoFin) {
        this.idTipoEstadoDocumentoFin = idTipoEstadoDocumentoFin;
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

    public TabActividadTransicion getIdActividadTransicion() {
        return idActividadTransicion;
    }

    public void setIdActividadTransicion(TabActividadTransicion idActividadTransicion) {
        this.idActividadTransicion = idActividadTransicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadTransicionDocu != null ? idActividadTransicionDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabActividadTransicionDocu)) {
            return false;
        }
        TabActividadTransicionDocu other = (TabActividadTransicionDocu) object;
        if ((this.idActividadTransicionDocu == null && other.idActividadTransicionDocu != null) || (this.idActividadTransicionDocu != null && !this.idActividadTransicionDocu.equals(other.idActividadTransicionDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabActividadTransicionDocu[ idActividadTransicionDocu=" + idActividadTransicionDocu + " ]";
    }
    
}
