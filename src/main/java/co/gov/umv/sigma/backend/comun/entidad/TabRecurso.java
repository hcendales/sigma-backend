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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_RECURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabRecurso.findAll", query = "SELECT t FROM TabRecurso t"),
    @NamedQuery(name = "TabRecurso.findByIdRecurso", query = "SELECT t FROM TabRecurso t WHERE t.idRecurso = :idRecurso"),
    @NamedQuery(name = "TabRecurso.findByIdTipoRecurso", query = "SELECT t FROM TabRecurso t WHERE t.idTipoRecurso = :idTipoRecurso"),
    @NamedQuery(name = "TabRecurso.findByIdentificadorRecurso", query = "SELECT t FROM TabRecurso t WHERE t.identificadorRecurso = :identificadorRecurso"),
    @NamedQuery(name = "TabRecurso.findByIntervaloProgramacion", query = "SELECT t FROM TabRecurso t WHERE t.intervaloProgramacion = :intervaloProgramacion"),
    @NamedQuery(name = "TabRecurso.findByAuditoriaUsuario", query = "SELECT t FROM TabRecurso t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabRecurso.findByAuditoriaFecha", query = "SELECT t FROM TabRecurso t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabRecurso implements Serializable {

    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 5)
    @Column(name = "HORA_INICIO_PROGRAMACION")
    private String horaInicioProgramacion;
    @Size(max = 5)
    @Column(name = "HORA_FIN_PROGRAMACION")
    private String horaFinProgramacion;
    @Size(max = 600)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private List<TabRecursoNovedad> tabRecursoNovedadList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RECURSO")
    private Long idRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_RECURSO")
    private long idTipoRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFICADOR_RECURSO")
    private long identificadorRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERVALO_PROGRAMACION")
    private long intervaloProgramacion;
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
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    @ManyToOne
    private TabEquipo equipo;
    @JoinColumn(name = "ID_LUGAR", referencedColumnName = "ID_LUGAR")
    @ManyToOne
    private TabLugar lugar;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private TabPersona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private List<TabRecursoDisponibilidad> tabRecursoDisponibilidadList;

    public TabRecurso() {
    }

    public TabRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public TabRecurso(Long idRecurso, long idTipoRecurso, long identificadorRecurso, long intervaloProgramacion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idRecurso = idRecurso;
        this.idTipoRecurso = idTipoRecurso;
        this.identificadorRecurso = identificadorRecurso;
        this.intervaloProgramacion = intervaloProgramacion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public long getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(long idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public long getIdentificadorRecurso() {
        return identificadorRecurso;
    }

    public void setIdentificadorRecurso(long identificadorRecurso) {
        this.identificadorRecurso = identificadorRecurso;
    }

    public long getIntervaloProgramacion() {
        return intervaloProgramacion;
    }

    public void setIntervaloProgramacion(long intervaloProgramacion) {
        this.intervaloProgramacion = intervaloProgramacion;
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

    
    
    
    public TabEquipo getEquipo() {
		return equipo;
	}

	public void setEquipo(TabEquipo equipo) {
		this.equipo = equipo;
	}

	public TabLugar getLugar() {
		return lugar;
	}

	public void setLugar(TabLugar lugar) {
		this.lugar = lugar;
	}

	public TabPersona getPersona() {
		return persona;
	}

	public void setPersona(TabPersona persona) {
		this.persona = persona;
	}

	@XmlTransient
    public List<TabRecursoDisponibilidad> getTabRecursoDisponibilidadList() {
        return tabRecursoDisponibilidadList;
    }

    public void setTabRecursoDisponibilidadList(List<TabRecursoDisponibilidad> tabRecursoDisponibilidadList) {
        this.tabRecursoDisponibilidadList = tabRecursoDisponibilidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabRecurso)) {
            return false;
        }
        TabRecurso other = (TabRecurso) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabRecurso[ idRecurso=" + idRecurso + " ]";
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHoraInicioProgramacion() {
        return horaInicioProgramacion;
    }

    public void setHoraInicioProgramacion(String horaInicioProgramacion) {
        this.horaInicioProgramacion = horaInicioProgramacion;
    }

    public String getHoraFinProgramacion() {
        return horaFinProgramacion;
    }

    public void setHoraFinProgramacion(String horaFinProgramacion) {
        this.horaFinProgramacion = horaFinProgramacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabRecursoNovedad> getTabRecursoNovedadList() {
        return tabRecursoNovedadList;
    }

    public void setTabRecursoNovedadList(List<TabRecursoNovedad> tabRecursoNovedadList) {
        this.tabRecursoNovedadList = tabRecursoNovedadList;
    }
    
}
