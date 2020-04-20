package mario.coloretto.model.event;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 20 apr. 2020
 *
 */

public interface ISpelEventListener {
	
	/**
	 * Called when event was thrown
	 * @param event event
	 */

	void onEvent(final SpelEvent event);
	
}
