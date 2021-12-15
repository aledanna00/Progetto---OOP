package prova.demo.service;

import java.util.Date;

public class DropboxFile extends DropboxElement{

    private String estensione;
    private String client_modified;  //OCCHIO CAMBIATO TIPO
    private String server_modified;  //OCCHIO CAMBIATO TIPO
    private String rev;
    private Number size;             //OCCHIO CAMBIATO SEGNO
    private String is_downloadable;  //OCCHIO CAMBIATO TIPO
    private String content_hash;

    public DropboxFile(String tag, String name,String estensione, String path_lower, String path_display, String id, String client_modified, String server_modified, String rev, Number size, String is_downloadable, String content_hash) {
        super(tag, name, path_lower, path_display, id);
        this.estensione = estensione;
        this.client_modified = client_modified;
        this.server_modified = server_modified;
        this.rev = rev;
        this.size = size;
        this.is_downloadable = is_downloadable;
        this.content_hash = content_hash;
    }

    public String getClient_modified() {
        return client_modified;
    }

    public void setClient_modified(String client_modified) {
        this.client_modified = client_modified;
    }

    public String getServer_modified() {
        return server_modified;
    }

    public void setServer_modified(String server_modified) {
        this.server_modified = server_modified;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public Number getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String isIs_downloadable() {
        return is_downloadable;
    }

    public void setIs_downloadable(String is_downloadable) {
        this.is_downloadable = is_downloadable;
    }

    public String getContent_hash() {
        return content_hash;
    }

    public void setContent_hash(String content_hash) {
        this.content_hash = content_hash;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    @Override
    public String toString() {
        return "DropboxFile{" + "estensione=" + estensione + ", client_modified=" + client_modified + ", server_modified=" + server_modified + ", rev=" + rev + ", size=" + size + ", is_downloadable=" + is_downloadable + ", content_hash=" + content_hash + '}';
    }   
}
