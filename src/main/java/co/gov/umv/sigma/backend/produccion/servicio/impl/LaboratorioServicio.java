package co.gov.umv.sigma.backend.produccion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoDetalleDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoInformeAdjuntoDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoInformeDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoMaterialDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoPkDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.EnsayoResultadoDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.GestionEnsayoDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.TipoMaterialEnsayoDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.TipoMezclaDTO;
import co.gov.umv.sigma.backend.produccion.dto.impl.TipoServicioEnsayoDTO;
import co.gov.umv.sigma.backend.produccion.servicio.ILaboratorioService;

public class LaboratorioServicio implements ILaboratorioService{

	
	@Override
	public Response clonarEnsayo(LaboratorioOE OE) 
	{
		GestionEnsayoDTO dto = new GestionEnsayoDTO();
		ObjetoSalida os = dto.clonarEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	
	@Override
	public Response consultarOrdenPrioridadEnsayo(LaboratorioOE OE) 
	{
		EnsayoDTO dto = new EnsayoDTO();
		ObjetoSalida os = dto.consultarOrdenPrioridad(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

		
	
	@Override
	public Response insertarEnsayo(LaboratorioOE OE) 
	{
		ICrudDTO dto = new EnsayoDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}



	
	/************************************/
	@Override
	public Response insertarDetEnsayo(LaboratorioOE OE) 
	{
		ICrudDTO dto = new EnsayoDetalleDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarDetEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoDetalleDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarDetEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoDetalleDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroDetEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoDetalleDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminarPorEnsayoDetalle(LaboratorioOE OE) 
	{
		EnsayoDetalleDTO dto = new EnsayoDetalleDTO();
		ObjetoSalida os = dto.eliminarPorEnsayo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/************************************/

	@Override
	public Response insertarResEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoResultadoDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarResEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoResultadoDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarResEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoResultadoDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroResEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoResultadoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	

	/************************************/
	@Override
	public Response insertartipoMezcla(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMezclaDTO();
		ObjetoSalida os = dto.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizartipoMezcla(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMezclaDTO();
		ObjetoSalida os = dto.actualizar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminartipoMezcla(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMezclaDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltrotipoMezcla(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMezclaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/************************************/
	@Override
	public Response insertartipoServicioEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoServicioEnsayoDTO();
		ObjetoSalida os = dto.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizartipoServicioEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoServicioEnsayoDTO();
		ObjetoSalida os = dto.actualizar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminartipoServicioEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoServicioEnsayoDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltrotipoServicioEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoServicioEnsayoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/******************************************************************/
	@Override
	public Response insertartipoMaterialEnsayo(LaboratorioOE OE) 
	{
		ICrudDTO dto = new TipoMaterialEnsayoDTO();
		ObjetoSalida os = dto.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizartipoMaterialEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMaterialEnsayoDTO();
		ObjetoSalida os = dto.actualizar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	

	@Override
	public Response eliminartipoMaterialEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMaterialEnsayoDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltrotipoMaterialEnsayo(LaboratorioOE OE) {
		ICrudDTO dto = new TipoMaterialEnsayoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	/************************************************************************/

	@Override
	public Response insertarEnsayoPk(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoPkDTO();
		ObjetoSalida os = dto.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarEnsayoPk(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoPkDTO();
		ObjetoSalida os = dto.actualizar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarEnsayoPk(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoPkDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroEnsayoPk(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoPkDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminarPorEnsayoPk(LaboratorioOE OE) {
		EnsayoPkDTO dto = new EnsayoPkDTO();
		ObjetoSalida os = dto.eliminarPorEnsayo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	/******************************************************************/

	@Override
	public Response insertarEnsayoinforme(LaboratorioOE OE) 
	{
		GestionEnsayoDTO dto = new GestionEnsayoDTO();
		ObjetoSalida os = dto.insertarEnsayoinforme(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarEnsayoinforme(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoInformeDTO();
		ObjetoSalida os = dto.actualizar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarEnsayoinforme(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoInformeDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroEnsayoinforme(LaboratorioOE OE) {
		ICrudDTO dto = new EnsayoInformeDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminarPorEnsayoInforme(LaboratorioOE OE) 
	{
		EnsayoInformeDTO dto = new EnsayoInformeDTO();
		ObjetoSalida os = dto.eliminarPorEnsayo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/********************************************************/
	//Consultas avanzadas 
	
	@Override
	public Response consultarTipoMaterialEnsayo(LaboratorioOE OE) 
	{
		GestionEnsayoDTO dto = new GestionEnsayoDTO();
		ObjetoSalida os = dto.consultarTipoMaterialEnsayo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarTipoServicioEnsayo(LaboratorioOE OE) 
	{
		GestionEnsayoDTO dto = new GestionEnsayoDTO();
		ObjetoSalida os = dto.consultarTipoServicioEnsayo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarEnsayo(LaboratorioOE OE) 
	{
		GestionEnsayoDTO dto = new GestionEnsayoDTO();
		ObjetoSalida os = dto.consultarEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarEnsayoDetalle(LaboratorioOE OE)
	{
		GestionEnsayoDTO dto = new GestionEnsayoDTO();
		ObjetoSalida os = dto.consultarEnsayoDetalle(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/**********************************************************/
	
	@Override
	public Response insertarEnsayoMaterial(LaboratorioOE OE) {
		EnsayoMaterialDTO dto = new EnsayoMaterialDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarEnsayoMaterial(LaboratorioOE OE) {
		EnsayoMaterialDTO dto = new EnsayoMaterialDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarEnsayoMaterial(LaboratorioOE OE) {
		EnsayoMaterialDTO dto = new EnsayoMaterialDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroEnsayoMaterial(LaboratorioOE OE) {
		EnsayoMaterialDTO dto = new EnsayoMaterialDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarPorEnsayoMaterial(LaboratorioOE OE) 
	{
		EnsayoMaterialDTO dto = new EnsayoMaterialDTO();
		ObjetoSalida os = dto.eliminarPorEnsayo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/********************************************************/
	@Override
	public Response insertarEnsayoinformeAdjunto(LaboratorioOE OE)
	{
		EnsayoInformeAdjuntoDTO dto = new EnsayoInformeAdjuntoDTO();
		ObjetoSalida os = dto.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarEnsayoinformeAdjunto(LaboratorioOE OE) {
		EnsayoInformeAdjuntoDTO dto = new EnsayoInformeAdjuntoDTO();
		ObjetoSalida os = dto.actualizar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarEnsayoinformeAdjunto(LaboratorioOE OE) {
		EnsayoInformeAdjuntoDTO dto = new EnsayoInformeAdjuntoDTO();
		ObjetoSalida os = dto.eliminar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroEnsayoinformeAdjunto(LaboratorioOE OE) {
		EnsayoInformeAdjuntoDTO dto = new EnsayoInformeAdjuntoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}


	


	@Override
	public Response eliminarXCodigoEnsayoDetalle(LaboratorioOE OE) {
		EnsayoDetalleDTO dto = new EnsayoDetalleDTO();
		ObjetoSalida os = dto.eliminarXCodigoEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarXCodigoEnsayoPk(LaboratorioOE OE) {
		EnsayoPkDTO dto = new EnsayoPkDTO();
		ObjetoSalida os = dto.eliminarXCodigoEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarXCodigoEnsayoInforme(LaboratorioOE OE) {
		EnsayoInformeDTO dto = new EnsayoInformeDTO();
		ObjetoSalida os = dto.eliminarXCodigoEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarXCodigoEnsayoMaterial(LaboratorioOE OE) {
		EnsayoMaterialDTO dto = new EnsayoMaterialDTO();
		ObjetoSalida os = dto.eliminarXCodigoEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarXCodigoEnsayo(LaboratorioOE OE) {
		EnsayoDTO dto = new EnsayoDTO();
		ObjetoSalida os = dto.eliminarXCodigoEnsayo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	@Override
	public Response actualizarCampoEnsayo(LaboratorioOE OE) 
	{
		EnsayoDTO servicio = new EnsayoDTO();
		ObjetoSalida os = servicio.actualizarCampo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

}
