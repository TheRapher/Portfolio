package UD1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pract2 {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime directorio/ruta: ");
		String ruta = sc.next();
		String direc = ruta;
		String archivo = "";
		File f = new File(ruta);
			
			//Metemos en un String los directorios
			if (f.isDirectory() && f.exists()) {
				for(int i = 0; i<3; i++) {
					System.out.print("Dime directorio a crear: ");
					direc += "/"+ sc.next();
					File f3 = new File(direc);
					f3.mkdir();
					System.out.println("Directorio creado");
				}
				//Metemos en un String el fichero
				System.out.print("Dime fichero a crear: ");
				archivo += "/"+ sc.next()+".txt";
				
				
				
				
				//Lo añadimos a la ruta y lo agregamos
				ruta =direc+archivo;
				System.out.print(ruta);
				
				File f2 = new File(ruta);
				f2.createNewFile();
				
				System.out.println("Archivo creado");
				
			}
		
	}
}
