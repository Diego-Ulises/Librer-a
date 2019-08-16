package com.layout;

import com.Serv_Inter.CLASECLIENTES;
import com.Serv_Inter.CLASEEMPRESA;
import javax.swing.JOptionPane;
import com.Serv_Inter.Handler;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class RegCliente1 extends javax.swing.JFrame {

    private ArrayList<CLASECLIENTES> clientes;
    private ArrayList<CLASEEMPRESA> empresas;
    private Handler handler;

    public RegCliente1() {
        initComponents();
        init();
        jButtonEliminar.setEnabled(true);
        handler = new Handler();
        updateArrays();
        updateClientes();
        updateEmpresas();
        this.setLocationRelativeTo(null);
    }

    private void updateArrays() {
        clientes = handler.showClientes();
        empresas = handler.showEmpresas();
    }

    private void updateClientes() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        for (int i = (model.getRowCount()); i < clientes.size(); i++) {
            CLASECLIENTES tmp = clientes.get(i);
            Object[] rowData = new Object[]{tmp.getNoContrato(), tmp.getNombre(), tmp.getApellidoP(), tmp.getApellidoM(), tmp.getDireccion(), tmp.getStatus(), tmp.getIDEMPRESA()};
            model.addRow(rowData);
        }
        jTable1.updateUI();
    }

    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jMenu1 = new javax.swing.JMenu();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          ApellidoPat = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jButtonAgregar = new javax.swing.JButton();
          ApellidoP = new javax.swing.JTextField();
          ApellidoM = new javax.swing.JTextField();
          Direccion = new javax.swing.JTextField();
          Status = new javax.swing.JTextField();
          jScrollPane1 = new javax.swing.JScrollPane();
          jTable1 = new javax.swing.JTable();
          NoContrato = new javax.swing.JTextField();
          Nombre = new javax.swing.JTextField();
          jButtonEliminar = new javax.swing.JButton();
          jComboBoxEmpresas = new javax.swing.JComboBox<>();
          Modificar = new javax.swing.JButton();
          jLabel3 = new javax.swing.JLabel();
          checkbox1 = new java.awt.Checkbox();
          checkbox2 = new java.awt.Checkbox();
          checkbox3 = new java.awt.Checkbox();
          checkbox4 = new java.awt.Checkbox();
          checkbox5 = new java.awt.Checkbox();
          checkbox6 = new java.awt.Checkbox();
          checkbox7 = new java.awt.Checkbox();
          jLabel8 = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          jLabel10 = new javax.swing.JLabel();
          jLabel11 = new javax.swing.JLabel();
          jComboBox1 = new javax.swing.JComboBox<>();
          jComboBox2 = new javax.swing.JComboBox<>();
          jComboBox3 = new javax.swing.JComboBox<>();
          jMenuBar1 = new javax.swing.JMenuBar();
          jMenu2 = new javax.swing.JMenu();
          jMenu3 = new javax.swing.JMenu();

          jMenu1.setText("jMenu1");

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("Gestion de Cuentas");
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowClosed(java.awt.event.WindowEvent evt) {
                    formWindowClosed(evt);
               }
          });

          jLabel1.setText("No Tarjeta");

          jLabel2.setText("Nombre");

          ApellidoPat.setText("ApellidoP");

          jLabel4.setText("ApellidoM");

          jLabel5.setText("Direccion");

          jLabel6.setText("Tipo de cuenta");

          jLabel7.setText("Saldo");

          jButtonAgregar.setText("Agregar");
          jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonAgregarActionPerformed(evt);
               }
          });

          ApellidoP.setName("ApellidoP"); // NOI18N

          ApellidoM.setName("ApellidoM"); // NOI18N

          Direccion.setName("Direccion"); // NOI18N

          Status.setName("Status"); // NOI18N

          jTable1.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "No Tarjeta", "Nombre", "ApellidoP", "ApellidoM", "Direccion", "Tipo de Cuenta", "Saldo"
               }
          ) {
               Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
               };

               public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
               }
          });
          jScrollPane1.setViewportView(jTable1);

          NoContrato.setName("NoContrato"); // NOI18N

          Nombre.setName("Nombre"); // NOI18N

          jButtonEliminar.setText("Eliminar");
          jButtonEliminar.setEnabled(false);
          jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonEliminarActionPerformed(evt);
               }
          });

          jComboBoxEmpresas.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBoxEmpresasActionPerformed(evt);
               }
          });

          Modificar.setText("Modificar");
          Modificar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ModificarActionPerformed(evt);
               }
          });

          jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
          jLabel3.setText("Datos Personales:");

          jLabel8.setText("Cuentas");

          jLabel9.setText("Nombre de Banco");

          jLabel10.setText("Codigo de Banco");

          jLabel11.setText("Codigo de Sucursal");

          jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un caja de ahorro", "Item 2", "Item 3", "Item 4" }));

          jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Item 3", "Item 4" }));

          jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una sucursal", "Item 2", "Item 3", "Item 4" }));

          jMenu2.setText("Guardar");
          jMenuBar1.add(jMenu2);

          jMenu3.setText("Volver");
          jMenuBar1.add(jMenu3);

          setJMenuBar(jMenuBar1);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(jLabel3)
                              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(checkbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(checkbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(checkbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(checkbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(ApellidoPat)
                                        .addComponent(jLabel2))
                                   .addComponent(jLabel1))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(NoContrato)
                                   .addComponent(ApellidoP, javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(ApellidoM, javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(Direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(Status, javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(Nombre)
                                   .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createSequentialGroup()
                                                  .addGap(42, 42, 42)
                                                  .addComponent(Modificar)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                  .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addComponent(jLabel8)
                                                       .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(116, 116, 116))
                                   .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                             .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                             .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                             .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                             .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                             .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                             .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel9)
                                   .addComponent(jLabel10)
                                   .addComponent(jLabel11))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(30, 30, 30)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(Modificar)
                                   .addComponent(jButtonAgregar)
                                   .addComponent(jButtonEliminar)))
                         .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(NoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jLabel2)
                                             .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(ApellidoPat)
                                             .addComponent(ApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jLabel4)
                                             .addComponent(ApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jLabel5)
                                             .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jLabel6)
                                             .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jLabel7)
                                             .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        try {
            String NombreEmpresa =  ((String) jComboBoxEmpresas.getSelectedItem());
             
            handler.AltaCliente(Integer.parseInt(NoContrato.getText()), Nombre.getText(), ApellidoP.getText(), ApellidoM.getText(), Direccion.getText(), Status.getText(), NombreEmpresa);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Revise los campos", "Error al registrar", JOptionPane.ERROR_MESSAGE);
        }
        updateArrays();
        updateClientes();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int toDelete = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int CveCliente = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        handler.BajaCliente(CveCliente);
        model.removeRow(toDelete);
        updateArrays();
        updateClientes();
    }//GEN-LAST:event_jButtonEliminarActionPerformed
    private void updateEmpresas() {
        jComboBoxEmpresas.removeAllItems();
        for (int i = 0; i < empresas.size(); i++) {
            CLASEEMPRESA tmp = empresas.get(i);
            jComboBoxEmpresas.addItem("" + tmp.getNombre());
        }
        jComboBoxEmpresas.updateUI();
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new Principal().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

        try{
            handler.UpClientes(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()), 
                    jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(), jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString(), 
                    jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString(), jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString(), 
                    jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString(), jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            System.out.println(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No su pudo actualizar la información");
        }
        updateArrays();
        updateClientes();

    }//GEN-LAST:event_ModificarActionPerformed

    private void jComboBoxEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmpresasActionPerformed

    public void init() {
        this.setVisible(true);
    }


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JTextField ApellidoM;
     private javax.swing.JTextField ApellidoP;
     private javax.swing.JLabel ApellidoPat;
     private javax.swing.JTextField Direccion;
     private javax.swing.JButton Modificar;
     private javax.swing.JTextField NoContrato;
     private javax.swing.JTextField Nombre;
     private javax.swing.JTextField Status;
     private java.awt.Checkbox checkbox1;
     private java.awt.Checkbox checkbox2;
     private java.awt.Checkbox checkbox3;
     private java.awt.Checkbox checkbox4;
     private java.awt.Checkbox checkbox5;
     private java.awt.Checkbox checkbox6;
     private java.awt.Checkbox checkbox7;
     private javax.swing.JButton jButtonAgregar;
     private javax.swing.JButton jButtonEliminar;
     private javax.swing.JComboBox<String> jComboBox1;
     private javax.swing.JComboBox<String> jComboBox2;
     private javax.swing.JComboBox<String> jComboBox3;
     private javax.swing.JComboBox<String> jComboBoxEmpresas;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenu jMenu3;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JTable jTable1;
     // End of variables declaration//GEN-END:variables
}
