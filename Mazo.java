package TPE;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import TPE.Pocimas.Pocima;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	private ArrayList<Carta> cartas;
	
	public Mazo() {
		this.cartas = new ArrayList<Carta>();
	}
	public Mazo(String mazoPath) {
		this.cartas = this.validarCartas(this.cargarCartas(mazoPath));
		
	}
	
	//Devuelve la cantidad de cartas de este mazo
	
	public int cantidadDeCartas() {
		return this.cartas.size();
	}

	//Devuelve la primer carta de este mazo
	
	public Carta damePrimera() {
		return this.cartas.remove(0);
	}
	
	//Muestra la primer carta de este mazo
	
	public Carta verCarta() {
		return this.cartas.get(0);
	}

	//Agrega una carta al final del mazo
	
	public void agregarAlMazo(Carta carta) {
		this.cartas.add(carta);
	}
	
	//Fija la primer carta como modelo y comprueba que todas las cartas contengan los mismos atributos 
	
	private ArrayList<Carta> validarCartas(ArrayList<Carta> cartas) {

		if (cartas.size() > 0) {
			ArrayList<Carta> cartasValidas;
			cartasValidas = new ArrayList<Carta>();
			Carta cartaModelo = cartas.get(0);
			cartasValidas.add(cartaModelo);

			for (int i = 1; i < cartas.size(); i++) {
				if (cartas.get(i).soyDelMismoMaso(cartaModelo)) {
					cartasValidas.add(cartas.get(i));
				}
			}
			return cartasValidas;
		} else {
			return null;
		}
	}
	
	// Orden aleatorio de todas las cartas del mazo
	
	public void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	// Agrega todas las pocimas del arreglo de pocimas pasado por parametro
	
	public void agregarPocimas(ArrayList<Pocima> pocimas) {
		for (int i = 0; i < pocimas.size(); i++) {
			this.cartas.get(i).setPocima(pocimas.get(i));
		} 
			
		
	}
	
	// Carga a un ArrayList las cartas, se pasa por parametro la direccion de un archivo json y las devuelve
	
	private ArrayList<Carta> cargarCartas(String jsonFile) {
		ArrayList<Carta> cartasCargadas = new ArrayList<Carta>();

		// URL url = getClass().getResource(jsonFile);
		File jsonInputFile = new File(jsonFile);
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Creo el objeto JsonReader de Json.
			JsonReader reader = Json.createReader(is);
			// Obtenemos el JsonObject a partir del JsonReader.
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
				Carta cartaCargada;
				cartaCargada = new Carta(nombreCarta);
				for (String nombreAtributo : atributos.keySet()) {
					Atributo atributoCargado = new Atributo (atributos.getInt(nombreAtributo),nombreAtributo);
					cartaCargada.addAtributo(atributoCargado);
					
				}
				cartasCargadas.add(cartaCargada);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartasCargadas;

	}

}
