package application.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainFXMLController implements EventHandler<ActionEvent> {

	@FXML
	Label myLabel;

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println( "Got to MainFXMLController!" );
		myLabel.setText( "Game started" );
	}
	
	public void options(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
		myLabel.setText( "Options menu" );
	}

	public void quit(ActionEvent event){
		System.out.println( "Got to MainFXMLController!" );
		myLabel.setText( "Game quit" );
	}
}