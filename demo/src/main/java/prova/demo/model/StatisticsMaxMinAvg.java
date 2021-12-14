package prova.demo.model;

import prova.demo.service.GetDataFromDropbox;
import prova.demo.service.DropboxFile;
import java.util.ArrayList;

public class StatisticsMaxMinAvg {

    String estensione;
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getData();
    
    public StatisticsMaxMinAvg(String estensione) {
        this.estensione = estensione;
    }

    public int risultatoMinimo() {
        int minimo = 0;
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

    public int risultatoMassimo() {
        int massimo = 0;
        for (DropboxFile i : listaFile) {
            if((this.estensione).equals(i.getEstensione())){
            if ((int) i.getSize() > massimo) {
                massimo = (int) i.getSize();
            }
            }
        }
        return massimo;
    }

    public double risultatoMedia() {
        int somma = 0;
        int contatore = 0;
        for(DropboxFile i : listaFile){
            if((this.estensione).equals(i.getEstensione())){
                somma += (int) i.getSize();
                contatore++;
            }
        }
        
        
        return (somma/contatore);
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

}
