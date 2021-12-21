package prova.demo.model;

/**
 * Sottoclasse di DropboxElement che modella gli elementi di tipo folder
 * @author Alessandra D'Anna
 * @author Alessio Cruciani
 * 
 * @param tag
 * @param name
 * @param path_lower
 * @param path_display
 * @param id
 * @see DropboxElement
 */

public class DropboxFolder extends DropboxElement{

    public DropboxFolder(String tag, String name, String path_lower, String path_display, String id) {
        super(tag, name, path_lower, path_display, id);
    } 
}
