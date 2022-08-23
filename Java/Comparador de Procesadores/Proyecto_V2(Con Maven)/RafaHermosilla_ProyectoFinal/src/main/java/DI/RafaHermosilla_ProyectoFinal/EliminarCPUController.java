package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EliminarCPUController {

    @FXML
    private ComboBox<String> cbxProcesador;

    @FXML
    private Button btnConfirmar;

    @FXML
    private ImageView imgVolver;

    @FXML
    void Confirmar(ActionEvent event) throws IOException {
			borrarProcesadores();
			cbxProcesador.getSelectionModel().clearSelection();
			
			//Informamos al usuario de que se borro el procesador
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Borrado");
            alert.setContentText("El procesador se borro correctamente");
            alert.showAndWait();
            
			//Llamamos a la funcion para actualizar la lista y lo ponemos a true para que no nos salga el alert
			cargarProcesadores();
    }

    public void initialize() throws IOException {
		cargarProcesadores();
    }
    public void cargarProcesadores() throws IOException {
        ObservableList<String> items = FXCollections.observableArrayList();
    	
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("cargarProcesadores");
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	boolean tmp = true;
		while(tmp) {
			tmp = s.leerBoolean();
			if (tmp == true) {
				items.add(s.leerTexto());
			}
		}
		s.stop();
		if(items.isEmpty()){
			btnConfirmar.setDisable(true);
			cbxProcesador.getItems().clear();
		}else {
		cbxProcesador.getItems().clear();
		cbxProcesador.setItems(items);
		cbxProcesador.getSelectionModel().select(0);
		btnConfirmar.setDisable(false);
		}
    }
    @FXML
    void Volver(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) imgVolver.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    
    public void borrarProcesadores() throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("borrarProcesadores");
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	s.escribirTexto(cbxProcesador.getValue());
    	s.stop();

    }
}