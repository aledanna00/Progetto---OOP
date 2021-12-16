package prova.demo.exception;

/**
 * @author Alessandra D'Anna 
 * Tale classe esplicita il messaggio di errore in cui si incappa se nel Dropbox non sono presenti file che presentano l'estensione specificata
 */

public class NoExtExc extends Exception{

	public NoExtExc() {
		super("ATTENZIONE: IL PROGRAMMA NON HA ALCUN DATO DA ELEBORARE");
	}
}
