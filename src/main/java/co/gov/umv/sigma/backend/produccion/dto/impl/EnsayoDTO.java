package co.gov.umv.sigma.backend.produccion.dto.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayo;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import co.gov.umv.sigma.backend.produccion.dao.impl.EnsayoDAO;

public class EnsayoDTO implements ICrudDTO
{

	EnsayoDAO modelo = new EnsayoDAO();
	
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) {
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) {
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) {
		return modelo.consultarXFiltro(OE);
	}

	public ObjetoSalida eliminarXCodigoEnsayo(LaboratorioOE OE) {
		return modelo.eliminarXCodigoEnsayo(OE);
	}

	public ObjetoSalida consultarOrdenPrioridad(LaboratorioOE OE) {
		return modelo.consultarOrdenPrioridad(OE);
	}

	public ObjetoSalida actualizarCampo(LaboratorioOE OE) 
	{
		LaboratorioOE OEE = new LaboratorioOE();
		OEE.setEnsayo(new TabEnsayo());
		OEE.getEnsayo().setIdEnsayo(OE.getEnsayo().getIdEnsayo());
		OEE.setUsuario(OE.getUsuario());

		String [] campos = OE.getNombreCampo().split(";");
		String [] valor = OE.getValorCampo().split(";");
		
		if(campos.length == valor.length) 
		{
			ObjetoSalida os = new ObjetoSalida();
			List<LinkedHashMap<String , Object>> respuesta = new ArrayList<LinkedHashMap<String,Object>>();
			for(int i = 0; i < campos.length; i++) 
			{
				ObjetoSalida oss = new ObjetoSalida();
				LinkedHashMap<String , Object> map =  new LinkedHashMap<String, Object>();
				
				OEE.setNombreCampo(campos[i]);
				OEE.setValorCampo(valor[i]);
				
				oss = modelo.actualizarCampo(OEE);
				if(oss.esRespuestaOperacionCorrecta()) {
					map.put("respuesta", oss);
					map.put("MsjError", oss.getMsgError());
					map.put("codError", oss.getCodError());					
					
				}else {
					map.put("MsjError", oss.getMsgError());
					map.put("codError", oss.getCodError());
				}
				respuesta.add(map);
			}
			os.setRespuesta(respuesta);
			return os;
		}else {
			return new ObjetoSalida();
		}
		
		 
	}


}
