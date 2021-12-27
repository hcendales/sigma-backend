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
@Table(name = "TAB_AREA_INTERVENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAreaIntervencion.findAll", query = "SELECT t FROM TabAreaIntervencion t"),
    @NamedQuery(name = "TabAreaIntervencion.findByIdAreaIntervencion", query = "SELECT t FROM TabAreaIntervencion t WHERE t.idAreaIntervencion = :idAreaIntervencion"),
    @NamedQuery(name = "TabAreaIntervencion.findByElemento", query = "SELECT t FROM TabAreaIntervencion t WHERE t.elemento = :elemento"),
    @NamedQuery(name = "TabAreaIntervencion.findByIdTipoSuperficie", query = "SELECT t FROM TabAreaIntervencion t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabAreaIntervencion.findByLongitud", query = "SELECT t FROM TabAreaIntervencion t WHERE t.longitud = :longitud"),
    @NamedQuery(name = "TabAreaIntervencion.findByAncho", query = "SELECT t FROM TabAreaIntervencion t WHERE t.ancho = :ancho"),
    @NamedQuery(name = "TabAreaIntervencion.findByArea", query = "SELECT t FROM TabAreaIntervencion t WHERE t.area = :area"),
    @NamedQuery(name = "TabAreaIntervencion.findByIdTipoIntervencion", query = "SELECT t FROM TabAreaIntervencion t WHERE t.idTipoIntervencion = :idTipoIntervencion"),
    @NamedQuery(name = "TabAreaIntervencion.findByAuditoriaUsuario", query = "SELECT t FROM TabAreaIntervencion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAreaIntervencion.findByAuditoriaFecha", query = "SELECT t FROM TabAreaIntervencion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabAreaIntervencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AREA_INTERVENCION")
    private Long idAreaIntervencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELEMENTO")
    private short elemento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_SUPERFICIE")
    private long idTipoSuperficie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_INTERVENCION")
    private long idTipoIntervencion;
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

    public TabAreaIntervencion() {
    }

    public TabAreaIntervencion(Long idAreaIntervencion) {
        this.idAreaIntervencion = idAreaIntervencion;
    }

    public TabAreaIntervencion(Long idAreaIntervencion, short elemento, long idTipoSuperficie, BigDecimal longitud, BigDecimal ancho, BigDecimal area, long idTipoIntervencion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAreaIntervencion = idAreaIntervencion;
        this.elemento = elemento;
        this.idTipoSuperficie = idTipoSuperficie;
        this.longitud = longitud;
        this.ancho = ancho;
        this.area = area;
        this.idTipoIntervencion = idTipoIntervencion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAreaIntervencion() {
        return idAreaIntervencion;
    }

    public void setIdAreaIntervencion(Long idAreaIntervencion) {
        this.idAreaIntervencion = idAreaIntervencion;
    }

    public short getElemento() {
        return elemento;
    }

    public void setElemento(short elemento) {
        this.elemento = elemento;
    }

    public long getIdTipoSuperficie() {
        return idTipoSuperficie;
    }

    public void setIdTipoSuperficie(long idTipoSuperficie) {
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

    public long getIdTipoIntervencion() {
        return idTipoIntervencion;
    }

    public void setIdTipoIntervencion(long idTipoIntervencion) {
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

    public TabMantenimientoVialEvento getIdMantenimientoVialEvento() {
        return idMantenimientoVialEvento;
    }

    public void setIdMantenimientoVialEvento(TabMantenimientoVialEvento idMantenimientoVialEvento) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaIntervencion != null ? idAreaIntervencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAreaIntervencion)) {
            return false;
        }
        TabAreaIntervencion other = (TabAreaIntervencion) object;
        if ((this.idAreaIntervencion == null && other.idAreaIntervencion != null) || (this.idAreaIntervencion != null && !this.idAreaIntervencion.equals(other.idAreaIntervencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAreaIntervencion[ idAreaIntervencion=" + idAreaIntervencion + " ]";
    }
    
}
