package prova.demo.model;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class Filter_Ext_and_Date {

    private String Estensione;
    private String Data;

    public Filter_Ext_and_Date(String Estensione, String Data) {
        this.Estensione = Estensione;
        this.Data = Data;
    }

    public ArrayList FiltraLaLista() {
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> ListaFile = x.getData();
        ArrayList<DropboxFile> ListaFileFiltrata = new ArrayList<>();

        for (DropboxFile i : ListaFile) {
            if ((this.Estensione).equals(i.getEstensione())) {
                if (!(i.getTag().equals("folder"))) {
                    String datalunga = i.getServer_modified();
                    String datacorta = datalunga.substring(0, 10);
                    if ((Data).equals(datacorta)) {
                        ListaFileFiltrata.add(ListaFile.get(ListaFile.indexOf(i)));
                    }
                }
            }
        }

        return ListaFileFiltrata;
    }

    public String getEstensione() {
        return Estensione;
    }

    public void setEstensione(String Estensione) {
        this.Estensione = Estensione;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}
