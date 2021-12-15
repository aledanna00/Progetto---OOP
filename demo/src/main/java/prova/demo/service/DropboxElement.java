package prova.demo.service;

/**
 *
 * @author aless
 */
public class DropboxElement {
    private String tag;
    private String name;
    private String path_lower;
    private String path_display;
    private String id;

    public DropboxElement(String tag, String name, String path_lower, String path_display, String id) {
        this.tag = tag;
        this.name = name;
        this.path_lower = path_lower;
        this.path_display = path_display;
        this.id = id;
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
}