/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import Controlador.Cvacceso;
import Controlador.Generales;
import Modelo.Accesom;
import Modelo.Vacceso;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Color;
import java.awt.Image;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Kalas
 */
public class Acceso extends javax.swing.JPanel {

    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    String codtarjeta, nombrecompleto, horaentrada;
    Vacceso vacceso = new Vacceso();
    Cvacceso cvacceso = new Cvacceso();
    Accesom accesom;
    ImageIcon imageicon;
    Blob bytesImagen;
    Long prueba;
    private SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (arduino.isMessageAvailable()) {
                    codtarjeta = arduino.printMessage();
                    try {
                        vacceso = cvacceso.verificar(Conexion.obtener(), codtarjeta);
                        nombrecompleto = vacceso.getNombre() + " " + vacceso.getApellido();
                        bytesImagen = vacceso.getFotografia();
                        byte[] bytesLeidos = bytesImagen.getBytes(1, (int) bytesImagen.length());
                        imageicon = new ImageIcon(bytesLeidos);
                        Icon icono = new ImageIcon(imageicon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
                        lblimagen.setIcon(icono);
                        lblpaso.setBackground(Color.GREEN);
                        lblnombre.setText(nombrecompleto);
                        //registro de ingresos
                        horaentrada = Generales.getDateTime();
                        accesom = new Accesom(codtarjeta, horaentrada);
                        cvacceso.registraracceso(Conexion.obtener(), accesom);
                    } catch (SQLException ex) {
                        Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("entro al label");
                }
            } catch (SerialPortException | ArduinoException ex) {
                // txttarjeta.setBackground(Color.RED);

                //txttarjeta.setText("Ocurrio un problema");
            }
        }

    };
    /**
     * Creates new form Acceso
     */
    public Acceso() {
          try {
           
             arduino.arduinoRXTX("COM4", 9600, listener);
       
         //System.out.println(arduino.getInputBytesAvailable());
         
    } catch (Exception ex) {
       // Logger.getLogger(Ralumnos.class.getName()).log(Level.SEVERE, null, ex);
        
    }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblpaso = new javax.swing.JLabel();
        lblimagen = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido:");

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblpaso.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblpaso.setOpaque(true);

        lblimagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpaso, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(lblpaso, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblpaso;
    // End of variables declaration//GEN-END:variables
}