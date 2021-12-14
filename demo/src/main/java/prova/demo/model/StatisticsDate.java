package prova.demo.model;

import java.util.ArrayList;

public class StatisticsDate {

	public String StatisticsDataCreation() { 
	
	String MeseMax = null;
	
	GetDataFromDropbox x = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = x.getData();
    ArrayList<String> listaMesi = new ArrayList<>(); //iniziale minuscola
    
    for(DropboxFile i: listaFile) {
    	if(!i.getTag().equals("folder"));
    	listaMesi.add((i.getServer_modified()).substring(5,7));
    	listaMesi.add((i.getClient_modified()).substring(5,7));
    }
    for(int i=0; i<listaMesi.size(); i++) {
    	String Mese1 = listaMesi.get(i);
    	int contatore = 0;
    	int contatoreMax = 0;
    	for(int j=listaMesi.size(); j>0; j--) {
    		String Mese2 = listaMesi.get(j);
    		if(Mese2.equals(Mese1)) {
    			contatore++;
    			
    			if(contatore>contatoreMax )contatoreMax = contatore;
    			
    			MeseMax = listaMesi.get(j);
    		}
    	}
    }
   
   //String MeseUscita = DateFormatSymbols().getMonths()[months-1];
   return MeseMax;
  }	
}