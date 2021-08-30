/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menuconsole;

/**
 *
 * @author berserker
 */
public class Archivo {
    
String base64	;
String extencionDestino;
String extencionFuente	;
String nombreArchivo	;

    public Archivo() {
    }

    public Archivo(String base64, String extencionDestino, String extencionFuente, String nombreArchivo) {
        this.base64 = base64;
        this.extencionDestino = extencionDestino;
        this.extencionFuente = extencionFuente;
        this.nombreArchivo = nombreArchivo;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getExtencionDestino() {
        return extencionDestino;
    }

    public void setExtencionDestino(String extencionDestino) {
        this.extencionDestino = extencionDestino;
    }

    public String getExtencionFuente() {
        return extencionFuente;
    }

    public void setExtencionFuente(String extencionFuente) {
        this.extencionFuente = extencionFuente;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
