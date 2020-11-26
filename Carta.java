package TPE;

import java.util.ArrayList;

import TPE.Pocimas.Pocima;

public class Carta {
	private String nombre;
	private ArrayList<Atributo> atributos;
	private Pocima pocima;
	
	public Carta(String nom) {
		this.setNombre(nom);
		this.atributos = new ArrayList<Atributo>();
		this.pocima = null;
	}
	
	public Pocima getPocima() {
		return pocima;
	}

	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// devuelve la cantidad de atributos
	
	public int cantidadDeAtributos() {
		return this.atributos.size();
	}
	
	public void addAtributo(Atributo atr) {
		atributos.add(atr);
	}

	public void removeAtributo(Atributo atr) {
		atributos.remove(atr);
	}
	
	// devuelve el valor del atributo del mismo nombre pasado por parametro
	
	public int devolverValorAtributo(String atr) {
		int i = this.encontrarIgualAtributo(atr);
		return this.atributos.get(i).getValor();
	}
	
	// devuelve el valor + el calculo de la pocima del atributo del mismo nombre pasado por parametro
	
	public int devolverValorAtributoPocimas(String atr) {
		int i = this.encontrarIgualAtributo(atr);
		
		if (this.pocima == null) 
			return this.atributos.get(i).getValor();
		else 
			return this.pocima.aplicarPocima(this.atributos.get(i));	
	}
	
	// Compara su atributo del mismo nombre con el pasado por parametro devuelve +, - o 0
	
	public int comparame(Atributo atr) {
		int i = this.encontrarIgualAtributo(atr.getNombre());
		return this.atributos.get(i).comparame(atr);
	}
	
	// Toma el nombre del atributo pasado por parametro y lo compara con el de la carta pasada por parametro
	
	public int comparameCarta(String atr, Carta otra) {
		int miValor = this.devolverValorAtributoPocimas(atr);
		int otroValor = otra.devolverValorAtributoPocimas(atr);
		return miValor - otroValor;
	}
	
	// Encuentra el atributo del mismo nombre y retorna su posicion en el ArrayList
	
	public int encontrarIgualAtributo(String atr) {
		int i=0;
		while (i<atributos.size()){
			if (atr.equals(atributos.get(i).getNombre())) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public Atributo mostrarAtributo(int indice) {
		if (indice < this.atributos.size()) {
			return this.atributos.get(indice);
			}
		else {
			return null;
		}
	}
	
	// Compara que la carta tenga los mismos atributos que otra carta
	
	public boolean soyDelMismoMaso(Carta carta) {
		boolean soyMismo= true ;
		if (this.atributos.size() == carta.atributos.size()){
			int i=0;
			while (( i<this.atributos.size()) && (soyMismo)) {
				if (!this.atributos.get(i).soyElMismoAtributo(carta.atributos.get(i).getNombre())){
					soyMismo = false;
				}
				i++;
			}	
		}
		else {
			soyMismo = false;
		}
		return soyMismo;
		
	}
	
	public String datosCompletos(String atr) {
		String datos= this.getNombre() + " con " + atr + ": " + this.devolverValorAtributo(atr); 
				if (this.getPocima() != null) 
					datos +=" Se aplica la pocima " + this.getPocima() + " valor resultante " + this.devolverValorAtributoPocimas(atr);
		return datos;
		
		
	}
	
	
	@Override
	public String toString() {
		return nombre;
	}
	
}
