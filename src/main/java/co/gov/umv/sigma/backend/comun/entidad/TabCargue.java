/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_CARGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabCargue.findAll", query = "SELECT t FROM TabCargue t"),
    @NamedQuery(name = "TabCargue.findByIdCargue", query = "SELECT t FROM TabCargue t WHERE t.idCargue = :idCargue"),
    @NamedQuery(name = "TabCargue.findByNombreArchivo", query = "SELECT t FROM TabCargue t WHERE t.nombreArchivo = :nombreArchivo"),
    @NamedQuery(name = "TabCargue.findByFechaRecibido", query = "SELECT t FROM TabCargue t WHERE t.fechaRecibido = :fechaRecibido"),
    @NamedQuery(name = "TabCargue.findByCantidadRegistros", query = "SELECT t FROM TabCargue t WHERE t.cantidadRegistros = :cantidadRegistros"),
    @NamedQuery(name = "TabCargue.findByFechaValidado", query = "SELECT t FROM TabCargue t WHERE t.fechaValidado = :fechaValidado"),
    @NamedQuery(name = "TabCargue.findByValidadoCorrecto", query = "SELECT t FROM TabCargue t WHERE t.validadoCorrecto = :validadoCorrecto"),
    @NamedQuery(name = "TabCargue.findByCantidadRegistrosNovalidos", query = "SELECT t FROM TabCargue t WHERE t.cantidadRegistrosNovalidos = :cantidadRegistrosNovalidos"),
    @NamedQuery(name = "TabCargue.findByFechaProcesado", query = "SELECT t FROM TabCargue t WHERE t.fechaProcesado = :fechaProcesado"),
    @NamedQuery(name = "TabCargue.findByProcesadoCorrecto", query = "SELECT t FROM TabCargue t WHERE t.procesadoCorrecto = :procesadoCorrecto"),
    @NamedQuery(name = "TabCargue.findByCantidadRegistrosError", query = "SELECT t FROM TabCargue t WHERE t.cantidadRegistrosError = :cantidadRegistrosError"),
    @NamedQuery(name = "TabCargue.findByAuditoriaUsuario", query = "SELECT t FROM TabCargue t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabCargue.findByAuditoriaFecha", query = "SELECT t FROM TabCargue t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabCargue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGUE")
    private Long idCargue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_RECIBIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecibido;
    @Column(name = "CANTIDAD_REGISTROS")
    private Integer cantidadRegistros;
    @Column(name = "FECHA_VALIDADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValidado;
    @Size(max = 2)
    @Column(name = "VALIDADO_CORRECTO")
    private String validadoCorrecto;
    @Column(name = "CANTIDAD_REGISTROS_NOVALIDOS")
    private Integer cantidadRegistrosNovalidos;
    @Column(name = "FECHA_PROCESADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProcesado;
    @Size(max = 2)
    @Column(name = "PROCESADO_CORRECTO")
    private String procesadoCorrecto;
    @Column(name = "CANTIDAD_REGISTROS_ERROR")
    private Integer cantidadRegistrosError;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargue")
    private List<TabCargueDetalle> tabCargueDetalleList;
    @JoinColumn(name = "ID_TIPO_CARGUE", referencedColumnName = "ID_TIPO_CARGUE")
    @ManyToOne(optional = false)
    private TabTipoCargue idTipoCargue;

    public TabCargue() {
    }

    public TabCargue(Long idCargue) {
        this.idCargue = idCargue;
    }

    public TabCargue(Long idCargue, String nombreArchivo, Date fechaRecibido, String auditoriaUsuario, Date auditoriaFecha) {
        this.idCargue = idCargue;
        this.nombreArchivo = nombreArchivo;
        this.fechaRecibido = fechaRecibido;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdCargue() {
        return idCargue;
    }

    public void setIdCargue(Long idCargue) {
        this.idCargue = idCargue;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Integer getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Integer cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }

    public Date getFechaValidado() {
        return fechaValidado;
    }

    public void setFechaValidado(Date fechaValidado) {
        this.fechaValidado = fechaValidado;
    }

    public String getValidadoCorrecto() {
        return validadoCorrecto;
    }

    public void setValidadoCorrecto(String validadoCorrecto) {
        this.validadoCorrecto = validadoCorrecto;
    }

    public Integer getCantidadRegistrosNovalidos() {
        return cantidadRegistrosNovalidos;
    }

    public void setCantidadRegistrosNovalidos(Integer cantidadRegistrosNovalidos) {
        this.cantidadRegistrosNovalidos = cantidadRegistrosNovalidos;
    }

    public Date getFechaProcesado() {
        return fechaProcesado;
    }

    public void setFechaProcesado(Date fechaProcesado) {
        this.fechaProcesado = fechaProcesado;
    }

    public String getProcesadoCorrecto() {
        return procesadoCorrecto;
    }

    public void setProcesadoCorrecto(String procesadoCorrecto) {
        this.procesadoCorrecto = procesadoCorrecto;
    }

    public Integer getCantidadRegistrosError() {
        return cantidadRegistrosError;
    }

    public void setCantidadRegistrosError(Integer cantidadRegistrosError) {
        this.cantidadRegistrosError = cantidadRegistrosError;
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

    @XmlTransient
    public List<TabCargueDetalle> getTabCargueDetalleList() {
        return tabCargueDetalleList;
    }

    public void setTabCargueDetalleList(List<TabCargueDetalle> tabCargueDetalleList) {
        this.tabCargueDetalleList = tabCargueDetalleList;
    }

    public TabTipoCargue getIdTipoCargue() {
        return idTipoCargue;
    }

    public void setIdTipoCargue(TabTipoCargue idTipoCargue) {
        this.idTipoCargue = idTipoCargue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargue != null ? idCargue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabCargue)) {
            return false;
        }
        TabCargue other = (TabCargue) object;
        if ((this.idCargue == null && other.idCargue != null) || (this.idCargue != null && !this.idCargue.equals(other.idCargue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabCargue[ idCargue=" + idCargue + " ]";
    }
    
}
