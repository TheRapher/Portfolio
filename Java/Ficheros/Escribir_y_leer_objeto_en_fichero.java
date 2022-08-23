package UD1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pract5 {

	public static class Persona implements Serializable{
		
		private String nombre;
		private String apellido;
		private int edad;
		private transient String DNI;
		static final long serialVersionUID = 42L;
		
		public Persona(String nombre, String apellido ,int edad, String DNI){
			this.nombre=nombre;
			this.apellido = apellido;
			this.edad=edad;
			this.DNI = DNI;
		
		}
		public String toString() {
			return nombre+ " "+apellido+" "+edad+" "+DNI+" "+serialVersionUID;
		}
	}
	
	public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Persona p1 =new Persona("Rafa2","Hermosilla2",22,"12345672H");
		Persona p2 =new Persona("Rafa","Hermosilla",21,"12345678H");
		File fichero = new File("/home/holacopia3");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
		Persona p3= (Persona) ois.readObject();
		Persona p4 = (Persona) ois.readObject();
		
        System.out.println(p3);  // Se escribe en pantalla el objeto
        System.out.println(p4);  // Se escribe en pantalla el objeto

		ois.close();
		
	}
}
