package mario.coloretto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mario.coloretto.model.event.ISpelEventListener;
import mario.coloretto.model.event.SpelEvent;
import mario.coloretto.model.event.VolgendeBeurtSpelEvent;

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
	
	/** huidige beurt in het spel */
	private int huidigeBeurt = 0;
	
	/** huidige ronde in het spel */
	private int huidigeRonde = 0;
	
	/** huidige speler */
	private Speler huidigeSpeler;
	
	/** <code>true</code> indien spel gestart */
	private boolean gestart;
	
	/** <code>true</code> indien laatste ronde */
	private boolean laatsteRonde;
	
	/** event listeners */
	private List<ISpelEventListener> spelEventListeners = new ArrayList<>();
	
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
		System.out.println("[SPEL] : Spel klaar zetten...");
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
		System.out.println("[SPEL] : Speler toegevoegd : " + speler.getNaam());
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
		System.out.println("******** KAARTEN ALLE SPELERS ***********");
		spelers.forEach(speler -> { toonKaarten(speler); });
		System.out.println("*****************************************");
	}
	
	/**
	 * Returns <code>true</code> indien spel gestart
	 * @return <code>true</code> indien spel gestart
	 */
	
	public boolean isGestart() {
		return gestart;
	}
	
	/**
	 * Returns <code>true</code> indien laatste ronde
	 * @return <code>true</code> indien laatste ronde
	 */
	
	public boolean isLaatsteRonde() {
		return laatsteRonde;
	}
	
	/**
	 * Returns huidige ronde
	 * @return huidige ronde
	 */
	
	public int getHuidigeRonde() {
		return huidigeRonde;
	}
	
	/**
	 * Start spel
	 */
	
	public void start() {
		
		System.out.println("[SPEL] : Spel starten...");
		
		//
		// verdeel de kaarten
		
		verdeelKaarten();
		
		//
		// schud kaarten in het kaartenboek
		
		boek.shudKaarten();
		
		//
		// Kies huidige speler
		
		Collections.shuffle(spelers);
		this.huidigeBeurt = 0;
		huidigeSpeler = spelers.get(huidigeBeurt);
		
		//
		// Klaar om te starten
		
		gestart = true;
		
		System.out.println("[SPEL] : ^^^ GAME ON ^^^");
		
	}
	
	/**
	 * Stopt spel
	 */
	
	public void stop() {
		gestart = false;
		
		System.out.println("[SPEL] : ^^^ EIND SPEL ^^^");
	}
	
	/**
	 * Neem kaart van de stapel en plaats bij een rij kaart
	 */
	
	public void neemKaartVanStapel() {
		
		// TODO : implement !
		
	}
	
	/**
	 * Speel volgende beurt
	 */
	
	public void volgendeBeurt() {
		
		if (!laatsteRonde) {
			
			System.out.println("[SPEL] : BEURT : " + huidigeBeurt + "/" + huidigeRonde);
			
			//
			// speel beurt
			
			notifyEvent(new VolgendeBeurtSpelEvent(this, huidigeSpeler));
			
			//
			// zet volgende speler
			
			if (huidigeBeurt+1 < spelers.size()) {
				huidigeBeurt++;
			}
			else {
				System.out.println("[SPEL] : VOLGENDE RONDE : " + huidigeBeurt + "/" + huidigeRonde);
				huidigeBeurt = 0;
				huidigeRonde++;
			}
			
			huidigeSpeler = spelers.get(huidigeBeurt);
			
		}
		else {
			gestart = false;
		}
		
	}
	
	/**
	 * Adds event listener
	 * @param l event listener
	 */
	
	public void addEventListener(final ISpelEventListener l) {
		this.spelEventListeners.add(l);
	}
	
	// ------------------------------ private methods ------------------------------------ //
	
	/**
	 * Verdeel kaarten aan spelers
	 */
	
	private void verdeelKaarten() {
		System.out.println("[SPEL] : Kaarten verdelen...");
		
		int aantalSpelers = getAantalSpelers();
		List<KaartType> beschikbareKleuren = new ArrayList<>(Arrays.asList(KaartType.KLEUR_KAARTEN));
		
		if (aantalSpelers == 2) {
			
			//
			// voor 2 spelers : verwijder 2 kleurenbundles 
			
			boek.verwijderAlleKaartenVanType(KaartType.ROZE);
			boek.verwijderAlleKaartenVanType(KaartType.DONKER_BRUIN);
		
			beschikbareKleuren.remove(KaartType.ROZE);
			beschikbareKleuren.remove(KaartType.DONKER_BRUIN);
			
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
				boek.verwijderAlleKaartenVanType(KaartType.ROZE);
				beschikbareKleuren.remove(KaartType.ROZE);
			}
			
			//
			// maak rijkaarten aan (1 per speler) -- bruine rijkaarten (altijd 3)
			
			for (int i = 0; i < aantalSpelers; i++) {
				rijen.add(new Rij(3));
			}
		}

		//
		// elke speler krijgt een summary kaart
		
		spelers.forEach(speler -> { speler.addKaart(new Kaart(KaartType.SUMMARY)); });
		
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
		
		System.out.println("[SPEL] : Kaarten verdeeld !");
	}
	
	/**
	 * Notifies event listeners of event
	 * @param e event
	 */
	
	private void notifyEvent(final SpelEvent e) {
		this.spelEventListeners.forEach(l -> { l.onEvent(e); } );
	}
}
