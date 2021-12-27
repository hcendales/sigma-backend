package co.gov.umv.sigma.backend.pci.entidades;


public class FallaPci {
	private String idPci;
	private String severidad;
	private Double medida;

	public FallaPci(String idPci, String severidad, Double medida) {
		this.idPci = idPci;
		this.severidad = severidad;
		this.medida = medida;
	}

	public String getIdPci() {
		return idPci;
	}

	public String getSeveridad() {
		return severidad;
	}

	public Double getMedida() {
		return medida;
	}
	
	public void setMedida(Double medida) {
		this.medida = medida;
	}
}
