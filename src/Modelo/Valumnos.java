/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Blob;

/**
 *
 * @author MUÑOZ
 */
public class Valumnos {
    private String matricula;
    private String nombre;
    private String apellido;
    private String email;
    private Blob fotografia;
    private String status;
    private String codigotarjeta;
    private int tstatus;

    public Valumnos() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getTstatus() {
        return tstatus;
    }

    public void setTstatus(int tstatus) {
        this.tstatus = tstatus;
    }

    public Valumnos(String matricula, String nombre, String apellido, String email, Blob fotografia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fotografia = fotografia;
    }
}
