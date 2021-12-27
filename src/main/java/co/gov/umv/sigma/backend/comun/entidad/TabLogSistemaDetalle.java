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
@Table(name = "TAB_LOG_SISTEMA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabLogSistemaDetalle.findAll", query = "SELECT t FROM TabLogSistemaDetalle t"),
    @NamedQuery(name = "TabLogSistemaDetalle.findByIdLogSistemaDetalle", query = "SELECT t FROM TabLogSistemaDetalle t WHERE t.idLogSistemaDetalle = :idLogSistemaDetalle"),
    @NamedQuery(name = "TabLogSistemaDetalle.findByMensaje", query = "SELECT t FROM TabLogSistemaDetalle t WHERE t.mensaje = :mensaje"),
    @NamedQuery(name = "TabLogSistemaDetalle.findByFecha", query = "SELECT t FROM TabLogSistemaDetalle t WHERE t.fecha = :fecha")})
public class TabLogSistemaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOG_SISTEMA_DETALLE")
    private Long idLogSistemaDetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ID_LOG_SISTEMA", referencedColumnName = "ID_LOG_SISTEMA")
    @ManyToOne(optional = false)
    private TabLogSistema idLogSistema;

    public TabLogSistemaDetalle() {
    }

    public TabLogSistemaDetalle(Long idLogSistemaDetalle) {
        this.idLogSistemaDetalle = idLogSistemaDetalle;
    }

    public TabLogSistemaDetalle(Long idLogSistemaDetalle, String mensaje, Date fecha) {
        this.idLogSistemaDetalle = idLogSistemaDetalle;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Long getIdLogSistemaDetalle() {
        return idLogSistemaDetalle;
    }

    public void setIdLogSistemaDetalle(Long idLogSistemaDetalle) {
        this.idLogSistemaDetalle = idLogSistemaDetalle;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TabLogSistema getIdLogSistema() {
        return idLogSistema;
    }

    public void setIdLogSistema(TabLogSistema idLogSistema) {
        this.idLogSistema = idLogSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogSistemaDetalle != null ? idLogSistemaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabLogSistemaDetalle)) {
            return false;
        }
        TabLogSistemaDetalle other = (TabLogSistemaDetalle) object;
        if ((this.idLogSistemaDetalle == null && other.idLogSistemaDetalle != null) || (this.idLogSistemaDetalle != null && !this.idLogSistemaDetalle.equals(other.idLogSistemaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabLogSistemaDetalle[ idLogSistemaDetalle=" + idLogSistemaDetalle + " ]";
    }
    
}
