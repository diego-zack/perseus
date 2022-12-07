package com.libreria.form;

import com.libreria.connection.Conexion;
import com.libreria.connection.DatabaseConnection;
import static com.libreria.form.asfddfadfs.tblDatos;
import com.libreria.main.RenderImagen;
import com.libreria.model.ModelProduct;
import com.libreria.model.ModelTipoProducto;
import com.libreria.service.ServiceProductos;



import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Form_Producto extends javax.swing.JPanel {
    
    private ArrayList<ModelProduct> productos,productosFiltrados;
    Conexion con = new Conexion();
    DatabaseConnection can;
    private ServiceProductos sp;
    DefaultTableModel mModeloTabla = new DefaultTableModel();
    private String txt;
    private Form_IngresarProducto formIngresarProducto;
//    private ModelProduct producto;
    public Form_Producto() {
        initComponents();
        mModeloTabla.addColumn("ID");
        mModeloTabla.addColumn("Nombre");
        mModeloTabla.addColumn("Codigo");
        mModeloTabla.addColumn("Stock");
        mModeloTabla.addColumn("Precio");
        mModeloTabla.addColumn("Imagen");
        productosFiltrados = new ArrayList();
        recargar();
        
    }
    public void recargar(){
        sp = new ServiceProductos();
        productos = sp.getAll();
        limpiarTabla(tblDatos);
        llenarTabla(tblDatos, productos);
    }
    public void llenarTabla(javax.swing.JTable tabla,ArrayList<ModelProduct> productos){ 
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        tblDatos.setDefaultRenderer(Object.class, new RenderImagen());
        limpiarTabla(tabla); 
        Object Datos[] = new Object[5];
        
        for(ModelProduct mp : productos){
            Datos[0] = mp.getCodigo();
            Datos[1] = mp.getNombre();
            Datos[2] = String.valueOf(mp.getStock());
            Datos[3] = String.valueOf(mp.getPrecio());
            try {
                        byte[] imagen = mp.getImagen();
                        BufferedImage bufferedImage = null;
                        InputStream inputStream = new ByteArrayInputStream(imagen);
                        bufferedImage = ImageIO.read(inputStream);
                        ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(150, 150, 0));
                        Datos[4] = new JLabel(mIcono);
                    } catch (Exception e) {
                        Datos[4] = new JLabel("No imagen");
                    }
            
            dtm.addRow(Datos);
        }
        tabla.setModel(dtm);
        tblDatos.setRowHeight(120);
        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblDatos.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblDatos.getColumnModel().getColumn(2).setPreferredWidth(10);
        tblDatos.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblDatos.getColumnModel().getColumn(4).setPreferredWidth(10);
    }
    public void limpiarTabla(javax.swing.JTable tabla){
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for(int i=0;i < dtm.getRowCount();i++){
            dtm.removeRow(i);
        }
    }
    
    
//    private void CargarImagenes(ArrayList<ModelProduct> productos) {
//        tblImagenes.setDefaultRenderer(Object.class, new RenderImagen());
//        //limpiarTabla(tabla);
//        ModelProduct producto;
//        sp = new ServiceProductos();
//        
//            Object Datos[] = new Object[6];
//            
//            
//            if (productos != null) {
//                for (int i = 0; i < productos.size(); i++) {
//                    producto = (ModelProduct) productos.get(i);
//                    Datos[0] = String.valueOf(producto.getId());
//                    Datos[1] = producto.getNombre();
//                    Datos[2] = producto.getCodigo();
//                    Datos[3] = String.valueOf(producto.getStock());
//                    Datos[4] = String.valueOf(producto.getPrecio());
//                    
//                    try {
//                        byte[] imagen = producto.getImagen();
//                        BufferedImage bufferedImage = null;
//                        InputStream inputStream = new ByteArrayInputStream(imagen);
//                        bufferedImage = ImageIO.read(inputStream);
//                        ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(150, 150, 0));
//                        Datos[5] = new JLabel(mIcono);
//                    } catch (Exception e) {
//                        Datos[5] = new JLabel("No imagen");
//                    }
//                    
//                    
//                    mModeloTabla.addRow(Datos);
//                }
//
//                tblImagenes.setModel(mModeloTabla);
//                tblImagenes.setRowHeight(120);
//                tblImagenes.getColumnModel().getColumn(0).setPreferredWidth(10);
//                tblImagenes.getColumnModel().getColumn(1).setPreferredWidth(40);
//                tblImagenes.getColumnModel().getColumn(2).setPreferredWidth(10);
//                tblImagenes.getColumnModel().getColumn(3).setPreferredWidth(10);
//                tblImagenes.getColumnModel().getColumn(4).setPreferredWidth(10);
//                tblImagenes.getColumnModel().getColumn(5).setPreferredWidth(100);
//            }
//        
//    }
    /*private void Limpiar() {
        for (int i = 0; i < tblImagenes.getRowCount(); i++) {
            mModeloTabla.removeRow(i);
            i -= 1;
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        etBuscarCategoria = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        etBuscar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Buscar:");

        etBuscarCategoria.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        etBuscarCategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etBuscarCategoriaActionPerformed(evt);
            }
        });
        etBuscarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etBuscarCategoriaKeyReleased(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(102, 102, 255));
        btnIngresar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(102, 102, 255));
        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Editar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos");

        tblDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblDatos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock", "Precio", "Imagen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Categoria");

        etBuscar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        etBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etBuscarActionPerformed(evt);
            }
        });
        etBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(etBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(etBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(322, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etBuscarCategoria)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etBuscar))
                .addGap(462, 462, 462)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnModificar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void etBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etBuscarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etBuscarCategoriaActionPerformed

    private void etBuscarCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etBuscarCategoriaKeyReleased
        // TODO add your handling code here:
        try
        {
            productosFiltrados.clear();
            txt = etBuscarCategoria.getText().toUpperCase();
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
                limpiarTabla(tblDatos);
                llenarTabla(tblDatos, productosFiltrados);
            }
        } catch (Exception e) {
            System.err.println("Error\n---> "+e);
        }
    }//GEN-LAST:event_etBuscarCategoriaKeyReleased

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        formIngresarProducto = new Form_IngresarProducto();
        formIngresarProducto.setVisible(true);
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tblDatos.getSelectedRow() != -1){
            String valor1 = (String) tblDatos.getValueAt(tblDatos.getSelectedRow(), 0);
    //        temporal tm = new temporal();
    //        tm.setTexto(valor);
            Form_IngresarProducto formIngresarProducto = new Form_IngresarProducto();
            formIngresarProducto.setVisible(true);
            for(ModelProduct p : productos){
                if(p.getCodigo().toUpperCase().equals(valor1.toUpperCase())){
                    formIngresarProducto.llenarFormulario(p);
                }
                
            }
        
        }
        
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatosMouseClicked

    private void etBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etBuscarActionPerformed

    private void etBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etBuscarKeyReleased
        try
        {
            productosFiltrados.clear();
            txt = etBuscarCategoria.getText().toUpperCase();
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
                limpiarTabla(tblDatos);
                llenarTabla(tblDatos, productosFiltrados);
            }
        } catch (Exception e) {
            System.err.println("Error\n---> "+e);
        }
    }//GEN-LAST:event_etBuscarKeyReleased

//    public void llenarTabla(javax.swing.JTable tabla,ArrayList<ModelProduct> productos){ 
//        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
//        limpiarTabla(tabla); 
//        
//        for(ModelProduct mp : productos){
//            dtm.addRow(new Object[]{
//                String.valueOf(mp.getId()),
//                String.valueOf(mp.getNombre()),
//                String.valueOf(mp.getCodigo()),
//                String.valueOf(mp.getStock()),
//                String.valueOf(mp.getPrecio()),
//                mp.getImagen(),
//                
//            } );
//        }
//        tabla.setModel(dtm);
//    }
//    public void limpiarTabla(javax.swing.JTable tabla){
//        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
//        for(int i=0;i < dtm.getRowCount();i++){
//            dtm.removeRow(i);
//        }
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField etBuscar;
    private javax.swing.JTextField etBuscarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
