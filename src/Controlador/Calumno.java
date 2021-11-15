/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Alumnotarjeta;
import Modelo.Vconsultaalumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kalas
 */
public class Calumno {

    public void guardar(Connection conexion, Alumno alumno) throws SQLException {
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("INSERT INTO alumno VALUES(?,?,?,?,?,?,?,?)");
            consulta.setString(1, alumno.getMatricula());
            consulta.setString(2, alumno.getNombre());
            consulta.setString(3, alumno.getApellido());
            consulta.setString(4, alumno.getTelefono());
            consulta.setString(5, alumno.getEmail());
            consulta.setInt(6, alumno.getIdcarrera());
            consulta.setInt(7, alumno.getIdstatus());
            consulta.setBlob(8, alumno.getFotografia());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }

    public void guardartarjeta(Connection conexion, Alumnotarjeta alumnotarjeta) throws SQLException {
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("INSERT INTO alumno_tarjeta VALUES(?,?,1)");
            consulta.setString(1, alumnotarjeta.getMatricula());
            consulta.setString(2, alumnotarjeta.getCodigotarjeta());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public boolean verificartarjeta(Connection conexion, String tarjeta) throws SQLException
    {
        Alumnotarjeta alumnotarjeta= new Alumnotarjeta();
        PreparedStatement consulta;
        try{
        consulta=conexion.prepareStatement("select * from alumno_tarjeta where codigotarjeta = '" + tarjeta + "'");
        ResultSet resultado = consulta.executeQuery();
        if(resultado.next()){
        return true;
        }
        else{
        return false;
        }
        
        }
        catch (SQLException ex) {
            throw new SQLException(ex);
        }
       
            
           
    
    }

    public ArrayList<Vconsultaalumnos> consulta(Connection conexion, String matricula) throws SQLException {
        ArrayList<Vconsultaalumnos> alumnos = new ArrayList();
        try {
            PreparedStatement consulta = conexion.prepareStatement("select * from consultaalumnos where matricula like '" + matricula + "%'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                alumnos.add(new Vconsultaalumnos(resultado.getString("matricula"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("telefono"), resultado.getString("carrera"),
                        resultado.getString("status"), resultado.getBlob("fotografia"),resultado.getString("email")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

        return alumnos;
    }

    public Alumno recuperaralumno(Connection conexion, String matricula) throws SQLException {
        Alumno alumno = new Alumno();
        try {
            PreparedStatement consulta = conexion.prepareStatement("select * from alumno where matricula = '" + matricula + "'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                alumno.setMatricula(resultado.getString("matricula"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setApellido(resultado.getString("apellido"));
                alumno.setTelefono(resultado.getString("telefono"));
                alumno.setIdcarrera(resultado.getInt("idcarrera"));
                alumno.setIdstatus(resultado.getInt("idstatus"));
                alumno.setFotografia(resultado.getBlob("fotografia"));
                alumno.setEmail(resultado.getString("email"));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return alumno;
    }
    
    public void actualizaralumno (Connection conexion,Alumno alumno) throws SQLException
    {
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("update alumno set nombre=?,apellido=?,telefono=?,idcarrera=?,idstatus=?,email=? where matricula=?");
            
            consulta.setString(1, alumno.getNombre());
            consulta.setString(2, alumno.getApellido());
            consulta.setString(3, alumno.getTelefono());
            consulta.setInt(4, alumno.getIdcarrera());
            consulta.setInt(5, alumno.getIdstatus());
            consulta.setString(6, alumno.getEmail());
            consulta.setString(7, alumno.getMatricula());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    
    
    
    }
    
}
