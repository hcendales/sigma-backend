package co.gov.umv.sigma.backend.produccion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.FiltroAvanzado;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FiltroBusquedaEquipo;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import co.gov.umv.sigma.backend.produccion.cbo.ProduccionOE;
import co.gov.umv.sigma.backend.produccion.dao.impl.MantenimientoEquipoDAO;

public class MantenimientoEquipoDTO implements ICrudDTO
{
	MantenimientoEquipoDAO modelo = new MantenimientoEquipoDAO();
	
	public ObjetoSalida insertar(ObjetoEntrada OE)
	{
		return modelo.insertar(OE);
	}

	public ObjetoSalida actualizar(ObjetoEntrada OE)
	{
		return modelo.actualizar(OE);
	}
	
	public ObjetoSalida eliminar(ObjetoEntrada OE)
	{
		return modelo.eliminar(OE);
	}
	
	public ObjetoSalida consultarXFiltroFallo(ProduccionOE OE)
	{
		return modelo.consultarXFiltroFallo(OE);
	}
	
	public ObjetoSalida cancelarMantenimiento(ObjetoEntrada OE)
	{
		return modelo.cancelarMantenimiento(OE);
		
	}
	
	public ObjetoSalida listarEquiposVigentesAc(FiltroBusquedaEquipo OE)
	{
		
		return modelo.listarEquiposVigentesAc(OE);
	}
	
	public ObjetoSalida listarEquiposActivosParaMtto(FiltroBusquedaEquipo OE)
	{
		
		return modelo.listarEquiposActivosParaMtto(OE);
	}
	
	public ObjetoSalida actualizarFallo(ObjetoEntrada OE)
	{
		return modelo.actualizarFallo(OE);
		
	}
	
	public ObjetoSalida actualizarMtto(ObjetoEntrada OE)
	{
		return modelo.actualizarMtto(OE);
	}

	public ObjetoSalida reestablecerComoFallo(ProduccionOE OE) {
		return modelo.reestablecerComoFallo(OE);
	}

	 private java.sql.Date obtenerFecha(java.util.Date fecha){
	    	java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Bogota"));		
	    	return (fecha == null) ? null : new java.sql.Date(fecha.getTime());
	    }
	 
	public ObjetoSalida consultarMantenimientosEquipos(ProduccionOE OE)
	{
		FiltroAvanzado filtro = new FiltroAvanzado();
		filtro.agregarFiltro("TIPO", ((ProduccionOE)OE).getMantenimiento().getTipo());
		filtro.agregarFiltro("ID_EQUIPO", ((ProduccionOE)OE).getMantenimiento().getIdEquipo());
		filtro.agregarFiltro("ID_TIPO_MANTENIMIENTO", ((ProduccionOE)OE).getMantenimiento().getIdTipoMantenimiento());
	//	filtro.agregarFiltro("FECHA",  obtenerFecha( ((ProduccionOE)OE).getMantenimiento().getFecha()));
		
		OE.setFiltro(filtro.obtenerComoFiltro());
		
		return modelo.consultarXFiltroMtto(OE);
	}

	public ObjetoSalida finalizarMantenimientoEquipo(ProduccionOE OE) {
		return modelo.finalizarMantenimientoEquipo(OE);
	}

	public ObjetoSalida programarMantenimiento(ProduccionOE OE) {
		return modelo.programarMantenimiento(OE);
	}

	public ObjetoSalida consultarXFiltroMtto(ProduccionOE OE)
	{
		return modelo.consultarXFiltroMtto(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{
		return modelo.consultarXFiltro(OE);
	}

	public ObjetoSalida reporteMantenimientoFallos(ProduccionOE OE)
	{
		return modelo.reporteMantenimientoFallos(OE);
	}
	
	
}