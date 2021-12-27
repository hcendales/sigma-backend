package co.gov.umv.sigma.backend.produccion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import oracle.jdbc.OracleTypes;

public class EnsayoPkDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_ENSAYO_PK";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayoPk().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", ((LaboratorioOE)OE).getEnsayoPk().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((LaboratorioOE)OE).getEnsayoPk().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_localidad", ((LaboratorioOE)OE).getEnsayoPk().getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_zona", ((LaboratorioOE)OE).getEnsayoPk().getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_upla", ((LaboratorioOE)OE).getEnsayoPk().getIdUpla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_barrio", ((LaboratorioOE)OE).getEnsayoPk().getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_cuadrante", ((LaboratorioOE)OE).getEnsayoPk().getIdCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_upz", ((LaboratorioOE)OE).getEnsayoPk().getIdUpz(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_civ", ((LaboratorioOE)OE).getEnsayoPk().getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_eje_vial", ((LaboratorioOE)OE).getEnsayoPk().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_desde", ((LaboratorioOE)OE).getEnsayoPk().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hasta", ((LaboratorioOE)OE).getEnsayoPk().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_estado_pk", ((LaboratorioOE)OE).getEnsayoPk().getEstadoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_pk", ((LaboratorioOE)OE).getEnsayoPk().getIdEnsayoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayoPk().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", ((LaboratorioOE)OE).getEnsayoPk().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((LaboratorioOE)OE).getEnsayoPk().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_localidad", ((LaboratorioOE)OE).getEnsayoPk().getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_zona", ((LaboratorioOE)OE).getEnsayoPk().getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_upla", ((LaboratorioOE)OE).getEnsayoPk().getIdUpla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_barrio", ((LaboratorioOE)OE).getEnsayoPk().getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_cuadrante", ((LaboratorioOE)OE).getEnsayoPk().getIdCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_upz", ((LaboratorioOE)OE).getEnsayoPk().getIdUpz(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_civ", ((LaboratorioOE)OE).getEnsayoPk().getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_eje_vial", ((LaboratorioOE)OE).getEnsayoPk().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_desde", ((LaboratorioOE)OE).getEnsayoPk().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hasta", ((LaboratorioOE)OE).getEnsayoPk().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_estado_pk", ((LaboratorioOE)OE).getEnsayoPk().getEstadoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_pk", ((LaboratorioOE)OE).getEnsayoPk().getIdEnsayoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

	
	public ObjetoSalida eliminarPorEnsayo(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayoPk().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
				
		return ejecutar(OE, PACKAGE+".prc_eliminar_por_ensayo", parametros);
	}


	public ObjetoSalida eliminarXCodigoEnsayo(LaboratorioOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_codigo_ensayo", ((LaboratorioOE)OE).getEnsayo().getCodigoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar_por_codigo", parametros);
	}
	
}