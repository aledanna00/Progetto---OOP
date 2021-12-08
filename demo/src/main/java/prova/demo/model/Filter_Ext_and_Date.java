package prova.demo.model;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class Filter_Ext_and_Date {
    
    private String Estensione;
    
    
    public Filter_Ext_and_Date(String Estensione) {
        this.Estensione = Estensione;
    }
    
    public ArrayList FiltraLaLista(){
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> ListaFile = x.getData();
        ArrayList<DropboxFile> ListaFileFiltrata = new ArrayList<>();
        
        for(DropboxFile i : ListaFile){
            if((this.Estensione).equals(i.getEstensione())){
                ListaFileFiltrata.add(ListaFile.get(ListaFile.indexOf(i)));
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
    
    
    
}
