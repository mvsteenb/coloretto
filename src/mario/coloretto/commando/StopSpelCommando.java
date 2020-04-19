package mario.coloretto.commando;

import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 19 apr. 2020
 *
 */

public class StopSpelCommando extends SpelCommando {

	/**
	 * Constructor
	 */
	
	public StopSpelCommando(final Spel spel, final Speler speler) {
		super(spel, speler);
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	@Override
	public void voerCommandoUit() {
		System.out.println(getSpeler().getNaam() + " heeft gevraagd het spel onmiddelijk te stoppen !");
		getSpel().stop();
	}

	
	
}
