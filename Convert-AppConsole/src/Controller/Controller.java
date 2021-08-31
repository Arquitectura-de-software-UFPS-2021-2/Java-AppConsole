package Controller;

import Negocio.Archivo;
import Negocio.B64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;

/**
 *
 * @author MIGUEL
 */
public class Controller {
    
    public static final String URL_POST ="http://54.163.147.33:8080/convertir";

    private static JSONObject createRequestJson(String nombrearchivo, String Abase64, String extensionFuente, String extensionDestino) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("nombreArchivo", nombrearchivo);
            obj.put("extensionFuente", extensionFuente);
            obj.put("extensionDestino", extensionDestino);
            obj.put("base64", Abase64);
            
            System.out.println("Create json request...OK");
            return obj;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static JSONObject requestPost(String sURL, JSONObject JSONSend, String destino) {

        try {

            URL myurl = new URL(sURL);
            HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);

            con.setRequestProperty("Content-Type", "application/json; charset=utf8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Method", "POST");
            OutputStream os = con.getOutputStream();
            os.write(JSONSend.toString().getBytes("UTF-8"));
            os.close();

            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

                String line = null;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                String response = sb.toString();
                //System.out.print(response);
                JSONParser parser = new JSONParser();
                //se parsea la respues en un JSONObject
                JSONObject jsonResult = (JSONObject) parser.parse(response);
                System.out.println("Response file...OK");
                return jsonResult;
                
            } else {
                System.out.println(con.getResponseCode());
                System.out.println(con.getResponseMessage());
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public static String convert(String rutaOrigen, String rutaDestino, String extensionFuente, String extensionDestino) {
        Archivo file = new Archivo(rutaOrigen);
        
        String base64Fuente = file.toBase64();        
        if(base64Fuente == null) return "Encode File to Base64...FAIL";
        
        JSONObject jsonRequest = createRequestJson(file.getName(), base64Fuente, extensionFuente, extensionDestino);
        if(jsonRequest==null) return "Create json request...FAIL";
        
        JSONObject jsonResponse = requestPost(URL_POST, jsonRequest, rutaDestino);
        if(jsonResponse==null) return "Response file...FAIL";        
        String base64Converted = (String) jsonResponse.get("base64");
        String nameFileConverted = (String) jsonResponse.get("nombreArchivo");
        
        B64 base64 = new B64(base64Converted);        
        String resultSavingFile = base64.toFileInLocal(rutaDestino, nameFileConverted);
        if(resultSavingFile==null) return "Saving file...FAIL";        
        
        return "-> New file saved in path " + rutaDestino + "\n";        
    }
}
