package model;

import java.time.LocalTime;

public class TurnTimer {

	
	private LocalTime timeDuration;
	private LocalTime timeTotal; 
	
	public TurnTimer(LocalTime timeDuration, LocalTime timeTotal) {
		this.timeDuration = timeDuration;
		this.timeTotal = timeTotal; 
	}

	public LocalTime getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(LocalTime timeDuration) {
		this.timeDuration = timeDuration;
	}

	public LocalTime getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(LocalTime timeTotal) {
		this.timeTotal = timeTotal;
	}
	
	
}
