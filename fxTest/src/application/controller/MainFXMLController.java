package application.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Player;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFXMLController implements EventHandler<ActionEvent>, Initializable {

	@FXML
	Label myLabel;
	
	@FXML
	TextField textField;

	Group root1 = new Group();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	/* similar to the switchStage method except it grabs the value from the TextField
	 * to use as the player's speed and creates a new Player instance.
	 */
	public void startGame(String name){
		Parent window1;
	    try {
	    	double moveSpeed = 0;
	    	if(!(textField.getText().trim().isEmpty()) || !(textField.getText().trim().equals(""))){
		    	if(Double.parseDouble(textField.getText()) > 0){
					moveSpeed = (Double.parseDouble(textField.getText()));
				} 
	    	} else moveSpeed = 1;
			window1 = FXMLLoader.load(getClass().getClassLoader().getResource(name));
			Stage mainStage;
			mainStage = Main.primaryStage;
		
			mainStage.getScene().setRoot(window1);
			/* getting the circle object from SceneBuilder with the @FXML annotation won't work since
			we're changing scenes so I'm using this instead */
			Circle playerCircle = (Circle) Main.primaryStage.getScene().lookup("#playerCircle"); 																								
			Player newPlayer = new Player(100, moveSpeed, 3, 1, playerCircle);
			moveCircleOnKeyPress(Main.primaryStage.getScene(), newPlayer.getPlayerCircle(), newPlayer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void moveCircleOnKeyPress(Scene scene, final Circle circle, Player player) {
	      scene.setOnKeyPressed(new EventHandler<KeyEvent>() { 
	      @Override public void handle(KeyEvent event) {
	        switch (event.getCode()) {
	          case W:
	          case UP:    circle.setCenterY(circle.getCenterY() - player.getMoveSpeed()); break;
	          case D:
	          case RIGHT: circle.setCenterX(circle.getCenterX() + player.getMoveSpeed()); break;
	          case S:
	          case DOWN:  circle.setCenterY(circle.getCenterY() + player.getMoveSpeed()); break;
	          case A:
	          case LEFT:  circle.setCenterX(circle.getCenterX() - player.getMoveSpeed()); break;
	        }
	      }
	    });
	  }
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println( "Got to MainFXMLController!" );
		myLabel.setText( "Game started" );
		startGame("test.fxml");
	}
	
	/*
	 * String name is the path of the fxml document to be loaded
	 */
	public void switchStage(String name){
		Parent window1;
	    try {
			window1 = FXMLLoader.load(getClass().getClassLoader().getResource(name));
			Stage mainStage;
			mainStage = Main.primaryStage;
		
			mainStage.getScene().setRoot(window1);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handle2(ActionEvent event){
		switchStage("myFxml.fxml");
	}
	
	public void options(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
		myLabel.setText( "Options menu" );
		switchStage("options.fxml");
	}
	
	public void backToMenu(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
		switchStage("myFXML.fxml");
	}

	public void quit(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
		myLabel.setText( "Game quit" );
	}

}