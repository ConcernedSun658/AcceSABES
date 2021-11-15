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
public class Vprestamolibro {
    private int idprestamo;
    private String matricula;
    private int idlibro;
    private String nombrelibro;
    private String fechaprestamo;
    private String fechaentrega;
    private String statusprestamo;

    public Vprestamolibro(int idprestamo, String matricula, int idlibro, String nombrelibro, String fechaprestamo, String fechaentrega, String statusprestamo) {
        this.idprestamo = idprestamo;
        this.matricula = matricula;
        this.idlibro = idlibro;
        this.nombrelibro = nombrelibro;
        this.fechaprestamo = fechaprestamo;
        this.fechaentrega = fechaentrega;
        this.statusprestamo = statusprestamo;
    }

    public Vprestamolibro() {
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getStatusprestamo() {
        return statusprestamo;
    }

    public void setStatusprestamo(String statusprestamo) {
        this.statusprestamo = statusprestamo;
    }
    
}
