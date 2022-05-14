package model;

import java.time.LocalTime;
import java.time.ZoneId;

public class Zone {
	
	private String nameCountry;
	private LocalTime timeCountry; 
	
	public Zone(String nameCountry, ZoneId idCountry) {
		this.nameCountry = nameCountry; 
		this.timeCountry = LocalTime.now(idCountry); 
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public LocalTime getTimeCountry() {
		return timeCountry;
	}

	public void setTimeCountry(LocalTime timeCountry) {
		this.timeCountry = timeCountry;
	}
	
	
}
