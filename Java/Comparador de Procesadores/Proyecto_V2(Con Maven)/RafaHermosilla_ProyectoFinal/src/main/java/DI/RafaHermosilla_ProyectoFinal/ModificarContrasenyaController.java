package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;

import java.util.Base64;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ModificarContrasenyaController {

    @FXML
    private PasswordField lblContrasenya;

    @FXML
    private PasswordField lblConfirmarContrasenya;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblContrasenya1;

    @FXML
    private Label lblContrasenya2;
    @FXML
    void Confirmar(ActionEvent event) throws IOException {
    	if(!lblContrasenya.getText().equals(lblConfirmarContrasenya.getText()) ) {
    		lblContrasenya1.setText("*Contraseña no coincide");
    		lblContrasenya2.setText("*Contraseña no coincide");

    		lblContrasenya1.setVisible(true);
    		lblContrasenya2.setVisible(true); 
    	
            

    	}else if(comprobarContrasenya()){

    		lblContrasenya1.setVisible(false);
    		lblContrasenya2.setVisible(false);
    		
    		//Llamamos a la funcion para cambiar la contrasenya
    		actualizarContrasenya(ComparatorCPUController.UsuarioGlobal,lblConfirmarContrasenya.getText());
    		
    		//Creamos un alert para informar al usuario
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Cambio de Contraseña");
            alert.setContentText("Su contraseña se cambio correctamente.\n\nDebe cerrar sesion si quiere ver los cambios");
            
            //Si el usuario le da al boton Cierra esta ventana
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
                stage.close();
            }
    		}
    }
    
    public void actualizarContrasenya(String usuario,String contrasenya) throws IOException {
    	String contraEncriptada = Base64.getEncoder().encodeToString(contrasenya.getBytes());
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("actualizarContrasenya");
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	s.escribirTexto(contraEncriptada);
    	s.stop();
    }
    public boolean comprobarContrasenya() {
    	lblContrasenya1.setVisible(false);
		lblContrasenya2.setVisible(false);
		

    	boolean bandera = true;
    	//Saber si la cadena es mayor de 10 caracteres 
    	if (lblContrasenya.getText().length() <10) {
    		//Mensaje de error
    		lblContrasenya1.setVisible(true);
    		lblContrasenya1.setText("*Longitud > 10");
    		bandera = false;
      	}else {
      		lblContrasenya1.setVisible(false);
      		bandera = true;

    	}
    	if (bandera ==true) {
    	//Saber si tiene alguna mayuscula
    		for (int i=0;i<lblContrasenya.getText().length(); i++){
    			if (Character.isUpperCase(lblContrasenya.getText().charAt(i))) {
    				lblContrasenya1.setVisible(false);
    				bandera = true;
    				break;
    			}else {
    				lblContrasenya1.setVisible(true);
    				lblContrasenya1.setText("*Debe tener Mayusculas");
    				bandera = false;
    			}
    		}
    	}
    	if(bandera == true) {
    		if(lblContrasenya.getText().contains("@") || lblContrasenya.getText().contains(".") || lblContrasenya.getText().contains(",")){
    			lblContrasenya1.setVisible(false);
				bandera = true;
    		}else {
    			lblContrasenya1.setVisible(true);
    			lblContrasenya1.setText("*Debe tener(@.,)");
				bandera = false;	

    		}
    	}
    	return bandera;
    }
}
