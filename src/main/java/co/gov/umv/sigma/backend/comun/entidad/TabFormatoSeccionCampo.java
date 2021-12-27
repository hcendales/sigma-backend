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

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_FORMATO_SECCION_CAMPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabFormatoSeccionCampo.findAll", query = "SELECT t FROM TabFormatoSeccionCampo t"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByIdFormatoSeccionCampo", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.idFormatoSeccionCampo = :idFormatoSeccionCampo"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByNombre", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByIdTipoCampo", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.idTipoCampo = :idTipoCampo"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByIdLista", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.idLista = :idLista"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByOrden", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.orden = :orden"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByRegistroActivo", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByAuditoriaUsuario", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabFormatoSeccionCampo.findByAuditoriaFecha", query = "SELECT t FROM TabFormatoSeccionCampo t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabFormatoSeccionCampo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FORMATO_SECCION_CAMPO")
    private Long idFormatoSeccionCampo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CAMPO")
    private long idTipoCampo;
    @Column(name = "ID_LISTA")
    private Long idLista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN")
    private long orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REGISTRO_ACTIVO")
    private String registroActivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormatoSeccionCampo")
    private List<TabDocumentoCampoValor> tabDocumentoCampoValorList;
    @JoinColumn(name = "ID_FORMATO_SECCION", referencedColumnName = "ID_FORMATO_SECCION")
    @ManyToOne(optional = false)
    private TabFormatoSeccion idFormatoSeccion;

    public TabFormatoSeccionCampo() {
    }

    public TabFormatoSeccionCampo(Long idFormatoSeccionCampo) {
        this.idFormatoSeccionCampo = idFormatoSeccionCampo;
    }

    public TabFormatoSeccionCampo(Long idFormatoSeccionCampo, String nombre, long idTipoCampo, long orden, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idFormatoSeccionCampo = idFormatoSeccionCampo;
        this.nombre = nombre;
        this.idTipoCampo = idTipoCampo;
        this.orden = orden;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdFormatoSeccionCampo() {
        return idFormatoSeccionCampo;
    }

    public void setIdFormatoSeccionCampo(Long idFormatoSeccionCampo) {
        this.idFormatoSeccionCampo = idFormatoSeccionCampo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdTipoCampo() {
        return idTipoCampo;
    }

    public void setIdTipoCampo(long idTipoCampo) {
        this.idTipoCampo = idTipoCampo;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
    }

    public String getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(String registroActivo) {
        this.registroActivo = registroActivo;
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
    public List<TabDocumentoCampoValor> getTabDocumentoCampoValorList() {
        return tabDocumentoCampoValorList;
    }

    public void setTabDocumentoCampoValorList(List<TabDocumentoCampoValor> tabDocumentoCampoValorList) {
        this.tabDocumentoCampoValorList = tabDocumentoCampoValorList;
    }

    public TabFormatoSeccion getIdFormatoSeccion() {
        return idFormatoSeccion;
    }

    public void setIdFormatoSeccion(TabFormatoSeccion idFormatoSeccion) {
        this.idFormatoSeccion = idFormatoSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormatoSeccionCampo != null ? idFormatoSeccionCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabFormatoSeccionCampo)) {
            return false;
        }
        TabFormatoSeccionCampo other = (TabFormatoSeccionCampo) object;
        if ((this.idFormatoSeccionCampo == null && other.idFormatoSeccionCampo != null) || (this.idFormatoSeccionCampo != null && !this.idFormatoSeccionCampo.equals(other.idFormatoSeccionCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabFormatoSeccionCampo[ idFormatoSeccionCampo=" + idFormatoSeccionCampo + " ]";
    }
    
}
