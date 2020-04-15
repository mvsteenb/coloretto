package manos.domein;

import java.util.*;

public class Spel {

	public Spel() {

	}

	private ArrayList<String> spelerLijst = new ArrayList<String>();
	private ArrayList<String> kleur = new ArrayList<String>();

	public void startSpel() {
		Scanner invoer = new Scanner(System.in);
		System.out.println("wilt u het spel starten? 0 voor nee, 1 voor ja");
		int keuze = invoer.nextInt();
		if (keuze == 0) {
			System.out.println("het spel wordt afgesloten");
			System.exit(0);
		}
		System.out.println("we beginnen een nieuw spel");
	}

	public void vulKleurArray() {

		kleur.add("Rood");
		kleur.add("Blauw");
		kleur.add("Geel");
		kleur.add("Groen");
		kleur.add("Paars");
		kleur.add("Bruin");
		kleur.add("Oranje");
	}

	public void vulSpelerArray() {

		spelerLijst.add("Speler 1");
		spelerLijst.add("Speler 2");
		spelerLijst.add("Speler 3");
		spelerLijst.add("Speler 4");
		spelerLijst.add("Speler 5");
	}

	public void kiesKleur() {
		for (int j = 0; j < kleur.size(); j++) {
			int rando = (int) ((Math.random() * kleur.size()));
			String text = kleur.get(rando);
			System.out.printf("Speler %d krijgt ", j);
			System.out.println(text);
			kleur.remove(rando);
		} // einde for loop
	} // einde kieskleur
} // ende klasse
