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
public class Accesom {
    private int idacceso;
    private String codigotarjeta;
    private String entrada;
    private String Salida;

    public Accesom() {
    }

    public Accesom(String Salida) {
        this.Salida = Salida;
    }

    public Accesom(String codigotarjeta, String entrada) {
        this.codigotarjeta = codigotarjeta;
        this.entrada = entrada;
    }

    public int getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(int idacceso) {
        this.idacceso = idacceso;
    }

    public String getCodigotarjeta() {
        return codigotarjeta;
    }

    public void setCodigotarjeta(String codigotarjeta) {
        this.codigotarjeta = codigotarjeta;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return Salida;
    }

    public void setSalida(String Salida) {
        this.Salida = Salida;
    }
    
    
}
