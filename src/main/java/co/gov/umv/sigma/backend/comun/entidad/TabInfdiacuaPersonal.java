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
@Table(name = "TAB_INFDIACUA_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaPersonal.findAll", query = "SELECT t FROM TabInfdiacuaPersonal t"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByIdInfdiacuaPersonal", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.idInfdiacuaPersonal = :idInfdiacuaPersonal"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByIdTipoHorario", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.idTipoHorario = :idTipoHorario"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByIdPersona", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.idPersona = :idPersona"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByHorarioLlegada", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.horarioLlegada = :horarioLlegada"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByHorarioSalida", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.horarioSalida = :horarioSalida"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByObservaciones", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaPersonal.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaPersonal t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaPersonal implements Serializable {

    @Column(name = "ID_TIPO_CATEGORIA_PERSONA")
    private Long idTipoCategoriaPersona;
    @Column(name = "ID_TIPO_CARGO")
    private Long idTipoCargo;
    @Column(name = "ID_TIPO_ROL")
    private Long idTipoRol;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_PERSONAL")
    private Long idInfdiacuaPersonal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_HORARIO")
    private long idTipoHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA")
    private long idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO_LLEGADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioLlegada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioSalida;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
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
    @JoinColumn(name = "ID_INFORME_DIARIO_CUADRILLA", referencedColumnName = "ID_INFORME_DIARIO_CUADRILLA")
    @ManyToOne(optional = false)
    private Long idInformeDiarioCuadrilla;

    public TabInfdiacuaPersonal() {
    }

    public TabInfdiacuaPersonal(Long idInfdiacuaPersonal) {
        this.idInfdiacuaPersonal = idInfdiacuaPersonal;
    }

    public TabInfdiacuaPersonal(Long idInfdiacuaPersonal, long idTipoHorario, long idPersona, Date horarioLlegada, Date horarioSalida, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaPersonal = idInfdiacuaPersonal;
        this.idTipoHorario = idTipoHorario;
        this.idPersona = idPersona;
        this.horarioLlegada = horarioLlegada;
        this.horarioSalida = horarioSalida;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaPersonal() {
        return idInfdiacuaPersonal;
    }

    public void setIdInfdiacuaPersonal(Long idInfdiacuaPersonal) {
        this.idInfdiacuaPersonal = idInfdiacuaPersonal;
    }

    public long getIdTipoHorario() {
        return idTipoHorario;
    }

    public void setIdTipoHorario(long idTipoHorario) {
        this.idTipoHorario = idTipoHorario;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public Date getHorarioLlegada() {
        return horarioLlegada;
    }

    public void setHorarioLlegada(Date horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public Date getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(Date horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Long getIdInformeDiarioCuadrilla() {
        return idInformeDiarioCuadrilla;
    }

    public void setIdInformeDiarioCuadrilla(Long idInformeDiarioCuadrilla) {
        this.idInformeDiarioCuadrilla = idInformeDiarioCuadrilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfdiacuaPersonal != null ? idInfdiacuaPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaPersonal)) {
            return false;
        }
        TabInfdiacuaPersonal other = (TabInfdiacuaPersonal) object;
        if ((this.idInfdiacuaPersonal == null && other.idInfdiacuaPersonal != null) || (this.idInfdiacuaPersonal != null && !this.idInfdiacuaPersonal.equals(other.idInfdiacuaPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaPersonal[ idInfdiacuaPersonal=" + idInfdiacuaPersonal + " ]";
    }

    public Long getIdTipoCategoriaPersona() {
        return idTipoCategoriaPersona;
    }

    public void setIdTipoCategoriaPersona(Long idTipoCategoriaPersona) {
        this.idTipoCategoriaPersona = idTipoCategoriaPersona;
    }

    public Long getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(Long idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public Long getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Long idTipoRol) {
        this.idTipoRol = idTipoRol;
    }
    
}
