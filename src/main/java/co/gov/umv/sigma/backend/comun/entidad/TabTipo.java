/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
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
@Table(name = "TAB_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabTipo.findAll", query = "SELECT t FROM TabTipo t"),
    @NamedQuery(name = "TabTipo.findByIdTipo", query = "SELECT t FROM TabTipo t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TabTipo.findByValor", query = "SELECT t FROM TabTipo t WHERE t.valor = :valor"),
    @NamedQuery(name = "TabTipo.findByDescripcion", query = "SELECT t FROM TabTipo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TabTipo.findByRegistroActivo", query = "SELECT t FROM TabTipo t WHERE t.registroActivo = :registroActivo"),
    @NamedQuery(name = "TabTipo.findByAuditoriaUsuario", query = "SELECT t FROM TabTipo t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabTipo.findByAuditoriaFecha", query = "SELECT t FROM TabTipo t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO")
    private Long idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VALOR")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "DESCRIPCION")
    private String descripcion;
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
    @JoinColumn(name = "ID_LISTA", referencedColumnName = "ID_LISTA")
    @ManyToOne(optional = false)
    private TabLista idLista;

    public TabTipo() {
    }

    public TabTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public TabTipo(Long idTipo, String valor, String descripcion, String registroActivo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idTipo = idTipo;
        this.valor = valor;
        this.descripcion = descripcion;
        this.registroActivo = registroActivo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public TabLista getIdLista() {
        return idLista;
    }

    public void setIdLista(TabLista idLista) {
        this.idLista = idLista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabTipo)) {
            return false;
        }
        TabTipo other = (TabTipo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabTipo[ idTipo=" + idTipo + " ]";
    }
    
}
