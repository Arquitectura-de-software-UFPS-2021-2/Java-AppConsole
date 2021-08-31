package Menuconsole;

import Controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class ConvertAppConsole {

    public static final String ERROR_NO_FILE = "Error: El archivo no existe!";
    public static final String[][] EXT = {
        {"", ""},
        {"DOCX", "PDF"},
        {"DOCX", "ODT"},
        {"ODT", "PDF"},
        {"ODT", "DOCX"},
        {"XLSX", "PDF"},
        {"XLSX", "ODS"},
        {"ODS", "PDF"},
        {"ODS", "XLSX"},
        {"PPTX", "PDF"},
        {"PPTX", "ODP"},
        {"ODP", "PDF"},
        {"ODP", "PPTX"}
    };

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor digite la opción deseada\n");
        for (int i = 1; i < EXT.length; i++) {
            System.out.println(i + ". Convert " + EXT[i][0] + " to " + EXT[i][1]);
        }
        System.out.println("0. Salir");

        System.out.print("Option: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Option: ");
            scanner.next();
        }
        
        int opcion = scanner.nextInt();
        if (opcion == 0) System.exit(0);

        System.out.print("Ruta origen del archivo (0 para cancelar):  ");
        String rutaOrigen = scanner.next();
        if (rutaOrigen.equals("0")) menu();
        String extensionFuente = rutaOrigen.substring(rutaOrigen.lastIndexOf(".") + 1);

        //RutaDestino
        System.out.print("Ruta destino del archivo convertido (0 para cancelar):  ");
        String rutaDestino = scanner.next();
        if (rutaDestino.equals("0")) menu();

        if (EXT[opcion][0].equalsIgnoreCase(extensionFuente)) {
            String response = Controller.convert(rutaOrigen, rutaDestino, extensionFuente.toUpperCase(), EXT[opcion][1]);
            System.out.println(response);
            menu();
        } else {
            System.out.println(ERROR_NO_FILE);
        }
    }

    public static void main(String[] args) {
        ConvertAppConsole c = new ConvertAppConsole();
        c.menu();
    }
}
