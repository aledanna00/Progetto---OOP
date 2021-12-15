package prova.demo.model;

import java.util.ArrayList;

import prova.demo.exception.NoExtExc;
import prova.demo.service.DropboxFile;
import prova.demo.service.GetDataFromDropbox;

public class Filters {
	 GetDataFromDropbox caricaDati = new GetDataFromDropbox();
     ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
     ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();
     
	 public ArrayList<DropboxFile>  FiltraPerEstensione(String estensione) throws NoExtExc{
	        for(DropboxFile i : listaFile){
	            if((estensione).equals(i.getEstensione())){
	                listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
	            }
	        }
	        if(listaFileFiltrata.isEmpty())throw new NoExtExc();
	        else return listaFileFiltrata;
	    }
	 
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
