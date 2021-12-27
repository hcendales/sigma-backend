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
@Table(name = "TAB_RADICADO_VINCULADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRadicadoVinculado.findAll", query = "SELECT t FROM TabRadicadoVinculado t"),
    @NamedQuery(name = "TabRadicadoVinculado.findByIdRadicadoVinculado", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.idRadicadoVinculado = :idRadicadoVinculado"),
    @NamedQuery(name = "TabRadicadoVinculado.findByIdTipoDestinoRadicado", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.idTipoDestinoRadicado = :idTipoDestinoRadicado"),
    @NamedQuery(name = "TabRadicadoVinculado.findByNumeroRadicado", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.numeroRadicado = :numeroRadicado"),
    @NamedQuery(name = "TabRadicadoVinculado.findByFechaRadicado", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.fechaRadicado = :fechaRadicado"),
    @NamedQuery(name = "TabRadicadoVinculado.findByEntidad", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.entidad = :entidad"),
    @NamedQuery(name = "TabRadicadoVinculado.findByRemitente", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.remitente = :remitente"),
    @NamedQuery(name = "TabRadicadoVinculado.findByDirigidoA", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.dirigidoA = :dirigidoA"),
    @NamedQuery(name = "TabRadicadoVinculado.findByFechaVencimiento", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "TabRadicadoVinculado.findByFechaVinculacion", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.fechaVinculacion = :fechaVinculacion"),
    @NamedQuery(name = "TabRadicadoVinculado.findByRegistroActivo", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabRadicadoVinculado.findByFechaDesvinculacion", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.fechaDesvinculacion = :fechaDesvinculacion"),
    @NamedQuery(name = "TabRadicadoVinculado.findByAuditoriaUsuario", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRadicadoVinculado.findByAuditoriaFecha", query = "SELECT t FROM TabRadicadoVinculado t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRadicadoVinculado implements Serializable {

    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_SALIDA")
    private String numeroRadicadoSalida;
    @Column(name = "FECHA_RADICADO_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicadoSalida;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ID_CALZADA")
    private long pkIdCalzada;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RADICADO_VINCULADO")
    private Long idRadicadoVinculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DESTINO_RADICADO")
    private long idTipoDestinoRadicado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_RADICADO")
    private String numeroRadicado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_RADICADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicado;
    @Size(max = 100)
    @Column(name = "ENTIDAD")
    private String entidad;
    @Size(max = 100)
    @Column(name = "REMITENTE")
    private String remitente;
    @Size(max = 100)
    @Column(name = "DIRIGIDO_A")
    private String dirigidoA;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VINCULACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVinculacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REGISTRO_ACTIVO")
    private String registroActivo;
    @Column(name = "FECHA_DESVINCULACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesvinculacion;
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

    
    @Column(name = "ID_TIPO_RADICADO")
    private long idTipoRadicado;
    
    
    
    public TabRadicadoVinculado() {
    }

    public TabRadicadoVinculado(Long idRadicadoVinculado) {
        this.idRadicadoVinculado = idRadicadoVinculado;
    }

    public TabRadicadoVinculado(Long idRadicadoVinculado, long idTipoDestinoRadicado, String numeroRadicado, Date fechaRadicado, Date fechaVinculacion, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRadicadoVinculado = idRadicadoVinculado;
        this.idTipoDestinoRadicado = idTipoDestinoRadicado;
        this.numeroRadicado = numeroRadicado;
        this.fechaRadicado = fechaRadicado;
        this.fechaVinculacion = fechaVinculacion;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRadicadoVinculado() {
        return idRadicadoVinculado;
    }

    public void setIdRadicadoVinculado(Long idRadicadoVinculado) {
        this.idRadicadoVinculado = idRadicadoVinculado;
    }

    public long getIdTipoDestinoRadicado() {
        return idTipoDestinoRadicado;
    }

    public void setIdTipoDestinoRadicado(long idTipoDestinoRadicado) {
        this.idTipoDestinoRadicado = idTipoDestinoRadicado;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public Date getFechaRadicado() {
        return fechaRadicado;
    }

    public void setFechaRadicado(Date fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(String dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(String registroActivo) {
        this.registroActivo = registroActivo;
    }

    public Date getFechaDesvinculacion() {
        return fechaDesvinculacion;
    }

    public void setFechaDesvinculacion(Date fechaDesvinculacion) {
        this.fechaDesvinculacion = fechaDesvinculacion;
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
        hash += (idRadicadoVinculado != null ? idRadicadoVinculado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRadicadoVinculado)) {
            return false;
        }
        TabRadicadoVinculado other = (TabRadicadoVinculado) object;
        if ((this.idRadicadoVinculado == null && other.idRadicadoVinculado != null) || (this.idRadicadoVinculado != null && !this.idRadicadoVinculado.equals(other.idRadicadoVinculado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRadicadoVinculado[ idRadicadoVinculado=" + idRadicadoVinculado + " ]";
    }

    public long getPkIdCalzada() {
        return pkIdCalzada;
    }

    public void setPkIdCalzada(long pkIdCalzada) {
        this.pkIdCalzada = pkIdCalzada;
    }

    public String getNumeroRadicadoSalida() {
        return numeroRadicadoSalida;
    }

    public void setNumeroRadicadoSalida(String numeroRadicadoSalida) {
        this.numeroRadicadoSalida = numeroRadicadoSalida;
    }

    public Date getFechaRadicadoSalida() {
        return fechaRadicadoSalida;
    }

    public void setFechaRadicadoSalida(Date fechaRadicadoSalida) {
        this.fechaRadicadoSalida = fechaRadicadoSalida;
    }

	public long getIdTipoRadicado() {
		return idTipoRadicado;
	}

	public void setIdTipoRadicado(long idTipoRadicado) {
		this.idTipoRadicado = idTipoRadicado;
	}
    
    
    
}
