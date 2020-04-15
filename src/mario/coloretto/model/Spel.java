package mario.coloretto.model;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Spel {

	private Boek boek;
	private int aantalSpelers;
	
	/**
	 * Constructor
	 * @param aantalSpelers aantal spelers
	 */
	
	public Spel(final int aantalSpelers) {
		this.aantalSpelers = aantalSpelers;
		
		//
		// initialiseer nieuw kaartenboek
		
		this.boek = new Boek();
		
		//
		// configureer spel
		
		configureerSpel();
		
	}
	
	// ------------------------------ private methods ------------------------------------ //
	
	/**
	 * Configureer spel
	 */

	private void configureerSpel() {
		if (aantalSpelers == 2) {
			
			//
			// voor 2 spelers : verwijder 2 kleurenbundles
			
			boek.verwijderKaartenVanType(KaartType.KLEUR_ROZE);
			boek.verwijderKaartenVanType(KaartType.KLEUR_DONKER_BRUIN);
		}		
	}
	
}
