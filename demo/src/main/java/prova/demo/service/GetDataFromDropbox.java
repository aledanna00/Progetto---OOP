package prova.demo.service;

import prova.demo.service.DropboxFile;
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

/**
 *
 * @author aless
 */
public class GetDataFromDropbox {

    ArrayList<DropboxFile> listaFile = new ArrayList<>();
    ArrayList<DropboxFolder> listaCartelle = new ArrayList<>();

    public void getData() {

        String url = "https://api.dropboxapi.com/2/files/list_folder";
        try {
            //APRE LA CONNESSIONE CON L'URL DI DROPBOX SELEZIONATO
            HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
            //DICHIARA CHE IL METODO è DI TIPO POST
            openConnection.setRequestMethod("POST");
            //RICHIEDE L'AUTORIZZAZIONE PER ACCEDERE AL DROPBOX SELEZIONATO UTILIZZANDO IL TOKEN
            openConnection.setRequestProperty("Authorization",
                    "Bearer 5VhgPSGk2XQAAAAAAAAAAU2LllQS4JNu0K9SxPejt0q9eizV-iYgSXZET4bbvVjh");
            //CI DICE CHE IL FILE DI OUTPUT è UN FILE DI TIPO JSON
            openConnection.setRequestProperty("Content-Type", "application/json");
            //NON LO SO 
            openConnection.setRequestProperty("Accept", "application/json");
            //NON LO SO 
            openConnection.setDoOutput(true);

            //AGGIUNGE IL BODY COME STRINGA
            String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
                    + "    \"include_media_info\": false,\r\n" + "    \"include_deleted\": false,\r\n"
                    + "    \"include_has_explicit_shared_members\": false,\r\n"
                    + "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
                    + "}";

            //TRASFORMA LA STRING IN BYTE
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

            JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
            JSONArray array2 = (JSONArray) obj.get("entries");

            for (int i = 0; i < array2.size(); i++) {

                JSONObject obj2 = (JSONObject) array2.get(i);

                String tag = (String) obj2.get(".tag");
                String name = (String) obj2.get("name");
                String path_lower = obj2.getAsString("path_lower");
                String path_display = obj2.getAsString("path_display");
                String id = obj2.getAsString("id");

                if (!tag.equals("folder")) {

                    String client_modified = obj2.getAsString("client_modified");
                    String server_modified = obj2.getAsString("server_modified");
                    String rev = obj2.getAsString("rev");
                    Number size = obj2.getAsNumber("size");
                    String is_downloadable = obj2.getAsString("is_downloadable");
                    String content_hash = obj2.getAsString("content_hash");
                    String estensione = name.substring(name.indexOf(".", 0));

                    DropboxFile dropboxFile = new DropboxFile(tag, name, estensione, path_lower, path_display, id, client_modified, server_modified, rev, size, is_downloadable, content_hash);
                    listaFile.add(dropboxFile);
                } else {
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
    
    public ArrayList<DropboxFile> getListaFile(){
        getData();
        return listaFile;
    }
    
    public ArrayList<DropboxFolder> getListaCartelle(){
        getData();
        return listaCartelle;
    }

}
