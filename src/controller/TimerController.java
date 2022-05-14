package controller;

import java.time.LocalTime;

import application.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TimeTimer;
import model.TurnTimer;

public class TimerController {
		@FXML
	    private Label timer;

	    @FXML
	    private TableView<TurnTimer> tableTimes;
	    
	    
	    @FXML 
	    private ObservableList<TurnTimer> timesList; 

	    @FXML
	    private TableColumn<TurnTimer, LocalTime> columnDuration;

	    @FXML
	    private TableColumn<TurnTimer, LocalTime> columnTime;

	    @FXML
	    private Button turnTimer;

	    @FXML
	    private Button stateTimer;

	    @FXML
	    private Button reset;
	    
	    private int mileseconds; 
	    private int seconds; 
	    private int minutes;
	    private int hours; 
	    
	    private Main main; 
	    
	    private TimeTimer tTimer; 
	    
	    private boolean state;	 
	    
	    
	    public void initialize() {
	    	tTimer = new TimeTimer(this);
	    	state = false; 
	    	timesList = FXCollections.observableArrayList();
	    	columnDuration.setCellValueFactory(new PropertyValueFactory<>("timeDuration"));
			columnTime.setCellValueFactory(new PropertyValueFactory<>("timeTotal"));
	    	this.mileseconds = 00; 
	    	this.seconds = 00;
	    	this.minutes = 00; 
	    	this.hours = 00; 
	    	tTimer.start();
	    	loadTimer();
	    }
	    
	    public void setMain(Main main) {
	    	this.main = main; 
	    }
	    
	    @FXML
	    void calculateFlag(ActionEvent event) {
	    	int secondsF = seconds;
	    	int minutesF = minutes; 
	    	int hoursF = hours;
	    	if(timesList.size()==0) {
	    		LocalTime duration = LocalTime.of(hoursF,minutesF,secondsF);
	    		LocalTime total = duration;
	    		
	    		TurnTimer obj = new TurnTimer(duration,total);
	    		timesList.add(obj);
	    		tableTimes.setItems(timesList);
	    		
	    	}else {
	    		LocalTime total = LocalTime.of(hoursF,minutesF,secondsF);
	    		LocalTime attemp = timesList.get(timesList.size()-1).getTimeTotal();
	    		
	    		LocalTime dura = LocalTime.of(hoursF,minutesF,secondsF);
	    		dura = dura.minusSeconds(attemp.getSecond());
	    		dura = dura.minusMinutes(attemp.getMinute());
	    		dura = dura.minusHours(attemp.getHour());
	    		
	    		TurnTimer obj = new TurnTimer(dura,total);
	    		timesList.add(obj);
	    		tableTimes.setItems(timesList);
	    	}
	    	
	    	
	    }

	    @FXML
	    void editState(ActionEvent event) {
	    	if(state==false) {
	    		state=true;
	    	}else {
	    		state=false;
	    	}
	    }

	    @FXML
	    void resetValues(ActionEvent event) {
	    	mileseconds = 0; 
		    seconds = 0; 
		    minutes = 0; 
		    hours = 0; 
		    timesList.clear(); 
		    tableTimes.setItems(timesList);
	    }
	    
	    @FXML
	    public void returnPrincipalFrame(ActionEvent event) {
	    	main.showPrincipalFrame();
	    }
	    
	    public void loadTimer() {
	    	timer.setText("00" + ":" + "00" + ":" + "00");
	    }
	    
	    public void refreshTimeTimer() {
	    	
	    	if(state==false) {
		    	Platform.runLater(()->{
		    		seconds++;
		    		if(seconds==59) {
		    			minutes++;
		    			seconds=0; 
		    		}
		    		if(minutes==59) {
		    			hours++;
		    			minutes=0;
		    			seconds=0;
		    		}
		    		
		    		String secondsT = "";
		    		String minutesT = "";
		    		String hoursT = ""; 
		    		
		    		if(seconds<=9) {
		    			secondsT="0"+seconds;
		    		}else {
		    			secondsT= ""+ seconds;
		    		}
		    		if(minutes<=9) {
		    			minutesT = "0"+minutes;
		    		}else {
		    			minutesT = ""+ minutes;
		    		}
		    		if(hours<=9) {
		    			hoursT = "0"+hours;
		    		}else {
		    			hoursT = ""+hours;
		    		}
		    		
		    		timer.setText(hoursT + ":" + minutesT + ":" +  secondsT);
		    		
		    	});
	    	}
	    }	
	    
}
