package Negocio;

import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author rozo
 */
public class Archivo {
    
    File file;

    public Archivo(String rutaOrigen) {
        file = new File(rutaOrigen);
    }
    
    public String getName(){
        return file.getName();
    }

    public String toBase64() {

        try {                     
            if (file.exists()) {                
                
                byte[] archivobytes = Files.readAllBytes(file.toPath());
                String Abase64 = java.util.Base64.getEncoder().encodeToString(archivobytes);
                System.out.println("Encode File to Base64...OK");
                return Abase64;
                
            } else {
                return null;                
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public File getfile (){
        return file;
    }
    
}
