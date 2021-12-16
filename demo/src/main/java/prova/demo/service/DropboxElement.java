package prova.demo.service;

/**
 * @author Alessio Cruciani
 * @author Alessandra D'Anna
 * @version 1.0
 * Superclasse che modella elementi di Dropbox 
 */
public class DropboxElement {
	/**
	 * tipo di elemento preso dal dropbox (file,folder)
	 */
    private String tag;
    /**
     * indica il nome dell'elemento
     */
    private String name;
    /**
     * indica il percorso del file in formato minuscolo
     */
    private String path_lower;
    /**
     * indica il percorso del file in formato maiuscolo
     */
    private String path_display;
    /**
     * identificatore del file
     */
    private String id;
    
    /**
     * Costruttore della superclasse
     * @param tag
     * @param name
     * @param path_lower
     * @param path_display
     * @param id
     */
    public DropboxElement(String tag, String name, String path_lower, String path_display, String id) {
        this.tag = tag;
        this.name = name;
        this.path_lower = path_lower;
        this.path_display = path_display;
        this.id = id;
    }
    
    /**
     * Getter della variabile tag
     * @return String tag
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * Setter della variabile tag
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Getter della variabile name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter della variabile name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter della variabile path_lower
     * @return String path_lower
     */
    public String getPath_lower() {
        return path_lower;
    }

    /**
     * Setter della variabile path_lower
     * @param path_lower
     */
    public void setPath_lower(String path_lower) {
        this.path_lower = path_lower;
    }

    /**
     * Getter della variabile path_display
     * @return String path_display
     */
    public String getPath_display() {
        return path_display;
    }

    /**
     * Setter della variabile path_display
     * @param path_display
     */
    public void setPath_display(String path_display) {
        this.path_display = path_display;
    }

    /**
     * Getter della variabile id
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter della variabile id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }  
}
