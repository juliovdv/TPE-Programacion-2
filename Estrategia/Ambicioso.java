package TPE.Estrategia;

import TPE.Atributo;
import TPE.Carta;

public class Ambicioso extends Estrategia {

	public Ambicioso() {
		super("Ambicioso");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String decidirAtributo(Carta carta) {
		Atributo atrElegido = carta.mostrarAtributo(0);
		for (int i = 1; i < carta.cantidadDeAtributos(); i++) {
			if (atrElegido.comparame(carta.mostrarAtributo(i))<0) {
				atrElegido = carta.mostrarAtributo(i);
			}
		}
		
		return atrElegido.getNombre();
	}

}
