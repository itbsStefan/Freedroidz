package myCode;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Sound;
import lejos.robotics.navigation.TachoPilot;

public class Robo {
	// Das ist Dein Roboter dem Du Befehle erteilen kannst.
	lejos.robotics.navigation.Pilot bot; 
	
	public Robo setup() {
		bot = new TachoPilot(56, 173, lejos.nxt.Motor.A, lejos.nxt.Motor.C);
		return this;
	}
	
	public Robo run() {
		System.out.println("Schreibe Dein Namen hier!");
		
		try {
			// rufte Deine eigenen Funktionen auf
			meineFunktion();
			
			
			//demo(); // lass den Bot im Kreis drehen! entferne // am Anfang der Zeile
		} catch (Exception e) {
			System.out.println("Kontroliere Dein Code es gab ein Fehler!");
		}
		return this;
	}
	
	private void meineFunktion() {
		System.out.println("Starte meineFunktion :-)");
		
		for(int i = 0; i < 4; i++){
			System.out.println("Wiederholung "+i);
			bot.travel(100);
			bot.rotate(90);			
		}
		
	}

	boolean runProgram = true;
	boolean enterPressed = false;
	private void tueIrgendwas() {
		
		Button.ENTER.addButtonListener(
			new ButtonListener() {
				public void buttonPressed(Button arg0) {
					// Flag setzen
					enterPressed = true;
				}
				public void buttonReleased(Button arg0) {
					// Programm beenden
					runProgram = false;
				}
			}
		);
		
		Button.ESCAPE.addButtonListener(
			new ButtonListener() {
				public void buttonPressed(Button arg0) {
					System.exit(0); // Stop Programm sofort
				}
				public void buttonReleased(Button arg0) {
					// is never called
				}
			}
		);		
		
		while(runProgram) {
			if(enterPressed) {
				Sound.playTone(0, 2);
			}
			//tue etwas... bis ENTER Button (orangene Taste) gedrückt wird
		}
		System.out.println("Die while-Schleife wurde beendet.");
	}
	
	private void demo() throws Exception {
		System.out.println("Demostrationsfunktion");
	
		// so lange bis escape button gedrueckt ist
		while(!Button.ESCAPE.isPressed()) {
			bot.arc(500, 45);
		
			Thread.sleep(10); // absturz verhindern
		}
	}	
} // end of Robo
