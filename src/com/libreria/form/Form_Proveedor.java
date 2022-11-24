package com.libreria.form;

import com.libreria.model.ModelProveedor;
import com.libreria.model.StatusType;
import com.libreria.service.ServiceProveedor;
import com.libreria.swing.ScrollBar;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Form_Proveedor extends javax.swing.JPanel {

    private Form_IngresarProveedor formIngresarProveedor;
    public ArrayList<ModelProveedor> proveedores = ServiceProveedor.consultarProveedor();

    
    public Form_Proveedor() {
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        rellenaTabla(this.proveedores);
    }   
    
    public static void rellenaTabla(ArrayList<ModelProveedor> proveedores){
        
        limpiarTabla(table);
        
        if(!proveedores.isEmpty()){
            for(ModelProveedor proveedor : proveedores){         
               
                table.addRow(new Object[]{
                String.valueOf(proveedor.getRut()),
                String.valueOf(proveedor.getNombre()),
                String.valueOf(proveedor.getRazonSocial()),
                String.valueOf(proveedor.getCiudad()),
                String.valueOf(proveedor.getComuna()),
                String.valueOf(proveedor.getDireccion()),                
                String.valueOf(proveedor.getTelefono()),
                String.valueOf(proveedor.getGiro()),
                String.valueOf(proveedor.getCorreo()),
                });       
            }   
        }else{
            limpiarTabla(table);
        }
    }
    
    public static void limpiarTabla(com.libreria.swing.Table table){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new com.libreria.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new com.libreria.swing.Table();
        jLabel2 = new javax.swing.JLabel();
        btnEliminarProveedor = new javax.swing.JButton();
        btnFormProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(915, 600));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proveedores");
        jLabel1.setPreferredSize(new java.awt.Dimension(915, 600));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUT", "NOMBRE", "RAZÓN SOCIAL", "CIUDAD", "COMUNA", "DIRECCIÓN", "TELÉFONO", "GIRO", "CORREO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Marque un registro para actualizar o eliminar.");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(323, 323, 323))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEliminarProveedor.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarProveedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        btnFormProveedor.setBackground(new java.awt.Color(0, 51, 153));
        btnFormProveedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnFormProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnFormProveedor.setText("Ingresar Proveedor");
        btnFormProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormProveedorActionPerformed(evt);
            }
        });

        btnActualizarProveedor.setBackground(new java.awt.Color(0, 102, 255));
        btnActualizarProveedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnActualizarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProveedor.setText("Actualizar");
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFormProveedor)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFormProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
       if (table.getSelectedRow() != -1){
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);

            if (opcion == 0){
              ArrayList<ModelProveedor> newProveedores = ServiceProveedor.consultarProveedor();
              for (int i = 0; i < newProveedores.size(); i++) {
                    if(table.getSelectedRow() == i){
                        boolean result = ServiceProveedor.eliminarProveedor(newProveedores.get(i));
                         if (result){
                            JOptionPane.showMessageDialog(new JFrame(), "Eliminado exitosamente!");
                            ArrayList<ModelProveedor> prov = ServiceProveedor.consultarProveedor();
                            rellenaTabla(prov);
                         }        
                         else{
                            JOptionPane.showMessageDialog(new JFrame(), "Hubo un error al Eliminar!");
                        }
                    }   
                }  
            }
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnFormProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormProveedorActionPerformed
        formIngresarProveedor = new Form_IngresarProveedor();
        formIngresarProveedor.setVisible(true);
    }//GEN-LAST:event_btnFormProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
        ArrayList<ModelProveedor> newProveedores = ServiceProveedor.consultarProveedor();
        
        for (int i = 0; i < newProveedores.size(); i++) {
            if(table.getSelectedRow() == i){
                Form_ActualizarProveedor formActualizarProveedor = new Form_ActualizarProveedor(newProveedores.get(i));
                formActualizarProveedor.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnFormProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.libreria.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    public static com.libreria.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
