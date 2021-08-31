![Logo](https://i.ibb.co/9pFNcg6/LOGO-DOCONVER.png)


# DoConver JAVA-AppConsole

Software que convierte ficheros en formato Microsoft Office a ficheros en formato abierto (ODF Open Document Format) y viceversa y a formato PDF (Portable Document Format):

- Documentos .DOCX y .ODT
- Documentos .XLSX y .ODS
- Documentos .PPTX y ODP
- Cualquier de los formatos anteriores a PDF.

## Documentación

[Documentación]()

## Ejecución

```bash
java -jar DoconverJavaConsole.jar
```

## Uso

### Menú 
```bash

Por favor digite la opción deseada

1. Convert DOCX to PDF
2. Convert DOCX to ODT
3. Convert ODT to PDF
4. Convert ODT to DOCX
5. Convert XLSX to PDF
6. Convert XLSX to ODS
7. Convert ODS to PDF
8. Convert ODS to XLSX
9. Convert PPTX to PDF
10. Convert PPTX to ODP
11. Convert ODP to PDF
12. Convert ODP to PPTX
0. Salir
Option: 

```
- Paso 1: Digitamos la opción deseada y posteriormente la ruta del archivo a convertir.
```bash
Option: 1
Ruta origen del archivo (0 para cancelar):  C:/FILE.DOCX
```

- Paso 2: Digitamos la ruta destino del archivo convertido.
```bash
Ruta destino del archivo convertido (0 para cancelar):  D:/
```

- Paso 3: Se mostrará el estado de cada proceso de conversión y la ruta de destino.
```bash
Encode File to Base64...OK
Create json request...OK
Response file...OK
Converted file...OK
-> New file saved in path D:/
```

## Construido en Lenguaje de Programación:
- [NetBeans IDE]()
- [JAVA]()

### Librerias utilizadas:
- [Json-simple]()

## Autores
- [Kevin Jimenez](https://github.com/Kevinjimenez0119)
- [Leonardo Vivas](https://github.com/LeonardoVivasAndrade)
- [José Rozo](https://github.com/joseedye)
- [Miguel Páez](https://github.com/1151613)
