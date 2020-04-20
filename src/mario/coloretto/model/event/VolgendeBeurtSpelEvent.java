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

public class VolgendeBeurtSpelEvent extends SpelEvent {
	
	/**
	 * Constructor
	 */
	
	public VolgendeBeurtSpelEvent(final Spel pspel, final Speler pspeler) {
		super(pspel, pspeler);
	}
	
	// ------------------------------ public methods ------------------------------------ //

	@Override
	public CommandoType[] getAllowedCommands() {
		return new CommandoType[] { CommandoType.NEEM_KAART, CommandoType.STOP_SPEL };
	}
}
