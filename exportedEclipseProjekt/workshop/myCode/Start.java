package myCode;

import myCode.Robo;

public class Start {
	public static void main(String[] args) {
		Robo botStefan = new Robo();
		botStefan.setup();
		botStefan.run();
		System.out.println("Ich habe Dein Progamm abgearneitet.");
		lejos.nxt.Button.waitForPress();
	}
}