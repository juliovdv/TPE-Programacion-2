package TPE;

import java.util.ArrayList;

import TPE.Pocimas.PocimaAumentoPorcentaje;
import TPE.Pocimas.PocimaCocktail;
import TPE.Pocimas.PocimaDisminucionPorcentaje;
import TPE.Pocimas.PocimaNumeroFijo;
import TPE.Pocimas.PocimaSelectiva;
import TPE.Pocimas.Pocima;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador deturno;
	private Mazo mazo;
	private ArrayList<Pocima> pocimas;
	private final int MAXJUGADAS = 30;

	public static void main(String[] args) {
		Juego j = new Juego();
		j.jugar();

	}

	public Juego() {
		String mazoPath = "./autos.json";
		mazo = new Mazo(mazoPath);

		jugador1 = new Jugador("Jugador 1");
		jugador2 = new Jugador("Jugador 2");
		deturno = jugador1;

		
	}

	private void jugar() {
		
		int jugadas = 1;
		this.repartirCartas();
		this.jugarMano();
		while ((jugadas <= MAXJUGADAS) && (this.jugador1.cuantasCartasTengo() > 0)
				&& (this.jugador2.cuantasCartasTengo() > 0)) {
			this.jugarMano();
			jugadas++;
		}
		if (this.jugador1.ganoYo(jugador2) == 0) {
			System.out.println("EMPATE");
		} else {
			if (this.jugador1.ganoYo(jugador2) > 0) {
				System.out.println("GANA LA PARTIDA " + this.jugador1);
			} else {
				System.out.println("GANA LA PARTIDA " + this.jugador2);
			}
		}

	}

	private void repartirCartas() {
		mazo.mezclarCartas();
		int cantCartas = mazo.cantidadDeCartas();
		mazo.mezclarCartas();
		if (cantCartas >= 2) {
			while (cantCartas >= 2) {
				jugador1.agregarAmiMazo(mazo.damePrimera());
				jugador2.agregarAmiMazo(mazo.damePrimera());// PROBLEMA DE CARTAS IMPARES
				cantCartas = mazo.cantidadDeCartas();
			}
			if (cantCartas == 1) {
				jugador1.agregarAmiMazo(mazo.damePrimera());
			}

		}
	}

	private void jugarMano() {
		String atribElegido;
		Carta cartaJugador1;
		Carta cartaJugador2;
		atribElegido = this.deturno.decirAtributo(this.deturno.verCarta());
		cartaJugador1 = this.jugador1.jugarCarta();
		cartaJugador2 = this.jugador2.jugarCarta();
		this.informacionMano(cartaJugador1, cartaJugador2, atribElegido);

		if (cartaJugador2.comparameCarta(atribElegido, cartaJugador1) > 0) {
			this.gano(jugador2, cartaJugador1, cartaJugador2);

		} else {
			if (cartaJugador2.comparameCarta(atribElegido, cartaJugador1) < 0) {
				this.gano(jugador1, cartaJugador1, cartaJugador2);

			} else {
				this.empate(cartaJugador1, cartaJugador2);
			}
		}
		this.informacionResultado();

	}

	private void empate(Carta c1, Carta c2) {
		this.jugador1.agregarAmiMazo(c1);
		this.jugador2.agregarAmiMazo(c2);
		System.out.println("Empate");
	}

	private void gano(Jugador jugador, Carta c1, Carta c2) {
		jugador.agregarAmiMazo(c1);
		jugador.agregarAmiMazo(c2);
		System.out.println("Gano " + jugador);
		this.deturno = jugador;
	}

	private void informacionMano(Carta c1, Carta c2, String atr) {
		System.out.println("Elije atributo: " + this.deturno);
		System.out.println("Eligio jugar con: " + atr);
		System.out.println(
				"La carta de " + this.jugador1 + " es " + c1.datosCompletos(atr));
		
		System.out.println(
				"La carta de " + this.jugador2 + " es " + c2.datosCompletos(atr));
		
	}

	private void informacionResultado() {
		System.out
				.println("La cantidad de cartas de " + this.jugador1 + " es de " + this.jugador1.cuantasCartasTengo());
		System.out
				.println("La cantidad de cartas de " + this.jugador2 + " es de " + this.jugador2.cuantasCartasTengo());
	} 
	
	
	private void crearPocimas() {
		
			Pocima pocimaAux = new PocimaAumentoPorcentaje("Fortalecedora", 20);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaAumentoPorcentaje("Fortalecedora Plus", 50);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaAumentoPorcentaje("Fortalecedora Plus Plus", 70);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaAumentoPorcentaje("Fortalecedora no tanto", 5);
			pocimas.add(pocimaAux);
			
			
			pocimaAux = new PocimaDisminucionPorcentaje("Kriptonita", 25);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaDisminucionPorcentaje("Reductor de plomo", 55);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaDisminucionPorcentaje("Covid positivo", 90);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaDisminucionPorcentaje("Kriptonita x 2", 50);
			pocimas.add(pocimaAux);
			
			
			pocimaAux = new PocimaNumeroFijo("Quiero vale cuatro", 4);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaNumeroFijo("Numero Magico", 23);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaNumeroFijo("IVA", 21);
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaNumeroFijo("Ausente", 0);
			pocimas.add(pocimaAux);
			
			
			pocimaAux = new PocimaSelectiva("Pocima selectiva fuerza", 35, "fuerza");
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaSelectiva("Pocima selectiva peso", 35, "peso");
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaSelectiva("Rosalia", 500,"altura");
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaSelectiva("Rocky", 1000, "peleas ganadas");
			pocimas.add(pocimaAux);
			
			
			pocimaAux = new PocimaCocktail(new PocimaSelectiva("Pocima selectiva peso", 35, "peso"), pocimaAux = new PocimaNumeroFijo("IVA", 21));
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaCocktail(new PocimaSelectiva("Rosalia", 500,"altura"), new PocimaSelectiva("Rocky", 1000, "peleas ganadas"));
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaCocktail(new PocimaNumeroFijo("Quiero vale cuatro", 4), new PocimaDisminucionPorcentaje("Kriptonita", 25));
			pocimas.add(pocimaAux);
			pocimaAux = new PocimaCocktail(new PocimaAumentoPorcentaje("Fortalecedora no tanto", 5), new PocimaSelectiva("Rosalia", 500,"altura"));
			pocimas.add(pocimaAux);
			
			
	}
	
}
