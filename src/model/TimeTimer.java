package model;

import controller.TimerController;

public class TimeTimer extends Thread{

	private TimerController tController; 
	
	public TimeTimer(TimerController tController) {
		this.tController = tController;
	}
	
	public void run(){
		
		while(true) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tController.refreshTimeTimer();
		}
	}
	
	
	
}
