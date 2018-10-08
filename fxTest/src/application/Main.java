package application;
	
import application.controller.MainFXMLController;
import application.model.Player;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;



public class Main extends Application {
	public Stage stage;
	public AnchorPane layout;
	public static Stage primaryStage;
	public Scene scene1, scene2;

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		Main.primaryStage = primaryStage;
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../myFXML.fxml") );
			this.layout = (AnchorPane) loader.load();
			scene1 = new Scene( layout );
			this.stage.setScene( scene1 );
			this.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getPrimaryStage() {
	    return primaryStage;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
