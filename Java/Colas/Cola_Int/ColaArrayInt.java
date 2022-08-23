package Act2;

public class ColaArrayInt implements ColaInt{
	private static final int LONGITUD_POR_DEFECTO = 10;
	private int maxLongitud;
	private int cabeza;
	private int fin;
	private int[] datos;
	
	//Constructores
	
	public ColaArrayInt() {
		this(LONGITUD_POR_DEFECTO);
	}

	public ColaArrayInt(int max) {
		maxLongitud = max+1;
		fin = 0;
		cabeza = 1;
		datos = new int[maxLongitud];
	}
	
	public void vaciar() {
		fin = 0;
		cabeza =1;
	}
	
	public boolean encolar(int elemento) {
	if((fin+2)% maxLongitud != cabeza) {
		fin = (fin+1) % maxLongitud;
		datos[fin] =  elemento;
		return true;
	}else { 
	System.out.println("La cola esta llena");
	return false;
	}
	}
	
	
	public int desencolar() {
		
		if(longitud() != 0){
			int elemento = datos[cabeza];
			datos[cabeza] = 0;
			cabeza = (cabeza + 1) % maxLongitud;
			return elemento;		
		}else { 
			System.out.println("La cola esta vacia");
		return 0;
		}
	}

	public int primero() {
		if(longitud() != 0){
			return datos[cabeza];
			
		}else { 
		System.out.println("La cola esta vacia");
		return 0;
		}
	}
	
	public int longitud() {return ((fin+maxLongitud) - cabeza + 1) % maxLongitud;}

	//Se necesita para poder devolver los numeros
	public String toString() {
		String numerosArrayInt="";
		
		for(int i=cabeza; i<=fin; i++) {
			
			numerosArrayInt =numerosArrayInt +"" + datos[i] + " ";
		}
		
		return numerosArrayInt;
	}
}