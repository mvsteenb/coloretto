package mario.coloretto.main;

import java.util.Scanner;

import mario.coloretto.commando.CommandoFactory;
import mario.coloretto.commando.CommandoType;
import mario.coloretto.commando.ICommando;
import mario.coloretto.model.ISpelEventHandler;
import mario.coloretto.model.Spel;
import mario.coloretto.model.Speler;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 16 apr. 2020
 *
 */

public class Coloretto implements ISpelEventHandler {

	/** scanner */
	private Scanner scanner;
	
	/**
	 * Constructor
	 */
	
	public Coloretto() {
		super();
	}
	
	// ------------------------------ public main methods ------------------------------------ //
	
	/**
	 * Start spel
	 */
	
	public void startSpel() {

		//
		// maak een nieuw spel aan en voeg spelers toe...
		// TIP : kan je ook doen via commands (maak een AddPlayerCommand) 
		
		Spel spel = new Spel(this);
		
		spel.addSpeler(new Speler("Manos"));
		spel.addSpeler(new Speler("Phoebe"));
		spel.addSpeler(new Speler("Nikos"));
		spel.addSpeler(new Speler("Jorgos"));
		spel.addSpeler(new Speler("Mario"));
		
		//
		// start het spel
		
		spel.start();
		
		//
		// toon kaarten
		
		spel.toonKaartenAlleSpelers();
		
		//
		// start game loop
		
		while (spel.isGestart()) {
			
			//
			// speel de volgende beurt
			
			spel.volgendeBeurt();
			
		}
		
	}
	
	@Override
	public void speelBeurt(final Spel spel, final Speler speler) {
		ICommando commando = leesCommando(spel, speler, CommandoType.SPELBEURT_COMMANDOS);
		if (commando != null) {
			commando.voerCommandoUit();
		}
	}
	
	@Override
	public void stopSpel(Spel spel) {
		if (scanner != null) {
			scanner.close();
		}
	}
	
	// ------------------------------ private methods ------------------------------------ //
	
	/**
	 * Leest commando van input
	 */
	
	private ICommando leesCommando(final Spel spel, final Speler speler, final CommandoType[] mogelijkeCommandos) {
		
		//
		// toon commando's op scherm 
		
		toonCommandos(speler, mogelijkeCommandos);
		
		//
		// lees commando keuze

		CommandoType commandoType = null;
		
		while (commandoType == null) {
			int keuze = getScanner().nextInt();
			
			if (keuze >= 0 && keuze < mogelijkeCommandos.length) {
				commandoType = mogelijkeCommandos[keuze];
			}
			else {
				System.out.println("[" + speler.getNaam() + "] : ONGELDIG COMMAND ! PROBEER OPNIEUW !");
				toonCommandos(speler, mogelijkeCommandos);
			}
		}

		//
		// maak commando aan
		
		return new CommandoFactory().maakCommandoAan(commandoType, spel, speler);
	}
	
	/**
	 * Toont commando's
	 * @param mogelijkeCommandos commandos
	 */
	
	private void toonCommandos(final Speler speler, final CommandoType[] commandos) {
		
		System.out.println("-------------------------------------------");
		
		for (int i=0; i < commandos.length; i++) {
			System.out.println(i + " : " + commandos[i].name());
		}
		
		System.out.println("[" + speler.getNaam() + "] : Geef een commando : ");
		System.out.println("-------------------------------------------");
		
	}
	
	/**
	 * Returns scanner
	 * @return scanner
	 */
	
	private Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	// ------------------------------ public main methods ------------------------------------ //
	
	/**
	 * Main
	 * @param args
	 */
	
	public static void main(final String[] args) {
		Coloretto coloretto = new Coloretto();
		coloretto.startSpel();
	}
}
