package application;
	
import java.io.IOException;

import controller.PrincipalController;
import controller.SampleController;
import controller.TimerController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage currentStage; 
	private PrincipalController controllerPC;
	
	@Override
	/*
	 * Este método permite iniciar la ejecución del programa. 
	 * Abre la ventana de login.
	 */
	public void start(Stage primaryStage) {
		try {
			showLoginFrame();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Método que permite mostrar la pantalla de logín.
	 */
	public void showLoginFrame() {
		try {
			
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("../ui/Sample.fxml"));
			BorderPane root; 
			root = (BorderPane)loader.load();
			SampleController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage; 
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Este método se ve en el multiventanismo, acá abrimos una nueva Stage, cerramos la 
	 * currentStage y le asignamos la nueva.
	 */
	public void showPrincipalFrame() {
		try {
			
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("../ui/PrincipalFrame.fxml"));
			BorderPane root; 
			root = (BorderPane)loader.load();
			PrincipalController controller = loader.getController();
			controller.setMain(this);
			Stage stage = new Stage(); // Ventana
			Scene scene = new Scene(root); //Contenido de la ventana
			stage.setScene(scene);
			currentStage.close();
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void showTimer() {
		try {
			/*
			BorderPane root;
			BorderPane timers = (BorderPane)FXMLLoader.load(getClass().getResource("../ui/TimerFrame.fxml"));
			Stage stage = currentStage;
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(timers);
			stage.show();
			*/
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("../ui/TimerFrame.fxml"));
			BorderPane root; 
			root = (BorderPane)loader.load();
			TimerController controller = loader.getController();
			controller.setMain(this);
			Stage stage = new Stage(); // Ventana
			Scene scene = new Scene(root); //Contenido de la ventana
			stage.setScene(scene);
			currentStage.close();
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void savePrincipalController(PrincipalController controllerS) {
		this.controllerPC = controllerS; 
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void reuploadPrincipalController() {
		try {
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("../ui/PrincipalFrame.fxml"));
			BorderPane root; 
			root = (BorderPane)loader.load();
			controllerPC.setMain(this);
			Stage stage = new Stage(); // Ventana
			Scene scene = new Scene(root); //Contenido de la ventana
			stage.setScene(scene);
			currentStage.close();
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
