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
@Table(name = "TAB_ROL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRolUsuario.findAll", query = "SELECT t FROM TabRolUsuario t"),
    @NamedQuery(name = "TabRolUsuario.findByIdRolUsuario", query = "SELECT t FROM TabRolUsuario t WHERE t.idRolUsuario = :idRolUsuario"),
    @NamedQuery(name = "TabRolUsuario.findByRegistroActivo", query = "SELECT t FROM TabRolUsuario t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabRolUsuario.findByAuditoriaUsuario", query = "SELECT t FROM TabRolUsuario t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRolUsuario.findByAuditoriaFecha", query = "SELECT t FROM TabRolUsuario t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRolUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL_USUARIO")
    private Long idRolUsuario;
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
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private TabRol idRol;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private TabUsuario idUsuario;

    public TabRolUsuario() {
    }

    public TabRolUsuario(Long idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public TabRolUsuario(Long idRolUsuario, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRolUsuario = idRolUsuario;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(Long idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
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

    public TabRol getIdRol() {
        return idRol;
    }

    public void setIdRol(TabRol idRol) {
        this.idRol = idRol;
    }

    public TabUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TabUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolUsuario != null ? idRolUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRolUsuario)) {
            return false;
        }
        TabRolUsuario other = (TabRolUsuario) object;
        if ((this.idRolUsuario == null && other.idRolUsuario != null) || (this.idRolUsuario != null && !this.idRolUsuario.equals(other.idRolUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRolUsuario[ idRolUsuario=" + idRolUsuario + " ]";
    }
    
}
