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
@Table(name = "TAB_INFDIACUA_SALI_MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findAll", query = "SELECT t FROM TabInfdiacuaSaliMaterial t"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByIdInfdiacuaSaliMaterial", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.idInfdiacuaSaliMaterial = :idInfdiacuaSaliMaterial"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByIdTipoMaterial", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByIdTipoClaseMaterial", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.idTipoClaseMaterial = :idTipoClaseMaterial"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByPlaca", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.placa = :placa"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByMovil", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.movil = :movil"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByVolumen", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.volumen = :volumen"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByNumeroRecibo", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.numeroRecibo = :numeroRecibo"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByIdArchivoRecibo", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.idArchivoRecibo = :idArchivoRecibo"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByHoraEntrada", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByHoraSalida", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.horaSalida = :horaSalida"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByIdTipoDestino", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.idTipoDestino = :idTipoDestino"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByNumeroVale", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.numeroVale = :numeroVale"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByObservaciones", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaSaliMaterial.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaSaliMaterial t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaSaliMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_SALI_MATERIAL")
    private Long idInfdiacuaSaliMaterial;
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
    @Column(name = "ID_TIPO_DESTINO")
    private Long idTipoDestino;
    @Size(max = 30)
    @Column(name = "NUMERO_VALE")
    private String numeroVale;
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

    public TabInfdiacuaSaliMaterial() {
    }

    public TabInfdiacuaSaliMaterial(Long idInfdiacuaSaliMaterial) {
        this.idInfdiacuaSaliMaterial = idInfdiacuaSaliMaterial;
    }

    public TabInfdiacuaSaliMaterial(Long idInfdiacuaSaliMaterial, long idTipoMaterial, long idTipoClaseMaterial, String placa, String movil, String observaciones, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaSaliMaterial = idInfdiacuaSaliMaterial;
        this.idTipoMaterial = idTipoMaterial;
        this.idTipoClaseMaterial = idTipoClaseMaterial;
        this.placa = placa;
        this.movil = movil;
        this.observaciones = observaciones;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaSaliMaterial() {
        return idInfdiacuaSaliMaterial;
    }

    public void setIdInfdiacuaSaliMaterial(Long idInfdiacuaSaliMaterial) {
        this.idInfdiacuaSaliMaterial = idInfdiacuaSaliMaterial;
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

    public Long getIdTipoDestino() {
        return idTipoDestino;
    }

    public void setIdTipoDestino(Long idTipoDestino) {
        this.idTipoDestino = idTipoDestino;
    }

    public String getNumeroVale() {
        return numeroVale;
    }

    public void setNumeroVale(String numeroVale) {
        this.numeroVale = numeroVale;
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
        hash += (idInfdiacuaSaliMaterial != null ? idInfdiacuaSaliMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaSaliMaterial)) {
            return false;
        }
        TabInfdiacuaSaliMaterial other = (TabInfdiacuaSaliMaterial) object;
        if ((this.idInfdiacuaSaliMaterial == null && other.idInfdiacuaSaliMaterial != null) || (this.idInfdiacuaSaliMaterial != null && !this.idInfdiacuaSaliMaterial.equals(other.idInfdiacuaSaliMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaSaliMaterial[ idInfdiacuaSaliMaterial=" + idInfdiacuaSaliMaterial + " ]";
    }
    
}
