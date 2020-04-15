package mario.coloretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Boek {

	/** kaarten */
	private final List<Kaart> kaarten = new ArrayList<>(); 
	
	/**
	 * Constructor
	 */
	
	public Boek() {
		initialize();
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Verwijder kaarten van het gegeven type uit het boek
	 * @param type type
	 */
	
	public void verwijderKaartenVanType(final KaartType type) {
		final List<Kaart> nieuweBoek = new ArrayList<>();
		for (Kaart kaart : kaarten) {
			if (kaart.getType() != type) {
				nieuweBoek.add(kaart);
			}
		}
		this.kaarten.clear();
		this.kaarten.addAll(nieuweBoek);
	}
	
	// ------------------------------ private methods ------------------------------------ //
	
	/**
	 * Initializes cards
	 */
	
	private void initialize() {

		//
		// verwijder alle kaarten
		
		this.kaarten.clear();
		
		//
		// voeg kaarten toe aan het boek
		
		// -- 9 kleurenkaarten van elke kleur
		
		voegKaartToe(9, KaartType.KLEUR_ORANJE);
		voegKaartToe(9, KaartType.KLEUR_BLAUW);
		voegKaartToe(9, KaartType.KLEUR_DONKER_BRUIN);
		voegKaartToe(9, KaartType.KLEUR_GEEL);
		voegKaartToe(9, KaartType.KLEUR_GRIJS);
		voegKaartToe(9, KaartType.KLEUR_GROEN);
		voegKaartToe(9, KaartType.KLEUR_ROZE);
		
		// -- 2 +2 kaarten
		
		voegKaartToe(2, KaartType.PLUS_2_KAART);
		
		// -- 3 jokers
		
		voegKaartToe(3, KaartType.JOKER);
		
		// -- 1 laatste ronde kaart
		
		voegKaartToe(1, KaartType.LAATSTE_RONDE);
		
		// -- 5 bruine kaarten
		
		voegKaartToe(5, KaartType.BRUINE_RIJ_KAART);
		
		// -- 5 summary kaarten
		
		voegKaartToe(5, KaartType.SUMMARY_KAART);
		
		// -- 3 groene kaarten
		
		voegKaartToe(3, KaartType.GROENE_RIJ_KAART);
		
	}
	
	/**
	 * Voeg kaart toe
	 * @param aantal aantal kaarten
	 * @param type type
	 */
	
	private void voegKaartToe(final int aantal, final KaartType type) {
		for (int i=0; i < aantal; i++) {
			kaarten.add(new Kaart(type));
		}
	}
	
}
