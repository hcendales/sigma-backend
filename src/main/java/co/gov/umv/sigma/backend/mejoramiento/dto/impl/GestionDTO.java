package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.CodTipoGestion;
import co.gov.umv.sigma.backend.comun.cbo.DominioGenerico;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.comun.dto.IDominioDTO;
import co.gov.umv.sigma.backend.comun.dto.impl.DominioDTO;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVial;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialEvento;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IConsultaGestionDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.ConsultaGestionDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IGestionDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialEventoDTO;

/**
*
* @author rocio.guio
*/
public class GestionDTO implements IGestionDTO 
{
	@Override
	public ObjetoSalida listarPanelPendiente(GestionOE OE)
	{
		IConsultaGestionDAO modelo = new ConsultaGestionDAO();
		return modelo.listarPanelPendiente(OE);
	}
	
	@Override
	public ObjetoSalida listarGestionPendiente(GestionOE OE) 
	{
		IConsultaGestionDAO modelo = new ConsultaGestionDAO();
		return modelo.listarGestionPendiente(OE);
	}
	

	@Override
	public ObjetoSalida obtenerGestionPendientePorIdTransicion(GestionOE OE)
	{
		IConsultaGestionDAO modelo = new ConsultaGestionDAO();
		return modelo.listarPorIdTransicion(OE);
	}
	
	@Override
	public ObjetoSalida obtenerTransicionesPorActividad(GestionOE OE)
	{
		IConsultaGestionDAO modelo = new ConsultaGestionDAO();
		return modelo.listarTransicionesPorActividad(OE);
	}
	
	private ObjetoSalida gestionarFlujoTrabajoMasivo_(GestionOE OE)
	{
		ObjetoSalida res = new ObjetoSalida();
		
		ArrayList<List<LinkedHashMap<String, Object>>> respuestaMasiva = new ArrayList<List<LinkedHashMap<String, Object>>>();
				
		ObjetoNegocioOE obj = new ObjetoNegocioOE();
		//usuario que esta ejecutando el metodo.
		obj.setUsuario(OE.getUsuario());
		
		AppConfig config = new AppConfig();
		
		//String[] ids = OE.getIds().split(",");
		if( OE.getIds().size() > 0)
		{
			for(Integer id : OE.getIds())
			{
				
				if(OE.getTipoGestion().equals(CodTipoGestion.AVANZAR))
				{
					//metodo que se va a consumir.
					obj.setUrl( config.getProp().getProperty("caliope.avanzarGestion"));
					//parametros de la peticion del metodo
					obj.setJson(OE.getJsonForAvanzarGestion(id));
				}
				
				ObjetoSalida os = new ObjetoSalida();
				
				try
				{
					ExternoDTO pasarela = new ExternoDTO();
					
					ObjetoSalida pas = pasarela.consumirExterno(obj);
					os =  extraerObjetoSalida(pas);
					CodError err = os.getCodError();
					String msg = os.getMsgError();
					
					os.getRespuesta().get(0).put("rtaGestion", err);
					os.getRespuesta().get(0).put("msgGestion", msg);
					
				}
				catch(Exception e)
				{
					if(os.getRespuesta() == null)
					{
						List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
						LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
						registro.put("rtaGestion", CodError.ERROR_INTERNO);
						registro.put("msgGestion", os.getMsgError());
						registro.put("id_proceso_gestion", id);
						respuesta.add(registro);
						os.setRespuesta(respuesta);
					}
				}
				
				//creo que respuestaM es masiva
				respuestaMasiva.add(os.getRespuesta());
			}
			
			if(respuestaMasiva == null || respuestaMasiva.isEmpty())
			{
				res.setCodError(CodError.ERROR_INTERNO);
				res.setMsgError("No se obtuvo respuesta correcta desde Caliope");
			}
			else
				res.setRespuestaM(respuestaMasiva);
		}
		else
		{
			res.setCodError(CodError.ERROR_INTERNO);
			res.setMsgError("No se enviaron registros para procesar");
		}
		return res ;
	}
	
	

	@Override
	public ObjetoSalida gestionarFlujoTrabajoMasivo(GestionOE OE)
	{
		ObjetoSalida res = new ObjetoSalida();
		
		List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
				
		ObjetoNegocioOE obj = new ObjetoNegocioOE();
		//usuario que esta ejecutando el metodo.
		obj.setUsuario(OE.getUsuario());
		
		AppConfig config = new AppConfig();
		
		//String[] ids = OE.getIds().split(",");
		
		if( OE.getIds().size() > 0)
		{
			for(Integer id : OE.getIds())
			{	
				if(OE.getTipoGestion().equals(CodTipoGestion.AVANZAR))
				{
					//metodo que se va a consumir.
					obj.setUrl( config.getProp().getProperty("caliope.avanzarGestion"));
					//parametros de la peticion del metodo
					obj.setJson(OE.getJsonForAvanzarGestion(id));
				}
				
				LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
				
				
				ObjetoSalida os = new ObjetoSalida();
				try
				{
					ExternoDTO pasarela = new ExternoDTO();
					
					ObjetoSalida pas = pasarela.consumirExterno(obj);
					os =  extraerObjetoSalida(pas);
					registro.put("rtaGestion", os.getCodError());
					registro.put("msgGestion", os.getMsgError());
					registro.put("id_proceso_gestion", id);
					respuesta.add(registro);
						
				}
				catch(Exception e)
				{
					if(os.getRespuesta() == null)
					{
						registro.put("rtaGestion", CodError.ERROR_INTERNO);
						
						if(os.getMsgError() == null) 
						{
							registro.put("msgGestion", "No se obtuvo una respuesta correcta de Caliope");
						}
						else
						{
							registro.put("msgGestion", os.getMsgError());
						}
						registro.put("id_proceso_gestion", id);
						respuesta.add(registro);
					}
				}
				
			}
			
			res.setMsgError("proceso masivo realizado");
			res.setRespuesta(respuesta);
		}
		else
		{
			res.setCodError(CodError.ERROR_INTERNO);
			res.setMsgError("No se enviaron registros para procesar");
		}
		return res ;
	}
	
	
	
	
	private ObjetoSalida extraerObjetoSalida(ObjetoSalida OSPasarela)
	{
		 //este objeto hay que convertirlo a Objeto de salida
		 String json =  OSPasarela.getRespuesta().get(0).get("json").toString();
		 ObjetoSalida os = null ;
		 try
		 {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            os = gson.fromJson(json,ObjetoSalida.class);
            
            if(os.getCodError() == null)
            	os.setCodError(OSPasarela.getCodError());
            if(os.getMsgError() == null)
            	os.setMsgError(OSPasarela.getMsgError());
          
            //str= gson.toJson(os);
            //System.out.println("User Object as string : "+str);

        }catch(JsonIOException err)
	 	{
        	os = null ;
            System.out.println("Exception : "+err.toString());
        }
		
		return os ;
	}

	@Override
	public ObjetoSalida gestionarFlujoTrabajo(GestionOE OE)
	{
		ObjetoNegocioOE obj = new ObjetoNegocioOE();
		//usuario que esta ejecutando el metodo.
		obj.setUsuario(OE.getUsuario());
		
		AppConfig config = new AppConfig();
		
		if(OE.getTipoGestion().equals(CodTipoGestion.INICIAR))
		{
			//metodo que se va a consumir.
			obj.setUrl( config.getProp().getProperty("caliope.iniciarGestion"));
			//parametros de la peticion del metodo
			obj.setJson(OE.getJsonForInicioGestion());
		}
		else if(OE.getTipoGestion().equals(CodTipoGestion.AVANZAR))
		{
			//metodo que se va a consumir.
			obj.setUrl( config.getProp().getProperty("caliope.avanzarGestion"));
			//parametros de la peticion del metodo
			obj.setJson(OE.getJsonForAvanzarGestion());
		}
		else if(OE.getTipoGestion().equals(CodTipoGestion.EVALUAR_TRANSICION))
		{
			//metodo que se va a consumir.
			obj.setUrl( config.getProp().getProperty("caliope.evaluarTransicion"));
			//parametros de la peticion del metodo
			obj.setJson(OE.getJsonForInicioGestion());
		}
		else if(OE.getTipoGestion().equals(CodTipoGestion.EVALUAR_ASIGNACION))
		{
			//metodo que se va a consumir.
			obj.setUrl( config.getProp().getProperty("caliope.evaluarAsignacion"));
			//parametros de la peticion del metodo
			obj.setJson(OE.getJsonForEvaluarAsignacion());
		}
		else if(OE.getTipoGestion().equals(CodTipoGestion.CAMBIAR_ACTOR))
		{
			//metodo que se va a consumir.
			obj.setUrl( config.getProp().getProperty("caliope.cambiarActor"));
			//parametros de la peticion del metodo
			obj.setJson(OE.getJsonForEvaluarAsignacion());
		}
		
		
		ObjetoSalida os = new ObjetoSalida();
		if(obj.getJson().equals("")) 
		{
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError("No se pudo convertir el objeto a JSON");
			return os ;
		}
		
		try
		{
			ExternoDTO pasarela = new ExternoDTO();
			os = extraerObjetoSalida( pasarela.consumirExterno(obj));
			
		}
		catch(Exception e)
		{
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError("No se obtuvo una respuesta correcta de Caliope");
			os.setRespuesta(null);
			
			e.printStackTrace();
			
		}
		
		return os ;
	}
	
	@Override
	public ObjetoSalida obtenerInfoMantenimiento(GestionOE OE, String campos)
	{
		ObjetoSalida res = new ObjetoSalida();
		String[] ids = campos.split(",");
		
		//consulta el Id Mantenimiento vial.
		MantenimientoVialOE OEmv = new MantenimientoVialOE();
		OEmv.setUsuario(OE.getUsuario());
		OEmv.setMantenimientovial(new TabMantenimientoVial());
		OEmv.getMantenimientovial().setIdMantenimientoVial(OE.getIdMantenimientoVial());
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.consultarId(OEmv);
		
		if(os.esRespuestaOperacionCorrecta())
		{
			List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
            LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(ids.length);	
			//saco unicamente los campos que quiero de lo que se consulta a la BD
			for (Map.Entry<String, Object> entry : os.getRespuesta().get(0).entrySet()) 
			{
			    String key = entry.getKey();
			    
			    for (String id : ids) 
				{
			    	if(key.equalsIgnoreCase(id))
			    	{
			    		registro.put(id, os.getRespuesta().get(0).get(id).toString());
			    		break ;
			    	}
				}
			}
			
			respuesta.add(registro);
			
			res.setRespuesta(respuesta);
		}
		
		else
		{
			res.setCodError(os.getCodError());
			res.setMsgError(os.getMsgError());
		}
		
		return res;
	}			

	
	@Override
	public ObjetoSalida obtenerResponsableVisita(GestionOE OE)
	{
		ObjetoSalida res = new ObjetoSalida();
		
		//String[] ids = OE.getIds().split(",");
		
		if( OE.getIds().size() > 0)
		{
			IGestionDTO consulta = new GestionDTO();
			ObjetoSalida os = consulta.listarGestionPendiente(OE);
			
			if(os.esRespuestaOperacionCorrecta())
			{
				List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
	            
				int index =0 ;
				for(HashMap<String, Object> map : os.getRespuesta())
				{
					Integer idProcesoGestion =  Integer.parseInt(os.getRespuesta().get(index).get("id_proceso_gestion").toString());
					for(Integer id : OE.getIds()) 
					{
						if(id.equals(idProcesoGestion))
						{
							LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(2);	
							registro.put("nombre_responsable_visita", os.getRespuesta().get(index).get("nombre_responsable_visita").toString());
							registro.put("fecha_visita_tecnica", os.getRespuesta().get(index).get("id_proceso_gestion").toString());
							respuesta.add(registro);
							break ;
						}
					}
					
					index++;
				}
				
				res.setRespuesta(respuesta);
			}
		}
		else
		{
			res.setCodError(CodError.ERROR_INTERNO);
			res.setMsgError("No se definio identificadores para buscar");
		}
		
		return res;
	}
	
	@Override
	public Map<Long,String> listarDominio(String dominio, String usuario)
	{
		IDominioDTO dominios = new DominioDTO();
		Map<Long,String> mapeo = new HashMap<>();
		
		 List<DominioGenerico> dominioFallas = dominios.listaDominios(usuario, Integer.parseInt( dominio));
		 
		 for (DominioGenerico falla : dominioFallas) 
		 {
			 mapeo.put(falla.getId_tipo(), falla.getValor());
		 }
		 
		 return mapeo ;
		
	}
	
	@Override
	public ObjetoSalida recuperarDominios(String dominio, String usuario)
	{
		IDominioDTO dominios = new DominioDTO();
		return dominios.consultarDominios("rocio.guio", Integer.parseInt( dominio));
		
	}

	
	private TabMantenimientoVialEvento obtenerInfoMantenimientoEvento(Long idMttoEvento, String usuario) throws JsonParseException, JsonMappingException, IOException
	{		
		//consulta el Id Mantenimiento vial.
		MantenimientoVialEventoOE OEmv = new MantenimientoVialEventoOE();
		OEmv.setUsuario(usuario);
		OEmv.setMantenimientoVialEvento(new TabMantenimientoVialEvento());
		OEmv.getMantenimientoVialEvento().setIdMantenimientoVialEvento(idMttoEvento);
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.consultarId(OEmv);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(os.getRespuesta().get(0));
		return new ObjectMapper().readValue(jsonString, TabMantenimientoVialEvento.class);
	}			

	
	private ObjetoSalida obtenerKmCarrilImpactoPorEvento(GestionOE OE) throws Exception 
	{
		ObjetoSalida OS = new ObjetoSalida();
		
		List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
		
		for(Integer id : OE.getIds())
		{
			TabMantenimientoVialEvento ev = obtenerInfoMantenimientoEvento(new Long(id), OE.getUsuario());
			
			LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
			registro.put("idMantenimientoVialEvento", new Long(id));
			registro.put("kmCarrilImpacto", ev.getKmCarrilImpacto());
			registro.put("idTipoIntervencion", ev.getIdTipoIntervencion());
			respuesta.add(registro);
		}
		
		OS.setCodError(CodError.OPERACION_CORRECTA);
		OS.setRespuesta(respuesta);

		return OS;
	}
	
	@Override
	public ObjetoSalida obtenerKmCarrilImpactoPorEventos(GestionOE OE) throws Exception 
	{
		ObjetoSalida OS = new ObjetoSalida();
		
		List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
		
		List<TabMantenimientoVialEvento> lst = obtenerInfoMantenimientoEventos(OE);
		if(lst.size() >0 )
		{
			Long idTipoIntervencion = lst.get(0).getIdTipoIntervencion() == null ? Long.MIN_VALUE : lst.get(0).getIdTipoIntervencion();
			BigDecimal kmCarrilImpactoAcumulado = BigDecimal.ZERO ;
			
			for(TabMantenimientoVialEvento mtto : lst)
			{
				kmCarrilImpactoAcumulado = kmCarrilImpactoAcumulado.add(mtto.getKmCarrilImpacto());
				Long idInt = mtto.getIdTipoIntervencion() == null ? Long.MIN_VALUE : mtto.getIdTipoIntervencion();
				
				if(!idTipoIntervencion.equals(idInt))
				{
					LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
					registro.put("kmCarrilImpactoAcumulado", kmCarrilImpactoAcumulado);
					registro.put("idTipoIntervencion", idTipoIntervencion == Long.MIN_VALUE ? null : idTipoIntervencion);
					respuesta.add(registro);
					
					kmCarrilImpactoAcumulado = BigDecimal.ZERO;
					idTipoIntervencion = mtto.getIdTipoIntervencion() == null ? Long.MIN_VALUE : mtto.getIdTipoIntervencion();
				}
			}
			//el ultimo regisro acumulado.
			LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
			registro.put("kmCarrilImpactoAcumulado", kmCarrilImpactoAcumulado);
			registro.put("idTipoIntervencion", idTipoIntervencion == Long.MIN_VALUE ? null : idTipoIntervencion);
			respuesta.add(registro);

		}
		
		OS.setCodError(CodError.OPERACION_CORRECTA);
		OS.setRespuesta(respuesta);

		return OS;
	}

	private List<TabMantenimientoVialEvento> obtenerInfoMantenimientoEventos(GestionOE OE) throws Exception 
	{
		Gson gson = new Gson();
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		MantenimientoVialEventoOE obj = new MantenimientoVialEventoOE();
		obj.setUsuario(OE.getUsuario());
		
		String ids = org.apache.commons.lang.StringUtils.join(OE.getIds(), ",");
		
		obj.setFiltro("ID_MANTENIMIENTO_VIAL_EVENTO in ("+  ids  +") ORDER BY ID_TIPO_INTERVENCION");
		ObjetoSalida os = servicio.consultarXFiltro(obj);

		List<TabMantenimientoVialEvento> lst = new ArrayList<TabMantenimientoVialEvento>(); 

		int index =0;
		for(LinkedHashMap<String, Object> rta : os.getRespuesta())
		{
			String jsonString = gson.toJson(os.getRespuesta().get(index));
			lst.add( new ObjectMapper().readValue(jsonString, TabMantenimientoVialEvento.class));
			index++;
		}
		
		return lst ;
		
	}

	@Override
	public ObjetoSalida acumularKmCarrilImpactoPorGestion(GestionOE OE) 
	{	
		ObjetoSalida res = new ObjetoSalida();
		
		if( OE.getIds().size() > 0)
		{
			IGestionDTO consulta = new GestionDTO();
			ObjetoSalida os = consulta.listarGestionPendiente(OE);
			
			if(os.esRespuestaOperacionCorrecta())
			{
				List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
	            
				int index =0 ;
				for(HashMap<String, Object> map : os.getRespuesta())
				{
					Integer idProcesoGestion =  Integer.parseInt(os.getRespuesta().get(index).get("id_proceso_gestion").toString());
					for(Integer id : OE.getIds()) 
					{
						if(id.equals(idProcesoGestion))
						{
							LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(2);	
							registro.put("codigo_actividad_agrupada", os.getRespuesta().get(index).get("codigo_actividad_agrupada").toString());
							registro.put("km_carril_impacto", os.getRespuesta().get(index).get("km_carril_impacto"));
							respuesta.add(registro);
							break ;
						}
					}
					
					index++;
				}
				
				res.setRespuesta(respuesta);
			}
			else
			{
				res.setCodError(CodError.ERROR_INTERNO);
				res.setMsgError("No se recibe respuesta correcta desde la BD");
			}
		}
		else
		{
			res.setCodError(CodError.ERROR_INTERNO);
			res.setMsgError("No se definio identificadores de gestión para buscar");
		}
		
		//una vez extraidos solo los ids que se requieren, voy a acumular.
		if(res.getCodError().equals(CodError.OPERACION_CORRECTA))
		{
			List<LinkedHashMap<String, Object>> acumulada = new ArrayList<LinkedHashMap<String, Object>>();
	        
			if(res.getRespuesta().size() > 0)
			{
				int index =0 ;
				for(HashMap<String, Object> map : res.getRespuesta())
				{
					
					String actividad = res.getRespuesta().get(index).get("codigo_actividad_agrupada").toString();
					BigDecimal kmCarril = (BigDecimal) res.getRespuesta().get(index).get("km_carril_impacto");
					
					LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>(2);	
					registro.put("codigo_actividad_agrupada", actividad );

					LinkedHashMap<String, Object> info = existeActividad(acumulada,actividad);
					
					if(info == null)
					{
						registro.put("km_carril_impacto", kmCarril);
						acumulada.add(registro);
					}
					else
					{
						acumulada.remove(info);
						BigDecimal kmCarrilA = (BigDecimal) info.get("km_carril_impacto");
						registro.put("km_carril_impacto", kmCarril.add(kmCarrilA));
						acumulada.add(registro);
					}
					index++;
				}
				
			}
			
			res.setRespuesta(acumulada);
		}
		
		return res;
	}


	private LinkedHashMap<String, Object> existeActividad(List<LinkedHashMap<String, Object>> acumulada, String actividad) 
	{
		for(LinkedHashMap<String, Object> reg : acumulada)
		{
			if(reg.get("codigo_actividad_agrupada").toString().equals(actividad))
				return reg;
		}
		return null;
	}
	
	
}
