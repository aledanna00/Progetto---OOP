package prova.demo.service;

import java.util.ArrayList;
import java.time.Month;
import prova.demo.exception.NoFileExc;
import prova.demo.model.DropboxFile;
import prova.demo.model.GetDataFromDropbox;
/**
 * @author Alessandra D'Anna
 * @author Alessio Cruciani
 * Tale classe implementa un metodo per definire in quale mese si è avuto il maggior numero di file creati
 */

public class StatisticsTimePeriod {
	/**
	 * @param mesePiuCreazione conterrà il mese in cui sono stati creati più file
	 * @param contatoreMax è la variabile che tiene conto del numero di file creati nel mesePiuCreazione
	 */
    String mesePiuCreazione;
    int contatoreMax;
    /**
     * @param caricaDati oggetto di GetDataFromDropbox
     * @param listaFile è l'ArrayList di DropboxFile che contiene tutti i file recuperati dal Dropbox
     */
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
    /**
    * @param listaMesi è il nuovo ArrayList di DropboxFile che verrà riempito con i mesi di creazione dei vari file
    */
    ArrayList<String> listaMesi = new ArrayList<>();

    /**
     * Tale classe scorre l'ArrayList listaFile e riempie listaMesi con i mesi di creazione dei file presenti nel Dropbox.
     * Usa il metodo calcolaStatistiche per trovare il mese in sui sono stati creati più file.
     * @see calcolaStatistiche
     * @return
     * @throws NoFileExc
     */
    public String StatisticaDataCreazione() throws NoFileExc {
        listaMesi.clear();
        for (DropboxFile i : listaFile) {
            listaMesi.add(i.getServer_modified().substring(5, 7));
        }
        calcolaStatistiche();
        return "Il mese in cui sono stati creati il numero maggiore di file è: " + Month.of(Integer.parseInt(mesePiuCreazione)) + " Nel quale sono stati creati " + this.contatoreMax + " file";
    }
    /**
     * Tale classe scorre l'ArrayList listaFile e riempie listaMesi con i mesi di modificazione dei file presenti nel Dropbox.
     * Usa il metodo calcolaStatistiche per trovare il mese in sui sono stati modificati più file.
     * @see calcolaStatistiche
     * @return
     * @throws NoFileExc
     */
    public String StatisticaDataModifica() throws NoFileExc {
        listaMesi.clear();
        for (DropboxFile i : listaFile) {
            listaMesi.add(i.getClient_modified().substring(5, 7));
        }
        calcolaStatistiche();
        return "Il mese in cui sono stati creati il numero maggiore di file è: " + Month.of(Integer.parseInt(mesePiuCreazione)) + " Nel quale sono stati creati " + this.contatoreMax + " file";
    }
    /**
     * @param meseDaContare varaiabile che viene usata per indicare il mese di creazione dei file nel for  
     * Grazie a due cicli di for si scorre due volte l'ArrayList listaMesi.
     * Con il primo for teniamo conto di un particolare mese , con il secondo for lo compariamo ai mesi degli altri oggetti in listaMesi ,
     * se questi combaciano il contatore ottiene un unità in più.
     * Se alla fine del ciclo contatore risulta più grande di contatoreMax quest ultimo ne assume il valore.
     * Si ripete per tutti gli elementi di listaMesi
     * @return una stringa contenente tutte le specifiche del mese in cui è stato inserito il maggior numero di file
     */

    public void calcolaStatistiche() throws NoFileExc{
    	if(listaMesi.isEmpty()) throw new NoFileExc();
    	else {
    		for (int i = 0; i < listaMesi.size(); i++) {
                String meseDaContare = listaMesi.get(i);
                int contatore = 0;
                for (int j = 0; j < listaMesi.size(); j++) {
                    if (listaMesi.get(j).equals(meseDaContare)) {
                        contatore++;
                        if (contatore > contatoreMax) {
                            this.contatoreMax = contatore;
                            mesePiuCreazione = listaMesi.get(j);
                        }
                    }
                }
            }
    	}
        
    }
    
}