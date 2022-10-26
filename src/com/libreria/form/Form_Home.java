package com.libreria.form;

import com.libreria.model.ModelCard;
import com.libreria.model.ModelProduct;
import com.libreria.service.ServiceProductos;
import com.libreria.swing.ScrollBar;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {
    
    ArrayList<ModelProduct> productos = ServiceProductos.getAllProductos();

    public Form_Home() {
        initComponents();
        card1.setData(new ModelCard(new ImageIcon(getClass().getResource("/com/libreria/icon/stock.png")), "Stock Total", "$200000", "Increased by 60%"));
        card2.setData(new ModelCard(new ImageIcon(getClass().getResource("/com/libreria/icon/profit.png")), "Total Profit", "$15000", "Increased by 25%"));
        card3.setData(new ModelCard(new ImageIcon(getClass().getResource("/com/libreria/icon/flag.png")), "Unique Visitors", "$300000", "Increased by 70%"));
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        pintarTabla(this.productos);
    }   
    
    public void pintarTabla(ArrayList<ModelProduct> productos){
        
        
        if(productos.isEmpty()){System.out.println("Lista Vacia");}
        else{
            for(ModelProduct producto : productos){
               
               table.addRow(new Object[]{
               String.valueOf(producto.getId()),
               String.valueOf(producto.getCodigo()),
               String.valueOf(producto.getDescripcion()),
               String.valueOf(producto.getPrecio()),
               String.valueOf(producto.getStock()),
               String.valueOf(producto.getProveedor()),
               String.valueOf(producto.getMarca())});
                
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.libreria.component.Card();
        card2 = new com.libreria.component.Card();
        card3 = new com.libreria.component.Card();
        panelBorder1 = new com.libreria.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new com.libreria.swing.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PRECIO", "STOCK", "PROVEEDOR", "MARCA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.libreria.component.Card card1;
    private com.libreria.component.Card card2;
    private com.libreria.component.Card card3;
    private javax.swing.JLayeredPane panel;
    private com.libreria.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    public com.libreria.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
