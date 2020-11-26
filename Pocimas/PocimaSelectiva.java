package TPE.Pocimas;

import TPE.Atributo;

public class PocimaSelectiva extends Pocima {

	private int modificador;
	private String atribAfectado;

	public PocimaSelectiva(String nombre, int valor, String atrib) {
		super(nombre);
		this.modificador = valor;
		this.atribAfectado = atrib;
	}

	@Override
	public int aplicarPocima(Atributo atr) {
		if (atr.getNombre().equals(atribAfectado)) {
			int valor = atr.getValor();
			int i = (int) (valor * modificador / 100);
			valor += i;
			return valor;
		} else
			return atr.getValor();
	}
}
