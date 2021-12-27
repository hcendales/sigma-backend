package co.gov.umv.sigma.backend.comun.dto.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.DominioGenerico;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.comun.dto.IDominioDTO;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;

public class DominioDTO implements IDominioDTO
{
	
	private ObjetoSalida recuperarDominios(String usuario, int id_lista)
	{
		DominioGenerico dom = new DominioGenerico(usuario, id_lista );
		
		ObjetoNegocioOE obj = new ObjetoNegocioOE();
		//usuario que esta ejecutando el metodo.
		obj.setUsuario(usuario);
		
		AppConfig config = new AppConfig();
		
		//metodo que se va a consumir.
		obj.setUrl( config.getProp().getProperty("caliope.consultarLista"));
		//parametros de la peticion del metodo
		obj.setJson(dom.getJsonForFiltro());
	
		ObjetoSalida os = new ObjetoSalida();
		
		try
		{
			ExternoDTO pasarela = new ExternoDTO();
			os = pasarela.generarObjetoSalida(obj);
			
		}
		catch(Exception e)
		{
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError("No se obtuvo una respuesta correcta de Caliope");
			os.setRespuesta(null);
			
		}
		
		return os ;
	}
	
	
	@Override
	public List<DominioGenerico> listaDominios(String usuario, int id_lista)
	{
		List<DominioGenerico> lista = new ArrayList<DominioGenerico>();
		
		try
		{
			ObjetoSalida os = recuperarDominios(usuario, id_lista);
			
			if(os.esRespuestaOperacionCorrecta())
			{
				for(HashMap<String, Object> map : os.getRespuesta())
				{
					ObjectMapper mapper = new ObjectMapper(); 
					DominioGenerico obj = mapper.convertValue(map, DominioGenerico.class);
					lista.add(obj);
				}
			}
		}
		catch(Exception e)
		{
			
		}
		
		return lista ;
		
	}
	
	@Override
	public ObjetoSalida consultarDominios(String usuario, int id_lista)
	{
		return recuperarDominios(usuario, id_lista);
	}
	

	
}
