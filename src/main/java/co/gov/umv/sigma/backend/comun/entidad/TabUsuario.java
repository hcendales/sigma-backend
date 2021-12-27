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
@Table(name = "TAB_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabUsuario.findAll", query = "SELECT t FROM TabUsuario t"),
    @NamedQuery(name = "TabUsuario.findByIdUsuario", query = "SELECT t FROM TabUsuario t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TabUsuario.findByIdentificacion", query = "SELECT t FROM TabUsuario t WHERE t.identificacion = :identificacion"),
    @NamedQuery(name = "TabUsuario.findByNombre", query = "SELECT t FROM TabUsuario t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabUsuario.findByIdTipoOrigen", query = "SELECT t FROM TabUsuario t WHERE t.idTipoOrigen = :idTipoOrigen"),
    @NamedQuery(name = "TabUsuario.findByLogin", query = "SELECT t FROM TabUsuario t WHERE t.login = :login"),
    @NamedQuery(name = "TabUsuario.findByClave", query = "SELECT t FROM TabUsuario t WHERE t.clave = :clave"),
    @NamedQuery(name = "TabUsuario.findByIdTipoEstado", query = "SELECT t FROM TabUsuario t WHERE t.idTipoEstado = :idTipoEstado"),
    @NamedQuery(name = "TabUsuario.findByRegistroActivo", query = "SELECT t FROM TabUsuario t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabUsuario.findByAuditoriaUsuario", query = "SELECT t FROM TabUsuario t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabUsuario.findByAuditoriaFecha", query = "SELECT t FROM TabUsuario t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ORIGEN")
    private long idTipoOrigen;
    @Size(max = 100)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 250)
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO")
    private long idTipoEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REGISTRO_ACTIVO")
    private String registroActivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TabRolUsuario> tabRolUsuarioList;
    @JoinColumn(name = "ID_ENTIDAD", referencedColumnName = "ID_ENTIDAD")
    @ManyToOne(optional = false)
    private TabEntidad idEntidad;

    public TabUsuario() {
    }

    public TabUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TabUsuario(Long idUsuario, String identificacion, String nombre, long idTipoOrigen, long idTipoEstado, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idUsuario = idUsuario;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.idTipoOrigen = idTipoOrigen;
        this.idTipoEstado = idTipoEstado;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdTipoOrigen() {
        return idTipoOrigen;
    }

    public void setIdTipoOrigen(long idTipoOrigen) {
        this.idTipoOrigen = idTipoOrigen;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public long getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(long idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public String getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(String registroActivo) {
        this.registroActivo = registroActivo;
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
    public List<TabRolUsuario> getTabRolUsuarioList() {
        return tabRolUsuarioList;
    }

    public void setTabRolUsuarioList(List<TabRolUsuario> tabRolUsuarioList) {
        this.tabRolUsuarioList = tabRolUsuarioList;
    }

    public TabEntidad getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(TabEntidad idEntidad) {
        this.idEntidad = idEntidad;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabUsuario)) {
            return false;
        }
        TabUsuario other = (TabUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
