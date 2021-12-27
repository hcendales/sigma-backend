package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.comun.entidad.TabEquipo;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EquipoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class EquipoDAO  extends CrudDAO  implements ICrudDAO
{
	private final static String PACKAGE = "PKG_EQUIPO";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
         
	    parametros.add(new SentenciaParametroDAO("p_numero_interno", ((EquipoOE)OE).getEquipo().getNumeroInterno(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_placa_inventario", ((EquipoOE)OE).getEquipo().getPlacaInventario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_placa", ((EquipoOE)OE).getEquipo().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_movil", ((EquipoOE)OE).getEquipo().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_equipo", ((EquipoOE)OE).getEquipo().getIdTipoClaseEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_equipo", ((EquipoOE)OE).getEquipo().getIdTipoEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_pico_y_placa", ((EquipoOE)OE).getEquipo().getPicoYPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_origen_equipo", ((EquipoOE)OE).getEquipo().getIdTipoOrigenEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_plazo_dias_mantenimiento", ((EquipoOE)OE).getEquipo().getPlazoDiasMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_horas_mantenimiento", ((EquipoOE)OE).getEquipo().getHorasMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_kilometros_mantenimiento", ((EquipoOE)OE).getEquipo().getKilometrosMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_fecha_ultimo_mantenimiento", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaUltimoMantenimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_siguiente_mantenimiento", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaSiguienteMantenimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_equipo", ((EquipoOE)OE).getEquipo().getIdTipoEstadoEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_marca_equipo", ((EquipoOE)OE).getEquipo().getIdTipoMarcaEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_linea", ((EquipoOE)OE).getEquipo().getLinea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_cilindraje", ((EquipoOE)OE).getEquipo().getCilindraje(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_numero_motor", ((EquipoOE)OE).getEquipo().getNumeroMotor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_numero_chasis", ((EquipoOE)OE).getEquipo().getNumeroChasis(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_combustible", ((EquipoOE)OE).getEquipo().getIdTipoCombustible(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_modelo", ((EquipoOE)OE).getEquipo().getModelo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_color", ((EquipoOE)OE).getEquipo().getColor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_area", ((EquipoOE)OE).getEquipo().getIdTipoArea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_toneladas", ((EquipoOE)OE).getEquipo().getToneladas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_pasajeros", ((EquipoOE)OE).getEquipo().getPasajeros(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_numero_serial", ((EquipoOE)OE).getEquipo().getNumeroSerial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_referencia", ((EquipoOE)OE).getEquipo().getReferencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_descripcion", ((EquipoOE)OE).getEquipo().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_volumen_m3", ((EquipoOE)OE).getEquipo().getVolumenM3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_unidad_uso", ((EquipoOE)OE).getEquipo().getIdTipoUnidadUso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);  
   }
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
        parametros.add(new SentenciaParametroDAO("p_id_equipo", ((EquipoOE)OE).getEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_numero_interno", ((EquipoOE)OE).getEquipo().getNumeroInterno(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_placa_inventario", ((EquipoOE)OE).getEquipo().getPlacaInventario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_placa", ((EquipoOE)OE).getEquipo().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_movil", ((EquipoOE)OE).getEquipo().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_equipo", ((EquipoOE)OE).getEquipo().getIdTipoClaseEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_equipo", ((EquipoOE)OE).getEquipo().getIdTipoEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_pico_y_placa", ((EquipoOE)OE).getEquipo().getPicoYPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_origen_equipo", ((EquipoOE)OE).getEquipo().getIdTipoOrigenEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_plazo_dias_mantenimiento", ((EquipoOE)OE).getEquipo().getPlazoDiasMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_horas_mantenimiento", ((EquipoOE)OE).getEquipo().getHorasMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_kilometros_mantenimiento", ((EquipoOE)OE).getEquipo().getKilometrosMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_fecha_ultimo_mantenimiento", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaUltimoMantenimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_siguiente_mantenimiento", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaSiguienteMantenimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_equipo", ((EquipoOE)OE).getEquipo().getIdTipoEstadoEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_marca_equipo", ((EquipoOE)OE).getEquipo().getIdTipoMarcaEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_linea", ((EquipoOE)OE).getEquipo().getLinea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_cilindraje", ((EquipoOE)OE).getEquipo().getCilindraje(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_numero_motor", ((EquipoOE)OE).getEquipo().getNumeroMotor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_numero_chasis", ((EquipoOE)OE).getEquipo().getNumeroChasis(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_combustible", ((EquipoOE)OE).getEquipo().getIdTipoCombustible(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_modelo", ((EquipoOE)OE).getEquipo().getModelo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_color", ((EquipoOE)OE).getEquipo().getColor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_area", ((EquipoOE)OE).getEquipo().getIdTipoArea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((EquipoOE)OE).getEquipo().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_toneladas", ((EquipoOE)OE).getEquipo().getToneladas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_pasajeros", ((EquipoOE)OE).getEquipo().getPasajeros(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_numero_serial", ((EquipoOE)OE).getEquipo().getNumeroSerial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_referencia", ((EquipoOE)OE).getEquipo().getReferencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_descripcion", ((EquipoOE)OE).getEquipo().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	    parametros.add(new SentenciaParametroDAO("p_volumen_m3", ((EquipoOE)OE).getEquipo().getVolumenM3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_tipo_unidad_uso", ((EquipoOE)OE).getEquipo().getIdTipoUnidadUso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                  
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);  
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{     
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	    parametros.add(new SentenciaParametroDAO("p_id_equipo", ((EquipoOE)OE).getEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	
	

}
