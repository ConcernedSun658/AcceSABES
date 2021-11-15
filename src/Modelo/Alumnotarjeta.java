/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Kalas
 */
public class Alumnotarjeta {
    private String matricula;
    private String codigotarjeta;
    private String status;

    public Alumnotarjeta(String matricula, String codigotarjeta) {
        this.matricula = matricula;
        this.codigotarjeta = codigotarjeta;
    }

    public Alumnotarjeta() {
    }

    public Alumnotarjeta(String matricula, String codigotarjeta, String status) {
        this.matricula = matricula;
        this.codigotarjeta = codigotarjeta;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCodigotarjeta() {
        return codigotarjeta;
    }

    public void setCodigotarjeta(String codigotarjeta) {
        this.codigotarjeta = codigotarjeta;
    }
    
    
}
