/*
 * Objeto generico de Salida
 */

package co.gov.umv.sigma.backend.comun.cbo;

import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ObjetoSalida extends ObjetoGenerico {

    @XmlElement
    private Long idUsuario;

    @XmlElement
    private CodError codError = CodError.OPERACION_CORRECTA;

    @XmlElement
    private String msgError;

    @XmlElement
    private String nombrePlantilla;
            
    private List<LinkedHashMap<String, Object>> respuesta;
    
    private ArrayList<List<LinkedHashMap<String, Object>>> respuestaM;
    
    private HashMap<String, Integer> orden;

    public CodError getCodError() {

        return codError;
    }

    public void setCodError(CodError codError) {

        this.codError = codError;
    }

    public Long getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {

        this.idUsuario = idUsuario;
    }

    public String getMsgError() {

        return msgError;
    }

    public void setMsgError(String msgError) {

        this.msgError = msgError;
    }

    public List<LinkedHashMap<String, Object>> getRespuesta() {

        return respuesta;
    }

    public void setRespuesta(List<LinkedHashMap<String, Object>> respuesta) {

        this.respuesta = respuesta;
    }
    public Boolean esRespuestaOperacionCorrecta() {

        return this.codError == CodError.OPERACION_CORRECTA && this.respuesta != null && !respuesta.isEmpty();
    }

    public String getNombrePlantilla() {
        return nombrePlantilla;
    }

    public void setNombrePlantilla(String nombrePlantilla) {
        this.nombrePlantilla = nombrePlantilla;
    }

	/**
	 * @return the respuestaM
	 */
	public ArrayList<List<LinkedHashMap<String, Object>>> getRespuestaM() {
		return respuestaM;
	}

	/**
	 * @param respuestaM the respuestaM to set
	 */
	public void setRespuestaM(ArrayList<List<LinkedHashMap<String, Object>>> respuestaM) {
		this.respuestaM = respuestaM;
	}

	/**
	 * @return the automaticos
	 */
	public HashMap<String, Integer> getOrden() {
		return orden;
	}

	/**
	 * @param automaticos the automaticos to set
	 */
	public void setOrden(HashMap<String, Integer> orden) {
		this.orden = orden;
	}
}
