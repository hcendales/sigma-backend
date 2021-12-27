package co.gov.umv.sigma.backend.workflow.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabDocumento;

public class DocumentoOE extends ObjetoEntrada {
	private TabDocumento documento;

	private Long idMantenimientoVial;
	private Long idMantenimientoVialEvento;
	
	public TabDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(TabDocumento documento) {
		this.documento = documento;
	}

	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}

	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}

	public Long getIdMantenimientoVialEvento() {
		return idMantenimientoVialEvento;
	}

	public void setIdMantenimientoVialEvento(Long idMantenimientoVialEvento) {
		this.idMantenimientoVialEvento = idMantenimientoVialEvento;
	}
	
	
	
}
