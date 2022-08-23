package Act2;

public class Main {

	public static void main(String[]args) {
		 ColaArrayInt cola = new ColaArrayInt(20);
		 cola.encolar(1);
		 cola.encolar(2);
		 cola.encolar(3);
		 cola.encolar(4);
		
		System.out.println(cola);
		cola.desencolar();
		cola.encolar(5);
		System.out.println(cola);
	}
	
	
	
}
