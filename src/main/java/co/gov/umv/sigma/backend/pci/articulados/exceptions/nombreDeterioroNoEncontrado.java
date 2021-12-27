package co.gov.umv.sigma.backend.pci.articulados.exceptions;

public class nombreDeterioroNoEncontrado extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4719433590751368897L;
	
	public nombreDeterioroNoEncontrado(String nombreDeterioro) {
		super("ERROR: no se encontró ningún deterioro con el nombre "+ nombreDeterioro);
	}

}
