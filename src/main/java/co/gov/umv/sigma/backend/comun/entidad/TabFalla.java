/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TAB_FALLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabFalla.findAll", query = "SELECT t FROM TabFalla t"),
    @NamedQuery(name = "TabFalla.findByIdFalla", query = "SELECT t FROM TabFalla t WHERE t.idFalla = :idFalla"),
    @NamedQuery(name = "TabFalla.findByDistancia", query = "SELECT t FROM TabFalla t WHERE t.distancia = :distancia"),
    @NamedQuery(name = "TabFalla.findByIdTipoSuperficie", query = "SELECT t FROM TabFalla t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabFalla.findByIdTipoFalla", query = "SELECT t FROM TabFalla t WHERE t.idTipoFalla = :idTipoFalla"),
    @NamedQuery(name = "TabFalla.findByIdTipoSeveridad", query = "SELECT t FROM TabFalla t WHERE t.idTipoSeveridad = :idTipoSeveridad"),
    @NamedQuery(name = "TabFalla.findByLongitud", query = "SELECT t FROM TabFalla t WHERE t.longitud = :longitud"),
    @NamedQuery(name = "TabFalla.findByAncho", query = "SELECT t FROM TabFalla t WHERE t.ancho = :ancho"),
    @NamedQuery(name = "TabFalla.findByArea", query = "SELECT t FROM TabFalla t WHERE t.area = :area"),
    @NamedQuery(name = "TabFalla.findByIdTipoIntervencion", query = "SELECT t FROM TabFalla t WHERE t.idTipoIntervencion = :idTipoIntervencion"),
    @NamedQuery(name = "TabFalla.findByNumeroLosas", query = "SELECT t FROM TabFalla t WHERE t.numeroLosas = :numeroLosas"),
    @NamedQuery(name = "TabFalla.findByAuditoriaUsuario", query = "SELECT t FROM TabFalla t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabFalla.findByAuditoriaFecha", query = "SELECT t FROM TabFalla t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabFalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FALLA")
    private Long idFalla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISTANCIA")
    private BigDecimal distancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_SUPERFICIE")
    private long idTipoSuperficie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_FALLA")
    private long idTipoFalla;
    @Column(name = "ID_TIPO_SEVERIDAD")
    private Long idTipoSeveridad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANCHO")
    private BigDecimal ancho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREA")
    private BigDecimal area;
    @Column(name = "ID_TIPO_INTERVENCION")
    private Long idTipoIntervencion;
    @Column(name = "NUMERO_LOSAS")
    private Long numeroLosas;
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
    @JoinColumn(name = "ID_UNIDAD_MUESTREO", referencedColumnName = "ID_UNIDAD_MUESTREO")
    @ManyToOne(optional = false)
    private TabUnidadMuestreo idUnidadMuestreo;

    public TabFalla() {
    }

    public TabFalla(Long idFalla) {
        this.idFalla = idFalla;
    }

    public TabFalla(Long idFalla, long idTipoSuperficie, long idTipoFalla, BigDecimal longitud, BigDecimal ancho, BigDecimal area, String auditoriaUsuario, Date auditoriaFecha) {
        this.idFalla = idFalla;
        this.idTipoSuperficie = idTipoSuperficie;
        this.idTipoFalla = idTipoFalla;
        this.longitud = longitud;
        this.ancho = ancho;
        this.area = area;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(Long idFalla) {
        this.idFalla = idFalla;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public long getIdTipoSuperficie() {
        return idTipoSuperficie;
    }

    public void setIdTipoSuperficie(long idTipoSuperficie) {
        this.idTipoSuperficie = idTipoSuperficie;
    }

    public long getIdTipoFalla() {
        return idTipoFalla;
    }

    public void setIdTipoFalla(long idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    public Long getIdTipoSeveridad() {
        return idTipoSeveridad;
    }

    public void setIdTipoSeveridad(Long idTipoSeveridad) {
        this.idTipoSeveridad = idTipoSeveridad;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Long getIdTipoIntervencion() {
        return idTipoIntervencion;
    }

    public void setIdTipoIntervencion(Long idTipoIntervencion) {
        this.idTipoIntervencion = idTipoIntervencion;
    }

    public Long getNumeroLosas() {
        return numeroLosas;
    }

    public void setNumeroLosas(Long numeroLosas) {
        this.numeroLosas = numeroLosas;
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

    public TabUnidadMuestreo getIdUnidadMuestreo() {
        return idUnidadMuestreo;
    }

    public void setIdUnidadMuestreo(TabUnidadMuestreo idUnidadMuestreo) {
        this.idUnidadMuestreo = idUnidadMuestreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFalla != null ? idFalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabFalla)) {
            return false;
        }
        TabFalla other = (TabFalla) object;
        if ((this.idFalla == null && other.idFalla != null) || (this.idFalla != null && !this.idFalla.equals(other.idFalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabFalla[ idFalla=" + idFalla + " ]";
    }
    
}
