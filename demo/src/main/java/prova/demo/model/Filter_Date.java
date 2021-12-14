package prova.demo.model;

import java.util.ArrayList;


/**
 *
 * @author aless
 */
public class Filter_Date {

    private String Data;
    GetDataFromDropbox x = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = x.getData();
    ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();


    public Filter_Date(String Data) {
        this.Data = Data;
    }

    public ArrayList FiltraLaLista(){
        for (DropboxFile i : listaFile) {

            if (!(i.getTag().equals("folder"))) {
                String datalunga = i.getServer_modified();
                String datacorta = datalunga.substring(0, 10);
                if ((Data).equals(datacorta)) {
                	int n = listaFile.indexOf(i);
                    listaFileFiltrata.add(listaFile.get(n));
                }
            }
        }
        	 return listaFileFiltrata;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}