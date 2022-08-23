package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException ;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Servidor extends Thread {
	private Socket clientSocket;

	public Servidor (Socket socket) {
		clientSocket = socket;
	}
	public void run () {
		try {
			
			System.out.println("Arrancando hilo");
			//Donde vamos a recibir y mandar informacion
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			DataInputStream entradaDatos = new DataInputStream(is);
			DataOutputStream salidaDatos = new DataOutputStream(os);
			//El cliente nos manda el comando a ejecutar
			String comando = entradaDatos.readUTF();
			
			
			if (comando.equals("conectarse")) {
				String nombre = entradaDatos.readUTF();
		    	String contrasenya=entradaDatos.readUTF();
		    	String nom ="";
		    	String contra ="";
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT usuario,contraseña FROM usuarios where usuario='"+nombre+"' and contraseña='"+contrasenya+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					nom = resul1.getString(1);
					contra = resul1.getString(2);
				}
				con.close();
				if (!nom.equals("") && !contra.equals("")){
					salidaDatos.writeBoolean(true);
				}else {
					salidaDatos.writeBoolean(false);
				}
				sentencia.close();
				con.close();
			}else if(comando.equals("comprobarUsuario")) {
				String nombre = entradaDatos.readUTF();
		    	String correoTmp=entradaDatos.readUTF();
				String usuario ="";
		    	String correo="";
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT usuario,correo FROM usuarios where usuario='"+nombre+"' or correo ='"+correoTmp+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					usuario =  resul1.getString(1);
					correo =  resul1.getString(2);
				}
				salidaDatos.writeUTF(usuario);
				salidaDatos.writeUTF(correo);
				sentencia.close();
				con.close();
			}else if(comando.equals("comprobarCorreo")) {
				String correo =entradaDatos.readUTF();
				String correoDef = "";
		    	String usuario ="";
		    	String contra  ="";
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT correo,usuario,contraseña FROM usuarios where correo='"+correo+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					correoDef = resul1.getString(1);
					usuario = resul1.getString(2);
					contra = resul1.getString(3);

				}
				salidaDatos.writeUTF(correoDef);
				salidaDatos.writeUTF(usuario);
				salidaDatos.writeUTF(contra);
				sentencia.close();
				con.close();
			}else if(comando.equals("enviarCorreoRecuperarCuenta")) {
				String destinatario = entradaDatos.readUTF();;
				String usuario =entradaDatos.readUTF();;
				String contra =entradaDatos.readUTF();;

			    Properties props = System.getProperties();
			    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
			    props.put("mail.smtp.user", "comparadorcpu@gmail.com");
			    props.put("mail.smtp.clave", "");    //La clave de la cuenta
			    props.put("mail.smtp.auth", "true");    //Usar autenticaciñn mediante usuario y clave
			    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
			    props.put("mail.smtp.port", "465");
			    props.put("mail.smtp.socketFactory.port", "465");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			    Session session = Session.getDefaultInstance(props);
			    MimeMessage message = new MimeMessage(session);

			    try {
			        message.setFrom(new InternetAddress("comparadorcpu@gmail.com"));
			        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
			        message.setSubject("Recuperar Contraseña...");
			        message.setText("Tu usuario es "+usuario+" y tu contraseña es "+contra);
			        Transport transport = session.getTransport("smtp");
			        transport.connect("smtp.gmail.com", "comparadorcpu@gmail.com", "");
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();
			    }
			    catch (MessagingException me) {
			        me.printStackTrace();   //Si se produce un error
			    }				
			}else if(comando.equals("enviarCorreoRegistro")) {
				int codigo = entradaDatos.readInt();
				String destinatario = entradaDatos.readUTF();;
				// Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
			    Properties props = System.getProperties();
			    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
			    props.put("mail.smtp.user", "comparadorcpu@gmail.com");
			    props.put("mail.smtp.clave", "");    //La clave de la cuenta
			    props.put("mail.smtp.auth", "true");    //Usar autenticaciñn mediante usuario y clave
			    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
			    props.put("mail.smtp.port", "465");
			    props.put("mail.smtp.socketFactory.port", "465");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			    Session session = Session.getDefaultInstance(props);
			    MimeMessage message = new MimeMessage(session);

			    try {
			        message.setFrom(new InternetAddress("comparadorcpu@gmail.com"));
			        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
			        message.setSubject("Registrarse en Toy Computer");
			        message.setText("Hola usuario!\nPor favor copie este codigo "+codigo+ " para poder registrarse");
			         Transport transport = session.getTransport("smtp");
			        transport.connect("smtp.gmail.com", "comparadorcpu@gmail.com", "");
			        transport.sendMessage(message, message.getAllRecipients());
			        //PONER LBL DE CORREO ENVIADO	        
			        transport.close();
			    }
			    catch (MessagingException me) {
			        me.printStackTrace();   //Si se produce un error
			    }				
			}else if(comando.equals("enviarCorreoVerificacion")) {
				int codigo =entradaDatos.readInt();
				String destinatario = entradaDatos.readUTF();
				// Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
			    Properties props = System.getProperties();
			    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
			    props.put("mail.smtp.user", "comparadorcpu@gmail.com");
			    props.put("mail.smtp.clave", "");    //La clave de la cuenta
			    props.put("mail.smtp.auth", "true");    //Usar autenticaciñn mediante usuario y clave
			    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
			    props.put("mail.smtp.port", "465");
			    props.put("mail.smtp.socketFactory.port", "465");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			    Session session = Session.getDefaultInstance(props);
			    MimeMessage message = new MimeMessage(session);

			    try {
			        message.setFrom(new InternetAddress("comparadorcpu@gmail.com"));
			        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
			        message.setSubject("Verificar inicio de sesion...");
			        message.setText("Hola usuario!\nPor favor copie este codigo "+codigo+" para poder registrarse");
			        Transport transport = session.getTransport("smtp");
			        transport.connect("smtp.gmail.com", "comparadorcpu@gmail.com", "");
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();
			    }
			    catch (MessagingException me) {
			        me.printStackTrace();  
			    }				
			}else if(comando.equals("comprobarNombreCPU")){
				String nombreUsuario = entradaDatos.readUTF(); 
				String nombre =entradaDatos.readUTF(); 
				String cpu1 ="";
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT Nombre FROM cpu_usuarios where Nombre='"+nombre+"' and idUsuario='"+nombreUsuario+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					cpu1 = resul1.getString(1);
				}
				
				sentencia.close();
				con.close();
				if (cpu1.equals("")  ){
					salidaDatos.writeBoolean(true);
				}else {
					salidaDatos.writeBoolean(false);
				}

			}else if(comando.equals("meterCPU")){
				//Crear una clase
				String txtNombre=entradaDatos.readUTF(); 
				String cbxMarca=entradaDatos.readUTF(); 
				String txtFrecuencia=entradaDatos.readUTF(); 
				String txtFrecuenciaMax=entradaDatos.readUTF(); 
				String txtNucleos=entradaDatos.readUTF(); 
				String txtMemoria=entradaDatos.readUTF(); 
				String txtEnlace=entradaDatos.readUTF(); 
				String txtHilos=entradaDatos.readUTF(); 
				String UsuarioGlobal=entradaDatos.readUTF(); 
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String agregar1="INSERT INTO cpu_usuarios(Nombre,Marca,Frecuencia, FrecuenciaMAX, Nucleos,Memoria, Enlace,Hilos,idUsuario)"+ "VALUES ('"+txtNombre+"','"+cbxMarca+"','"+txtFrecuencia+"','"+txtFrecuenciaMax+"','"+txtNucleos+"','"+txtMemoria+"','"+txtEnlace+"','"+txtHilos+"','"+UsuarioGlobal+"');";
			
				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(agregar1);
				
				sentencia.close();
				con.close();
			}else if(comando.equals("meterUsuario")) {
				String nombre=entradaDatos.readUTF(); 
				String contrasenya=entradaDatos.readUTF(); 
				String correo=entradaDatos.readUTF(); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String agregar1="INSERT INTO usuarios (usuario,contraseña, correo, Tipo,Verificacion)"+ "VALUES ('"+nombre+"','"+contrasenya+"','"+correo+"','PRUEBA','No');";
				
				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(agregar1);
				
				sentencia.close();
				con.close();
			}else if(comando.equals("meterValoracion")) {
				String usuario=entradaDatos.readUTF(); 
				String valoracion=entradaDatos.readUTF();
				String cpu1 =entradaDatos.readUTF();
				String cpu2 =entradaDatos.readUTF();
				String agregar1="";
				int id1 = 0;
				int id2 = 0;

				if (obtenerTipoCPU_Usuario(cpu1,usuario) && obtenerTipoCPU_Usuario(cpu2,usuario)) {
					 id1 = obtenerIdCPU_Usuario(cpu1,usuario);
					 id2 = obtenerIdCPU_Usuario(cpu1,usuario);
					 agregar1="INSERT INTO valoraciones_usuarios(id_usuario,valoracion,cpu1_usuario,cpu2_usuario)"+ "VALUES ('"+usuario+"','"+valoracion+"','"+id1+"','"+id2+"');";
				}else if(obtenerTipoCPU_Usuario(cpu1,usuario) && obtenerTipoCPU_Usuario(cpu2,usuario) == false) {
					 id1 = obtenerIdCPU_Usuario(cpu1,usuario);
					 agregar1="INSERT INTO valoraciones_usuarios(id_usuario,valoracion,cpu2,cpu1_usuario)"+ "VALUES ('"+usuario+"','"+valoracion+"','"+cpu2+"','"+id1+"');";

				}else if(obtenerTipoCPU_Usuario(cpu1,usuario) ==false && obtenerTipoCPU_Usuario(cpu2,usuario) ) {
					 id2 = obtenerIdCPU_Usuario(cpu2,usuario);
					 agregar1="INSERT INTO valoraciones_usuarios(id_usuario,valoracion,cpu1,cpu2_usuario)"+ "VALUES ('"+usuario+"','"+valoracion+"','"+cpu1+"','"+id2+"');";

				}else if(obtenerTipoCPU_Usuario(cpu1,usuario) ==false && obtenerTipoCPU_Usuario(cpu2,usuario) ==false ) {
					 id2 = obtenerIdCPU_Usuario(cpu2,usuario);
					 agregar1="INSERT INTO valoraciones_usuarios(id_usuario,valoracion,cpu1,cpu2)"+ "VALUES ('"+usuario+"','"+valoracion+"','"+cpu1+"','"+cpu2+"');";
				}
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");

				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(agregar1);
				
				sentencia.close();
				con.close();
			}else if(comando.equals("cargarProcesadores")) {
				String UsuarioGlobal = entradaDatos.readUTF(); 
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT * FROM cpu_usuarios where idUsuario = '"+UsuarioGlobal+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				boolean tmp = true;
				while(resul1.next() ) {
					salidaDatos.writeBoolean(tmp);
					salidaDatos.writeUTF(resul1.getString(2));
				}
				tmp = false;
				salidaDatos.writeBoolean(tmp);
				sentencia.close();
				con.close();

			}else if(comando.equals("obtenerCPU_BaseDatos")) {
				String nombre = entradaDatos.readUTF();
				CPU cpu = null;
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT * FROM cpu_defecto where nombre='"+nombre+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
			    	cpu = new CPU(resul1.getString(1), resul1.getString(2), resul1.getDouble(3), resul1.getDouble(4), resul1.getInt(5),resul1.getInt(6), resul1.getString(7), resul1.getInt(8));
				}
				sentencia.close();
				con.close();
				if (cpu==null) {
					cpu = obtenerCPU_UsuarioBaseDatos(nombre);
					salidaDatos.writeUTF(cpu.getNombre());
					salidaDatos.writeUTF(cpu.getMarca());
					salidaDatos.writeDouble(cpu.getFrecuenciaReloj());
					salidaDatos.writeDouble(cpu.getFrecuenciaRelojMax());
					salidaDatos.writeInt(cpu.getNumNucleos());
					salidaDatos.writeInt(cpu.getMemoriaCache());
					salidaDatos.writeUTF(cpu.getEnlace());
					salidaDatos.writeInt(cpu.getNumHilos());
				}else {
				salidaDatos.writeUTF(cpu.getNombre());
				salidaDatos.writeUTF(cpu.getMarca());
				salidaDatos.writeDouble(cpu.getFrecuenciaReloj());
				salidaDatos.writeDouble(cpu.getFrecuenciaRelojMax());
				salidaDatos.writeInt(cpu.getNumNucleos());
				salidaDatos.writeInt(cpu.getMemoriaCache());
				salidaDatos.writeUTF(cpu.getEnlace());
				salidaDatos.writeInt(cpu.getNumHilos());
				}

			}else if(comando.equals("actualizarCPU")) {
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT * FROM cpu_defecto;";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				boolean tmp = true;
				while(resul1.next()) {
					salidaDatos.writeBoolean(tmp);
					salidaDatos.writeUTF(resul1.getString(1));
					salidaDatos.writeUTF(resul1.getString(2));
					salidaDatos.writeDouble(resul1.getDouble(3));
					salidaDatos.writeDouble(resul1.getDouble(4));
					salidaDatos.writeInt(resul1.getInt(5));
					salidaDatos.writeInt(resul1.getInt(6));
					salidaDatos.writeUTF(resul1.getString(7));
					salidaDatos.writeInt(resul1.getInt(8));
				}
				tmp = false;
				salidaDatos.writeBoolean(tmp);

				sentencia.close();
				con.close();
				
				
			}else if(comando.equals("actualizarCPU_Usuarios")) {
	    	String usuario = entradaDatos.readUTF();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
			String sql="SELECT * FROM cpu_usuarios where idUsuario ='"+usuario+"';";
			Statement sentencia = con.createStatement();
			ResultSet resul1 = sentencia.executeQuery(sql);
			boolean tmp = true;
			while(resul1.next()) {
				salidaDatos.writeBoolean(tmp);
				salidaDatos.writeUTF(resul1.getString(2));
				salidaDatos.writeUTF(resul1.getString(3));
				salidaDatos.writeDouble(resul1.getDouble(4));
				salidaDatos.writeDouble(resul1.getDouble(5));
				salidaDatos.writeInt(resul1.getInt(6));
				salidaDatos.writeInt(resul1.getInt(7));
				salidaDatos.writeUTF(resul1.getString(8));
				salidaDatos.writeInt(resul1.getInt(9));
			}
			tmp = false;
			salidaDatos.writeBoolean(tmp);

			sentencia.close();
			con.close();
			
			
		}else if (comando.equals("hayProcesadores")) {
		        List<String> items = new ArrayList<String>();

		    	String usuario = entradaDatos.readUTF();
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT * FROM cpu_usuarios where idUsuario = '"+usuario+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next() ) {
					items.add(resul1.getString(2));
				}
				sentencia.close();
				con.close();				
				if (items.isEmpty()) {
					salidaDatos.writeBoolean(false);
				}else {
					salidaDatos.writeBoolean(true);
				}
			}else if (comando.equals("totalCPU")) {
		    	int total = 0;
		    	String usuario = entradaDatos.readUTF();
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT * FROM cpu_usuarios where idUsuario = '"+usuario+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next() ) {
					total +=1;
				}
				sentencia.close();
				con.close();
				
				salidaDatos.writeInt(total);
			}else if (comando.equals("tipoUsuario")) {
		        String tipoUsuario="";
		    	String usuario = entradaDatos.readUTF();
		    	
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT Tipo FROM usuarios where usuario = '"+usuario+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next() ) {
					tipoUsuario = resul1.getString(1);
				}
				sentencia.close();
				con.close();
				salidaDatos.writeUTF(tipoUsuario);
				
			}else if (comando.equals("tipoVerificacion")) {
		    	String usuario = entradaDatos.readUTF();
		    	
		    	String verificacion = "";

		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT Verificacion FROM usuarios where usuario='"+usuario+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					verificacion = resul1.getString(1);
				}
				con.close();
				if (verificacion.equals("Si")){
					salidaDatos.writeBoolean(true);
				}else {
					salidaDatos.writeBoolean(false);
				}
			}else if(comando.equals("editarProcesador")) {
				String opcion =entradaDatos.readUTF();
				String opcion2 = entradaDatos.readUTF();
				String usuario = entradaDatos.readUTF();
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String agregar1="UPDATE `cpu_usuarios` SET `"+opcion+"`='"+opcion2+"' WHERE id="+sacarID(usuario)+"";
			
				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(agregar1);
				
				sentencia.close();
				con.close();
			}else if(comando.equals("borrarProcesadores")) {
				String usuario = entradaDatos.readUTF();
				String nombreCPU = entradaDatos.readUTF();
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="DELETE FROM `cpu_usuarios` WHERE idUsuario='"+usuario+"' and Nombre ='"+nombreCPU+"'";
				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(sql);
				sentencia.close();
				con.close();
			}else if(comando.equals("actualizarContrasenya")) {
				String usuario = entradaDatos.readUTF();
				String contrasenya = entradaDatos.readUTF();
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		    	String agregar3="UPDATE `usuarios` SET `contraseña`='"+contrasenya+"' WHERE usuario = '"+usuario+"'";
				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(agregar3);
				sentencia.close();
				con.close();	
			}else if (comando.equals("actualizarCorreo")) {
				String nuevoCorreo = entradaDatos.readUTF();
				String usuario = entradaDatos.readUTF();
		    	if (comprobarCorreoParaEditar(nuevoCorreo) == true) {
		    		salidaDatos.writeBoolean(false);

		    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		    		String agregar3="UPDATE `usuarios` SET `correo`='"+nuevoCorreo+"' WHERE usuario = '"+usuario+"'";
		    		Statement sentencia = con.createStatement();
		    		sentencia.executeUpdate(agregar3);
		    		sentencia.close();
		    		con.close();
		    		
		    	}else {
		    		salidaDatos.writeBoolean(true);
		    	}
			}else if(comando.equals("modificarTipo")) {
				String usuario =entradaDatos.readUTF();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
	    		String agregar3="UPDATE `usuarios` SET `tipo`='PREMIUM' WHERE usuario = '"+usuario+"'";
	    		Statement sentencia = con.createStatement();
	    		sentencia.executeUpdate(agregar3);
	    		sentencia.close();
	    		con.close();
			}else if(comando.equals("modificarVerificacion")) {
				String usuario =entradaDatos.readUTF();
				String verificacion = entradaDatos.readUTF();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String agregar3="UPDATE `usuarios` SET `Verificacion`='"+verificacion+"' WHERE usuario = '"+usuario+"'";
	    		Statement sentencia = con.createStatement();
	    		sentencia.executeUpdate(agregar3);
	    		sentencia.close();
	    		con.close();
			}else if (comando.equals("getCorreo")) {
				String usuario =entradaDatos.readUTF();
				String correo = "";
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT correo FROM usuarios where usuario='"+usuario+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					correo = resul1.getString(1);
				}
				con.close();
				resul1.close();
				salidaDatos.writeUTF(correo);
			}else if(comando.equals("numFactura")) {
		    	int numero = 0;
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT count(usuario) FROM usuarios where tipo='PREMIUM';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				while(resul1.next()) {
					numero = resul1.getInt(1);
				}
				numero +=1;
				con.close();
				resul1.close();
				salidaDatos.writeInt(numero);
			}else if(comando.equals("actualizarUsuario")) {
				String nuevoUsuario= entradaDatos.readUTF();
				String usuario= entradaDatos.readUTF();
				if (comprobarExisteUsuario(nuevoUsuario) == true) {
					salidaDatos.writeBoolean(false);
		    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		    		String agregar3="UPDATE `usuarios` SET `usuario`='"+nuevoUsuario+"' WHERE usuario = '"+usuario+"'";
		    		Statement sentencia = con.createStatement();
		    		sentencia.executeUpdate(agregar3);
		    		sentencia.close();
		    		con.close();
		    		
		    	}else {
		    		salidaDatos.writeBoolean(true);
		    	}
			}else if(comando.equals("informacion")) {
				String usu =entradaDatos.readUTF();
				String usuario = "";
				String contra= "";
				String email= "";
				String tipoUsuario= "";
				String Verificacion= "";

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
				String sql="SELECT * FROM usuarios where usuario='"+usu+"';";
				Statement sentencia = con.createStatement();
				ResultSet resul1 = sentencia.executeQuery(sql);
				
				while(resul1.next()) {
					usuario=resul1.getString(1);
					contra = resul1.getString(2);
					email=resul1.getString(3);
					tipoUsuario=resul1.getString(4);
					Verificacion=resul1.getString(5);
				}
				//objectOut.writeObject(informacion);
				resul1.close();
				sentencia.close();
				con.close();
				
				salidaDatos.writeUTF(usuario);
				salidaDatos.writeUTF(contra);
				salidaDatos.writeUTF(email);
				salidaDatos.writeUTF(tipoUsuario);
				salidaDatos.writeUTF(Verificacion);

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hilo terminado");
	}
	public boolean comprobarCorreoParaEditar(String nuevoCorreo) throws SQLException {
		String nombre =" ";
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		String sql="SELECT usuario FROM usuarios where correo='"+nuevoCorreo+"';";
		Statement sentencia = con.createStatement();
		ResultSet resul1 = sentencia.executeQuery(sql);
		while(resul1.next()) {
			nombre = resul1.getString(1);
		}
		System.out.print(nombre);
		if (nombre.equals(" ")){
			return true;
		}else {
			return false;
		}
	}
	//Funcion para saber si el procesador es creado por el usuario para meterlo en las valoraciones
	public boolean obtenerTipoCPU_Usuario(String cpu,String usuario) throws SQLException {
		int id = -1;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		String sql="SELECT id FROM cpu_usuarios where nombre='"+cpu+"' and idUsuario='"+usuario+"';";
		Statement sentencia = con.createStatement();
		ResultSet resul1 = sentencia.executeQuery(sql);
		while(resul1.next()) {
	    	id = resul1.getInt(1);
		}
		sentencia.close();
		con.close();
		
		if(id== -1)
		{
			return false;
		}else {
			return true;
		}

	}
	public int obtenerIdCPU_Usuario(String cpu,String usuario) throws SQLException {
		int id = 0;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		String sql="SELECT id FROM cpu_usuarios where nombre='"+cpu+"' and idUsuario='"+usuario+"';";
		Statement sentencia = con.createStatement();
		ResultSet resul1 = sentencia.executeQuery(sql);
		while(resul1.next()) {
	    	id = resul1.getInt(1);
		}
		sentencia.close();
		con.close();
		
		return id;
	}
	public CPU obtenerCPU_UsuarioBaseDatos(String nombre) throws SQLException {
		CPU cpu = null;
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		String sql="SELECT * FROM cpu_usuarios where nombre='"+nombre+"';";
		Statement sentencia = con.createStatement();
		ResultSet resul1 = sentencia.executeQuery(sql);
		while(resul1.next()) {
	    	cpu = new CPU(resul1.getString(2), resul1.getString(3), resul1.getDouble(4), resul1.getDouble(5), resul1.getInt(6),resul1.getInt(7), resul1.getString(8), resul1.getInt(9));
		}
		sentencia.close();
		con.close();
		return cpu;
	}
    public boolean comprobarExisteUsuario(String usuario) throws SQLException {
    	String nom =" ";
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		String sql="SELECT usuario FROM usuarios where usuario='"+usuario+"';";
		Statement sentencia = con.createStatement();
		ResultSet resul1 = sentencia.executeQuery(sql);
		while(resul1.next()) {
			nom = resul1.getString(1);
		}
		System.out.print(nom);
		if (nom.equals(" ")){
			return true;
		}else {
			return false;
		}
    }
    
	//Funcion para poder editar el procesador
    public String sacarID(String usuario) throws SQLException {
    	String id ="";
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/comparador_cpu?"+ "user=rafa&password=rafa");
		String sql="SELECT * FROM cpu_usuarios where idUsuario = '"+usuario+"';";
		Statement sentencia = con.createStatement();
		ResultSet resul1 = sentencia.executeQuery(sql);
		while(resul1.next() ) {
			id = resul1.getString(1);
		}
		con.close();
		return id;
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
				Servidor hilo = new Servidor(newSocket);
				hilo.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Terminado");
	}
}