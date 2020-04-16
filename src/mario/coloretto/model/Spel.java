package mario.coloretto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hoe gebruiken : 
 * 
 * <pre>
 *   Spel spel = new Spel();
 *   spel.addSpeler(new Speler("Mario");
 *   spel.addSpeler(new Speler("Phoebe");
 *   spel.addSpeler(new Speler("Manos");
 *   spel.start();
 * </pre>
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public class Spel {

	/** boek */
	private Boek boek;
	
	/** spelers */
	private final List<Speler> spelers = new ArrayList<>();
	
	/** rijen */
	private final List<Rij> rijen = new ArrayList<>();
	
	/** laatste-ronde kaart */
	private Kaart laatsteRondeKaart;
	
	/**
	 * Constructor
	 */
	
	public Spel() {
		reset();
	}
	
	// ------------------------------ public methods ------------------------------------ //

	/**
	 * Reset spel
	 */
	
	public void reset() {
		
		System.out.println("Spel klaar zetten...");
		
		this.boek = new Boek();
		this.spelers.clear();
	}
	
	/**
	 * Returns aantal spelers
	 * @return aantal spelers
	 */
	
	public int getAantalSpelers() {
		return this.spelers.size();
	}
	
	/**
	 * Voegt speler toe
	 * @param speler
	 */
	
	public void addSpeler(final Speler speler) {
		this.spelers.add(speler);
		System.out.println("Speler toegevoegd : " + speler.getNaam());
	}
	
	/**
	 * Toont kaarten van speler
	 * @param speler speler
	 */
	
	public void toonKaarten(final Speler speler) {
		System.out.println(speler);
	}
	
	/**
	 * Toont kaarten van alle spelers
	 */
	
	public void toonKaartenAlleSpelers() {
		System.out.println("******** KAARTEN ALLE SPELERS **********");
		spelers.forEach(speler -> { toonKaarten(speler); });
		System.out.println("*****************************************");
	}
	
	/**
	 * Start spel
	 */
	
	public void start() {
		
		System.out.println("Spel starten...");
		
		//
		// verdeel de kaarten
		
		verdeelKaarten();
		
		//
		// shud kaarten in het kaartenboek
		
		boek.shudKaarten();
		
		System.out.println("^^^ GAME ON ^^^");
	}
	
	// ------------------------------ public methods ------------------------------------ //
	
	/**
	 * Verdeel kaarten aan spelers
	 */
	
	private void verdeelKaarten() {
		System.out.println("Kaarten verdelen...");
		
		int aantalSpelers = getAantalSpelers();
		List<KaartType> beschikbareKleuren = new ArrayList<>(Arrays.asList(KaartType.KLEUR_KAARTEN));
		
		if (aantalSpelers == 2) {
			
			//
			// voor 2 spelers : verwijder 2 kleurenbundles 
			
			boek.verwijderAlleKaartenVanType(KaartType.KLEUR_ROZE);
			boek.verwijderAlleKaartenVanType(KaartType.KLEUR_DONKER_BRUIN);
		
			beschikbareKleuren.remove(KaartType.KLEUR_ROZE);
			beschikbareKleuren.remove(KaartType.KLEUR_DONKER_BRUIN);
			
			// 
			// gebruik de groene rijkaarten (1,2,3)
			
			rijen.add(new Rij(1));
			rijen.add(new Rij(2));
			rijen.add(new Rij(3));
			
		}
		else {

			//
			// With 3 players, remove the cards of one color from the game.
			
			if (aantalSpelers == 3) {
				boek.verwijderAlleKaartenVanType(KaartType.KLEUR_ROZE);
				beschikbareKleuren.remove(KaartType.KLEUR_ROZE);
			}
			
			//
			// maak rijkaarten aan (1 per speler) -- bruine rijkaarten (altijd 3)
			
			for (int i = 0; i < aantalSpelers; i++) {
				rijen.add(new Rij(3));
			}
		}

		//
		// elke speler krijgt een summary kaart
		
		spelers.forEach(speler -> { speler.addKaart(new Kaart(KaartType.SUMMARY_KAART)); });
		
		//
		// Remove the ‘last round’ card from the deck and set it aside for now
		
		laatsteRondeKaart = boek.neemKaartVanType(KaartType.LAATSTE_RONDE);

		//
		// Elke speler krijgt een kaart van een verschillende kleur

		for (Speler speler : spelers) {
			
			// neem een kleur uit de nog beschikbare kleuren en verwijder deze kleur
			
			KaartType kleur = beschikbareKleuren.get(0);
			beschikbareKleuren.remove(kleur);
			
			//
			// neem een kaart van deze kleur uit het boek en geef aan speler
			
			Kaart kaart = boek.neemKaartVanType(kleur);
			speler.addKaart(kaart);
			
		}
		
		System.out.println("Kaarten verdeeld !");
	}
	
	
}
