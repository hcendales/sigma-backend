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
@Table(name = "TAB_DISENIO_CAPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabDisenioCapa.findAll", query = "SELECT t FROM TabDisenioCapa t"),
    @NamedQuery(name = "TabDisenioCapa.findByIdDisenioCapa", query = "SELECT t FROM TabDisenioCapa t WHERE t.idDisenioCapa = :idDisenioCapa"),
    @NamedQuery(name = "TabDisenioCapa.findByIdTipoCapa", query = "SELECT t FROM TabDisenioCapa t WHERE t.idTipoCapa = :idTipoCapa"),
    @NamedQuery(name = "TabDisenioCapa.findByEspesor", query = "SELECT t FROM TabDisenioCapa t WHERE t.espesor = :espesor"),
    @NamedQuery(name = "TabDisenioCapa.findByAuditoriaUsuario", query = "SELECT t FROM TabDisenioCapa t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabDisenioCapa.findByAuditoriaFecha", query = "SELECT t FROM TabDisenioCapa t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabDisenioCapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DISENIO_CAPA")
    private Long idDisenioCapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CAPA")
    private long idTipoCapa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPESOR")
    private BigDecimal espesor;
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
    @JoinColumn(name = "ID_ALTERNATIVA_DISENIO", referencedColumnName = "ID_ALTERNATIVA_DISENIO")
    @ManyToOne(optional = false)
    private TabAlternativaDisenio alternativaDisenio;

    public TabDisenioCapa() {
    }

    public TabDisenioCapa(Long idDisenioCapa) {
        this.idDisenioCapa = idDisenioCapa;
    }

    public TabDisenioCapa(Long idDisenioCapa, long idTipoCapa, BigDecimal espesor, String auditoriaUsuario, Date auditoriaFecha) {
        this.idDisenioCapa = idDisenioCapa;
        this.idTipoCapa = idTipoCapa;
        this.espesor = espesor;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdDisenioCapa() {
        return idDisenioCapa;
    }

    public void setIdDisenioCapa(Long idDisenioCapa) {
        this.idDisenioCapa = idDisenioCapa;
    }

    public long getIdTipoCapa() {
        return idTipoCapa;
    }

    public void setIdTipoCapa(long idTipoCapa) {
        this.idTipoCapa = idTipoCapa;
    }

    public BigDecimal getEspesor() {
        return espesor;
    }

    public void setEspesor(BigDecimal espesor) {
        this.espesor = espesor;
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

 
    public TabAlternativaDisenio getAlternativaDisenio() {
		return alternativaDisenio;
	}

	public void setAlternativaDisenio(TabAlternativaDisenio alternativaDisenio) {
		this.alternativaDisenio = alternativaDisenio;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisenioCapa != null ? idDisenioCapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabDisenioCapa)) {
            return false;
        }
        TabDisenioCapa other = (TabDisenioCapa) object;
        if ((this.idDisenioCapa == null && other.idDisenioCapa != null) || (this.idDisenioCapa != null && !this.idDisenioCapa.equals(other.idDisenioCapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabDisenioCapa[ idDisenioCapa=" + idDisenioCapa + " ]";
    }
    
}
