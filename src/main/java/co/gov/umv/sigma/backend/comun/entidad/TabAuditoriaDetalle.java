/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_AUDITORIA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabAuditoriaDetalle.findAll", query = "SELECT t FROM TabAuditoriaDetalle t"),
    @NamedQuery(name = "TabAuditoriaDetalle.findByIdAuditoriaDetalle", query = "SELECT t FROM TabAuditoriaDetalle t WHERE t.idAuditoriaDetalle = :idAuditoriaDetalle"),
    @NamedQuery(name = "TabAuditoriaDetalle.findByColumna", query = "SELECT t FROM TabAuditoriaDetalle t WHERE t.columna = :columna"),
    @NamedQuery(name = "TabAuditoriaDetalle.findByValorAntes", query = "SELECT t FROM TabAuditoriaDetalle t WHERE t.valorAntes = :valorAntes"),
    @NamedQuery(name = "TabAuditoriaDetalle.findByValorDespues", query = "SELECT t FROM TabAuditoriaDetalle t WHERE t.valorDespues = :valorDespues")})
public class TabAuditoriaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AUDITORIA_DETALLE")
    private Long idAuditoriaDetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COLUMNA")
    private String columna;
    @Size(max = 2000)
    @Column(name = "VALOR_ANTES")
    private String valorAntes;
    @Size(max = 2000)
    @Column(name = "VALOR_DESPUES")
    private String valorDespues;
    @JoinColumn(name = "ID_AUDITORIA", referencedColumnName = "ID_AUDITORIA")
    @ManyToOne(optional = false)
    private TabAuditoria idAuditoria;

    public TabAuditoriaDetalle() {
    }

    public TabAuditoriaDetalle(Long idAuditoriaDetalle) {
        this.idAuditoriaDetalle = idAuditoriaDetalle;
    }

    public TabAuditoriaDetalle(Long idAuditoriaDetalle, String columna) {
        this.idAuditoriaDetalle = idAuditoriaDetalle;
        this.columna = columna;
    }

    public Long getIdAuditoriaDetalle() {
        return idAuditoriaDetalle;
    }

    public void setIdAuditoriaDetalle(Long idAuditoriaDetalle) {
        this.idAuditoriaDetalle = idAuditoriaDetalle;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getValorAntes() {
        return valorAntes;
    }

    public void setValorAntes(String valorAntes) {
        this.valorAntes = valorAntes;
    }

    public String getValorDespues() {
        return valorDespues;
    }

    public void setValorDespues(String valorDespues) {
        this.valorDespues = valorDespues;
    }

    public TabAuditoria getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(TabAuditoria idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoriaDetalle != null ? idAuditoriaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAuditoriaDetalle)) {
            return false;
        }
        TabAuditoriaDetalle other = (TabAuditoriaDetalle) object;
        if ((this.idAuditoriaDetalle == null && other.idAuditoriaDetalle != null) || (this.idAuditoriaDetalle != null && !this.idAuditoriaDetalle.equals(other.idAuditoriaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabAuditoriaDetalle[ idAuditoriaDetalle=" + idAuditoriaDetalle + " ]";
    }
    
}
