package mario.coloretto.model;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public void verwijderAlleKaartenVanType(final KaartType type) {
		
		//
		// doorzoek kaartenboek naar kaarten die niet gelijk zijn aan dit type
		// en voeg ze toe aan een nieuwe stapel
		
		final List<Kaart> nieuweBoek = new ArrayList<>();
		for (Kaart kaart : kaarten) {
			if (kaart.getType() != type) {
				nieuweBoek.add(kaart);
			}
		}
		
		//
		// verwijder alle kaarten uit het boek
		// en voeg de nieuwe stapel toe aan het boek
		
		this.kaarten.clear();
		this.kaarten.addAll(nieuweBoek);
	}
	
	/**
	 * Neemt een kaart uit het boek van gegeven type
	 * @param type type
	 * @return kaart
	 */
	
	public Kaart neemKaartVanType(final KaartType type) {
		Kaart kaart = null;
		
		//
		// zoek kaart van gegeven type in de stapel
		
		for (Kaart k : kaarten) {
			if (k.getType() == type) {
				kaart = k;
				break;
			}
		}
		
		//
		// indien kaart gevonden, verwijder van boek
		
		if (kaart != null) {
			kaarten.remove(kaart);
		}
		
		return kaart;
	}
	
	/**
	 * Neem de volgende kaart van de stapel
	 * @return volgende kaart
	 */
	
	public Kaart neemVolgendeKaartVanStapel() {
		Kaart res = kaarten.get(kaarten.size()-1);
		kaarten.remove(res);
		return res;
	}
	
	/**
	 * Doorschud de kaarten
	 */
	
	public void shudKaarten() {
		System.out.println("Kaarten shudden...");
		Collections.shuffle(kaarten);
		System.out.println("Kaarten geschud !");
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
		
		voegKaartToe(10, KaartType.PLUS_2_KAART);
		
		// -- 3 jokers
		
		voegKaartToe(3, KaartType.JOKER);
		
		// -- 1 laatste ronde kaart
		
		voegKaartToe(1, KaartType.LAATSTE_RONDE);
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
