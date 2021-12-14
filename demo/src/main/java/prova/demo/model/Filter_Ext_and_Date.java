package prova.demo.model;

import java.util.ArrayList;
import prova.demo.exception.*;

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

    public ArrayList FiltraLaLista() throws NoFileExc{
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> listaFile = x.getData();
        ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();

        for (DropboxFile i : listaFile) {
            if ((this.Estensione).equals(i.getEstensione())) {
                if (!(i.getTag().equals("folder"))) {
                    String datalunga = i.getServer_modified();
                    String datacorta = datalunga.substring(0, 10);
                    if ((Data).equals(datacorta)) {
                        listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
                    }
                }
            }
        }
        if(listaFileFiltrata.isEmpty()) throw new NoFileExc();
        else    return listaFileFiltrata;
      
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