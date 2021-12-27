package co.gov.umv.sigma.backend.produccion.servicio.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.externo.dto.ExternoDTO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ContratoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FiltroBusquedaEquipo;
import co.gov.umv.sigma.backend.produccion.cbo.ProduccionOE;
import co.gov.umv.sigma.backend.produccion.dto.impl.MantenimientoEquipoDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.MezclaFormulaDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.MezclaFormulaMateriaDTO;
import co.gov.umv.sigma.backend.produccion.servicio.IProduccionService;

public class ProduccioServicio implements IProduccionService
{

			
	@Override
	public Response insertarFallo(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
			OE.getMantenimiento().ingresarComoFallo(false);
		//OE.getMantenimiento().setDescripcionMtto(OE.getMantenimiento().getDescripcionFallo());
		
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	@Override
	public Response actualizarFallo(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		//hay que validar si esta cancelado ya fue 
		String filtro = "ID_MANTENIMIENTO_EQUIPO = " + OE.getMantenimiento().getIdMantenimientoEquipo();
		OE.setFiltro(filtro);
		ObjetoSalida os = dto.consultarXFiltro(OE);
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				//si esta cancelado, no lo puede actualizar.
				if(!os.getRespuesta().get(0).get("id_estado").toString().equals("4771")) //cancelado 
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El fallo ha sido gestionado y el mantenimiento ya fue cancelado o finalizado, no puede ser actualizado el registro.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
			}
		}
				
		os = dto.actualizarFallo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	
	
	@Override
	public Response eliminarFallo(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		boolean eliminarFull = false;
		
		//hay que validar si ya esta programado me imagino no se debe dejar eliminar
		String filtro = "ID_MANTENIMIENTO_EQUIPO = " + OE.getMantenimiento().getIdMantenimientoEquipo();
		OE.setFiltro(filtro);
		ObjetoSalida os = dto.consultarXFiltro(OE);
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				if(os.getRespuesta().get(0).get("fecha") != null) //es decir ya existe como mtto. retorna un error
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El fallo ya fue programado, no puede ser eliminado.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
				else
				{
					eliminarFull=true;
					break;
				}
			}
		}
		
		os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroFallo(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		ObjetoSalida os = dto.consultarXFiltroFallo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/*********************************************************/
	@Override
	public Response programarMantenimientoEquipo(ProduccionOE OE)
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		        
		OE.getMantenimiento().igresarcomoMantenimiento();
				
		ObjetoSalida os = dto.programarMantenimiento(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarMantenimientoEquipo(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		String ingresoComoFallo = "0";
		
		//hay que validar si ingreso como fallo 
		String filtro = "ID_MANTENIMIENTO_EQUIPO = " + OE.getMantenimiento().getIdMantenimientoEquipo();
		OE.setFiltro(filtro);
		ObjetoSalida os = dto.consultarXFiltro(OE);
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				//si esta cancelado, no lo puede actualizar.
				ingresoComoFallo = os.getRespuesta().get(0).get("ingreso_como_fallo").toString();
				
				if(!os.getRespuesta().get(0).get("id_estado").toString().equals("4771")) //cancelado 
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El mantenimiento ya fue cancelado o finalizado, no puede ser actualizado el registro.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
			}
		}
		
		if(ingresoComoFallo.equals("1"))
		{
			OE.getMantenimiento().setIngresoComoFallo(1);
			OE.getMantenimiento().ajustarCodigo();
		}
		
		os = dto.actualizarMtto(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	public Response eliminarMantenimientoEquipo(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		String filtro = "ID_MANTENIMIENTO_EQUIPO = " + OE.getMantenimiento().getIdMantenimientoEquipo();
		OE.setFiltro(filtro);
		ObjetoSalida os = dto.consultarXFiltro(OE);
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				//si esta cancelado, no lo puede eliminar.
				if(!os.getRespuesta().get(0).get("id_estado").toString().equals("4771")) //cancelado 
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El mantenimiento  fue cancelado o finalizado, no puede ser eliminado.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
				
				//si ingrso como fallo, solo actualizaria la informacion de mtto para dejarlo de nuevo limpio.
				if(os.getRespuesta().get(0).get("ingreso_como_fallo").toString().equals("1")) 
				{
					dto.reestablecerComoFallo(OE);
					return Response.status(Response.Status.OK).entity(os).build();
				}
			}
		}
		
		//sino, lo elimina completamente.
		os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	

	@Override
	public Response consultarXFiltroMtto(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		ObjetoSalida os = dto.consultarXFiltroMtto(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaContrato(ContratoOE OE)
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		ObjetoNegocioOE obj = new ObjetoNegocioOE();
		//usuario que esta ejecutando el metodo.
		obj.setUsuario(OE.getUsuario());
		
		AppConfig config = new AppConfig();
		
		//metodo que se va a consumir.
		obj.setUrl( config.getProp().getProperty("caliope.consultarContrato"));
		
		//parametros de la peticion del metodo
		obj.setJson(OE.getJson());
	
		ObjetoSalida os = new ObjetoSalida();
		
		try
		{
			ExternoDTO pasarela = new ExternoDTO();
			os = pasarela.generarObjetoSalida(obj);
			
			//en el objeto de salida, la rspuesta, solo deja los campos id_documento,nombre_contratista,clase_contrato
			if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
			{
				List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
				
				int index = 0;
				for(HashMap<String, Object> map : os.getRespuesta())
				{
					LinkedHashMap<String, Object> registro = new LinkedHashMap<String, Object>();
					
					//Long id =  Long.parseLong(os.getRespuesta().get(0).get("id_documento").toString());
					
					try
					{
						System.out.println( obtenerString(os.getRespuesta().get(index).get("id_documento").toString()));
					}
					catch(Exception e)
					{
						
					}

					registro.put("id_documento", obtenerString(os.getRespuesta().get(index).get("id_documento")));
					
					
					registro.put("nombre_contratista", obtenerString(os.getRespuesta().get(index).get("nombre_contratista")));
					registro.put("clase_contrato", obtenerString(os.getRespuesta().get(index).get("clase_contrato")));
					
					registro.put("numero_contrato", obtenerString(os.getRespuesta().get(index).get("número_contrato")));
					
					registro.put("vigencia", obtenerString(os.getRespuesta().get(index).get("vigencia")));
					
					respuesta.add(registro);
					index++;
				}
				
				os.setRespuesta(respuesta);
				
			}
			
			
		}
		catch(Exception e)
		{
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError("No se obtuvo una respuesta correcta de Caliope");
			os.setRespuesta(null);
			
		}
		
		return Response.status(Response.Status.OK).entity(os).build();
	}

	private String obtenerString(Object o)
	{
		try
		{
			return o.toString();
		}
		catch(Exception e)
		{
			System.out.println("salio error" + o);
			return "";
		}
	}
	
	@Override
	public Response cancelarMantenimiento(ProduccionOE OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		
		//hay que validar si esta cancelado ya fue 
		String filtro = "ID_MANTENIMIENTO_EQUIPO = " + OE.getMantenimiento().getIdMantenimientoEquipo();
		OE.setFiltro(filtro);
		ObjetoSalida os = dto.consultarXFiltro(OE);
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				//si esta cancelado, no lo puede actualizar.
				if(!os.getRespuesta().get(0).get("id_estado").toString().equals("4771")) //cancelado 
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El mantenimiento ya fue cancelado o finalizado, no puede ser actualizado el registro.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
				else if(os.getRespuesta().get(0).get("fecha") == null) //es decir ya existe como mtto. retorna un error
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El mantenimiento no ha sido  programado, no puede ser cancelado.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
				
			}
		}
		 os = dto.cancelarMantenimiento(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response listarEquiposVigentesAc(FiltroBusquedaEquipo OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		ObjetoSalida os = dto.listarEquiposVigentesAc(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response listarEquiposActivosParaMtto(FiltroBusquedaEquipo OE) 
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		ObjetoSalida os = dto.listarEquiposActivosParaMtto(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarMantenimientosEquipos(ProduccionOE OE) {
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		ObjetoSalida os = dto.consultarMantenimientosEquipos(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response finalizarMantenimientoEquipo(ProduccionOE OE)
	{
		MantenimientoEquipoDTO dto = new MantenimientoEquipoDTO();
		
		//hay que validar si esta cancelado ya fue 
		String filtro = "ID_MANTENIMIENTO_EQUIPO = " + OE.getMantenimiento().getIdMantenimientoEquipo();
		OE.setFiltro(filtro);
		ObjetoSalida os = dto.consultarXFiltro(OE);
		if(os.esRespuestaOperacionCorrecta() && os.getRespuesta().size() > 0)
		{
			for(HashMap<String, Object> map : os.getRespuesta())
			{
				//si esta cancelado, no lo puede actualizar.
				if(!os.getRespuesta().get(0).get("id_estado").toString().equals("4771")) //cancelado 
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El mantenimiento ya fue cancelado o finalizado, no puede ser actualizado el registro.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
				else if(os.getRespuesta().get(0).get("fecha") == null) //es decir ya existe como mtto. retorna un error
				{
					os.setRespuesta(null);
					os.setCodError(CodError.ERROR_INTERNO);
					os.setMsgError("El mantenimiento no ha sido  programado, no puede ser finalizado.");
					return Response.status(Response.Status.OK).entity(os).build();
				}
				
			}
		}
		
		 os = dto.finalizarMantenimientoEquipo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	/*********************************************************************************/
	
	@Override
	public Response insertarMezclaFormula(ProduccionOE OE) 
	{
		MezclaFormulaDTO dto = new MezclaFormulaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response actualizarMezclaFormula(ProduccionOE OE) 
	{
		MezclaFormulaDTO dto = new MezclaFormulaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarMezclaFormula(ProduccionOE OE) {
		MezclaFormulaDTO dto = new MezclaFormulaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response consultarXFiltroMezclaFormula(ProduccionOE OE) 
	{
		MezclaFormulaDTO dto = new MezclaFormulaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/*****************************************************************/

	@Override
	public Response insertarMezclaFormulaMateria(ProduccionOE OE) 
	{
		MezclaFormulaMateriaDTO dto = new MezclaFormulaMateriaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response actualizarMezclaFormulaMateria(ProduccionOE OE) 
	{
		MezclaFormulaMateriaDTO dto = new MezclaFormulaMateriaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarMezclaFormulaMateria(ProduccionOE OE)
	{
		MezclaFormulaMateriaDTO dto = new MezclaFormulaMateriaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response consultarXFiltroMezclaFormulaMateria(ProduccionOE OE) 
	{
		MezclaFormulaMateriaDTO dto = new MezclaFormulaMateriaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	
	
	

}
