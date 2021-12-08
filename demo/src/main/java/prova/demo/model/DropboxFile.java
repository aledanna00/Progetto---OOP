package prova.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class DropboxFile {

    public String tag;
    public String name;
    public String path_lower;
    public String path_display;
    public String id;
    public String client_modified;  //OCCHIO CAMBIATO TIPO
    public String server_modified;  //OCCHIO CAMBIATO TIPO
    public String rev;
    public Number size;             //OCCHIO CAMBIATO SEGNO
    public String is_downloadable;  //OCCHIO CAMBIATO TIPO
    public String content_hash;

    public DropboxFile(String tag, String name, String path_lower, String path_display, String id, String client_modified, String server_modified, String rev, Number size, String is_downloadable, String content_hash) {
        this.tag = tag;
        this.name = name;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{tag=").append(tag);
        sb.append(", name=").append(name);
        sb.append(", path_lower=").append(path_lower);
        sb.append(", path_display=").append(path_display);
        sb.append(", id=").append(id);
        sb.append(", client_modified=").append(client_modified);
        sb.append(", server_modified=").append(server_modified);
        sb.append(", rev=").append(rev);
        sb.append(", size=").append(size);
        sb.append(", is_downloadable=").append(is_downloadable);
        sb.append(", content_hash=").append(content_hash);
        sb.append('}');
        return sb.toString();
    }

    

    
    

}
