/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Vacceso;
import Modelo.Accesom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kalas
 */
public class Cvacceso {

    public Vacceso verificar(Connection conexion, String codigo) {
        Vacceso vacceso = new Vacceso();
        PreparedStatement consulta;
        try {
            consulta = conexion.prepareStatement("SELECT matricula,nombre,apellido,fotografia FROM vacceso where status='Inscrito' and codigotarjeta='" + codigo + "' and tstatus=1");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                vacceso.setMatricula(resultado.getString("matricula"));
                vacceso.setNombre(resultado.getString("nombre"));
                vacceso.setApellido(resultado.getString("apellido"));
                vacceso.setFotografia(resultado.getBlob("fotografia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cvacceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vacceso;
    }
    
    public void registraracceso(Connection conexion, Accesom acceso) throws SQLException
    {
        
        PreparedStatement consulta;
         try {
             consulta = conexion.prepareStatement("INSERT INTO acceso (codigotarjeta,entrada) VALUES(?,?)");
             consulta.setString(1,acceso.getCodigotarjeta());
             consulta.setString(2, acceso.getEntrada());
             System.out.println(acceso.getCodigotarjeta());
             System.out.println(acceso.getEntrada());
             consulta.executeUpdate();
         } catch (SQLException ex) {
             throw new SQLException(ex);
            
         }
    
    
    
    }
    
    public void registraraccesocc(Connection conexion, Accesom acceso) throws SQLException
    {
        
        PreparedStatement consulta;
         try {
             consulta = conexion.prepareStatement("INSERT INTO accesocc (codigotarjeta,acceso,idcc) VALUES(?,?,3)");
             consulta.setString(1,acceso.getCodigotarjeta());
             consulta.setString(2, acceso.getEntrada());
             System.out.println(acceso.getCodigotarjeta());
             System.out.println(acceso.getEntrada());
             consulta.executeUpdate();
         } catch (SQLException ex) {
             throw new SQLException(ex);
            
         }
    
    
    
    }

}
