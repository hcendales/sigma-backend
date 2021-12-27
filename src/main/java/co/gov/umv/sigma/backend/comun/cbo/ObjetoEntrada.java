/*
 * Objeto generico de Entrada
 */

package co.gov.umv.sigma.backend.comun.cbo;

import javax.xml.bind.annotation.XmlElement;

public class ObjetoEntrada extends ObjetoGenerico {

    @XmlElement
    private Integer idUsuario;
    @XmlElement
    private String usuario;
    @XmlElement
    private String filtro;
    @XmlElement
    private String nombreCampo;
    @XmlElement
    private String valorCampo;
    
    
    public Integer getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {

        this.idUsuario = idUsuario;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public String getValorCampo() {
		return valorCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public void setValorCampo(String valorCampo) {
		this.valorCampo = valorCampo;
	}
}
