package prova.demo.model;

import prova.demo.service.GetDataFromDropbox;
import prova.demo.service.DropboxFile;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aless
 */
public class Filter_Date {

    private String data;
    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getData();
    ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();

    public Filter_Date(String data) {
        this.data = data;
    }

    public ArrayList FiltraLaLista() {

        for (DropboxFile i : listaFile) {

            if (!(i.getTag().equals("folder"))) {

                if (data.equals(i.getServer_modified().substring(0, 10))) {
                    listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
                }
            }
        }

        return listaFileFiltrata;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
