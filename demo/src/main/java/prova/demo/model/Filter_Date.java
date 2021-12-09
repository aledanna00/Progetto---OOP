package prova.demo.model;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class Filter_Date {

    private String Data;

    public Filter_Date(String Data) {
        this.Data = Data;
    }

    public ArrayList FiltraLaLista() {
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> ListaFile = x.getData();
        ArrayList<DropboxFile> ListaFileFiltrata = new ArrayList<>();

        for (DropboxFile i : ListaFile) {

            if (!(i.getTag().equals("folder"))) {
                String datalunga = i.getServer_modified();
                String datacorta = datalunga.substring(0, 10);
                if ((Data).equals(datacorta)) {
                    ListaFileFiltrata.add(ListaFile.get(ListaFile.indexOf(i)));
                }
            }
        }

        return ListaFileFiltrata;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}
