package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {
	
    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnAbrir;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCortar;

    @FXML
    private Button btnCopiar;

    @FXML
    private Button btnPegar;

    @FXML
    private Button btnSalir;

    @FXML
    private TextArea texto;
    
    @FXML
    private Label textoFichero;
    @FXML
    private Button btnGuardarComo;
    @FXML
    private ImageView imgTextoArchivo;
    
    private java.io.File file = null;
    
    @FXML
    void Abrir(ActionEvent event) {
    	texto.setVisible(true);
    	Stage primaryStage = null;
    	FileChooser fp = new FileChooser();
        fp.setTitle("Seleccionar archivo abierto");
        file = fp.showOpenDialog(primaryStage);
        textoFichero.setText(file.getName());
        if (file != null && file.exists()) {
            try {
                // Leer datos en varias líneas de texto
                FileInputStream in = new FileInputStream(file);
                byte[] bs = new byte[(int)file.length()];
                in.read(bs);
                // Establecer el contenido en un cuadro de texto de varias líneas
                texto.setText(new String(bs));
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void Copiar(ActionEvent event) {
    	texto.copy();
    }

    @FXML
    void Cortar(ActionEvent event) {
    	texto.cut();
    }

    @FXML
    void Guardar(ActionEvent event) {
    	imgTextoArchivo.setVisible(false);
    	if (file!=null) {
            // Escribe el contenido del cuadro de texto de varias líneas en el archivo señalado por archivo
            try {
                // Crear flujo de salida
                FileOutputStream out = new FileOutputStream(file);
                out.write(texto.getText().getBytes());
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    @FXML
    void GuardarComo(ActionEvent event) {
    	imgTextoArchivo.setVisible(false);
    	Stage primaryStage = null;
    	FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar archivo-Guardar");
        java.io.File file = fc.showSaveDialog(primaryStage);
        if (file!=null) {
            // Escribe el contenido del cuadro de texto de varias líneas en el archivo señalado por archivo
            try {
                // Crear flujo de salida
                FileOutputStream out = new FileOutputStream(file);
                out.write(texto.getText().getBytes());
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @FXML
    void Nuevo(ActionEvent event) {
    	texto.setText("");
    	imgTextoArchivo.setVisible(false);
    	texto.setVisible(true);
    }

    @FXML
    void Pegar(ActionEvent event) {
    	texto.paste();
    }

    @FXML
    void Salir(ActionEvent event) {
    	System.exit(0);
    }
    @FXML
    void teclaPresionada(KeyEvent event) {
    	if(texto.getText() != "")
    	imgTextoArchivo.setVisible(true);
    	else imgTextoArchivo.setVisible(false);
    }
}

