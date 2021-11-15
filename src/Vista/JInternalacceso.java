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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.JFrame;
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
public class JInternalacceso extends javax.swing.JInternalFrame {

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
                System.out.println("la conexion con arduino se cerro");
                arduino.killArduinoConnection();
            } catch (ArduinoException ex) {
                Logger.getLogger(JInternalacceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void internalFrameClosed(InternalFrameEvent e) {
            try {
                System.out.println("la conexion con arduino se cerro");
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

            //  arduino.arduinoRXTX("COM4", 9600, listener);
            System.out.println("frameacti");

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
                            Icon icono = new ImageIcon(imageicon.getImage().getScaledInstance(512, 384, Image.SCALE_DEFAULT));
                            lblimagen.setIcon(imageicon);
                            System.out.println(imageicon.getIconHeight());
                            System.out.println(imageicon.getIconWidth());
                            lblpaso.setBackground(Color.GREEN);
                            semaforo("verde");
                            lblnombre.setText(nombrecompleto);

                            //registro de entrdas descomentar las lineas de abajo 
                            horaentrada = Generales.getDateTime();
                            accesom = new Accesom(codtarjeta, horaentrada);
                            cvacceso.registraracceso(Conexion.obtener(), accesom);

                            inicial();

                        } else {
                            lblpaso.setBackground(Color.red);
                            lblnombre.setText("usuario no registrado o en situacion de baja ");
                            lblnombre.setForeground(Color.red);
                            semaforo("rojo");
                            lblimagen.setIcon(new ImageIcon(getClass().getResource("/iconos/sn.png")));
                            inicial();
                        }

                    } catch (SQLException ex) {
                        lblpaso.setBackground(Color.red);
                        Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        lblpaso.setBackground(Color.red);
                        Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SerialPortException | ArduinoException ex) {
                lblpaso.setBackground(Color.red);

            }
        }

    };

    /**
     * Creates new form JInternalacceso
     */
    public JInternalacceso() {
        initComponents();
        semaforo("amarillo");
        lblimagen.setHorizontalAlignment(JLabel.CENTER);
        lblimagen.setVerticalAlignment(JLabel.CENTER);
        lblnombre.setHorizontalAlignment(JLabel.CENTER);
        lblnombre.setVerticalAlignment(JLabel.CENTER);
        addInternalFrameListener(listener1);
        try {
            arduino.arduinoRXTX("COM4", 9600, listener);

        } catch (Exception ex) {
            Logger.getLogger(Ralumnos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void inicial() {
        try {
            Thread.sleep(2300);
            lblnombre.setText("");
            lblpaso.setBackground(Color.gray);
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

        setClosable(true);
        setIconifiable(true);
        setTitle("Acceso");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido:");

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblnombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblpaso.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblpaso.setOpaque(true);

        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sn.png"))); // NOI18N
        lblimagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(lblpaso, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblpaso, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblpaso;
    // End of variables declaration//GEN-END:variables

}
