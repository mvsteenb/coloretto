package mario.coloretto.commando;

import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 19 apr. 2020
 *
 */

public abstract class SpelCommando implements ICommando {

	/** spel */
	private final Spel spel;
	
	/** speler */
	private final Speler speler;
	
	/**
	 * Constructor
	 */
	
	public SpelCommando(final Spel spel, final Speler speler) {
		this.spel = spel;
		this.speler = speler;
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Returns spel
	 * @return spel
	 */
	
	public Spel getSpel() {
		return spel;
	}
	
	/**
	 * Returns speler
	 * @return speler
	 */
	
	public Speler getSpeler() {
		return speler;
	}
}
