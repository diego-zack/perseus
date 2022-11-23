package com.libreria.model;

public class ModelProduct {
    
    private int id;
    private int codigo;
    private int tipo_producto_id;
    private String nombre;
    private String modelo;
    private String descripcion;
    private String marca;
    private String proveedor;
    private String unidad;
    private int tipo_unidad_int;
    private Double precio;
    private int stock;
    private int foto_id;

    public ModelProduct() {
    }

    public ModelProduct(int id, int codigo, int tipo_producto_id, String nombre, String modelo, String descripcion, String marca, String proveedor, String unidad, int tipo_unidad_int, Double precio, int stock, int foto_id) {
        this.id = id;
        this.codigo = codigo;
        this.tipo_producto_id = tipo_producto_id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.proveedor = proveedor;
        this.unidad = unidad;
        this.tipo_unidad_int = tipo_unidad_int;
        this.precio = precio;
        this.stock = stock;
        this.foto_id = foto_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo_producto_id() {
        return tipo_producto_id;
    }

    public void setTipo_producto_id(int tipo_producto_id) {
        this.tipo_producto_id = tipo_producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getTipo_unidad_int() {
        return tipo_unidad_int;
    }

    public void setTipo_unidad_int(int tipo_unidad_int) {
        this.tipo_unidad_int = tipo_unidad_int;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;
    }

    public ModelProduct(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

   

    
}
