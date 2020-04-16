package mario.coloretto.model;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public enum KaartType {

	/* kleurenkaarten */
	
	KLEUR_ORANJE,
	KLEUR_BLAUW,
	KLEUR_DONKER_BRUIN,
	KLEUR_GEEL,
	KLEUR_GRIJS,
	KLEUR_GROEN,
	KLEUR_ROZE,
	
	/* andere kaarten */
	
	PLUS_2_KAART,
	JOKER,
	LAATSTE_RONDE,
	SUMMARY_KAART;
	
	/** kleurkaarten */
	public static KaartType[] KLEUR_KAARTEN = new KaartType[] { KLEUR_ORANJE, KLEUR_BLAUW, KLEUR_DONKER_BRUIN, KLEUR_GEEL, KLEUR_GRIJS, KLEUR_GROEN, KLEUR_ROZE };
	
}
