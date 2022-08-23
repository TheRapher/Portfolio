package practicaFinal;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EJCliente4 {
	public static void main (String[] args) {
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5559);
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			//Para recibir y enviar enviar informacion
			DataInputStream entradaDatos = new DataInputStream(is);
			DataOutputStream salidaDatos = new DataOutputStream(os);
			Scanner sc = new Scanner(System.in);
			int tipo =0;
			//Para enviar el char al servidor
			String chat ="";
			boolean chatServer =true;
			//Enviar clave para acceder
			salidaDatos.writeUTF("Hola Servidor");
			System.out.println("Enviando mensaje...");
			
			System.out.println("Recibiendo resultado");
			String result = entradaDatos.readUTF();
			//Si el resultado que nos da el server es 1234 significa que la clave esta bien y podemos enviar nuestro usuario
			if(result.equals("1234")) {
				System.out.print("Dime tu usuario:");
				String usuario = sc.next();
				salidaDatos.writeUTF(usuario);
				System.out.print("Dime tipo de conexion(1 al 3):");
				tipo = sc.nextInt();
				salidaDatos.writeInt(tipo);
			}
			if(tipo ==1) {
			//Nos envia un booleano el server para estar conectados a el hasta que nosotros pongamos la frase Adios servidor
			boolean autentificar = entradaDatos.readBoolean();
			if (autentificar ==true) {
				while(autentificar ==true) {
					System.out.print("Dime tu mensaje:");
					chat = sc.nextLine();
					salidaDatos.writeUTF(chat);
					if(chat.equals("Adios servidor")) {
						autentificar=false;
					}
				}
			}
			}else if(tipo ==2) {
				String linea = "";
				System.out.println("Recibiendo informacion del fichero...");
				while(!linea.equals(" ")) {
				linea = entradaDatos.readUTF();
				System.out.println(linea);
				}
			//Cuando sea de tipo 3 nos preguntara que informacion de usuario queremos ver y depende de lo que pongamos nos pondra error o no
			}else if(tipo ==3) {
			System.out.println("¿De que tipo de usuario quieres recibir informacion?(1 o 2)");
			int tipo2 = sc.nextInt();
			salidaDatos.writeInt(tipo2);
			if(tipo2 ==1 || tipo2 ==2) {
				System.out.println("Usuarios conectados: "+entradaDatos.readInt());

			}else {
				System.out.println(entradaDatos.readUTF());
			
			}
			}
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}