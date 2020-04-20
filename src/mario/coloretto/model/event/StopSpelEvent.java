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

public class StopSpelEvent extends SpelEvent {
	
	/**
	 * Constructor
	 */
	
	public StopSpelEvent(final Spel pspel, final Speler pspeler) {
		super(pspel, pspeler);
	}
	
	// ------------------------------ public methods ------------------------------------ //

	@Override
	public CommandoType[] getAllowedCommands() {
		return null;
	}

}
