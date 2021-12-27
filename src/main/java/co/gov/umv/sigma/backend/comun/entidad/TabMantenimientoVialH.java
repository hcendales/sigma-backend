/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "TAB_MANTENIMIENTO_VIAL_H")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMantenimientoVialH.findAll", query = "SELECT t FROM TabMantenimientoVialH t"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdMantenimientoVialH", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idMantenimientoVialH = :idMantenimientoVialH"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoOrigen", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoOrigen = :idTipoOrigen"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFecha", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudNombre", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudNombre = :solicitudNombre"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudFecha", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudFecha = :solicitudFecha"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudVencimiento", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudVencimiento = :solicitudVencimiento"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudRadicadoEntrada", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudRadicadoEntrada = :solicitudRadicadoEntrada"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudDireccion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudDireccion = :solicitudDireccion"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudRadicadoSalida", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudRadicadoSalida = :solicitudRadicadoSalida"),
    @NamedQuery(name = "TabMantenimientoVialH.findBySolicitudFechaSalida", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.solicitudFechaSalida = :solicitudFechaSalida"),
    @NamedQuery(name = "TabMantenimientoVialH.findByPkIdCalzada", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.pkIdCalzada = :pkIdCalzada"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdLocalidad", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idLocalidad = :idLocalidad"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdZona", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idZona = :idZona"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdUpla", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idUpla = :idUpla"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdBarrio", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idBarrio = :idBarrio"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdCuadrante", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idCuadrante = :idCuadrante"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdUpz", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idUpz = :idUpz"),
    @NamedQuery(name = "TabMantenimientoVialH.findByAnchoPk", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.anchoPk = :anchoPk"),
    @NamedQuery(name = "TabMantenimientoVialH.findByAreaPk", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.areaPk = :areaPk"),
    @NamedQuery(name = "TabMantenimientoVialH.findByLongitudHorizontalPk", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.longitudHorizontalPk = :longitudHorizontalPk"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoEstadoPk", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoEstadoPk = :idTipoEstadoPk"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoUsoVia", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoUsoVia = :idTipoUsoVia"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoMalla", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoMalla = :idTipoMalla"),
    @NamedQuery(name = "TabMantenimientoVialH.findByCiv", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.civ = :civ"),
    @NamedQuery(name = "TabMantenimientoVialH.findByEjeVial", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.ejeVial = :ejeVial"),
    @NamedQuery(name = "TabMantenimientoVialH.findByDesde", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.desde = :desde"),
    @NamedQuery(name = "TabMantenimientoVialH.findByHasta", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.hasta = :hasta"),
    @NamedQuery(name = "TabMantenimientoVialH.findByNumeroRadicadoEntrada", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.numeroRadicadoEntrada = :numeroRadicadoEntrada"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoEstadoProgVisita", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoEstadoProgVisita = :idTipoEstadoProgVisita"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaVisitaTecnica", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaVisitaTecnica = :fechaVisitaTecnica"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaResponsableVisita", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaResponsableVisita = :idPersonaResponsableVisita"),
    @NamedQuery(name = "TabMantenimientoVialH.findByRutasTransporte", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.rutasTransporte = :rutasTransporte"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoTransitabilidad", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoTransitabilidad = :idTipoTransitabilidad"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoImpactoSocial", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoImpactoSocial = :idTipoImpactoSocial"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoDeterminacionInterv", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoDeterminacionInterv = :idTipoDeterminacionInterv"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoCoordinacionInterinst", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoCoordinacionInterinst = :idTipoCoordinacionInterinst"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoAporteMetas", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoAporteMetas = :idTipoAporteMetas"),
    @NamedQuery(name = "TabMantenimientoVialH.findByObservacionesDiagnostico", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.observacionesDiagnostico = :observacionesDiagnostico"),
    @NamedQuery(name = "TabMantenimientoVialH.findByPci", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.pci = :pci"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoCalificacionPci", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoCalificacionPci = :idTipoCalificacionPci"),
    @NamedQuery(name = "TabMantenimientoVialH.findByNumeroRadicadoSalida", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.numeroRadicadoSalida = :numeroRadicadoSalida"),
    @NamedQuery(name = "TabMantenimientoVialH.findByNumeroRadicadoIntervencion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.numeroRadicadoIntervencion = :numeroRadicadoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdZonaEabEsp", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idZonaEabEsp = :idZonaEabEsp"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoSeccionVial", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoSeccionVial = :idTipoSeccionVial"),
    @NamedQuery(name = "TabMantenimientoVialH.findByKmCarrilImpacto", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.kmCarrilImpacto = :kmCarrilImpacto"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoPrograma", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoPrograma = :idTipoPrograma"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoEstrategia", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoEstrategia = :idTipoEstrategia"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoActividad", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoActividad = :idTipoActividad"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIndicePriorizacion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.indicePriorizacion = :indicePriorizacion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaRadicadoIntervencion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaRadicadoIntervencion = :fechaRadicadoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionLongitud", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionLongitud = :intervencionLongitud"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionAncho", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionAncho = :intervencionAncho"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionArea", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionArea = :intervencionArea"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionKmCarril", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionKmCarril = :intervencionKmCarril"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionTipo", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionTipo = :intervencionTipo"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionRespuestaIdu", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionRespuestaIdu = :intervencionRespuestaIdu"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionPlacaReferencia", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionPlacaReferencia = :intervencionPlacaReferencia"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIntervencionFechaEjecucion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.intervencionFechaEjecucion = :intervencionFechaEjecucion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByPosibleDanioRedes", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.posibleDanioRedes = :posibleDanioRedes"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoEjecucion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoEjecucion = :idTipoEjecucion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoClase", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoClase = :idTipoClase"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaTerminacion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaTerminacion = :fechaTerminacion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaSeguimiento", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaSeguimiento = :fechaSeguimiento"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaVisitaVerificacion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaVisitaVerificacion = :fechaVisitaVerificacion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaResponsableVerif", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaResponsableVerif = :idPersonaResponsableVerif"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaDirectorObra", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaDirectorObra = :idPersonaDirectorObra"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaResidenteSocial", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaResidenteSocial = :idPersonaResidenteSocial"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaResidenteSst", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaResidenteSst = :idPersonaResidenteSst"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaResidenteAmbiental", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaResidenteAmbiental = :idPersonaResidenteAmbiental"),
    @NamedQuery(name = "TabMantenimientoVialH.findByObservacionesIntervencion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.observacionesIntervencion = :observacionesIntervencion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByRequiereActualizacionDiag", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.requiereActualizacionDiag = :requiereActualizacionDiag"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoPmt", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoPmt = :idTipoPmt"),
    @NamedQuery(name = "TabMantenimientoVialH.findByCoi", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.coi = :coi"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoEstadoPmt", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoEstadoPmt = :idTipoEstadoPmt"),
    @NamedQuery(name = "TabMantenimientoVialH.findByNumeroRadicadoPmt", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.numeroRadicadoPmt = :numeroRadicadoPmt"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaRadicadoPmt", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaRadicadoPmt = :fechaRadicadoPmt"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdProgramacionPeriodica", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idProgramacionPeriodica = :idProgramacionPeriodica"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdPersonaResidenteObra", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idPersonaResidenteObra = :idPersonaResidenteObra"),
    @NamedQuery(name = "TabMantenimientoVialH.findByNumeroRadicadoSolReserva", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.numeroRadicadoSolReserva = :numeroRadicadoSolReserva"),
    @NamedQuery(name = "TabMantenimientoVialH.findByNumeroRadicadoResReserva", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.numeroRadicadoResReserva = :numeroRadicadoResReserva"),
    @NamedQuery(name = "TabMantenimientoVialH.findByEnSeguimiento", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.enSeguimiento = :enSeguimiento"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoRutasTransporte", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoRutasTransporte = :idTipoRutasTransporte"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoSuperficie", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoVia", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoVia = :idTipoVia"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoAdministracion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoAdministracion = :idTipoAdministracion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoRequerimiento", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoRequerimiento = :idTipoRequerimiento"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoGrupo", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoGrupo = :idTipoGrupo"),
    @NamedQuery(name = "TabMantenimientoVialH.findByPriorizacionTrimestre", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.priorizacionTrimestre = :priorizacionTrimestre"),
    @NamedQuery(name = "TabMantenimientoVialH.findByObservacionesPriorizacion", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.observacionesPriorizacion = :observacionesPriorizacion"),
    @NamedQuery(name = "TabMantenimientoVialH.findByIdTipoIntervencionTotal", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.idTipoIntervencionTotal = :idTipoIntervencionTotal"),
    @NamedQuery(name = "TabMantenimientoVialH.findByAuditoriaUsuario", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMantenimientoVialH.findByAuditoriaFecha", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.auditoriaFecha = :auditoriaFecha"),
    @NamedQuery(name = "TabMantenimientoVialH.findByFechaH", query = "SELECT t FROM TabMantenimientoVialH t WHERE t.fechaH = :fechaH")})
public class TabMantenimientoVialH implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO_VIAL_H")
    private Long idMantenimientoVialH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ORIGEN")
    private long idTipoOrigen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "SOLICITUD_NOMBRE")
    private String solicitudNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solicitudFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solicitudVencimiento;
    @Size(max = 20)
    @Column(name = "SOLICITUD_RADICADO_ENTRADA")
    private String solicitudRadicadoEntrada;
    @Size(max = 100)
    @Column(name = "SOLICITUD_DIRECCION")
    private String solicitudDireccion;
    @Size(max = 20)
    @Column(name = "SOLICITUD_RADICADO_SALIDA")
    private String solicitudRadicadoSalida;
    @Column(name = "SOLICITUD_FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solicitudFechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ID_CALZADA")
    private BigInteger pkIdCalzada;
    @Column(name = "ID_LOCALIDAD")
    private Long idLocalidad;
    @Column(name = "ID_ZONA")
    private Long idZona;
    @Column(name = "ID_UPLA")
    private Long idUpla;
    @Column(name = "ID_BARRIO")
    private Long idBarrio;
    @Column(name = "ID_CUADRANTE")
    private Long idCuadrante;
    @Column(name = "ID_UPZ")
    private Long idUpz;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ESTADO_PK")
    private long idTipoEstadoPk;
    @Column(name = "ID_TIPO_USO_VIA")
    private Long idTipoUsoVia;
    @Column(name = "ID_TIPO_MALLA")
    private Long idTipoMalla;
    @Size(max = 30)
    @Column(name = "CIV")
    private String civ;
    @Size(max = 20)
    @Column(name = "EJE_VIAL")
    private String ejeVial;
    @Size(max = 30)
    @Column(name = "DESDE")
    private String desde;
    @Size(max = 30)
    @Column(name = "HASTA")
    private String hasta;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_ENTRADA")
    private String numeroRadicadoEntrada;
    @Column(name = "ID_TIPO_ESTADO_PROG_VISITA")
    private Long idTipoEstadoProgVisita;
    @Column(name = "FECHA_VISITA_TECNICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisitaTecnica;
    @Column(name = "ID_PERSONA_RESPONSABLE_VISITA")
    private Long idPersonaResponsableVisita;
    @Size(max = 2)
    @Column(name = "RUTAS_TRANSPORTE")
    private String rutasTransporte;
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
    @Size(max = 600)
    @Column(name = "OBSERVACIONES_DIAGNOSTICO")
    private String observacionesDiagnostico;
    @Column(name = "PCI")
    private Long pci;
    @Column(name = "ID_TIPO_CALIFICACION_PCI")
    private Long idTipoCalificacionPci;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_SALIDA")
    private String numeroRadicadoSalida;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_INTERVENCION")
    private String numeroRadicadoIntervencion;
    @Column(name = "ID_ZONA_EAB_ESP")
    private Long idZonaEabEsp;
    @Column(name = "ID_TIPO_SECCION_VIAL")
    private Long idTipoSeccionVial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KM_CARRIL_IMPACTO")
    private BigDecimal kmCarrilImpacto;
    @Column(name = "ID_TIPO_PROGRAMA")
    private Long idTipoPrograma;
    @Column(name = "ID_TIPO_ESTRATEGIA")
    private Long idTipoEstrategia;
    @Column(name = "ID_TIPO_ACTIVIDAD")
    private Long idTipoActividad;
    @Column(name = "INDICE_PRIORIZACION")
    private BigDecimal indicePriorizacion;
    @Column(name = "FECHA_RADICADO_INTERVENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicadoIntervencion;
    @Column(name = "INTERVENCION_LONGITUD")
    private BigDecimal intervencionLongitud;
    @Column(name = "INTERVENCION_ANCHO")
    private BigDecimal intervencionAncho;
    @Column(name = "INTERVENCION_AREA")
    private BigDecimal intervencionArea;
    @Column(name = "INTERVENCION_KM_CARRIL")
    private BigDecimal intervencionKmCarril;
    @Size(max = 300)
    @Column(name = "INTERVENCION_TIPO")
    private String intervencionTipo;
    @Column(name = "INTERVENCION_RESPUESTA_IDU")
    private Long intervencionRespuestaIdu;
    @Size(max = 300)
    @Column(name = "INTERVENCION_PLACA_REFERENCIA")
    private String intervencionPlacaReferencia;
    @Column(name = "INTERVENCION_FECHA_EJECUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intervencionFechaEjecucion;
    @Size(max = 2)
    @Column(name = "POSIBLE_DANIO_REDES")
    private String posibleDanioRedes;
    @Column(name = "ID_TIPO_EJECUCION")
    private Long idTipoEjecucion;
    @Column(name = "ID_TIPO_CLASE")
    private Long idTipoClase;
    @Column(name = "FECHA_TERMINACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminacion;
    @Column(name = "FECHA_SEGUIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimiento;
    @Column(name = "FECHA_VISITA_VERIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisitaVerificacion;
    @Column(name = "ID_PERSONA_RESPONSABLE_VERIF")
    private Long idPersonaResponsableVerif;
    @Column(name = "ID_PERSONA_DIRECTOR_OBRA")
    private Long idPersonaDirectorObra;
    @Column(name = "ID_PERSONA_RESIDENTE_SOCIAL")
    private Long idPersonaResidenteSocial;
    @Column(name = "ID_PERSONA_RESIDENTE_SST")
    private Long idPersonaResidenteSst;
    @Column(name = "ID_PERSONA_RESIDENTE_AMBIENTAL")
    private Long idPersonaResidenteAmbiental;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES_INTERVENCION")
    private String observacionesIntervencion;
    @Size(max = 2)
    @Column(name = "REQUIERE_ACTUALIZACION_DIAG")
    private String requiereActualizacionDiag;
    @Column(name = "ID_TIPO_PMT")
    private Long idTipoPmt;
    @Column(name = "COI")
    private Long coi;
    @Column(name = "ID_TIPO_ESTADO_PMT")
    private Long idTipoEstadoPmt;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_PMT")
    private String numeroRadicadoPmt;
    @Column(name = "FECHA_RADICADO_PMT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicadoPmt;
    @Column(name = "ID_PROGRAMACION_PERIODICA")
    private Long idProgramacionPeriodica;
    @Column(name = "ID_PERSONA_RESIDENTE_OBRA")
    private Long idPersonaResidenteObra;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_SOL_RESERVA")
    private String numeroRadicadoSolReserva;
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_RES_RESERVA")
    private String numeroRadicadoResReserva;
    @Size(max = 2)
    @Column(name = "EN_SEGUIMIENTO")
    private String enSeguimiento;
    @Column(name = "ID_TIPO_RUTAS_TRANSPORTE")
    private Long idTipoRutasTransporte;
    @Column(name = "ID_TIPO_SUPERFICIE")
    private Long idTipoSuperficie;
    @Column(name = "ID_TIPO_VIA")
    private Long idTipoVia;
    @Column(name = "ID_TIPO_ADMINISTRACION")
    private Long idTipoAdministracion;
    @Column(name = "ID_TIPO_REQUERIMIENTO")
    private Long idTipoRequerimiento;
    @Column(name = "ID_TIPO_GRUPO")
    private Long idTipoGrupo;
    @Size(max = 6)
    @Column(name = "PRIORIZACION_TRIMESTRE")
    private String priorizacionTrimestre;
    @Size(max = 2000)
    @Column(name = "OBSERVACIONES_PRIORIZACION")
    private String observacionesPriorizacion;
    @Column(name = "ID_TIPO_INTERVENCION_TOTAL")
    private Long idTipoIntervencionTotal;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_H")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaH;
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL", referencedColumnName = "ID_MANTENIMIENTO_VIAL")
    @ManyToOne(optional = false)
    private TabMantenimientoVial idMantenimientoVial;

    public TabMantenimientoVialH() {
    }

    public TabMantenimientoVialH(Long idMantenimientoVialH) {
        this.idMantenimientoVialH = idMantenimientoVialH;
    }

    public TabMantenimientoVialH(Long idMantenimientoVialH, long idTipoOrigen, Date fecha, Date solicitudFecha, Date solicitudVencimiento, BigInteger pkIdCalzada, BigDecimal anchoPk, BigDecimal areaPk, BigDecimal longitudHorizontalPk, long idTipoEstadoPk, BigDecimal kmCarrilImpacto, String auditoriaUsuario, Date auditoriaFecha, Date fechaH) {
        this.idMantenimientoVialH = idMantenimientoVialH;
        this.idTipoOrigen = idTipoOrigen;
        this.fecha = fecha;
        this.solicitudFecha = solicitudFecha;
        this.solicitudVencimiento = solicitudVencimiento;
        this.pkIdCalzada = pkIdCalzada;
        this.anchoPk = anchoPk;
        this.areaPk = areaPk;
        this.longitudHorizontalPk = longitudHorizontalPk;
        this.idTipoEstadoPk = idTipoEstadoPk;
        this.kmCarrilImpacto = kmCarrilImpacto;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
        this.fechaH = fechaH;
    }

    public Long getIdMantenimientoVialH() {
        return idMantenimientoVialH;
    }

    public void setIdMantenimientoVialH(Long idMantenimientoVialH) {
        this.idMantenimientoVialH = idMantenimientoVialH;
    }

    public long getIdTipoOrigen() {
        return idTipoOrigen;
    }

    public void setIdTipoOrigen(long idTipoOrigen) {
        this.idTipoOrigen = idTipoOrigen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSolicitudNombre() {
        return solicitudNombre;
    }

    public void setSolicitudNombre(String solicitudNombre) {
        this.solicitudNombre = solicitudNombre;
    }

    public Date getSolicitudFecha() {
        return solicitudFecha;
    }

    public void setSolicitudFecha(Date solicitudFecha) {
        this.solicitudFecha = solicitudFecha;
    }

    public Date getSolicitudVencimiento() {
        return solicitudVencimiento;
    }

    public void setSolicitudVencimiento(Date solicitudVencimiento) {
        this.solicitudVencimiento = solicitudVencimiento;
    }

    public String getSolicitudRadicadoEntrada() {
        return solicitudRadicadoEntrada;
    }

    public void setSolicitudRadicadoEntrada(String solicitudRadicadoEntrada) {
        this.solicitudRadicadoEntrada = solicitudRadicadoEntrada;
    }

    public String getSolicitudDireccion() {
        return solicitudDireccion;
    }

    public void setSolicitudDireccion(String solicitudDireccion) {
        this.solicitudDireccion = solicitudDireccion;
    }

    public String getSolicitudRadicadoSalida() {
        return solicitudRadicadoSalida;
    }

    public void setSolicitudRadicadoSalida(String solicitudRadicadoSalida) {
        this.solicitudRadicadoSalida = solicitudRadicadoSalida;
    }

    public Date getSolicitudFechaSalida() {
        return solicitudFechaSalida;
    }

    public void setSolicitudFechaSalida(Date solicitudFechaSalida) {
        this.solicitudFechaSalida = solicitudFechaSalida;
    }

    public BigInteger getPkIdCalzada() {
        return pkIdCalzada;
    }

    public void setPkIdCalzada(BigInteger pkIdCalzada) {
        this.pkIdCalzada = pkIdCalzada;
    }

    public Long getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Long idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public Long getIdUpla() {
        return idUpla;
    }

    public void setIdUpla(Long idUpla) {
        this.idUpla = idUpla;
    }

    public Long getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Long idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Long getIdCuadrante() {
        return idCuadrante;
    }

    public void setIdCuadrante(Long idCuadrante) {
        this.idCuadrante = idCuadrante;
    }

    public Long getIdUpz() {
        return idUpz;
    }

    public void setIdUpz(Long idUpz) {
        this.idUpz = idUpz;
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

    public long getIdTipoEstadoPk() {
        return idTipoEstadoPk;
    }

    public void setIdTipoEstadoPk(long idTipoEstadoPk) {
        this.idTipoEstadoPk = idTipoEstadoPk;
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

    public String getCiv() {
        return civ;
    }

    public void setCiv(String civ) {
        this.civ = civ;
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

    public String getNumeroRadicadoEntrada() {
        return numeroRadicadoEntrada;
    }

    public void setNumeroRadicadoEntrada(String numeroRadicadoEntrada) {
        this.numeroRadicadoEntrada = numeroRadicadoEntrada;
    }

    public Long getIdTipoEstadoProgVisita() {
        return idTipoEstadoProgVisita;
    }

    public void setIdTipoEstadoProgVisita(Long idTipoEstadoProgVisita) {
        this.idTipoEstadoProgVisita = idTipoEstadoProgVisita;
    }

    public Date getFechaVisitaTecnica() {
        return fechaVisitaTecnica;
    }

    public void setFechaVisitaTecnica(Date fechaVisitaTecnica) {
        this.fechaVisitaTecnica = fechaVisitaTecnica;
    }

    public Long getIdPersonaResponsableVisita() {
        return idPersonaResponsableVisita;
    }

    public void setIdPersonaResponsableVisita(Long idPersonaResponsableVisita) {
        this.idPersonaResponsableVisita = idPersonaResponsableVisita;
    }

    public String getRutasTransporte() {
        return rutasTransporte;
    }

    public void setRutasTransporte(String rutasTransporte) {
        this.rutasTransporte = rutasTransporte;
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

    public String getObservacionesDiagnostico() {
        return observacionesDiagnostico;
    }

    public void setObservacionesDiagnostico(String observacionesDiagnostico) {
        this.observacionesDiagnostico = observacionesDiagnostico;
    }

    public Long getPci() {
        return pci;
    }

    public void setPci(Long pci) {
        this.pci = pci;
    }

    public Long getIdTipoCalificacionPci() {
        return idTipoCalificacionPci;
    }

    public void setIdTipoCalificacionPci(Long idTipoCalificacionPci) {
        this.idTipoCalificacionPci = idTipoCalificacionPci;
    }

    public String getNumeroRadicadoSalida() {
        return numeroRadicadoSalida;
    }

    public void setNumeroRadicadoSalida(String numeroRadicadoSalida) {
        this.numeroRadicadoSalida = numeroRadicadoSalida;
    }

    public String getNumeroRadicadoIntervencion() {
        return numeroRadicadoIntervencion;
    }

    public void setNumeroRadicadoIntervencion(String numeroRadicadoIntervencion) {
        this.numeroRadicadoIntervencion = numeroRadicadoIntervencion;
    }

    public Long getIdZonaEabEsp() {
        return idZonaEabEsp;
    }

    public void setIdZonaEabEsp(Long idZonaEabEsp) {
        this.idZonaEabEsp = idZonaEabEsp;
    }

    public Long getIdTipoSeccionVial() {
        return idTipoSeccionVial;
    }

    public void setIdTipoSeccionVial(Long idTipoSeccionVial) {
        this.idTipoSeccionVial = idTipoSeccionVial;
    }

    public BigDecimal getKmCarrilImpacto() {
        return kmCarrilImpacto;
    }

    public void setKmCarrilImpacto(BigDecimal kmCarrilImpacto) {
        this.kmCarrilImpacto = kmCarrilImpacto;
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

    public Long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(Long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public BigDecimal getIndicePriorizacion() {
        return indicePriorizacion;
    }

    public void setIndicePriorizacion(BigDecimal indicePriorizacion) {
        this.indicePriorizacion = indicePriorizacion;
    }

    public Date getFechaRadicadoIntervencion() {
        return fechaRadicadoIntervencion;
    }

    public void setFechaRadicadoIntervencion(Date fechaRadicadoIntervencion) {
        this.fechaRadicadoIntervencion = fechaRadicadoIntervencion;
    }

    public BigDecimal getIntervencionLongitud() {
        return intervencionLongitud;
    }

    public void setIntervencionLongitud(BigDecimal intervencionLongitud) {
        this.intervencionLongitud = intervencionLongitud;
    }

    public BigDecimal getIntervencionAncho() {
        return intervencionAncho;
    }

    public void setIntervencionAncho(BigDecimal intervencionAncho) {
        this.intervencionAncho = intervencionAncho;
    }

    public BigDecimal getIntervencionArea() {
        return intervencionArea;
    }

    public void setIntervencionArea(BigDecimal intervencionArea) {
        this.intervencionArea = intervencionArea;
    }

    public BigDecimal getIntervencionKmCarril() {
        return intervencionKmCarril;
    }

    public void setIntervencionKmCarril(BigDecimal intervencionKmCarril) {
        this.intervencionKmCarril = intervencionKmCarril;
    }

    public String getIntervencionTipo() {
        return intervencionTipo;
    }

    public void setIntervencionTipo(String intervencionTipo) {
        this.intervencionTipo = intervencionTipo;
    }

    public Long getIntervencionRespuestaIdu() {
        return intervencionRespuestaIdu;
    }

    public void setIntervencionRespuestaIdu(Long intervencionRespuestaIdu) {
        this.intervencionRespuestaIdu = intervencionRespuestaIdu;
    }

    public String getIntervencionPlacaReferencia() {
        return intervencionPlacaReferencia;
    }

    public void setIntervencionPlacaReferencia(String intervencionPlacaReferencia) {
        this.intervencionPlacaReferencia = intervencionPlacaReferencia;
    }

    public Date getIntervencionFechaEjecucion() {
        return intervencionFechaEjecucion;
    }

    public void setIntervencionFechaEjecucion(Date intervencionFechaEjecucion) {
        this.intervencionFechaEjecucion = intervencionFechaEjecucion;
    }

    public String getPosibleDanioRedes() {
        return posibleDanioRedes;
    }

    public void setPosibleDanioRedes(String posibleDanioRedes) {
        this.posibleDanioRedes = posibleDanioRedes;
    }

    public Long getIdTipoEjecucion() {
        return idTipoEjecucion;
    }

    public void setIdTipoEjecucion(Long idTipoEjecucion) {
        this.idTipoEjecucion = idTipoEjecucion;
    }

    public Long getIdTipoClase() {
        return idTipoClase;
    }

    public void setIdTipoClase(Long idTipoClase) {
        this.idTipoClase = idTipoClase;
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

    public Date getFechaVisitaVerificacion() {
        return fechaVisitaVerificacion;
    }

    public void setFechaVisitaVerificacion(Date fechaVisitaVerificacion) {
        this.fechaVisitaVerificacion = fechaVisitaVerificacion;
    }

    public Long getIdPersonaResponsableVerif() {
        return idPersonaResponsableVerif;
    }

    public void setIdPersonaResponsableVerif(Long idPersonaResponsableVerif) {
        this.idPersonaResponsableVerif = idPersonaResponsableVerif;
    }

    public Long getIdPersonaDirectorObra() {
        return idPersonaDirectorObra;
    }

    public void setIdPersonaDirectorObra(Long idPersonaDirectorObra) {
        this.idPersonaDirectorObra = idPersonaDirectorObra;
    }

    public Long getIdPersonaResidenteSocial() {
        return idPersonaResidenteSocial;
    }

    public void setIdPersonaResidenteSocial(Long idPersonaResidenteSocial) {
        this.idPersonaResidenteSocial = idPersonaResidenteSocial;
    }

    public Long getIdPersonaResidenteSst() {
        return idPersonaResidenteSst;
    }

    public void setIdPersonaResidenteSst(Long idPersonaResidenteSst) {
        this.idPersonaResidenteSst = idPersonaResidenteSst;
    }

    public Long getIdPersonaResidenteAmbiental() {
        return idPersonaResidenteAmbiental;
    }

    public void setIdPersonaResidenteAmbiental(Long idPersonaResidenteAmbiental) {
        this.idPersonaResidenteAmbiental = idPersonaResidenteAmbiental;
    }

    public String getObservacionesIntervencion() {
        return observacionesIntervencion;
    }

    public void setObservacionesIntervencion(String observacionesIntervencion) {
        this.observacionesIntervencion = observacionesIntervencion;
    }

    public String getRequiereActualizacionDiag() {
        return requiereActualizacionDiag;
    }

    public void setRequiereActualizacionDiag(String requiereActualizacionDiag) {
        this.requiereActualizacionDiag = requiereActualizacionDiag;
    }

    public Long getIdTipoPmt() {
        return idTipoPmt;
    }

    public void setIdTipoPmt(Long idTipoPmt) {
        this.idTipoPmt = idTipoPmt;
    }

    public Long getCoi() {
        return coi;
    }

    public void setCoi(Long coi) {
        this.coi = coi;
    }

    public Long getIdTipoEstadoPmt() {
        return idTipoEstadoPmt;
    }

    public void setIdTipoEstadoPmt(Long idTipoEstadoPmt) {
        this.idTipoEstadoPmt = idTipoEstadoPmt;
    }

    public String getNumeroRadicadoPmt() {
        return numeroRadicadoPmt;
    }

    public void setNumeroRadicadoPmt(String numeroRadicadoPmt) {
        this.numeroRadicadoPmt = numeroRadicadoPmt;
    }

    public Date getFechaRadicadoPmt() {
        return fechaRadicadoPmt;
    }

    public void setFechaRadicadoPmt(Date fechaRadicadoPmt) {
        this.fechaRadicadoPmt = fechaRadicadoPmt;
    }

    public Long getIdProgramacionPeriodica() {
        return idProgramacionPeriodica;
    }

    public void setIdProgramacionPeriodica(Long idProgramacionPeriodica) {
        this.idProgramacionPeriodica = idProgramacionPeriodica;
    }

    public Long getIdPersonaResidenteObra() {
        return idPersonaResidenteObra;
    }

    public void setIdPersonaResidenteObra(Long idPersonaResidenteObra) {
        this.idPersonaResidenteObra = idPersonaResidenteObra;
    }

    public String getNumeroRadicadoSolReserva() {
        return numeroRadicadoSolReserva;
    }

    public void setNumeroRadicadoSolReserva(String numeroRadicadoSolReserva) {
        this.numeroRadicadoSolReserva = numeroRadicadoSolReserva;
    }

    public String getNumeroRadicadoResReserva() {
        return numeroRadicadoResReserva;
    }

    public void setNumeroRadicadoResReserva(String numeroRadicadoResReserva) {
        this.numeroRadicadoResReserva = numeroRadicadoResReserva;
    }

    public String getEnSeguimiento() {
        return enSeguimiento;
    }

    public void setEnSeguimiento(String enSeguimiento) {
        this.enSeguimiento = enSeguimiento;
    }

    public Long getIdTipoRutasTransporte() {
        return idTipoRutasTransporte;
    }

    public void setIdTipoRutasTransporte(Long idTipoRutasTransporte) {
        this.idTipoRutasTransporte = idTipoRutasTransporte;
    }

    public Long getIdTipoSuperficie() {
        return idTipoSuperficie;
    }

    public void setIdTipoSuperficie(Long idTipoSuperficie) {
        this.idTipoSuperficie = idTipoSuperficie;
    }

    public Long getIdTipoVia() {
        return idTipoVia;
    }

    public void setIdTipoVia(Long idTipoVia) {
        this.idTipoVia = idTipoVia;
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

    public Long getIdTipoGrupo() {
        return idTipoGrupo;
    }

    public void setIdTipoGrupo(Long idTipoGrupo) {
        this.idTipoGrupo = idTipoGrupo;
    }

    public String getPriorizacionTrimestre() {
        return priorizacionTrimestre;
    }

    public void setPriorizacionTrimestre(String priorizacionTrimestre) {
        this.priorizacionTrimestre = priorizacionTrimestre;
    }

    public String getObservacionesPriorizacion() {
        return observacionesPriorizacion;
    }

    public void setObservacionesPriorizacion(String observacionesPriorizacion) {
        this.observacionesPriorizacion = observacionesPriorizacion;
    }

    public Long getIdTipoIntervencionTotal() {
        return idTipoIntervencionTotal;
    }

    public void setIdTipoIntervencionTotal(Long idTipoIntervencionTotal) {
        this.idTipoIntervencionTotal = idTipoIntervencionTotal;
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

    public Date getFechaH() {
        return fechaH;
    }

    public void setFechaH(Date fechaH) {
        this.fechaH = fechaH;
    }

    public TabMantenimientoVial getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(TabMantenimientoVial idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimientoVialH != null ? idMantenimientoVialH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMantenimientoVialH)) {
            return false;
        }
        TabMantenimientoVialH other = (TabMantenimientoVialH) object;
        if ((this.idMantenimientoVialH == null && other.idMantenimientoVialH != null) || (this.idMantenimientoVialH != null && !this.idMantenimientoVialH.equals(other.idMantenimientoVialH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialH[ idMantenimientoVialH=" + idMantenimientoVialH + " ]";
    }
    
}
