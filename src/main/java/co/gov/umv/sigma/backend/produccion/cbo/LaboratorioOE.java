package co.gov.umv.sigma.backend.produccion.cbo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayo;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoDetalle;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoInforme;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoInformeAdjunto;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoPk;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoResultado;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoMaterialEnsayo;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoMezcla;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoServicioEnsayo;
import co.gov.umv.sigma.backend.comun.entidad.TabEnsayoMaterial;

public class LaboratorioOE extends ObjetoEntrada 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TabEnsayo ensayo;
	private TabEnsayoDetalle detalle;
	private TabEnsayoResultado resultado;
	private TabTipoMezcla tipoMezcla;
	private TabTipoServicioEnsayo tipoServicioEnsayo;
	private TabEnsayoInformeAdjunto informeAdjunto;
	
	private TabTipoMaterialEnsayo tipoMaterialEnsayo;
	private TabEnsayoPk ensayoPk;
	private TabEnsayoInforme informe;
	
	private TabEnsayoMaterial ensayoMaterial;

	public TabEnsayoInforme getInforme() {
		return informe;
	}

	public void setInforme(TabEnsayoInforme informe) {
		this.informe = informe;
	}

	public TabEnsayoPk getEnsayoPk() {
		return ensayoPk;
	}

	public void setEnsayoPk(TabEnsayoPk ensayoPk) {
		this.ensayoPk = ensayoPk;
	}

	public TabTipoMaterialEnsayo getTipoMaterialEnsayo() {
		return tipoMaterialEnsayo;
	}

	public void setTipoMaterialEnsayo(TabTipoMaterialEnsayo tipoMaterialEnsayo) {
		this.tipoMaterialEnsayo = tipoMaterialEnsayo;
	}

	public TabTipoServicioEnsayo getTipoServicioEnsayo() {
		return tipoServicioEnsayo;
	}

	public void setTipoServicioEnsayo(TabTipoServicioEnsayo tipoServicioEnsayo) {
		this.tipoServicioEnsayo = tipoServicioEnsayo;
	}

	public TabTipoMezcla getTipoMezcla() {
		return tipoMezcla;
	}

	public void setTipoMezcla(TabTipoMezcla tipoMezcla) {
		this.tipoMezcla = tipoMezcla;
	}

	public TabEnsayo getEnsayo() {
		return ensayo;
	}

	public void setEnsayo(TabEnsayo ensayo) {
		this.ensayo = ensayo;
	}

	public TabEnsayoDetalle getDetalle() {
		return detalle;
	}

	public void setDetalle(TabEnsayoDetalle detalle) {
		this.detalle = detalle;
	}

	public TabEnsayoResultado getResultado() {
		return resultado;
	}

	public void setResultado(TabEnsayoResultado resultado) {
		this.resultado = resultado;
	}

	public TabEnsayoMaterial getEnsayoMaterial() {
		return ensayoMaterial;
	}

	public void setEnsayoMaterial(TabEnsayoMaterial ensayoMaterial) {
		this.ensayoMaterial = ensayoMaterial;
	}


	public static void main(String[] args) throws JsonProcessingException
	{
		 Map<String, Object> m = new HashMap<>();
		 TabEnsayoInforme e = new TabEnsayoInforme();
	     
        Class<?> c = e.getClass();
        for(Field f : c.getDeclaredFields())
        {
             f.setAccessible(true);
             m.put(f.getName(),  (f.getType() == String.class ? "string" : "numero")   );
         }
        ObjectMapper mapper = new ObjectMapper();
        System.out.println( mapper.writeValueAsString(m));
	
	}

	public TabEnsayoInformeAdjunto getInformeAdjunto() {
		return informeAdjunto;
	}

	public void setInformeAdjunto(TabEnsayoInformeAdjunto informeAdjunto) {
		this.informeAdjunto = informeAdjunto;
	}
	
	
	
	
}
