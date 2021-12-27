/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_SELECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabSeleccion.findAll", query = "SELECT t FROM TabSeleccion t"),
    @NamedQuery(name = "TabSeleccion.findByIdSeleccion", query = "SELECT t FROM TabSeleccion t WHERE t.idSeleccion = :idSeleccion"),
    @NamedQuery(name = "TabSeleccion.findByNombre", query = "SELECT t FROM TabSeleccion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabSeleccion.findByDescripcion", query = "SELECT t FROM TabSeleccion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabSeleccion.findByFecha", query = "SELECT t FROM TabSeleccion t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabSeleccion.findByCantidadPks", query = "SELECT t FROM TabSeleccion t WHERE t.cantidadPks = :cantidadPks"),
    @NamedQuery(name = "TabSeleccion.findByTotalKmCarril", query = "SELECT t FROM TabSeleccion t WHERE t.totalKmCarril = :totalKmCarril"),
    @NamedQuery(name = "TabSeleccion.findByIdTipoOrigenSeleccion", query = "SELECT t FROM TabSeleccion t WHERE t.idTipoOrigenSeleccion = :idTipoOrigenSeleccion"),
    @NamedQuery(name = "TabSeleccion.findByIdTipoEstadoSeleccion", query = "SELECT t FROM TabSeleccion t WHERE t.idTipoEstadoSeleccion = :idTipoEstadoSeleccion"),
    @NamedQuery(name = "TabSeleccion.findByIdZona", query = "SELECT t FROM TabSeleccion t WHERE t.idZona = :idZona"),
    @NamedQuery(name = "TabSeleccion.findByLoccodigo", query = "SELECT t FROM TabSeleccion t WHERE t.loccodigo = :loccodigo"),
    @NamedQuery(name = "TabSeleccion.findByUplcodigo", query = "SELECT t FROM TabSeleccion t WHERE t.uplcodigo = :uplcodigo"),
    @NamedQuery(name = "TabSeleccion.findByScacodigo", query = "SELECT t FROM TabSeleccion t WHERE t.scacodigo = :scacodigo"),
    @NamedQuery(name = "TabSeleccion.findByIdUpz", query = "SELECT t FROM TabSeleccion t WHERE t.idUpz = :idUpz"),
    @NamedQuery(name = "TabSeleccion.findByIdCuadrante", query = "SELECT t FROM TabSeleccion t WHERE t.idCuadrante = :idCuadrante"),
    @NamedQuery(name = "TabSeleccion.findByAuditoriaUsuario", query = "SELECT t FROM TabSeleccion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabSeleccion.findByAuditoriaFecha", query = "SELECT t FROM TabSeleccion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabSeleccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SELECCION")
    private Long idSeleccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PKS")
    private long cantidadPks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_KM_CARRIL")
    private BigDecimal totalKmCarril;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ORIGEN_SELECCION")
    private long idTipoOrigenSeleccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_SELECCION")
    private long idTipoEstadoSeleccion;
    @Column(name = "ID_ZONA")
    private Long idZona;
    @Column(name = "LOCCODIGO")
    private Long loccodigo;
    @Column(name = "UPLCODIGO")
    private Long uplcodigo;
    @Column(name = "SCACODIGO")
    private Long scacodigo;
    @Column(name = "ID_UPZ")
    private Long idUpz;
    @Column(name = "ID_CUADRANTE")
    private Long idCuadrante;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeleccion")
    private List<TabSeleccionCalzada> tabSeleccionCalzadaList;

    public TabSeleccion() {
    }

    public TabSeleccion(Long idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public TabSeleccion(Long idSeleccion, String nombre, String descripcion, Date fecha, long cantidadPks, BigDecimal totalKmCarril, long idTipoOrigenSeleccion, long idTipoEstadoSeleccion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idSeleccion = idSeleccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cantidadPks = cantidadPks;
        this.totalKmCarril = totalKmCarril;
        this.idTipoOrigenSeleccion = idTipoOrigenSeleccion;
        this.idTipoEstadoSeleccion = idTipoEstadoSeleccion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(Long idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getCantidadPks() {
        return cantidadPks;
    }

    public void setCantidadPks(long cantidadPks) {
        this.cantidadPks = cantidadPks;
    }

    public BigDecimal getTotalKmCarril() {
        return totalKmCarril;
    }

    public void setTotalKmCarril(BigDecimal totalKmCarril) {
        this.totalKmCarril = totalKmCarril;
    }

    public long getIdTipoOrigenSeleccion() {
        return idTipoOrigenSeleccion;
    }

    public void setIdTipoOrigenSeleccion(long idTipoOrigenSeleccion) {
        this.idTipoOrigenSeleccion = idTipoOrigenSeleccion;
    }

    public long getIdTipoEstadoSeleccion() {
        return idTipoEstadoSeleccion;
    }

    public void setIdTipoEstadoSeleccion(long idTipoEstadoSeleccion) {
        this.idTipoEstadoSeleccion = idTipoEstadoSeleccion;
    }

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public Long getLoccodigo() {
        return loccodigo;
    }

    public void setLoccodigo(Long loccodigo) {
        this.loccodigo = loccodigo;
    }

    public Long getUplcodigo() {
        return uplcodigo;
    }

    public void setUplcodigo(Long uplcodigo) {
        this.uplcodigo = uplcodigo;
    }

    public Long getScacodigo() {
        return scacodigo;
    }

    public void setScacodigo(Long scacodigo) {
        this.scacodigo = scacodigo;
    }

    public Long getIdUpz() {
        return idUpz;
    }

    public void setIdUpz(Long idUpz) {
        this.idUpz = idUpz;
    }

    public Long getIdCuadrante() {
        return idCuadrante;
    }

    public void setIdCuadrante(Long idCuadrante) {
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

    @XmlTransient
    public List<TabSeleccionCalzada> getTabSeleccionCalzadaList() {
        return tabSeleccionCalzadaList;
    }

    public void setTabSeleccionCalzadaList(List<TabSeleccionCalzada> tabSeleccionCalzadaList) {
        this.tabSeleccionCalzadaList = tabSeleccionCalzadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeleccion != null ? idSeleccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabSeleccion)) {
            return false;
        }
        TabSeleccion other = (TabSeleccion) object;
        if ((this.idSeleccion == null && other.idSeleccion != null) || (this.idSeleccion != null && !this.idSeleccion.equals(other.idSeleccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabSeleccion[ idSeleccion=" + idSeleccion + " ]";
    }
    
}
