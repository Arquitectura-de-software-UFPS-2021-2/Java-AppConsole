
package Negocio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rozo
 */
public class B64 {

    public static boolean toFileAndSaveInLocal(String strBase64, String rutaDestino, String nameFile) {

        try {
            byte[] decodedFile = Base64.getDecoder()
                    .decode(strBase64.getBytes(StandardCharsets.UTF_8));
//        Path destinationFile = Paths.get("/path/to/imageDir", "myImage.jpg");
            Path destinationFile = Paths.get(rutaDestino, nameFile);

            Files.write(destinationFile, decodedFile);
        } catch (IOException ex) {
            Logger.getLogger(B64.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return true;

    }
}
