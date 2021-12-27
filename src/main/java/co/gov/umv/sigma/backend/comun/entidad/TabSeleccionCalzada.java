/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "TAB_SELECCION_CALZADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabSeleccionCalzada.findAll", query = "SELECT t FROM TabSeleccionCalzada t"),
    @NamedQuery(name = "TabSeleccionCalzada.findByIdSeleccionCalzada", query = "SELECT t FROM TabSeleccionCalzada t WHERE t.idSeleccionCalzada = :idSeleccionCalzada"),
    @NamedQuery(name = "TabSeleccionCalzada.findByPkIdCalz", query = "SELECT t FROM TabSeleccionCalzada t WHERE t.pkIdCalz = :pkIdCalz"),
    @NamedQuery(name = "TabSeleccionCalzada.findByRegistroActivo", query = "SELECT t FROM TabSeleccionCalzada t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabSeleccionCalzada.findByObservacion", query = "SELECT t FROM TabSeleccionCalzada t WHERE t.observacion = :observacion"),
    @NamedQuery(name = "TabSeleccionCalzada.findByAuditoriaUsuario", query = "SELECT t FROM TabSeleccionCalzada t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabSeleccionCalzada.findByAuditoriaFecha", query = "SELECT t FROM TabSeleccionCalzada t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabSeleccionCalzada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SELECCION_CALZADA")
    private Long idSeleccionCalzada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ID_CALZ")
    private BigInteger pkIdCalz;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REGISTRO_ACTIVO")
    private String registroActivo;
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
    @JoinColumn(name = "ID_SELECCION", referencedColumnName = "ID_SELECCION")
    @ManyToOne(optional = false)
    private TabSeleccion idSeleccion;

    public TabSeleccionCalzada() {
    }

    public TabSeleccionCalzada(Long idSeleccionCalzada) {
        this.idSeleccionCalzada = idSeleccionCalzada;
    }

    public TabSeleccionCalzada(Long idSeleccionCalzada, BigInteger pkIdCalz, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idSeleccionCalzada = idSeleccionCalzada;
        this.pkIdCalz = pkIdCalz;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdSeleccionCalzada() {
        return idSeleccionCalzada;
    }

    public void setIdSeleccionCalzada(Long idSeleccionCalzada) {
        this.idSeleccionCalzada = idSeleccionCalzada;
    }

    public BigInteger getPkIdCalz() {
        return pkIdCalz;
    }

    public void setPkIdCalz(BigInteger pkIdCalz) {
        this.pkIdCalz = pkIdCalz;
    }

    public String getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(String registroActivo) {
        this.registroActivo = registroActivo;
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

    public TabSeleccion getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(TabSeleccion idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeleccionCalzada != null ? idSeleccionCalzada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabSeleccionCalzada)) {
            return false;
        }
        TabSeleccionCalzada other = (TabSeleccionCalzada) object;
        if ((this.idSeleccionCalzada == null && other.idSeleccionCalzada != null) || (this.idSeleccionCalzada != null && !this.idSeleccionCalzada.equals(other.idSeleccionCalzada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabSeleccionCalzada[ idSeleccionCalzada=" + idSeleccionCalzada + " ]";
    }
    
}
