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
@Table(name = "TAB_INFDIACUA_OBSERVACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaObservacion.findAll", query = "SELECT t FROM TabInfdiacuaObservacion t"),
    @NamedQuery(name = "TabInfdiacuaObservacion.findByIdInfdiacuaObservacion", query = "SELECT t FROM TabInfdiacuaObservacion t WHERE t.idInfdiacuaObservacion = :idInfdiacuaObservacion"),
    @NamedQuery(name = "TabInfdiacuaObservacion.findByObservaciones", query = "SELECT t FROM TabInfdiacuaObservacion t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabInfdiacuaObservacion.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaObservacion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaObservacion.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaObservacion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaObservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_OBSERVACION")
    private Long idInfdiacuaObservacion;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
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
    @JoinColumn(name = "ID_INFORME_DIARIO_CUADRILLA", referencedColumnName = "ID_INFORME_DIARIO_CUADRILLA")
    @ManyToOne(optional = false)
    private Long idInformeDiarioCuadrilla;

    public TabInfdiacuaObservacion() {
    }

    public TabInfdiacuaObservacion(Long idInfdiacuaObservacion) {
        this.idInfdiacuaObservacion = idInfdiacuaObservacion;
    }

    public TabInfdiacuaObservacion(Long idInfdiacuaObservacion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaObservacion = idInfdiacuaObservacion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaObservacion() {
        return idInfdiacuaObservacion;
    }

    public void setIdInfdiacuaObservacion(Long idInfdiacuaObservacion) {
        this.idInfdiacuaObservacion = idInfdiacuaObservacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Long getIdInformeDiarioCuadrilla() {
        return idInformeDiarioCuadrilla;
    }

    public void setIdInformeDiarioCuadrilla(Long idInformeDiarioCuadrilla) {
        this.idInformeDiarioCuadrilla = idInformeDiarioCuadrilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfdiacuaObservacion != null ? idInfdiacuaObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaObservacion)) {
            return false;
        }
        TabInfdiacuaObservacion other = (TabInfdiacuaObservacion) object;
        if ((this.idInfdiacuaObservacion == null && other.idInfdiacuaObservacion != null) || (this.idInfdiacuaObservacion != null && !this.idInfdiacuaObservacion.equals(other.idInfdiacuaObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaObservacion[ idInfdiacuaObservacion=" + idInfdiacuaObservacion + " ]";
    }
    
}
