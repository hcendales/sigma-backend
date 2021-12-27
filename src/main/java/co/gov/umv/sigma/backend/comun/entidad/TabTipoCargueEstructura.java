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
@Table(name = "TAB_TIPO_CARGUE_ESTRUCTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabTipoCargueEstructura.findAll", query = "SELECT t FROM TabTipoCargueEstructura t"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByIdTipoCargueEstructura", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.idTipoCargueEstructura = :idTipoCargueEstructura"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByCampo", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.campo = :campo"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByDescripcion", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByRequerido", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.requerido = :requerido"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByTipoDato", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.tipoDato = :tipoDato"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByLongitudMaxima", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.longitudMaxima = :longitudMaxima"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByNumeroMinimo", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.numeroMinimo = :numeroMinimo"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByNumeroMaximo", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.numeroMaximo = :numeroMaximo"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByFechaMinima", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.fechaMinima = :fechaMinima"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByFechaMaxima", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.fechaMaxima = :fechaMaxima"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByIdLista", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.idLista = :idLista"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByAuditoriaUsuario", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabTipoCargueEstructura.findByAuditoriaFecha", query = "SELECT t FROM TabTipoCargueEstructura t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabTipoCargueEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CARGUE_ESTRUCTURA")
    private Long idTipoCargueEstructura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CAMPO")
    private String campo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REQUERIDO")
    private String requerido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPO_DATO")
    private String tipoDato;
    @Column(name = "LONGITUD_MAXIMA")
    private Short longitudMaxima;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NUMERO_MINIMO")
    private BigDecimal numeroMinimo;
    @Column(name = "NUMERO_MAXIMO")
    private BigDecimal numeroMaximo;
    @Column(name = "FECHA_MINIMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMinima;
    @Column(name = "FECHA_MAXIMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMaxima;
    @Column(name = "ID_LISTA")
    private Long idLista;
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
    @JoinColumn(name = "ID_TIPO_CARGUE", referencedColumnName = "ID_TIPO_CARGUE")
    @ManyToOne(optional = false)
    private TabTipoCargue idTipoCargue;

    public TabTipoCargueEstructura() {
    }

    public TabTipoCargueEstructura(Long idTipoCargueEstructura) {
        this.idTipoCargueEstructura = idTipoCargueEstructura;
    }

    public TabTipoCargueEstructura(Long idTipoCargueEstructura, String campo, String descripcion, String requerido, String tipoDato, String auditoriaUsuario, Date auditoriaFecha) {
        this.idTipoCargueEstructura = idTipoCargueEstructura;
        this.campo = campo;
        this.descripcion = descripcion;
        this.requerido = requerido;
        this.tipoDato = tipoDato;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdTipoCargueEstructura() {
        return idTipoCargueEstructura;
    }

    public void setIdTipoCargueEstructura(Long idTipoCargueEstructura) {
        this.idTipoCargueEstructura = idTipoCargueEstructura;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Short getLongitudMaxima() {
        return longitudMaxima;
    }

    public void setLongitudMaxima(Short longitudMaxima) {
        this.longitudMaxima = longitudMaxima;
    }

    public BigDecimal getNumeroMinimo() {
        return numeroMinimo;
    }

    public void setNumeroMinimo(BigDecimal numeroMinimo) {
        this.numeroMinimo = numeroMinimo;
    }

    public BigDecimal getNumeroMaximo() {
        return numeroMaximo;
    }

    public void setNumeroMaximo(BigDecimal numeroMaximo) {
        this.numeroMaximo = numeroMaximo;
    }

    public Date getFechaMinima() {
        return fechaMinima;
    }

    public void setFechaMinima(Date fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(Date fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
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

    public TabTipoCargue getIdTipoCargue() {
        return idTipoCargue;
    }

    public void setIdTipoCargue(TabTipoCargue idTipoCargue) {
        this.idTipoCargue = idTipoCargue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCargueEstructura != null ? idTipoCargueEstructura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabTipoCargueEstructura)) {
            return false;
        }
        TabTipoCargueEstructura other = (TabTipoCargueEstructura) object;
        if ((this.idTipoCargueEstructura == null && other.idTipoCargueEstructura != null) || (this.idTipoCargueEstructura != null && !this.idTipoCargueEstructura.equals(other.idTipoCargueEstructura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabTipoCargueEstructura[ idTipoCargueEstructura=" + idTipoCargueEstructura + " ]";
    }
    
}
