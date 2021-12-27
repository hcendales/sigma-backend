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
@Table(name = "TAB_EVENTO_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabEventoSistema.findAll", query = "SELECT t FROM TabEventoSistema t"),
    @NamedQuery(name = "TabEventoSistema.findByIdEventoSistema", query = "SELECT t FROM TabEventoSistema t WHERE t.idEventoSistema = :idEventoSistema"),
    @NamedQuery(name = "TabEventoSistema.findByUsuario", query = "SELECT t FROM TabEventoSistema t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TabEventoSistema.findByDescripcion", query = "SELECT t FROM TabEventoSistema t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabEventoSistema.findByFecha", query = "SELECT t FROM TabEventoSistema t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabEventoSistema.findByNuevo", query = "SELECT t FROM TabEventoSistema t WHERE t.nuevo = :nuevo"),
    @NamedQuery(name = "TabEventoSistema.findByAuditoriaUsuario", query = "SELECT t FROM TabEventoSistema t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabEventoSistema.findByAuditoriaFecha", query = "SELECT t FROM TabEventoSistema t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabEventoSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVENTO_SISTEMA")
    private Long idEventoSistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NUEVO")
    private String nuevo;
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
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne(optional = false)
    private TabEvento idEvento;

    public TabEventoSistema() {
    }

    public TabEventoSistema(Long idEventoSistema) {
        this.idEventoSistema = idEventoSistema;
    }

    public TabEventoSistema(Long idEventoSistema, String usuario, String descripcion, Date fecha, String nuevo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idEventoSistema = idEventoSistema;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.nuevo = nuevo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdEventoSistema() {
        return idEventoSistema;
    }

    public void setIdEventoSistema(Long idEventoSistema) {
        this.idEventoSistema = idEventoSistema;
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

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
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

    public TabEvento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TabEvento idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventoSistema != null ? idEventoSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabEventoSistema)) {
            return false;
        }
        TabEventoSistema other = (TabEventoSistema) object;
        if ((this.idEventoSistema == null && other.idEventoSistema != null) || (this.idEventoSistema != null && !this.idEventoSistema.equals(other.idEventoSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabEventoSistema[ idEventoSistema=" + idEventoSistema + " ]";
    }
    
}
