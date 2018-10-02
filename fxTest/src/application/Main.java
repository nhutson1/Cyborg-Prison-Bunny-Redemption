package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	public Stage stage;
	public AnchorPane layout;

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../myFXML.fxml") );
			this.layout = (AnchorPane) loader.load();
			Scene scene = new Scene( layout );
			this.stage.setScene( scene );
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
