/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TAB_UNIDAD_MUESTREO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabUnidadMuestreo.findAll", query = "SELECT t FROM TabUnidadMuestreo t"),
    @NamedQuery(name = "TabUnidadMuestreo.findByIdUnidadMuestreo", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.idUnidadMuestreo = :idUnidadMuestreo"),
    @NamedQuery(name = "TabUnidadMuestreo.findByAbscisaInicial", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.abscisaInicial = :abscisaInicial"),
    @NamedQuery(name = "TabUnidadMuestreo.findByAbscisaFinal", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.abscisaFinal = :abscisaFinal"),
    @NamedQuery(name = "TabUnidadMuestreo.findByArea", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.area = :area"),
    @NamedQuery(name = "TabUnidadMuestreo.findByPci", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.pci = :pci"),
    @NamedQuery(name = "TabUnidadMuestreo.findByAncho", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.ancho = :ancho"),
    @NamedQuery(name = "TabUnidadMuestreo.findByAuditoriaUsuario", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabUnidadMuestreo.findByAuditoriaFecha", query = "SELECT t FROM TabUnidadMuestreo t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabUnidadMuestreo implements Serializable {

    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL_EVENTO", referencedColumnName = "ID_MANTENIMIENTO_VIAL_EVENTO")
    @ManyToOne(optional = false)
    private TabMantenimientoVialEvento idMantenimientoVialEvento;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD_MUESTREO")
    private Long idUnidadMuestreo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABSCISA_INICIAL")
    private BigDecimal abscisaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABSCISA_FINAL")
    private BigDecimal abscisaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREA")
    private BigDecimal area;
    @Column(name = "PCI")
    private Long pci;
    @Column(name = "ANCHO")
    private BigDecimal ancho;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMuestreo")
    private List<TabFalla> tabFallaList;

    public TabUnidadMuestreo() {
    }

    public TabUnidadMuestreo(Long idUnidadMuestreo) {
        this.idUnidadMuestreo = idUnidadMuestreo;
    }

    public TabUnidadMuestreo(Long idUnidadMuestreo, BigDecimal abscisaInicial, BigDecimal abscisaFinal, BigDecimal area, String auditoriaUsuario, Date auditoriaFecha) {
        this.idUnidadMuestreo = idUnidadMuestreo;
        this.abscisaInicial = abscisaInicial;
        this.abscisaFinal = abscisaFinal;
        this.area = area;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdUnidadMuestreo() {
        return idUnidadMuestreo;
    }

    public void setIdUnidadMuestreo(Long idUnidadMuestreo) {
        this.idUnidadMuestreo = idUnidadMuestreo;
    }

    public BigDecimal getAbscisaInicial() {
        return abscisaInicial;
    }

    public void setAbscisaInicial(BigDecimal abscisaInicial) {
        this.abscisaInicial = abscisaInicial;
    }

    public BigDecimal getAbscisaFinal() {
        return abscisaFinal;
    }

    public void setAbscisaFinal(BigDecimal abscisaFinal) {
        this.abscisaFinal = abscisaFinal;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Long getPci() {
        return pci;
    }

    public void setPci(Long pci) {
        this.pci = pci;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
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

    @XmlTransient
    public List<TabFalla> getTabFallaList() {
        return tabFallaList;
    }

    public void setTabFallaList(List<TabFalla> tabFallaList) {
        this.tabFallaList = tabFallaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadMuestreo != null ? idUnidadMuestreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabUnidadMuestreo)) {
            return false;
        }
        TabUnidadMuestreo other = (TabUnidadMuestreo) object;
        if ((this.idUnidadMuestreo == null && other.idUnidadMuestreo != null) || (this.idUnidadMuestreo != null && !this.idUnidadMuestreo.equals(other.idUnidadMuestreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo[ idUnidadMuestreo=" + idUnidadMuestreo + " ]";
    }

    public TabMantenimientoVialEvento getIdMantenimientoVialEvento() {
        return idMantenimientoVialEvento;
    }

    public void setIdMantenimientoVialEvento(TabMantenimientoVialEvento idMantenimientoVialEvento) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
    }
    
}
