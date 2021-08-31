/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Controller.MainController;
import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author rozo
 */
public class Archivo {

    public void toBase64(String origen, String destino, String extension, String conv) {

        try {
            MainController m=new MainController();
            File archivo = new File(origen);
            if (archivo.exists()) {
                
                String nombrearchivo = archivo.getName();
                byte[] archivobytes = Files.readAllBytes(archivo.toPath());
                String Abase64 = java.util.Base64.getEncoder().encodeToString(archivobytes);
                m.RequestJson(nombrearchivo, Abase64, destino, extension, conv);
                
            } else {
                System.out.println("no se encontro");
                
            }

        } catch (Exception e) {
            System.out.print("Error" + e);
            
        }

    }
}
