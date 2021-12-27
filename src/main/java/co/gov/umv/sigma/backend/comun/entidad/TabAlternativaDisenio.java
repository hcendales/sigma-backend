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
@Table(name = "TAB_ALTERNATIVA_DISENIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAlternativaDisenio.findAll", query = "SELECT t FROM TabAlternativaDisenio t"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdAlternativaDisenio", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idAlternativaDisenio = :idAlternativaDisenio"),
    @NamedQuery(name = "TabAlternativaDisenio.findByAlternativa", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.alternativa = :alternativa"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdTipoSuperficieDisenio", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idTipoSuperficieDisenio = :idTipoSuperficieDisenio"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdTipoIntervencionFinalDisenio", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idTipoIntervencionFinalDisenio = :idTipoIntervencionFinalDisenio"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdTipoMetodologiaDisenio", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idTipoMetodologiaDisenio = :idTipoMetodologiaDisenio"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdTipoMaterialGranular", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idTipoMaterialGranular = :idTipoMaterialGranular"),
    @NamedQuery(name = "TabAlternativaDisenio.findByEspesorDisenio", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.espesorDisenio = :espesorDisenio"),
    @NamedQuery(name = "TabAlternativaDisenio.findByCbrInicialPct", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.cbrInicialPct = :cbrInicialPct"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdTipoGeosinteticos", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idTipoGeosinteticos = :idTipoGeosinteticos"),
    @NamedQuery(name = "TabAlternativaDisenio.findByIdTipoSistemaDrenaje", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.idTipoSistemaDrenaje = :idTipoSistemaDrenaje"),
    @NamedQuery(name = "TabAlternativaDisenio.findByObservaciones", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabAlternativaDisenio.findBySeleccionada", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.seleccionada = :seleccionada"),
    @NamedQuery(name = "TabAlternativaDisenio.findByAuditoriaUsuario", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabAlternativaDisenio.findByAuditoriaFecha", query = "SELECT t FROM TabAlternativaDisenio t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabAlternativaDisenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALTERNATIVA_DISENIO")
    private Long idAlternativaDisenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ALTERNATIVA")
    private String alternativa;
    @Column(name = "ID_TIPO_SUPERFICIE_DISENIO")
    private Long idTipoSuperficieDisenio;
    @Column(name = "ID_TIPO_INTERVENCION_FINAL_DISENIO")
    private Long idTipoIntervencionFinalDisenio;
    @Column(name = "ID_TIPO_METODOLOGIA_DISENIO")
    private Long idTipoMetodologiaDisenio;
    @Column(name = "ID_TIPO_MATERIAL_GRANULAR")
    private Long idTipoMaterialGranular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESPESOR_DISENIO")
    private BigDecimal espesorDisenio;
    @Column(name = "CBR_INICIAL_PCT")
    private BigDecimal cbrInicialPct;
    @Column(name = "ID_TIPO_GEOSINTETICOS")
    private Long idTipoGeosinteticos;
    @Column(name = "ID_TIPO_SISTEMA_DRENAJE")
    private Long idTipoSistemaDrenaje;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 2)
    @Column(name = "SELECCIONADA")
    private String seleccionada;
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
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL_EVENTO", referencedColumnName = "ID_MANTENIMIENTO_VIAL_EVENTO")
    @ManyToOne(optional = false)
    private TabMantenimientoVialEvento mantenimientoVialEvento;

    public TabAlternativaDisenio() {
    }

    public TabAlternativaDisenio(Long idAlternativaDisenio) {
        this.idAlternativaDisenio = idAlternativaDisenio;
    }

    public TabAlternativaDisenio(Long idAlternativaDisenio, String alternativa, String auditoriaUsuario, Date auditoriaFecha) {
        this.idAlternativaDisenio = idAlternativaDisenio;
        this.alternativa = alternativa;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdAlternativaDisenio() {
        return idAlternativaDisenio;
    }

    public void setIdAlternativaDisenio(Long idAlternativaDisenio) {
        this.idAlternativaDisenio = idAlternativaDisenio;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public Long getIdTipoSuperficieDisenio() {
        return idTipoSuperficieDisenio;
    }

    public void setIdTipoSuperficieDisenio(Long idTipoSuperficieDisenio) {
        this.idTipoSuperficieDisenio = idTipoSuperficieDisenio;
    }

    public Long getIdTipoIntervencionFinalDisenio() {
        return idTipoIntervencionFinalDisenio;
    }

    public void setIdTipoIntervencionFinalDisenio(Long idTipoIntervencionFinalDisenio) {
        this.idTipoIntervencionFinalDisenio = idTipoIntervencionFinalDisenio;
    }

    public Long getIdTipoMetodologiaDisenio() {
        return idTipoMetodologiaDisenio;
    }

    public void setIdTipoMetodologiaDisenio(Long idTipoMetodologiaDisenio) {
        this.idTipoMetodologiaDisenio = idTipoMetodologiaDisenio;
    }

    public Long getIdTipoMaterialGranular() {
        return idTipoMaterialGranular;
    }

    public void setIdTipoMaterialGranular(Long idTipoMaterialGranular) {
        this.idTipoMaterialGranular = idTipoMaterialGranular;
    }

    public BigDecimal getEspesorDisenio() {
        return espesorDisenio;
    }

    public void setEspesorDisenio(BigDecimal espesorDisenio) {
        this.espesorDisenio = espesorDisenio;
    }

    public BigDecimal getCbrInicialPct() {
        return cbrInicialPct;
    }

    public void setCbrInicialPct(BigDecimal cbrInicialPct) {
        this.cbrInicialPct = cbrInicialPct;
    }

    public Long getIdTipoGeosinteticos() {
        return idTipoGeosinteticos;
    }

    public void setIdTipoGeosinteticos(Long idTipoGeosinteticos) {
        this.idTipoGeosinteticos = idTipoGeosinteticos;
    }

    public Long getIdTipoSistemaDrenaje() {
        return idTipoSistemaDrenaje;
    }

    public void setIdTipoSistemaDrenaje(Long idTipoSistemaDrenaje) {
        this.idTipoSistemaDrenaje = idTipoSistemaDrenaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(String seleccionada) {
        this.seleccionada = seleccionada;
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


    public TabMantenimientoVialEvento getMantenimientoVialEvento() {
		return mantenimientoVialEvento;
	}

	public void setMantenimientoVialEvento(TabMantenimientoVialEvento mantenimientoVialEvento) {
		this.mantenimientoVialEvento = mantenimientoVialEvento;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlternativaDisenio != null ? idAlternativaDisenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAlternativaDisenio)) {
            return false;
        }
        TabAlternativaDisenio other = (TabAlternativaDisenio) object;
        if ((this.idAlternativaDisenio == null && other.idAlternativaDisenio != null) || (this.idAlternativaDisenio != null && !this.idAlternativaDisenio.equals(other.idAlternativaDisenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAlternativaDisenio[ idAlternativaDisenio=" + idAlternativaDisenio + " ]";
    }
    
}
