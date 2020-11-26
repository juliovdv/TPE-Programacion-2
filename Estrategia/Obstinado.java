package TPE.Estrategia;

import TPE.Carta;

public class Obstinado extends Estrategia {
	private int posicionAtributo;
	
	public Obstinado(int posicion) {
		super("Obstinado");
		this.posicionAtributo = posicion;
	}

	@Override
	public String decidirAtributo(Carta carta) {
	
		return carta.mostrarAtributo(posicionAtributo).getNombre();
	}

}
