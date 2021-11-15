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
public class Vconsultaalumnos {
     private String matricula;
     private String nombre;
     private String apellidos;
     private String telefono;
     private String carrera;
     private String status;
     private Blob fotografia;
     private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vconsultaalumnos(String matricula, String nombre, String apellidos, String telefono, String carrera, String status, Blob fotografia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.carrera = carrera;
        this.status = status;
        this.fotografia = fotografia;
    }

    public Vconsultaalumnos(String matricula, String nombre, String apellidos, String telefono, String carrera, String status, Blob fotografia, String email) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.carrera = carrera;
        this.status = status;
        this.fotografia = fotografia;
        this.email = email;
    }
    
    

    public Vconsultaalumnos() {
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
     
    
    
}
