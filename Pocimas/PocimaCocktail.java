package TPE.Pocimas;

import TPE.Atributo;

public class PocimaCocktail extends Pocima {
	private Pocima poc1, poc2;
	
	public PocimaCocktail(Pocima poc1, Pocima poc2) {
		super("Pocima Cocktail");
		this.poc1 = poc1;
		this.poc2 = poc2;
	}
	
	public int aplicarPocima(Atributo atr) {
		int aumento1 = poc1.aplicarPocima(atr);
		Atributo atrAux = new Atributo(aumento1, atr.getNombre());
		return poc2.aplicarPocima(atrAux);
		
		
	}

}
