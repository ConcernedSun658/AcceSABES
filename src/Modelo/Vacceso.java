/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Blob;

/**
 *
 * @author Kalas
 */
public class Vacceso {
    private String matricula;
    private String nombre;
    private String apellido;
    private Blob fotografia;
    private String status;
    private String codigotarjeta;

    public Vacceso() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Blob getFotografia() {
        return fotografia;
    }

    public void setFotografia(Blob fotografia) {
        this.fotografia = fotografia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigotarjeta() {
        return codigotarjeta;
    }

    public void setCodigotarjeta(String codigotarjeta) {
        this.codigotarjeta = codigotarjeta;
    }
    
    
}
