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
@Table(name = "TAB_MANTENIMIENTO_VIAL_DOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMantenimientoVialDocu.findAll", query = "SELECT t FROM TabMantenimientoVialDocu t"),
    @NamedQuery(name = "TabMantenimientoVialDocu.findByIdMantenimientoVialDocu", query = "SELECT t FROM TabMantenimientoVialDocu t WHERE t.idMantenimientoVialDocu = :idMantenimientoVialDocu"),
    @NamedQuery(name = "TabMantenimientoVialDocu.findByRegistroActivo", query = "SELECT t FROM TabMantenimientoVialDocu t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabMantenimientoVialDocu.findByAuditoriaUsuario", query = "SELECT t FROM TabMantenimientoVialDocu t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMantenimientoVialDocu.findByAuditoriaFecha", query = "SELECT t FROM TabMantenimientoVialDocu t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabMantenimientoVialDocu implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO")
    private long idDocumento;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO_VIAL_DOCU")
    private Long idMantenimientoVialDocu;
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
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL", referencedColumnName = "ID_MANTENIMIENTO_VIAL")
    @ManyToOne(optional = false)
    private TabMantenimientoVial idMantenimientoVial;

    public TabMantenimientoVialDocu() {
    }

    public TabMantenimientoVialDocu(Long idMantenimientoVialDocu) {
        this.idMantenimientoVialDocu = idMantenimientoVialDocu;
    }

    public TabMantenimientoVialDocu(Long idMantenimientoVialDocu, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idMantenimientoVialDocu = idMantenimientoVialDocu;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdMantenimientoVialDocu() {
        return idMantenimientoVialDocu;
    }

    public void setIdMantenimientoVialDocu(Long idMantenimientoVialDocu) {
        this.idMantenimientoVialDocu = idMantenimientoVialDocu;
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

    public TabMantenimientoVial getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(TabMantenimientoVial idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimientoVialDocu != null ? idMantenimientoVialDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMantenimientoVialDocu)) {
            return false;
        }
        TabMantenimientoVialDocu other = (TabMantenimientoVialDocu) object;
        if ((this.idMantenimientoVialDocu == null && other.idMantenimientoVialDocu != null) || (this.idMantenimientoVialDocu != null && !this.idMantenimientoVialDocu.equals(other.idMantenimientoVialDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialDocu[ idMantenimientoVialDocu=" + idMantenimientoVialDocu + " ]";
    }

    public long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }
    
}
