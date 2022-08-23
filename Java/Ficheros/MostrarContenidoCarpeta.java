package UD1;

import java.io.File;
import java.util.Scanner;

public class Prac1 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime el directorio: ");
		String direc = sc.next();
		
		String ruta ="/media/"+direc;

		File f = new File(ruta);
		if (f.isDirectory()) {
		
			File[] pru = f.listFiles();
		
				for(int i=0; i<pru.length; i++) {
					System.out.println(pru[i]);
				}
		}else if(!f.isDirectory()|| !f.exists()){
			System.out.print("No es un directorio");
		}		
	}
}
