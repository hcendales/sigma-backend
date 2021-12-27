package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.entidad.TabCargueDetalle;
import co.gov.umv.sigma.backend.mejoramiento.cbo.CargueOE;

public interface ICargueDAO 
{
	public ObjetoSalida procesarCargueTipo1(CargueOE OE);
	public ObjetoSalida procesarCargueTipo2(CargueOE OE);
	public ObjetoSalida procesarCargueTipo4(CargueOE OE);
	
	public ObjetoSalida validarCargueTipo1(CargueOE OE);
	public ObjetoSalida validarCargueTipo2(CargueOE OE);
	public ObjetoSalida validarCargueTipo4(CargueOE OE);
		
	public ObjetoSalida eliminarDetalles(CargueOE OE);
	public ObjetoSalida insertaDetalle(TabCargueDetalle info, Long idCargue, String usuario);
	public ObjetoSalida consultarPorFiltro(CargueOE OE);
}
