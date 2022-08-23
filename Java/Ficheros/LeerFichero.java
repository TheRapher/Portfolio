package UD1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pract4 {
public static void main(String[]args) throws IOException {

	DataOutputStream salida=new DataOutputStream(new FileOutputStream("/home/holacopia2"));

	boolean boo = true;
	salida.writeBoolean(boo);
	
	int entero = 1;
	salida.writeInt(entero);
	
	float flo = 1.5256f;
	salida.writeFloat(flo);
	
	double dou = 2.34;
	salida.writeDouble(dou);
	
	char cha = 'e';
	salida.writeChar(cha);
	
	String stri = "Rafa";
	salida.writeUTF(stri);
	
	byte by = 23;
	salida.writeByte(by);
	
	try(DataInputStream dis=new DataInputStream(new FileInputStream("/home/holacopia2"));){
        System.out.println(dis.readBoolean());
        
        System.out.println(dis.readInt());

        System.out.println(dis.readFloat());
        
        System.out.println(dis.readDouble());

        System.out.println(dis.readChar());

        System.out.println(dis.readUTF());

        System.out.println(dis.readByte());

        

    }catch(IOException e){
        System.out.println("Error E/S");
    }
}
}
