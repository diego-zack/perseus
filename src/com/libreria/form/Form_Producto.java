package com.libreria.form;

import com.libreria.model.ModelMarca;
import com.libreria.model.ModelProduct;
import com.libreria.model.ModelProveedor;
import com.libreria.model.ModelTipoProducto;
import com.libreria.model.ModelTipoUnidad;
import com.libreria.service.ServiceMarca;
import com.libreria.service.ServiceProductos;
import com.libreria.service.ServiceProveedor;
import com.libreria.service.ServiceTipoProducto;
import com.libreria.service.ServiceTipoUnidad;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Form_Producto extends javax.swing.JPanel {
    
    private ArrayList<ModelProduct> productos,productosFiltrados;
    private ArrayList<ModelTipoProducto> listTipoProducto;
    private ArrayList<ModelMarca> listMarca;
    private  ArrayList<ModelProveedor> listProveedor;
    private ArrayList<ModelTipoUnidad> listTipoUnidad;
    
    private ModelProduct producto;
    private ModelTipoProducto modelTipoProducto;
    private ModelMarca modelMarca;
    private ModelProveedor modelProveedor;
    private ModelTipoUnidad modelTipoUnidad;
    
    private ServiceProductos sp;
    private ServiceTipoProducto stp;
    private ServiceMarca sm;
    private ServiceTipoUnidad stu;
    
    private String nombre;
    private String codigo;
    private String precio;
    private String stock;
    private String unidad;
    private String modelo;
    private String descripcion;
    private String imagen;
    
    private String txt;
    private int id;
    String Ruta = "";
  
    public Form_Producto() {
        stp = new ServiceTipoProducto();
        sm = new ServiceMarca();
        stu = new ServiceTipoUnidad();
        
        listTipoProducto = stp.getAll();
        listMarca = sm.getAll();
        listProveedor = ServiceProveedor.consultarProveedor();
        listTipoUnidad = stu.getAll();
        
        productosFiltrados = new ArrayList();
        
        initComponents();
        btnGuardarCambios.setVisible(false);
        recargar();
        llenarcbTP(); //Llenar comboBox TipoProducto
        llenarcbM(); //Llenar comboBox Marca
        llenarcbP(); //Llenar comboBox Proveedor
        llenarcbTU(); //Llenar combobox TipoUnidad 
    }
    public void recargar(){
        sp = new ServiceProductos();
        productos = sp.getAll();
        limpiarTabla(tblDatos);
        llenarTabla(tblDatos, productos);
    }
    
    public void llenarTabla(javax.swing.JTable tabla,ArrayList<ModelProduct> productos){ 
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        limpiarTabla(tabla); 
        
        for(ModelProduct mp : productos){
            dtm.addRow(new Object[]{
                String.valueOf(mp.getCodigo()),
                String.valueOf(mp.getNombre()),
                String.valueOf(mp.getStock()),
                String.valueOf(mp.getPrecio())
            } );
        }
        tabla.setModel(dtm);
    }
    
    public void llenarcbTP(){
       cbTipoProducto.insertItemAt("-", 0);
       if(!listTipoProducto.isEmpty()){
           for(ModelTipoProducto tp : listTipoProducto){
               cbTipoProducto.insertItemAt(tp.getNombre(),tp.getId());
           }
       }
       cbTipoProducto.setSelectedIndex(0);
    }
    
    public void llenarcbM(){
        cbMarca.insertItemAt("-", 0);
        if(!listMarca.isEmpty()){
            for(ModelMarca mm : listMarca){
                cbMarca.insertItemAt(mm.getNombre(), mm.getId());
            }
        }
        cbMarca.setSelectedIndex(0);
    }
    
    public void llenarcbP(){
        cbProveedor.insertItemAt("-", 0);
        if(!listProveedor.isEmpty()){
            for(ModelProveedor mp : listProveedor){
                cbProveedor.insertItemAt(mp.getNombre(), mp.getId());
            }
        }        
        cbProveedor.setSelectedIndex(0);
    }
    
    public void llenarcbTU(){
        cbTipoUnidad.insertItemAt("-",0);
        if(!listTipoUnidad.isEmpty()){
            for(ModelTipoUnidad mtu : listTipoUnidad){
                cbTipoUnidad.insertItemAt(mtu.getNombre(), mtu.getId());
            }
        }
        cbTipoUnidad.setSelectedIndex(0);
    }
    
    public void limpiarFormulario()
    {
        etNombre.setText("");
        etCodigo.setText("");
        etPrecio.setText("");
        etStock.setText("");
        etUnidad.setText("");
        etModelo.setText("");
        etDescripcion.setText("");
        cbMarca.setSelectedIndex(0);
        cbTipoProducto.setSelectedIndex(0);
        cbProveedor.setSelectedIndex(0);
        cbTipoUnidad.setSelectedIndex(0);
        btnIngresar.setVisible(true);
        btnGuardarCambios.setVisible(false);
    }
    public void llenarFormulario(ModelProduct p){
        etNombre.setText(p.getNombre());
        etCodigo.setText(p.getCodigo());
        etPrecio.setText(String.valueOf(p.getPrecio()));
        etStock.setText(String.valueOf(p.getStock()));
        etUnidad.setText(String.valueOf(p.getUnidad()));
        etModelo.setText(p.getModelo());
        etDescripcion.setText(p.getDescripcion());
        cbMarca.setSelectedIndex(p.getMarca());
        cbTipoProducto.setSelectedIndex(p.getTipoProducto());
        cbProveedor.setSelectedIndex(p.getProveedor());
        cbTipoUnidad.setSelectedIndex(p.getTipoUnidad());
    }
    
    public void limpiarTabla(javax.swing.JTable tabla){
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for(int i=0;i < dtm.getRowCount();i++){
            dtm.removeRow(i);
        }
    }
    public static Boolean esNumero(String s){
        try{
            Double d = Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public Boolean productoExiste(ModelProduct p){
        Boolean esta = false;
        for(ModelProduct mp : productos){
            if(mp.getCodigo().toUpperCase().equals(p.getCodigo())){
                esta = true;
            }
        }
        return esta;
    }
    public ModelProduct crearProducto(){
        Boolean esta = false;
        
        nombre = etNombre.getText().toUpperCase();
        codigo = etCodigo.getText().toUpperCase();    
        precio = etPrecio.getText().toUpperCase();
        stock = etStock.getText().toUpperCase();
        
        if(nombre.length() > 0 && codigo.length() > 0 && precio.length() > 0 && stock.length() > 0 && 
           !(modelMarca == null || modelProveedor == null || modelTipoProducto == null|| modelTipoUnidad == null)){
            
            unidad = (etUnidad.getText().length() > 0 )?etUnidad.getText().toUpperCase():"0";
            modelo = (etModelo.getText().length() > 0)?etModelo.getText().toUpperCase():"";
            descripcion = (etDescripcion.getText().length() > 0)?etDescripcion.getText().toUpperCase():"";
            
            producto = new ModelProduct();
            producto.setNombre(nombre);
            producto.setCodigo(codigo);
            producto.setModelo(modelo);
            producto.setDescripcion(descripcion);
            producto.setMarca(modelMarca.getId());
            producto.setProveedor(modelProveedor.getId());
            producto.setTipoProducto(modelTipoProducto.getId());
            producto.setTipoUnidad(modelTipoUnidad.getId());
            producto.setUnidad((esNumero(unidad))?Double.valueOf(unidad):0);
            producto.setStock((esNumero(stock))?Integer.parseInt(stock):0);
            producto.setPrecio((esNumero(precio))?Double.valueOf(precio):0.0);                
            producto.setFoto(1);
            producto.setImagen(getImagen(Ruta));
 
        }else{
            JOptionPane.showMessageDialog(this, "Rellene los campos obligatorios");
        }
        return producto;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private byte[] getImagen(String Ruta) {
        File imagen = new File(Ruta);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        } catch (Exception ex) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        etBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        PanelIngresoProducto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etCodigo = new javax.swing.JTextField();
        etNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbTipoProducto = new javax.swing.JComboBox<>();
        cbMarca = new javax.swing.JComboBox<>();
        cbProveedor = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbTipoUnidad = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        etStock = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        etUnidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        etModelo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        etDescripcion = new javax.swing.JTextArea();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnGuardarCambios = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblDatos.setForeground(new java.awt.Color(255, 153, 0));
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Buscar:");

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

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos");

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 255));
        btnLimpiar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        PanelIngresoProducto.setBackground(new java.awt.Color(255, 255, 255));
        PanelIngresoProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("* Código:");

        etCodigo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        etCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        etNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        etNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("* Nombre:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("* Precio:");

        etPrecio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        etPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("* Tipo Prod:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("* Marca:");

        cbTipoProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoProductoActionPerformed(evt);
            }
        });

        cbMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMarcaActionPerformed(evt);
            }
        });

        cbProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("* Proveedor:");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Foto:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Examinar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("* Tipo Unidad:");

        cbTipoUnidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTipoUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoUnidadActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(101, 101, 101));
        jLabel12.setText("* Stock:");

        etStock.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(101, 101, 101));
        jLabel13.setText("Unidad:");

        etUnidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(101, 101, 101));
        jLabel14.setText("Modelo:");

        etModelo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(101, 101, 101));
        jLabel15.setText("Descripcion:");

        etDescripcion.setColumns(10);
        etDescripcion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        etDescripcion.setRows(4);
        jScrollPane2.setViewportView(etDescripcion);

        javax.swing.GroupLayout PanelIngresoProductoLayout = new javax.swing.GroupLayout(PanelIngresoProducto);
        PanelIngresoProducto.setLayout(PanelIngresoProductoLayout);
        PanelIngresoProductoLayout.setHorizontalGroup(
            PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoProductoLayout.createSequentialGroup()
                        .addComponent(etPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etStock, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                        .addComponent(cbTipoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTipoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etNombre)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etModelo)
                    .addComponent(jScrollPane2)
                    .addComponent(etCodigo))
                .addGap(33, 33, 33))
        );
        PanelIngresoProductoLayout.setVerticalGroup(
            PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresoProductoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etNombre))
                .addGap(16, 16, 16)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbTipoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(etModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelIngresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnModificar.setBackground(new java.awt.Color(102, 102, 255));
        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Editar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 255));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        jLabel16.setText("Campos marcados con ( * ) son obligatorios para ingresar un producto");

        btnGuardarCambios.setBackground(new java.awt.Color(102, 102, 255));
        btnGuardarCambios.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarCambios))
                            .addComponent(PanelIngresoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etBuscar))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelIngresoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnIngresar)
                        .addComponent(btnLimpiar)
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tblDatos.getSelectedRow() != -1){
           String valor = (String) tblDatos.getValueAt(tblDatos.getSelectedRow(), 0);
           for(ModelProduct mp : productos){
               if(mp.getCodigo().toUpperCase().equals(valor.toUpperCase())){
                   llenarFormulario(mp);
                   id = mp.getId();
               }
           }
        }
        btnIngresar.setVisible(false);
        btnGuardarCambios.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(tblDatos.getSelectedRow() != -1){
            String valor = (String) tblDatos.getValueAt(tblDatos.getSelectedRow(), 0);
            for(ModelProduct mp : productos){
                if(mp.getCodigo().toUpperCase().equals(valor.toUpperCase())){
                   Boolean i = sp.eliminarProducto(mp);
                   if(i){
                       JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                       limpiarFormulario();
                       recargar();
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "Error al eliminar, contacte a su proveedor");
                   }
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Boolean listo = false;
        ModelProduct p = crearProducto();
        
        if(p != null){
            if(!productoExiste(p)){
                listo = sp.insertProducto(p);
                if(listo){
                    JOptionPane.showMessageDialog(this, "producto se registro exitosamente");
                    limpiarFormulario();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al ingresar el producto, llame a soporte");
                }
            }
            JOptionPane.showMessageDialog(this,"El producto ya esta registrado\nSi desea actualizar puede buscar con el codigo\n"+p.getCodigo());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void etBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etBuscarKeyReleased
        // TODO add your handling code here:
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
                limpiarTabla(tblDatos); 
                llenarTabla(tblDatos, productosFiltrados);
            }
        } catch (Exception e) {
            System.err.println("Error\n---> "+e);
        }   
    }//GEN-LAST:event_etBuscarKeyReleased

    private void cbTipoUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoUnidadActionPerformed
        // TODO add your handling code here:
        for(ModelTipoUnidad mtu : listTipoUnidad){
            if(mtu.getId() == cbTipoUnidad.getSelectedIndex()){
                modelTipoUnidad = mtu;
            }
        }
    }//GEN-LAST:event_cbTipoUnidadActionPerformed

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
        for(ModelProveedor mp : listProveedor){
            if(mp.getId() == cbProveedor.getSelectedIndex()){
                modelProveedor = mp;
            }
        }
    }//GEN-LAST:event_cbProveedorActionPerformed

    private void cbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMarcaActionPerformed
        // TODO add your handling code here:
        for(ModelMarca mm : listMarca){
            if(mm.getId() == cbMarca.getSelectedIndex()){
                modelMarca = mm;
            }
        }
    }//GEN-LAST:event_cbMarcaActionPerformed

    private void cbTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoProductoActionPerformed
        // TODO add your handling code here:
        for(ModelTipoProducto tp : listTipoProducto){
            if(tp.getId() == cbTipoProducto.getSelectedIndex() ){
                modelTipoProducto = tp;
            }
        }
    }//GEN-LAST:event_cbTipoProductoActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        Boolean listo = false;
        ModelProduct p = crearProducto();
        if(p != null){
            p.setId(id);
            listo = sp.actualizarProducto(p);
            if(listo){
                JOptionPane.showMessageDialog(this, "Registro actualizado correctamente");
                recargar();
                btnGuardarCambios.setVisible(false);
                btnIngresar.setVisible(true);
                llenarFormulario(p);
            }else{
                JOptionPane.showMessageDialog(this, "Error al actualizar, contancte a su proveedor");
            }
            
        }else{
            System.out.println("Error al crear el producto");
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void etBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(extensionFilter);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Ruta = fileChooser.getSelectedFile().getAbsolutePath();
            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 0));
            lblImagen.setIcon(mIcono);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelIngresoProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbProveedor;
    private javax.swing.JComboBox<String> cbTipoProducto;
    private javax.swing.JComboBox<String> cbTipoUnidad;
    private javax.swing.JTextField etBuscar;
    private javax.swing.JTextField etCodigo;
    private javax.swing.JTextArea etDescripcion;
    private javax.swing.JTextField etModelo;
    private javax.swing.JTextField etNombre;
    private javax.swing.JTextField etPrecio;
    private javax.swing.JTextField etStock;
    private javax.swing.JTextField etUnidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    public static javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}

