package prova.demo.model;

import prova.demo.service.GetDataFromDropbox;
import prova.demo.service.DropboxFile;
import java.util.ArrayList;
import net.minidev.json.JSONArray;

/**
 *
 * @author aless
 */
public class Filter_Ext {

    private String estensione;
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getData();
    ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();

    public Filter_Ext(String estensione) {
        this.estensione = estensione;
    }

    public ArrayList FiltraLaLista() {

        for (DropboxFile i : listaFile) {
            if ((this.estensione).equals(i.getEstensione())) {
                listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
            }
        }

        return listaFileFiltrata;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

}
