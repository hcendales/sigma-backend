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
@Table(name = "TAB_ELEMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabElemento.findAll", query = "SELECT t FROM TabElemento t"),
    @NamedQuery(name = "TabElemento.findByIdElemento", query = "SELECT t FROM TabElemento t WHERE t.idElemento = :idElemento"),
    @NamedQuery(name = "TabElemento.findByIdTipoElemento", query = "SELECT t FROM TabElemento t WHERE t.idTipoElemento = :idTipoElemento"),
    @NamedQuery(name = "TabElemento.findByIdTipoSuperficie", query = "SELECT t FROM TabElemento t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabElemento.findByLongitud", query = "SELECT t FROM TabElemento t WHERE t.longitud = :longitud"),
    @NamedQuery(name = "TabElemento.findByAncho", query = "SELECT t FROM TabElemento t WHERE t.ancho = :ancho"),
    @NamedQuery(name = "TabElemento.findByArea", query = "SELECT t FROM TabElemento t WHERE t.area = :area"),
    @NamedQuery(name = "TabElemento.findByIdTipoPmt", query = "SELECT t FROM TabElemento t WHERE t.idTipoPmt = :idTipoPmt"),
    @NamedQuery(name = "TabElemento.findByIdTipoActividad", query = "SELECT t FROM TabElemento t WHERE t.idTipoActividad = :idTipoActividad"),
    @NamedQuery(name = "TabElemento.findByIdTipoIntervencion", query = "SELECT t FROM TabElemento t WHERE t.idTipoIntervencion = :idTipoIntervencion"),
    @NamedQuery(name = "TabElemento.findByAuditoriaUsuario", query = "SELECT t FROM TabElemento t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabElemento.findByAuditoriaFecha", query = "SELECT t FROM TabElemento t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabElemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ELEMENTO")
    private Long idElemento;
    @Column(name = "ID_TIPO_ELEMENTO")
    private Long idTipoElemento;
    @Column(name = "ID_TIPO_SUPERFICIE")
    private Long idTipoSuperficie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "ANCHO")
    private BigDecimal ancho;
    @Column(name = "AREA")
    private BigDecimal area;
    @Column(name = "ID_TIPO_PMT")
    private Long idTipoPmt;
    @Column(name = "ID_TIPO_ACTIVIDAD")
    private Long idTipoActividad;
    @Column(name = "ID_TIPO_INTERVENCION")
    private Long idTipoIntervencion;
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

    public TabElemento() {
    }

    public TabElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    public TabElemento(Long idElemento, String auditoriaUsuario, Date auditoriaFecha) {
        this.idElemento = idElemento;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    public Long getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(Long idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public Long getIdTipoSuperficie() {
        return idTipoSuperficie;
    }

    public void setIdTipoSuperficie(Long idTipoSuperficie) {
        this.idTipoSuperficie = idTipoSuperficie;
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

    public Long getIdTipoPmt() {
        return idTipoPmt;
    }

    public void setIdTipoPmt(Long idTipoPmt) {
        this.idTipoPmt = idTipoPmt;
    }

    public Long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(Long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public Long getIdTipoIntervencion() {
        return idTipoIntervencion;
    }

    public void setIdTipoIntervencion(Long idTipoIntervencion) {
        this.idTipoIntervencion = idTipoIntervencion;
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
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabElemento)) {
            return false;
        }
        TabElemento other = (TabElemento) object;
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabElemento[ idElemento=" + idElemento + " ]";
    }
    
}
