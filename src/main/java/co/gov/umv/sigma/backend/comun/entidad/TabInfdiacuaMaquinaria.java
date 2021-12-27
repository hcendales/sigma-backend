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
@Table(name = "TAB_INFDIACUA_MAQUINARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findAll", query = "SELECT t FROM TabInfdiacuaMaquinaria t"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByIdInfdiacuaMaquinaria", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.idInfdiacuaMaquinaria = :idInfdiacuaMaquinaria"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByIdEquipo", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.idEquipo = :idEquipo"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByDescripcion", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByMovil", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.movil = :movil"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByPlaca", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.placa = :placa"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByHoraInicial", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.horaInicial = :horaInicial"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByHoraFinal", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.horaFinal = :horaFinal"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByHorasTrabajadas", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.horasTrabajadas = :horasTrabajadas"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByStandBy", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.standBy = :standBy"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByNumeroRecibo", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.numeroRecibo = :numeroRecibo"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByIdArchivoRecibo", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.idArchivoRecibo = :idArchivoRecibo"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByViajes", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.viajes = :viajes"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByActividadObservacion", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.actividadObservacion = :actividadObservacion"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaMaquinaria.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaMaquinaria t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaMaquinaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_MAQUINARIA")
    private Long idInfdiacuaMaquinaria;
    @Column(name = "ID_EQUIPO")
    private Long idEquipo;
    @Size(max = 600)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOVIL")
    private String movil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 5)
    @Column(name = "HORA_INICIAL")
    private String horaInicial;
    @Size(max = 5)
    @Column(name = "HORA_FINAL")
    private String horaFinal;
    @Column(name = "HORAS_TRABAJADAS")
    private Short horasTrabajadas;
    @Column(name = "STAND_BY")
    private Short standBy;
    @Size(max = 30)
    @Column(name = "NUMERO_RECIBO")
    private String numeroRecibo;
    @Column(name = "ID_ARCHIVO_RECIBO")
    private Long idArchivoRecibo;
    @Column(name = "VIAJES")
    private Short viajes;
    @Size(max = 600)
    @Column(name = "ACTIVIDAD_OBSERVACION")
    private String actividadObservacion;
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

    public TabInfdiacuaMaquinaria() {
    }

    public TabInfdiacuaMaquinaria(Long idInfdiacuaMaquinaria) {
        this.idInfdiacuaMaquinaria = idInfdiacuaMaquinaria;
    }

    public TabInfdiacuaMaquinaria(Long idInfdiacuaMaquinaria, String movil, String placa, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaMaquinaria = idInfdiacuaMaquinaria;
        this.movil = movil;
        this.placa = placa;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaMaquinaria() {
        return idInfdiacuaMaquinaria;
    }

    public void setIdInfdiacuaMaquinaria(Long idInfdiacuaMaquinaria) {
        this.idInfdiacuaMaquinaria = idInfdiacuaMaquinaria;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Short getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Short horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Short getStandBy() {
        return standBy;
    }

    public void setStandBy(Short standBy) {
        this.standBy = standBy;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Long getIdArchivoRecibo() {
        return idArchivoRecibo;
    }

    public void setIdArchivoRecibo(Long idArchivoRecibo) {
        this.idArchivoRecibo = idArchivoRecibo;
    }

    public Short getViajes() {
        return viajes;
    }

    public void setViajes(Short viajes) {
        this.viajes = viajes;
    }

    public String getActividadObservacion() {
        return actividadObservacion;
    }

    public void setActividadObservacion(String actividadObservacion) {
        this.actividadObservacion = actividadObservacion;
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
        hash += (idInfdiacuaMaquinaria != null ? idInfdiacuaMaquinaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaMaquinaria)) {
            return false;
        }
        TabInfdiacuaMaquinaria other = (TabInfdiacuaMaquinaria) object;
        if ((this.idInfdiacuaMaquinaria == null && other.idInfdiacuaMaquinaria != null) || (this.idInfdiacuaMaquinaria != null && !this.idInfdiacuaMaquinaria.equals(other.idInfdiacuaMaquinaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaMaquinaria[ idInfdiacuaMaquinaria=" + idInfdiacuaMaquinaria + " ]";
    }
    
}
