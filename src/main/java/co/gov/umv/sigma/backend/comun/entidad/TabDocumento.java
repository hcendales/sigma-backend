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
import javax.persistence.OneToOne;
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
@Table(name = "TAB_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabDocumento.findAll", query = "SELECT t FROM TabDocumento t"),
    @NamedQuery(name = "TabDocumento.findByIdDocumento", query = "SELECT t FROM TabDocumento t WHERE t.idDocumento = :idDocumento"),
    @NamedQuery(name = "TabDocumento.findByIdTipoDocumento", query = "SELECT t FROM TabDocumento t WHERE t.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "TabDocumento.findByIdTipoEstadoDocumento", query = "SELECT t FROM TabDocumento t WHERE t.idTipoEstadoDocumento = :idTipoEstadoDocumento"),
    @NamedQuery(name = "TabDocumento.findByNumero", query = "SELECT t FROM TabDocumento t WHERE t.numero = :numero"),
    @NamedQuery(name = "TabDocumento.findByFecha", query = "SELECT t FROM TabDocumento t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabDocumento.findByDescripcion", query = "SELECT t FROM TabDocumento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabDocumento.findByUrlArchivo", query = "SELECT t FROM TabDocumento t WHERE t.urlArchivo = :urlArchivo"),
    @NamedQuery(name = "TabDocumento.findByAuditoriaUsuario", query = "SELECT t FROM TabDocumento t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabDocumento.findByAuditoriaFecha", query = "SELECT t FROM TabDocumento t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO")
    private Long idDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DOCUMENTO")
    private long idTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_DOCUMENTO")
    private long idTipoEstadoDocumento;
    @Size(max = 30)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private String fecha;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 600)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private List<TabMantenimientoVialDocu> tabMantenimientoVialDocuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private List<TabDocumentoCampoValor> tabDocumentoCampoValorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private List<TabDocumentoEstado> tabDocumentoEstadoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private TabBacheAdjunto tabBacheAdjunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private List<TabArchivo> tabArchivoList;
    
    private String registroActivo;
    
    private String clave1;
    
    private String clave2;
    
    private String clave3;
    
    private Short numeroVersion;
    
    
	public TabDocumento() {
    }

    public TabDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public TabDocumento(Long idDocumento, long idTipoDocumento, long idTipoEstadoDocumento, String fecha, String auditoriaUsuario, Date auditoriaFecha) {
        this.idDocumento = idDocumento;
        this.idTipoDocumento = idTipoDocumento;
        this.idTipoEstadoDocumento = idTipoEstadoDocumento;
        this.fecha = fecha;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public long getIdTipoEstadoDocumento() {
        return idTipoEstadoDocumento;
    }

    public void setIdTipoEstadoDocumento(long idTipoEstadoDocumento) {
        this.idTipoEstadoDocumento = idTipoEstadoDocumento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<TabMantenimientoVialDocu> getTabMantenimientoVialDocuList() {
        return tabMantenimientoVialDocuList;
    }

    public void setTabMantenimientoVialDocuList(List<TabMantenimientoVialDocu> tabMantenimientoVialDocuList) {
        this.tabMantenimientoVialDocuList = tabMantenimientoVialDocuList;
    }

    @XmlTransient
    public List<TabDocumentoCampoValor> getTabDocumentoCampoValorList() {
        return tabDocumentoCampoValorList;
    }

    public void setTabDocumentoCampoValorList(List<TabDocumentoCampoValor> tabDocumentoCampoValorList) {
        this.tabDocumentoCampoValorList = tabDocumentoCampoValorList;
    }

    @XmlTransient
    public List<TabDocumentoEstado> getTabDocumentoEstadoList() {
        return tabDocumentoEstadoList;
    }

    public void setTabDocumentoEstadoList(List<TabDocumentoEstado> tabDocumentoEstadoList) {
        this.tabDocumentoEstadoList = tabDocumentoEstadoList;
    }

    public TabBacheAdjunto getTabBacheAdjunto() {
        return tabBacheAdjunto;
    }

    public void setTabBacheAdjunto(TabBacheAdjunto tabBacheAdjunto) {
        this.tabBacheAdjunto = tabBacheAdjunto;
    }

    @XmlTransient
    public List<TabArchivo> getTabArchivoList() {
        return tabArchivoList;
    }

    public void setTabArchivoList(List<TabArchivo> tabArchivoList) {
        this.tabArchivoList = tabArchivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabDocumento)) {
            return false;
        }
        TabDocumento other = (TabDocumento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabDocumento[ idDocumento=" + idDocumento + " ]";
    }
    
    public String getRegistroActivo() {
		return registroActivo;
	}

	public void setRegistroActivo(String registroActivo) {
		this.registroActivo = registroActivo;
	}

	public String getClave1() {
		return clave1;
	}

	public String getClave2() {
		return clave2;
	}

	public String getClave3() {
		return clave3;
	}

	public Short getNumeroVersion() {
		return numeroVersion;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public void setClave3(String clave3) {
		this.clave3 = clave3;
	}

	public void setNumeroVersion(Short numeroVersion) {
		this.numeroVersion = numeroVersion;
	}

}
