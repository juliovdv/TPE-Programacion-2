package TPE.Pocimas;

import TPE.Atributo;

public abstract class Pocima {
	private String nombre;

	public Pocima(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return this.getNombre();
	}

	public abstract int aplicarPocima(Atributo atr);
}
