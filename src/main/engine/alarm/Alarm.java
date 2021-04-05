package main.engine.alarm;

public class Alarm {
	
	private AlarmEvent alarm;
	private int timer;
	
	public Alarm(AlarmEvent alarm) {
		this.alarm = alarm;
		timer = -1;
	}
	
	public void setEvent(AlarmEvent alarm, int timer) {
		this.alarm = alarm;
		this.set(timer);
		System.out.println("Set timer to : " + timer);
	}
	
	public void setEvent(AlarmEvent alarm, double timer) {
		setEvent(alarm, (int)timer);
	}
	
	public void set(int time) {
		timer = time;
	}
	
	public void update() {
		if(timer > 0) {
			System.out.println("Tick");
			timer -= 1;
		}
		else {
			if(this.alarm != null) {
				alarm.event();
				timer = -1;
			}
		}
	}
}
