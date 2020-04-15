package mario.coloretto.model;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Kaart {

	/** type */
	private KaartType type;
	
	/**
	 * Constructor
	 */
	
	public Kaart() {
		super();
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Constructor
	 * @param ptype type
	 */
	
	public Kaart(final KaartType ptype) {
		this.type = ptype;
	}
	
	public void setType(KaartType type) {
		this.type = type;
	}
	
	public KaartType getType() {
		return type;
	}
	
}
