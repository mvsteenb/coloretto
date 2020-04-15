package mario.coloretto.model;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Speler {

	/** naam */
	private String naam;
	
	/**
	 * Constructor
	 */
	
	public Speler() {
		super();
	}
	
	/**
	 * Constructor
	 */
	
	public Speler(final String pname) {
		this.naam = pname;
	}
	
	// ------------------------------ public methods ------------------------------------ //

	/**
	 * Sets naam
	 * @param naam naam
	 */
	
	public void setNaam(final String naam) {
		this.naam = naam;
	}
	
	/**
	 * Returns naam
	 * @return naam
	 */
	
	public String getNaam() {
		return naam;
	}
}
