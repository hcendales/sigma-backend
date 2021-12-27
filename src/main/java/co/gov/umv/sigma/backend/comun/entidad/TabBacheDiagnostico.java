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
@Table(name = "TAB_BACHE_DIAGNOSTICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabBacheDiagnostico.findAll", query = "SELECT t FROM TabBacheDiagnostico t"),
    @NamedQuery(name = "TabBacheDiagnostico.findByIdBacheDiagnostico", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.idBacheDiagnostico = :idBacheDiagnostico"),
    @NamedQuery(name = "TabBacheDiagnostico.findByIdBache", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.idBache = :idBache"),
    @NamedQuery(name = "TabBacheDiagnostico.findByFechaVisita", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.fechaVisita = :fechaVisita"),
    @NamedQuery(name = "TabBacheDiagnostico.findByNParche", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.nParche = :nParche"),
    @NamedQuery(name = "TabBacheDiagnostico.findByRespVisita", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.respVisita = :respVisita"),
    @NamedQuery(name = "TabBacheDiagnostico.findByPlacaDeR", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.placaDeR = :placaDeR"),
    @NamedQuery(name = "TabBacheDiagnostico.findByIdTipoEstadoBache", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.idTipoEstadoBache = :idTipoEstadoBache"),
    @NamedQuery(name = "TabBacheDiagnostico.findByObservaci", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.observaci = :observaci"),
    @NamedQuery(name = "TabBacheDiagnostico.findByFechaDeI", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.fechaDeI = :fechaDeI"),
    @NamedQuery(name = "TabBacheDiagnostico.findByResponInter", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.responInter = :responInter"),
    @NamedQuery(name = "TabBacheDiagnostico.findByNDeRec", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.nDeRec = :nDeRec"),
    @NamedQuery(name = "TabBacheDiagnostico.findByNDeHue", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.nDeHue = :nDeHue"),
    @NamedQuery(name = "TabBacheDiagnostico.findByLongitudD", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.longitudD = :longitudD"),
    @NamedQuery(name = "TabBacheDiagnostico.findByAnchoDeI", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.anchoDeI = :anchoDeI"),
    @NamedQuery(name = "TabBacheDiagnostico.findByIdTransfer", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.idTransfer = :idTransfer"),
    @NamedQuery(name = "TabBacheDiagnostico.findByAreaD", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.areaD = :areaD"),
    @NamedQuery(name = "TabBacheDiagnostico.findByTIntervencion", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.tIntervencion = :tIntervencion"),
    @NamedQuery(name = "TabBacheDiagnostico.findByIdTipoPrograma", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.idTipoPrograma = :idTipoPrograma"),
    @NamedQuery(name = "TabBacheDiagnostico.findByIdHuecoT", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.idHuecoT = :idHuecoT"),
    @NamedQuery(name = "TabBacheDiagnostico.findByAuditoriaUsuario", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabBacheDiagnostico.findByAuditoriaFecha", query = "SELECT t FROM TabBacheDiagnostico t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabBacheDiagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BACHE_DIAGNOSTICO")
    private Long idBacheDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BACHE")
    private long idBache;
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Column(name = "N_PARCHE")
    private BigInteger nParche;
    @Column(name = "RESP_VISITA")
    private Long respVisita;
    @Size(max = 254)
    @Column(name = "PLACA_DE_R")
    private String placaDeR;
    @Column(name = "ID_TIPO_ESTADO_BACHE")
    private Long idTipoEstadoBache;
    @Size(max = 254)
    @Column(name = "OBSERVACI")
    private String observaci;
    @Column(name = "FECHA_DE_I")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeI;
    @Column(name = "RESPON_INTER")
    private Long responInter;
    @Size(max = 254)
    @Column(name = "N_DE_REC")
    private String nDeRec;
    @Column(name = "N_DE_HUE")
    private BigInteger nDeHue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUD_D")
    private BigDecimal longitudD;
    @Column(name = "ANCHO_DE_I")
    private BigDecimal anchoDeI;
    @Size(max = 50)
    @Column(name = "ID_TRANSFER")
    private String idTransfer;
    @Column(name = "AREA_D")
    private BigDecimal areaD;
    @Size(max = 255)
    @Column(name = "T_INTERVENCION")
    private String tIntervencion;
    @Column(name = "ID_TIPO_PROGRAMA")
    private Long idTipoPrograma;
    @Column(name = "ID_HUECO_T")
    private BigInteger idHuecoT;
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

    public TabBacheDiagnostico() {
    }

    public TabBacheDiagnostico(Long idBacheDiagnostico) {
        this.idBacheDiagnostico = idBacheDiagnostico;
    }

    public TabBacheDiagnostico(Long idBacheDiagnostico, long idBache, String auditoriaUsuario, Date auditoriaFecha) {
        this.idBacheDiagnostico = idBacheDiagnostico;
        this.idBache = idBache;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdBacheDiagnostico() {
        return idBacheDiagnostico;
    }

    public void setIdBacheDiagnostico(Long idBacheDiagnostico) {
        this.idBacheDiagnostico = idBacheDiagnostico;
    }

    public long getIdBache() {
        return idBache;
    }

    public void setIdBache(long idBache) {
        this.idBache = idBache;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public BigInteger getNParche() {
        return nParche;
    }

    public void setNParche(BigInteger nParche) {
        this.nParche = nParche;
    }

    public Long getRespVisita() {
        return respVisita;
    }

    public void setRespVisita(Long respVisita) {
        this.respVisita = respVisita;
    }

    public String getPlacaDeR() {
        return placaDeR;
    }

    public void setPlacaDeR(String placaDeR) {
        this.placaDeR = placaDeR;
    }

    public Long getIdTipoEstadoBache() {
        return idTipoEstadoBache;
    }

    public void setIdTipoEstadoBache(Long idTipoEstadoBache) {
        this.idTipoEstadoBache = idTipoEstadoBache;
    }

    public String getObservaci() {
        return observaci;
    }

    public void setObservaci(String observaci) {
        this.observaci = observaci;
    }

    public Date getFechaDeI() {
        return fechaDeI;
    }

    public void setFechaDeI(Date fechaDeI) {
        this.fechaDeI = fechaDeI;
    }

    public Long getResponInter() {
        return responInter;
    }

    public void setResponInter(Long responInter) {
        this.responInter = responInter;
    }

    public String getNDeRec() {
        return nDeRec;
    }

    public void setNDeRec(String nDeRec) {
        this.nDeRec = nDeRec;
    }

    public BigInteger getNDeHue() {
        return nDeHue;
    }

    public void setNDeHue(BigInteger nDeHue) {
        this.nDeHue = nDeHue;
    }

    public BigDecimal getLongitudD() {
        return longitudD;
    }

    public void setLongitudD(BigDecimal longitudD) {
        this.longitudD = longitudD;
    }

    public BigDecimal getAnchoDeI() {
        return anchoDeI;
    }

    public void setAnchoDeI(BigDecimal anchoDeI) {
        this.anchoDeI = anchoDeI;
    }

    public String getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(String idTransfer) {
        this.idTransfer = idTransfer;
    }

    public BigDecimal getAreaD() {
        return areaD;
    }

    public void setAreaD(BigDecimal areaD) {
        this.areaD = areaD;
    }

    public String getTIntervencion() {
        return tIntervencion;
    }

    public void setTIntervencion(String tIntervencion) {
        this.tIntervencion = tIntervencion;
    }

    public Long getIdTipoPrograma() {
        return idTipoPrograma;
    }

    public void setIdTipoPrograma(Long idTipoPrograma) {
        this.idTipoPrograma = idTipoPrograma;
    }

    public BigInteger getIdHuecoT() {
        return idHuecoT;
    }

    public void setIdHuecoT(BigInteger idHuecoT) {
        this.idHuecoT = idHuecoT;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBacheDiagnostico != null ? idBacheDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabBacheDiagnostico)) {
            return false;
        }
        TabBacheDiagnostico other = (TabBacheDiagnostico) object;
        if ((this.idBacheDiagnostico == null && other.idBacheDiagnostico != null) || (this.idBacheDiagnostico != null && !this.idBacheDiagnostico.equals(other.idBacheDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabBacheDiagnostico[ idBacheDiagnostico=" + idBacheDiagnostico + " ]";
    }
    
}
