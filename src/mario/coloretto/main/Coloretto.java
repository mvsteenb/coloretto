package mario.coloretto.main;

import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 16 apr. 2020
 *
 */

public class Coloretto {

	/**
	 * Constructor
	 */
	
	public Coloretto() {
		super();
	}
	
	// ------------------------------ public main methods ------------------------------------ //
	
	/**
	 * Start spel
	 */
	
	public void startSpel() {
		
		//
		// maak een nieuw spel aan en voeg spelers toe
		
		Spel spel = new Spel();
		spel.addSpeler(new Speler("Manos"));
		spel.addSpeler(new Speler("Phoebe"));
		spel.addSpeler(new Speler("Nikos"));
		spel.addSpeler(new Speler("Jorgos"));
		spel.addSpeler(new Speler("Mario"));
		
		//
		// start het spel
		
		spel.start();
		
		//
		// toon kaarten
		
		spel.toonKaartenAlleSpelers();
	}
	
	// ------------------------------ public main methods ------------------------------------ //
	
	/**
	 * Main
	 * @param args
	 */
	
	public static void main(final String[] args) {
		Coloretto coloretto = new Coloretto();
		coloretto.startSpel();
	}
}
