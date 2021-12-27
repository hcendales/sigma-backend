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
@Table(name = "TAB_CONFIGURACION_SERVICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabConfiguracionServicios.findAll", query = "SELECT t FROM TabConfiguracionServicios t"),
    @NamedQuery(name = "TabConfiguracionServicios.findByIdConfiguracionServicio", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.idConfiguracionServicio = :idConfiguracionServicio"),
    @NamedQuery(name = "TabConfiguracionServicios.findByNombre", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabConfiguracionServicios.findByEntidad", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.entidad = :entidad"),
    @NamedQuery(name = "TabConfiguracionServicios.findByDescripcion", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabConfiguracionServicios.findByServicioA", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.servicioA = :servicioA"),
    @NamedQuery(name = "TabConfiguracionServicios.findByServicioB", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.servicioB = :servicioB"),
    @NamedQuery(name = "TabConfiguracionServicios.findByPlanActivo", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.planActivo = :planActivo"),
    @NamedQuery(name = "TabConfiguracionServicios.findByAuditoriaUsuario", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabConfiguracionServicios.findByAuditoriaFecha", query = "SELECT t FROM TabConfiguracionServicios t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabConfiguracionServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONFIGURACION_SERVICIO")
    private Long idConfiguracionServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ENTIDAD")
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "SERVICIO_A")
    private String servicioA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "SERVICIO_B")
    private String servicioB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PLAN_ACTIVO")
    private String planActivo;
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

    public TabConfiguracionServicios() {
    }

    public TabConfiguracionServicios(Long idConfiguracionServicio) {
        this.idConfiguracionServicio = idConfiguracionServicio;
    }

    public TabConfiguracionServicios(Long idConfiguracionServicio, String nombre, String entidad, String descripcion, String servicioA, String servicioB, String planActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idConfiguracionServicio = idConfiguracionServicio;
        this.nombre = nombre;
        this.entidad = entidad;
        this.descripcion = descripcion;
        this.servicioA = servicioA;
        this.servicioB = servicioB;
        this.planActivo = planActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdConfiguracionServicio() {
        return idConfiguracionServicio;
    }

    public void setIdConfiguracionServicio(Long idConfiguracionServicio) {
        this.idConfiguracionServicio = idConfiguracionServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getServicioA() {
        return servicioA;
    }

    public void setServicioA(String servicioA) {
        this.servicioA = servicioA;
    }

    public String getServicioB() {
        return servicioB;
    }

    public void setServicioB(String servicioB) {
        this.servicioB = servicioB;
    }

    public String getPlanActivo() {
        return planActivo;
    }

    public void setPlanActivo(String planActivo) {
        this.planActivo = planActivo;
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
        hash += (idConfiguracionServicio != null ? idConfiguracionServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabConfiguracionServicios)) {
            return false;
        }
        TabConfiguracionServicios other = (TabConfiguracionServicios) object;
        if ((this.idConfiguracionServicio == null && other.idConfiguracionServicio != null) || (this.idConfiguracionServicio != null && !this.idConfiguracionServicio.equals(other.idConfiguracionServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabConfiguracionServicios[ idConfiguracionServicio=" + idConfiguracionServicio + " ]";
    }
    
}
