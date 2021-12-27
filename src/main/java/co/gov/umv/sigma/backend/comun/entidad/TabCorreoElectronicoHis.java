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
@Table(name = "TAB_CORREO_ELECTRONICO_HIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabCorreoElectronicoHis.findAll", query = "SELECT t FROM TabCorreoElectronicoHis t"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByIdCorreoElectronico", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.idCorreoElectronico = :idCorreoElectronico"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByDestino", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.destino = :destino"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByFecha", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByAsunto", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.asunto = :asunto"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByMensaje", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.mensaje = :mensaje"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByEnviado", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.enviado = :enviado"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByFechaEnviado", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.fechaEnviado = :fechaEnviado"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByAuditoriaUsuario", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "TabCorreoElectronicoHis.findByAuditoriaFecha", query = "SELECT t FROM TabCorreoElectronicoHis t WHERE t.auditoriaFecha = :auditoriaFecha")})
public class TabCorreoElectronicoHis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CORREO_ELECTRONICO")
    private Long idCorreoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESTINO")
    private String destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ASUNTO")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ENVIADO")
    private String enviado;
    @Column(name = "FECHA_ENVIADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnviado;
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

    public TabCorreoElectronicoHis() {
    }

    public TabCorreoElectronicoHis(Long idCorreoElectronico) {
        this.idCorreoElectronico = idCorreoElectronico;
    }

    public TabCorreoElectronicoHis(Long idCorreoElectronico, String destino, Date fecha, String asunto, String mensaje, String enviado, String auditoriaUsuario, Date auditoriaFecha) {
        this.idCorreoElectronico = idCorreoElectronico;
        this.destino = destino;
        this.fecha = fecha;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.enviado = enviado;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
    }

    public Long getIdCorreoElectronico() {
        return idCorreoElectronico;
    }

    public void setIdCorreoElectronico(Long idCorreoElectronico) {
        this.idCorreoElectronico = idCorreoElectronico;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public Date getFechaEnviado() {
        return fechaEnviado;
    }

    public void setFechaEnviado(Date fechaEnviado) {
        this.fechaEnviado = fechaEnviado;
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
        hash += (idCorreoElectronico != null ? idCorreoElectronico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabCorreoElectronicoHis)) {
            return false;
        }
        TabCorreoElectronicoHis other = (TabCorreoElectronicoHis) object;
        if ((this.idCorreoElectronico == null && other.idCorreoElectronico != null) || (this.idCorreoElectronico != null && !this.idCorreoElectronico.equals(other.idCorreoElectronico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabCorreoElectronicoHis[ idCorreoElectronico=" + idCorreoElectronico + " ]";
    }
    
}
