package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import java.util.Base64;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OpcionesController {

    @FXML
    private Label usuario;

    @FXML
    private Label tipoUsuario;

    @FXML
    private Label contraseña;

    @FXML
    private Label email;

    @FXML
    private Button btnAceptar;
    @FXML
    private Label lblTipo;
    
    @FXML
    private Label Verificacion;
    //Cambiamos de ventana...
    @FXML
    void cambiar(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) btnAceptar.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void modificarVerificacion(MouseEvent event) throws IOException {
    	Stage stageConfirmar = new Stage();
	    Parent root = FXMLLoader.load(VerificacionController.class.getResource("Verificacion.fxml"));
	    stageConfirmar.initModality(Modality.APPLICATION_MODAL);
	    stageConfirmar.setScene(new Scene(root,600,400));
	    stageConfirmar.setTitle("Verificacion de dos pasos");
	    stageConfirmar.setResizable(false);
	    stageConfirmar.show();
    }
    @FXML
    void modificarContraseña(MouseEvent event) throws IOException {
    	Stage stageConfirmar = new Stage();
	    Parent root = FXMLLoader.load(ModificarContrasenyaController.class.getResource("ModificarContrasenya.fxml"));
	    stageConfirmar.initModality(Modality.APPLICATION_MODAL);
	    stageConfirmar.setScene(new Scene(root,477,378));
	    stageConfirmar.setTitle("Modificar Contraseña");
	    stageConfirmar.setResizable(false);
	    stageConfirmar.show();
    }

    @FXML
    void modificarTipo(MouseEvent event) throws IOException {
    	Stage stageConfirmar = new Stage();
	    Parent root = FXMLLoader.load(ModificarTipoController.class.getResource("ModificarTipo.fxml"));
	    stageConfirmar.initModality(Modality.APPLICATION_MODAL);
	    stageConfirmar.setScene(new Scene(root,447,445));
	    stageConfirmar.setTitle("Modificar Tipo");
	    stageConfirmar.setResizable(false);
	    stageConfirmar.show();
    }

    @FXML
    void modificarUsuario(MouseEvent event) throws IOException {
    	Stage stageConfirmar = new Stage();
	    Parent root = FXMLLoader.load(ModificarUsuarioController.class.getResource("ModificarUsuario.fxml"));
	    stageConfirmar.initModality(Modality.APPLICATION_MODAL);
	    stageConfirmar.setScene(new Scene(root,475,400));
	    stageConfirmar.setTitle("Modificar Usuario");
	    stageConfirmar.setResizable(false);
	    stageConfirmar.show();
    }

    //Metodo que saca toda la informacion del usuario
    public void informacion(String usu) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("informacion");
    	s.escribirTexto(usu);
    	
		String contra ="";
		
			usuario.setText(s.leerTexto());
			contra = s.leerTexto();
			email.setText(s.leerTexto());
			tipoUsuario.setText(s.leerTexto());
			Verificacion.setText(s.leerTexto());
	
		if(!tipoUsuario.getText().equals("PREMIUM")) {
			lblTipo.setVisible(true);
		}
		
		//Desencriptamos la contrasenya
		byte[] decodedBytes = Base64.getDecoder().decode(contra);
		String decodedString = new String(decodedBytes);
		//Cambiamos la contraseña por *
		String[] contraSep = decodedString.split("");
		contra ="";
        for (int i = 0; i < contraSep.length; i++) {
            contra += "*";
        }
		contraseña.setText(contra);

    }
    public void setUsuario(String usu) throws IOException {
    	informacion(usu);
    }
   
}