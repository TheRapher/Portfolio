package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;
import java.io.InputStream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ModificarTipoController {

	 @FXML
	    private TextField lblNombre;

	    @FXML
	    private TextField lblNumeroTarjeta;

	    @FXML
	    private TextField lblCVV;

	    @FXML
	    private Button btnConfirmar;

	    @FXML
	    private DatePicker lblFecha;

	    @FXML
	    void Confirmar(ActionEvent event) throws JRException, IOException {
	    	//Metemos la fecha de la tarjeta en una variable y creamos otra con la fecha de hoy para compararlas
	    	LocalDate fechaCaducidadTarjeta = lblFecha.getValue();
	        LocalDate fechaActual = LocalDate.now();
	        if(lblNombre.equals("")) {
	        	//Creamos el alert para notificar al usuario
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setTitle("ERROR");
	            alert.setContentText("Debe especificar su nombre y apellidos");
	  
	        }else if (fechaCaducidadTarjeta.isAfter(fechaActual)) {
	    		
	    		//Creamos el alert para notificar al usuario

	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            
	            alert.setTitle("Compra Completada");
	            alert.setContentText("¡¡¡Se compro la version PREMIUM con exito!!!\n¿Desea descargar la factura?\n\nMuchas gracias por apoyar el desarrollo.\nAtt. Toy Computer");
	            alert.getButtonTypes().clear();
	            alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
	            
	            //Si el usuario le da al boton Cierra esta ventana
	            Optional<ButtonType> result = alert.showAndWait();
	            if (result.get() == ButtonType.YES){
	            	Map<String, Object> parameters = new HashMap<String, Object>();
	            	Factura factura = new Factura (lblNombre.getText(), getCorreo(), numFactura());

	            	List<Factura> listfactura = Arrays.asList(factura);
	            	InputStream is = Main.class.getResourceAsStream("Factura.jrxml");

	            	JasperReport report = JasperCompileManager.compileReport(is);
	            	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listfactura);
	            	JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
	            	JasperExportManager.exportReportToPdfFile(print, "Factura"+ComparatorCPUController.UsuarioGlobal+".pdf");
	                try {
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +System.getProperty("user.dir")+"//Factura"+ComparatorCPUController.UsuarioGlobal+".pdf");
					} catch (IOException e) {
						e.printStackTrace();
					}
	            	//Llamamos a la funcion para modificar el tipo
	 	    		modificarTipo(ComparatorCPUController.UsuarioGlobal);
	 	    		
	            	Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
	            	stage.close();
	            }else if(result.get() == ButtonType.NO){
	                Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
	                stage.close();
	            }
	    	}else {
	    		//Notificamos al error que hubo un error
	    		Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	            alert2.setHeaderText(null);
	            alert2.setTitle("Error");
	            alert2.setContentText("Su tarjeta de credito esta caducada y no se pudo hacer el pago.\n\nIntentelo con otra tarjeta.");
	            alert2.showAndWait();
	    		}
	    	}
	    

	    @FXML
	    void numeroTarjeta(KeyEvent event) {
	    	//Ponemos que el campo sea numerico y que tenga un rango del 0 al 16
	    	if (!lblNumeroTarjeta.getText().matches("\\d{0,16}")) {
	    		lblNumeroTarjeta.deletePreviousChar();
	        }
	    }
	    @FXML
	    void tarjetaCVV(KeyEvent event) {
	    	//Ponemos que el campo sea numerico y que tenga un rango del 0 al 3
	    	if (!lblCVV.getText().matches("\\d{0,3}")) {
	    		lblCVV.deletePreviousChar();
	        }
	    }
	    public void modificarTipo(String usu) throws IOException {
	    	//Modificamos el Tipo de usuario a PREMIUM
	    	ServerCliente s = new ServerCliente();
	    	s.start();
	    	s.escribirTexto("modificarTipo");
	    	s.escribirTexto(usu);
	    	s.stop();
	    }
	    public String getCorreo() throws IOException {
	    	ServerCliente s = new ServerCliente();
	    	s.start();
	    	s.escribirTexto("getCorreo");
	    	s.escribirTexto(ComparatorCPUController.UsuarioGlobal);
	    	String correo = s.leerTexto();
	    	s.stop();
	    	return correo;
	    }
	    public int numFactura() throws IOException {
	    	//Modificamos el Tipo de usuario a PREMIUM
	    	ServerCliente s = new ServerCliente();
	    	s.start();
	    	s.escribirTexto("numFactura");
	    	int numero = s.leerInt();
	    	s.stop();
			return numero;
	    }
}