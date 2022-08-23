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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgregarCPUController {

    @FXML
    private TextField txtEnlace;

    @FXML
    private TextField txtHilos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtMemoria;

    @FXML
    private TextField txtFrecuencia;

    @FXML
    private TextField txtFrecuenciaMax;

    @FXML
    private TextField txtNucleos;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblFrecuencia;

    @FXML
    private Label lblFrecuenciaMax;

    @FXML
    private Label lblNucleos;

    @FXML
    private ComboBox<String> cbxMarca;
    
    @FXML
    private Label lblMemoria;

    @FXML
    private Label lblHilos;

    @FXML
    private ImageView imgVolver;
    
    ObservableList<String> items = FXCollections.observableArrayList();
    public void initialize() {
    	iniciarCombo();
    }
    //Comprobar todos los text para ponerle un limite
    @FXML
    void Comprobar(KeyEvent event) {
    	if (txtNombre.isEditable() && txtNombre.getText().length() >10) {
    		txtNombre.deletePreviousChar();
    	}
    	if (txtHilos.isEditable() && !txtHilos.getText().matches("[0-9]*") || txtHilos.getText().length() >4) {
    		txtHilos.deletePreviousChar();
    	}
    	if (txtFrecuencia.isEditable() && !txtFrecuencia.getText().matches("[0-9].*") ||txtFrecuencia.getText().length() >4) {
    		txtFrecuencia.deletePreviousChar();
    	}
    	if (txtFrecuenciaMax.isEditable() && !txtFrecuenciaMax.getText().matches("[0-9].*") || txtFrecuenciaMax.getText().length() >4) {
    		txtFrecuenciaMax.deletePreviousChar();
    	}

    	if (txtNucleos.isEditable() && !txtNucleos.getText().matches("[0-9]*") || txtNucleos.getText().length() >4) {
    		txtNucleos.deletePreviousChar();
    	}
    }

    @FXML
    void Confirmar(ActionEvent event) throws IOException {
    	if (!tipoUsuario().equals("PREMIUM") && totalCPU() ==1) {
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("ERROR");
             alert.setContentText("Su cuenta es de PRUEBA y ya tiene un procesador creado.");
             alert.showAndWait();
             FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
             Stage stage = (Stage) imgVolver.getScene().getWindow();
             Scene scene = new Scene(fxmlLoader.load());
             stage.setScene(scene);
    	}else if(comprobarCampos()) {
    		if(comprobarNombreCPU(txtNombre.getText())) {
    			meterCPU();
    			vaciar();
    		}else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("El nombre de este procesador ya existe");
                alert.showAndWait();
    		}
    	}
    	
    }

    @FXML
    void VolverAplicacion(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) imgVolver.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    public int totalCPU() throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("totalCPU");

    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	int total = s.leerInt();
    	s.stop();
    	
    	return total;
		
    }
    public String tipoUsuario() throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("tipoUsuario");

    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	String tipo = s.leerTexto();
    	s.stop();
    	
    	return tipo;
    }
    //Mirar si algun campo esta vacio y si es asi que no siga con el proceso
    public boolean comprobarCampos() {
    	boolean tmp = true;
    	if (txtNombre.getText().equals("")) {
    		lblNombre.setVisible(true);
    		tmp = false;
    	}else {
    		lblNombre.setVisible(false);
    	}
    	
    	if(txtHilos.getText().equals("")) {
    		lblHilos.setVisible(true);
    		tmp = false;
    	}else {
    		lblHilos.setVisible(false);
    	}
    	
    	if (txtMemoria.getText().equals("")) {
    		lblMemoria.setVisible(true);
    		tmp = false;
    	}else {
    		lblMemoria.setVisible(false);
    	}
    	
    	if (txtFrecuencia.getText().equals("")) {
    		lblFrecuencia.setVisible(true);
    		tmp = false;
    	}else {
    		lblFrecuencia.setVisible(false);
    	}
    	
    	if (txtFrecuenciaMax.getText().equals("")) {
    		lblFrecuenciaMax.setVisible(true);
    		tmp = false;
    	}else {
    		lblFrecuenciaMax.setVisible(false);
    	}
    	
    	if (txtNucleos.getText().equals("")) {
    		lblNucleos.setVisible(true);
    		tmp = false;
    	}else {
    		lblNucleos.setVisible(false);
    	}
    	
    	if (tmp == true) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
    //Metodo que comprueba si la CPU ya existe con nuestro usuario y que tampoco este en las cpu por defecto
    public boolean comprobarNombreCPU(String nombre) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("comprobarNombreCPU");
    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
    	s.escribirTexto(nombre);
    	boolean noExisteCPU =s.leerBoolean();
    	s.stop();
    	return noExisteCPU;
    }
    public void meterCPU() throws IOException {
		ServerCliente s = new ServerCliente();
		s.start();
		s.escribirTexto("meterCPU");
		s.escribirTexto(txtNombre.getText());
		s.escribirTexto(cbxMarca.getValue());
		s.escribirTexto(txtFrecuencia.getText());
		s.escribirTexto(txtFrecuenciaMax.getText());
		s.escribirTexto(txtNucleos.getText());
		s.escribirTexto(txtMemoria.getText());
		s.escribirTexto(txtEnlace.getText());
		s.escribirTexto(txtHilos.getText());
		s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
		s.stop();

    }
    //Metodo para meter en el combo la informacion
    public void iniciarCombo() {
    	items.add("INTEL");
    	items.add("AMD");
    	cbxMarca.setItems(items);
    	cbxMarca.getSelectionModel().select(0);
    }
    //Metodo para una vez creada la CPU vaciar los campos
    public void vaciar() {
    	
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmado");
        alert.setContentText("El procesador se agrego perfectamente");
        alert.showAndWait();
        
    	txtEnlace.setText("");
        txtHilos.setText("");
        txtNombre.setText("");
        txtMemoria.setText("");
        txtFrecuencia.setText("");
        txtFrecuenciaMax.setText("");
        txtNucleos.setText("");
        
    }
}
