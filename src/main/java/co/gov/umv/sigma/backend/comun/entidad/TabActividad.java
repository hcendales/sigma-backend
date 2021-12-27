/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
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
@Table(name = "TAB_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabActividad.findAll", query = "SELECT t FROM TabActividad t"),
    @NamedQuery(name = "TabActividad.findByIdActividad", query = "SELECT t FROM TabActividad t WHERE t.idActividad = :idActividad"),
    @NamedQuery(name = "TabActividad.findByIdTipoProceso", query = "SELECT t FROM TabActividad t WHERE t.idTipoProceso = :idTipoProceso"),
    @NamedQuery(name = "TabActividad.findByNombre", query = "SELECT t FROM TabActividad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabActividad.findByDescripcion", query = "SELECT t FROM TabActividad t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabActividad.findByDuracion", query = "SELECT t FROM TabActividad t WHERE t.duracion = :duracion"),
    @NamedQuery(name = "TabActividad.findByIdTipoArea", query = "SELECT t FROM TabActividad t WHERE t.idTipoArea = :idTipoArea"),
    @NamedQuery(name = "TabActividad.findByIdTipoCargo", query = "SELECT t FROM TabActividad t WHERE t.idTipoCargo = :idTipoCargo"),
    @NamedQuery(name = "TabActividad.findByUrl", query = "SELECT t FROM TabActividad t WHERE t.url = :url"),
    @NamedQuery(name = "TabActividad.findByMasiva", query = "SELECT t FROM TabActividad t WHERE t.masiva = :masiva"),
    @NamedQuery(name = "TabActividad.findByAuditoriaUsuario", query = "SELECT t FROM TabActividad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabActividad.findByAuditoriaFecha", query = "SELECT t FROM TabActividad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTIVIDAD")
    private Long idActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PROCESO")
    private long idTipoProceso;
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
    @Column(name = "DURACION")
    private long duracion;
    @Column(name = "ID_TIPO_AREA")
    private Long idTipoArea;
    @Column(name = "ID_TIPO_CARGO")
    private Long idTipoCargo;
    @Size(max = 300)
    @Column(name = "URL")
    private String url;
    @Size(max = 2)
    @Column(name = "MASIVA")
    private String masiva;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividad")
    private List<TabRolActividad> tabRolActividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadOrigen")
    private List<TabActividadTransicion> tabActividadTransicionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadDestino")
    private List<TabActividadTransicion> tabActividadTransicionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividad")
    private List<TabMantenimientoVialGestion> tabMantenimientoVialGestionList;

    public TabActividad() {
    }

    public TabActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public TabActividad(Long idActividad, long idTipoProceso, String nombre, String descripcion, long duracion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idActividad = idActividad;
        this.idTipoProceso = idTipoProceso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public long getIdTipoProceso() {
        return idTipoProceso;
    }

    public void setIdTipoProceso(long idTipoProceso) {
        this.idTipoProceso = idTipoProceso;
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

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public Long getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(Long idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public Long getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(Long idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMasiva() {
        return masiva;
    }

    public void setMasiva(String masiva) {
        this.masiva = masiva;
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
    public List<TabRolActividad> getTabRolActividadList() {
        return tabRolActividadList;
    }

    public void setTabRolActividadList(List<TabRolActividad> tabRolActividadList) {
        this.tabRolActividadList = tabRolActividadList;
    }

    @XmlTransient
    public List<TabActividadTransicion> getTabActividadTransicionList() {
        return tabActividadTransicionList;
    }

    public void setTabActividadTransicionList(List<TabActividadTransicion> tabActividadTransicionList) {
        this.tabActividadTransicionList = tabActividadTransicionList;
    }

    @XmlTransient
    public List<TabActividadTransicion> getTabActividadTransicionList1() {
        return tabActividadTransicionList1;
    }

    public void setTabActividadTransicionList1(List<TabActividadTransicion> tabActividadTransicionList1) {
        this.tabActividadTransicionList1 = tabActividadTransicionList1;
    }

    @XmlTransient
    public List<TabMantenimientoVialGestion> getTabMantenimientoVialGestionList() {
        return tabMantenimientoVialGestionList;
    }

    public void setTabMantenimientoVialGestionList(List<TabMantenimientoVialGestion> tabMantenimientoVialGestionList) {
        this.tabMantenimientoVialGestionList = tabMantenimientoVialGestionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabActividad)) {
            return false;
        }
        TabActividad other = (TabActividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabActividad[ idActividad=" + idActividad + " ]";
    }
    
}
