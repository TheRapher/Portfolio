package UD1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pract3 {

	
	static void copia(String origen, String destino ) throws IOException {
		File f = new File(origen);
		 FileReader in= new FileReader(f);
		 Scanner sc = new Scanner(System.in);
		FileWriter out= new FileWriter(destino);
		PrintWriter pw = new PrintWriter(out);
		BufferedReader br = new BufferedReader(in);
		int palabra;
		int tama = (int) f.length();
		char[] totalDef = new char[tama];
		int i =0;
		
		while((palabra=br.read())!=-1){
            char letra=(char)palabra;
			totalDef[i] = letra;
			
            i++;
		}
		for(int j =totalDef.length; j>0; j--) {
			pw.print(totalDef[j-1]);
		} 
		
		
		pw.println(" ");
		pw.println("Rafa Hermosilla");
		
		in.close();
		out.close();
		
		File f2 = new File(destino);
		FileReader in2= new FileReader(f2);
		BufferedReader br2 = new BufferedReader(in2);
		String palabra2;
		
		
		while((palabra2=br2.readLine())!=null){
			System.out.println(palabra2);			
		}		
		in2.close();
		
		
		 
	}
	
	public static void main(String[] args) throws IOException {
		copia("/home/Hola.txt","/home/holacopia1.txt");
		

	}
}
