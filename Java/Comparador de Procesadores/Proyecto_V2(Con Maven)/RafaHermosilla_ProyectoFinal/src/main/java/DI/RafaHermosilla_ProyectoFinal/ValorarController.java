package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ValorarController {

    @FXML
    private TextArea txtValoracion;

    @FXML
    private Button btnValorar;
    String nombreCPU1;
   
    String nombreCPU2;
    public void initialize() {
    	System.out.println("HOLAAAAAAAAAAAAAAAAAAA2"+nombreCPU1+nombreCPU2);

    }
    @FXML
    void btnValorar(ActionEvent event) throws IOException {
    	System.out.println("HOLAAAAAAAAAAAAAAAAAAA"+nombreCPU1+nombreCPU2);

    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("meterValoracion");
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	s.escribirTexto(txtValoracion.getText());
    	s.escribirTexto(nombreCPU1);
    	s.escribirTexto(nombreCPU2);
    	s.stop();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) txtValoracion.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    
    public void setCPU(String cpu1, String cpu2) {
    	nombreCPU1 = cpu1;
    	nombreCPU2 = cpu2;
    	initialize();
    }
}
