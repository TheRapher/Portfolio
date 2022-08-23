package DI.RafaHermosilla_ProyectoFinal;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,444,400);
			//scene.getStylesheets().add(getClass().getResource("file:.\\src\\main\\resources\\DI\\RafaHermosilla_ProyectoFinal\\application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Toy Computer");

			primaryStage.getIcons().add(new Image("file:.\\src\\main\\resources\\images\\cpu.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
