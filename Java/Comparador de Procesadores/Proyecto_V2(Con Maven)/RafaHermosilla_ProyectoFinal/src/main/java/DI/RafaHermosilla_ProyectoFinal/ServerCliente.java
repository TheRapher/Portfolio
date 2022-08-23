package DI.RafaHermosilla_ProyectoFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ServerCliente {
	Socket clientSocket;
	DataInputStream entradaDatos;
	DataOutputStream salidaDatos;

	public void start() throws IOException {
		clientSocket = new Socket();
		System.out.println("Estableciendo la conexi�n");
		InetSocketAddress addr = new InetSocketAddress("localhost", 5559);
		clientSocket.connect(addr);
		InputStream is = clientSocket.getInputStream();
		OutputStream os = clientSocket.getOutputStream();
		//Para recibir y enviar enviar informacion
		entradaDatos = new DataInputStream(is);
		salidaDatos = new DataOutputStream(os);
	}
	
	
	public void escribirTexto(String texto) throws IOException {
		salidaDatos.writeUTF(texto);
	}
	public void escribirBooleano(Boolean texto) throws IOException {
		salidaDatos.writeBoolean(texto);
	}
	public void escribirInt(int texto) throws IOException {
		salidaDatos.writeInt(texto);
	}
	public int leerInt() throws IOException {
		return entradaDatos.readInt();
	}
	public void escribirDouble(double texto) throws IOException {
		salidaDatos.writeDouble(texto);
	}
	public double leerDouble() throws IOException {
		return entradaDatos.readDouble();
	}
	public String leerTexto() throws IOException {
		return entradaDatos.readUTF();
	}
	
	public Boolean leerBoolean() throws IOException {
		return entradaDatos.readBoolean();
	}
	public void stop() throws IOException {
		clientSocket.close();

	}
}
