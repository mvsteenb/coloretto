package mario.coloretto.model;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 15 apr. 2020
 *
 */

public enum KaartType {

	/* kleurenkaarten */
	
	ORANJE,
	BLAUW,
	DONKER_BRUIN,
	GEEL,
	GRIJS,
	GROEN,
	ROZE,
	
	/* andere kaarten */
	
	PLUS_2,
	JOKER,
	LAATSTE_RONDE,
	SUMMARY;
	
	/** kleurkaarten */
	public static KaartType[] KLEUR_KAARTEN = new KaartType[] { ORANJE, BLAUW, DONKER_BRUIN, GEEL, GRIJS, GROEN, ROZE };
	
}
