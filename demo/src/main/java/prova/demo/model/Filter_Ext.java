package prova.demo.model;

import java.util.ArrayList;
import prova.demo.exception.*;

/**
 *
 * @author aless
 */
public class Filter_Ext {
    
    private String Estensione;
    
    
    public Filter_Ext(String Estensione) throws NoFileExc{
        this.Estensione = Estensione;
    }
    
    public ArrayList FiltraLaLista() throws NoFileExc{
        GetDataFromDropbox x = new GetDataFromDropbox();
        ArrayList<DropboxFile> listaFile = x.getData();
        ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();
        
        for(DropboxFile i : listaFile){
            if((this.Estensione).equals(i.getEstensione())){
                listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
            }
        }
        if(listaFileFiltrata.isEmpty())throw new NoFileExc();
        else  return listaFileFiltrata;
       
    }

    public String getEstensione() {
        return Estensione;
    }

    public void setEstensione(String Estensione) {
        this.Estensione = Estensione;
    }
    
    
    
}