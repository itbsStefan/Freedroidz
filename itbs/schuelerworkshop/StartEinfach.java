package schuelerworkshop;

import lejos.robotics.navigation.TachoPilot;
import lejos.nxt.Button;

public class StartEinfach {
	lejos.robotics.navigation.Pilot pilot;
	
	public static void main(String[] args) {
		StartEinfach startProgramm = new StartEinfach();
		startProgramm.pilot = new TachoPilot(56, 173, lejos.nxt.Motor.A, lejos.nxt.Motor.C);
		
		startProgramm.run();
		
		try{
			
			
			
			
			
			
			//startProgramm.run();
		}catch(Exception e){
			
		}
	}

	private void run() {//throws InterruptedExeption {
		while(!Button.ESCAPE.isPressed()){
			pilot.forward();
			
		}
	}

}
 