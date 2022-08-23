package practicaFinal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException ;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.time.LocalDateTime;

public class EJServidor4 extends Thread {
	private Socket clientSocket;
	//Variables estaticas para que se queden guardadas y ver cuantas veces hemos accedido a cada tipo
	static int tipo1_Usuarios = 0;
	static int tipo2_Usuarios= 0;
	public EJServidor4 (Socket socket) {
		clientSocket = socket;
	}
	public void run () {
		try {
			
			System.out.println("Arrancando hilo");
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			//Donde vamos a recibir y mandar informacion
			DataInputStream entradaDatos = new DataInputStream(is);
			DataOutputStream salidaDatos = new DataOutputStream(os);
			//Donde vamos a mostrar los mensajes del cliente
			String mensajes = "";
			long inicio = 0;
			//Donde vamos a guardar la informacion del fichero
			PrintWriter pw =new PrintWriter(new FileOutputStream("log.txt",true));
			
			System.out.println("Esperando mensaje de operación");
			mensajes = entradaDatos.readUTF();
			System.out.println("Mensaje Recibido: "+ new String(mensajes));
			if(mensajes.equals("Hola Servidor")) {
				String entrada = "1234";
				System.out.println("Enviando autentificacion de usuario...");
				salidaDatos.writeUTF(entrada);
			} else {
				System.out.println("Operación no reconocida");
			}
			//El cliente nos manda el usuario
			String usuario = entradaDatos.readUTF();
			int tipo = entradaDatos.readInt();
			if (tipo ==1) {
				tipo1_Usuarios++;
				System.out.print(usuario);
				//Empezamos a contar los segundos
				inicio = System.currentTimeMillis();
				//Guardamos en el fichero el nombre de usuario y la hora
				pw.println("Usuario: "+usuario);
				pw.println("Se inicio sesion: "+LocalDateTime.now());
				//Le enviamos un booleano para que esten en constante comunicacion y cuando el cliente ponga la frase clave nuestro booleano se pondra en false
				boolean autenticacion = true;
				salidaDatos.writeBoolean(autenticacion);
				System.out.print("Usuario Conectado...");
				while(autenticacion ==true) {
					mensajes = entradaDatos.readUTF();
					System.out.println("Mensaje del cliente: "+mensajes);
					if (mensajes.equals("Adios servidor")) {
						autenticacion = false;
					}
				}
			
			//Cogemos los segundos y hacemos el calculo para calcular cuantos segundos estuvimos y los guardamos en el fichero
	        long fin = System.currentTimeMillis();
	        double tiempo = (double) ((fin - inicio)/1000);
	        pw.println("Duracion: "+tiempo+" segundos");
	        pw.close();
			}else if (tipo ==2) {
				tipo2_Usuarios++;
				//Ponemos que hasta que no termine de leerse el fichero no se finalice ni el cliente ni el servidor
				
				String ruta = new File ("log.txt").getAbsolutePath ();
				File archivo = new File (ruta);

				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
		        while((linea=br.readLine())!=null) {
					System.out.println(linea);
					salidaDatos.writeUTF(linea);
		        }
		        salidaDatos.writeUTF(" ");
		     //Si el cliente nos pone que es de tipo 3 entrara en esta zona donde vamos a leer el tipo de informacion que quiere leer y depende del numero que ponga le devolveremos una cosa
			}else if (tipo ==3) {
				int tipo2 =entradaDatos.readInt();
				if (tipo2 ==1) {
					salidaDatos.writeInt(tipo1_Usuarios);
				}else if(tipo2 ==2) {
					salidaDatos.writeInt(tipo2_Usuarios);
				}else {
					salidaDatos.writeUTF("Error");

					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("Hilo terminado");
	}
	public static void main (String[] args) {
		System.out.println("Creando socket servidor");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			System.out.println ("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5559);
			serverSocket.bind(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Aceptando conexiones");
		while (serverSocket != null) {
			try {
				Socket newSocket = serverSocket.accept();
				System.out.println("Conexión recibida");
				EJServidor4 hilo = new EJServidor4(newSocket);
				hilo.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Terminado");
	}
}