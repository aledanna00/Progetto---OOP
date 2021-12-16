package prova.demo.model;

import java.util.ArrayList;

import prova.demo.exception.NoExtExc;
import prova.demo.service.DropboxFile;
import prova.demo.service.GetDataFromDropbox;
/**
 * Classe che gestisce il filtraggio dei file del Dropbox secondo specifici canoni
 * @author Alessandra D'Anna
 * @author Alessio Cruciani
 */
public class Filters {
	/**
	 * @param caricaDati oggetto di GetDataFromDropbox
	 * @param listaFile è l'ArrayList di DropboxFile che contiene tutti i file recuperati dal Dropbox
	 */
	 GetDataFromDropbox caricaDati = new GetDataFromDropbox();
     ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
     /**
      * @param listaFileFiltrata è il nuovo ArrayList di DropboxFile che verrà riempito con gli elementi che vengono filtrati 
      */
     ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();
     
     /**
      * @param estensione
      * @return listaFileFiltrata contiene i file che hanno l'estensione desiderata
      * @throws NoExtExc
      */
	 public ArrayList<DropboxFile>  FiltraPerEstensione(String estensione) throws NoExtExc{
	        for(DropboxFile i : listaFile){
	            if((estensione).equals(i.getEstensione())){
	                listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
	            }
	        }
	        if(listaFileFiltrata.isEmpty())throw new NoExtExc();
	        else return listaFileFiltrata;
	    }
	 /**
	  * @param data
	  * @return listaFileFiltrata contiene i file che sono stati creati o modificati in una specifica data 
	  * @throws NoExtExc
	  */
	 public ArrayList<DropboxFile>  FiltraPerData(String data) throws NoExtExc{
	        for (DropboxFile i : listaFile) {
	                if ((data).equals(i.getServer_modified().substring(0, 10))) {
	                	int n = listaFile.indexOf(i);
	                    listaFileFiltrata.add(listaFile.get(n));
	                }
	            }
	             if(listaFileFiltrata.isEmpty()) throw new NoExtExc();
	        	 return listaFileFiltrata;
	    }
	 /**
	  * @param estensione
	  * @param data
	  * @return listaFileFiltrata contiene i file che sono stati creati o modificati in una specifica data e hanno l'estensione desiderata 
	  * @throws NoExtExc
	  */
	 public ArrayList<DropboxFile> FiltraPerDataEstensione(String estensione, String data) throws NoExtExc {
	        listaFileFiltrata = FiltraPerData(data);
	        for(int i = 0; i < listaFileFiltrata.size(); i++){
	            if(!estensione.equals(listaFileFiltrata.get(i).getEstensione())){
	                listaFileFiltrata.remove(i);
	                --i;
	            }
	        }
	        if(listaFileFiltrata.isEmpty()) throw new NoExtExc();
	        return listaFileFiltrata;
	    }
}
