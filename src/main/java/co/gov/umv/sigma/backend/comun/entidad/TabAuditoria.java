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
@Table(name = "TAB_AUDITORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAuditoria.findAll", query = "SELECT t FROM TabAuditoria t"),
    @NamedQuery(name = "TabAuditoria.findByIdAuditoria", query = "SELECT t FROM TabAuditoria t WHERE t.idAuditoria = :idAuditoria"),
    @NamedQuery(name = "TabAuditoria.findByTabla", query = "SELECT t FROM TabAuditoria t WHERE t.tabla = :tabla"),
    @NamedQuery(name = "TabAuditoria.findByIdTipoOperacion", query = "SELECT t FROM TabAuditoria t WHERE t.idTipoOperacion = :idTipoOperacion"),
    @NamedQuery(name = "TabAuditoria.findByRegistro", query = "SELECT t FROM TabAuditoria t WHERE t.registro = :registro"),
    @NamedQuery(name = "TabAuditoria.findByUsuario", query = "SELECT t FROM TabAuditoria t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TabAuditoria.findByFecha", query = "SELECT t FROM TabAuditoria t WHERE t.fecha = :fecha")})
public class TabAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AUDITORIA")
    private Long idAuditoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TABLA")
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_OPERACION")
    private long idTipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGISTRO")
    private long registro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAuditoria")
    private List<TabAuditoriaDetalle> tabAuditoriaDetalleList;

    public TabAuditoria() {
    }

    public TabAuditoria(Long idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public TabAuditoria(Long idAuditoria, String tabla, long idTipoOperacion, long registro, String usuario, Date fecha) {
        this.idAuditoria = idAuditoria;
        this.tabla = tabla;
        this.idTipoOperacion = idTipoOperacion;
        this.registro = registro;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Long getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Long idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public long getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(long idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public long getRegistro() {
        return registro;
    }

    public void setRegistro(long registro) {
        this.registro = registro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<TabAuditoriaDetalle> getTabAuditoriaDetalleList() {
        return tabAuditoriaDetalleList;
    }

    public void setTabAuditoriaDetalleList(List<TabAuditoriaDetalle> tabAuditoriaDetalleList) {
        this.tabAuditoriaDetalleList = tabAuditoriaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAuditoria)) {
            return false;
        }
        TabAuditoria other = (TabAuditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAuditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}
