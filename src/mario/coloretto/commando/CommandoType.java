package mario.coloretto.commando;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 19 apr. 2020
 *
 */

public enum CommandoType {

	NEEM_KAART,
	STOP_SPEL;
	
	/** spelbeurt commando's : commando's die de speler kan uitvoeren tijdens een spelbeurt */
	public static final CommandoType[] SPELBEURT_COMMANDOS = new CommandoType[] { NEEM_KAART, STOP_SPEL };
	
}
