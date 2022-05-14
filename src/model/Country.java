package model;

import java.time.LocalTime;

import controller.PrincipalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Country extends Thread{

	private PrincipalController  pcontroller; 
	private LocalTime time; 
	
	public Country(PrincipalController pcontroller) {
		this.pcontroller = pcontroller; 
		this.time = LocalTime.now(); 
	}
	
	@Override
	public void run() {
		
		while(true) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pcontroller.refreshTime();
		pcontroller.refreshCountriesOtro();
		}
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	
	
		
}

	

