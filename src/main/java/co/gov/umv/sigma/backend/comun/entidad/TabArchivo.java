/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "TAB_ARCHIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabArchivo.findAll", query = "SELECT t FROM TabArchivo t"),
    @NamedQuery(name = "TabArchivo.findByIdArchivo", query = "SELECT t FROM TabArchivo t WHERE t.idArchivo = :idArchivo"),
    @NamedQuery(name = "TabArchivo.findByNombre", query = "SELECT t FROM TabArchivo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabArchivo.findByUrlArchivo", query = "SELECT t FROM TabArchivo t WHERE t.urlArchivo = :urlArchivo"),
    @NamedQuery(name = "TabArchivo.findByAuditoriaUsuario", query = "SELECT t FROM TabArchivo t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabArchivo.findByAuditoriaFecha", query = "SELECT t FROM TabArchivo t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabArchivo implements Serializable {
	private String descripcion;
	

	@Column(name = "ID_TIPO_ARCHIVO")
	private Long idTipoArchivo;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ARCHIVO")
    private Long idArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "URL_ARCHIVO")
    private String urlArchivo;
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
    @OneToOne(mappedBy = "idArchivo")
    private TabFormato tabFormato;
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @ManyToOne(optional = false)
    private TabDocumento idDocumento;

    public TabArchivo() {
    }

    public TabArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public TabArchivo(Long idArchivo, String nombre, String urlArchivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idArchivo = idArchivo;
        this.nombre = nombre;
        this.urlArchivo = urlArchivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
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

    public TabFormato getTabFormato() {
        return tabFormato;
    }

    public void setTabFormato(TabFormato tabFormato) {
        this.tabFormato = tabFormato;
    }

    public TabDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(TabDocumento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIdTipoArchivo() {
		return idTipoArchivo;
	}

	public void setIdTipoArchivo(Long idTipoArchivo) {
		this.idTipoArchivo = idTipoArchivo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabArchivo)) {
            return false;
        }
        TabArchivo other = (TabArchivo) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabArchivo[ idArchivo=" + idArchivo + " ]";
    }

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
