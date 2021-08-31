/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Negocio.B64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;


/**
 *
 * @author MIGUEL
 */
public class MainController {

    public void RequestJson(String nombrearchivo, String Abase64, String destino, String extencion, String conv) throws Exception
    {
        String uri ="http://54.163.147.33:8080/convertir";
        JSONObject obj = new JSONObject();
        obj.put("nombreArchivo", nombrearchivo);
        obj.put("extensionFuente", extencion);
        obj.put("extensionDestino", conv);
        obj.put("base64", Abase64);
        //System.out.print(obj);
        requestPost(uri, obj, destino);
    }

    public void requestPost(String sURL, JSONObject JSONSend, String destino) throws Exception{
        
        try {
           
           
            URL myurl = new URL(sURL);
            HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);

            con.setRequestProperty("Content-Type", "application/json; charset=utf8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Method", "POST");
            OutputStream os = con.getOutputStream();
            os.write(JSONSend.toString().getBytes("UTF-8"));
            os.close();


            StringBuilder sb = new StringBuilder();  
            int HttpResult =con.getResponseCode();
            if(HttpResult ==HttpURLConnection.HTTP_OK){
            BufferedReader br = new BufferedReader(new   InputStreamReader(con.getInputStream(),"utf-8"));  

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
            String codebase64=(String) jsonResult.get("base64");
            String nombrearchivo=(String) jsonResult.get("nombreArchivo");
            B64 b=new B64();
            b.toFileAndSaveInLocal(codebase64, destino, nombrearchivo);
            }else{
            System.out.println(con.getResponseCode());
            System.out.println(con.getResponseMessage());  
            }
             
             
            } catch (Exception e) {
                e.printStackTrace();
            }
       
        

    }
}
