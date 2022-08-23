package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarUsuarioController {

    @FXML
    private TextField lblUsuario;

    @FXML
    private Button btnConfirmar;
    @FXML
    private Label lblUsuarioExiste;
    @FXML
    void Confirmar(ActionEvent event) throws IOException {
    	
    		//Llamamos a la funcion para cambiar la contrasenya
    	actualizarUsuario(lblUsuario.getText(),ComparatorCPUController.UsuarioGlobal);
    }
    
    public void actualizarUsuario(String nuevoUsuario,String usuario) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("actualizarUsuario");
    	s.escribirTexto(nuevoUsuario);
    	s.escribirTexto(usuario);
    	boolean comprobarExisteUsuario= s.leerBoolean();
    	s.stop();
    	if (comprobarExisteUsuario == false) {
    		lblUsuarioExiste.setVisible(false);
    		ComparatorCPUController.UsuarioGlobal = nuevoUsuario;
    		
    		//Creamos un alert para informar al usuario
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Cambio de Usuario");
            alert.setContentText("Su usuario se cambio correctamente.\n\nDebe cerrar sesion para que todos los cambios sean correctos");
            
            //Si el usuario le da al boton Cierra esta ventana
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
                stage.close();
            }else {

    		}
    	}else {
    		lblUsuarioExiste.setVisible(true);
    	}
    }

}