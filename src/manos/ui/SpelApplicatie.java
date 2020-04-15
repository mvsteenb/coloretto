package manos.ui;
import manos.domein.Spel;

public class SpelApplicatie {
	
	public static void main(String[] args) {
		
		Spel app = new Spel();
		app.startSpel();
		app.vulKleurArray();
		app.vulSpelerArray();
		app.kiesKleur();
	
	}
	
} // einde app