package prova.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
                    "Bearer sl.A9vi1mLR3DY7tuIzISiH6AJeO8Ec423U8bMZptbDWzTWcsLhi_qfVBGtwj-jz3dzNzD3TU60vpgu0IjxCyak6aXWSKJ016PHmjlASvJ7VdZ47YDkQIPJgDayUGXbHcXLAcVjpy0");
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
                
                System.out.println(data);
                
            } finally {
                in.close();
            }
            JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
            
            System.out.println(obj.toString());
            
            System.out.println("OK");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
