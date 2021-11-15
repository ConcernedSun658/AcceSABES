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
public class Alumno {
    private String matricula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private int idcarrera;
    private int idstatus;
    private Blob fotografia;
   

    public Alumno() {
    }

    public Alumno(String matricula, String nombre, String apellido, String telefono, String email,int idcarrera, int idstatus) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email=email;
        this.idcarrera = idcarrera;
        this.idstatus = idstatus;
    }
    

    public Alumno(String matricula, String nombre, String apellido, String telefono, int idcarrera, int idstatus, Blob fotografia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idcarrera = idcarrera;
        this.idstatus = idstatus;
        this.fotografia = fotografia;
    }

    public Alumno(String matricula, String nombre, String apellido, String telefono, String email, int idcarrera, int idstatus, Blob fotografia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.idcarrera = idcarrera;
        this.idstatus = idstatus;
        this.fotografia = fotografia;
    }
    

    public Blob getFotografia() {
        return fotografia;
    }

    public void setFotografia(Blob fotografia) {
        this.fotografia = fotografia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

  
    
    
}
