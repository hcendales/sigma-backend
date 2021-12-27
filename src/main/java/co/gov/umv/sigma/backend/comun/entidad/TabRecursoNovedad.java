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
@Table(name = "TAB_RECURSO_NOVEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRecursoNovedad.findAll", query = "SELECT t FROM TabRecursoNovedad t"),
    @NamedQuery(name = "TabRecursoNovedad.findByIdRecursoNovedad", query = "SELECT t FROM TabRecursoNovedad t WHERE t.idRecursoNovedad = :idRecursoNovedad"),
    @NamedQuery(name = "TabRecursoNovedad.findByIdTipoNovedad", query = "SELECT t FROM TabRecursoNovedad t WHERE t.idTipoNovedad = :idTipoNovedad"),
    @NamedQuery(name = "TabRecursoNovedad.findByHoraDesde", query = "SELECT t FROM TabRecursoNovedad t WHERE t.horaDesde = :horaDesde"),
    @NamedQuery(name = "TabRecursoNovedad.findByHoraHasta", query = "SELECT t FROM TabRecursoNovedad t WHERE t.horaHasta = :horaHasta"),
    @NamedQuery(name = "TabRecursoNovedad.findByObservaciones", query = "SELECT t FROM TabRecursoNovedad t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabRecursoNovedad.findByAuditoriaUsuario", query = "SELECT t FROM TabRecursoNovedad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRecursoNovedad.findByAuditoriaFecha", query = "SELECT t FROM TabRecursoNovedad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRecursoNovedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RECURSO_NOVEDAD")
    private Long idRecursoNovedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_NOVEDAD")
    private long idTipoNovedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaHasta;
    @Size(max = 300)
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
    @JoinColumn(name = "ID_RECURSO", referencedColumnName = "ID_RECURSO")
    @ManyToOne(optional = false)
    private TabRecurso recurso;

    public TabRecursoNovedad() {
    }

    public TabRecursoNovedad(Long idRecursoNovedad) {
        this.idRecursoNovedad = idRecursoNovedad;
    }

    public TabRecursoNovedad(Long idRecursoNovedad, long idTipoNovedad, Date horaDesde, Date horaHasta, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRecursoNovedad = idRecursoNovedad;
        this.idTipoNovedad = idTipoNovedad;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRecursoNovedad() {
        return idRecursoNovedad;
    }

    public void setIdRecursoNovedad(Long idRecursoNovedad) {
        this.idRecursoNovedad = idRecursoNovedad;
    }

    public long getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(long idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public Date getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(Date horaDesde) {
        this.horaDesde = horaDesde;
    }

    public Date getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(Date horaHasta) {
        this.horaHasta = horaHasta;
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


    public TabRecurso getRecurso() {
		return recurso;
	}

	public void setRecurso(TabRecurso recurso) {
		this.recurso = recurso;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecursoNovedad != null ? idRecursoNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRecursoNovedad)) {
            return false;
        }
        TabRecursoNovedad other = (TabRecursoNovedad) object;
        if ((this.idRecursoNovedad == null && other.idRecursoNovedad != null) || (this.idRecursoNovedad != null && !this.idRecursoNovedad.equals(other.idRecursoNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRecursoNovedad[ idRecursoNovedad=" + idRecursoNovedad + " ]";
    }
    
}
