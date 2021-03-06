/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Cbiblioteca;
import Controlador.Clibro;
import Controlador.Conexion;
import Modelo.Alta_libro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUÑOZ
 */
public class Jinternalalta_libro extends javax.swing.JInternalFrame {
String  nombre_libro, clasificacion, autor, edicion, isbn;
    int cod_libro;
    Alta_libro libro;
    Clibro clibro = new Clibro();
    
    
   DefaultTableModel modelo = new DefaultTableModel();
   List<Alta_libro> altasL = new ArrayList();
   Object[] lista = new Object[6];
   Object[] lista2 = new Object[6]; 
    Cbiblioteca biblioteca = new Cbiblioteca();
    
    /**
     * Creates new form Registro_libro
     */
    public Jinternalalta_libro() {
        initComponents();
        lista[0] = "Codigo";
        lista[1] ="Nombre del libro";
        lista[2] ="Clasificacion";
        lista[3] = "Autor";
        lista[4] = "Edicion";
        lista[5] = "ISBN";
        modelo.setColumnIdentifiers(lista);
        tbllibro.setModel(modelo);
        this.consulta();
    }
     public void consulta(){
       modelo.setRowCount(0);
       
    try {
       
        altasL = biblioteca.registro(Conexion.obtener());
        for (int i = 0; i < altasL.size() -1; i++) {
            lista2[0] = altasL.get(i).getId_libro();
            lista2[1] = altasL.get(i).getNombre_libro();
            lista2[2] = altasL.get(i).getClasificacion();
            lista2[3] = altasL.get(i).getAutor();
            lista2[4] = altasL.get(i).getEdicion();
            lista2[5] = altasL.get(i).getIsbn();
            modelo.addRow(lista2);
            
            
            tbllibro.setModel(modelo);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
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

        txtCodigo = new Vista.DiseñoCuadro();
        txtNombrelibro = new Vista.DiseñoCuadro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtclasificacion = new Vista.DiseñoCuadro();
        jLabel3 = new javax.swing.JLabel();
        txtautor = new Vista.DiseñoCuadro();
        jLabel4 = new javax.swing.JLabel();
        txtEdicion = new Vista.DiseñoCuadro();
        jLabel5 = new javax.swing.JLabel();
        txtIsbn = new Vista.DiseñoCuadro();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbllibro = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();

        setClosable(true);

        txtCodigo.setEnabled(false);

        txtNombrelibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrelibroActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo libro");

        jLabel2.setText("Nombre del libro");

        jLabel3.setText("Claificacion");

        jLabel4.setText("Autor");

        jLabel5.setText("Edicion");

        jLabel6.setText("ISBN");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");

        tbllibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbllibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbllibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbllibro);

        btnactualizar.setText("Actualizar");
        btnactualizar.setEnabled(false);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnactualizar)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2))
                    .addComponent(txtIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txtEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtautor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtclasificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombrelibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrelibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtclasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnactualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrelibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrelibroActionPerformed
        // TODO add your handling code here:
        
        if (txtNombrelibro.getText().equals("")) {
            System.out.println("falta dato");
        }else{
            long  a = Long.valueOf(txtNombrelibro.getText().trim());
                
       txtCodigo.setText(""+a);
        txtNombrelibro.setText("");
            System.out.println("Error de espacio"+a);
        }
        
    }//GEN-LAST:event_txtNombrelibroActionPerformed

   public void borrar(){
       txtCodigo.setText("");
       txtNombrelibro.setText("");
       txtclasificacion.setText("");
       txtautor.setText("");
       txtEdicion.setText("");
       txtIsbn.setText("");
   }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            cod_libro = Integer.valueOf(txtCodigo.getText());
            nombre_libro = txtNombrelibro.getText();
            clasificacion = txtclasificacion.getText();
            autor = txtautor.getText();
            edicion = txtEdicion.getText();
            isbn = txtIsbn.getText();
            libro = new Alta_libro(cod_libro, nombre_libro, clasificacion, autor,edicion, isbn );
            try{
                
                clibro.guardar(Conexion.obtener(), libro);
                this.borrar();
                JOptionPane.showMessageDialog(this, "Guardado");
                consulta();
            }catch(SQLException ex){
                System.out.println(""+ex);
                JOptionPane.showMessageDialog(this,"Hubo un error al insertar");
            } catch (ClassNotFoundException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbllibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbllibroMouseClicked
       String idlibro;
        int y = tbllibro.getSelectedRow();
        idlibro=String.valueOf(tbllibro.getValueAt(y, 0));
        
    try {
        libro=clibro.consulta_libro(Conexion.obtener(), Integer.parseInt(idlibro));
        txtCodigo.setText(String.valueOf(libro.getId_libro()));
        txtNombrelibro.setText(libro.getNombre_libro());
        txtclasificacion.setText(libro.getClasificacion());
        txtautor.setText(libro.getAutor());
        txtEdicion.setText(libro.getEdicion());
        txtIsbn.setText(libro.getIsbn());
        btnactualizar.setEnabled(true);
        jButton1.setEnabled(false);
    } catch (SQLException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_tbllibroMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        cod_libro = Integer.valueOf(txtCodigo.getText());
            nombre_libro = txtNombrelibro.getText();
            clasificacion = txtclasificacion.getText();
            autor = txtautor.getText();
            edicion = txtEdicion.getText();
            isbn = txtIsbn.getText();
        libro = new Alta_libro(cod_libro,nombre_libro,clasificacion,autor,edicion,isbn);
    try {
        clibro.actualizarlibro(Conexion.obtener(), libro);
        JOptionPane.showMessageDialog(this,
                            "Registro actualizado correctamente",
                            "Actualización de registro",
                            JOptionPane.INFORMATION_MESSAGE);
        jButton1.setEnabled(true);
        btnactualizar.setEnabled(false);
        borrar();
        consulta();
    } catch (SQLException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Jinternalalta_libro.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnactualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbllibro;
    private Vista.DiseñoCuadro txtCodigo;
    private Vista.DiseñoCuadro txtEdicion;
    private Vista.DiseñoCuadro txtIsbn;
    private Vista.DiseñoCuadro txtNombrelibro;
    private Vista.DiseñoCuadro txtautor;
    private Vista.DiseñoCuadro txtclasificacion;
    // End of variables declaration//GEN-END:variables
}
