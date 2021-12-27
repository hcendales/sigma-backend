/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_CARGUE_DETALLE_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabCargueDetalleLog.findAll", query = "SELECT t FROM TabCargueDetalleLog t"),
    @NamedQuery(name = "TabCargueDetalleLog.findByIdCargueDetalleLog", query = "SELECT t FROM TabCargueDetalleLog t WHERE t.idCargueDetalleLog = :idCargueDetalleLog"),
    @NamedQuery(name = "TabCargueDetalleLog.findByMensaje", query = "SELECT t FROM TabCargueDetalleLog t WHERE t.mensaje = :mensaje")})
public class TabCargueDetalleLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGUE_DETALLE_LOG")
    private Long idCargueDetalleLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "MENSAJE")
    private String mensaje;
    @JoinColumn(name = "ID_CARGUE_DETALLE", referencedColumnName = "ID_CARGUE_DETALLE")
    @ManyToOne(optional = false)
    private TabCargueDetalle idCargueDetalle;

    public TabCargueDetalleLog() {
    }

    public TabCargueDetalleLog(Long idCargueDetalleLog) {
        this.idCargueDetalleLog = idCargueDetalleLog;
    }

    public TabCargueDetalleLog(Long idCargueDetalleLog, String mensaje) {
        this.idCargueDetalleLog = idCargueDetalleLog;
        this.mensaje = mensaje;
    }

    public Long getIdCargueDetalleLog() {
        return idCargueDetalleLog;
    }

    public void setIdCargueDetalleLog(Long idCargueDetalleLog) {
        this.idCargueDetalleLog = idCargueDetalleLog;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TabCargueDetalle getIdCargueDetalle() {
        return idCargueDetalle;
    }

    public void setIdCargueDetalle(TabCargueDetalle idCargueDetalle) {
        this.idCargueDetalle = idCargueDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargueDetalleLog != null ? idCargueDetalleLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabCargueDetalleLog)) {
            return false;
        }
        TabCargueDetalleLog other = (TabCargueDetalleLog) object;
        if ((this.idCargueDetalleLog == null && other.idCargueDetalleLog != null) || (this.idCargueDetalleLog != null && !this.idCargueDetalleLog.equals(other.idCargueDetalleLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabCargueDetalleLog[ idCargueDetalleLog=" + idCargueDetalleLog + " ]";
    }
    
}
