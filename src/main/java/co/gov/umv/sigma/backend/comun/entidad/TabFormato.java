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
@Table(name = "TAB_FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabFormato.findAll", query = "SELECT t FROM TabFormato t"),
    @NamedQuery(name = "TabFormato.findByIdFormato", query = "SELECT t FROM TabFormato t WHERE t.idFormato = :idFormato"),
    @NamedQuery(name = "TabFormato.findByIdTipoDocumento", query = "SELECT t FROM TabFormato t WHERE t.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "TabFormato.findByCodigoFormato", query = "SELECT t FROM TabFormato t WHERE t.codigoFormato = :codigoFormato"),
    @NamedQuery(name = "TabFormato.findByRegistroActivo", query = "SELECT t FROM TabFormato t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabFormato.findByAuditoriaUsuario", query = "SELECT t FROM TabFormato t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabFormato.findByAuditoriaFecha", query = "SELECT t FROM TabFormato t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabFormato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FORMATO")
    private Long idFormato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DOCUMENTO")
    private long idTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CODIGO_FORMATO")
    private String codigoFormato;
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
    @JoinColumn(name = "ID_ARCHIVO", referencedColumnName = "ID_ARCHIVO")
    @OneToOne
    private TabArchivo idArchivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormato")
    private List<TabFormatoSeccion> tabFormatoSeccionList;

    public TabFormato() {
    }

    public TabFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public TabFormato(Long idFormato, long idTipoDocumento, String codigoFormato, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idFormato = idFormato;
        this.idTipoDocumento = idTipoDocumento;
        this.codigoFormato = codigoFormato;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getCodigoFormato() {
        return codigoFormato;
    }

    public void setCodigoFormato(String codigoFormato) {
        this.codigoFormato = codigoFormato;
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

    public TabArchivo getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(TabArchivo idArchivo) {
        this.idArchivo = idArchivo;
    }

    @XmlTransient
    public List<TabFormatoSeccion> getTabFormatoSeccionList() {
        return tabFormatoSeccionList;
    }

    public void setTabFormatoSeccionList(List<TabFormatoSeccion> tabFormatoSeccionList) {
        this.tabFormatoSeccionList = tabFormatoSeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormato != null ? idFormato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabFormato)) {
            return false;
        }
        TabFormato other = (TabFormato) object;
        if ((this.idFormato == null && other.idFormato != null) || (this.idFormato != null && !this.idFormato.equals(other.idFormato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabFormato[ idFormato=" + idFormato + " ]";
    }
    
}
