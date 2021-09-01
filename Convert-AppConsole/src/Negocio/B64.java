package Negocio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 *
 * @author Angel Leonardo
 */
public class B64 {
    
    String base64;

    public B64(String base64) {
        this.base64 = base64;
    }
        
    public String toFileInLocal(String rutaDestino, String nameFile) {

        try {
            byte[] decodedFile = Base64.getDecoder()
                    .decode(base64.getBytes(StandardCharsets.ISO_8859_1));
            Path destinationFile = Paths.get(rutaDestino, nameFile);

            Files.write(destinationFile, decodedFile);
            System.out.println("Converted file...OK");
            return destinationFile.toString();
        } catch (IOException ex) {            
            System.out.println("Error guardando los archivo: "+ex.getMessage());
            System.out.println(rutaDestino);
            return "";
        }

    }
}
