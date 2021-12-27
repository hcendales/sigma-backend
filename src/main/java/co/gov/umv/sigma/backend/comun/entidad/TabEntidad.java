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
@Table(name = "TAB_ENTIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabEntidad.findAll", query = "SELECT t FROM TabEntidad t"),
    @NamedQuery(name = "TabEntidad.findByIdEntidad", query = "SELECT t FROM TabEntidad t WHERE t.idEntidad = :idEntidad"),
    @NamedQuery(name = "TabEntidad.findByIdentificacion", query = "SELECT t FROM TabEntidad t WHERE t.identificacion = :identificacion"),
    @NamedQuery(name = "TabEntidad.findByNombre", query = "SELECT t FROM TabEntidad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabEntidad.findByContacto", query = "SELECT t FROM TabEntidad t WHERE t.contacto = :contacto"),
    @NamedQuery(name = "TabEntidad.findByTelefono", query = "SELECT t FROM TabEntidad t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TabEntidad.findByCorreoElectronico", query = "SELECT t FROM TabEntidad t WHERE t.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "TabEntidad.findByIdTipoEntidad", query = "SELECT t FROM TabEntidad t WHERE t.idTipoEntidad = :idTipoEntidad"),
    @NamedQuery(name = "TabEntidad.findByIdLocalidad", query = "SELECT t FROM TabEntidad t WHERE t.idLocalidad = :idLocalidad"),
    @NamedQuery(name = "TabEntidad.findByRegistroActivo", query = "SELECT t FROM TabEntidad t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabEntidad.findByAuditoriaUsuario", query = "SELECT t FROM TabEntidad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabEntidad.findByAuditoriaFecha", query = "SELECT t FROM TabEntidad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENTIDAD")
    private Long idEntidad;
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
    @Size(min = 1, max = 100)
    @Column(name = "CONTACTO")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ENTIDAD")
    private long idTipoEntidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOCALIDAD")
    private long idLocalidad;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private List<TabUsuario> tabUsuarioList;

    public TabEntidad() {
    }

    public TabEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public TabEntidad(Long idEntidad, String identificacion, String nombre, String contacto, String telefono, String correoElectronico, long idTipoEntidad, long idLocalidad, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idEntidad = idEntidad;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.idTipoEntidad = idTipoEntidad;
        this.idLocalidad = idLocalidad;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public long getIdTipoEntidad() {
        return idTipoEntidad;
    }

    public void setIdTipoEntidad(long idTipoEntidad) {
        this.idTipoEntidad = idTipoEntidad;
    }

    public long getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(long idLocalidad) {
        this.idLocalidad = idLocalidad;
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
    public List<TabUsuario> getTabUsuarioList() {
        return tabUsuarioList;
    }

    public void setTabUsuarioList(List<TabUsuario> tabUsuarioList) {
        this.tabUsuarioList = tabUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabEntidad)) {
            return false;
        }
        TabEntidad other = (TabEntidad) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabEntidad[ idEntidad=" + idEntidad + " ]";
    }
    
}
