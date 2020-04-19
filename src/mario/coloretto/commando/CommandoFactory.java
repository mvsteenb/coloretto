package mario.coloretto.commando;

import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 19 apr. 2020
 *
 */

public class CommandoFactory {

	/**
	 * Constructor
	 */
	
	public CommandoFactory() {
		super();
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Maak commando aan
	 * @param commando commando string
	 * @return commando
	 */
	
	public ICommando maakCommandoAan(final CommandoType commandoType, final Spel spel, final Speler speler) {
		if (CommandoType.NEEM_KAART == commandoType) {
			return new NeemKaartCommando(spel, speler);
		}
		if (CommandoType.STOP_SPEL == commandoType) {
			return new StopSpelCommando(spel, speler);
		}
		return null;
	}
	
}
