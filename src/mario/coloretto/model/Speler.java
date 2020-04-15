package mario.coloretto.model;

import java.util.List;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Speler {

	/** naam */
	private String naam;
	
	/** kaarten */
	private List<Kaart> kaarten;
	
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
	
	/**
	 * Kaart toevoegen
	 * @param kaart kaart
	 */
	
	public void addKaart(final Kaart kaart) {
		this.kaarten.add(kaart);
	}
	
	/**
	 * Returns kaarten
	 * @return kaarten
	 */
	
	public List<Kaart> getKaarten() {
		return kaarten;
	}
}
