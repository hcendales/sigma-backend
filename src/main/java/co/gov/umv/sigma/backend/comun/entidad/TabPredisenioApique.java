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
@Table(name = "TAB_PREDISENIO_APIQUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabPredisenioApique.findAll", query = "SELECT t FROM TabPredisenioApique t"),
    @NamedQuery(name = "TabPredisenioApique.findByIdPredisenioApique", query = "SELECT t FROM TabPredisenioApique t WHERE t.idPredisenioApique = :idPredisenioApique"),
    @NamedQuery(name = "TabPredisenioApique.findByNomenclatura", query = "SELECT t FROM TabPredisenioApique t WHERE t.nomenclatura = :nomenclatura"),
    @NamedQuery(name = "TabPredisenioApique.findByObservacion", query = "SELECT t FROM TabPredisenioApique t WHERE t.observacion = :observacion"),
    @NamedQuery(name = "TabPredisenioApique.findByIdDocumentoResultadoApiques", query = "SELECT t FROM TabPredisenioApique t WHERE t.idDocumentoResultadoApiques = :idDocumentoResultadoApiques"),
    @NamedQuery(name = "TabPredisenioApique.findByAuditoriaUsuario", query = "SELECT t FROM TabPredisenioApique t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabPredisenioApique.findByAuditoriaFecha", query = "SELECT t FROM TabPredisenioApique t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabPredisenioApique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PREDISENIO_APIQUE")
    private Long idPredisenioApique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMENCLATURA")
    private String nomenclatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ID_DOCUMENTO_RESULTADO_APIQUES")
    private Long idDocumentoResultadoApiques;
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
    @JoinColumn(name = "ID_MANTENIMIENTO_VIAL_EVENTO", referencedColumnName = "ID_MANTENIMIENTO_VIAL_EVENTO")
    @ManyToOne(optional = false)
    private TabMantenimientoVialEvento mantenimientoVialEvento;

    public TabPredisenioApique() {
    }

    public TabPredisenioApique(Long idPredisenioApique) {
        this.idPredisenioApique = idPredisenioApique;
    }

    public TabPredisenioApique(Long idPredisenioApique, String nomenclatura, String observacion, String auditoriaUsuario, Date auditoriaFecha) {
        this.idPredisenioApique = idPredisenioApique;
        this.nomenclatura = nomenclatura;
        this.observacion = observacion;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdPredisenioApique() {
        return idPredisenioApique;
    }

    public void setIdPredisenioApique(Long idPredisenioApique) {
        this.idPredisenioApique = idPredisenioApique;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getIdDocumentoResultadoApiques() {
        return idDocumentoResultadoApiques;
    }

    public void setIdDocumentoResultadoApiques(Long idDocumentoResultadoApiques) {
        this.idDocumentoResultadoApiques = idDocumentoResultadoApiques;
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

  

    public TabMantenimientoVialEvento getMantenimientoVialEvento() {
		return mantenimientoVialEvento;
	}

	public void setMantenimientoVialEvento(TabMantenimientoVialEvento mantenimientoVialEvento) {
		this.mantenimientoVialEvento = mantenimientoVialEvento;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPredisenioApique != null ? idPredisenioApique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabPredisenioApique)) {
            return false;
        }
        TabPredisenioApique other = (TabPredisenioApique) object;
        if ((this.idPredisenioApique == null && other.idPredisenioApique != null) || (this.idPredisenioApique != null && !this.idPredisenioApique.equals(other.idPredisenioApique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabPredisenioApique[ idPredisenioApique=" + idPredisenioApique + " ]";
    }
    
}
