/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MUÑOZ
 */
public class Vprestamo_biblioteca {
  
    private int id_libro;
    private String matricula;
    private String fecha_inicio;
    private String fecha_final;
    private int status;

    public Vprestamo_biblioteca(int id_libro, String matricula, String fecha_inicio, String fecha_final, int status) {
        this.id_libro = id_libro;
        this.matricula = matricula;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.status = status;
    }
    
    public Vprestamo_biblioteca(int id_libro, String matricula, String fecha_inicio, String fecha_final) {
        
        this.id_libro = id_libro;
        this.matricula = matricula;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public Vprestamo_biblioteca() {
        
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
           
          
}
