/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TAB_INFDIACUA_ENTR_MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findAll", query = "SELECT t FROM TabInfdiacuaEntrMaterial t"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByIdInfdiacuaEntrMaterial", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.idInfdiacuaEntrMaterial = :idInfdiacuaEntrMaterial"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByIdTipoMaterial", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByIdTipoClaseMaterial", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.idTipoClaseMaterial = :idTipoClaseMaterial"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByPlaca", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.placa = :placa"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByMovil", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.movil = :movil"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByVolumen", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.volumen = :volumen"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByNumeroRecibo", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.numeroRecibo = :numeroRecibo"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByIdArchivoRecibo", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.idArchivoRecibo = :idArchivoRecibo"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByHoraEntrada", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByHoraSalida", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.horaSalida = :horaSalida"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByActividadObservacion", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.actividadObservacion = :actividadObservacion"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByObservaciones", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaEntrMaterial.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaEntrMaterial t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaEntrMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_ENTR_MATERIAL")
    private Long idInfdiacuaEntrMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_MATERIAL")
    private long idTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLASE_MATERIAL")
    private long idTipoClaseMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOVIL")
    private String movil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VOLUMEN")
    private BigDecimal volumen;
    @Size(max = 30)
    @Column(name = "NUMERO_RECIBO")
    private String numeroRecibo;
    @Column(name = "ID_ARCHIVO_RECIBO")
    private Long idArchivoRecibo;
    @Size(max = 5)
    @Column(name = "HORA_ENTRADA")
    private String horaEntrada;
    @Size(max = 5)
    @Column(name = "HORA_SALIDA")
    private String horaSalida;
    @Size(max = 600)
    @Column(name = "ACTIVIDAD_OBSERVACION")
    private String actividadObservacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
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

    public TabInfdiacuaEntrMaterial() {
    }

    public TabInfdiacuaEntrMaterial(Long idInfdiacuaEntrMaterial) {
        this.idInfdiacuaEntrMaterial = idInfdiacuaEntrMaterial;
    }

    public TabInfdiacuaEntrMaterial(Long idInfdiacuaEntrMaterial, long idTipoMaterial, long idTipoClaseMaterial, String placa, String movil, String observaciones, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaEntrMaterial = idInfdiacuaEntrMaterial;
        this.idTipoMaterial = idTipoMaterial;
        this.idTipoClaseMaterial = idTipoClaseMaterial;
        this.placa = placa;
        this.movil = movil;
        this.observaciones = observaciones;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaEntrMaterial() {
        return idInfdiacuaEntrMaterial;
    }

    public void setIdInfdiacuaEntrMaterial(Long idInfdiacuaEntrMaterial) {
        this.idInfdiacuaEntrMaterial = idInfdiacuaEntrMaterial;
    }

    public long getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(long idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public long getIdTipoClaseMaterial() {
        return idTipoClaseMaterial;
    }

    public void setIdTipoClaseMaterial(long idTipoClaseMaterial) {
        this.idTipoClaseMaterial = idTipoClaseMaterial;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public BigDecimal getVolumen() {
        return volumen;
    }

    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
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

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getActividadObservacion() {
        return actividadObservacion;
    }

    public void setActividadObservacion(String actividadObservacion) {
        this.actividadObservacion = actividadObservacion;
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
        hash += (idInfdiacuaEntrMaterial != null ? idInfdiacuaEntrMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaEntrMaterial)) {
            return false;
        }
        TabInfdiacuaEntrMaterial other = (TabInfdiacuaEntrMaterial) object;
        if ((this.idInfdiacuaEntrMaterial == null && other.idInfdiacuaEntrMaterial != null) || (this.idInfdiacuaEntrMaterial != null && !this.idInfdiacuaEntrMaterial.equals(other.idInfdiacuaEntrMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaEntrMaterial[ idInfdiacuaEntrMaterial=" + idInfdiacuaEntrMaterial + " ]";
    }
    
}
