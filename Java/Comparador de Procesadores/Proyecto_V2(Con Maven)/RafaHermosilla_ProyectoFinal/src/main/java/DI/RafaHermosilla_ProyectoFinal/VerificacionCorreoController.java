package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerificacionCorreoController {
    @FXML
    private TextField txtCodigo;
    String usuario;
    @FXML
    private Button btnConfirmar;
    int codigo = 0;


    private static void enviarCorreo(String destinatario,int codigo) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("enviarCorreoVerificacion");
	    s.escribirInt(codigo);
	    s.escribirTexto(destinatario);
	    s.stop();
	}
    
    public String obtenerCorreo() throws IOException {
    	String correo = "";
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("getCorreo");
    	s.escribirTexto(usuario);
    	correo = s.leerTexto();
    	s.stop();
		return correo;
    }
    @FXML
    void Confirmar(ActionEvent event) {
    	int codigoTexto = Integer.valueOf(txtCodigo.getText());
    	if (codigoTexto ==codigo) {
			FXMLLoader fxmlLoader = new FXMLLoader();

			try {
                fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
                Stage stage = (Stage) btnConfirmar.getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
		
                //Mandamos informacion a la ventana principal
                ComparatorCPUController controlador =(ComparatorCPUController) fxmlLoader.getController();
                controlador.setUsuario(usuario);

    		} catch (IOException e) {
    			e.printStackTrace();
    	    } 
    	}
    }
    public void initialize() {
    	codigo = (int) (Math.random()* ( 9999 - 1000 ));

    }
    //Metodo que añade el usuario a la ventana
    public void setUsuario(String usu) {
    	usuario = usu;
    	System.out.println(codigo);
    	System.out.println(usuario);

    	try {
			enviarCorreo(obtenerCorreo(),codigo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
