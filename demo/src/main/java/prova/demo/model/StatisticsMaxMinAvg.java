package prova.demo.model;

import java.util.ArrayList;
import prova.demo.exception.*;

import prova.demo.exception.NoFileExc;
import prova.demo.service.DropboxFile;
import prova.demo.service.GetDataFromDropbox;

public class StatisticsMaxMinAvg {    
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();

    public int risultatoMinimo(String estensione) throws NoFileExc{
        int minimo = 0;
      if(listaFile.isEmpty()) throw new NoFileExc();
      else {
        for (DropboxFile i : listaFile) {
            if ((estensione).equals(i.getEstensione())) {
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

    public int risultatoMassimo(String estensione) throws NoFileExc{
        int massimo = 0;
        if(listaFile.isEmpty()) throw new NoFileExc();
        else {
        	 for (DropboxFile i : listaFile) {
                 if((estensione).equals(i.getEstensione())){
                 if ((int) i.getSize() > massimo) {
                     massimo = (int) i.getSize();
                 }
                 }
             }
             return massimo;
        }
    }

    public double risultatoMedia(String estensione) throws NoFileExc{
        int somma = 0;
        int contatore = 0;
        if(listaFile.isEmpty()) throw new NoFileExc();
        else {
        	
        	 for(DropboxFile i : listaFile){
                 if((estensione).equals(i.getEstensione())){
                     somma += (int) i.getSize();
                     contatore++;
                 }
             }
             return (somma/contatore);
        }
    }
}