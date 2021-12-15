package prova.demo.model;

import java.util.ArrayList;
import prova.demo.service.DropboxFile;
import prova.demo.service.GetDataFromDropbox;

public class Filters {

    GetDataFromDropbox caricaDati = new GetDataFromDropbox();
    ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
    ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();

    public ArrayList<DropboxFile> FiltraPerEstensione(String estensione) {
        listaFileFiltrata.clear();
        for (DropboxFile i : listaFile) {
            if (estensione.equals(i.getEstensione())) {
                listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
            }
        }
        return listaFileFiltrata;
    }

    public ArrayList<DropboxFile> FiltraPerData(String data) {
        listaFileFiltrata.clear();
        for (DropboxFile i : listaFile) {
            if (data.equals(i.getServer_modified().substring(0, 10))) {
                listaFileFiltrata.add(listaFile.get(listaFile.indexOf(i)));
            }
        }
        return listaFileFiltrata;
    }

    public ArrayList<DropboxFile> FiltraPerDataEstensione(String estensione, String data) {
        listaFileFiltrata = FiltraPerData(data);
        for(int i = 0; i < listaFileFiltrata.size(); i++){
            if(!estensione.equals(listaFileFiltrata.get(i).getEstensione())){
                listaFileFiltrata.remove(i);
                --i;
            }
        }
        return listaFileFiltrata;
    }

}
