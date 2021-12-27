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
@Table(name = "TAB_FORMATO_SECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabFormatoSeccion.findAll", query = "SELECT t FROM TabFormatoSeccion t"),
    @NamedQuery(name = "TabFormatoSeccion.findByIdFormatoSeccion", query = "SELECT t FROM TabFormatoSeccion t WHERE t.idFormatoSeccion = :idFormatoSeccion"),
    @NamedQuery(name = "TabFormatoSeccion.findByNombre", query = "SELECT t FROM TabFormatoSeccion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TabFormatoSeccion.findByOrden", query = "SELECT t FROM TabFormatoSeccion t WHERE t.orden = :orden"),
    @NamedQuery(name = "TabFormatoSeccion.findByRegistroActivo", query = "SELECT t FROM TabFormatoSeccion t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabFormatoSeccion.findByAuditoriaUsuario", query = "SELECT t FROM TabFormatoSeccion t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabFormatoSeccion.findByAuditoriaFecha", query = "SELECT t FROM TabFormatoSeccion t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabFormatoSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FORMATO_SECCION")
    private Long idFormatoSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @JoinColumn(name = "ID_FORMATO", referencedColumnName = "ID_FORMATO")
    @ManyToOne(optional = false)
    private TabFormato idFormato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormatoSeccion")
    private List<TabFormatoSeccionCampo> tabFormatoSeccionCampoList;

    public TabFormatoSeccion() {
    }

    public TabFormatoSeccion(Long idFormatoSeccion) {
        this.idFormatoSeccion = idFormatoSeccion;
    }

    public TabFormatoSeccion(Long idFormatoSeccion, String nombre, long orden, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idFormatoSeccion = idFormatoSeccion;
        this.nombre = nombre;
        this.orden = orden;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdFormatoSeccion() {
        return idFormatoSeccion;
    }

    public void setIdFormatoSeccion(Long idFormatoSeccion) {
        this.idFormatoSeccion = idFormatoSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public TabFormato getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(TabFormato idFormato) {
        this.idFormato = idFormato;
    }

    @XmlTransient
    public List<TabFormatoSeccionCampo> getTabFormatoSeccionCampoList() {
        return tabFormatoSeccionCampoList;
    }

    public void setTabFormatoSeccionCampoList(List<TabFormatoSeccionCampo> tabFormatoSeccionCampoList) {
        this.tabFormatoSeccionCampoList = tabFormatoSeccionCampoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormatoSeccion != null ? idFormatoSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabFormatoSeccion)) {
            return false;
        }
        TabFormatoSeccion other = (TabFormatoSeccion) object;
        if ((this.idFormatoSeccion == null && other.idFormatoSeccion != null) || (this.idFormatoSeccion != null && !this.idFormatoSeccion.equals(other.idFormatoSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabFormatoSeccion[ idFormatoSeccion=" + idFormatoSeccion + " ]";
    }
    
}
