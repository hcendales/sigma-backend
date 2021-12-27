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
@Table(name = "TAB_BACHE_ADJUNTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabBacheAdjunto.findAll", query = "SELECT t FROM TabBacheAdjunto t"),
    @NamedQuery(name = "TabBacheAdjunto.findByIdBacheAdjunto", query = "SELECT t FROM TabBacheAdjunto t WHERE t.idBacheAdjunto = :idBacheAdjunto"),
    @NamedQuery(name = "TabBacheAdjunto.findByIdBache", query = "SELECT t FROM TabBacheAdjunto t WHERE t.idBache = :idBache"),
    @NamedQuery(name = "TabBacheAdjunto.findByAuditoriaUsuario", query = "SELECT t FROM TabBacheAdjunto t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabBacheAdjunto.findByAuditoriaFecha", query = "SELECT t FROM TabBacheAdjunto t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabBacheAdjunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BACHE_ADJUNTO")
    private Long idBacheAdjunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BACHE")
    private long idBache;
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
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @OneToOne(optional = false)
    private TabDocumento idDocumento;

    public TabBacheAdjunto() {
    }

    public TabBacheAdjunto(Long idBacheAdjunto) {
        this.idBacheAdjunto = idBacheAdjunto;
    }

    public TabBacheAdjunto(Long idBacheAdjunto, long idBache, String auditoriaUsuario, Date auditoriaFecha) {
        this.idBacheAdjunto = idBacheAdjunto;
        this.idBache = idBache;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdBacheAdjunto() {
        return idBacheAdjunto;
    }

    public void setIdBacheAdjunto(Long idBacheAdjunto) {
        this.idBacheAdjunto = idBacheAdjunto;
    }

    public long getIdBache() {
        return idBache;
    }

    public void setIdBache(long idBache) {
        this.idBache = idBache;
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

    public TabDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(TabDocumento idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBacheAdjunto != null ? idBacheAdjunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabBacheAdjunto)) {
            return false;
        }
        TabBacheAdjunto other = (TabBacheAdjunto) object;
        if ((this.idBacheAdjunto == null && other.idBacheAdjunto != null) || (this.idBacheAdjunto != null && !this.idBacheAdjunto.equals(other.idBacheAdjunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabBacheAdjunto[ idBacheAdjunto=" + idBacheAdjunto + " ]";
    }
    
}
