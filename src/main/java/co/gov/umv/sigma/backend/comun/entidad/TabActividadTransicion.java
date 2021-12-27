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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TAB_ACTIVIDAD_TRANSICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabActividadTransicion.findAll", query = "SELECT t FROM TabActividadTransicion t"),
    @NamedQuery(name = "TabActividadTransicion.findByIdActividadTransicion", query = "SELECT t FROM TabActividadTransicion t WHERE t.idActividadTransicion = :idActividadTransicion"),
    @NamedQuery(name = "TabActividadTransicion.findByIdTipoEstadoPk", query = "SELECT t FROM TabActividadTransicion t WHERE t.idTipoEstadoPk = :idTipoEstadoPk"),
    @NamedQuery(name = "TabActividadTransicion.findByCondicion", query = "SELECT t FROM TabActividadTransicion t WHERE t.condicion = :condicion"),
    @NamedQuery(name = "TabActividadTransicion.findByCondicionDescripcion", query = "SELECT t FROM TabActividadTransicion t WHERE t.condicionDescripcion = :condicionDescripcion"),
    @NamedQuery(name = "TabActividadTransicion.findByIdTipoAsignacion", query = "SELECT t FROM TabActividadTransicion t WHERE t.idTipoAsignacion = :idTipoAsignacion"),
    @NamedQuery(name = "TabActividadTransicion.findByPermiteCambioAsignacion", query = "SELECT t FROM TabActividadTransicion t WHERE t.permiteCambioAsignacion = :permiteCambioAsignacion"),
    @NamedQuery(name = "TabActividadTransicion.findByAuditoriaUsuario", query = "SELECT t FROM TabActividadTransicion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabActividadTransicion.findByAuditoriaFecha", query = "SELECT t FROM TabActividadTransicion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabActividadTransicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTIVIDAD_TRANSICION")
    private Long idActividadTransicion;
    @Column(name = "ID_TIPO_ESTADO_PK")
    private Long idTipoEstadoPk;
    @Size(max = 300)
    @Column(name = "CONDICION")
    private String condicion;
    @Size(max = 300)
    @Column(name = "CONDICION_DESCRIPCION")
    private String condicionDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ASIGNACION")
    private long idTipoAsignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PERMITE_CAMBIO_ASIGNACION")
    private String permiteCambioAsignacion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadTransicion")
    private List<TabActividadTransicionDocu> tabActividadTransicionDocuList;
    @JoinColumn(name = "ID_ACTIVIDAD_ORIGEN", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(optional = false)
    private TabActividad idActividadOrigen;
    @JoinColumn(name = "ID_ACTIVIDAD_DESTINO", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(optional = false)
    private TabActividad idActividadDestino;

    public TabActividadTransicion() {
    }

    public TabActividadTransicion(Long idActividadTransicion) {
        this.idActividadTransicion = idActividadTransicion;
    }

    public TabActividadTransicion(Long idActividadTransicion, long idTipoAsignacion, String permiteCambioAsignacion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idActividadTransicion = idActividadTransicion;
        this.idTipoAsignacion = idTipoAsignacion;
        this.permiteCambioAsignacion = permiteCambioAsignacion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdActividadTransicion() {
        return idActividadTransicion;
    }

    public void setIdActividadTransicion(Long idActividadTransicion) {
        this.idActividadTransicion = idActividadTransicion;
    }

    public Long getIdTipoEstadoPk() {
        return idTipoEstadoPk;
    }

    public void setIdTipoEstadoPk(Long idTipoEstadoPk) {
        this.idTipoEstadoPk = idTipoEstadoPk;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getCondicionDescripcion() {
        return condicionDescripcion;
    }

    public void setCondicionDescripcion(String condicionDescripcion) {
        this.condicionDescripcion = condicionDescripcion;
    }

    public long getIdTipoAsignacion() {
        return idTipoAsignacion;
    }

    public void setIdTipoAsignacion(long idTipoAsignacion) {
        this.idTipoAsignacion = idTipoAsignacion;
    }

    public String getPermiteCambioAsignacion() {
        return permiteCambioAsignacion;
    }

    public void setPermiteCambioAsignacion(String permiteCambioAsignacion) {
        this.permiteCambioAsignacion = permiteCambioAsignacion;
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
    public List<TabActividadTransicionDocu> getTabActividadTransicionDocuList() {
        return tabActividadTransicionDocuList;
    }

    public void setTabActividadTransicionDocuList(List<TabActividadTransicionDocu> tabActividadTransicionDocuList) {
        this.tabActividadTransicionDocuList = tabActividadTransicionDocuList;
    }

    public TabActividad getIdActividadOrigen() {
        return idActividadOrigen;
    }

    public void setIdActividadOrigen(TabActividad idActividadOrigen) {
        this.idActividadOrigen = idActividadOrigen;
    }

    public TabActividad getIdActividadDestino() {
        return idActividadDestino;
    }

    public void setIdActividadDestino(TabActividad idActividadDestino) {
        this.idActividadDestino = idActividadDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadTransicion != null ? idActividadTransicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabActividadTransicion)) {
            return false;
        }
        TabActividadTransicion other = (TabActividadTransicion) object;
        if ((this.idActividadTransicion == null && other.idActividadTransicion != null) || (this.idActividadTransicion != null && !this.idActividadTransicion.equals(other.idActividadTransicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabActividadTransicion[ idActividadTransicion=" + idActividadTransicion + " ]";
    }
    
}
