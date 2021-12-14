package prova.demo.model;

import prova.demo.service.GetDataFromDropbox;
import prova.demo.service.DropboxFile;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aless
 */
public class Filter_Ext_and_Date {

    private String estensione;
    private String data;
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getData();
    ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();

    public Filter_Ext_and_Date(String estensione, String data) {
        this.estensione = estensione;
        this.data = data;
    }

    public ArrayList FiltraLaLista() {

        for (DropboxFile i : listaFile) {
            if ((this.estensione).equals(i.getEstensione())) {
                if (!(i.getTag().equals("folder"))) {
                    if (data.equals(i.getServer_modified().substring(0, 10))) {
                        listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
                    }
                }
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
