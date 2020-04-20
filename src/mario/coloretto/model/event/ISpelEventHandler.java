package mario.coloretto.model.event;

import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 19 apr. 2020
 *
 */

public interface ISpelEventHandler {

	/**
	 * Speelt beurt
	 * @param spel spel
	 * @param speler speler
	 */
	
	void speelBeurt(final Spel spel, final Speler speler);
	
	/**
	 * Spel gestopt
	 * @param spel spel
	 */
	
	void stopSpel(final Spel spel);
	
}
