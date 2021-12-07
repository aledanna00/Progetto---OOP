package prova.demo;

import prova.demo.model.DropboxFile;
import com.google.gson.Gson;

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
import javax.swing.text.html.HTMLDocument;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import prova.demo.controller.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
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
                    //System.out.println(line);
                }

                //System.out.println(data);
            } finally {
                in.close();
            }
            JSONObject obj = (JSONObject) JSONValue.parseWithException(data);

            ArrayList<DropboxFile> ListaFile = new ArrayList<>();

            ArrayList<String> keys = new ArrayList<>();

            Iterator iter = obj.keySet().iterator();

            while (iter.hasNext()) {
                String chiave = (String) iter.next();
                keys.add(chiave);
                //System.out.println(obj.get(chiave));
            }
            System.out.println();
            System.out.println();

            JSONArray array2 = (JSONArray) obj.get("entries");

            ArrayList<String> keys2 = new ArrayList<>();

            for (int i = 0; i < array2.size(); i++) {

                JSONObject obj2 = (JSONObject) array2.get(i);

                Iterator iter2 = obj2.keySet().iterator();
                while (iter2.hasNext()) {
                    String chiave = (String) iter2.next();
                    keys2.add(chiave);
                }

                String tag = (String) obj2.get(".tag");
                String name = (String) obj2.get("name");
                String path_lower = (String) obj2.get("path_lower");
                String path_display = (String) obj2.get("path_display");
                String id = (String) obj2.get("id");
                Date client_modified = (Date) obj2.get("client_modified");
                Date server_modified = (Date) obj2.get("server_modified");
                String rev = (String) obj2.get("rev");
                int size = (int) obj2.get("size");
                boolean is_downloadable = (boolean) obj2.get("is_downloadable");
                String content_hash = (String) obj2.get("content_hash");

                DropboxFile db = new DropboxFile(tag, name, path_lower, path_display, id, client_modified, server_modified, rev, size, is_downloadable, content_hash);
                ListaFile.add(db);
            }

            for (DropboxFile i : ListaFile) {
                System.out.println(i.toString());
            }

            /*
            for (int i = 0; i < keys2.size(); i++) {
                System.out.println(keys2.get(i));
                System.out.println();
                System.out.println();
            }
             */
            System.out.println("OK");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
