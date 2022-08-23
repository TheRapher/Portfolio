package DI.RafaHermosilla_ProyectoFinal;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ComparatorCPUController {

    @FXML
    private MenuItem Añadir;
    
    public static String UsuarioGlobal;
    
    @FXML
    private MenuItem Editar;

    @FXML
    private MenuItem Borrar;

    @FXML
    private MenuItem Usuario;

    @FXML
    private MenuItem Cerrar;

    @FXML
    private MenuItem AcercaDe;

    @FXML
    private ComboBox<String> cmbox1;

    @FXML
    private ComboBox<String> combox2;

    @FXML
    private ImageView img1;
    
    @FXML
    private ImageView img2;
    @FXML
    private Label user;
    @FXML
    private Button btnComparar;
    
    boolean tmp = false;
    ObservableList<String> items = FXCollections.observableArrayList();
	CPU cpu  =new CPU(null, null, 0, 0, 0, 0, null, 0);
	List<CPU> lista = new ArrayList<CPU>();
	
    @FXML
    void Comparar(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();

		try {
            fxmlLoader.setLocation(getClass().getResource("CaracteristicasCPU.fxml"));
            Stage stage = (Stage) btnComparar.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            //Mandamos informacion a la ventana principal
            CaracteristicasCPUController controlador =(CaracteristicasCPUController) fxmlLoader.getController();
            controlador.setCPU(cmbox1.getValue(),combox2.getValue());

		} catch (IOException e) {
			e.printStackTrace();
	    }   
    }
	
	
    @FXML
    void AcercaDeOpcion(ActionEvent event) throws URISyntaxException, IOException {

		URI uri=new URI("http://localhost/ToyComputer/Ayuda.html");
		Desktop.getDesktop().browse(uri); 
    }
    public void initialize() throws IOException {
    	user.setText(UsuarioGlobal);
		if (UsuarioGlobal != null){
			actualizarCPU();
			actualizarCPU_Usuarios();
		}
		cmbox1.getSelectionModel().select(0);
		combox2.getSelectionModel().select(8);
    }
    @FXML
    void AñadirCPU(ActionEvent event) throws IOException {
    	if (tipoUsuario().equals("PREMIUM") ) {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource("AgregarCPU.fxml"));
    		Stage stage = (Stage) img1.getScene().getWindow();
    		Scene scene = new Scene(fxmlLoader.load(),600,560);
    		stage.setScene(scene);
    	}else if(totalCPU() <1 && tipoUsuario().equals("PRUEBA")) {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource("AgregarCPU.fxml"));
    		Stage stage = (Stage) img1.getScene().getWindow();
    		Scene scene = new Scene(fxmlLoader.load(),600,560);
    		stage.setScene(scene);	
    	}else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("No puede crear mas procesadores.\nNecesita una cuenta PREMIUM para poder crear los que quiera.\nPara mas informacion vaya a la ayuda.");
            alert.showAndWait();
    	}
    }

    @FXML
    void BorrarCPU(ActionEvent event) throws IOException {
    	if (hayProcesadores()) {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource("EliminarCPU.fxml"));
    		Stage stage = (Stage) img1.getScene().getWindow();
    		Scene scene = new Scene(fxmlLoader.load(),522,471);
    		stage.setScene(scene);
    	}else {
    		//Creamos un alert para informar al usuario
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("No tiene procesadores que se puedan borrar");
            alert.showAndWait();
    	}
    }
    
    @FXML
    void EditarCPU(ActionEvent event) throws IOException {
    	if(hayProcesadores()) {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource("EditarCPU.fxml"));
    		Stage stage = (Stage) img1.getScene().getWindow();
    		Scene scene = new Scene(fxmlLoader.load(),600,471);
    		stage.setScene(scene);
    	}else {
    		//Creamos un alert para informar al usuario
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("No tiene procesadores que se puedan editar");
            alert.showAndWait();    	
        }
    }
    @FXML
    void CerrarSesion(ActionEvent event) throws IOException {
    	//Abrimos la ventana del login
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) img1.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
   
    }
    
    //Metodo que te lleva a las opciones del usuario y le mandamos el usuario para poder hacer sentencias con la Base de Datos
    @FXML
    void UsuarioOpciones(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Opciones.fxml"));
        Stage stage = (Stage) img1.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        
        //Mandamos informacion a la ventana principal
        OpcionesController controlador =(OpcionesController) fxmlLoader.getController();
        controlador.setUsuario(user.getText());
    }
    //Metodo que añade el usuario a la ventana
    public void setUsuario(String usu) throws IOException {
    	UsuarioGlobal = usu;
    	user.setText(usu);
    	initialize();

    }
    //Metodo que añade todos los procesadores a nuestro ComboBox
    public void actualizarCPU() throws IOException {
    	items.clear();
    	boolean tmp = true;
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("actualizarCPU");
    	while(tmp) {
    		tmp = s.leerBoolean();
    		if(tmp == true) {
    		cpu = new CPU(s.leerTexto(), s.leerTexto(),s.leerDouble(), s.leerDouble(), s.leerInt(),s.leerInt(), s.leerTexto(), s.leerInt());
			lista.add(cpu);
			items.add(cpu.getNombre());
			}
		}
    	s.stop();
		cmbox1.setItems(items);
		combox2.setItems(items);
    }
    public void actualizarCPU_Usuarios() throws IOException {
    	boolean tmp = true;
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("actualizarCPU_Usuarios");
    	s.escribirTexto(UsuarioGlobal);
    	while(tmp) {
    		tmp = s.leerBoolean();
    		if(tmp == true) {
    		cpu = new CPU(s.leerTexto(), s.leerTexto(),s.leerDouble(), s.leerDouble(), s.leerInt(),s.leerInt(), s.leerTexto(), s.leerInt());
			lista.add(cpu);
			items.add(cpu.getNombre());
			}
		}
    	s.stop();
		cmbox1.setItems(items);
		combox2.setItems(items);
    }
    public boolean hayProcesadores() throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("hayProcesadores");
    	s.escribirTexto(UsuarioGlobal);
    	boolean hayProcesador = s.leerBoolean();
    	s.stop();
    	return hayProcesador;
    }
    public int totalCPU() throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("totalCPU");

    	s.escribirTexto(UsuarioGlobal);
    	int total = s.leerInt();
    	s.stop();
    	
    	return total;
		
    }
    public String tipoUsuario() throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("tipoUsuario");

    	s.escribirTexto(UsuarioGlobal);
    	String tipo = s.leerTexto();
    	s.stop();
    	
    	return tipo;
    }
    @FXML
    void cambiarImagen(ActionEvent event) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("obtenerCPU_BaseDatos");
    	s.escribirTexto(cmbox1.getValue());
    	CPU cpu = null;
	    cpu = new CPU(s.leerTexto(), s.leerTexto(),s.leerDouble(), s.leerDouble(), s.leerInt(),s.leerInt(), s.leerTexto(), s.leerInt());
		s.stop(); 
		File img;
		if (cpu.getMarca().equals("INTEL")) {
			img = new File(".\\src\\main\\resources\\images\\intel.png");

		}else {
			img = new File(".\\src\\main\\resources\\images\\amd.png");
		}
		InputStream isImage = (InputStream) new FileInputStream(img);
		img1.setImage(new Image(isImage));    }
    @FXML
    void cambiarImagen2(ActionEvent event) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("obtenerCPU_BaseDatos");
    	s.escribirTexto(combox2.getValue());
    	CPU cpu = null;
	    cpu = new CPU(s.leerTexto(), s.leerTexto(),s.leerDouble(), s.leerDouble(), s.leerInt(),s.leerInt(), s.leerTexto(), s.leerInt());
		s.stop();    
		File img;
		if (cpu.getMarca().equals("INTEL")) {
			img = new File(".\\src\\main\\resources\\images\\intel.png");

		}else {
			img = new File(".\\src\\main\\resources\\images\\amd.png");

		}
		InputStream isImage = (InputStream) new FileInputStream(img);
		img2.setImage(new Image(isImage));
    }
}