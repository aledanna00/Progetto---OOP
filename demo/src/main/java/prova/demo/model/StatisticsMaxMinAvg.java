package prova.demo.model;

import java.util.ArrayList;
import prova.demo.exception.*;

import prova.demo.exception.NoFileExc;

public class StatisticsMaxMinAvg {

    private String estensione;
    GetDataFromDropbox x = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = x.getData();

    public StatisticsMaxMinAvg(String estensione) {
        this.estensione = estensione;
    }

    public int risultatoMinimo() throws NoFileExc{
        int minimo = 0;
      if(listaFile.isEmpty()) throw new NoFileExc();
      else {
        for (DropboxFile i : listaFile) {
            if ((this.estensione).equals(i.getEstensione())) {
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

    public int risultatoMassimo() throws NoFileExc{
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> ListaFile = x.getData();
        int massimo = 0;
        if(ListaFile.isEmpty()) throw new NoFileExc();
        else {
        	 for (DropboxFile i : ListaFile) {
                 if((this.estensione).equals(i.getEstensione())){
                 if ((int) i.getSize() > massimo) {
                     massimo = (int) i.getSize();
                 }
                 }
             }
             return massimo;
        }
    }

    public double risultatoMedia() throws NoFileExc{
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> ListaFile = x.getData();
        int somma = 0;
        int contatore = 0;
        if(ListaFile.isEmpty()) throw new NoFileExc();
        else {
        	
        	 for(DropboxFile i : ListaFile){
                 if((this.estensione).equals(i.getEstensione())){
                     somma += (int) i.getSize();
                     contatore++;
                 }
             }
             return (somma/contatore);
        }
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

}