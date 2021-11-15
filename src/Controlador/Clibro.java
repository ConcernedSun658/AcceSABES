/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alta_libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MUÑOZ
 */
public class Clibro {
    
    public void guardar(Connection conexion, Alta_libro libro) throws SQLException {
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("INSERT INTO libro VALUES(?,?,?,?,?,?)");
            consulta.setInt(1, libro.getId_libro());
            consulta.setString(2, libro.getNombre_libro());
            consulta.setString(3, libro.getClasificacion());
             consulta.setString(4, libro.getAutor());
            consulta.setString(5, libro.getEdicion());
            consulta.setString(6, libro.getIsbn());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }
    
    
    public Alta_libro consulta_libro(Connection conexion, int id_libro) throws SQLException {
        Alta_libro libro = new Alta_libro();
        try {
            PreparedStatement consulta = conexion.prepareStatement("select * from libro WHERE id_libro= '"+id_libro+"'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                
                libro.setId_libro(resultado.getInt("id_libro"));
               libro.setAutor(resultado.getString("autor"));
               libro.setNombre_libro(resultado.getString("nombre"));
               libro.setClasificacion(resultado.getString("clasificacion"));
               libro.setEdicion(resultado.getString("edicion"));
               libro.setIsbn(resultado.getString("isbn"));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return libro;
    }

   public void actualizarlibro (Connection conexion,Alta_libro libro) throws SQLException
   {
   PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("update libro set nombre=?,clasificacion=?,autor=?,edicion=?,ISBN=? where id_libro=?");
            
            consulta.setString(1, libro.getNombre_libro());
            consulta.setString(2, libro.getClasificacion());
            consulta.setString(3, libro.getAutor());
            consulta.setString(4, libro.getEdicion());
            consulta.setString(5, libro.getIsbn());
            consulta.setInt(6, libro.getId_libro());
            
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
   
   
   }

   
   
    
}
