package schuelerworkshop;

import lejos.robotics.navigation.Pilot;

public final class BotJim extends Bot {

	public static void main(String[] args) {
		Bot mybot = new BotJim();
		
		System.out.println("Hallo Welt!");
		mybot.setup();
		mybot.myName = "Jimmy";
		mybot.run();
		mybot.wiederholeAllesWasIchAnweise();
		System.out.println("Programmende ;-)");
		try{Thread.sleep(15000);}catch(InterruptedException e){}
	}
	
	protected void meineAnweisungen() {
		//meineFunktion();
		System.out.print(".");
		bot.arc(100);
		bot.travel(200);
	}	

}
