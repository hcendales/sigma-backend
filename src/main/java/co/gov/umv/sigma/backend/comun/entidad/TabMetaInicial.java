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
@Table(name = "TAB_META_INICIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMetaInicial.findAll", query = "SELECT t FROM TabMetaInicial t"),
    @NamedQuery(name = "TabMetaInicial.findByIdMetaInicial", query = "SELECT t FROM TabMetaInicial t WHERE t.idMetaInicial = :idMetaInicial"),
    @NamedQuery(name = "TabMetaInicial.findByFechaInicio", query = "SELECT t FROM TabMetaInicial t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TabMetaInicial.findByFechaFin", query = "SELECT t FROM TabMetaInicial t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TabMetaInicial.findByKmCarrilImpacto", query = "SELECT t FROM TabMetaInicial t WHERE t.kmCarrilImpacto = :kmCarrilImpacto"),
    @NamedQuery(name = "TabMetaInicial.findByCantidadPk", query = "SELECT t FROM TabMetaInicial t WHERE t.cantidadPk = :cantidadPk"),
    @NamedQuery(name = "TabMetaInicial.findByIdCuadrante", query = "SELECT t FROM TabMetaInicial t WHERE t.idCuadrante = :idCuadrante"),
    @NamedQuery(name = "TabMetaInicial.findByAuditoriaUsuario", query = "SELECT t FROM TabMetaInicial t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMetaInicial.findByAuditoriaFecha", query = "SELECT t FROM TabMetaInicial t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabMetaInicial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_META_INICIAL")
    private Long idMetaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KM_CARRIL_IMPACTO")
    private long kmCarrilImpacto;
    @Column(name = "CANTIDAD_PK")
    private Long cantidadPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUADRANTE")
    private long idCuadrante;
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

    public TabMetaInicial() {
    }

    public TabMetaInicial(Long idMetaInicial) {
        this.idMetaInicial = idMetaInicial;
    }

    public TabMetaInicial(Long idMetaInicial, Date fechaInicio, Date fechaFin, long kmCarrilImpacto, long idCuadrante, String auditoriaUsuario, Date auditoriaFecha) {
        this.idMetaInicial = idMetaInicial;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.kmCarrilImpacto = kmCarrilImpacto;
        this.idCuadrante = idCuadrante;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdMetaInicial() {
        return idMetaInicial;
    }

    public void setIdMetaInicial(Long idMetaInicial) {
        this.idMetaInicial = idMetaInicial;
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

    public long getKmCarrilImpacto() {
        return kmCarrilImpacto;
    }

    public void setKmCarrilImpacto(long kmCarrilImpacto) {
        this.kmCarrilImpacto = kmCarrilImpacto;
    }

    public Long getCantidadPk() {
        return cantidadPk;
    }

    public void setCantidadPk(Long cantidadPk) {
        this.cantidadPk = cantidadPk;
    }

    public long getIdCuadrante() {
        return idCuadrante;
    }

    public void setIdCuadrante(long idCuadrante) {
        this.idCuadrante = idCuadrante;
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
        hash += (idMetaInicial != null ? idMetaInicial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMetaInicial)) {
            return false;
        }
        TabMetaInicial other = (TabMetaInicial) object;
        if ((this.idMetaInicial == null && other.idMetaInicial != null) || (this.idMetaInicial != null && !this.idMetaInicial.equals(other.idMetaInicial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMetaInicial[ idMetaInicial=" + idMetaInicial + " ]";
    }
    
}
