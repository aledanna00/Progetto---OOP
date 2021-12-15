package prova.demo.model;

import prova.demo.service.GetDataFromDropbox;
import prova.demo.service.DropboxFile;
import java.util.ArrayList;

public class StatisticsMaxMinAvg {
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();

    public int risultatoMinimo(String estensione) {
        int minimo = 0;
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

    public int risultatoMassimo(String estensione) {
        int massimo = 0;
        for (DropboxFile i : listaFile) {
            if(estensione.equals(i.getEstensione())){
            if ((int) i.getSize() > massimo) {
                massimo = (int) i.getSize();
            }
            }
        }
        return massimo;
    }

    public double risultatoMedia(String estensione) {
        int somma = 0;
        int contatore = 0;
        for(DropboxFile i : listaFile){
            if(estensione.equals(i.getEstensione())){
                somma += (int) i.getSize();
                contatore++;
            }
        }
        return (somma/contatore);
    }
}
