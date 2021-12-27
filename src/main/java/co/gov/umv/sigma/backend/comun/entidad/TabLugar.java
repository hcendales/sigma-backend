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
@Table(name = "TAB_LUGAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabLugar.findAll", query = "SELECT t FROM TabLugar t"),
    @NamedQuery(name = "TabLugar.findByIdLugar", query = "SELECT t FROM TabLugar t WHERE t.idLugar = :idLugar"),
    @NamedQuery(name = "TabLugar.findByIdTipoLugar", query = "SELECT t FROM TabLugar t WHERE t.idTipoLugar = :idTipoLugar"),
    @NamedQuery(name = "TabLugar.findByIdTipoOrigen", query = "SELECT t FROM TabLugar t WHERE t.idTipoOrigen = :idTipoOrigen"),
    @NamedQuery(name = "TabLugar.findByContactoNombre", query = "SELECT t FROM TabLugar t WHERE t.contactoNombre = :contactoNombre"),
    @NamedQuery(name = "TabLugar.findByContactoCorreoElectronico", query = "SELECT t FROM TabLugar t WHERE t.contactoCorreoElectronico = :contactoCorreoElectronico"),
    @NamedQuery(name = "TabLugar.findByContactoTelefono", query = "SELECT t FROM TabLugar t WHERE t.contactoTelefono = :contactoTelefono"),
    @NamedQuery(name = "TabLugar.findByDireccion", query = "SELECT t FROM TabLugar t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TabLugar.findByIdTipoEstadoLugar", query = "SELECT t FROM TabLugar t WHERE t.idTipoEstadoLugar = :idTipoEstadoLugar"),
    @NamedQuery(name = "TabLugar.findByAuditoriaUsuario", query = "SELECT t FROM TabLugar t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabLugar.findByAuditoriaFecha", query = "SELECT t FROM TabLugar t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabLugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LUGAR")
    private Long idLugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_LUGAR")
    private long idTipoLugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ORIGEN")
    private long idTipoOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CONTACTO_NOMBRE")
    private String contactoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CONTACTO_CORREO_ELECTRONICO")
    private String contactoCorreoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACTO_TELEFONO")
    private long contactoTelefono;
    @Size(max = 300)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_LUGAR")
    private long idTipoEstadoLugar;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    
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
    @OneToMany(mappedBy = "idLugar")
    private List<TabRecurso> tabRecursoList;

    public TabLugar() {
    }

    public TabLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public TabLugar(Long idLugar, long idTipoLugar, long idTipoOrigen, String contactoNombre, String contactoCorreoElectronico, long contactoTelefono, long idTipoEstadoLugar, String auditoriaUsuario, Date auditoriaFecha) {
        this.idLugar = idLugar;
        this.idTipoLugar = idTipoLugar;
        this.idTipoOrigen = idTipoOrigen;
        this.contactoNombre = contactoNombre;
        this.contactoCorreoElectronico = contactoCorreoElectronico;
        this.contactoTelefono = contactoTelefono;
        this.idTipoEstadoLugar = idTipoEstadoLugar;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public long getIdTipoLugar() {
        return idTipoLugar;
    }

    public void setIdTipoLugar(long idTipoLugar) {
        this.idTipoLugar = idTipoLugar;
    }

    public long getIdTipoOrigen() {
        return idTipoOrigen;
    }

    public void setIdTipoOrigen(long idTipoOrigen) {
        this.idTipoOrigen = idTipoOrigen;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoCorreoElectronico() {
        return contactoCorreoElectronico;
    }

    public void setContactoCorreoElectronico(String contactoCorreoElectronico) {
        this.contactoCorreoElectronico = contactoCorreoElectronico;
    }

    public long getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(long contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getIdTipoEstadoLugar() {
        return idTipoEstadoLugar;
    }

    public void setIdTipoEstadoLugar(long idTipoEstadoLugar) {
        this.idTipoEstadoLugar = idTipoEstadoLugar;
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
    public List<TabRecurso> getTabRecursoList() {
        return tabRecursoList;
    }

    public void setTabRecursoList(List<TabRecurso> tabRecursoList) {
        this.tabRecursoList = tabRecursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugar != null ? idLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabLugar)) {
            return false;
        }
        TabLugar other = (TabLugar) object;
        if ((this.idLugar == null && other.idLugar != null) || (this.idLugar != null && !this.idLugar.equals(other.idLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabLugar[ idLugar=" + idLugar + " ]";
    }
    
}
