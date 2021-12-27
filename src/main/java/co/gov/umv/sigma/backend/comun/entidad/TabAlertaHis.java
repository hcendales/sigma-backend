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
@Table(name = "TAB_ALERTA_HIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAlertaHis.findAll", query = "SELECT t FROM TabAlertaHis t"),
    @NamedQuery(name = "TabAlertaHis.findByIdAlerta", query = "SELECT t FROM TabAlertaHis t WHERE t.idAlerta = :idAlerta"),
    @NamedQuery(name = "TabAlertaHis.findByUsuario", query = "SELECT t FROM TabAlertaHis t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TabAlertaHis.findByDescripcion", query = "SELECT t FROM TabAlertaHis t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabAlertaHis.findByFecha", query = "SELECT t FROM TabAlertaHis t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabAlertaHis.findByLeida", query = "SELECT t FROM TabAlertaHis t WHERE t.leida = :leida"),
    @NamedQuery(name = "TabAlertaHis.findByFechaLeida", query = "SELECT t FROM TabAlertaHis t WHERE t.fechaLeida = :fechaLeida"),
    @NamedQuery(name = "TabAlertaHis.findByAuditoriaUsuario", query = "SELECT t FROM TabAlertaHis t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAlertaHis.findByAuditoriaFecha", query = "SELECT t FROM TabAlertaHis t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabAlertaHis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALERTA")
    private Long idAlerta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 2)
    @Column(name = "LEIDA")
    private String leida;
    @Column(name = "FECHA_LEIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLeida;
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

    public TabAlertaHis() {
    }

    public TabAlertaHis(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public TabAlertaHis(Long idAlerta, String usuario, String descripcion, Date fecha, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAlerta = idAlerta;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLeida() {
        return leida;
    }

    public void setLeida(String leida) {
        this.leida = leida;
    }

    public Date getFechaLeida() {
        return fechaLeida;
    }

    public void setFechaLeida(Date fechaLeida) {
        this.fechaLeida = fechaLeida;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlerta != null ? idAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAlertaHis)) {
            return false;
        }
        TabAlertaHis other = (TabAlertaHis) object;
        if ((this.idAlerta == null && other.idAlerta != null) || (this.idAlerta != null && !this.idAlerta.equals(other.idAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAlertaHis[ idAlerta=" + idAlerta + " ]";
    }
    
}
