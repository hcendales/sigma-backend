package co.gov.umv.sigma.backend.comun.dao;

import java.util.List;

public class SentenciaDAO {

    private String nombre;
    private String usuario;
    private Integer idUsuario;
    private List<SentenciaParametroDAO> parametros;

    public SentenciaDAO(String nombre, Integer idUsuario) {

        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    public SentenciaDAO(String nombre, String idUsuario) {

        this.nombre = nombre;
        this.usuario = idUsuario;
    }
    
    public Integer getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {

        this.idUsuario = idUsuario;
    }

    public List<SentenciaParametroDAO> getParametros() {

        return parametros;
    }

    public void setParametros(List<SentenciaParametroDAO> parametros) {

        this.parametros = parametros;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
