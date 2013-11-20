/**
 *  Diese Klasse kann von den Schülern erweitert werden (extends) und dient zur
 *  Verbergung von vorbereiteten Codezeilen bzw. ausführlicher Dokumentation
 *   Copyright (C) 2013  Stefan Gehrmann
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package schuelerworkshop;

import ws.nxt;
import lejos.robotics.navigation.TachoPilot;
import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.ColorLightSensor;
import lejos.nxt.Sound;
import lejos.nxt.SoundSensor;

//-----------------------------------------------------------------	
/**
 * Sammlung mit vorbereiteten Implementierungscode für einfaches erweitern mit eigener Klasse
 * 
 * Ziel ist es Code für Übungen vorgeben zu können jedoch auch mit eigenen zu überschreiben
 * bzw. mit der Elternklasse zu verketten. Um sich so nur für einzelne Details einer Programmierung 
 * selbst kümmer zu müssen und der einfachheithalber auf Vorgabe Codeteile Beispielcode 
 * zurückgreifen zu können
 * 
 */
abstract class Bot {
	/*
	 * Beispiel einer Main Methode für die personalisierte Bot Klasse
	 * 
	public static void main(String[] args) {
	    // erstellen des Robot mit aus der Abstrakten Klasse Bot
		Bot mybot = new Bot();
		// eine Textzeile auf den NXT ausgeben
		System.out.println("Hallo Welt!");
		// Auswahl und Konfiguration deines Roboters
		mybot.setup(); 
		// starten des Robo durch die verketteten run-Methoden
		mybot.run();
		// Ankündigung des kompletten Durchlauf deines Programmcodes 
		System.out.println("Programmende ;-)");
		// Anzeige für einige Zeit noch anzeigen bis sich der NXT in Hauptmenue zurücksetzt
		try{Thread.sleep(15000);}catch(InterruptedException e){}
	}
	*/	
	
	// bot in Kleinbuchstaben ist der Name deines Roboters dem Du Befehle erteilen kannst.
	lejos.robotics.navigation.Pilot bot;
	public String myName = "";
	public boolean shouldBeRunning = true;
	long lastTouch = System.currentTimeMillis();
	lejos.nxt.TouchSensor t1;
	lejos.nxt.TouchSensor t2;
	lejos.nxt.TouchSensor t3;
	lejos.nxt.TouchSensor t4;
	lejos.nxt.UltrasonicSensor u1;
	lejos.nxt.UltrasonicSensor u4;
	lejos.nxt.LightSensor l1;
	lejos.nxt.ColorLightSensor c1;
	
	
	/**
	 * Setup ermöglicht es alle Einstellungen und Sensoren anzupassen so
	 * wie Du den Roboter auch gebaut hast
	 * Also kontroliere hier noch mal ob alle Stecker genau so in dem NXT gesteckt 
	 * sind wie hier beschrieben! Achte auch auf die richtige reihenfolge der Motoren links, rechts
	 * 
	 *  z.B.: wenn 
	 * 
	 * Dein fertig konfigurierter Roboter wird an die Anwendung Go zurückgegeben
	 * @return Bot
	 */
	public Bot setup() {
		bot = new TachoPilot(56, 173, lejos.nxt.Motor.A, lejos.nxt.Motor.C);
		/**
		 * Sensor initialisieren, dies muss man beim TouchSensor nicht machen, 
		 * bei Licht oder Ultraschall macht es aber Sinn um deren Funktion zu aktivieren
		 */
		t1 = new lejos.nxt.TouchSensor(SensorPort.S1);
		t2 = new lejos.nxt.TouchSensor(SensorPort.S2);
		t3 = new lejos.nxt.TouchSensor(SensorPort.S3);
		t4 = new lejos.nxt.TouchSensor(SensorPort.S4);
		u1 = new lejos.nxt.UltrasonicSensor(SensorPort.S1);		
		u4 = new lejos.nxt.UltrasonicSensor(SensorPort.S3);		
		//l1 = new lejos.nxt.LightSensor(SensorPort.S1);
		//c1 = new lejos.nxt.ColorLightSensor(SensorPort.S1, lejos.nxt.ColorLightSensor.TYPE_COLORFULL);
		
		return this;
	}
	
	/**              
	 * Das ist Deine Hauptfunktion in der alles abläuft
	 * 
	 * 
	 * Am Ende ehält die Funktion static main aus der Anwendung Go diesen Roboter mit Einstellungen
	 * @return Bot
	 */
	public Bot run() {
		System.out.println(myName+" startet");
		
		try {
			bot.travel(-10);
			// -----------------------------------------------------------------	
// rufte Deine eigenen Funktionen auf setze oder entferne // am Anfang der Zeile
			/*
			meineFunktion();
			meineZweite();
			*/
			//schaltMichEinUndSchaltMichAus(); // s0 MotorB an | s1 MotorB aus
			//tastEreignisse(true);            // Tastsensoren anzeigen wenn gedrückt
			
			//fnkWhileESCAPEmeineZweite(); // die Funktion meineZweite() ist noch leer! 
			
			//tueIrgendwas();                      			
			//vorTueIrgendwas();     // beinhaltet whileProgramIsRunningTueIrgendwas() und tastEreignisse()			
			// -----------------------------------------------------------------	
		} catch (Exception e) {
			System.out.println("Kontroliere Deinen Code es gab ein Fehler!");
		}
		return this;
	}
	
	/**********************************************************************
	 *                                                                    *
	 * Schreibe deine eigennen Funktionen                                 *
	 * folgend sind bereit einige vorbereitet benutze bot. um dein        *
	 * Robotor zu steuern!                                                *
	 *                                                                    *
	 **********************************************************************/
	protected void meineFunktion() {
		System.out.println("meineFunktion-->");
		
		bot.travel(zufallszahl());
		bot.arc(100, 45);
		bot.rotate(zufallszahl());
		
		/*
		for(int i = 0; i < 4; i++){
			System.out.println("Wiederholung "+i);
			bot.travel(100);
			bot.rotate(90);			
		}
		*/
	}
	
	private void meineZweite() {
		//tastSensoren();
		//ultraschalSensoren();
	}
	
	protected void wiederholeAllesWasIchAnweise() {
		System.out.println("Stop den NXT mit");
		System.out.println("oranger & grauer");
		System.out.println("Tasten zusammen!");		
		while(true) {
			meineAnweisungen();
		}
	}
	protected void meineAnweisungen() {
		//meineFunktion();
	}	

	private void tastSensoren() {
		
		if(t2.isPressed()) {
			System.out.println("fahre Vorwaerts");
			bot.forward();
		}
		if(t3.isPressed()) {
			System.out.println("fahre Zurueck");
			bot.backward();
		}
		
		long now = System.currentTimeMillis();
		if(now - lastTouch > 6000) {
			System.out.println("wechsle Richtung");
			weicheAus();
		}
		
		if(ESCAPEwasPressed) {
			System.out.println(now - lastTouch);
		}
	}
	
	boolean ESCAPEwasPressed = false;
	private void ultraschalSensoren() {
		showUltraschalInfos();
		
		if(u1.getDistance() < 20) {
			System.out.println("fahre Vorwaerts");
			bot.forward();
		}
		if(u4.getDistance() < 20) {
			System.out.println("fahre Zurueck");
			bot.backward();
		}
		
		long now = System.currentTimeMillis();
		if(now - lastTouch > 16000) {
			System.out.println("wechsle Richtung");
			weicheAus();
		}	
		
		if(ESCAPEwasPressed) {
			System.out.println(now - lastTouch);
		}
	}
	
	private void showUltraschalInfos() {
		int d1 = u1.getDistance();
		int d4 = u4.getDistance();
		System.out.println("Abstaende sind:");
		if(d1 < 100){
			System.out.println("vorne ="+d1);
		}
		if(d4 < 100){
			System.out.println("hinten="+d4);
		}
	}
	
	public void weicheAus() {
		bot.travel(-100);
		bot.rotate(zufallszahl());
		bot.forward();
		lastTouch = System.currentTimeMillis();
	}
		
	/**
	 * Diese Funktion sollte nicht verändert werden
	 * Es sei denn Du kennst dich damit bereits aus
	 * 
	 * wiederholt etwas bis ESCAPE (kleine graue Taste) gedrückt wird
	 */
	private void fnkWhileESCAPEmeineZweite() throws Exception {
		System.out.println("whileFunktion");
	
		// so lange bis escape button gedrueckt ist
		while(!Button.ESCAPE.isPressed()) {
			meineZweite();
			Thread.sleep(10); // absturz verhindern
		}
		ESCAPEwasPressed = true;
	}

// °º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,
	int counter = 1;
	/**
	 * Diese Fuktion kannst Du verwenden.
	 * Wie die ersten muss sie in der run-Methode aufgerufen werden.
	 * 
	 * oder Du schreibst vorTueIrgendwas() in run 
	 * Dann sind Taster t1-t4 und enterPressed im Funktion verwendbar
	 * t1-t4 müssen angeschlossene Sensoren sein dass man sie verwenden kann
	 * enterPressed ist gleich true wenn man am NXT auf die orange-Taste drückt
	 * Es wird somit auch der Inhalt der enterWasPressed() Funktion ausgeführt.
	 * auch ist es einfacher das Programm schnell zu beenden mit
	 * kurz auf die Escape-Taste (kleine graue Taste am NXT)
	 * 
	 * @throws Exception
	 */
	private void tueIrgendwas() throws Exception {
		// -----------------------------------------------------------------	
		//System.out.println("tueIrgendwas"+counter);
		counter++;
		Motor.B.rotate(counter);

		if(shouldBeRunning) {
			ultraschalSensoren();
		}

		if(t4.isPressed()) {
			shouldBeRunning = false;
			lejos.nxt.Motor.A.rotate(0);
			lejos.nxt.Motor.B.rotate(0);
			lejos.nxt.Motor.C.rotate(0);
		}
		
		System.out.println(shouldBeRunning);
		// -----------------------------------------------------------------	
		
	}
	/**
	 * Diese Funktion läuft mit der tueIrgendwas 
	 * wenn sie in der run mit vorTueIrgendwas() aufgerufen wurde
	 * 
	 * vorTueIrgendwas-->whileProgramIsRunningTueIrgendwas-->tueIrgendwas
	 */
	private void enterWasPressed() {
		shouldBeRunning = true;
		enterPressed = false;
	}
	
	/**
	 * Diese Funktion sollte nicht verändert werden
	 * Es sei denn Du kennst dich damit bereits aus
	 * 
	 * wiederholt etwas bis ESCAPE (kleine graue Taste) gedrückt wird
	 * 
	 * @throws Exception
	 */
	private void vorTueIrgendwas() throws Exception {
		// -----------------------------------------------------------------	
		tastEreignisse(false); // Ausgabe der Tastenevents auf dem NXT
		System.out.println("S1S4ESCAPE+ENTER");
		whileProgramIsRunningTueIrgendwas(); // ESCAPE und ENTER loop
	}
// °º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,
	
	
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
					//runProgram = false;
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
				System.out.println("Enter gedrueckt!");
				enterWasPressed();
			}
			System.out.print("-");
			//tue etwas... bis ENTER Button (orangene Taste) gedrückt wird
			tueIrgendwas();
		}
		System.out.println("while-Ende");
	}
		
	private void schaltMichEinUndSchaltMichAus() throws Exception {
		// das ist eine Endlosschleife die den Code immer weiter wiederholt
		while(true) {
			// hier kommt das hin was wiederholt werden soll
			System.out.println("Taster S2:"+t2.isPressed()); 
			
			if(t2.isPressed()) {
				Motor.B.forward();
				System.out.println("S2:"+t2.isPressed()); 
			}
			if(t3.isPressed()) {
				Motor.B.stop();
				System.out.println("S3:"+t3.isPressed()); 
			}	
			Thread.sleep(10);
		}	
	}
	/**********************************************************************/	
	private void tastEreignisse(boolean mitWhile) throws Exception {
		// Listener für jeden Taster hinzufügen
		SensorPort.S1.addSensorPortListener(touchSensorListener);
		SensorPort.S2.addSensorPortListener(touchSensorListener);
		SensorPort.S3.addSensorPortListener(touchSensorListener);
		SensorPort.S4.addSensorPortListener(touchSensorListener);
		
		System.out.println("Taste druecken!");
		// Wenn man sonst nichts weiter macht, muss man das Programm am laufen halten:
		while(mitWhile && !Button.ESCAPE.isPressed()) {
			System.out.print(".");
			Thread.sleep(10); // nichts tun warten bis jemand drückt!
		}		
	}
	
	// den SensorPortListener bauen kan mehrfach verwendet werden
	private SensorPortListener touchSensorListener = new SensorPortListener() {
		
		/** 
		 * diese Methode wird shouldBeRunningjedesmal aufgerufen, wenn die Roh-Werte des Sensors sich verändern.
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
	private int zufallszahl() {
		return (int) ((Math.random()-0.5f)*360); 
	}
} // end of Robo
