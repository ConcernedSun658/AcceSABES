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
public class Carrera {
    private Integer idcarrera;
    private String  carrera;

    public Carrera(Integer idcarrera, String carrera) {
        this.idcarrera = idcarrera;
        this.carrera = carrera;
    }

   

    public Carrera() {
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return this.carrera;
    }
    
    
}
