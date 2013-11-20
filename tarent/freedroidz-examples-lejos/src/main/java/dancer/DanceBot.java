package dancer;

import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.Pilot;
import lejos.robotics.navigation.TachoPilot;

public class DanceBot {
	Pilot pilot;

	public static void main(String[] args) {
		DanceBot example = new DanceBot();
		example.setPilot(new TachoPilot(56, 105, Motor.A, Motor.C));
		example.run();
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	
	protected void run(){
		pilot.travel(100);
		pilot.travel(-100);
		Sound.playTone(0, 2);
		pilot.travel(100);
		pilot.travel(-100);
		pilot.rotate(360);
		pilot.travel(100);
		pilot.travel(-100);
	}
	
}
