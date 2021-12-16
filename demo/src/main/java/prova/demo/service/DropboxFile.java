package prova.demo.service;

import java.util.Date;

/**
 * Sottoclasse che modella tutti gli elementi di tipo DropboxFile
 *
 *
 * @author Alessio Cruciani
 * @author Alessandra D'Anna
 * @version 1.0
 */
public class DropboxFile extends DropboxElement {

    /**
     * Indica l'estensione del file contenuto nel dropbox
     */
    private String estensione;
    /**
     * Indica la data in cui, l'utente ha modificato il file
     */
    private String client_modified;
    /**
     * Indica la data in cui è stato creato il file
     */
    private String server_modified;
    /**
     * Indica un identificatore univoco per la revisione corrente di un file può
     * essere utile per rilevare le modifiche e i conflitti, esso è generato
     * automaticamente da Dropbox
     */
    private String rev;
    /**
     * Indica la dimensione del file ed è espressa in Kb
     */
    private Number size;
    /**
     * Indica se il file è scaricabile dal dropbox oppure no
     */
    private String is_downloadable;
    /**
     * Indica un codice alfanumerico che può essere utilizzato per verificare
     * l'integrità di un file, esso è generato automaticamente da Dropbox
     */
    private String content_hash;

    /**
     * Costruttore
     *
     * @param tag
     * @param name
     * @param path_lower
     * @param path_display
     * @param id
     * @see DropboxElement
     *
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @param client_modified Indica la data in cui, l'utente ha modificato il
     * file
     *
     * @param server_modified Indica la data in cui è stato creato il file
     * @param rev Indica un identificatore univoco per la revisione corrente di
     * un file può essere utile per rilevare le modifiche e i conflitti, esso è
     * generato automaticamente da Dropbox
     *
     * @param size Indica la dimensione del file ed è espressa in Kb
     * @param is_downloadable Indica se il file è scaricabile dal dropbox oppure
     * no
     *
     * @param content_hash Indica un codice alfanumerico che può essere
     * utilizzato per verificare l'integrità di un file, esso è generato
     * automaticamente da Dropbox
     */
    public DropboxFile(String tag, String name, String estensione, String path_lower, String path_display, String id, String client_modified, String server_modified, String rev, Number size, String is_downloadable, String content_hash) {
        super(tag, name, path_lower, path_display, id);
        this.estensione = estensione;
        this.client_modified = client_modified;
        this.server_modified = server_modified;
        this.rev = rev;
        this.size = size;
        this.is_downloadable = is_downloadable;
        this.content_hash = content_hash;
    }

    /**
     * Metodo Getter di client_modified
     * @return una data in formato String che indica la modifica più recente
     */
    public String getClient_modified() {
        return client_modified;
    }

    /**
     * Metodo Setter di client_modified
     * @param client_modified Indica la data in cui, l'utente ha modificato il file
     */
    public void setClient_modified(String client_modified) {
        this.client_modified = client_modified;
    }
    
    /**
     * Metodo Getter di server_modified
     * @return una data in formato String che indica la creazione.
     */
    public String getServer_modified() {
        return server_modified;
    }

    /**
     * Metodo Setter di server_modified
     * @param server_modified Indica la data in cui è stato creato il file
     */
    public void setServer_modified(String server_modified) {
        this.server_modified = server_modified;
    }

    /**
     * Metodo Getter di Rev
     * @return un codice univoco utile per la revisione corrente di un file
     */
    public String getRev() {
        return rev;
    }

    /**
     * Metodo Setter di Rev
     * @param rev Indica un codice univoco per la revisione corrente di un file
     */
    public void setRev(String rev) {
        this.rev = rev;
    }

    /**
     * Metodo Getter di size
     * @return un numero che corrisponde alla dimensione del file con unità Kb
     */
    public Number getSize() {
        return size;
    }

    /**
     * Metodo Setter di size
     * @param size Indica la dimensione del file ed è espressa in Kb
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Metodo Getter di is_downloadable
     * @return dice se è scaricabile oppure no
     */
    public String getIs_downloadable() {
        return is_downloadable;
    }

    /**
     * Metodo Setter di is_downloadable
     * @param is_downloadable Indica se il file è scaricabile dal dropbox oppure no
     */
    public void setIs_downloadable(String is_downloadable) {
        this.is_downloadable = is_downloadable;
    }

    /**
     * Metodo Getter di content_hash
     * @return un codice alfanumerico utile a verificare l'integrità dei file
     */
    public String getContent_hash() {
        return content_hash;
    }

    /**
     * Metodo Setter di content_hash
     * @param content_hash Indica un codice alfanumerico che può essere utilizzato per verificare l'integrità di un file
     */
    public void setContent_hash(String content_hash) {
        this.content_hash = content_hash;
    }

    /**
     * Metodo Getter di estensione
     * @return una stringa che indica il tipo di file che abbiamo davanti (es .docx)
     */
    public String getEstensione() {
        return estensione;
    }

    /**
     * Metodo Setter di estensione
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     */
    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    /**
     * Metodo toString classe DropboxFile
     * @return rappresentazione testuale oggetto di tipo DropboxFile
     */
    @Override
    public String toString() {
        return "DropboxFile{" + "estensione=" + estensione + ", client_modified=" + client_modified + ", server_modified=" + server_modified + ", rev=" + rev + ", size=" + size + ", is_downloadable=" + is_downloadable + ", content_hash=" + content_hash + '}';
    }
}
