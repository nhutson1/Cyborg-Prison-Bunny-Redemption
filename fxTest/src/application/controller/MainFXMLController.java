package application.controller;


import java.io.IOException;
import java.net.URL;
import java.time.Instant;
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

public class MainFXMLController implements EventHandler<ActionEvent>, Initializable, Runnable {

	@FXML
	Label myLabel;
	
	@FXML
	TextField textField;

	Group root1 = new Group();
	Player newPlayer = new Player(100, 3, 1);

	private boolean running = false;
	private Thread thread;
	
	private synchronized void start(){
		if(running) return;
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	// Game loop
	public void run(){
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				newPlayer.tick();
				updates++;
				delta--;
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates);
				updates = 0;
				frames = 0;
			}
		}
		stop();
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
			newPlayer.setPlayerCircle(playerCircle);
			newPlayer.setMoveSpeed(moveSpeed);
			movePlayerOnKeyPress(Main.primaryStage.getScene(), newPlayer);
			start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void movePlayerOnKeyPress(Scene scene, Player player) {
	      scene.setOnKeyPressed(new EventHandler<KeyEvent>() { 
	      @Override public void handle(KeyEvent event) {
	    	  switch (event.getCode()) {
	          case W:
	          case UP:    player.setVelY(-player.getMoveSpeed()); break;
	          case D:
	          case RIGHT: player.setVelX(player.getMoveSpeed()); break;
	          case S:
	          case DOWN:  player.setVelY(player.getMoveSpeed()); break;
	          case A:
	          case LEFT:  player.setVelX(-player.getMoveSpeed()); break;
	          default: break;
	        }
	      }
	    });
	      scene.setOnKeyReleased(new EventHandler<KeyEvent>() { 
		      @Override public void handle(KeyEvent event) {
		        switch (event.getCode()) {
		          case W:
		          case UP:    player.setVelY(0); break;
		          case D:
		          case RIGHT: player.setVelX(0); break;
		          case S:
		          case DOWN:  player.setVelY(0); break;
		          case A:
		          case LEFT:  player.setVelX(0); break;
		          default: break;
		        }
		      }
		    });
	  }
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println( "Got to MainFXMLController!" );
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
		switchStage("options.fxml");
	}
	
	public void backToMenu(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
		switchStage("myFXML.fxml");
	}

	public void quit(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
	}

}
