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
@Table(name = "TAB_LOG_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabLogSistema.findAll", query = "SELECT t FROM TabLogSistema t"),
    @NamedQuery(name = "TabLogSistema.findByIdLogSistema", query = "SELECT t FROM TabLogSistema t WHERE t.idLogSistema = :idLogSistema"),
    @NamedQuery(name = "TabLogSistema.findByFecha", query = "SELECT t FROM TabLogSistema t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabLogSistema.findByTipo", query = "SELECT t FROM TabLogSistema t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TabLogSistema.findByPrograma", query = "SELECT t FROM TabLogSistema t WHERE t.programa = :programa"),
    @NamedQuery(name = "TabLogSistema.findByMensaje", query = "SELECT t FROM TabLogSistema t WHERE t.mensaje = :mensaje"),
    @NamedQuery(name = "TabLogSistema.findByUsuario", query = "SELECT t FROM TabLogSistema t WHERE t.usuario = :usuario")})
public class TabLogSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOG_SISTEMA")
    private Long idLogSistema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PROGRAMA")
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLogSistema")
    private List<TabLogSistemaDetalle> tabLogSistemaDetalleList;

    public TabLogSistema() {
    }

    public TabLogSistema(Long idLogSistema) {
        this.idLogSistema = idLogSistema;
    }

    public TabLogSistema(Long idLogSistema, Date fecha, String tipo, String programa, String mensaje, String usuario) {
        this.idLogSistema = idLogSistema;
        this.fecha = fecha;
        this.tipo = tipo;
        this.programa = programa;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public Long getIdLogSistema() {
        return idLogSistema;
    }

    public void setIdLogSistema(Long idLogSistema) {
        this.idLogSistema = idLogSistema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<TabLogSistemaDetalle> getTabLogSistemaDetalleList() {
        return tabLogSistemaDetalleList;
    }

    public void setTabLogSistemaDetalleList(List<TabLogSistemaDetalle> tabLogSistemaDetalleList) {
        this.tabLogSistemaDetalleList = tabLogSistemaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogSistema != null ? idLogSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabLogSistema)) {
            return false;
        }
        TabLogSistema other = (TabLogSistema) object;
        if ((this.idLogSistema == null && other.idLogSistema != null) || (this.idLogSistema != null && !this.idLogSistema.equals(other.idLogSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabLogSistema[ idLogSistema=" + idLogSistema + " ]";
    }
    
}
