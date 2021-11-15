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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Kalas
 */
public class JInternalaccesocc extends javax.swing.JInternalFrame {
     PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    String codtarjeta, nombrecompleto, horaentrada;
    Vacceso vacceso = new Vacceso();
    Cvacceso cvacceso = new Cvacceso();
    Accesom accesom;
    ImageIcon imageicon;
    Blob bytesImagen;
    InternalFrameListener listener1 = new InternalFrameListener() {
        @Override
        public void internalFrameOpened(InternalFrameEvent e) {
            System.out.println("opened");
        }

        @Override
        public void internalFrameClosing(InternalFrameEvent e) {
            try {
                System.out.println("framedeac");
                arduino.killArduinoConnection();
            } catch (ArduinoException ex) {
                Logger.getLogger(JInternalacceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void internalFrameClosed(InternalFrameEvent e) {
            try {
                System.out.println("closed");
                arduino.killArduinoConnection();
            } catch (ArduinoException ex) {
                Logger.getLogger(JInternalacceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void internalFrameIconified(InternalFrameEvent e) {
            System.out.println("iconi");
        }

        @Override
        public void internalFrameDeiconified(InternalFrameEvent e) {
            System.out.println("deico");
        }

        @Override
        public void internalFrameActivated(InternalFrameEvent e) {
            try {
                //  arduino.arduinoRXTX("COM4", 9600, listener);
                System.out.println("frameacti");
            } catch (Exception ex) {
                Logger.getLogger(JInternalacceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void internalFrameDeactivated(InternalFrameEvent e) {
            System.out.println("deac");
        }
    };
    private SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {

                if (arduino.isMessageAvailable()) {

                    codtarjeta = arduino.printMessage();
                    try {
                        lblnombre.setForeground(Color.black);
                        vacceso = cvacceso.verificar(Conexion.obtener(), codtarjeta);
                        if (vacceso.getApellido() != null) {
                            nombrecompleto = vacceso.getNombre() + " " + vacceso.getApellido();
                            System.out.println("nomre" + nombrecompleto);
                            bytesImagen = vacceso.getFotografia();
                            byte[] bytesLeidos = bytesImagen.getBytes(1, (int) bytesImagen.length());
                            BufferedImage img = null;
                            try {
                                img = ImageIO.read(new ByteArrayInputStream(bytesLeidos));
                            } catch (IOException ex) {
                                Logger.getLogger(JInternalacceso.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            imageicon = new ImageIcon(img);
                            Icon icono = new ImageIcon(imageicon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
                            lblimagen.setIcon(imageicon);
                            semaforo("verde");
                            lblpaso.setBackground(Color.GREEN);
                            lblnombre.setText(nombrecompleto);
                            lblhora.setText("Tu hora de entrada es: "+Generales.gethour());
                            //registro de entrdas descomentar las lineas de abajo 
                            horaentrada = Generales.getDateTime();
                            accesom = new Accesom(codtarjeta, horaentrada);
                            cvacceso.registraraccesocc(Conexion.obtener(), accesom);

                            inicial();

                        } else {
                            lblpaso.setBackground(Color.red);
                            semaforo("rojo");
                            lblnombre.setText("usuario no registrado o en situacion de baja ");
                            lblnombre.setForeground(Color.red);
                            lblimagen.setIcon(new ImageIcon(getClass().getResource("/iconos/sn.png")));
                            inicial();
                        }

//                  txttarjeta.setBackground(Color.GREEN);
//                 
//                   txttarjeta.setText("Registrada");
// arduino.killArduinoConnection();
                    } catch (SQLException ex) {
                        lblpaso.setBackground(Color.red);
                        semaforo("rojo");
                        Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        lblpaso.setBackground(Color.red);
                        semaforo("rojo");
                        Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SerialPortException | ArduinoException ex) {
                lblpaso.setBackground(Color.red);
                // txttarjeta.setBackground(Color.RED);

                //txttarjeta.setText("Ocurrio un problema");
            }
        }

    };
    
     private void inicial() {
        try {
            Thread.sleep(2300);
            lblnombre.setText("");
            lblhora.setText("");
            semaforo("amarillo");
            lblimagen.setIcon(new ImageIcon(getClass().getResource("/iconos/sn.png")));
        } catch (InterruptedException ex) {
            Logger.getLogger(Ralumnos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hilo");
        }

    }
     private void semaforo(String color) {
        String path = "/fondos/" + color + ".jpg";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(307, 382, Image.SCALE_DEFAULT));
        lblpaso.setIcon(icono);

    }

    /**
     * Creates new form JInternalaccesocc
     */
    public JInternalaccesocc() {
        initComponents();
        semaforo("amarillo");
        lblimagen.setVerticalAlignment(JLabel.CENTER);
        lblimagen.setHorizontalAlignment(JLabel.CENTER);
        lblnombre.setHorizontalAlignment(JLabel.CENTER);
        lblnombre.setVerticalAlignment(JLabel.CENTER);
        addInternalFrameListener(listener1);
        try {
            arduino.arduinoRXTX("COM4", 9600, listener);

        } catch (Exception ex) {
            Logger.getLogger(Ralumnos.class.getName()).log(Level.SEVERE, null, ex);

        }
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
        lblpaso = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblimagen = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Acceso centro de computo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido al centro de computo:");

        lblpaso.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblpaso.setOpaque(true);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblnombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblnombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sn.png"))); // NOI18N
        lblimagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblhora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblhora.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpaso, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblpaso, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblhora;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblpaso;
    // End of variables declaration//GEN-END:variables
}
