

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Menuconsole;

import Controller.MainController;
import Negocio.Archivo;
import java.util.Scanner;


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
        Archivo a=new Archivo();
        MainController m= new MainController();
        Scanner scanner = new Scanner(System.in);
		
        System.out.println("--Convertir archivos--");
        System.out.println("1. Convertir DOCX a PDF");
        System.out.println("2. Convertir ODT a PDF");
        System.out.println("3. Convertir ODT a DOCX");
        System.out.println("4. Convertir DOCX a ODT");
        System.out.println("5. Convertir XLSX a PDF");
        System.out.println("6. Convertir ODS a PDF");
        System.out.println("7. Convertir ODS a XLSX");
        System.out.println("8. Convertir XLSX a ODS");
        System.out.println("9. Convertir PPTX a PDF");
        System.out.println("10. Convertir ODP a PDF");
        System.out.println("11. Convertir ODP a PPTX");
        System.out.println("12. Convertir PPTX a ODP");
        System.out.println("0. Salir");
        System.out.println("Por favor digite la opción deseada");
        
        while(!scanner.hasNextInt()) scanner.next();
        int opcion= scanner.nextInt();
        
        if(opcion==0)
        {
            System.exit(0);
        }
        
        System.out.println("Por favor digite la ruta del archivo");
        
        String origen = scanner.next();
        String extension=origen.substring(origen.lastIndexOf(".") +1);
        
        //RutaDestino
        System.out.println("Por favor digite la ruta donde guardar el archivo convertido");
        String destino = scanner.next();
        
        switch(opcion)
        {
            
            case 0:
                break;
            case 1:
                if("docx".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PDF");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 2:
                
                if("odt".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PDF");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 3:
                if("odt".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "DOCX");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 4:
                if("docx".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "ODT");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 5:
                if("xlsx".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PDF");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 6:
                if("ods".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PDF");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 7:
                if("ods".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "XLSX");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 8:
                if("xlsx".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "ODS");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                }
            case 9:
                if("pptx".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PDF");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 10:
                if("odp".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PDF");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 11:
                if("odp".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "PPTX");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            case 12:
                if("pptx".equals(extension))
                {
                    a.toBase64(origen, destino, extension.toUpperCase(), "ODP");
                    menu();
                    
                }else{
                    System.out.print("El archivo no existe");
                    break;
                };
            default:
                break;
               
                
        }    
        
        
    }
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        ConvertAppConsole c=new ConvertAppConsole();
        c.menu();
    }
    
}
