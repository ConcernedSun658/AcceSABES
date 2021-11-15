/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alta_libro;
import Modelo.Valumnos;
import Modelo.Vconsultaalumnos;
import Modelo.Vprestamolibro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kalas
 */
public class Cbiblioteca {
    Valumnos alumno= new Valumnos();
    
    public Valumnos consultaralumno (Connection conexion,String codtarjeta) throws SQLException
    {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM `valumnosbiblioteca` WHERE STATUS='Inscrito' and tstatus=1 and codigotarjeta='"+codtarjeta+"'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                alumno.setMatricula(resultado.getString("matricula"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setApellido(resultado.getString("apellido"));
               alumno.setEmail(resultado.getString("email"));
                alumno.setFotografia(resultado.getBlob("fotografia"));
                
            }
        } catch (SQLException ex) {
            System.out.println("hola");
            throw new SQLException(ex);
        }
        return alumno;
        
        
   
    }

     public ArrayList<Vprestamolibro> consultaprestamos (Connection conexion, String matricula) throws SQLException{
     ArrayList<Vprestamolibro> prestamoslibros = new ArrayList();
     try {
            PreparedStatement consulta = conexion.prepareStatement("select * from vprestamolibro where matricula = '" + matricula + "' and status_pre='prestamo'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                
                prestamoslibros.add(new Vprestamolibro(resultado.getInt("id_prestamo"), resultado.getString("matricula"), resultado.getInt("id_libro"), resultado.getString("nombre"), resultado.getString("fecha_prestamo"),
                        resultado.getString("fecha_entrega"),resultado.getString("status_pre")));
            } 
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
     
     return prestamoslibros;
     }

  public ArrayList<Alta_libro> registro(Connection conexion) throws SQLException {
      ArrayList<Alta_libro> libro = new ArrayList();
      
      try {
            PreparedStatement consulta = conexion.prepareStatement("select * from libro");//javier
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                
                libro.add(new Alta_libro(resultado.getInt("id_libro"),resultado.getString("nombre"), resultado.getString("clasificacion"), resultado.getString("autor"), resultado.getString("edicion"), resultado.getString("ISBN")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

        return libro;
  }  
  
  

}
