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
@Table(name = "TAB_PERSONA_NOVEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabPersonaNovedad.findAll", query = "SELECT t FROM TabPersonaNovedad t"),
    @NamedQuery(name = "TabPersonaNovedad.findByIdPersonaNovedad", query = "SELECT t FROM TabPersonaNovedad t WHERE t.idPersonaNovedad = :idPersonaNovedad"),
    @NamedQuery(name = "TabPersonaNovedad.findByIdTipoNovedad", query = "SELECT t FROM TabPersonaNovedad t WHERE t.idTipoNovedad = :idTipoNovedad"),
    @NamedQuery(name = "TabPersonaNovedad.findByHoraDesde", query = "SELECT t FROM TabPersonaNovedad t WHERE t.horaDesde = :horaDesde"),
    @NamedQuery(name = "TabPersonaNovedad.findByHoraHasta", query = "SELECT t FROM TabPersonaNovedad t WHERE t.horaHasta = :horaHasta"),
    @NamedQuery(name = "TabPersonaNovedad.findByObservaciones", query = "SELECT t FROM TabPersonaNovedad t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabPersonaNovedad.findByAuditoriaUsuario", query = "SELECT t FROM TabPersonaNovedad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabPersonaNovedad.findByAuditoriaFecha", query = "SELECT t FROM TabPersonaNovedad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabPersonaNovedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA_NOVEDAD")
    private Long idPersonaNovedad;
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
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private TabPersona idPersona;

    public TabPersonaNovedad() {
    }

    public TabPersonaNovedad(Long idPersonaNovedad) {
        this.idPersonaNovedad = idPersonaNovedad;
    }

    public TabPersonaNovedad(Long idPersonaNovedad, long idTipoNovedad, Date horaDesde, Date horaHasta, String auditoriaUsuario, Date auditoriaFecha) {
        this.idPersonaNovedad = idPersonaNovedad;
        this.idTipoNovedad = idTipoNovedad;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdPersonaNovedad() {
        return idPersonaNovedad;
    }

    public void setIdPersonaNovedad(Long idPersonaNovedad) {
        this.idPersonaNovedad = idPersonaNovedad;
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

    public TabPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(TabPersona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonaNovedad != null ? idPersonaNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabPersonaNovedad)) {
            return false;
        }
        TabPersonaNovedad other = (TabPersonaNovedad) object;
        if ((this.idPersonaNovedad == null && other.idPersonaNovedad != null) || (this.idPersonaNovedad != null && !this.idPersonaNovedad.equals(other.idPersonaNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabPersonaNovedad[ idPersonaNovedad=" + idPersonaNovedad + " ]";
    }
    
}
