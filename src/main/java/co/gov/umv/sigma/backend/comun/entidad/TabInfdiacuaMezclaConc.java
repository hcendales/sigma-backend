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
@Table(name = "TAB_INFDIACUA_MEZCLA_CONC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findAll", query = "SELECT t FROM TabInfdiacuaMezclaConc t"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByIdInfdiacuaMezclaConc", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.idInfdiacuaMezclaConc = :idInfdiacuaMezclaConc"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByIdTipoMaterial", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByIdTipoClaseMaterial", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.idTipoClaseMaterial = :idTipoClaseMaterial"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByMovil", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.movil = :movil"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByPlaca", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.placa = :placa"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByVolumen", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.volumen = :volumen"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByNumeroRecibo", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.numeroRecibo = :numeroRecibo"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByIdArchivoRecibo", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.idArchivoRecibo = :idArchivoRecibo"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByHoraEntrada", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByHoraInstalacion", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.horaInstalacion = :horaInstalacion"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByHoraSalida", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.horaSalida = :horaSalida"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByAbcsisaInicio", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.abcsisaInicio = :abcsisaInicio"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByAbcsisaFinal", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.abcsisaFinal = :abcsisaFinal"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByAbcsisaCarril", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.abcsisaCarril = :abcsisaCarril"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByTemperaturaRecibo", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.temperaturaRecibo = :temperaturaRecibo"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByTemperaturaLlegada", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.temperaturaLlegada = :temperaturaLlegada"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByTemperaturaExtendido", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.temperaturaExtendido = :temperaturaExtendido"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByTemperaturaCompactacion", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.temperaturaCompactacion = :temperaturaCompactacion"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaMezclaConc.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaMezclaConc t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaMezclaConc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_MEZCLA_CONC")
    private Long idInfdiacuaMezclaConc;
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
    @Column(name = "MOVIL")
    private String movil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PLACA")
    private String placa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOLUMEN")
    private BigDecimal volumen;
    @Size(max = 30)
    @Column(name = "NUMERO_RECIBO")
    private String numeroRecibo;
    @Column(name = "ID_ARCHIVO_RECIBO")
    private Long idArchivoRecibo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "HORA_ENTRADA")
    private String horaEntrada;
    @Size(max = 5)
    @Column(name = "HORA_INSTALACION")
    private String horaInstalacion;
    @Size(max = 5)
    @Column(name = "HORA_SALIDA")
    private String horaSalida;
    @Column(name = "ABCSISA_INICIO")
    private BigDecimal abcsisaInicio;
    @Column(name = "ABCSISA_FINAL")
    private BigDecimal abcsisaFinal;
    @Column(name = "ABCSISA_CARRIL")
    private BigDecimal abcsisaCarril;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEMPERATURA_RECIBO")
    private BigDecimal temperaturaRecibo;
    @Column(name = "TEMPERATURA_LLEGADA")
    private BigDecimal temperaturaLlegada;
    @Column(name = "TEMPERATURA_EXTENDIDO")
    private BigDecimal temperaturaExtendido;
    @Column(name = "TEMPERATURA_COMPACTACION")
    private BigDecimal temperaturaCompactacion;
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

    public TabInfdiacuaMezclaConc() {
    }

    public TabInfdiacuaMezclaConc(Long idInfdiacuaMezclaConc) {
        this.idInfdiacuaMezclaConc = idInfdiacuaMezclaConc;
    }

    public TabInfdiacuaMezclaConc(Long idInfdiacuaMezclaConc, long idTipoMaterial, long idTipoClaseMaterial, String movil, String placa, BigDecimal volumen, String horaEntrada, BigDecimal temperaturaRecibo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaMezclaConc = idInfdiacuaMezclaConc;
        this.idTipoMaterial = idTipoMaterial;
        this.idTipoClaseMaterial = idTipoClaseMaterial;
        this.movil = movil;
        this.placa = placa;
        this.volumen = volumen;
        this.horaEntrada = horaEntrada;
        this.temperaturaRecibo = temperaturaRecibo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaMezclaConc() {
        return idInfdiacuaMezclaConc;
    }

    public void setIdInfdiacuaMezclaConc(Long idInfdiacuaMezclaConc) {
        this.idInfdiacuaMezclaConc = idInfdiacuaMezclaConc;
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

    public String getHoraInstalacion() {
        return horaInstalacion;
    }

    public void setHoraInstalacion(String horaInstalacion) {
        this.horaInstalacion = horaInstalacion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public BigDecimal getAbcsisaInicio() {
        return abcsisaInicio;
    }

    public void setAbcsisaInicio(BigDecimal abcsisaInicio) {
        this.abcsisaInicio = abcsisaInicio;
    }

    public BigDecimal getAbcsisaFinal() {
        return abcsisaFinal;
    }

    public void setAbcsisaFinal(BigDecimal abcsisaFinal) {
        this.abcsisaFinal = abcsisaFinal;
    }

    public BigDecimal getAbcsisaCarril() {
        return abcsisaCarril;
    }

    public void setAbcsisaCarril(BigDecimal abcsisaCarril) {
        this.abcsisaCarril = abcsisaCarril;
    }

    public BigDecimal getTemperaturaRecibo() {
        return temperaturaRecibo;
    }

    public void setTemperaturaRecibo(BigDecimal temperaturaRecibo) {
        this.temperaturaRecibo = temperaturaRecibo;
    }

    public BigDecimal getTemperaturaLlegada() {
        return temperaturaLlegada;
    }

    public void setTemperaturaLlegada(BigDecimal temperaturaLlegada) {
        this.temperaturaLlegada = temperaturaLlegada;
    }

    public BigDecimal getTemperaturaExtendido() {
        return temperaturaExtendido;
    }

    public void setTemperaturaExtendido(BigDecimal temperaturaExtendido) {
        this.temperaturaExtendido = temperaturaExtendido;
    }

    public BigDecimal getTemperaturaCompactacion() {
        return temperaturaCompactacion;
    }

    public void setTemperaturaCompactacion(BigDecimal temperaturaCompactacion) {
        this.temperaturaCompactacion = temperaturaCompactacion;
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
        hash += (idInfdiacuaMezclaConc != null ? idInfdiacuaMezclaConc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaMezclaConc)) {
            return false;
        }
        TabInfdiacuaMezclaConc other = (TabInfdiacuaMezclaConc) object;
        if ((this.idInfdiacuaMezclaConc == null && other.idInfdiacuaMezclaConc != null) || (this.idInfdiacuaMezclaConc != null && !this.idInfdiacuaMezclaConc.equals(other.idInfdiacuaMezclaConc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaMezclaConc[ idInfdiacuaMezclaConc=" + idInfdiacuaMezclaConc + " ]";
    }
    
}
