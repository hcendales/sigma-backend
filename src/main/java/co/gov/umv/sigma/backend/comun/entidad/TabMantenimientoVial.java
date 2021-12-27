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
@Table(name = "TAB_MANTENIMIENTO_VIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabMantenimientoVial.findAll", query = "SELECT t FROM TabMantenimientoVial t"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdMantenimientoVial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idMantenimientoVial = :idMantenimientoVial"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoOrigen", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoOrigen = :idTipoOrigen"),
    @NamedQuery(name = "TabMantenimientoVial.findByFecha", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudNombre", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudNombre = :solicitudNombre"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudFecha", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudFecha = :solicitudFecha"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudVencimiento", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudVencimiento = :solicitudVencimiento"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudRadicadoEntrada", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudRadicadoEntrada = :solicitudRadicadoEntrada"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudDireccion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudDireccion = :solicitudDireccion"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudRadicadoSalida", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudRadicadoSalida = :solicitudRadicadoSalida"),
    @NamedQuery(name = "TabMantenimientoVial.findBySolicitudFechaSalida", query = "SELECT t FROM TabMantenimientoVial t WHERE t.solicitudFechaSalida = :solicitudFechaSalida"),
    @NamedQuery(name = "TabMantenimientoVial.findByPkIdCalzada", query = "SELECT t FROM TabMantenimientoVial t WHERE t.pkIdCalzada = :pkIdCalzada"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdLocalidad", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idLocalidad = :idLocalidad"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdZona", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idZona = :idZona"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdUpla", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idUpla = :idUpla"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdBarrio", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idBarrio = :idBarrio"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdCuadrante", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idCuadrante = :idCuadrante"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdUpz", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idUpz = :idUpz"),
    @NamedQuery(name = "TabMantenimientoVial.findByAnchoPk", query = "SELECT t FROM TabMantenimientoVial t WHERE t.anchoPk = :anchoPk"),
    @NamedQuery(name = "TabMantenimientoVial.findByAreaPk", query = "SELECT t FROM TabMantenimientoVial t WHERE t.areaPk = :areaPk"),
    @NamedQuery(name = "TabMantenimientoVial.findByLongitudHorizontalPk", query = "SELECT t FROM TabMantenimientoVial t WHERE t.longitudHorizontalPk = :longitudHorizontalPk"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoEstadoPk", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoEstadoPk = :idTipoEstadoPk"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoUsoVia", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoUsoVia = :idTipoUsoVia"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoMalla", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoMalla = :idTipoMalla"),
    @NamedQuery(name = "TabMantenimientoVial.findByCiv", query = "SELECT t FROM TabMantenimientoVial t WHERE t.civ = :civ"),
    @NamedQuery(name = "TabMantenimientoVial.findByEjeVial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.ejeVial = :ejeVial"),
    @NamedQuery(name = "TabMantenimientoVial.findByDesde", query = "SELECT t FROM TabMantenimientoVial t WHERE t.desde = :desde"),
    @NamedQuery(name = "TabMantenimientoVial.findByHasta", query = "SELECT t FROM TabMantenimientoVial t WHERE t.hasta = :hasta"),
    @NamedQuery(name = "TabMantenimientoVial.findByNumeroRadicadoEntrada", query = "SELECT t FROM TabMantenimientoVial t WHERE t.numeroRadicadoEntrada = :numeroRadicadoEntrada"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoEstadoProgVisita", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoEstadoProgVisita = :idTipoEstadoProgVisita"),
    @NamedQuery(name = "TabMantenimientoVial.findByFechaVisitaTecnica", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fechaVisitaTecnica = :fechaVisitaTecnica"),
    @NamedQuery(name = "TabMantenimientoVial.findByRutasTransporte", query = "SELECT t FROM TabMantenimientoVial t WHERE t.rutasTransporte = :rutasTransporte"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoTransitabilidad", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoTransitabilidad = :idTipoTransitabilidad"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoImpactoSocial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoImpactoSocial = :idTipoImpactoSocial"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoDeterminacionInterv", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoDeterminacionInterv = :idTipoDeterminacionInterv"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoCoordinacionInterinst", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoCoordinacionInterinst = :idTipoCoordinacionInterinst"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoAporteMetas", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoAporteMetas = :idTipoAporteMetas"),
    @NamedQuery(name = "TabMantenimientoVial.findByObservacionesDiagnostico", query = "SELECT t FROM TabMantenimientoVial t WHERE t.observacionesDiagnostico = :observacionesDiagnostico"),
    @NamedQuery(name = "TabMantenimientoVial.findByPci", query = "SELECT t FROM TabMantenimientoVial t WHERE t.pci = :pci"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoCalificacionPci", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoCalificacionPci = :idTipoCalificacionPci"),
    @NamedQuery(name = "TabMantenimientoVial.findByNumeroRadicadoSalida", query = "SELECT t FROM TabMantenimientoVial t WHERE t.numeroRadicadoSalida = :numeroRadicadoSalida"),
    @NamedQuery(name = "TabMantenimientoVial.findByNumeroRadicadoIntervencion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.numeroRadicadoIntervencion = :numeroRadicadoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdZonaEabEsp", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idZonaEabEsp = :idZonaEabEsp"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoSeccionVial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoSeccionVial = :idTipoSeccionVial"),
    @NamedQuery(name = "TabMantenimientoVial.findByKmCarrilImpacto", query = "SELECT t FROM TabMantenimientoVial t WHERE t.kmCarrilImpacto = :kmCarrilImpacto"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoPrograma", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoPrograma = :idTipoPrograma"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoEstrategia", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoEstrategia = :idTipoEstrategia"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoActividad", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoActividad = :idTipoActividad"),
    @NamedQuery(name = "TabMantenimientoVial.findByIndicePriorizacion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.indicePriorizacion = :indicePriorizacion"),
    @NamedQuery(name = "TabMantenimientoVial.findByFechaRadicadoIntervencion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fechaRadicadoIntervencion = :fechaRadicadoIntervencion"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionLongitud", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionLongitud = :intervencionLongitud"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionAncho", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionAncho = :intervencionAncho"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionArea", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionArea = :intervencionArea"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionKmCarril", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionKmCarril = :intervencionKmCarril"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionTipo", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionTipo = :intervencionTipo"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionRespuestaIdu", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionRespuestaIdu = :intervencionRespuestaIdu"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionPlacaReferencia", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionPlacaReferencia = :intervencionPlacaReferencia"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionFechaEjecucion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionFechaEjecucion = :intervencionFechaEjecucion"),
    @NamedQuery(name = "TabMantenimientoVial.findByPosibleDanioRedes", query = "SELECT t FROM TabMantenimientoVial t WHERE t.posibleDanioRedes = :posibleDanioRedes"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoEjecucion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoEjecucion = :idTipoEjecucion"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoClase", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoClase = :idTipoClase"),
    @NamedQuery(name = "TabMantenimientoVial.findByFechaTerminacion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fechaTerminacion = :fechaTerminacion"),
    @NamedQuery(name = "TabMantenimientoVial.findByFechaSeguimiento", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fechaSeguimiento = :fechaSeguimiento"),
    @NamedQuery(name = "TabMantenimientoVial.findByFechaVisitaVerificacion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fechaVisitaVerificacion = :fechaVisitaVerificacion"),
    @NamedQuery(name = "TabMantenimientoVial.findByObservacionesIntervencion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.observacionesIntervencion = :observacionesIntervencion"),
    @NamedQuery(name = "TabMantenimientoVial.findByRequiereActualizacionDiag", query = "SELECT t FROM TabMantenimientoVial t WHERE t.requiereActualizacionDiag = :requiereActualizacionDiag"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoPmt", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoPmt = :idTipoPmt"),
    @NamedQuery(name = "TabMantenimientoVial.findByCoi", query = "SELECT t FROM TabMantenimientoVial t WHERE t.coi = :coi"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoEstadoPmt", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoEstadoPmt = :idTipoEstadoPmt"),
    @NamedQuery(name = "TabMantenimientoVial.findByNumeroRadicadoPmt", query = "SELECT t FROM TabMantenimientoVial t WHERE t.numeroRadicadoPmt = :numeroRadicadoPmt"),
    @NamedQuery(name = "TabMantenimientoVial.findByFechaRadicadoPmt", query = "SELECT t FROM TabMantenimientoVial t WHERE t.fechaRadicadoPmt = :fechaRadicadoPmt"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdProgramacionPeriodica", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idProgramacionPeriodica = :idProgramacionPeriodica"),
    @NamedQuery(name = "TabMantenimientoVial.findByNumeroRadicadoSolReserva", query = "SELECT t FROM TabMantenimientoVial t WHERE t.numeroRadicadoSolReserva = :numeroRadicadoSolReserva"),
    @NamedQuery(name = "TabMantenimientoVial.findByNumeroRadicadoResReserva", query = "SELECT t FROM TabMantenimientoVial t WHERE t.numeroRadicadoResReserva = :numeroRadicadoResReserva"),
    @NamedQuery(name = "TabMantenimientoVial.findByEnSeguimiento", query = "SELECT t FROM TabMantenimientoVial t WHERE t.enSeguimiento = :enSeguimiento"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoRutasTransporte", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoRutasTransporte = :idTipoRutasTransporte"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoSuperficie", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoSuperficie = :idTipoSuperficie"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoVia", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoVia = :idTipoVia"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoAdministracion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoAdministracion = :idTipoAdministracion"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoRequerimiento", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoRequerimiento = :idTipoRequerimiento"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoGrupo", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoGrupo = :idTipoGrupo"),
    @NamedQuery(name = "TabMantenimientoVial.findByPriorizacionTrimestre", query = "SELECT t FROM TabMantenimientoVial t WHERE t.priorizacionTrimestre = :priorizacionTrimestre"),
    @NamedQuery(name = "TabMantenimientoVial.findByObservacionesPriorizacion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.observacionesPriorizacion = :observacionesPriorizacion"),
    @NamedQuery(name = "TabMantenimientoVial.findByIdTipoIntervencionTotal", query = "SELECT t FROM TabMantenimientoVial t WHERE t.idTipoIntervencionTotal = :idTipoIntervencionTotal"),
    @NamedQuery(name = "TabMantenimientoVial.findByAuditoriaUsuario", query = "SELECT t FROM TabMantenimientoVial t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabMantenimientoVial.findByAuditoriaFecha", query = "SELECT t FROM TabMantenimientoVial t WHERE t.auditoriaFecha = :auditoriaFecha"),
    @NamedQuery(name = "TabMantenimientoVial.findByIntervencionHuecos", query = "SELECT t FROM TabMantenimientoVial t WHERE t.intervencionHuecos = :intervencionHuecos"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeDpmr", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeDpmr = :puntajeDpmr"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeDpg", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeDpg = :puntajeDpg"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajePeticion", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajePeticion = :puntajePeticion"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeSitioSocial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeSitioSocial = :puntajeSitioSocial"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeUsoSocial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeUsoSocial = :puntajeUsoSocial"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeDimenSocial", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeDimenSocial = :puntajeDimenSocial"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeUsoEconomico", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeUsoEconomico = :puntajeUsoEconomico"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeSitioEconom", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeSitioEconom = :puntajeSitioEconom"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeDimenEconom", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeDimenEconom = :puntajeDimenEconom"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeMalla", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeMalla = :puntajeMalla"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeRutas", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeRutas = :puntajeRutas"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeSiniest", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeSiniest = :puntajeSiniest"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeDimenTecnica", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeDimenTecnica = :puntajeDimenTecnica"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeIp", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeIp = :puntajeIp"),
    @NamedQuery(name = "TabMantenimientoVial.findByRangosIp", query = "SELECT t FROM TabMantenimientoVial t WHERE t.rangosIp = :rangosIp"),
    @NamedQuery(name = "TabMantenimientoVial.findByIpRelativo", query = "SELECT t FROM TabMantenimientoVial t WHERE t.ipRelativo = :ipRelativo"),
    @NamedQuery(name = "TabMantenimientoVial.findByPuntajeIpMax", query = "SELECT t FROM TabMantenimientoVial t WHERE t.puntajeIpMax = :puntajeIpMax")})
public class TabMantenimientoVial implements Serializable {

    @Size(max = 100)
    @Column(name = "COI")
    private String coi;
    @Column(name = "FECHA_VISITA_PREDISENIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisitaPredisenio;
    @Column(name = "FECHA_VISITA_DISENIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisitaDisenio;
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
    @Size(max = 20)
    @Column(name = "NUMERO_RADICADO_SDM_PMT")
    private String numeroRadicadoSdmPmt;
    @Column(name = "ID_ARCHIVO_COI_PMT")
    private Long idArchivoCoiPmt;
    @Size(max = 600)
    @Column(name = "OBSERVACIONES_PMT")
    private String observacionesPmt;
    @Column(name = "ID_TIPO_ESTADO_OBRA")
    private Long idTipoEstadoObra;
    @Column(name = "ID_UNIDAD_EJECUTORA")
    private Long idUnidadEjecutora;
    @Column(name = "NUMERO_CARRILES")
    private Short numeroCarriles;
    @Column(name = "NUMERO_LOSAS")
    private Long numeroLosas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabInformeDiarioCuadrilla> tabInformeDiarioCuadrillaList;
    

    @Size(max = 2)
    @Column(name = "REQUIERE_AFORO")
    private String requiereAforo;
    @Size(max = 2)
    @Column(name = "REQUIERE_APIQUES")
    private String requiereApiques;
    @Size(max = 2)
    @Column(name = "RESPUESTA_AFORO")
    private String respuestaAforo;
    @Size(max = 2)
    @Column(name = "RESPUESTA_APIQUES")
    private String respuestaApiques;
   
    @Column(name = "ID_PERSONA_RESPONSABLE_VISITA")
    private Long idPersonaResponsableVisita;
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
    @Column(name = "ID_PERSONA_RESIDENTE_OBRA")
    private Long idPersonaResidenteObra;
    @Size(max = 50)
    @Column(name = "TIPO_ELEMENTO")
    private String tipoElemento;
    @Size(max = 50)
    @Column(name = "CODIGO_ACTIVIDAD_AGRUPADA")
    private String codigoActividadAgrupada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO_VIAL")
    private Long idMantenimientoVial;
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
    @Size(max = 600)
    @Column(name = "OBSERVACIONES_INTERVENCION")
    private String observacionesIntervencion;
    @Size(max = 2)
    @Column(name = "REQUIERE_ACTUALIZACION_DIAG")
    private String requiereActualizacionDiag;
    @Column(name = "ID_TIPO_PMT")
    private Long idTipoPmt;
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
    @Column(name = "INTERVENCION_HUECOS")
    private BigDecimal intervencionHuecos;
    @Column(name = "PUNTAJE_DPMR")
    private BigDecimal puntajeDpmr;
    @Column(name = "PUNTAJE_DPG")
    private BigDecimal puntajeDpg;
    @Column(name = "PUNTAJE_PETICION")
    private BigDecimal puntajePeticion;
    @Column(name = "PUNTAJE_SITIO_SOCIAL")
    private BigDecimal puntajeSitioSocial;
    @Column(name = "PUNTAJE_USO_SOCIAL")
    private BigDecimal puntajeUsoSocial;
    @Column(name = "PUNTAJE_DIMEN_SOCIAL")
    private BigDecimal puntajeDimenSocial;
    @Column(name = "PUNTAJE_USO_ECONOMICO")
    private BigDecimal puntajeUsoEconomico;
    @Column(name = "PUNTAJE_SITIO_ECONOM")
    private BigDecimal puntajeSitioEconom;
    @Column(name = "PUNTAJE_DIMEN_ECONOM")
    private BigDecimal puntajeDimenEconom;
    @Column(name = "PUNTAJE_MALLA")
    private BigDecimal puntajeMalla;
    @Column(name = "PUNTAJE_RUTAS")
    private BigDecimal puntajeRutas;
    @Column(name = "PUNTAJE_SINIEST")
    private BigDecimal puntajeSiniest;
    @Column(name = "PUNTAJE_DIMEN_TECNICA")
    private BigDecimal puntajeDimenTecnica;
    @Column(name = "PUNTAJE_IP")
    private BigDecimal puntajeIp;
    @Size(max = 50)
    @Column(name = "RANGOS_IP")
    private String rangosIp;
    @Column(name = "IP_RELATIVO")
    private BigDecimal ipRelativo;
    @Column(name = "PUNTAJE_IP_MAX")
    private BigDecimal puntajeIpMax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabMantenimientoVialH> tabMantenimientoVialHList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabOtroFactor> tabOtroFactorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabMantenimientoVialDocu> tabMantenimientoVialDocuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabRadicadoVinculado> tabRadicadoVinculadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabProgramacion> tabProgramacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabUnidadMuestreo> tabUnidadMuestreoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabElemento> tabElementoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimientoVial")
    private List<TabMantenimientoVialGestion> tabMantenimientoVialGestionList;
    
    public TabMantenimientoVial() {
    }

    public TabMantenimientoVial(Long idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
    }

    public TabMantenimientoVial(Long idMantenimientoVial, long idTipoOrigen, Date fecha, Date solicitudFecha, BigInteger pkIdCalzada, BigDecimal anchoPk, BigDecimal areaPk, BigDecimal longitudHorizontalPk, long idTipoEstadoPk, BigDecimal kmCarrilImpacto, String auditoriaUsuario, Date auditoriaFecha) {
        this.idMantenimientoVial = idMantenimientoVial;
        this.idTipoOrigen = idTipoOrigen;
        this.fecha = fecha;
        this.solicitudFecha = solicitudFecha;
        this.pkIdCalzada = pkIdCalzada;
        this.anchoPk = anchoPk;
        this.areaPk = areaPk;
        this.longitudHorizontalPk = longitudHorizontalPk;
        this.idTipoEstadoPk = idTipoEstadoPk;
        this.kmCarrilImpacto = kmCarrilImpacto;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdMantenimientoVial() {
        return idMantenimientoVial;
    }

    public void setIdMantenimientoVial(Long idMantenimientoVial) {
        this.idMantenimientoVial = idMantenimientoVial;
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

    public BigDecimal getIntervencionHuecos() {
        return intervencionHuecos;
    }

    public void setIntervencionHuecos(BigDecimal intervencionHuecos) {
        this.intervencionHuecos = intervencionHuecos;
    }

    public BigDecimal getPuntajeDpmr() {
        return puntajeDpmr;
    }

    public void setPuntajeDpmr(BigDecimal puntajeDpmr) {
        this.puntajeDpmr = puntajeDpmr;
    }

    public BigDecimal getPuntajeDpg() {
        return puntajeDpg;
    }

    public void setPuntajeDpg(BigDecimal puntajeDpg) {
        this.puntajeDpg = puntajeDpg;
    }

    public BigDecimal getPuntajePeticion() {
        return puntajePeticion;
    }

    public void setPuntajePeticion(BigDecimal puntajePeticion) {
        this.puntajePeticion = puntajePeticion;
    }

    public BigDecimal getPuntajeSitioSocial() {
        return puntajeSitioSocial;
    }

    public void setPuntajeSitioSocial(BigDecimal puntajeSitioSocial) {
        this.puntajeSitioSocial = puntajeSitioSocial;
    }

    public BigDecimal getPuntajeUsoSocial() {
        return puntajeUsoSocial;
    }

    public void setPuntajeUsoSocial(BigDecimal puntajeUsoSocial) {
        this.puntajeUsoSocial = puntajeUsoSocial;
    }

    public BigDecimal getPuntajeDimenSocial() {
        return puntajeDimenSocial;
    }

    public void setPuntajeDimenSocial(BigDecimal puntajeDimenSocial) {
        this.puntajeDimenSocial = puntajeDimenSocial;
    }

    public BigDecimal getPuntajeUsoEconomico() {
        return puntajeUsoEconomico;
    }

    public void setPuntajeUsoEconomico(BigDecimal puntajeUsoEconomico) {
        this.puntajeUsoEconomico = puntajeUsoEconomico;
    }

    public BigDecimal getPuntajeSitioEconom() {
        return puntajeSitioEconom;
    }

    public void setPuntajeSitioEconom(BigDecimal puntajeSitioEconom) {
        this.puntajeSitioEconom = puntajeSitioEconom;
    }

    public BigDecimal getPuntajeDimenEconom() {
        return puntajeDimenEconom;
    }

    public void setPuntajeDimenEconom(BigDecimal puntajeDimenEconom) {
        this.puntajeDimenEconom = puntajeDimenEconom;
    }

    public BigDecimal getPuntajeMalla() {
        return puntajeMalla;
    }

    public void setPuntajeMalla(BigDecimal puntajeMalla) {
        this.puntajeMalla = puntajeMalla;
    }

    public BigDecimal getPuntajeRutas() {
        return puntajeRutas;
    }

    public void setPuntajeRutas(BigDecimal puntajeRutas) {
        this.puntajeRutas = puntajeRutas;
    }

    public BigDecimal getPuntajeSiniest() {
        return puntajeSiniest;
    }

    public void setPuntajeSiniest(BigDecimal puntajeSiniest) {
        this.puntajeSiniest = puntajeSiniest;
    }

    public BigDecimal getPuntajeDimenTecnica() {
        return puntajeDimenTecnica;
    }

    public void setPuntajeDimenTecnica(BigDecimal puntajeDimenTecnica) {
        this.puntajeDimenTecnica = puntajeDimenTecnica;
    }

    public BigDecimal getPuntajeIp() {
        return puntajeIp;
    }

    public void setPuntajeIp(BigDecimal puntajeIp) {
        this.puntajeIp = puntajeIp;
    }

    public String getRangosIp() {
        return rangosIp;
    }

    public void setRangosIp(String rangosIp) {
        this.rangosIp = rangosIp;
    }

    public BigDecimal getIpRelativo() {
        return ipRelativo;
    }

    public void setIpRelativo(BigDecimal ipRelativo) {
        this.ipRelativo = ipRelativo;
    }

    public BigDecimal getPuntajeIpMax() {
        return puntajeIpMax;
    }

    public void setPuntajeIpMax(BigDecimal puntajeIpMax) {
        this.puntajeIpMax = puntajeIpMax;
    }

    @XmlTransient
    public List<TabMantenimientoVialH> getTabMantenimientoVialHList() {
        return tabMantenimientoVialHList;
    }

    public void setTabMantenimientoVialHList(List<TabMantenimientoVialH> tabMantenimientoVialHList) {
        this.tabMantenimientoVialHList = tabMantenimientoVialHList;
    }

    @XmlTransient
    public List<TabOtroFactor> getTabOtroFactorList() {
        return tabOtroFactorList;
    }

    public void setTabOtroFactorList(List<TabOtroFactor> tabOtroFactorList) {
        this.tabOtroFactorList = tabOtroFactorList;
    }

    @XmlTransient
    public List<TabMantenimientoVialDocu> getTabMantenimientoVialDocuList() {
        return tabMantenimientoVialDocuList;
    }

    public void setTabMantenimientoVialDocuList(List<TabMantenimientoVialDocu> tabMantenimientoVialDocuList) {
        this.tabMantenimientoVialDocuList = tabMantenimientoVialDocuList;
    }

    @XmlTransient
    public List<TabRadicadoVinculado> getTabRadicadoVinculadoList() {
        return tabRadicadoVinculadoList;
    }

    public void setTabRadicadoVinculadoList(List<TabRadicadoVinculado> tabRadicadoVinculadoList) {
        this.tabRadicadoVinculadoList = tabRadicadoVinculadoList;
    }
    
    @XmlTransient
    public List<TabProgramacion> getTabProgramacionList() {
        return tabProgramacionList;
    }

    public void setTabProgramacionList(List<TabProgramacion> tabProgramacionList) {
        this.tabProgramacionList = tabProgramacionList;
    }


    @XmlTransient
    public List<TabUnidadMuestreo> getTabUnidadMuestreoList() {
        return tabUnidadMuestreoList;
    }

    public void setTabUnidadMuestreoList(List<TabUnidadMuestreo> tabUnidadMuestreoList) {
        this.tabUnidadMuestreoList = tabUnidadMuestreoList;
    }

    @XmlTransient
    public List<TabElemento> getTabElementoList() {
        return tabElementoList;
    }

    public void setTabElementoList(List<TabElemento> tabElementoList) {
        this.tabElementoList = tabElementoList;
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
        hash += (idMantenimientoVial != null ? idMantenimientoVial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabMantenimientoVial)) {
            return false;
        }
        TabMantenimientoVial other = (TabMantenimientoVial) object;
        if ((this.idMantenimientoVial == null && other.idMantenimientoVial != null) || (this.idMantenimientoVial != null && !this.idMantenimientoVial.equals(other.idMantenimientoVial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVial[ idMantenimientoVial=" + idMantenimientoVial + " ]";
    }

    public Long getIdPersonaResponsableVisita() {
        return idPersonaResponsableVisita;
    }

    public void setIdPersonaResponsableVisita(Long idPersonaResponsableVisita) {
        this.idPersonaResponsableVisita = idPersonaResponsableVisita;
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

    public Long getIdPersonaResidenteObra() {
        return idPersonaResidenteObra;
    }

    public void setIdPersonaResidenteObra(Long idPersonaResidenteObra) {
        this.idPersonaResidenteObra = idPersonaResidenteObra;
    }

    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public String getCodigoActividadAgrupada() {
        return codigoActividadAgrupada;
    }

    public void setCodigoActividadAgrupada(String codigoActividadAgrupada) {
        this.codigoActividadAgrupada = codigoActividadAgrupada;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabMantenimientoVialEvento> getTabMantenimientoVialEventoList() {
        return tabMantenimientoVialEventoList;
    }

    public void setTabMantenimientoVialEventoList(List<TabMantenimientoVialEvento> tabMantenimientoVialEventoList) {
        this.tabMantenimientoVialEventoList = tabMantenimientoVialEventoList;
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

    public String getCoi() {
        return coi;
    }

    public void setCoi(String coi) {
        this.coi = coi;
    }

    public Date getFechaVisitaPredisenio() {
        return fechaVisitaPredisenio;
    }

    public void setFechaVisitaPredisenio(Date fechaVisitaPredisenio) {
        this.fechaVisitaPredisenio = fechaVisitaPredisenio;
    }

    public Date getFechaVisitaDisenio() {
        return fechaVisitaDisenio;
    }

    public void setFechaVisitaDisenio(Date fechaVisitaDisenio) {
        this.fechaVisitaDisenio = fechaVisitaDisenio;
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

    public String getNumeroRadicadoSdmPmt() {
        return numeroRadicadoSdmPmt;
    }

    public void setNumeroRadicadoSdmPmt(String numeroRadicadoSdmPmt) {
        this.numeroRadicadoSdmPmt = numeroRadicadoSdmPmt;
    }

    public Long getIdArchivoCoiPmt() {
        return idArchivoCoiPmt;
    }

    public void setIdArchivoCoiPmt(Long idArchivoCoiPmt) {
        this.idArchivoCoiPmt = idArchivoCoiPmt;
    }

    public String getObservacionesPmt() {
        return observacionesPmt;
    }

    public void setObservacionesPmt(String observacionesPmt) {
        this.observacionesPmt = observacionesPmt;
    }

    public Long getIdTipoEstadoObra() {
        return idTipoEstadoObra;
    }

    public void setIdTipoEstadoObra(Long idTipoEstadoObra) {
        this.idTipoEstadoObra = idTipoEstadoObra;
    }

    public Long getIdUnidadEjecutora() {
        return idUnidadEjecutora;
    }

    public void setIdUnidadEjecutora(Long idUnidadEjecutora) {
        this.idUnidadEjecutora = idUnidadEjecutora;
    }

    public Short getNumeroCarriles() {
        return numeroCarriles;
    }

    public void setNumeroCarriles(Short numeroCarriles) {
        this.numeroCarriles = numeroCarriles;
    }

    public Long getNumeroLosas() {
        return numeroLosas;
    }

    public void setNumeroLosas(Long numeroLosas) {
        this.numeroLosas = numeroLosas;
    }

    @XmlTransient
    @JsonIgnore
    public List<TabInformeDiarioCuadrilla> getTabInformeDiarioCuadrillaList() {
        return tabInformeDiarioCuadrillaList;
    }

    public void setTabInformeDiarioCuadrillaList(List<TabInformeDiarioCuadrilla> tabInformeDiarioCuadrillaList) {
        this.tabInformeDiarioCuadrillaList = tabInformeDiarioCuadrillaList;
    }

}
