package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditarCPUController {

    @FXML
    private ComboBox<String> cbxCPU;

    @FXML
    private ComboBox<String> cbxOpciones;
    
    @FXML
    private ComboBox<String> cbxMarca;
    
    @FXML
    private TextField txtProcesador;

    @FXML
    private Button btnConfirmar;
    @FXML
    void Confirmar(ActionEvent event) throws IOException {
			editarProcesador();
			cargarProcesadores();
			cargarCombo();
    }

    @FXML
    void VolverVentanaPrincipal(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) txtProcesador.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    public void initialize() throws IOException {
			cargarProcesadores();
			cargarCombo();
		
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
			cbxCPU.getItems().clear();
			txtProcesador.setVisible(false);
			cbxOpciones.setVisible(false);
		}else {
			cbxCPU.getItems().clear();
			cbxCPU.setItems(items);
			cbxCPU.getSelectionModel().select(0);
			btnConfirmar.setDisable(false);
		}
    }
    //A�adimos informacion al combo de opciones
    public void cargarCombo(){
        ObservableList<String> items = FXCollections.observableArrayList();
        ObservableList<String> items2 = FXCollections.observableArrayList();

        items.addAll("Nombre","Marca","Frecuencia","FrecuenciaMAX","Nucleos","Memoria","Hilos","Enlace");
    	cbxOpciones.setItems(items);
    	cbxOpciones.getSelectionModel().select(0);
    	

    	items2.addAll("INTEL","AMD");
    	cbxMarca.setItems(items2);
    	cbxMarca.getSelectionModel().select(0);


    }

    @FXML
    void Cambiar(ActionEvent event) {
    	txtProcesador.setText("");
    	if(cbxOpciones.getValue().equals("Marca")) {
    		cbxMarca.setVisible(true);
    		txtProcesador.setVisible(false);

    	}else {
    		cbxMarca.setVisible(false);
    		txtProcesador.setVisible(true);

    	}
    }
    //Metodo para editar el procesador
    public void editarProcesador() throws IOException {
    	ServerCliente s= new ServerCliente();
    	s.start();
    	s.escribirTexto("editarProcesador");
    	s.escribirTexto(cbxOpciones.getValue());
    	if (cbxOpciones.getValue().equals("Marca")) {
    		s.escribirTexto(cbxMarca.getValue());
    	}else {
    	s.escribirTexto(txtProcesador.getText());
    	}
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	s.stop();
    }

    @FXML
    void comprobarTipo(KeyEvent event) {
    	if (cbxOpciones.getValue().equals("Nombre") &&  txtProcesador.getText().length() >10) {
    		txtProcesador.deletePreviousChar();
    	}if (cbxOpciones.getValue().equals("Frecuencia") && txtProcesador.isEditable() && txtProcesador.getText().matches("[0-9].*") && txtProcesador.getText().length() >4) {
    		txtProcesador.deletePreviousChar();
    	}
    	if (cbxOpciones.getValue().equals("FrecuenciaMAX") && txtProcesador.isEditable() && txtProcesador.getText().matches("[0-9].*") && txtProcesador.getText().length() >4) {
    		txtProcesador.deletePreviousChar();
    	}
    	if (cbxOpciones.getValue().equals("Nucleos") && txtProcesador.isEditable() && txtProcesador.getText().matches("[0-9].*") && txtProcesador.getText().length() >4) {
    		txtProcesador.deletePreviousChar();
    	}
    	if (cbxOpciones.getValue().equals("Memoria") && txtProcesador.isEditable() && txtProcesador.getText().matches("[0-9].*") && txtProcesador.getText().length() >4) {
    		txtProcesador.deletePreviousChar();
    	}
    	if (cbxOpciones.getValue().equals("Hilos") && txtProcesador.isEditable() && txtProcesador.getText().matches("[0-9].*") && txtProcesador.getText().length() >4) {
    		txtProcesador.deletePreviousChar();
    	}
    }


}
