package com.libreria.form;

import javax.swing.JLabel;


public class IngresarProducto extends javax.swing.JPanel {

    JLabel nombre = new JLabel();

    public IngresarProducto() {
        initComponents();
        
        nombre.setText("Nombre");
        PanelIngresoProducto.add(nombre);
        PanelIngresoProducto.setVisible(true);
    }   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PanelIngresoProducto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(915, 600));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresar Producto");

        jLabel2.setText("HOOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        jLabel3.setText("adios");

        javax.swing.GroupLayout PanelIngresoProductoLayout = new javax.swing.GroupLayout(PanelIngresoProducto);
        PanelIngresoProducto.setLayout(PanelIngresoProductoLayout);
        PanelIngresoProductoLayout.setHorizontalGroup(
            PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel2))
                    .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(jLabel3)))
                .addContainerGap(393, Short.MAX_VALUE))
        );
        PanelIngresoProductoLayout.setVerticalGroup(
            PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel2)
                .addGap(86, 86, 86)
                .addComponent(jLabel3)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(PanelIngresoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(PanelIngresoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelIngresoProducto;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
