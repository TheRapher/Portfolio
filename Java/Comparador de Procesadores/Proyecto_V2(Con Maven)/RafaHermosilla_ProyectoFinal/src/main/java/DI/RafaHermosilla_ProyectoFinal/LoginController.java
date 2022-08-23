package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;

import java.util.Base64;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {


    @FXML
    private TextField txtUsuario;

    @FXML
    public Button btnLogin;

    @FXML
    private Label lblContraseña;

    @FXML
    private Label lblRegistro;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    void AccederAplicacion(ActionEvent event) throws  IOException {
    	if (conectarse(txtUsuario.getText(),txtContraseña.getText())) {
    		if (tipoVerificacion(txtUsuario.getText())) {
    			FXMLLoader fxmlLoader = new FXMLLoader();

    			try {
                    fxmlLoader.setLocation(getClass().getResource("VerificacionCorreo.fxml"));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                    
                    //Mandamos informacion a la ventana principal
                    VerificacionCorreoController controlador =(VerificacionCorreoController) fxmlLoader.getController();
                    controlador.setUsuario(txtUsuario.getText());

        		} catch (IOException e) {
        			e.printStackTrace();
        	    }                          
    		}else {
    			FXMLLoader fxmlLoader = new FXMLLoader();

    			try {
                    fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
    		
                    //Mandamos informacion a la ventana principal
                    ComparatorCPUController controlador =(ComparatorCPUController) fxmlLoader.getController();
                    controlador.setUsuario(txtUsuario.getText());

        		} catch (IOException e) {
        			e.printStackTrace();
        	    }                          
    		}
    	}
    }

    @FXML
    void accesoRegistro(MouseEvent event) {
    	try {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Registro.fxml"));
        Stage stage = (Stage) lblRegistro.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setScene(scene);		
        } catch (IOException e) {
		e.printStackTrace();
        }
    }

    @FXML
    void cambiarEscenaContraseña(MouseEvent event) {
    	try {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Contrasenya.fxml"));
        Stage stage = (Stage) lblRegistro.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setScene(scene);		
        } catch (IOException e) {
		e.printStackTrace();
        }
    }

    //Cuando pase el cursor por el label se cambiara
    @FXML
    void cambiarForma(MouseEvent event) {
    	lblContraseña.setCursor(Cursor.HAND);
    }

    @FXML
    void cambiarForma2(MouseEvent event) {
    	lblRegistro.setCursor(Cursor.HAND);

    }
    public boolean conectarse(String nombre, String contrasenya) throws IOException {
    	boolean entra;
    	ServerCliente s = new ServerCliente();
    	s.start();

    	String originalInput = contrasenya;
    	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
    	s.escribirTexto("conectarse");
    	s.escribirTexto(nombre);
    	s.escribirTexto(encodedString);
    	entra =s.leerBoolean();
    	s.stop();
    	return entra;
    }
    public boolean tipoVerificacion(String nombre) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("tipoVerificacion");
    	s.escribirTexto(nombre);
    	boolean tipoVerificacion =s.leerBoolean();
    	s.stop();
    	return tipoVerificacion;
    }

}
