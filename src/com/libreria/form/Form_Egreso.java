/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.libreria.form;

import com.libreria.model.ModelEgreso;
import com.libreria.model.ModelProduct;
import com.libreria.service.ServiceProductos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Form_Egreso extends javax.swing.JPanel {
    
    private ModelProduct producto;
    private Form_Producto formProducto;
    
    private ServiceProductos sp;
    
    private ArrayList<ModelProduct> productos;
    private ArrayList<ModelProduct> productosFiltrados;
    private ArrayList<ModelEgreso> productosEgreso;
    
    private Double totalEgreso;
    private String txt;
    
    public Form_Egreso() {
        sp = new ServiceProductos();
        productos = sp.getAll();
        productosFiltrados = new ArrayList<>();
        productosEgreso = new ArrayList<>();
        
        formProducto = new Form_Producto();
        formProducto.setVisible(false);
        
        initComponents();
        formProducto.llenarTabla(tblProductos, productos);
    }
    
    public void addElementListEgreso(ModelProduct mp){
        //Map<String, ArrayList<ModelProduct>> articulos = new HashMap<>();
        boolean aumento = false;
        if(!productosEgreso.isEmpty()){
            for(ModelEgreso m : productosEgreso){
                if(m.getProducto().getCodigo().equals(mp.getCodigo())){
                    m.setCantidad(m.getCantidad() + 1);
                    aumento = true;
                }
            }
        }
        if(!aumento){
            ModelEgreso me = new ModelEgreso();
            Integer cantidad = 1;
            me.setProducto(mp);
            me.setCantidad(cantidad);
            productosEgreso.add(me);
        }
        updateTotal();
    }
    
    public void removeElementListEgreso(ModelEgreso me){
        for(ModelEgreso m : productosEgreso){
            if(m.getProducto().getCodigo().equals(me.getProducto().getCodigo())){
                m.setCantidad(m.getCantidad() - 1);
                if(m.getCantidad() == 0){
                    productosEgreso.remove(m);
                    break;
                }
            }
        }
        updateTotal();
    }
    
    private void updateTotal(){
        totalEgreso = 0.0;
        if(!productosEgreso.isEmpty()){
            for(ModelEgreso me : productosEgreso){
                totalEgreso += me.getProducto().getPrecio() * me.getCantidad();
            }
            formProducto.limpiarTabla(tblEgreso);
            llenarTablaEgreso(tblEgreso, productosEgreso);

            int total = (int) Math.round(totalEgreso);
            jlTotal.setText(String.valueOf(total));
        }else{
            formProducto.limpiarTabla(tblEgreso);
            jlTotal.setText("$ 0");
        }
        
    }
    
    public void llenarTablaEgreso(javax.swing.JTable tabla,ArrayList<ModelEgreso> lista){
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        formProducto.limpiarTabla(tabla);
        for(ModelEgreso me : lista){
            dtm.addRow(new Object[]{
                me.getProducto().getCodigo(),
                me.getProducto().getNombre(),
                me.getProducto().getPrecio(),
                me.getCantidad()
            });
        }
        tabla.setModel(dtm);   
    }
    
    public void generarEgreso(ArrayList<ModelEgreso> listEgreso){
        for(ModelEgreso me : listEgreso){
            for(ModelProduct mp : productos){
                if(mp.getId() == me.getProducto().getId()){
                    mp.setStock(mp.getStock() - me.getCantidad());
                    System.out.println("id: "+me.getProducto().getId());
                }
            }
        }
        productosEgreso.clear();
        updateTotal();
        formProducto.limpiarTabla(tblProductos);
        formProducto.llenarTabla(tblProductos, productos);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        etDescripcion = new javax.swing.JTextArea();
        jlabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEgreso = new javax.swing.JTable();
        btnAgregarItem = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Egreso");

        etBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etBuscarKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Buscar");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        etDescripcion.setColumns(20);
        etDescripcion.setRows(5);
        jScrollPane2.setViewportView(etDescripcion);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setText("Total");

        jlTotal.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jlTotal.setText("$ 0");

        jButton1.setBackground(new java.awt.Color(0, 236, 0));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generar Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(152, 152, 152)
                        .addComponent(jlTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jlTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tblEgreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEgreso);

        btnAgregarItem.setBackground(new java.awt.Color(0, 255, 0));
        btnAgregarItem.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarItem.setText("Agregar");
        btnAgregarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItemActionPerformed(evt);
            }
        });

        btnQuitarProducto.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarProducto.setText("Quitar");
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnQuitarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnAgregarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void etBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etBuscarKeyReleased
        try 
        {   
            productosFiltrados.clear();
            txt = etBuscar.getText().toUpperCase();
            if(!productos.equals(null)){
                for(ModelProduct p : productos){
                    if((p.getNombre()).toUpperCase().contains(txt)
                            || p.getCodigo().toUpperCase().contains(txt))
                    {
                       productosFiltrados.add(p);
                    }                  
                }
            }
            if(!productosFiltrados.isEmpty()){
                formProducto.limpiarTabla(tblProductos); 
                formProducto.llenarTabla(tblProductos, productosFiltrados);
            }
        } catch (Exception e) {
            System.err.println("Error\n---> "+e);
        }
    }//GEN-LAST:event_etBuscarKeyReleased

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        if(tblProductos.getSelectedRow() != -1){
          String valor = (String) tblProductos.getValueAt(tblProductos.getSelectedRow(),0);
          for(ModelProduct mp : productos){
              if(mp.getCodigo().equals(valor)){
                  etDescripcion.setText(mp.getDescripcion());
              }
          }
      }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarItemActionPerformed
        if(tblProductos.getSelectedRow() != -1 ){
            String valor = (String) tblProductos.getValueAt(tblProductos.getSelectedRow(),0);
            for(ModelProduct mp : productos){
                if(mp.getCodigo().equals(valor)){
                    addElementListEgreso(mp);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarItemActionPerformed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        if(tblEgreso.getSelectedRow() != -1){
            String valor = (String) tblEgreso.getValueAt(tblEgreso.getSelectedRow(), 0);
            for(ModelEgreso me : productosEgreso){
                if(me.getProducto().getCodigo().equals(valor)){
                    removeElementListEgreso(me);
                }
            }
        }
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!productosEgreso.isEmpty()){
            generarEgreso(productosEgreso);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarItem;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JTextField etBuscar;
    private javax.swing.JTextArea etDescripcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTable tblEgreso;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
