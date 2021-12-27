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
@Table(name = "TAB_INFDIACUA_CANT_OBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaCantObra.findAll", query = "SELECT t FROM TabInfdiacuaCantObra t"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByIdInfdiacuaCantObra", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.idInfdiacuaCantObra = :idInfdiacuaCantObra"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByIdTipoActividad", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.idTipoActividad = :idTipoActividad"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByIdTipoMaterial", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByIdTipoClaseMaterial", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.idTipoClaseMaterial = :idTipoClaseMaterial"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByIdTipoUnidadMedida", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.idTipoUnidadMedida = :idTipoUnidadMedida"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByCantidad", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByLargo", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.largo = :largo"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByAncho", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.ancho = :ancho"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByEspesor", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.espesor = :espesor"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByVolumenMaterialCompacto", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.volumenMaterialCompacto = :volumenMaterialCompacto"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByPorcentajeCompactacion", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.porcentajeCompactacion = :porcentajeCompactacion"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByManual", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.manual = :manual"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByMecanica", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.mecanica = :mecanica"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaCantObra.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaCantObra t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaCantObra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_CANT_OBRA")
    private Long idInfdiacuaCantObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ACTIVIDAD")
    private long idTipoActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_MATERIAL")
    private long idTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLASE_MATERIAL")
    private long idTipoClaseMaterial;
    @Column(name = "ID_TIPO_UNIDAD_MEDIDA")
    private Long idTipoUnidadMedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Column(name = "LARGO")
    private BigDecimal largo;
    @Column(name = "ANCHO")
    private BigDecimal ancho;
    @Column(name = "ESPESOR")
    private BigDecimal espesor;
    @Column(name = "VOLUMEN_MATERIAL_COMPACTO")
    private BigDecimal volumenMaterialCompacto;
    @Column(name = "PORCENTAJE_COMPACTACION")
    private BigDecimal porcentajeCompactacion;
    @Size(max = 2)
    @Column(name = "MANUAL")
    private String manual;
    @Size(max = 2)
    @Column(name = "MECANICA")
    private String mecanica;
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

    public TabInfdiacuaCantObra() {
    }

    public TabInfdiacuaCantObra(Long idInfdiacuaCantObra) {
        this.idInfdiacuaCantObra = idInfdiacuaCantObra;
    }

    public TabInfdiacuaCantObra(Long idInfdiacuaCantObra, long idTipoActividad, long idTipoMaterial, long idTipoClaseMaterial, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaCantObra = idInfdiacuaCantObra;
        this.idTipoActividad = idTipoActividad;
        this.idTipoMaterial = idTipoMaterial;
        this.idTipoClaseMaterial = idTipoClaseMaterial;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaCantObra() {
        return idInfdiacuaCantObra;
    }

    public void setIdInfdiacuaCantObra(Long idInfdiacuaCantObra) {
        this.idInfdiacuaCantObra = idInfdiacuaCantObra;
    }

    public long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
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

    public Long getIdTipoUnidadMedida() {
        return idTipoUnidadMedida;
    }

    public void setIdTipoUnidadMedida(Long idTipoUnidadMedida) {
        this.idTipoUnidadMedida = idTipoUnidadMedida;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getEspesor() {
        return espesor;
    }

    public void setEspesor(BigDecimal espesor) {
        this.espesor = espesor;
    }

    public BigDecimal getVolumenMaterialCompacto() {
        return volumenMaterialCompacto;
    }

    public void setVolumenMaterialCompacto(BigDecimal volumenMaterialCompacto) {
        this.volumenMaterialCompacto = volumenMaterialCompacto;
    }

    public BigDecimal getPorcentajeCompactacion() {
        return porcentajeCompactacion;
    }

    public void setPorcentajeCompactacion(BigDecimal porcentajeCompactacion) {
        this.porcentajeCompactacion = porcentajeCompactacion;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getMecanica() {
        return mecanica;
    }

    public void setMecanica(String mecanica) {
        this.mecanica = mecanica;
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
        hash += (idInfdiacuaCantObra != null ? idInfdiacuaCantObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaCantObra)) {
            return false;
        }
        TabInfdiacuaCantObra other = (TabInfdiacuaCantObra) object;
        if ((this.idInfdiacuaCantObra == null && other.idInfdiacuaCantObra != null) || (this.idInfdiacuaCantObra != null && !this.idInfdiacuaCantObra.equals(other.idInfdiacuaCantObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaCantObra[ idInfdiacuaCantObra=" + idInfdiacuaCantObra + " ]";
    }
    
}
