package co.gov.umv.sigma.backend.pci.exceptions;

public class SeveridadNoExisteException extends Exception{

	/**
	 * Indica que no existe una curva para un nivel de severidad de una falla.
	 */
	private static final long serialVersionUID = 6049584996944104861L;
	
	public SeveridadNoExisteException(String severidad, String idFalla) {
		super("ERROR: la severidad '"+severidad+"' no existe para la falla con id '" + idFalla + "'.");
	}

}
