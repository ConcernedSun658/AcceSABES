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
public class Alta_libro {
    private int id_libro;
    private String nombre_libro;
    private String clasificacion;
    private String autor;
    private String edicion;
    private String isbn;

    public Alta_libro(int id_libro, String nombre_libro, String clasificacion, String autor, String edicion, String isbn) {
        this.id_libro = id_libro;
        this.nombre_libro = nombre_libro;
        this.clasificacion = clasificacion;
        this.autor = autor;
        this.edicion = edicion;
        this.isbn = isbn;
    }

    public Alta_libro(String nombre_libro, String clasificacion, String autor, String edicion, String isbn) {
        this.nombre_libro = nombre_libro;
        this.clasificacion = clasificacion;
        this.autor = autor;
        this.edicion = edicion;
        this.isbn = isbn;
    }
    
    

    public Alta_libro() {
        
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
   
   
}
