package TPE.Estrategia;

import TPE.Atributo;
import TPE.Carta;

public abstract class Estrategia {
	private String nombre;
	public Estrategia(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String decidirAtributo(Carta carta);
}
