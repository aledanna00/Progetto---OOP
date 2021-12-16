package prova.demo.exception;
/**
 * @author Alesandra D'Anna
 * Tale classe esplicita il messaggio di errore in cui si incappa se l'ArrayList di DropboxFile (che contiene gli elementi del DropBox) è vuoto
 */
public class NoFileExc extends Exception{
	
	public  NoFileExc(){
		super("ERRORE: nessun file presente ");
	}
}

