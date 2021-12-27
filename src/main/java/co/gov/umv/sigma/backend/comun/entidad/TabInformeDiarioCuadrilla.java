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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_INFORME_DIARIO_CUADRILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findAll", query = "SELECT t FROM TabInformeDiarioCuadrilla t"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdInformeDiarioCuadrilla", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idInformeDiarioCuadrilla = :idInformeDiarioCuadrilla"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByFecha", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdTipoJornada", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idTipoJornada = :idTipoJornada"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByPorcentajeAvanceDiarioObra", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.porcentajeAvanceDiarioObra = :porcentajeAvanceDiarioObra"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByPorcentajeAvanceAcumObra", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.porcentajeAvanceAcumObra = :porcentajeAvanceAcumObra"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByAreaTotalIntervenida", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.areaTotalIntervenida = :areaTotalIntervenida"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByLongitudTotalIntervenida", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.LongitudTotalIntervenida = :LongitudTotalIntervenida"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdTipoClimaManana", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idTipoClimaManana = :idTipoClimaManana"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdTipoClimaTarde", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idTipoClimaTarde = :idTipoClimaTarde"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdTipoClimaNoche", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idTipoClimaNoche = :idTipoClimaNoche"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByHoraInicioActividades", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.horaInicioActividades = :horaInicioActividades"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByHorarioFinActividades", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.horarioFinActividades = :horarioFinActividades"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByServicioVigilancia", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.servicioVigilancia = :servicioVigilancia"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByServicioVigilanciaHoras", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.servicioVigilanciaHoras = :servicioVigilanciaHoras"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByServicioBanio", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.servicioBanio = :servicioBanio"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByServicioBanioHoras", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.servicioBanioHoras = :servicioBanioHoras"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByCantidadSeniales", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.cantidadSeniales = :cantidadSeniales"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByCantidadDelineadores", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.cantidadDelineadores = :cantidadDelineadores"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdArchivoEsquema", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idArchivoEsquema = :idArchivoEsquema"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdTipoEstadoObra", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idTipoEstadoObra = :idTipoEstadoObra"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdTipoEstadoInforme", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idTipoEstadoInforme = :idTipoEstadoInforme"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdPersonaElabora", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idPersonaElabora = :idPersonaElabora"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdPersonaRevisa", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idPersonaRevisa = :idPersonaRevisa"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByIdPersonaAprueba", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.idPersonaAprueba = :idPersonaAprueba"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByObservaciones", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByActividadDiaSiguiente", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.actividadDiaSiguiente = :actividadDiaSiguiente"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByAuditoriaUsuario", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInformeDiarioCuadrilla.findByAuditoriaFecha", query = "SELECT t FROM TabInformeDiarioCuadrilla t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInformeDiarioCuadrilla implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFORME_DIARIO_CUADRILLA")
    private Long idInformeDiarioCuadrilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_JORNADA")
    private Long idTipoJornada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_AVANCE_DIARIO_OBRA")
    private BigDecimal porcentajeAvanceDiarioObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_AVANCE_ACUM_OBRA")
    private BigDecimal porcentajeAvanceAcumObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREA_TOTAL_INTERVENIDA")
    private BigDecimal areaTotalIntervenida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LongITUD_TOTAL_INTERVENIDA")
    private BigDecimal LongitudTotalIntervenida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLIMA_MANANA")
    private Long idTipoClimaManana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLIMA_TARDE")
    private Long idTipoClimaTarde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLIMA_NOCHE")
    private Long idTipoClimaNoche;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "HORA_INICIO_ACTIVIDADES")
    private String horaInicioActividades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "HORARIO_FIN_ACTIVIDADES")
    private String horarioFinActividades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SERVICIO_VIGILANCIA")
    private String servicioVigilancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_VIGILANCIA_HORAS")
    private BigDecimal servicioVigilanciaHoras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SERVICIO_BANIO")
    private String servicioBanio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_BANIO_HORAS")
    private short servicioBanioHoras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_SENIALES")
    private short cantidadSeniales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_DELINEADORES")
    private short cantidadDelineadores;
    @Column(name = "ID_ARCHIVO_ESQUEMA")
    private Long idArchivoEsquema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_OBRA")
    private Long idTipoEstadoObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_INFORME")
    private Long idTipoEstadoInforme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA_ELABORA")
    private Long idPersonaElabora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA_REVISA")
    private Long idPersonaRevisa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA_APRUEBA")
    private Long idPersonaAprueba;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 600)
    @Column(name = "ACTIVIDAD_DIA_SIGUIENTE")
    private String actividadDiaSiguiente;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaEntrMaterial> tabInfdiacuaEntrMaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaPersonal> tabInfdiacuaPersonalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaMezclaConc> tabInfdiacuaMezclaConcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaCalidad> tabInfdiacuaCalidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaSaliMaterial> tabInfdiacuaSaliMaterialList;
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL", referencedColumnName = "ID_MANTENIMIENTO_VIAL")
    @ManyToOne(optional = false)
    private Long idMantenimientoVial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaObservacion> tabInfdiacuaObservacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaCantObra> tabInfdiacuaCantObraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformeDiarioCuadrilla")
    private List<TabInfdiacuaMaquinaria> tabInfdiacuaMaquinariaList;

    public TabInformeDiarioCuadrilla() {
    }

    public TabInformeDiarioCuadrilla(Long idInformeDiarioCuadrilla) {
        this.idInformeDiarioCuadrilla = idInformeDiarioCuadrilla;
    }

    public TabInformeDiarioCuadrilla(Long idInformeDiarioCuadrilla, Date fecha, Long idTipoJornada, BigDecimal porcentajeAvanceDiarioObra, BigDecimal porcentajeAvanceAcumObra, BigDecimal areaTotalIntervenida, BigDecimal LongitudTotalIntervenida, Long idTipoClimaManana, Long idTipoClimaTarde, Long idTipoClimaNoche, String horaInicioActividades, String horarioFinActividades, String servicioVigilancia, BigDecimal servicioVigilanciaHoras, String servicioBanio, short servicioBanioHoras, short cantidadSeniales, short cantidadDelineadores, Long idTipoEstadoObra, Long idTipoEstadoInforme, Long idPersonaElabora, Long idPersonaRevisa, Long idPersonaAprueba, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInformeDiarioCuadrilla = idInformeDiarioCuadrilla;
        this.fecha = fecha;
        this.idTipoJornada = idTipoJornada;
        this.porcentajeAvanceDiarioObra = porcentajeAvanceDiarioObra;
        this.porcentajeAvanceAcumObra = porcentajeAvanceAcumObra;
        this.areaTotalIntervenida = areaTotalIntervenida;
        this.LongitudTotalIntervenida = LongitudTotalIntervenida;
        this.idTipoClimaManana = idTipoClimaManana;
        this.idTipoClimaTarde = idTipoClimaTarde;
        this.idTipoClimaNoche = idTipoClimaNoche;
        this.horaInicioActividades = horaInicioActividades;
        this.horarioFinActividades = horarioFinActividades;
        this.servicioVigilancia = servicioVigilancia;
        this.servicioVigilanciaHoras = servicioVigilanciaHoras;
        this.servicioBanio = servicioBanio;
        this.servicioBanioHoras = servicioBanioHoras;
        this.cantidadSeniales = cantidadSeniales;
        this.cantidadDelineadores = cantidadDelineadores;
        this.idTipoEstadoObra = idTipoEstadoObra;
        this.idTipoEstadoInforme = idTipoEstadoInforme;
        this.idPersonaElabora = idPersonaElabora;
        this.idPersonaRevisa = idPersonaRevisa;
        this.idPersonaAprueba = idPersonaAprueba;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInformeDiarioCuadrilla() {
        return idInformeDiarioCuadrilla;
    }

    public void setIdInformeDiarioCuadrilla(Long idInformeDiarioCuadrilla) {
        this.idInformeDiarioCuadrilla = idInformeDiarioCuadrilla;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdTipoJornada() {
        return idTipoJornada;
    }

    public void setIdTipoJornada(Long idTipoJornada) {
        this.idTipoJornada = idTipoJornada;
    }

    public BigDecimal getPorcentajeAvanceDiarioObra() {
        return porcentajeAvanceDiarioObra;
    }

    public void setPorcentajeAvanceDiarioObra(BigDecimal porcentajeAvanceDiarioObra) {
        this.porcentajeAvanceDiarioObra = porcentajeAvanceDiarioObra;
    }

    public BigDecimal getPorcentajeAvanceAcumObra() {
        return porcentajeAvanceAcumObra;
    }

    public void setPorcentajeAvanceAcumObra(BigDecimal porcentajeAvanceAcumObra) {
        this.porcentajeAvanceAcumObra = porcentajeAvanceAcumObra;
    }

    public BigDecimal getAreaTotalIntervenida() {
        return areaTotalIntervenida;
    }

    public void setAreaTotalIntervenida(BigDecimal areaTotalIntervenida) {
        this.areaTotalIntervenida = areaTotalIntervenida;
    }

    public BigDecimal getLongitudTotalIntervenida() {
        return LongitudTotalIntervenida;
    }

    public void setLongitudTotalIntervenida(BigDecimal LongitudTotalIntervenida) {
        this.LongitudTotalIntervenida = LongitudTotalIntervenida;
    }

    public Long getIdTipoClimaManana() {
        return idTipoClimaManana;
    }

    public void setIdTipoClimaManana(Long idTipoClimaManana) {
        this.idTipoClimaManana = idTipoClimaManana;
    }

    public Long getIdTipoClimaTarde() {
        return idTipoClimaTarde;
    }

    public void setIdTipoClimaTarde(Long idTipoClimaTarde) {
        this.idTipoClimaTarde = idTipoClimaTarde;
    }

    public Long getIdTipoClimaNoche() {
        return idTipoClimaNoche;
    }

    public void setIdTipoClimaNoche(Long idTipoClimaNoche) {
        this.idTipoClimaNoche = idTipoClimaNoche;
    }

    public String getHoraInicioActividades() {
        return horaInicioActividades;
    }

    public void setHoraInicioActividades(String horaInicioActividades) {
        this.horaInicioActividades = horaInicioActividades;
    }

    public String getHorarioFinActividades() {
        return horarioFinActividades;
    }

    public void setHorarioFinActividades(String horarioFinActividades) {
        this.horarioFinActividades = horarioFinActividades;
    }

    public String getServicioVigilancia() {
        return servicioVigilancia;
    }

    public void setServicioVigilancia(String servicioVigilancia) {
        this.servicioVigilancia = servicioVigilancia;
    }

    public BigDecimal getServicioVigilanciaHoras() {
        return servicioVigilanciaHoras;
    }

    public void setServicioVigilanciaHoras(BigDecimal servicioVigilanciaHoras) {
        this.servicioVigilanciaHoras = servicioVigilanciaHoras;
    }

    public String getServicioBanio() {
        return servicioBanio;
    }

    public void setServicioBanio(String servicioBanio) {
        this.servicioBanio = servicioBanio;
    }

    public short getServicioBanioHoras() {
        return servicioBanioHoras;
    }

    public void setServicioBanioHoras(short servicioBanioHoras) {
        this.servicioBanioHoras = servicioBanioHoras;
    }

    public short getCantidadSeniales() {
        return cantidadSeniales;
    }

    public void setCantidadSeniales(short cantidadSeniales) {
        this.cantidadSeniales = cantidadSeniales;
    }

    public short getCantidadDelineadores() {
        return cantidadDelineadores;
    }

    public void setCantidadDelineadores(short cantidadDelineadores) {
        this.cantidadDelineadores = cantidadDelineadores;
    }

    public Long getIdArchivoEsquema() {
        return idArchivoEsquema;
    }

    public void setIdArchivoEsquema(Long idArchivoEsquema) {
        this.idArchivoEsquema = idArchivoEsquema;
    }

    public Long getIdTipoEstadoObra() {
        return idTipoEstadoObra;
    }

    public void setIdTipoEstadoObra(Long idTipoEstadoObra) {
        this.idTipoEstadoObra = idTipoEstadoObra;
    }

    public Long getIdTipoEstadoInforme() {
        return idTipoEstadoInforme;
    }

    public void setIdTipoEstadoInforme(Long idTipoEstadoInforme) {
        this.idTipoEstadoInforme = idTipoEstadoInforme;
    }

    public Long getIdPersonaElabora() {
        return idPersonaElabora;
    }

    public void setIdPersonaElabora(Long idPersonaElabora) {
        this.idPersonaElabora = idPersonaElabora;
    }

    public Long getIdPersonaRevisa() {
        return idPersonaRevisa;
    }

    public void setIdPersonaRevisa(Long idPersonaRevisa) {
        this.idPersonaRevisa = idPersonaRevisa;
    }

    public Long getIdPersonaAprueba() {
        return idPersonaAprueba;
    }

    public void setIdPersonaAprueba(Long idPersonaAprueba) {
        this.idPersonaAprueba = idPersonaAprueba;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getActividadDiaSiguiente() {
        return actividadDiaSiguiente;
    }

    public void setActividadDiaSiguiente(String actividadDiaSiguiente) {
        this.actividadDiaSiguiente = actividadDiaSiguiente;
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
    @JsonIgnore
    public List<TabInfdiacuaEntrMaterial> getTabInfdiacuaEntrMaterialList() {
        return tabInfdiacuaEntrMaterialList;
    }

    public void setTabInfdiacuaEntrMaterialList(List<TabInfdiacuaEntrMaterial> tabInfdiacuaEntrMaterialList) {
        this.tabInfdiacuaEntrMaterialList = tabInfdiacuaEntrMaterialList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaPersonal> getTabInfdiacuaPersonalList() {
        return tabInfdiacuaPersonalList;
    }

    public void setTabInfdiacuaPersonalList(List<TabInfdiacuaPersonal> tabInfdiacuaPersonalList) {
        this.tabInfdiacuaPersonalList = tabInfdiacuaPersonalList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaMezclaConc> getTabInfdiacuaMezclaConcList() {
        return tabInfdiacuaMezclaConcList;
    }

    public void setTabInfdiacuaMezclaConcList(List<TabInfdiacuaMezclaConc> tabInfdiacuaMezclaConcList) {
        this.tabInfdiacuaMezclaConcList = tabInfdiacuaMezclaConcList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaCalidad> getTabInfdiacuaCalidadList() {
        return tabInfdiacuaCalidadList;
    }

    public void setTabInfdiacuaCalidadList(List<TabInfdiacuaCalidad> tabInfdiacuaCalidadList) {
        this.tabInfdiacuaCalidadList = tabInfdiacuaCalidadList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaSaliMaterial> getTabInfdiacuaSaliMaterialList() {
        return tabInfdiacuaSaliMaterialList;
    }

    public void setTabInfdiacuaSaliMaterialList(List<TabInfdiacuaSaliMaterial> tabInfdiacuaSaliMaterialList) {
        this.tabInfdiacuaSaliMaterialList = tabInfdiacuaSaliMaterialList;
    }

    public Long getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(Long idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaObservacion> getTabInfdiacuaObservacionList() {
        return tabInfdiacuaObservacionList;
    }

    public void setTabInfdiacuaObservacionList(List<TabInfdiacuaObservacion> tabInfdiacuaObservacionList) {
        this.tabInfdiacuaObservacionList = tabInfdiacuaObservacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaCantObra> getTabInfdiacuaCantObraList() {
        return tabInfdiacuaCantObraList;
    }

    public void setTabInfdiacuaCantObraList(List<TabInfdiacuaCantObra> tabInfdiacuaCantObraList) {
        this.tabInfdiacuaCantObraList = tabInfdiacuaCantObraList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInfdiacuaMaquinaria> getTabInfdiacuaMaquinariaList() {
        return tabInfdiacuaMaquinariaList;
    }

    public void setTabInfdiacuaMaquinariaList(List<TabInfdiacuaMaquinaria> tabInfdiacuaMaquinariaList) {
        this.tabInfdiacuaMaquinariaList = tabInfdiacuaMaquinariaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformeDiarioCuadrilla != null ? idInformeDiarioCuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInformeDiarioCuadrilla)) {
            return false;
        }
        TabInformeDiarioCuadrilla other = (TabInformeDiarioCuadrilla) object;
        if ((this.idInformeDiarioCuadrilla == null && other.idInformeDiarioCuadrilla != null) || (this.idInformeDiarioCuadrilla != null && !this.idInformeDiarioCuadrilla.equals(other.idInformeDiarioCuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInformeDiarioCuadrilla[ idInformeDiarioCuadrilla=" + idInformeDiarioCuadrilla + " ]";
    }
    
}
