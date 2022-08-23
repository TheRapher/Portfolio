package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class VerificacionController {

    @FXML
    private ComboBox<String> cbxVerificacion;

    public void initialize() {
    	ObservableList<String> items = FXCollections.observableArrayList();

    	items.addAll("Activar","Desactivar");
    	cbxVerificacion.setItems(items);
    	cbxVerificacion.getSelectionModel().select(0);
    }
    @FXML
    void btnConfirmar(ActionEvent event) throws IOException {
		modificarTipo();
		
    	Stage stage = (Stage) this.cbxVerificacion.getScene().getWindow();
    	stage.close();
    }
    public void modificarTipo() throws IOException {
    	//Modificamos el Tipo de usuario a PREMIUM
    	String verificacion = getVerificado();
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("modificarVerificacion");
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	s.escribirTexto(verificacion);

    }
    public String getVerificado()  {
    	if (cbxVerificacion.getValue().equals("Activar")) {
    		return "Si";
    	}else {
    		return "No";
    	}
    }
}
