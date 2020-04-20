package mario.coloretto.model.event;

import mario.coloretto.commando.CommandoType;
import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 20 apr. 2020
 *
 */

public abstract class SpelEvent {
	
	private final Spel spel;
	private final Speler speler;
	
	/**
	 * Constructor
	 */
	
	public SpelEvent(final Spel pspel, final Speler pspeler) {
		this.spel = pspel;
		this.speler = pspeler;
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Geeft toegelaten commando's
	 * @return toegelaten commando's
	 */
	
	public abstract CommandoType[] getAllowedCommands();
	
	/**
	 * Returns spel
	 * @return spel
	 */
	
	public Spel getSpel() {
		return spel;
	}
	
	/**
	 * Returnd speler
	 * @return speler
	 */
	
	public Speler getSpeler() {
		return speler;
	}
}
