package Menuconsole;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.Base64;

/**
 *
 * @author Kevin
 */
public class ConvertAppConsole {

    /**
     * @param args the command line arguments
     */
    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
		
        System.out.println("--Convertir archivos a pdf--");
        System.out.println("1. DOCX a PDF");
        System.out.println("2. ODT a PDF");
        System.out.println("3. ODT a DOCX");
        System.out.println("4. DOCX a ODT");
        System.out.println("5. XLSX a PDF");
        System.out.println("6. ODS a PDF");
        System.out.println("7. ODS a XLSX");
        System.out.println("8. XLSX a ODS");
        System.out.println("9. PPTX a PDF");
        System.out.println("10. ODP a PDF");
        System.out.println("11. ODP a PPTX");
        System.out.println("12. PPTX a ODP");
        System.out.println("0. salir");
        System.out.println("Por favor digite la opcion deseada");
        
        int opcion=scanner.nextInt();
        
        System.out.println("Por favor digite la ruta del archivo de el archivo");
        
        String name = scanner.next();
        switch(opcion)
        {
            case 0:
                break;
            case 1:
                convert(name);
                menu();
                break;
            case 2:
                convert(name);
                menu();
                break; 
        }
    }
    public void convert(String name)
    {
        try {
            File archivo = new File(name);
            
            if(archivo.exists())
            {
                
                byte[] archivobytes= Files.readAllBytes(archivo.toPath());
                String Abase64= Base64.getEncoder().encodeToString(archivobytes);
                System.out.print(Abase64);
                
                
                
            
            }else{
            System.out.print("El archivo no existe");
            }
            
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        
        
    }
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        ConvertAppConsole c=new ConvertAppConsole();
        c.menu();
    }
    
}
