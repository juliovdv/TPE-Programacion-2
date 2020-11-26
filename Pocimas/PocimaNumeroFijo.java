package TPE.Pocimas;

import TPE.Atributo;

public class PocimaNumeroFijo extends Pocima {

	private int modificador;

	public PocimaNumeroFijo(String nombre, int valor) {
		super(nombre);
		this.modificador = valor;
	}

	@Override
	public int aplicarPocima(Atributo atr) {
		return modificador;
	}

}
