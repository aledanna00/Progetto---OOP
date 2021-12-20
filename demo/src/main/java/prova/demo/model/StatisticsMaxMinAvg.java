package prova.demo.model;

import prova.demo.service.GetDataFromDropbox;
import prova.demo.service.DropboxFile;
import java.util.ArrayList;
import prova.demo.exception.NoFileExc;

/**
 * Classe che si occupa delle statistiche di Massimo, Minimo e Media
 * 
 * @author Alessio Cruciani
 * @author Alessandra D'Anna
 * @version 1.0
 */
public class StatisticsMaxMinAvg {
    /**
     * Creazione di un oggetto di GetDataFromDropbox
     * @see GetDataFromDropbox
     */
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    /**
     * Arraylist che contiene oggetti di tipo DropboxFile
     */
    ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();

    /**
     * Metodo che cerca la dimensione minima di un tipo di file specificato
     * 
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @return Indica la dimensione Minima dei file, cercati per tipo di file
     */
    public int risultatoMinimo(String estensione) throws NoFileExc{
        int minimo = 0;
        if(listaFile.isEmpty()) throw new NoFileExc();
        else {
        	for (DropboxFile i : listaFile) {
                if (estensione.equals(i.getEstensione())) {
                    while (minimo == 0) {
                        minimo = (int) i.getSize();
                    }
                    if ((int) i.getSize() < minimo) {
                        minimo = (int) i.getSize();
                    }
                }
            }
            return minimo;
        }
    }
    /**
     * Metodo che cerca la dimensione massima di un tipo di file specificato
     * 
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @return Indica la dimensione Massima dei file, cercati per tipo di file
     */
    public int risultatoMassimo(String estensione) throws NoFileExc{
        int massimo = 0;
        if(listaFile.isEmpty()) throw new NoFileExc();
        else {
        	 for (DropboxFile i : listaFile) {
                 if(estensione.equals(i.getEstensione())){
                 if ((int) i.getSize() > massimo) {
                     massimo = (int) i.getSize();
                 }
                 }
             }
             return massimo;
        }
   }
    /**
     * Metodo che cerca la dimensione media di un tipo di file specificato
     * 
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @return Indica la dimensione Media dei file, cercati per tipo di file
     */
    public double risultatoMedia(String estensione) throws NoFileExc{
        int somma = 0;
        int contatore = 0;
        if(listaFile.isEmpty()) throw new NoFileExc();
        else {
            for(DropboxFile i : listaFile){
                if(estensione.equals(i.getEstensione())){
                    somma += (int) i.getSize();
                    contatore++;
                }
            }
            return (somma/contatore);
        }
  }
  
}
