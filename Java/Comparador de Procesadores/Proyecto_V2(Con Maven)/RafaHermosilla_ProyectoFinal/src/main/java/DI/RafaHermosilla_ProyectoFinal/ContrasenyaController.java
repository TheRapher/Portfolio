package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;

import java.util.Base64;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContrasenyaController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TextField txtCodigo;
    
    @FXML
    private Button btnCancelar;

    @FXML
    void Cancelar(ActionEvent event) {
    	FXMLLoader fxmlLoader = new FXMLLoader();

		try {
            fxmlLoader.setLocation(getClass().getResource("Login.fxml"));
            Stage stage = (Stage) txtCodigo.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
	    } 
    }
    @FXML
    void Confirmar(ActionEvent event) throws IOException {
    	if (!txtCodigo.getText().equals("")){
				comprobarCorreo(txtCodigo.getText());
	
    	}
    }
    private static void enviarCorreo(String destinatario,String usuario, String contra) throws IOException {
	   ServerCliente s = new ServerCliente();
	   s.start();
	   s.escribirTexto("enviarCorreoRecuperarCuenta");
	   s.escribirTexto(destinatario);
	   s.escribirTexto(usuario);
	   s.escribirTexto(contra);
	   s.stop();
	}
    //Metodo para saber si el correo existe
    public void comprobarCorreo(String correo) throws IOException {
    	ServerCliente s =new ServerCliente ();
    	s.start();
    	s.escribirTexto("comprobarCorreo");
    	s.escribirTexto(correo);

    	String correoDef = s.leerTexto();
    	String usuario =s.leerTexto();
    	String contra  =s.leerTexto();
    	
    	s.stop();
		
		if (correoDef.equals(correo)){
			byte[] contraDesencriptada = Base64.getDecoder().decode(contra);
			String contraDesencriptadaDef = new String(contraDesencriptada);
			enviarCorreo(correoDef,usuario,contraDesencriptadaDef);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Correo Enviado");
            alert.setContentText("**El correo se envio correctamente!!");
            alert.showAndWait();	
		}else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("El correo es incorrecto o no existe");
            alert.showAndWait();		
       }
    }
}
