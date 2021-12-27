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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/**
 *
 * @author juanmetalmolina
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "TAB_MANTENIMIENTO_VIAL_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMantenimientoVialEvento.findAll", query = "SELECT t FROM TabMantenimientoVialEvento t"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdMantenimientoVialEvento", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idMantenimientoVialEvento = :idMantenimientoVialEvento"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByEvento", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.evento = :evento"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaCreacionEvento", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaCreacionEvento = :fechaCreacionEvento"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaVisita", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaVisita = :fechaVisita"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdResponsableVisita", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idResponsableVisita = :idResponsableVisita"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdDocumentoVisita", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idDocumentoVisita = :idDocumentoVisita"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByObservaciones", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByAnchoPk", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.anchoPk = :anchoPk"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByAreaPk", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.areaPk = :areaPk"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByLongitudHorizontalPk", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.longitudHorizontalPk = :longitudHorizontalPk"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoUsoVia", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoUsoVia = :idTipoUsoVia"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoMalla", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoMalla = :idTipoMalla"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoSuperficie", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByEjeVial", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.ejeVial = :ejeVial"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByDesde", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.desde = :desde"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByHasta", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.hasta = :hasta"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByRutasTransporte", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.rutasTransporte = :rutasTransporte"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByPosibleDanioRedes", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.posibleDanioRedes = :posibleDanioRedes"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoTransitabilidad", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoTransitabilidad = :idTipoTransitabilidad"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoImpactoSocial", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoImpactoSocial = :idTipoImpactoSocial"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoDeterminacionInterv", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoDeterminacionInterv = :idTipoDeterminacionInterv"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoCoordinacionInterinst", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoCoordinacionInterinst = :idTipoCoordinacionInterinst"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoAporteMetas", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoAporteMetas = :idTipoAporteMetas"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByPci", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.pci = :pci"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByKmCarrilImpacto", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.kmCarrilImpacto = :kmCarrilImpacto"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByKmCarrilObra", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.kmCarrilObra = :kmCarrilObra"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByKmCarril", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.kmCarril = :kmCarril"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByKmLineal", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.kmLineal = :kmLineal"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByRequiereAforo", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.requiereAforo = :requiereAforo"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByRequiereApiques", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.requiereApiques = :requiereApiques"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findBySolicitudesAdicionales", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.solicitudesAdicionales = :solicitudesAdicionales"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByObservacionAdicionales", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.observacionAdicionales = :observacionAdicionales"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByViableIntervencion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.viableIntervencion = :viableIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoClasificacionSubrasant", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoClasificacionSubrasant = :idTipoClasificacionSubrasant"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoSuperficieDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoSuperficieDisenio = :idTipoSuperficieDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoIntervencionFinalDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoIntervencionFinalDisenio = :idTipoIntervencionFinalDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoMetodologiaDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoMetodologiaDisenio = :idTipoMetodologiaDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoMaterialGranular", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoMaterialGranular = :idTipoMaterialGranular"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByEspesorDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.espesorDisenio = :espesorDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByCbrInicialPct", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.cbrInicialPct = :cbrInicialPct"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByCbrDisenioPct", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.cbrDisenioPct = :cbrDisenioPct"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByKsDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.ksDisenio = :ksDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByNeeDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.neeDisenio = :neeDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByTpdvcDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.tpdvcDisenio = :tpdvcDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByNumeroEstructuralEfectivoDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.numeroEstructuralEfectivoDisenio = :numeroEstructuralEfectivoDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoGeosinteticos", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoGeosinteticos = :idTipoGeosinteticos"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoSistemaDrenaje", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoSistemaDrenaje = :idTipoSistemaDrenaje"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoPrograma", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoPrograma = :idTipoPrograma"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoEstrategia", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoEstrategia = :idTipoEstrategia"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoAdministracion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoAdministracion = :idTipoAdministracion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoRequerimiento", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoRequerimiento = :idTipoRequerimiento"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoActividadDetallada", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoActividadDetallada = :idTipoActividadDetallada"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoIntervencionTotal", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoIntervencionTotal = :idTipoIntervencionTotal"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByCodigoActividadAgrupada", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.codigoActividadAgrupada = :codigoActividadAgrupada"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIndicePriorizacion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.indicePriorizacion = :indicePriorizacion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByPriorizacionTrimestre", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.priorizacionTrimestre = :priorizacionTrimestre"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdTipoIntervencion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idTipoIntervencion = :idTipoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIntervencionHuecos", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.intervencionHuecos = :intervencionHuecos"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaInicio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaEjecucion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaEjecucion = :fechaEjecucion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaSuspension", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaSuspension = :fechaSuspension"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaTerminacion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaTerminacion = :fechaTerminacion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaSeguimiento", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaSeguimiento = :fechaSeguimiento"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdDirectorObra", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idDirectorObra = :idDirectorObra"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdResidenteObra", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idResidenteObra = :idResidenteObra"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdResidenteSocial", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idResidenteSocial = :idResidenteSocial"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdResidenteSst", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idResidenteSst = :idResidenteSst"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdResidenteAmbiental", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idResidenteAmbiental = :idResidenteAmbiental"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdIngenieroDisenio", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idIngenieroDisenio = :idIngenieroDisenio"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByIdIngenieroApoyo", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.idIngenieroApoyo = :idIngenieroApoyo"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByRequiereActualizacionDiag", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.requiereActualizacionDiag = :requiereActualizacionDiag"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByNumeroRadicadoIntervencion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.numeroRadicadoIntervencion = :numeroRadicadoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaRadicadoIntervencion", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaRadicadoIntervencion = :fechaRadicadoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByNumeroRadicadoSolReserva", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.numeroRadicadoSolReserva = :numeroRadicadoSolReserva"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaRadicadoSolReserva", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaRadicadoSolReserva = :fechaRadicadoSolReserva"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByNumeroRadicadoResReserva", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.numeroRadicadoResReserva = :numeroRadicadoResReserva"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByFechaRadicadoResReserva", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.fechaRadicadoResReserva = :fechaRadicadoResReserva"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByEnSeguimiento", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.enSeguimiento = :enSeguimiento"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByAuditoriaUsuario", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMantenimientoVialEvento.findByAuditoriaFecha", query = "SELECT t FROM TabMantenimientoVialEvento t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabMantenimientoVialEvento implements Serializable {

    @Size(max = 2)
    @Column(name = "RESPUESTA_AFORO")
    private String respuestaAforo;
    @Size(max = 2)
    @Column(name = "RESPUESTA_APIQUES")
    private String respuestaApiques;
    
    @Column(name = "ID_TIPO_PMT")
    private Long idTipoPmt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVialEvento")
    private Collection<TabIntervencionNovedad> tabIntervencionNovedadCollection;

    @Size(max = 600)
    @Column(name = "OBSERVACION_VIABLE_INTERVENCION")
    private String observacionViableIntervencion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVialEvento")
    private List<TabAlternativaDisenio> tabAlternativaDisenioList;

    @Column(name = "ID_TIPO_ACTIVIDAD_DETALLADA")
    private Long idTipoActividadDetallada;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO_VIAL_EVENTO")
    private Long idMantenimientoVialEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVENTO")
    private String evento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION_EVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionEvento;
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Column(name = "ID_RESPONSABLE_VISITA")
    private Long idResponsableVisita;
    @Column(name = "ID_DOCUMENTO_VISITA")
    private Long idDocumentoVisita;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANCHO_PK")
    private BigDecimal anchoPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREA_PK")
    private BigDecimal areaPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD_HORIZONTAL_PK")
    private BigDecimal longitudHorizontalPk;
    @Column(name = "ID_TIPO_USO_VIA")
    private Long idTipoUsoVia;
    @Column(name = "ID_TIPO_MALLA")
    private Long idTipoMalla;
    @Column(name = "ID_TIPO_SUPERFICIE")
    private Long idTipoSuperficie;
    @Size(max = 20)
    @Column(name = "EJE_VIAL")
    private String ejeVial;
    @Size(max = 30)
    @Column(name = "DESDE")
    private String desde;
    @Size(max = 30)
    @Column(name = "HASTA")
    private String hasta;
    @Size(max = 2)
    @Column(name = "RUTAS_TRANSPORTE")
    private String rutasTransporte;
    @Size(max = 2)
    @Column(name = "POSIBLE_DANIO_REDES")
    private String posibleDanioRedes;
    @Column(name = "ID_TIPO_TRANSITABILIDAD")
    private Long idTipoTransitabilidad;
    @Column(name = "ID_TIPO_IMPACTO_SOCIAL")
    private Long idTipoImpactoSocial;
    @Column(name = "ID_TIPO_DETERMINACION_INTERV")
    private Long idTipoDeterminacionInterv;
    @Column(name = "ID_TIPO_COORDINACION_INTERINST")
    private Long idTipoCoordinacionInterinst;
    @Column(name = "ID_TIPO_APORTE_METAS")
    private Long idTipoAporteMetas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PCI")
    private long pci;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KM_CARRIL_IMPACTO")
    @JsonProperty("km_carril_impacto")
    private BigDecimal kmCarrilImpacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KM_CARRIL_OBRA")
    private BigDecimal kmCarrilObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KM_CARRIL")
    private BigDecimal kmCarril;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KM_LINEAL")
    private BigDecimal kmLineal;
    @Size(max = 2)
    @Column(name = "REQUIERE_AFORO")
    private String requiereAforo;
    @Size(max = 2)
    @Column(name = "REQUIERE_APIQUES")
    private String requiereApiques;
    @Size(max = 2)
    @Column(name = "SOLICITUDES_ADICIONALES")
    private String solicitudesAdicionales;
    @Size(max = 600)
    @Column(name = "OBSERVACION_ADICIONALES")
    private String observacionAdicionales;
    @Size(max = 2)
    @Column(name = "VIABLE_INTERVENCION")
    private String viableIntervencion;
    @Column(name = "ID_TIPO_CLASIFICACION_SUBRASANT")
    private Long idTipoClasificacionSubrasant;
    @Column(name = "ID_TIPO_SUPERFICIE_DISENIO")
    private Long idTipoSuperficieDisenio;
    @Column(name = "ID_TIPO_INTERVENCION_FINAL_DISENIO")
    private Long idTipoIntervencionFinalDisenio;
    @Column(name = "ID_TIPO_METODOLOGIA_DISENIO")
    private Long idTipoMetodologiaDisenio;
    @Column(name = "ID_TIPO_MATERIAL_GRANULAR")
    private Long idTipoMaterialGranular;
    @Column(name = "ESPESOR_DISENIO")
    private BigDecimal espesorDisenio;
    @Column(name = "CBR_INICIAL_PCT")
    private BigDecimal cbrInicialPct;
    @Column(name = "CBR_DISENIO_PCT")
    private BigDecimal cbrDisenioPct;
    @Column(name = "KS_DISENIO")
    private BigDecimal ksDisenio;
    @Column(name = "NEE_DISENIO")
    private BigDecimal neeDisenio;
    @Column(name = "TPDVC_DISENIO")
    private BigDecimal tpdvcDisenio;
    @Column(name = "NUMERO_ESTRUCTURAL_EFECTIVO_DISENIO")
    private BigDecimal numeroEstructuralEfectivoDisenio;
    @Column(name = "ID_TIPO_GEOSINTETICOS")
    private Long idTipoGeosinteticos;
    @Column(name = "ID_TIPO_SISTEMA_DRENAJE")
    private Long idTipoSistemaDrenaje;
    @Column(name = "ID_TIPO_PROGRAMA")
    private Long idTipoPrograma;
    @Column(name = "ID_TIPO_ESTRATEGIA")
    private Long idTipoEstrategia;
    @Column(name = "ID_TIPO_ADMINISTRACION")
    private Long idTipoAdministracion;
    @Column(name = "ID_TIPO_REQUERIMIENTO")
    private Long idTipoRequerimiento;
    @Column(name = "ID_TIPO_INTERVENCION_TOTAL")
    private Long idTipoIntervencionTotal;
    @Size(max = 50)
    @Column(name = "CODIGO_ACTIVIDAD_AGRUPADA")
    private String codigoActividadAgrupada;
    @Column(name = "INDICE_PRIORIZACION")
    private BigDecimal indicePriorizacion;
    @Size(max = 6)
    @Column(name = "PRIORIZACION_TRIMESTRE")
    private String priorizacionTrimestre;
   
    @Column(name = "ID_TIPO_INTERVENCION")
    @JsonProperty("id_tipo_intervencion")
    private Long idTipoIntervencion;
    
    @Column(name = "INTERVENCION_HUECOS")
    private BigDecimal intervencionHuecos;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_EJECUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEjecucion;
    @Column(name = "FECHA_SUSPENSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSuspension;
    @Column(name = "FECHA_TERMINACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminacion;
    @Column(name = "FECHA_SEGUIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimiento;
    @Column(name = "ID_DIRECTOR_OBRA")
    private Long idDirectorObra;
    @Column(name = "ID_RESIDENTE_OBRA")
    private Long idResidenteObra;
    @Column(name = "ID_RESIDENTE_SOCIAL")
    private Long idResidenteSocial;
    @Column(name = "ID_RESIDENTE_SST")
    private Long idResidenteSst;
    @Column(name = "ID_RESIDENTE_AMBIENTAL")
    private Long idResidenteAmbiental;
    @Column(name = "ID_INGENIERO_DISENIO")
    private Long idIngenieroDisenio;
    @Column(name = "ID_INGENIERO_APOYO")
    private Long idIngenieroApoyo;
    @Size(max = 2)
    @Column(name = "REQUIERE_ACTUALIZACION_DIAG")
    private String requiereActualizacionDiag;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_INTERVENCION")
    private String numeroRadicadoIntervencion;
    @Column(name = "FECHA_RADICADO_INTERVENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicadoIntervencion;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_SOL_RESERVA")
    private String numeroRadicadoSolReserva;
    @Column(name = "FECHA_RADICADO_SOL_RESERVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicadoSolReserva;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_RES_RESERVA")
    private String numeroRadicadoResReserva;
    @Column(name = "FECHA_RADICADO_RES_RESERVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicadoResReserva;
    @Size(max = 2)
    @Column(name = "EN_SEGUIMIENTO")
    private String enSeguimiento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVialEvento")
    private List<TabUnidadMuestreo> tabUnidadMuestreoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVialEvento")
    private List<TabOtroFactor> tabOtroFactorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVialEvento")
    private List<TabDisenioCapa> tabDisenioCapaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVialEvento")
    private List<TabPredisenioApique> tabPredisenioApiqueList;
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL", referencedColumnName = "ID_MANTENIMIENTO_VIAL")
    @ManyToOne(optional = false)
    private TabMantenimientoVial idMantenimientoVial;
    @OneToMany(mappedBy = "idMantenimientoVialEvento")
    private List<TabRecursoAsignacion> tabRecursoAsignacionList;

    public TabMantenimientoVialEvento() {
    }

    public TabMantenimientoVialEvento(Long idMantenimientoVialEvento) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
    }

    public TabMantenimientoVialEvento(Long idMantenimientoVialEvento, String evento, Date fechaCreacionEvento, BigDecimal anchoPk, BigDecimal areaPk, BigDecimal longitudHorizontalPk, long pci, BigDecimal kmCarrilImpacto, BigDecimal kmCarrilObra, BigDecimal kmCarril, BigDecimal kmLineal, String auditoriaUsuario, Date auditoriaFecha) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
        this.evento = evento;
        this.fechaCreacionEvento = fechaCreacionEvento;
        this.anchoPk = anchoPk;
        this.areaPk = areaPk;
        this.longitudHorizontalPk = longitudHorizontalPk;
        this.pci = pci;
        this.kmCarrilImpacto = kmCarrilImpacto;
        this.kmCarrilObra = kmCarrilObra;
        this.kmCarril = kmCarril;
        this.kmLineal = kmLineal;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdMantenimientoVialEvento() {
        return idMantenimientoVialEvento;
    }

    public void setIdMantenimientoVialEvento(Long idMantenimientoVialEvento) {
        this.idMantenimientoVialEvento = idMantenimientoVialEvento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getFechaCreacionEvento() {
        return fechaCreacionEvento;
    }

    public void setFechaCreacionEvento(Date fechaCreacionEvento) {
        this.fechaCreacionEvento = fechaCreacionEvento;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Long getIdResponsableVisita() {
        return idResponsableVisita;
    }

    public void setIdResponsableVisita(Long idResponsableVisita) {
        this.idResponsableVisita = idResponsableVisita;
    }

    public Long getIdDocumentoVisita() {
        return idDocumentoVisita;
    }

    public void setIdDocumentoVisita(Long idDocumentoVisita) {
        this.idDocumentoVisita = idDocumentoVisita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getAnchoPk() {
        return anchoPk;
    }

    public void setAnchoPk(BigDecimal anchoPk) {
        this.anchoPk = anchoPk;
    }

    public BigDecimal getAreaPk() {
        return areaPk;
    }

    public void setAreaPk(BigDecimal areaPk) {
        this.areaPk = areaPk;
    }

    public BigDecimal getLongitudHorizontalPk() {
        return longitudHorizontalPk;
    }

    public void setLongitudHorizontalPk(BigDecimal longitudHorizontalPk) {
        this.longitudHorizontalPk = longitudHorizontalPk;
    }

    public Long getIdTipoUsoVia() {
        return idTipoUsoVia;
    }

    public void setIdTipoUsoVia(Long idTipoUsoVia) {
        this.idTipoUsoVia = idTipoUsoVia;
    }

    public Long getIdTipoMalla() {
        return idTipoMalla;
    }

    public void setIdTipoMalla(Long idTipoMalla) {
        this.idTipoMalla = idTipoMalla;
    }

    public Long getIdTipoSuperficie() {
        return idTipoSuperficie;
    }

    public void setIdTipoSuperficie(Long idTipoSuperficie) {
        this.idTipoSuperficie = idTipoSuperficie;
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

    public String getRutasTransporte() {
        return rutasTransporte;
    }

    public void setRutasTransporte(String rutasTransporte) {
        this.rutasTransporte = rutasTransporte;
    }

    public String getPosibleDanioRedes() {
        return posibleDanioRedes;
    }

    public void setPosibleDanioRedes(String posibleDanioRedes) {
        this.posibleDanioRedes = posibleDanioRedes;
    }

    public Long getIdTipoTransitabilidad() {
        return idTipoTransitabilidad;
    }

    public void setIdTipoTransitabilidad(Long idTipoTransitabilidad) {
        this.idTipoTransitabilidad = idTipoTransitabilidad;
    }

    public Long getIdTipoImpactoSocial() {
        return idTipoImpactoSocial;
    }

    public void setIdTipoImpactoSocial(Long idTipoImpactoSocial) {
        this.idTipoImpactoSocial = idTipoImpactoSocial;
    }

    public Long getIdTipoDeterminacionInterv() {
        return idTipoDeterminacionInterv;
    }

    public void setIdTipoDeterminacionInterv(Long idTipoDeterminacionInterv) {
        this.idTipoDeterminacionInterv = idTipoDeterminacionInterv;
    }

    public Long getIdTipoCoordinacionInterinst() {
        return idTipoCoordinacionInterinst;
    }

    public void setIdTipoCoordinacionInterinst(Long idTipoCoordinacionInterinst) {
        this.idTipoCoordinacionInterinst = idTipoCoordinacionInterinst;
    }

    public Long getIdTipoAporteMetas() {
        return idTipoAporteMetas;
    }

    public void setIdTipoAporteMetas(Long idTipoAporteMetas) {
        this.idTipoAporteMetas = idTipoAporteMetas;
    }

    public long getPci() {
        return pci;
    }

    public void setPci(long pci) {
        this.pci = pci;
    }

    public BigDecimal getKmCarrilImpacto() {
        return kmCarrilImpacto;
    }

    public void setKmCarrilImpacto(BigDecimal kmCarrilImpacto) {
        this.kmCarrilImpacto = kmCarrilImpacto;
    }

    public BigDecimal getKmCarrilObra() {
        return kmCarrilObra;
    }

    public void setKmCarrilObra(BigDecimal kmCarrilObra) {
        this.kmCarrilObra = kmCarrilObra;
    }

    public BigDecimal getKmCarril() {
        return kmCarril;
    }

    public void setKmCarril(BigDecimal kmCarril) {
        this.kmCarril = kmCarril;
    }

    public BigDecimal getKmLineal() {
        return kmLineal;
    }

    public void setKmLineal(BigDecimal kmLineal) {
        this.kmLineal = kmLineal;
    }

    public String getRequiereAforo() {
        return requiereAforo;
    }

    public void setRequiereAforo(String requiereAforo) {
        this.requiereAforo = requiereAforo;
    }

    public String getRequiereApiques() {
        return requiereApiques;
    }

    public void setRequiereApiques(String requiereApiques) {
        this.requiereApiques = requiereApiques;
    }

    public String getSolicitudesAdicionales() {
        return solicitudesAdicionales;
    }

    public void setSolicitudesAdicionales(String solicitudesAdicionales) {
        this.solicitudesAdicionales = solicitudesAdicionales;
    }

    public String getObservacionAdicionales() {
        return observacionAdicionales;
    }

    public void setObservacionAdicionales(String observacionAdicionales) {
        this.observacionAdicionales = observacionAdicionales;
    }

    public String getViableIntervencion() {
        return viableIntervencion;
    }

    public void setViableIntervencion(String viableIntervencion) {
        this.viableIntervencion = viableIntervencion;
    }

    public Long getIdTipoClasificacionSubrasant() {
        return idTipoClasificacionSubrasant;
    }

    public void setIdTipoClasificacionSubrasant(Long idTipoClasificacionSubrasant) {
        this.idTipoClasificacionSubrasant = idTipoClasificacionSubrasant;
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

    public BigDecimal getCbrDisenioPct() {
        return cbrDisenioPct;
    }

    public void setCbrDisenioPct(BigDecimal cbrDisenioPct) {
        this.cbrDisenioPct = cbrDisenioPct;
    }

    public BigDecimal getKsDisenio() {
        return ksDisenio;
    }

    public void setKsDisenio(BigDecimal ksDisenio) {
        this.ksDisenio = ksDisenio;
    }

    public BigDecimal getNeeDisenio() {
        return neeDisenio;
    }

    public void setNeeDisenio(BigDecimal neeDisenio) {
        this.neeDisenio = neeDisenio;
    }

    public BigDecimal getTpdvcDisenio() {
        return tpdvcDisenio;
    }

    public void setTpdvcDisenio(BigDecimal tpdvcDisenio) {
        this.tpdvcDisenio = tpdvcDisenio;
    }

    public BigDecimal getNumeroEstructuralEfectivoDisenio() {
        return numeroEstructuralEfectivoDisenio;
    }

    public void setNumeroEstructuralEfectivoDisenio(BigDecimal numeroEstructuralEfectivoDisenio) {
        this.numeroEstructuralEfectivoDisenio = numeroEstructuralEfectivoDisenio;
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

    public Long getIdTipoPrograma() {
        return idTipoPrograma;
    }

    public void setIdTipoPrograma(Long idTipoPrograma) {
        this.idTipoPrograma = idTipoPrograma;
    }

    public Long getIdTipoEstrategia() {
        return idTipoEstrategia;
    }

    public void setIdTipoEstrategia(Long idTipoEstrategia) {
        this.idTipoEstrategia = idTipoEstrategia;
    }

    public Long getIdTipoAdministracion() {
        return idTipoAdministracion;
    }

    public void setIdTipoAdministracion(Long idTipoAdministracion) {
        this.idTipoAdministracion = idTipoAdministracion;
    }

    public Long getIdTipoRequerimiento() {
        return idTipoRequerimiento;
    }

    public void setIdTipoRequerimiento(Long idTipoRequerimiento) {
        this.idTipoRequerimiento = idTipoRequerimiento;
    }

    public Long getIdTipoIntervencionTotal() {
        return idTipoIntervencionTotal;
    }

    public void setIdTipoIntervencionTotal(Long idTipoIntervencionTotal) {
        this.idTipoIntervencionTotal = idTipoIntervencionTotal;
    }

    public String getCodigoActividadAgrupada() {
        return codigoActividadAgrupada;
    }

    public void setCodigoActividadAgrupada(String codigoActividadAgrupada) {
        this.codigoActividadAgrupada = codigoActividadAgrupada;
    }

    public BigDecimal getIndicePriorizacion() {
        return indicePriorizacion;
    }

    public void setIndicePriorizacion(BigDecimal indicePriorizacion) {
        this.indicePriorizacion = indicePriorizacion;
    }

    public String getPriorizacionTrimestre() {
        return priorizacionTrimestre;
    }

    public void setPriorizacionTrimestre(String priorizacionTrimestre) {
        this.priorizacionTrimestre = priorizacionTrimestre;
    }

    public Long getIdTipoIntervencion() {
        return idTipoIntervencion;
    }

    public void setIdTipoIntervencion(Long idTipoIntervencion) {
        this.idTipoIntervencion = idTipoIntervencion;
    }

    public BigDecimal getIntervencionHuecos() {
        return intervencionHuecos;
    }

    public void setIntervencionHuecos(BigDecimal intervencionHuecos) {
        this.intervencionHuecos = intervencionHuecos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Date getFechaSuspension() {
        return fechaSuspension;
    }

    public void setFechaSuspension(Date fechaSuspension) {
        this.fechaSuspension = fechaSuspension;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Long getIdDirectorObra() {
        return idDirectorObra;
    }

    public void setIdDirectorObra(Long idDirectorObra) {
        this.idDirectorObra = idDirectorObra;
    }

    public Long getIdResidenteObra() {
        return idResidenteObra;
    }

    public void setIdResidenteObra(Long idResidenteObra) {
        this.idResidenteObra = idResidenteObra;
    }

    public Long getIdResidenteSocial() {
        return idResidenteSocial;
    }

    public void setIdResidenteSocial(Long idResidenteSocial) {
        this.idResidenteSocial = idResidenteSocial;
    }

    public Long getIdResidenteSst() {
        return idResidenteSst;
    }

    public void setIdResidenteSst(Long idResidenteSst) {
        this.idResidenteSst = idResidenteSst;
    }

    public Long getIdResidenteAmbiental() {
        return idResidenteAmbiental;
    }

    public void setIdResidenteAmbiental(Long idResidenteAmbiental) {
        this.idResidenteAmbiental = idResidenteAmbiental;
    }

    public Long getIdIngenieroDisenio() {
        return idIngenieroDisenio;
    }

    public void setIdIngenieroDisenio(Long idIngenieroDisenio) {
        this.idIngenieroDisenio = idIngenieroDisenio;
    }

    public Long getIdIngenieroApoyo() {
        return idIngenieroApoyo;
    }

    public void setIdIngenieroApoyo(Long idIngenieroApoyo) {
        this.idIngenieroApoyo = idIngenieroApoyo;
    }

    public String getRequiereActualizacionDiag() {
        return requiereActualizacionDiag;
    }

    public void setRequiereActualizacionDiag(String requiereActualizacionDiag) {
        this.requiereActualizacionDiag = requiereActualizacionDiag;
    }

    public String getNumeroRadicadoIntervencion() {
        return numeroRadicadoIntervencion;
    }

    public void setNumeroRadicadoIntervencion(String numeroRadicadoIntervencion) {
        this.numeroRadicadoIntervencion = numeroRadicadoIntervencion;
    }

    public Date getFechaRadicadoIntervencion() {
        return fechaRadicadoIntervencion;
    }

    public void setFechaRadicadoIntervencion(Date fechaRadicadoIntervencion) {
        this.fechaRadicadoIntervencion = fechaRadicadoIntervencion;
    }

    public String getNumeroRadicadoSolReserva() {
        return numeroRadicadoSolReserva;
    }

    public void setNumeroRadicadoSolReserva(String numeroRadicadoSolReserva) {
        this.numeroRadicadoSolReserva = numeroRadicadoSolReserva;
    }

    public Date getFechaRadicadoSolReserva() {
        return fechaRadicadoSolReserva;
    }

    public void setFechaRadicadoSolReserva(Date fechaRadicadoSolReserva) {
        this.fechaRadicadoSolReserva = fechaRadicadoSolReserva;
    }

    public String getNumeroRadicadoResReserva() {
        return numeroRadicadoResReserva;
    }

    public void setNumeroRadicadoResReserva(String numeroRadicadoResReserva) {
        this.numeroRadicadoResReserva = numeroRadicadoResReserva;
    }

    public Date getFechaRadicadoResReserva() {
        return fechaRadicadoResReserva;
    }

    public void setFechaRadicadoResReserva(Date fechaRadicadoResReserva) {
        this.fechaRadicadoResReserva = fechaRadicadoResReserva;
    }

    public String getEnSeguimiento() {
        return enSeguimiento;
    }

    public void setEnSeguimiento(String enSeguimiento) {
        this.enSeguimiento = enSeguimiento;
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
    public List<TabUnidadMuestreo> getTabUnidadMuestreoList() {
        return tabUnidadMuestreoList;
    }

    public void setTabUnidadMuestreoList(List<TabUnidadMuestreo> tabUnidadMuestreoList) {
        this.tabUnidadMuestreoList = tabUnidadMuestreoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabOtroFactor> getTabOtroFactorList() {
        return tabOtroFactorList;
    }

    public void setTabOtroFactorList(List<TabOtroFactor> tabOtroFactorList) {
        this.tabOtroFactorList = tabOtroFactorList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabDisenioCapa> getTabDisenioCapaList() {
        return tabDisenioCapaList;
    }

    public void setTabDisenioCapaList(List<TabDisenioCapa> tabDisenioCapaList) {
        this.tabDisenioCapaList = tabDisenioCapaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabPredisenioApique> getTabPredisenioApiqueList() {
        return tabPredisenioApiqueList;
    }

    public void setTabPredisenioApiqueList(List<TabPredisenioApique> tabPredisenioApiqueList) {
        this.tabPredisenioApiqueList = tabPredisenioApiqueList;
    }

    public TabMantenimientoVial getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(TabMantenimientoVial idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabRecursoAsignacion> getTabRecursoAsignacionList() {
        return tabRecursoAsignacionList;
    }

    public void setTabRecursoAsignacionList(List<TabRecursoAsignacion> tabRecursoAsignacionList) {
        this.tabRecursoAsignacionList = tabRecursoAsignacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimientoVialEvento != null ? idMantenimientoVialEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMantenimientoVialEvento)) {
            return false;
        }
        TabMantenimientoVialEvento other = (TabMantenimientoVialEvento) object;
        if ((this.idMantenimientoVialEvento == null && other.idMantenimientoVialEvento != null) || (this.idMantenimientoVialEvento != null && !this.idMantenimientoVialEvento.equals(other.idMantenimientoVialEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialEvento[ idMantenimientoVialEvento=" + idMantenimientoVialEvento + " ]";
    }

    public Long getIdTipoActividadDetallada() {
        return idTipoActividadDetallada;
    }

    public void setIdTipoActividadDetallada(Long idTipoActividadDetallada) {
        this.idTipoActividadDetallada = idTipoActividadDetallada;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabAlternativaDisenio> getTabAlternativaDisenioList() {
        return tabAlternativaDisenioList;
    }

    public void setTabAlternativaDisenioList(List<TabAlternativaDisenio> tabAlternativaDisenioList) {
        this.tabAlternativaDisenioList = tabAlternativaDisenioList;
    }

    public String getObservacionViableIntervencion() {
        return observacionViableIntervencion;
    }

    public void setObservacionViableIntervencion(String observacionViableIntervencion) {
        this.observacionViableIntervencion = observacionViableIntervencion;
    }    

    public Long getIdTipoPmt() {
        return idTipoPmt;
    }

    public void setIdTipoPmt(Long idTipoPmt) {
        this.idTipoPmt = idTipoPmt;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TabIntervencionNovedad> getTabIntervencionNovedadCollection() {
        return tabIntervencionNovedadCollection;
    }

    public void setTabIntervencionNovedadCollection(Collection<TabIntervencionNovedad> tabIntervencionNovedadCollection) {
        this.tabIntervencionNovedadCollection = tabIntervencionNovedadCollection;
    }

    public String getRespuestaAforo() {
        return respuestaAforo;
    }

    public void setRespuestaAforo(String respuestaAforo) {
        this.respuestaAforo = respuestaAforo;
    }

    public String getRespuestaApiques() {
        return respuestaApiques;
    }

    public void setRespuestaApiques(String respuestaApiques) {
        this.respuestaApiques = respuestaApiques;
    }

}
