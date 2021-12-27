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
@Table(name = "TAB_AFORO_CALZADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAforoCalzada.findAll", query = "SELECT t FROM TabAforoCalzada t"),
    @NamedQuery(name = "TabAforoCalzada.findByIdAforoCalzada", query = "SELECT t FROM TabAforoCalzada t WHERE t.idAforoCalzada = :idAforoCalzada"),
    @NamedQuery(name = "TabAforoCalzada.findByPkIdCalzada", query = "SELECT t FROM TabAforoCalzada t WHERE t.pkIdCalzada = :pkIdCalzada"),
    @NamedQuery(name = "TabAforoCalzada.findByAledanio", query = "SELECT t FROM TabAforoCalzada t WHERE t.aledanio = :aledanio"),
    @NamedQuery(name = "TabAforoCalzada.findByCiv", query = "SELECT t FROM TabAforoCalzada t WHERE t.civ = :civ"),
    @NamedQuery(name = "TabAforoCalzada.findByEjeVial", query = "SELECT t FROM TabAforoCalzada t WHERE t.ejeVial = :ejeVial"),
    @NamedQuery(name = "TabAforoCalzada.findByDesde", query = "SELECT t FROM TabAforoCalzada t WHERE t.desde = :desde"),
    @NamedQuery(name = "TabAforoCalzada.findByHasta", query = "SELECT t FROM TabAforoCalzada t WHERE t.hasta = :hasta"),
    @NamedQuery(name = "TabAforoCalzada.findByIdLocalidad", query = "SELECT t FROM TabAforoCalzada t WHERE t.idLocalidad = :idLocalidad"),
    @NamedQuery(name = "TabAforoCalzada.findByDescripcionLocalidad", query = "SELECT t FROM TabAforoCalzada t WHERE t.descripcionLocalidad = :descripcionLocalidad"),
    @NamedQuery(name = "TabAforoCalzada.findByIdTipoSuperficie", query = "SELECT t FROM TabAforoCalzada t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabAforoCalzada.findByDescripcionTipoSuperficie", query = "SELECT t FROM TabAforoCalzada t WHERE t.descripcionTipoSuperficie = :descripcionTipoSuperficie"),
    @NamedQuery(name = "TabAforoCalzada.findByAuditoriaUsuario", query = "SELECT t FROM TabAforoCalzada t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAforoCalzada.findByAuditoriaFecha", query = "SELECT t FROM TabAforoCalzada t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabAforoCalzada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFORO_CALZADA")
    private Long idAforoCalzada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ID_CALZADA")
    private long pkIdCalzada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String aledanio;
    @Size(max = 30)
    private String civ;
    @Size(max = 20)
    @Column(name = "EJE_VIAL")
    private String ejeVial;
    @Size(max = 30)
    private String desde;
    @Size(max = 30)
    private String hasta;
    @Column(name = "ID_LOCALIDAD")
    private Long idLocalidad;
    @Size(max = 100)
    @Column(name = "DESCRIPCION_LOCALIDAD")
    private String descripcionLocalidad;
    @Column(name = "ID_TIPO_SUPERFICIE")
    private Long idTipoSuperficie;
    @Size(max = 100)
    @Column(name = "DESCRIPCION_TIPO_SUPERFICIE")
    private String descripcionTipoSuperficie;
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
    @JoinColumn(name = "ID_AFORO", referencedColumnName = "ID_AFORO")
    @ManyToOne(optional = false)
    private TabAforo2 idAforo;

    public TabAforoCalzada() {
    }

    public TabAforoCalzada(Long idAforoCalzada) {
        this.idAforoCalzada = idAforoCalzada;
    }

    public TabAforoCalzada(Long idAforoCalzada, long pkIdCalzada, String aledanio, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAforoCalzada = idAforoCalzada;
        this.pkIdCalzada = pkIdCalzada;
        this.aledanio = aledanio;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAforoCalzada() {
        return idAforoCalzada;
    }

    public void setIdAforoCalzada(Long idAforoCalzada) {
        this.idAforoCalzada = idAforoCalzada;
    }

    public long getPkIdCalzada() {
        return pkIdCalzada;
    }

    public void setPkIdCalzada(long pkIdCalzada) {
        this.pkIdCalzada = pkIdCalzada;
    }

    public String getAledanio() {
        return aledanio;
    }

    public void setAledanio(String aledanio) {
        this.aledanio = aledanio;
    }

    public String getCiv() {
        return civ;
    }

    public void setCiv(String civ) {
        this.civ = civ;
    }

    public String getEjeVial() {
        return ejeVial;
    }

    public void setEjeVial(String ejeVial) {
        this.ejeVial = ejeVial;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public Long getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Long idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getDescripcionLocalidad() {
        return descripcionLocalidad;
    }

    public void setDescripcionLocalidad(String descripcionLocalidad) {
        this.descripcionLocalidad = descripcionLocalidad;
    }

    public Long getIdTipoSuperficie() {
        return idTipoSuperficie;
    }

    public void setIdTipoSuperficie(Long idTipoSuperficie) {
        this.idTipoSuperficie = idTipoSuperficie;
    }

    public String getDescripcionTipoSuperficie() {
        return descripcionTipoSuperficie;
    }

    public void setDescripcionTipoSuperficie(String descripcionTipoSuperficie) {
        this.descripcionTipoSuperficie = descripcionTipoSuperficie;
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

    public TabAforo2 getIdAforo() {
        return idAforo;
    }

    public void setIdAforo(TabAforo2 idAforo) {
        this.idAforo = idAforo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAforoCalzada != null ? idAforoCalzada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAforoCalzada)) {
            return false;
        }
        TabAforoCalzada other = (TabAforoCalzada) object;
        if ((this.idAforoCalzada == null && other.idAforoCalzada != null) || (this.idAforoCalzada != null && !this.idAforoCalzada.equals(other.idAforoCalzada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAforoCalzada[ idAforoCalzada=" + idAforoCalzada + " ]";
    }
    
}
