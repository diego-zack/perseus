package com.libreria.model;

public class ModelProduct {
    
    private int id;
    private String nombre;
    private String codigo;
    private String modelo;
    private String descripcion;
    private int marca;
    private int proveedor;
    private int tipoProducto;
    private int tipoUnidad;
    private int stock;
    private int foto;
    private Double unidad;
    private Double precio;
    private byte [] imagen; 
    
    public ModelProduct(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
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

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public Double getUnidad() {
        return unidad;
    }

    public void setUnidad(Double unidad) {
        this.unidad = unidad;
    }

    public int getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(int tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    
    
    
    
}
