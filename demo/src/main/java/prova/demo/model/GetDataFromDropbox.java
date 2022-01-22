package prova.demo.model;

import ch.qos.logback.classic.pattern.DateConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.minidev.asm.ConvertDate;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import prova.demo.model.DropboxFile;

/**
 * La classe ha come scopo principale quello di estrarre i file dal Dropbox di cui si è passato il token ed inserirli 
 * in un ArrayList diverso in base al loro tipo (file o folder)
 * @author Alessandra D'Anna
 * @author Alessio Cruciani
 */
public class GetDataFromDropbox {

	/**
	 * @param listaFile è l'ArrayList di DropboxFile che contiene tutti i file recuperati dal Dropbox
	 */
    ArrayList<DropboxFile> listaFile = new ArrayList<>();
    /**
     * @param listaCartelle è l'ArrayList di DropboxFolder che contiene tutti i folder recuperati dal Dropbox
     */
    ArrayList<DropboxFolder> listaCartelle = new ArrayList<>();

    /**
     * getData è il metodo che implementa l'obiettivo della classe GetDataFromDropbox
     */
    public void getData() {

        String url = "https://api.dropboxapi.com/2/files/list_folder";
        try {
        	/**
        	 * APRE LA CONNESSIONE CON L'URL DI DROPBOX SELEZIONATO
        	 */
            HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
            /**
             * DICHIARA CHE IL METODO è DI TIPO POST
             */
            openConnection.setRequestMethod("POST");
            /**
             * RICHIEDE L'AUTORIZZAZIONE PER ACCEDERE AL DROPBOX SELEZIONATO UTILIZZANDO IL TOKEN
             */
            openConnection.setRequestProperty("Authorization",
                    "Bearer 5VhgPSGk2XQAAAAAAAAAAU2LllQS4JNu0K9SxPejt0q9eizV-iYgSXZET4bbvVjh");
            /**
             * CI DICE CHE IL FILE DI OUTPUT è UN FILE DI TIPO JSON
             */
            openConnection.setRequestProperty("Content-Type", "application/json");
            
            openConnection.setRequestProperty("Accept", "application/json");
            
            openConnection.setDoOutput(true);
            /**
             * AGGIUNGE IL BODY COME STRINGA
             */
            String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
                    + "    \"include_media_info\": false,\r\n" + "    \"include_deleted\": false,\r\n"
                    + "    \"include_has_explicit_shared_members\": false,\r\n"
                    + "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
                    + "}";
            /**
             * TRASFORMA LA STRING IN BYTE
             */
            try ( OutputStream os = openConnection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            InputStream in = openConnection.getInputStream();

            String data = "";
            String line = "";
            try {
                InputStreamReader inR = new InputStreamReader(in);
                BufferedReader buf = new BufferedReader(inR);

                while ((line = buf.readLine()) != null) {
                    data += line;
                }
            } finally {
                in.close();
            }

            /**
             * TRASFORMA data IN UN JSONOBJECT
             */
            JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
            /**
             * RIEMPIE IL JSONARRAY array2 CON JSONOBJECT
             */
            JSONArray array2 = (JSONArray) obj.get("entries");

            /**
             * TALE CICLO DI FOR SEREV PER TRASFORMARE I JSONOBJECT IN DROPBOX FILE O FOLDER 
             */
            for (int i = 0; i < array2.size(); i++) {

                JSONObject obj2 = (JSONObject) array2.get(i);

                /**
                 * ASSEGNAZIONI DELLE VARIABILI IN BASE ALLE CHIAVI PRESENTI NEL FILE JSON
                 * @see DropBoxElement
                 */
                String tag = (String) obj2.get(".tag");
                String name = (String) obj2.get("name");
                String path_lower = obj2.getAsString("path_lower");
                String path_display = obj2.getAsString("path_display");
                String id = obj2.getAsString("id");

                /**
                 * SE IL TAG DELL'ELEMENTO NON E' FOLDER SARA' FILE E PRESENTERA' ALTRE VARIABILI CHE NECESSITERANNO DI ESSERE ASSEGNATE 
                 */
                if (!tag.equals("folder")) {

                	/**
                	 * @see DropBoxFile
                	 */
                    String client_modified = obj2.getAsString("client_modified");
                    String server_modified = obj2.getAsString("server_modified");
                    String rev = obj2.getAsString("rev");
                    Number size = obj2.getAsNumber("size");
                    String is_downloadable = obj2.getAsString("is_downloadable");
                    String content_hash = obj2.getAsString("content_hash");
                    String estensione = name.substring(name.indexOf(".", 0));
                    /**
                     * CREAZIONE DI UN NUOVO DROPBOXFILE CON LE VARIABILI RECUPERATE DAL FILE JSON.
                     * QUESTO VIENE AGGIUNTO ALL'ARRAYLIST listaFile
                     */
                    DropboxFile dropboxFile = new DropboxFile(tag, name, estensione, path_lower, path_display, id, client_modified, server_modified, rev, size, is_downloadable, content_hash);
                    listaFile.add(dropboxFile);
                } else {
                	/**
                     * CREAZIONE DI UN NUOVO DROPBOXFOLDER CON LE VARIABILI RECUPERATE DAL FILE JSON.
                     * QUESTO VIENE AGGIUNTO ALL'ARRAYLIST listaCartelle
                     */
                    DropboxFolder dropboxFolder = new DropboxFolder(tag, name, path_lower, path_display, id);
                    listaCartelle.add(dropboxFolder);
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    /**
     * GETTER DELL'ARRAYLIST listaFile CONTENENTE I DROPBOXFILE TROVATI NEL DROPBOX 
     * @return listaFile
     */
    public ArrayList<DropboxFile> getListaFile(){
        getData();
        return listaFile;
    }
    /**
     * GETTER DELL'ARRAYLIST listaCartelle CONTENENTE I DROPBOXFOLDER TROVATI NEL DROPBOX 
     * @return listaCartelle
     */
    public ArrayList<DropboxFolder> getListaCartelle(){
        getData();
        return listaCartelle;
    }

}
