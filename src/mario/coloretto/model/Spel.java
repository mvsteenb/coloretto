package mario.coloretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Hoe gebruiken : 
 * 
 * <pre>
 *   Spel spel = new Spel();
 *   spel.addSpeler(new Speler("Mario");
 *   spel.addSpeler(new Speler("Phoebe");
 *   spel.addSpeler(new Speler("Manos");
 *   spel.start();
 * </pre>
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Spel {

	/** boek */
	private Boek boek;
	
	/** spelers */
	private List<Speler> spelers = new ArrayList<>();
	
	/**
	 * Constructor
	 */
	
	public Spel() {
		reset();
	}
	
	// ------------------------------ public methods ------------------------------------ //

	/**
	 * Reset spel
	 */
	
	public void reset() {
		this.boek = new Boek();
		this.spelers.clear();
	}
	
	/**
	 * Returns aantal spelers
	 * @return aantal spelers
	 */
	
	public int getAantalSpelers() {
		return this.spelers.size();
	}
	
	/**
	 * Voegt speler toe
	 * @param speler
	 */
	
	public void addSpeler(final Speler speler) {
		this.spelers.add(speler);
	}
	
	/**
	 * Start spel
	 */
	
	public void start() {
		initialiseerSpel();
		verdeelKaarten();
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Verdeel kaarten aan spelers
	 */
	
	private void verdeelKaarten() {
		
		//
		// elke speler krijgt een summary kaart
		
	}
	
	/**
	 * Initialiseer spel
	 */

	private void initialiseerSpel() {
		
		final int aantalSpelers = getAantalSpelers();
		
		if (aantalSpelers == 2) {
			
			//
			// voor 2 spelers : verwijder 2 kleurenbundles
			
			boek.verwijderKaartenVanType(KaartType.KLEUR_ROZE);
			boek.verwijderKaartenVanType(KaartType.KLEUR_DONKER_BRUIN);
		}		
	}
	
}
