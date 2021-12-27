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
@Table(name = "TAB_ROL_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRolActividad.findAll", query = "SELECT t FROM TabRolActividad t"),
    @NamedQuery(name = "TabRolActividad.findByIdRolActividad", query = "SELECT t FROM TabRolActividad t WHERE t.idRolActividad = :idRolActividad"),
    @NamedQuery(name = "TabRolActividad.findByRegistroActivo", query = "SELECT t FROM TabRolActividad t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabRolActividad.findByAuditoriaUsuario", query = "SELECT t FROM TabRolActividad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRolActividad.findByAuditoriaFecha", query = "SELECT t FROM TabRolActividad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRolActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL_ACTIVIDAD")
    private Long idRolActividad;
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
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(optional = false)
    private TabActividad idActividad;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private TabRol idRol;

    public TabRolActividad() {
    }

    public TabRolActividad(Long idRolActividad) {
        this.idRolActividad = idRolActividad;
    }

    public TabRolActividad(Long idRolActividad, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRolActividad = idRolActividad;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRolActividad() {
        return idRolActividad;
    }

    public void setIdRolActividad(Long idRolActividad) {
        this.idRolActividad = idRolActividad;
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

    public TabActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(TabActividad idActividad) {
        this.idActividad = idActividad;
    }

    public TabRol getIdRol() {
        return idRol;
    }

    public void setIdRol(TabRol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolActividad != null ? idRolActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRolActividad)) {
            return false;
        }
        TabRolActividad other = (TabRolActividad) object;
        if ((this.idRolActividad == null && other.idRolActividad != null) || (this.idRolActividad != null && !this.idRolActividad.equals(other.idRolActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRolActividad[ idRolActividad=" + idRolActividad + " ]";
    }
    
}
