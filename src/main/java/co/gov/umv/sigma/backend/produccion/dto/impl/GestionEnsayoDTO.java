package co.gov.umv.sigma.backend.produccion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.FiltroAvanzado;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EnsayoApiqueOE;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import co.gov.umv.sigma.backend.produccion.dao.impl.GestionEnsayoDAO;

public class GestionEnsayoDTO 
{
	public ObjetoSalida crearGestionEnsayo(EnsayoApiqueOE OE) {
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		return modelo.crearGestionEnsayo(OE);
	}
	

	public ObjetoSalida consultarEnsayo(LaboratorioOE OE)
	{
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		FiltroAvanzado filtro = new FiltroAvanzado();
		filtro.agregarFiltro("ID_ENSAYO", ((LaboratorioOE)OE).getEnsayo().getIdEnsayo());
		
		OE.setFiltro(filtro.obtenerComoFiltro());
		
		return modelo.consultarEnsayo(OE);
	}

	public ObjetoSalida clonarEnsayo(LaboratorioOE OE) 
	{
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		return modelo.clonarEnsayo(OE);
	}
	
	public ObjetoSalida consultarEnsayoDetalle(LaboratorioOE OE) 
	{
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		
		FiltroAvanzado filtro = new FiltroAvanzado();
		filtro.agregarFiltro("ID_ENSAYO", ((LaboratorioOE)OE).getDetalle().getIdEnsayo());
		
		OE.setFiltro(filtro.obtenerComoFiltro());
		
		return modelo.consultarEnsayoDetalle(OE);
	}

	
	public ObjetoSalida consultarTipoServicioEnsayo(LaboratorioOE OE) 
	{
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		return modelo.consultarTipoServicioEnsayo(OE);
	}

	
	public ObjetoSalida consultarTipoMaterialEnsayo(LaboratorioOE OE) 
	{	
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		return modelo.consultarTipoMaterialEnsayo(OE);
	}

	//consulta mtto activos que esten en estado 10,12,15,24
	public ObjetoSalida consultarPkConMantenimientosActivos(ConsultaOE OE) 
	{
		
		//ARMA EL FILTRO QUE SERA ENVIADO AL PROCEDIMIENTO ALMACENADO
		String filtro = "AND (";
		
		if (OE.getIdsMantenimientoVial() != null)
			filtro += " ID_MANTENIMIENTO_VIAL IN ( "+OE.getIdsMantenimientoVial()+ ") AND";
		
		if (OE.getPkIdCalzada() != null)
			filtro += " PK_ID_CALZADA IN ( "+OE.getPkIdCalzada()+ ") AND";
		
		if (OE.getCiv() != null)
			filtro += " CIV = '" + OE.getCiv() +"' AND" ;
		
		if (OE.getIdZona() != null)
			filtro += " ID_ZONA = " + OE.getIdZona() + " AND" ;

		if (OE.getIdLocalidad() != null)
			filtro += " ID_LOCALIDAD = " + OE.getIdLocalidad() + " AND" ;

		if (OE.getIdBarrio() != null)
			filtro += " ID_BARRIO = " + OE.getIdBarrio() + " AND" ;

		if (OE.getIdUPZ() != null)
			filtro += " ID_UPZ = " + OE.getIdUPZ()  ;
	 
		if(!filtro.equals("AND ("))
		{
			if(filtro.endsWith("AND"))
				filtro = filtro.substring(0, filtro.length() - 3);
				
			OE.setFiltro(filtro + " )");
			
		}
		else
			OE.setFiltro(null);
		
		
		
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		return modelo.consultarPkConMantenimientosActivos(OE);
	}


	public ObjetoSalida insertarEnsayoinforme(LaboratorioOE OE) {
		GestionEnsayoDAO modelo = new GestionEnsayoDAO();
		return modelo.insertarEnsayoinforme(OE);
	}


}
