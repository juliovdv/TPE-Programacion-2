package TPE.Pocimas;

import TPE.Atributo;

public class PocimaAumentoPorcentaje extends Pocima {
	
	private int modificador;

	public PocimaAumentoPorcentaje(String nombre, int valor) {
		super(nombre);
		this.modificador = valor;
	}

	@Override
	public int aplicarPocima(Atributo atr) {
		int valor = atr.getValor();
		int i =(int) (valor * modificador / 100);
		valor += i;
		return valor;
	}

}
