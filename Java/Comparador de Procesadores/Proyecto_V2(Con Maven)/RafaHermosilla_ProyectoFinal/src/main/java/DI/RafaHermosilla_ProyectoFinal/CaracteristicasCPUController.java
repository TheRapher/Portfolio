package DI.RafaHermosilla_ProyectoFinal;

import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CaracteristicasCPUController {
    
    @FXML    
    private TableView<Tabla> tabla;

    @FXML
    private TableColumn<Tabla, String> tbCaracteristicas;

    @FXML
    private TableColumn<Tabla, String> tbCPU1;
    public String CPU1_Def = "null";
    public String CPU2_Def;
    boolean tmp = false;
    @FXML
    private TableColumn<Tabla, String> tbCPU2;
    
    @FXML
    private PieChart pcComparador;

    @FXML
    private BarChart<String, Number> CaracteristirasGrafico;
    
    @FXML
    private CategoryAxis Categoria;

    @FXML
    private NumberAxis Numeros;
   
    
    //Procesadores que vamos a comparar
    CPU procesador1;
    CPU procesador2;
    //Puntos de cada procesador
    int  puntosProcesador1=0;
    int puntosProcesador2=0;

    
    public void setCPU(String c1, String c2) throws IOException {
    	CPU1_Def = c1;
    	CPU2_Def = c2;
    	procesador1=obtenerCPU_BaseDatos(CPU1_Def);
    	procesador2=obtenerCPU_BaseDatos(CPU2_Def);
    	//Obtenemos la CPU con toda su informacion y mostramos los datos en la aplicacion
    	cargarDatos(procesador1,procesador2);
    	//Obtenemos los puntos para ponerlos mas adelante en el PieChart
    	comparar(procesador1,procesador2);
    	//Cargamos el PieChart
    	cargarPieChart(procesador1,procesador2);
    	}
    
	@SuppressWarnings("unchecked")
	public void cargarDatos(CPU procesador1, CPU procesador2) {
    	tbCaracteristicas.setCellValueFactory(new PropertyValueFactory<Tabla, String>("caracteristicas"));
    	tbCPU1.setCellValueFactory(new PropertyValueFactory<Tabla, String>("primeraCPU"));
    	tbCPU2.setCellValueFactory(new PropertyValueFactory<Tabla, String>("segundaCPU"));
    	tabla.getItems().add(new Tabla("Nombre",procesador1.getNombre(),procesador2.getNombre()));
    	tabla.getItems().add(new Tabla("Marca",procesador1.getMarca(),procesador2.getMarca()));
    	tabla.getItems().add(new Tabla("Frecuencia",String.valueOf(procesador1.getFrecuenciaReloj()),String.valueOf(procesador2.getFrecuenciaReloj())));
    	tabla.getItems().add(new Tabla("Frecuencia Maxima",String.valueOf(procesador1.getFrecuenciaRelojMax()),String.valueOf(procesador2.getFrecuenciaRelojMax())));
    	tabla.getItems().add(new Tabla("Nucleos",String.valueOf(procesador1.getNumHilos()),String.valueOf(procesador2.getNumHilos())));
    	tabla.getItems().add(new Tabla("Memoria",String.valueOf(procesador1.getMemoriaCache()),String.valueOf(procesador2.getMemoriaCache())));
    	tabla.getItems().add(new Tabla("Hilos",String.valueOf(procesador1.getNumHilos()),String.valueOf(procesador2.getNumHilos())));
    
    	Categoria = new CategoryAxis();
		Numeros = new NumberAxis();

        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
        series1.setName(procesador1.getNombre());       
        series1.getData().add(new Data<String, Number>("Frecuencia", procesador1.getFrecuenciaReloj()));
        series1.getData().add(new Data<String, Number>("Frecuencia Maxima",procesador1.getFrecuenciaRelojMax()));
        series1.getData().add(new Data<String, Number>("Nucleos", procesador1.getNumHilos()));
        series1.getData().add(new Data<String, Number>("Memoria", procesador1.getMemoriaCache()));
        series1.getData().add(new Data<String, Number>("Hilos", procesador1.getNumHilos()));      
        
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
        series2.setName(procesador2.getNombre());       
        series2.getData().add(new Data<String, Number>("Frecuencia", procesador2.getFrecuenciaReloj()));
        series2.getData().add(new Data<String, Number>("Frecuencia Maxima",procesador2.getFrecuenciaRelojMax()));
        series2.getData().add(new Data<String, Number>("Nucleos", procesador2.getNumHilos()));
        series2.getData().add(new Data<String, Number>("Memoria", procesador2.getMemoriaCache()));
        series2.getData().add(new Data<String, Number>("Hilos", procesador2.getNumHilos()));      
        CaracteristirasGrafico.getData().addAll(series1, series2);

    }
    public CPU obtenerCPU_BaseDatos(String nombre) throws IOException {
    	ServerCliente s = new ServerCliente();
    	s.start();
    	s.escribirTexto("obtenerCPU_BaseDatos");
    	s.escribirTexto(nombre);
    	CPU cpu = null;
	    cpu = new CPU(s.leerTexto(), s.leerTexto(),s.leerDouble(), s.leerDouble(), s.leerInt(),s.leerInt(), s.leerTexto(), s.leerInt());
		s.stop();
		return cpu;
    }
    
    //Metodo para comparar y saber que CPU es mejor
    public void comparar(CPU c1, CPU c2) {
    	if(c1.getNumNucleos() > c2.getNumNucleos()) {
    		puntosProcesador1 +=2;

    	}else if(c1.getNumNucleos() < c2.getNumNucleos()) {
    		puntosProcesador2 +=2;

    	}else {
    		puntosProcesador1 +=2;
    		puntosProcesador2 +=2;
    	}
    	if(c1.getMemoriaCache() > c2.getMemoriaCache()) {
    		puntosProcesador1 +=2;

    	}else if(c1.getMemoriaCache() < c2.getMemoriaCache()) {
    		puntosProcesador2 +=2;
    	}else {
    		puntosProcesador1 +=2;
    		puntosProcesador2 +=2;
    	}
    	if(c1.getNumHilos() > c2.getNumHilos()) {
    		puntosProcesador1 +=2;
    	}else if(c1.getNumHilos() < c2.getNumHilos()) {

    		puntosProcesador2 +=2;

    	}else {
    		puntosProcesador1 +=2;
    		puntosProcesador2 +=2;
    	}
    	if(c1.getFrecuenciaReloj() > c2.getFrecuenciaReloj()) {
    		puntosProcesador1 +=2;

    	}else if(c1.getFrecuenciaReloj() < c2.getFrecuenciaReloj()) {
    		puntosProcesador2 +=2;

    	}else {
    		puntosProcesador1 +=2;
    		puntosProcesador2 +=2;
    	}
    	if(c1.getFrecuenciaRelojMax() > c2.getFrecuenciaRelojMax()) {
    		puntosProcesador1 +=2;
    	}else if(c1.getFrecuenciaRelojMax() < c2.getFrecuenciaRelojMax()) {
    		puntosProcesador2 +=2;

    	}else {
    		puntosProcesador1 +=2;
    		puntosProcesador2 +=2;
    	}
    	puntosProcesador1 = puntosProcesador1/2*10;
    	puntosProcesador2 = puntosProcesador2/2*10;
    }
    public void cargarPieChart(CPU c1, CPU c2) {
    	ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    	data.add(new PieChart.Data(c1.getNombre(), puntosProcesador1));
    	data.add(new PieChart.Data(c2.getNombre(), puntosProcesador2));

    	pcComparador.getData().addAll(data);
    }

    @FXML
    void Volver(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) pcComparador.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    
    @FXML
    void btnValorar(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();

		try {
            fxmlLoader.setLocation(getClass().getResource("Valorar.fxml"));
            Stage stage = (Stage) pcComparador.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            
            //Mandamos informacion a la ventana principal
            ValorarController controlador =(ValorarController) fxmlLoader.getController();
            controlador.setCPU(CPU1_Def, CPU2_Def);

		} catch (IOException e) {
			e.printStackTrace();
	    }             
      
    }

    @FXML
    void btnVolver(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ComparatorCPU.fxml"));
        Stage stage = (Stage) pcComparador.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
