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

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.CascadeType;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_EQUIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabEquipo.findAll", query = "SELECT t FROM TabEquipo t"),
    @NamedQuery(name = "TabEquipo.findByIdEquipo", query = "SELECT t FROM TabEquipo t WHERE t.idEquipo = :idEquipo"),
    @NamedQuery(name = "TabEquipo.findByNumeroInterno", query = "SELECT t FROM TabEquipo t WHERE t.numeroInterno = :numeroInterno"),
    @NamedQuery(name = "TabEquipo.findByPlacaInventario", query = "SELECT t FROM TabEquipo t WHERE t.placaInventario = :placaInventario"),
    @NamedQuery(name = "TabEquipo.findByPlaca", query = "SELECT t FROM TabEquipo t WHERE t.placa = :placa"),
    @NamedQuery(name = "TabEquipo.findByMovil", query = "SELECT t FROM TabEquipo t WHERE t.movil = :movil"),
    @NamedQuery(name = "TabEquipo.findByIdTipoClaseEqupo", query = "SELECT t FROM TabEquipo t WHERE t.idTipoClaseEqupo = :idTipoClaseEqupo"),
    @NamedQuery(name = "TabEquipo.findByIdTipoEquipo", query = "SELECT t FROM TabEquipo t WHERE t.idTipoEquipo = :idTipoEquipo"),
    @NamedQuery(name = "TabEquipo.findByPicoYPlaca", query = "SELECT t FROM TabEquipo t WHERE t.picoYPlaca = :picoYPlaca"),
    @NamedQuery(name = "TabEquipo.findByIdTipoOrigenEquipo", query = "SELECT t FROM TabEquipo t WHERE t.idTipoOrigenEquipo = :idTipoOrigenEquipo"),
    @NamedQuery(name = "TabEquipo.findByPlazoDiasMantenimiento", query = "SELECT t FROM TabEquipo t WHERE t.plazoDiasMantenimiento = :plazoDiasMantenimiento"),
    @NamedQuery(name = "TabEquipo.findByHorasMantenimiento", query = "SELECT t FROM TabEquipo t WHERE t.horasMantenimiento = :horasMantenimiento"),
    @NamedQuery(name = "TabEquipo.findByKilometrosMantenimiento", query = "SELECT t FROM TabEquipo t WHERE t.kilometrosMantenimiento = :kilometrosMantenimiento"),
    @NamedQuery(name = "TabEquipo.findByFechaUltimoMantenimiento", query = "SELECT t FROM TabEquipo t WHERE t.fechaUltimoMantenimiento = :fechaUltimoMantenimiento"),
    @NamedQuery(name = "TabEquipo.findByFechaSiguienteMantenimiento", query = "SELECT t FROM TabEquipo t WHERE t.fechaSiguienteMantenimiento = :fechaSiguienteMantenimiento"),
    @NamedQuery(name = "TabEquipo.findByIdTipoEstadoEquipo", query = "SELECT t FROM TabEquipo t WHERE t.idTipoEstadoEquipo = :idTipoEstadoEquipo"),
    @NamedQuery(name = "TabEquipo.findByIdTipoMarcaEquipo", query = "SELECT t FROM TabEquipo t WHERE t.idTipoMarcaEquipo = :idTipoMarcaEquipo"),
    @NamedQuery(name = "TabEquipo.findByCilindraje", query = "SELECT t FROM TabEquipo t WHERE t.cilindraje = :cilindraje"),
    @NamedQuery(name = "TabEquipo.findByNumeroMotor", query = "SELECT t FROM TabEquipo t WHERE t.numeroMotor = :numeroMotor"),
    @NamedQuery(name = "TabEquipo.findByNumeroChasis", query = "SELECT t FROM TabEquipo t WHERE t.numeroChasis = :numeroChasis"),
    @NamedQuery(name = "TabEquipo.findByIdTipoCombustible", query = "SELECT t FROM TabEquipo t WHERE t.idTipoCombustible = :idTipoCombustible"),
    @NamedQuery(name = "TabEquipo.findByModelo", query = "SELECT t FROM TabEquipo t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "TabEquipo.findByColor", query = "SELECT t FROM TabEquipo t WHERE t.color = :color"),
    @NamedQuery(name = "TabEquipo.findByIdTipoArea", query = "SELECT t FROM TabEquipo t WHERE t.idTipoArea = :idTipoArea"),
    @NamedQuery(name = "TabEquipo.findByIdTipoLugar", query = "SELECT t FROM TabEquipo t WHERE t.idTipoLugar = :idTipoLugar"),
    @NamedQuery(name = "TabEquipo.findByFechaInicio", query = "SELECT t FROM TabEquipo t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TabEquipo.findByFechaFin", query = "SELECT t FROM TabEquipo t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TabEquipo.findByAuditoriaUsuario", query = "SELECT t FROM TabEquipo t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabEquipo.findByAuditoriaFecha", query = "SELECT t FROM TabEquipo t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabEquipo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLASE_EQUIPO")
    private long idTipoClaseEquipo;
    @Column(name = "TONELADAS")
    private Short toneladas;
    @Column(name = "PASAJEROS")
    private Short pasajeros;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VOLUMEN_M3")
    private BigDecimal volumenM3;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EQUIPO")
    private Long idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_INTERNO")
    private String numeroInterno;
    @Size(max = 20)
    @Column(name = "PLACA_INVENTARIO")
    private String placaInventario;
    @Size(max = 20)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 10)
    @Column(name = "MOVIL")
    private String movil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLASE_EQUPO")
    private long idTipoClaseEqupo;
    @Column(name = "ID_TIPO_EQUIPO")
    private Long idTipoEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PICO_Y_PLACA")
    private String picoYPlaca;
    @Column(name = "ID_TIPO_ORIGEN_EQUIPO")
    private Long idTipoOrigenEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAZO_DIAS_MANTENIMIENTO")
    private long plazoDiasMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_MANTENIMIENTO")
    private long horasMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KILOMETROS_MANTENIMIENTO")
    private long kilometrosMantenimiento;
    
    //@JsonFormat(pattern="yyyy-MM-dd")
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ULTIMO_MANTENIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoMantenimiento;
    
    
    //@JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "FECHA_SIGUIENTE_MANTENIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSiguienteMantenimiento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_EQUIPO")
    private long idTipoEstadoEquipo;
    @Basic(optional = false)
    @NotNull
    
    
    @Column(name = "ID_TIPO_MARCA_EQUIPO")
    private Long idTipoMarcaEquipo;
    
    @Column(name = "LINEA")
    private String linea;
    
    
    @Column(name = "CILINDRAJE")
    private Long cilindraje;
    @Size(max = 20)
    @Column(name = "NUMERO_MOTOR")
    private String numeroMotor;
    @Size(max = 20)
    @Column(name = "NUMERO_CHASIS")
    private String numeroChasis;
    @Column(name = "ID_TIPO_COMBUSTIBLE")
    private Long idTipoCombustible;
    @Column(name = "MODELO")
    private Long modelo;
    @Size(max = 100)
    @Column(name = "COLOR")
    private String color;
    @Column(name = "ID_TIPO_AREA")
    private Long idTipoArea;
    @Column(name = "ID_TIPO_LUGAR")
    private Long idTipoLugar;
    
    //@JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    //@JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    
    @Column(name = "NUMERO_SERIAL") 
    private String numeroSerial;
    @Column(name = "REFERENCIA") 
    private String referencia;
    @Column(name = "DESCRIPCION") 
    private String descripcion;
    
    @Column(name = "ID_TIPO_UNIDAD_USO")
    private Long idTipoUnidadUso;
   
    
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
    @OneToMany(mappedBy = "idEquipo")
    private List<TabRecurso> tabRecursoList;

    public TabEquipo() {
    }

    public TabEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public TabEquipo(Long idEquipo, String numeroInterno, long idTipoClaseEqupo, String picoYPlaca, long plazoDiasMantenimiento, long horasMantenimiento, long kilometrosMantenimiento, Date fechaUltimoMantenimiento, long idTipoEstadoEquipo, String horaInicioProgramacion, String horaFinProgramacion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idEquipo = idEquipo;
        this.numeroInterno = numeroInterno;
        this.idTipoClaseEqupo = idTipoClaseEqupo;
        this.picoYPlaca = picoYPlaca;
        this.plazoDiasMantenimiento = plazoDiasMantenimiento;
        this.horasMantenimiento = horasMantenimiento;
        this.kilometrosMantenimiento = kilometrosMantenimiento;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.idTipoEstadoEquipo = idTipoEstadoEquipo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(String numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public String getPlacaInventario() {
        return placaInventario;
    }

    public void setPlacaInventario(String placaInventario) {
        this.placaInventario = placaInventario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public long getIdTipoClaseEqupo() {
        return idTipoClaseEqupo;
    }

    public void setIdTipoClaseEqupo(long idTipoClaseEqupo) {
        this.idTipoClaseEqupo = idTipoClaseEqupo;
    }

    public Long getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(Long idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public String getPicoYPlaca() {
        return picoYPlaca;
    }

    public void setPicoYPlaca(String picoYPlaca) {
        this.picoYPlaca = picoYPlaca;
    }

    public Long getIdTipoOrigenEquipo() {
        return idTipoOrigenEquipo;
    }

    public void setIdTipoOrigenEquipo(Long idTipoOrigenEquipo) {
        this.idTipoOrigenEquipo = idTipoOrigenEquipo;
    }

    public long getPlazoDiasMantenimiento() {
        return plazoDiasMantenimiento;
    }

    public void setPlazoDiasMantenimiento(long plazoDiasMantenimiento) {
        this.plazoDiasMantenimiento = plazoDiasMantenimiento;
    }

    public long getHorasMantenimiento() {
        return horasMantenimiento;
    }

    public void setHorasMantenimiento(long horasMantenimiento) {
        this.horasMantenimiento = horasMantenimiento;
    }

    public long getKilometrosMantenimiento() {
        return kilometrosMantenimiento;
    }

    public void setKilometrosMantenimiento(long kilometrosMantenimiento) {
        this.kilometrosMantenimiento = kilometrosMantenimiento;
    }

    public Date getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    public void setFechaUltimoMantenimiento(Date fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    public Date getFechaSiguienteMantenimiento() {
        return fechaSiguienteMantenimiento;
    }

    public void setFechaSiguienteMantenimiento(Date fechaSiguienteMantenimiento) {
        this.fechaSiguienteMantenimiento = fechaSiguienteMantenimiento;
    }

    public long getIdTipoEstadoEquipo() {
        return idTipoEstadoEquipo;
    }

    public void setIdTipoEstadoEquipo(long idTipoEstadoEquipo) {
        this.idTipoEstadoEquipo = idTipoEstadoEquipo;
    }

 
    public Long getIdTipoMarcaEquipo() {
        return idTipoMarcaEquipo;
    }

    public void setIdTipoMarcaEquipo(Long idTipoMarcaEquipo) {
        this.idTipoMarcaEquipo = idTipoMarcaEquipo;
    }

  

    public Long getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Long cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public Long getIdTipoCombustible() {
        return idTipoCombustible;
    }

    public void setIdTipoCombustible(Long idTipoCombustible) {
        this.idTipoCombustible = idTipoCombustible;
    }

    public Long getModelo() {
        return modelo;
    }

    public void setModelo(Long modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(Long idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public Long getIdTipoLugar() {
        return idTipoLugar;
    }

    public void setIdTipoLugar(Long idTipoLugar) {
        this.idTipoLugar = idTipoLugar;
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

    
    
    



	public String getNumeroSerial() {
		return numeroSerial;
	}

	public void setNumeroSerial(String numeroSerial) {
		this.numeroSerial = numeroSerial;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
    public List<TabRecurso> getTabRecursoList() {
        return tabRecursoList;
    }

    public void setTabRecursoList(List<TabRecurso> tabRecursoList) {
        this.tabRecursoList = tabRecursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabEquipo)) {
            return false;
        }
        TabEquipo other = (TabEquipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabEquipo[ idEquipo=" + idEquipo + " ]";
    }

    public long getIdTipoClaseEquipo() {
        return idTipoClaseEquipo;
    }

    public void setIdTipoClaseEquipo(long idTipoClaseEquipo) {
        this.idTipoClaseEquipo = idTipoClaseEquipo;
    }

    public Short getToneladas() {
        return toneladas;
    }

    public void setToneladas(Short toneladas) {
        this.toneladas = toneladas;
    }

    public Short getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Short pasajeros) {
        this.pasajeros = pasajeros;
    }

    public BigDecimal getVolumenM3() {
        return volumenM3;
    }

    public void setVolumenM3(BigDecimal volumenM3) {
        this.volumenM3 = volumenM3;
    }

	public Long getIdTipoUnidadUso() {
		return idTipoUnidadUso;
	}

	public void setIdTipoUnidadUso(Long idTipoUnidadUso) {
		this.idTipoUnidadUso = idTipoUnidadUso;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}
    
}
