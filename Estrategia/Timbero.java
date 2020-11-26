package TPE.Estrategia;

import TPE.Atributo;
import TPE.Carta;

public class Timbero extends Estrategia {
	
	
	public Timbero() {
		super("Timbero");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String decidirAtributo(Carta carta) {
		Atributo atribElegido = null;
		int cantAtributos = carta.cantidadDeAtributos();
		if (cantAtributos>0) {
			atribElegido = carta.mostrarAtributo((int) (Math.random()*cantAtributos));
		}
		return atribElegido.getNombre();
	}

}
