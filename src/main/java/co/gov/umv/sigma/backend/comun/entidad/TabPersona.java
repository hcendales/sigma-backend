/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TAB_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabPersona.findAll", query = "SELECT t FROM TabPersona t"),
    @NamedQuery(name = "TabPersona.findByIdPersona", query = "SELECT t FROM TabPersona t WHERE t.idPersona = :idPersona"),
    @NamedQuery(name = "TabPersona.findByIdTipoRegimen", query = "SELECT t FROM TabPersona t WHERE t.idTipoRegimen = :idTipoRegimen"),
    @NamedQuery(name = "TabPersona.findByIdTipoCategoriaPersona", query = "SELECT t FROM TabPersona t WHERE t.idTipoCategoriaPersona = :idTipoCategoriaPersona"),
    @NamedQuery(name = "TabPersona.findByIdentificacion", query = "SELECT t FROM TabPersona t WHERE t.identificacion = :identificacion"),
    @NamedQuery(name = "TabPersona.findByUsuario", query = "SELECT t FROM TabPersona t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TabPersona.findByNombre", query = "SELECT t FROM TabPersona t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabPersona.findByTelefono", query = "SELECT t FROM TabPersona t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TabPersona.findByEmail", query = "SELECT t FROM TabPersona t WHERE t.email = :email"),
    @NamedQuery(name = "TabPersona.findByIdTipoArea", query = "SELECT t FROM TabPersona t WHERE t.idTipoArea = :idTipoArea"),
    @NamedQuery(name = "TabPersona.findByIdTipoCargo", query = "SELECT t FROM TabPersona t WHERE t.idTipoCargo = :idTipoCargo"),
    @NamedQuery(name = "TabPersona.findByIdTipoRol", query = "SELECT t FROM TabPersona t WHERE t.idTipoRol = :idTipoRol"),
    @NamedQuery(name = "TabPersona.findByIdTipoEstadoPersona", query = "SELECT t FROM TabPersona t WHERE t.idTipoEstadoPersona = :idTipoEstadoPersona"),
    @NamedQuery(name = "TabPersona.findByHoraInicioProgramacion", query = "SELECT t FROM TabPersona t WHERE t.horaInicioProgramacion = :horaInicioProgramacion"),
    @NamedQuery(name = "TabPersona.findByHoraFinProgramacion", query = "SELECT t FROM TabPersona t WHERE t.horaFinProgramacion = :horaFinProgramacion"),
    @NamedQuery(name = "TabPersona.findByAuditoriaUsuario", query = "SELECT t FROM TabPersona t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabPersona.findByAuditoriaFecha", query = "SELECT t FROM TabPersona t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabPersona implements Serializable {
   
    @OneToMany(mappedBy = "idResidenteSocial")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList;
    @OneToMany(mappedBy = "idResidenteSst")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList1;
    @OneToMany(mappedBy = "idResidenteObra")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList2;
    @OneToMany(mappedBy = "idIngenieroDisenio")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList3;
    @OneToMany(mappedBy = "idIngenieroApoyo")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList4;
    @OneToMany(mappedBy = "idDirectorObra")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList5;
    @OneToMany(mappedBy = "idResponsableVisita")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList6;
    @OneToMany(mappedBy = "idResidenteAmbiental")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList7;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA")
    private Long idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_REGIMEN")
    private long idTipoRegimen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CATEGORIA_PERSONA")
    private long idTipoCategoriaPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuarioLogin;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ID_TIPO_AREA")
    private Long idTipoArea;
    @Column(name = "ID_TIPO_CARGO")
    private Long idTipoCargo;
    @Column(name = "ID_TIPO_ROL")
    private Long idTipoRol;
    @Column(name = "ID_TIPO_ESTADO_PERSONA")
    private Long idTipoEstadoPersona;
    @Size(max = 5)
    @Column(name = "HORA_INICIO_PROGRAMACION")
    private String horaInicioProgramacion;
    @Size(max = 5)
    @Column(name = "HORA_FIN_PROGRAMACION")
    private String horaFinProgramacion;
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
    
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    
    @OneToMany(mappedBy = "idPersonaResponsableVisita")
    private List<TabMantenimientoVial> tabMantenimientoVialList;
    @OneToMany(mappedBy = "idPersonaResponsableVerif")
    private List<TabMantenimientoVial> tabMantenimientoVialList1;
    @OneToMany(mappedBy = "idPersonaDirectorObra")
    private List<TabMantenimientoVial> tabMantenimientoVialList2;
    @OneToMany(mappedBy = "idPersonaResidenteObra")
    private List<TabMantenimientoVial> tabMantenimientoVialList3;
    @OneToMany(mappedBy = "idPersonaResidenteAmbiental")
    private List<TabMantenimientoVial> tabMantenimientoVialList4;
    @OneToMany(mappedBy = "idPersonaResidenteSst")
    private List<TabMantenimientoVial> tabMantenimientoVialList5;
    @OneToMany(mappedBy = "idPersonaResidenteSocial")
    private List<TabMantenimientoVial> tabMantenimientoVialList6;
    @OneToMany(mappedBy = "idPersona")
    private List<TabRecurso> tabRecursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<TabOtraActividad> tabOtraActividadList;
    @OneToMany(mappedBy = "idPersona")
    private List<TabDocumentoEstado> tabDocumentoEstadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<TabPersonaNovedad> tabPersonaNovedadList;
    @OneToMany(mappedBy = "idPersona")
    private List<TabMantenimientoVialGestion> tabMantenimientoVialGestionList;

    public TabPersona() {
    }

    public TabPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public TabPersona(Long idPersona, long idTipoRegimen, long idTipoCategoriaPersona, String identificacion, String nombre, String auditoriaUsuario, Date auditoriaFecha) {
        this.idPersona = idPersona;
        this.idTipoRegimen = idTipoRegimen;
        this.idTipoCategoriaPersona = idTipoCategoriaPersona;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public long getIdTipoRegimen() {
        return idTipoRegimen;
    }

    public void setIdTipoRegimen(long idTipoRegimen) {
        this.idTipoRegimen = idTipoRegimen;
    }

    public long getIdTipoCategoriaPersona() {
        return idTipoCategoriaPersona;
    }

    public void setIdTipoCategoriaPersona(long idTipoCategoriaPersona) {
        this.idTipoCategoriaPersona = idTipoCategoriaPersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(Long idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public Long getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(Long idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public Long getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Long idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public Long getIdTipoEstadoPersona() {
        return idTipoEstadoPersona;
    }

    public void setIdTipoEstadoPersona(Long idTipoEstadoPersona) {
        this.idTipoEstadoPersona = idTipoEstadoPersona;
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
    public List<TabMantenimientoVial> getTabMantenimientoVialList() {
        return tabMantenimientoVialList;
    }

    public void setTabMantenimientoVialList(List<TabMantenimientoVial> tabMantenimientoVialList) {
        this.tabMantenimientoVialList = tabMantenimientoVialList;
    }

    @XmlTransient
    public List<TabMantenimientoVial> getTabMantenimientoVialList1() {
        return tabMantenimientoVialList1;
    }

    public void setTabMantenimientoVialList1(List<TabMantenimientoVial> tabMantenimientoVialList1) {
        this.tabMantenimientoVialList1 = tabMantenimientoVialList1;
    }

    @XmlTransient
    public List<TabMantenimientoVial> getTabMantenimientoVialList2() {
        return tabMantenimientoVialList2;
    }

    public void setTabMantenimientoVialList2(List<TabMantenimientoVial> tabMantenimientoVialList2) {
        this.tabMantenimientoVialList2 = tabMantenimientoVialList2;
    }

    @XmlTransient
    public List<TabMantenimientoVial> getTabMantenimientoVialList3() {
        return tabMantenimientoVialList3;
    }

    public void setTabMantenimientoVialList3(List<TabMantenimientoVial> tabMantenimientoVialList3) {
        this.tabMantenimientoVialList3 = tabMantenimientoVialList3;
    }

    @XmlTransient
    public List<TabMantenimientoVial> getTabMantenimientoVialList4() {
        return tabMantenimientoVialList4;
    }

    public void setTabMantenimientoVialList4(List<TabMantenimientoVial> tabMantenimientoVialList4) {
        this.tabMantenimientoVialList4 = tabMantenimientoVialList4;
    }

    @XmlTransient
    public List<TabMantenimientoVial> getTabMantenimientoVialList5() {
        return tabMantenimientoVialList5;
    }

    public void setTabMantenimientoVialList5(List<TabMantenimientoVial> tabMantenimientoVialList5) {
        this.tabMantenimientoVialList5 = tabMantenimientoVialList5;
    }

    @XmlTransient
    public List<TabMantenimientoVial> getTabMantenimientoVialList6() {
        return tabMantenimientoVialList6;
    }

    public void setTabMantenimientoVialList6(List<TabMantenimientoVial> tabMantenimientoVialList6) {
        this.tabMantenimientoVialList6 = tabMantenimientoVialList6;
    }

    @XmlTransient
    public List<TabRecurso> getTabRecursoList() {
        return tabRecursoList;
    }

    public void setTabRecursoList(List<TabRecurso> tabRecursoList) {
        this.tabRecursoList = tabRecursoList;
    }

    @XmlTransient
    public List<TabOtraActividad> getTabOtraActividadList() {
        return tabOtraActividadList;
    }

    public void setTabOtraActividadList(List<TabOtraActividad> tabOtraActividadList) {
        this.tabOtraActividadList = tabOtraActividadList;
    }

    @XmlTransient
    public List<TabDocumentoEstado> getTabDocumentoEstadoList() {
        return tabDocumentoEstadoList;
    }

    public void setTabDocumentoEstadoList(List<TabDocumentoEstado> tabDocumentoEstadoList) {
        this.tabDocumentoEstadoList = tabDocumentoEstadoList;
    }

    @XmlTransient
    public List<TabPersonaNovedad> getTabPersonaNovedadList() {
        return tabPersonaNovedadList;
    }

    public void setTabPersonaNovedadList(List<TabPersonaNovedad> tabPersonaNovedadList) {
        this.tabPersonaNovedadList = tabPersonaNovedadList;
    }

    @XmlTransient
    public List<TabMantenimientoVialGestion> getTabMantenimientoVialGestionList() {
        return tabMantenimientoVialGestionList;
    }

    public void setTabMantenimientoVialGestionList(List<TabMantenimientoVialGestion> tabMantenimientoVialGestionList) {
        this.tabMantenimientoVialGestionList = tabMantenimientoVialGestionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabPersona)) {
            return false;
        }
        TabPersona other = (TabPersona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabPersona[ idPersona=" + idPersona + " ]";
    }

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList() {
        return tabMantenimientoVialEventoList;
    }

    public void setTabMantenimientoVialEventoList(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList) {
        this.tabMantenimientoVialEventoList = tabMantenimientoVialEventoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList1() {
        return tabMantenimientoVialEventoList1;
    }

    public void setTabMantenimientoVialEventoList1(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList1) {
        this.tabMantenimientoVialEventoList1 = tabMantenimientoVialEventoList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList2() {
        return tabMantenimientoVialEventoList2;
    }

    public void setTabMantenimientoVialEventoList2(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList2) {
        this.tabMantenimientoVialEventoList2 = tabMantenimientoVialEventoList2;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList3() {
        return tabMantenimientoVialEventoList3;
    }

    public void setTabMantenimientoVialEventoList3(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList3) {
        this.tabMantenimientoVialEventoList3 = tabMantenimientoVialEventoList3;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList4() {
        return tabMantenimientoVialEventoList4;
    }

    public void setTabMantenimientoVialEventoList4(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList4) {
        this.tabMantenimientoVialEventoList4 = tabMantenimientoVialEventoList4;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList5() {
        return tabMantenimientoVialEventoList5;
    }

    public void setTabMantenimientoVialEventoList5(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList5) {
        this.tabMantenimientoVialEventoList5 = tabMantenimientoVialEventoList5;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList6() {
        return tabMantenimientoVialEventoList6;
    }

    public void setTabMantenimientoVialEventoList6(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList6) {
        this.tabMantenimientoVialEventoList6 = tabMantenimientoVialEventoList6;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList7() {
        return tabMantenimientoVialEventoList7;
    }

    public void setTabMantenimientoVialEventoList7(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList7) {
        this.tabMantenimientoVialEventoList7 = tabMantenimientoVialEventoList7;
    }
        
}
