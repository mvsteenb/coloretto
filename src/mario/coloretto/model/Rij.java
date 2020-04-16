package mario.coloretto.model;

import java.util.List;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 16 apr. 2020
 *
 */

public class Rij {

	/** kaarten */
	private List<Kaart> kaarten;
	
	/** max aantal kaarten */
	private final int maxAantalKaarten;
	
	/**
	 * Constructor
	 */
	
	public Rij(final int pmaxAantalKaarten) {
		this.maxAantalKaarten = pmaxAantalKaarten;
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Returns max aantal kaarten
	 * @return max aantal kaarten
	 */
	
	public int getMaxAantalKaarten() {
		return maxAantalKaarten;
	}
	
}
