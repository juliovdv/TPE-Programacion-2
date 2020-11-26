package TPE;

public class Atributo {
	private String nombre;
	private int valor;


	public Atributo(int val, String nom){
		this.setNombre(nom);
		this.setValor(val);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
	
	// Compara su valor con el valor de un atributo, + si es mayor, 0 si es igual y - si es menor 
	
	public int comparame(Atributo atr) {
		return this.valor - atr.valor;
		
	}
	
	// Compara su nombre con otro atributo y devuelve si es igual o no
	
	public boolean soyElMismoAtributo(String atr) {
		if (this.nombre.equals(atr)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return nombre;
	}
}
