package co.gov.umv.sigma.backend.pci.exceptions;

import java.math.BigDecimal;

public class CantidadLosasUnidadInvalidaException extends Exception {
	/**
	 * Indica que una unidad de meustreo posee una cantidad de losas que es igual o menor que cero.
	 * 
	 * @author      Ferney.Moreno
	 */
	private static final long serialVersionUID = 1031321226986431003L;

	public CantidadLosasUnidadInvalidaException(long consecUnidad, BigDecimal cantidadLosasUnidad) {
		super("ERROR: la unidad "+ consecUnidad + " tiene una cantidad de losas no válida (" + cantidadLosasUnidad + " losas)");
	}
}
