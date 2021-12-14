package prova.demo.model;

import java.util.Date;

public class DropboxFile {

    private String tag;
    private String name;
    private String estensione;
    private String path_lower;
    private String path_display;
    private String id;
    private String client_modified;  
    private String server_modified; 
    private String rev;
    private Number size;             
    private String is_downloadable;  
    private String content_hash;

    public DropboxFile(String tag, String name,String estensione, String path_lower, String path_display, String id, String client_modified, String server_modified, String rev, Number size, String is_downloadable, String content_hash) {
        this.tag = tag;
        this.name = name;
        this.estensione = estensione;
        this.path_lower = path_lower;
        this.path_display = path_display;
        this.id = id;
        this.client_modified = client_modified;
        this.server_modified = server_modified;
        this.rev = rev;
        this.size = size;
        this.is_downloadable = is_downloadable;
        this.content_hash = content_hash;
    } 
    
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath_lower() {
        return path_lower;
    }

    public void setPath_lower(String path_lower) {
        this.path_lower = path_lower;
    }

    public String getPath_display() {
        return path_display;
    }

    public void setPath_display(String path_display) {
        this.path_display = path_display;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "{" + "tag=" + tag + ", name=" + name + ", estensione=" + estensione + ", path_lower=" + path_lower + ", path_display=" + path_display + ", id=" + id + ", client_modified=" + client_modified + ", server_modified=" + server_modified + ", rev=" + rev + ", size=" + size + ", is_downloadable=" + is_downloadable + ", content_hash=" + content_hash + '}';
    }
 
}