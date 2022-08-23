package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class RegistroController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContraseña;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtContraseñaConfirmar;
    @FXML
    private ImageView imgAtras;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblConfirmarContraseña;

    @FXML
    private Label lblContraseña;

    @FXML
    private Label lblContraseña2;
    
    @FXML
    private Label lblUsuario;
    @FXML
    private Label LimitadorUsuario;

    int i =0;
    
	boolean bandera = false;

    @FXML
    void limitador(KeyEvent event) {
    	if (txtUsuario.getText().length() >10) {
    		txtUsuario.deletePreviousChar();
    	}

    	LimitadorUsuario.setText(txtUsuario.getText().length()+"/10");
    }
    
    @FXML
    void Atras(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) imgAtras.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void Confirmar(ActionEvent event) throws IOException {
    	//Comprobar que el usuario y el correo no existe en la Base de Datos
    	if(comprobarUsuario(txtUsuario.getText(),txtCorreo.getText())) {
    		bandera = true;
    	}
    	//Confirmamos si la contraseña es la misma
    	if (!txtContraseña.getText().equals(txtContraseñaConfirmar.getText())){
    		bandera = true;
    		lblConfirmarContraseña.setText("*Contraseña no coincide");
    		lblConfirmarContraseña.setVisible(true);
    	}else {
    		lblConfirmarContraseña.setVisible(false);
    	}

    	//Comprobamos que el campo no este vacio
    	if(txtContraseña.getText() == ""){
    		bandera = true;
    		lblContraseña.setText("*Campo obligatorio");
    		lblContraseña.setVisible(true);
    	}else {
        	//Llamamos al metodo para ver si esta bien compuesta la contrasenya
        	comprobarContrasenya();

    		lblContraseña.setVisible(false);

    	}
    	//Comprobamos que el campo no este vacio
    	if(txtUsuario.getText().equals("")) {
    		bandera = true;
    		lblUsuario.setText("*Campo obligatorio");
    		lblUsuario.setVisible(true);
    	}else {
    		lblUsuario.setVisible(false);

    	}
    	//Comprobamos que el campo no este vacio
    	if(txtCorreo.getText().equals("")) {
    		bandera = true;
    		lblCorreo.setText("*Campo obligatorio");
    		lblCorreo.setVisible(true);
    	}else {
    		lblCorreo.setVisible(false);
    	}

    	//Si todo fue bien entra y llamamos a la siguiente ventana...
    	if(bandera == false){
    		Usuario usu = new Usuario(txtUsuario.getText(),txtContraseña.getText(),txtCorreo.getText(),"","");
    		
			FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("Confirmar.fxml"));

	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.setTitle("Confirmar");
	        stage.initModality(Modality.APPLICATION_MODAL);

    		ConfirmarController confirmar = (ConfirmarController) fxmlLoader.getController();
    		confirmar.setUsuario(usu);
            stage.showAndWait();
    	}
    }
    //Comprobamos si el usuario existe...
    public boolean comprobarUsuario(String nombre,String correoTmp) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("comprobarUsuario");
    	s.escribirTexto(nombre);
    	s.escribirTexto(correoTmp);
    	String usuario =s.leerTexto();
    	String correo=s.leerTexto();
    	s.stop();
		
		if(correo.equals(correo) && usuario.equals(nombre)) {
			lblCorreo.setText("*El correo ya existe");
    		lblCorreo.setVisible(true);
    		lblUsuario.setText("*El usuario ya existe");
    		lblUsuario.setVisible(true);
			return true;
		}else if(correo.equals(correo)) {
			lblCorreo.setText("*El correo ya existe");
    		lblCorreo.setVisible(true);
			return true;
		}else if (usuario.equals(nombre)){
			lblUsuario.setText("*El usuario ya existe");
    		lblUsuario.setVisible(true);
			return true;
		}else {
    		lblUsuario.setVisible(false);
    		lblCorreo.setVisible(false);
			return false;
		}	
    }
    public void comprobarContrasenya() {
    	//Saber si la cadena es mayor de 10 caracteres 
    	if (txtContraseña.getText().length() <10) {
    		//Mensaje de error
    		lblContraseña2.setVisible(true);
    		lblContraseña2.setText("*Longitud > 10");
    		bandera = true;
      	}else {
      		lblContraseña2.setVisible(false);
      		bandera = false;

    	}
    	if (bandera ==false) {
    	//Saber si tiene alguna mayuscula
    		for (int i=0;i<txtContraseña.getText().length(); i++){
    			if (Character.isUpperCase(txtContraseña.getText().charAt(i))) {
    				lblContraseña2.setVisible(false);
    				bandera = false;
    				break;
    			}else {
    				lblContraseña2.setVisible(true);
    				lblContraseña2.setText("*Debe tener Mayusculas");
    				bandera = true;
    			}
    		}
    	}
    	if(bandera == false) {
    		if(txtContraseña.getText().contains("@") || txtContraseña.getText().contains(".") || txtContraseña.getText().contains(",")){
				lblContraseña2.setVisible(false);
				bandera = false;
    		}else {
				lblContraseña2.setVisible(true);
				lblContraseña2.setText("*Debe tener(@.,)");
				bandera = true;	

    		}
    	}
    }
}