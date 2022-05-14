package controller;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.TimeZone;

import application.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Country;
import model.Zone;

public class PrincipalController {
	
	private Main main; 
	
	@FXML
	private Label localTime;
	  
	private Country country; 
	
	 @FXML
	 private Button addButton;

	 @FXML
	 private TableView<Zone> tableCountries;

	 @FXML
	 private TableColumn<Zone,String> columnName;

	 @FXML
	 private TableColumn<Zone,LocalTime> columnTime;
	
	 @FXML
	 private ComboBox<String> timeZoneCountries;
	 
	 @FXML
	 private ObservableList<Zone> countriesZone; 
	 
	private ArrayList<Zone> saveCountries; 
	 
	 
	public void initialize() {
		
		saveCountries = new ArrayList<Zone>();
		localTime.setText("0:00");
		country = new Country(this); 
		countriesZone = FXCollections.observableArrayList(); 
		columnName.setCellValueFactory(new PropertyValueFactory<>("nameCountry"));
		columnTime.setCellValueFactory(new PropertyValueFactory<>("timeCountry"));
		country.start();
		loadTime(); 
		loadCountries();
	}
	public void setMain(Main main) {
		this.main = main; 
	}
	
	public void loadTime() {
		//country.start();  
		localTime.setText(LocalTime.now()
				  .truncatedTo(ChronoUnit.SECONDS)
				  .format(DateTimeFormatter.ISO_LOCAL_TIME)+  ""); 
	}
	
	public void refreshTime() {
		
		Platform.runLater(()->{
			localTime.setText(LocalTime.now()
					  .truncatedTo(ChronoUnit.SECONDS)
					  .format(DateTimeFormatter.ISO_LOCAL_TIME)+  ""); 
			
		});
			
		
	}
	
	  @FXML
	  public void addTimeCountry(ActionEvent event) {
		  
		  ZoneId zone = ZoneId.of(timeZoneCountries.getSelectionModel().getSelectedItem().toString());
		  String name = timeZoneCountries.getSelectionModel().getSelectedItem().toString();
		  Zone obj = new Zone(name,zone);
		  
		  countriesZone.add(obj);
		  saveCountries.add(obj);
		  tableCountries.setItems(countriesZone); 
		  
		  
	  }
	  
	  public void loadCountries() {
		  String[] times = TimeZone.getAvailableIDs();
		  timeZoneCountries.getItems().addAll(times);
	  }
	  
	 
	  public void refreshCountriesOtro() {
		  
		
		  Platform.runLater(()->{
			  
		       for(int i = 0; i<countriesZone.size();i++) {
		    	   
				   ZoneId zone = ZoneId.of(countriesZone.get(i).getNameCountry());
				    countriesZone.get(i).setTimeCountry(LocalTime.now(zone));
				    tableCountries.setItems(countriesZone);
				    tableCountries.refresh();		       
				    } 
			   
			}); 
		}	 
	  
	  @FXML
	  public void lookTimer(ActionEvent event) {

		  main.savePrincipalController(this);
		  main.showTimer();
	  }
	
	 
	  
	  
	  
	
	
	
	
}
