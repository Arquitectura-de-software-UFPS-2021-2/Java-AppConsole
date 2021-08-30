/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Menuconsole.Archivo;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIGUEL
 */
public class MainController {

    public JSONObject ObJson(Archivo archi) {

        JSONObject obj = new JSONObject();
        obj.put("base64", archi.getBase64());
        obj.put("extencionDestino", archi.getExtencionDestino());
        obj.put("extencionFuente", archi.getExtencionFuente());
        obj.put("nombreArchivo", archi.getNombreArchivo());

        try {
            requestPost(obj);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(obj);
        return obj;
        
    }

    public JSONObject requestPost(JSONObject JSONSend) throws Exception {
        //se crea el objeto de tipo URL
        URL url = new URL("http://54.163.147.33:8080/convertir");
        //Convierte el JSONObject a un string y despues a un arreglo de Bytes
        byte[] postDataBytes = JSONSend.toJSONString().getBytes("UTF-8");
        //Abre la conexión y asigna el objeto de la conexion a conn
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //establece el metodo o verbo de la conexión    conn.setRequestMethod("POST");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        //se establece que la solicitud tendrá salida
        conn.setDoOutput(true);
        //se escribe el cuerpo de la solicitud con el JSON convertido a Bytes
        conn.getOutputStream().write(postDataBytes);
        //Se realiza la solicitud y se lee la respuesta de la misma en el Reader
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        //Se convierte el Reader en un String
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) {
            sb.append((char) c);
        }
        String response = sb.toString();
        //Se crea el objeto que parseará la respuesta
        JSONParser parser = new JSONParser();
        //Se parsea la respuesta en un JSONObject
        JSONObject jsonResult = (JSONObject) parser.parse(response);
        //se Retorna la respuesta
        System.out.println(jsonResult);
        return jsonResult;
    }
        public static void main(String[] args) {
        
    }
}
