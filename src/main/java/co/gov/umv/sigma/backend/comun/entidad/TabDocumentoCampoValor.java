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
@Table(name = "TAB_DOCUMENTO_CAMPO_VALOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabDocumentoCampoValor.findAll", query = "SELECT t FROM TabDocumentoCampoValor t"),
    @NamedQuery(name = "TabDocumentoCampoValor.findByIdDocumentoCampoValor", query = "SELECT t FROM TabDocumentoCampoValor t WHERE t.idDocumentoCampoValor = :idDocumentoCampoValor"),
    @NamedQuery(name = "TabDocumentoCampoValor.findByValor", query = "SELECT t FROM TabDocumentoCampoValor t WHERE t.valor = :valor"),
    @NamedQuery(name = "TabDocumentoCampoValor.findByAuditoriaUsuario", query = "SELECT t FROM TabDocumentoCampoValor t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabDocumentoCampoValor.findByAuditoriaFecha", query = "SELECT t FROM TabDocumentoCampoValor t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabDocumentoCampoValor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO_CAMPO_VALOR")
    private Long idDocumentoCampoValor;
    @Size(max = 2000)
    @Column(name = "VALOR")
    private String valor;
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
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @ManyToOne(optional = false)
    private TabDocumento idDocumento;
    @JoinColumn(name = "ID_FORMATO_SECCION_CAMPO", referencedColumnName = "ID_FORMATO_SECCION_CAMPO")
    @ManyToOne(optional = false)
    private TabFormatoSeccionCampo idFormatoSeccionCampo;

    public TabDocumentoCampoValor() {
    }

    public TabDocumentoCampoValor(Long idDocumentoCampoValor) {
        this.idDocumentoCampoValor = idDocumentoCampoValor;
    }

    public TabDocumentoCampoValor(Long idDocumentoCampoValor, String auditoriaUsuario, Date auditoriaFecha) {
        this.idDocumentoCampoValor = idDocumentoCampoValor;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdDocumentoCampoValor() {
        return idDocumentoCampoValor;
    }

    public void setIdDocumentoCampoValor(Long idDocumentoCampoValor) {
        this.idDocumentoCampoValor = idDocumentoCampoValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    public TabDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(TabDocumento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public TabFormatoSeccionCampo getIdFormatoSeccionCampo() {
        return idFormatoSeccionCampo;
    }

    public void setIdFormatoSeccionCampo(TabFormatoSeccionCampo idFormatoSeccionCampo) {
        this.idFormatoSeccionCampo = idFormatoSeccionCampo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoCampoValor != null ? idDocumentoCampoValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabDocumentoCampoValor)) {
            return false;
        }
        TabDocumentoCampoValor other = (TabDocumentoCampoValor) object;
        if ((this.idDocumentoCampoValor == null && other.idDocumentoCampoValor != null) || (this.idDocumentoCampoValor != null && !this.idDocumentoCampoValor.equals(other.idDocumentoCampoValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabDocumentoCampoValor[ idDocumentoCampoValor=" + idDocumentoCampoValor + " ]";
    }
    
}
