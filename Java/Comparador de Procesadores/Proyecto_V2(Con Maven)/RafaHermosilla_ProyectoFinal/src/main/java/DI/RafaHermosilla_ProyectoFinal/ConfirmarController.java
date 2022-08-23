package DI.RafaHermosilla_ProyectoFinal;
import java.util.Base64;
import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ConfirmarController{

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField txtCodigo;
    @FXML
    private Label txtNumero;
    
    private int codigo =0;
    private static final int tiempo = 120;
    private Timeline timeline;
    private final IntegerProperty timeSeconds = new SimpleIntegerProperty(tiempo);
    
    
    Usuario usu = new Usuario("a","a","a", null, null);
    
    public void setUsuario(Usuario u) throws IOException {
    	usu = new Usuario(u.getNombre(),u.getContraseña(),u.getCorreo(), null, null);
    	
    	codigo = (int) (Math.random()* ( 9999 - 1000 ));
    	System.out.println(usu.getCorreo());
    	enviarCorreo(usu.getCorreo(),codigo);
    }
    
    private void actualizarTiempo() {
        //Metemos en una variable los segundos y le restamos 1
        int segundos = timeSeconds.get();
        timeSeconds.set(segundos-1);
        //Cuando llegue a uno cerramos la ventana ya que se acabo el tiempo
        if(txtNumero.getText().equals("1")) {
    		//Cerramos la ventana
    	    Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
    	    stage.close();
        }
    }
    //Creamos el contador en un metodo para iniciarlo cuando abramos la ventana
    public void contador() {
    	//Lo creamos y vamos actualizando el tiempo
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> actualizarTiempo())); 
        //Ponemos que este indifinidamente
        timeline.setCycleCount(Animation.INDEFINITE);
        //Le ponemos el tiempo que queremos que este
        timeSeconds.set(tiempo);
        //Lo iniciamos
        timeline.play();
        //Y lo metemos en el label
        txtNumero.textProperty().bind(timeSeconds.asString());
    }
    
    @FXML
    void Confirmar(ActionEvent event) throws  IOException {
    	if(Integer.parseInt(txtCodigo.getText())==codigo) {
    		timeline.stop();
			//Metemos el usuario en la base de datos
    		meterUsuario(usu);
    		//Cerramos la ventana
    	    Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
    	    stage.close();
    	}else {
    		
    	}
    }
    private static void enviarCorreo(String destinatario,int codigo) throws IOException {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente tambiñn.
	    ServerCliente s = new ServerCliente();
	    s.start();
	    s.escribirTexto("enviarCorreoRegistro");
	    s.escribirInt(codigo);
	    s.escribirTexto(destinatario);
	    s.stop();
	}
    public void meterUsuario(Usuario u) throws  IOException {
    	String contraOriginal = u.getContraseña();
    	String contraEncriptada = Base64.getEncoder().encodeToString(contraOriginal.getBytes());
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("meterUsuario");
    	s.escribirTexto(u.getNombre());
    	s.escribirTexto(contraEncriptada);
    	s.escribirTexto(u.getCorreo());
    	s.stop();
    	
    }

    @FXML
    public void initialize() throws InterruptedException {
    	contador();
	}
    
}
