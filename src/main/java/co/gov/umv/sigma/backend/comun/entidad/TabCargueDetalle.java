/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "TAB_CARGUE_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabCargueDetalle.findAll", query = "SELECT t FROM TabCargueDetalle t"),
    @NamedQuery(name = "TabCargueDetalle.findByIdCargueDetalle", query = "SELECT t FROM TabCargueDetalle t WHERE t.idCargueDetalle = :idCargueDetalle"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo1", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo1 = :campo1"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo2", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo2 = :campo2"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo3", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo3 = :campo3"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo4", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo4 = :campo4"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo5", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo5 = :campo5"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo6", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo6 = :campo6"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo7", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo7 = :campo7"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo8", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo8 = :campo8"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo9", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo9 = :campo9"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo10", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo10 = :campo10"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo11", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo11 = :campo11"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo12", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo12 = :campo12"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo13", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo13 = :campo13"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo14", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo14 = :campo14"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo15", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo15 = :campo15"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo16", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo16 = :campo16"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo17", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo17 = :campo17"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo18", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo18 = :campo18"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo19", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo19 = :campo19"),
    @NamedQuery(name = "TabCargueDetalle.findByCampo20", query = "SELECT t FROM TabCargueDetalle t WHERE t.campo20 = :campo20")})
public class TabCargueDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGUE_DETALLE")
    private Long idCargueDetalle;
    @Size(max = 800)
    @Column(name = "CAMPO_1")
    private String campo1;
    @Size(max = 800)
    @Column(name = "CAMPO_2")
    private String campo2;
    @Size(max = 800)
    @Column(name = "CAMPO_3")
    private String campo3;
    @Size(max = 800)
    @Column(name = "CAMPO_4")
    private String campo4;
    @Size(max = 800)
    @Column(name = "CAMPO_5")
    private String campo5;
    @Size(max = 800)
    @Column(name = "CAMPO_6")
    private String campo6;
    @Size(max = 800)
    @Column(name = "CAMPO_7")
    private String campo7;
    @Size(max = 800)
    @Column(name = "CAMPO_8")
    private String campo8;
    @Size(max = 800)
    @Column(name = "CAMPO_9")
    private String campo9;
    @Size(max = 800)
    @Column(name = "CAMPO_10")
    private String campo10;
    @Size(max = 800)
    @Column(name = "CAMPO_11")
    private String campo11;
    @Size(max = 800)
    @Column(name = "CAMPO_12")
    private String campo12;
    @Size(max = 800)
    @Column(name = "CAMPO_13")
    private String campo13;
    @Size(max = 800)
    @Column(name = "CAMPO_14")
    private String campo14;
    @Size(max = 800)
    @Column(name = "CAMPO_15")
    private String campo15;
    @Size(max = 800)
    @Column(name = "CAMPO_16")
    private String campo16;
    @Size(max = 800)
    @Column(name = "CAMPO_17")
    private String campo17;
    @Size(max = 800)
    @Column(name = "CAMPO_18")
    private String campo18;
    @Size(max = 800)
    @Column(name = "CAMPO_19")
    private String campo19;
    @Size(max = 800)
    @Column(name = "CAMPO_20")
    private String campo20;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargueDetalle")
    private List<TabCargueDetalleLog> tabCargueDetalleLogList;
    @JoinColumn(name = "ID_CARGUE", referencedColumnName = "ID_CARGUE")
    @ManyToOne(optional = false)
    private TabCargue idCargue;

    public TabCargueDetalle() {
    }

    public TabCargueDetalle(Long idCargueDetalle) {
        this.idCargueDetalle = idCargueDetalle;
    }

    public Long getIdCargueDetalle() {
        return idCargueDetalle;
    }

    public void setIdCargueDetalle(Long idCargueDetalle) {
        this.idCargueDetalle = idCargueDetalle;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getCampo9() {
        return campo9;
    }

    public void setCampo9(String campo9) {
        this.campo9 = campo9;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public String getCampo11() {
        return campo11;
    }

    public void setCampo11(String campo11) {
        this.campo11 = campo11;
    }

    public String getCampo12() {
        return campo12;
    }

    public void setCampo12(String campo12) {
        this.campo12 = campo12;
    }

    public String getCampo13() {
        return campo13;
    }

    public void setCampo13(String campo13) {
        this.campo13 = campo13;
    }

    public String getCampo14() {
        return campo14;
    }

    public void setCampo14(String campo14) {
        this.campo14 = campo14;
    }

    public String getCampo15() {
        return campo15;
    }

    public void setCampo15(String campo15) {
        this.campo15 = campo15;
    }

    public String getCampo16() {
        return campo16;
    }

    public void setCampo16(String campo16) {
        this.campo16 = campo16;
    }

    public String getCampo17() {
        return campo17;
    }

    public void setCampo17(String campo17) {
        this.campo17 = campo17;
    }

    public String getCampo18() {
        return campo18;
    }

    public void setCampo18(String campo18) {
        this.campo18 = campo18;
    }

    public String getCampo19() {
        return campo19;
    }

    public void setCampo19(String campo19) {
        this.campo19 = campo19;
    }

    public String getCampo20() {
        return campo20;
    }

    public void setCampo20(String campo20) {
        this.campo20 = campo20;
    }

    @XmlTransient
    public List<TabCargueDetalleLog> getTabCargueDetalleLogList() {
        return tabCargueDetalleLogList;
    }

    public void setTabCargueDetalleLogList(List<TabCargueDetalleLog> tabCargueDetalleLogList) {
        this.tabCargueDetalleLogList = tabCargueDetalleLogList;
    }

    public TabCargue getIdCargue() {
        return idCargue;
    }

    public void setIdCargue(TabCargue idCargue) {
        this.idCargue = idCargue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargueDetalle != null ? idCargueDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabCargueDetalle)) {
            return false;
        }
        TabCargueDetalle other = (TabCargueDetalle) object;
        if ((this.idCargueDetalle == null && other.idCargueDetalle != null) || (this.idCargueDetalle != null && !this.idCargueDetalle.equals(other.idCargueDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.umv.sigma.backend.comun.entidad.TabCargueDetalle[ idCargueDetalle=" + idCargueDetalle + " ]";
    }
    
}
