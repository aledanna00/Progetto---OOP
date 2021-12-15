package prova.demo.model;

import java.time.Month;
import java.util.ArrayList;

import prova.demo.service.DropboxFile;
import prova.demo.service.GetDataFromDropbox;

public class StatisticsCreationDate {
	 String mesePiuCreazione;
	    int contatoreMax;
	    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
	    ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
	    ArrayList<String> listaMesi = new ArrayList<>();

	    public String StatisticaDataCreazione() {

	        

	        for (DropboxFile i : listaFile) {
	                listaMesi.add(i.getClient_modified().substring(5, 7));
	        }

	        for (int i = 0; i < listaMesi.size(); i++) {
	            String meseDaContare = listaMesi.get(i);

	            int contatore = 0;

	            for (int j = 0; j < listaMesi.size(); j++) {
	                if (listaMesi.get(j).equals(meseDaContare)) {
	                    contatore++;
	                    if (contatore > contatoreMax) {
	                        contatoreMax = contatore;
	                        mesePiuCreazione = listaMesi.get(j);

	                    }
	                }
	            }
	        }

	        return "Il mese in cui sono stati creati il numero maggiore di file è: " + Month.of(Integer.parseInt(mesePiuCreazione)) + " Nel quale sono stati creati " + contatoreMax + " file";
	    }
}
