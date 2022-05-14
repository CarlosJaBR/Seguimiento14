package controller;

import application.Main;
import javafx.fxml.FXML;

public class SampleController {
	
	/*
	 * Esta clase tiene el control sobre la pantalla de login. 
	 * Permite continuar con el proceso de ejecución. 
	 */
	
	
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	public void lookPrincipalFrame() {
		//System.out.println("Hello world");
		main.showPrincipalFrame();
	}
	
	
	
	
}
