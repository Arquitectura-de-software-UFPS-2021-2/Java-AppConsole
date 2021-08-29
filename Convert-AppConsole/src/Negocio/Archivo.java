/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author rozo
 */
public class Archivo {

    public static String toBase64(String origen) {

        try {
            File archivo = new File(origen);
            if (archivo.exists()) {

                byte[] archivobytes = Files.readAllBytes(archivo.toPath());
                String Abase64 = java.util.Base64.getEncoder().encodeToString(archivobytes);

                return Abase64;
            } else {
                System.out.println("no se encontro");
                return "no";
            }

        } catch (Exception e) {
            System.out.print("Error" + e);
            return "no se encontro";
        }

    }
    
    public void SaveInLocal (File file, String ruta , String nombre){
        //grabar un archio en la ruta
        
    }
}
