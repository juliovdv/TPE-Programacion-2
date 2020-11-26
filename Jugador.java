package TPE;

import TPE.Estrategia.Ambicioso;
import TPE.Estrategia.Estrategia;
import TPE.Estrategia.Timbero;
import TPE.Estrategia.Obstinado;

public class Jugador {
	private String nombre;
	private Mazo mazo;
	private Estrategia estrategia;
	
	public Jugador(String nomb){
		this.nombre = nomb;
		this.mazo = new Mazo();
		this.estrategia = new Timbero(); 
	}
	
	public Jugador(String nomb, Estrategia estrategia){
		this.nombre = nomb;
		this.mazo = new Mazo();
		this.estrategia = estrategia; 
	}
	
	// Setea la estrategia que va a usar el jugador
	
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Quita la carta de su mazo y la juega
	
	public Carta jugarCarta() {
		if (this.mazo.cantidadDeCartas()>0) {
			return this.mazo.damePrimera();
		}
		else {
			return null;
		}
	}
	
	// Muestra la primera carta
	
	public Carta verCarta() {
		if (this.mazo.cantidadDeCartas()>0) {
			return this.mazo.verCarta();
		}
		else {
			return null;
		}
	}
	
	// Agrega una carta al mazo del jugador
	
	public void agregarAmiMazo(Carta carta){
		this.mazo.agregarAlMazo(carta);
	}
	
	// Devuelve la cantidad de cartas en el mazo del jugador
	
	public int cuantasCartasTengo() {
		return this.mazo.cantidadDeCartas();
	}
	
	// Elije un atributo segun la estrategia que siga el jugador
	
	public String decirAtributo(Carta carta) {
		
		return estrategia.decidirAtributo(carta);
	}
	
	// Compara la cantidad de cartas con otro jugador
	
	public int ganoYo(Jugador j) {
		return this.cuantasCartasTengo() - j.cuantasCartasTengo();
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}

