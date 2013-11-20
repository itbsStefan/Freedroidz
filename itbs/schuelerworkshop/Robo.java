package schuelerworkshop;

import lejos.robotics.navigation.TachoPilot;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;

public class Robo {
	public static void main(String[] args) {
		Robo mybot = new Robo();
		System.out.println("Hallo Welt!");
		mybot.setup();
		mybot.run();
		System.out.println("Programmende ;-)");
		try{Thread.sleep(15000);}catch(InterruptedException e){}
	}
	
// -----------------------------------------------------------------	
	//bot ist der Name deines Roboters dem Du Befehle erteilen kannst.
	lejos.robotics.navigation.Pilot bot;
	
	public Robo setup() {
		bot = new TachoPilot(56, 173, lejos.nxt.Motor.A, lejos.nxt.Motor.C);
		return this;
	}
	
	public Robo run() {
		System.out.println("Dein Namen hier!");
		
		try {
			bot.travel(-10);
			// -----------------------------------------------------------------	
// rufte Deine eigenen Funktionen auf setze oder entferne // am Anfang der Zeile
			meineFunktion();
			
			//schaltMichEinUndSchaltMichAus(); // s0 MotorB an | s1 MotorB aus
			//tastEreignisse(true);            // Tastsensoren anzeigen wenn gedrückt
			//demoESCAPEmeineZweite(); // die Funktion meineZweite() ist noch leer! 

			
			//tueIrgendwas();                      
			
			//vorTueIrgendwas();  // beinhaltet whileProgramIsRunningTueIrgendwas() und tastEreignisse()
			
			
			// -----------------------------------------------------------------	
		} catch (Exception e) {
			System.out.println("Kontroliere Deinen Code es gab ein Fehler!");
		}
		return this;
	}
	
	private void meineFunktion() {
		System.out.println("meineFunktion-->");
		
		bot.travel(100);
		bot.arc(100, 45);
		bot.rotate(90);
		
		/*
		for(int i = 0; i < 4; i++){
			System.out.println("Wiederholung "+i);
			bot.travel(100);
			bot.rotate(90);			
		}
		*/
	}

	private void meineZweite() {

	}
	
	int counter = 1;
	private void tueIrgendwas() throws Exception {
		// -----------------------------------------------------------------	
		//System.out.println("tueIrgendwas"+counter);
		counter++;
		Motor.B.rotate(counter);

		// -----------------------------------------------------------------	
		
	}

	private void vorTueIrgendwas() throws Exception {
		// -----------------------------------------------------------------	
		tastEreignisse(false); // Ausgabe der Tastenevents auf dem NXT
		System.out.println("S1-S4+ESCAPE+ENTER");
		whileProgramIsRunningTueIrgendwas(); // ESCAPE und ENTER loop
	}
// -----------------------------------------------------------------	
	
	/**********************************************************************
	 *                                                                    *
	 * Probiere den folgenden Code, schau ihn dir an vielleicht kannst Du *
	 * Teile verwenden in deinen eigennen Funktion                        *
	 *                                                                    *
	 **********************************************************************/
	boolean runProgram = true;
	boolean enterPressed = false;
	private void whileProgramIsRunningTueIrgendwas() throws Exception{
		
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
					System.exit(0); // Stopt Programm sofort
				}
				public void buttonReleased(Button arg0) {
					// is never called
				}
			}
		);		
		
		while(runProgram) {
			if(enterPressed) {
				Sound.playTone(0, 2, 5);
				System.out.println("r:"+runProgram+" e:"+enterPressed);
			}
			//tue etwas... bis ENTER Button (orangene Taste) gedrückt wird
			tueIrgendwas();
		}
		System.out.println("while-Ende");
	}
	
	private void demoESCAPE() throws Exception {
		System.out.println("Demofunktion");
	
		// so lange bis escape button gedrueckt ist
		while(!Button.ESCAPE.isPressed()) {
			meineZweite();
			Thread.sleep(10); // absturz verhindern
		}
	}
	
	private void schaltMichEinUndSchaltMichAus() throws Exception {
		// erstellt einen Berührungssensor mit dem Namen 'touchMe'
		TouchSensor touchMe = new TouchSensor(SensorPort.S1);
		TouchSensor sID1 = new TouchSensor(SensorPort.S2);

		// das ist eine Endlosschleife die den Code immer weiter wiederholt
		while (true) {
			// hier kommt das hin was wiederholt werden soll
			System.out.println("S1:"+touchMe.isPressed()); 
			
			if(touchMe.isPressed()) {
				Motor.B.forward();
			}
			if(sID1.isPressed()) {
				Motor.B.stop();
			}	
			Thread.sleep(10);
		}	
	}
	/**********************************************************************/	
	// Sensor initialisieren, dies muss man beim TouchSensor nicht machen, 
	//	bei Licht oder Ultraschall macht es aber Sinn um deren Funktion zu aktivieren
	private TouchSensor touch = new TouchSensor(SensorPort.S1);

	private void tastEreignisse(boolean mitWhile) throws Exception {
		// Listener für jeden Taster hinzufügen
		SensorPort.S1.addSensorPortListener(touchSensorListener);
		SensorPort.S2.addSensorPortListener(touchSensorListener);
		SensorPort.S3.addSensorPortListener(touchSensorListener);
		SensorPort.S4.addSensorPortListener(touchSensorListener);
		
		System.out.println("Taste druecken!");
		// Wenn man sonst nichts weiter macht, muss man das Programm am laufen halten:
		while(mitWhile && !Button.ESCAPE.isPressed()) {
			Thread.sleep(10); // nichts tun warten bis jemand drückt!
		}		
	}
	
	// den SensorPortListener bauen kan mehrfach verwendet werden
	private SensorPortListener touchSensorListener = new SensorPortListener() {
		
		/** 
		 * diese Methode wird jedesmal aufgerufen, wenn die Roh-Werte des Sensors sich verändern.
		 */
		@Override
		public void stateChanged(SensorPort port, int oldValue, int newValue) {
			
			// hiermit kann man sich einen Eindruck verschaffen, wie oft diese Methode aufgerufen wird und mit welchen Werten.
//			System.out.println(oldValue + "      " + newValue); 
			
			// wie man sieht ändert sich der Wert manchmal nur geringfügig, 
			// d.h. für den TouchSensor würde z.B. folgende Abfrage Sinn machen:
			if(oldValue > 500 && newValue < 500) {
				onTouchPress(port);
			} else if(oldValue < 500 && newValue > 500) {
				onTouchRelease(port);
			}
		}
		
	};
	
	/** 
	 * wird aufgerufen wenn der TouchSensor gedrückt wird
	 */
	protected void onTouchPress(SensorPort port) {
		System.out.println("S"+port.getId()+" gedrueckt!");
	}
	
	/** 
	 * wird aufgerufen wenn der TouchSensor wieder losgelassen wird
	 */
	protected void onTouchRelease(SensorPort port) {
		System.out.println("S"+port.getId()+" losgelassen");
	}
	/**********************************************************************/	
} // end of Robo
