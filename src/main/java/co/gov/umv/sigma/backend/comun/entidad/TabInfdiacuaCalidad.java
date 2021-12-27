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
@Table(name = "TAB_INFDIACUA_CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabInfdiacuaCalidad.findAll", query = "SELECT t FROM TabInfdiacuaCalidad t"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByIdInfdiacuaCalidad", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.idInfdiacuaCalidad = :idInfdiacuaCalidad"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByNumeroMuestrasTomadas", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.numeroMuestrasTomadas = :numeroMuestrasTomadas"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByIdTipoMaterial", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByIdTipoEnsayo", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.idTipoEnsayo = :idTipoEnsayo"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByResultado", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.resultado = :resultado"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByAuditoriaUsuario", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabInfdiacuaCalidad.findByAuditoriaFecha", query = "SELECT t FROM TabInfdiacuaCalidad t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabInfdiacuaCalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFDIACUA_CALIDAD")
    private Long idInfdiacuaCalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_MUESTRAS_TOMADAS")
    private short numeroMuestrasTomadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_MATERIAL")
    private long idTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ENSAYO")
    private long idTipoEnsayo;
    @Size(max = 600)
    @Column(name = "RESULTADO")
    private String resultado;
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
    @JoinColumn(name = "ID_INFORME_DIARIO_CUADRILLA", referencedColumnName = "ID_INFORME_DIARIO_CUADRILLA")
    @ManyToOne(optional = false)
    private Long idInformeDiarioCuadrilla;

    public TabInfdiacuaCalidad() {
    }

    public TabInfdiacuaCalidad(Long idInfdiacuaCalidad) {
        this.idInfdiacuaCalidad = idInfdiacuaCalidad;
    }

    public TabInfdiacuaCalidad(Long idInfdiacuaCalidad, short numeroMuestrasTomadas, long idTipoMaterial, long idTipoEnsayo, String auditoriaUsuario, Date auditoriaFecha) {
        this.idInfdiacuaCalidad = idInfdiacuaCalidad;
        this.numeroMuestrasTomadas = numeroMuestrasTomadas;
        this.idTipoMaterial = idTipoMaterial;
        this.idTipoEnsayo = idTipoEnsayo;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdInfdiacuaCalidad() {
        return idInfdiacuaCalidad;
    }

    public void setIdInfdiacuaCalidad(Long idInfdiacuaCalidad) {
        this.idInfdiacuaCalidad = idInfdiacuaCalidad;
    }

    public short getNumeroMuestrasTomadas() {
        return numeroMuestrasTomadas;
    }

    public void setNumeroMuestrasTomadas(short numeroMuestrasTomadas) {
        this.numeroMuestrasTomadas = numeroMuestrasTomadas;
    }

    public long getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(long idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public long getIdTipoEnsayo() {
        return idTipoEnsayo;
    }

    public void setIdTipoEnsayo(long idTipoEnsayo) {
        this.idTipoEnsayo = idTipoEnsayo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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

    public Long getIdInformeDiarioCuadrilla() {
        return idInformeDiarioCuadrilla;
    }

    public void setIdInformeDiarioCuadrilla(Long idInformeDiarioCuadrilla) {
        this.idInformeDiarioCuadrilla = idInformeDiarioCuadrilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfdiacuaCalidad != null ? idInfdiacuaCalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabInfdiacuaCalidad)) {
            return false;
        }
        TabInfdiacuaCalidad other = (TabInfdiacuaCalidad) object;
        if ((this.idInfdiacuaCalidad == null && other.idInfdiacuaCalidad != null) || (this.idInfdiacuaCalidad != null && !this.idInfdiacuaCalidad.equals(other.idInfdiacuaCalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaCalidad[ idInfdiacuaCalidad=" + idInfdiacuaCalidad + " ]";
    }
    
}
