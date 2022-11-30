/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.Conexion;
import com.libreria.connection.DatabaseConnection;
import com.libreria.form.Form_Producto;
import com.libreria.model.ModelProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceProductos {
    
    PreparedStatement ps;
    ResultSet rs;
    ResultSet res;
    Connection acceso; 
    Conexion con = new Conexion();
    ModelProduct producto;
    ArrayList<ModelProduct> lista;
   
    
      public ArrayList<ModelProduct> getAll(){        
        con.Conectar();
        lista =new ArrayList<ModelProduct>();
        String query = "select * from producto";
        Statement stmt = con.getStmt();
        try{
            ResultSet res = stmt.executeQuery(query);
        
        while (res.next()) {
            producto = new ModelProduct();
            producto.setId(res.getInt("id"));
            producto.setCodigo(res.getString("codigo"));
            producto.setTipoProducto(res.getInt("tipo_producto_id"));
            producto.setNombre(res.getString("nombre"));
            producto.setModelo(res.getString("modelo"));
            producto.setDescripcion(res.getString("descripcion"));
            producto.setMarca(res.getInt("marca_id"));
            producto.setProveedor(res.getInt("proveedor_id"));
            producto.setUnidad(Double.valueOf(res.getString("unidad")));
            producto.setTipoUnidad(res.getInt("tipo_unidad_id"));
            producto.setPrecio(res.getDouble("precio"));
            producto.setStock(res.getInt("stock"));
            producto.setImagen(res.getBytes("imagen"));
              
            lista.add(producto);
        }
        }catch(SQLException e){
            System.out.println("Error => "+e);
        }
        con.Desconectar();
        return lista;
    }
    public Boolean insertProducto(ModelProduct p){
        Connection con = DatabaseConnection.getInstance().getConnection();
        String query = "insert into "
                + "producto(nombre,codigo,modelo,descripcion,marca_id,proveedor_id,tipo_producto_id,tipo_unidad_id,stock,unidad,precio,imagen)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getCodigo());
            ps.setString(3,p.getModelo());
            ps.setString(4,p.getDescripcion());
            ps.setString(10,String.valueOf(p.getUnidad()));
            ps.setInt(5,p.getMarca());
            ps.setInt(6,p.getProveedor());
            ps.setInt(7, p.getTipoProducto());
            ps.setInt(8,p.getTipoUnidad());
            ps.setInt(9, p.getStock());
            ps.setDouble(11,p.getPrecio());
            ps.setBytes(12,p.getImagen());
            
            ps.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.out.println("Error al insertar Producto\n=> "+e);
        }
        return false;
    }
    public Boolean actualizarProducto(ModelProduct p){
        Connection con = DatabaseConnection.getInstance().getConnection();
        String query = "update producto set "
                + "nombre = ? , codigo = ? , modelo = ? , descripcion = ? , marca_id = ? , proveedor_id = ? , "
                + "tipo_producto_id = ? , tipo_unidad_id = ? , stock = ? , imagen = ? , unidad = ? , precio = ?  "
                + "where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getCodigo());
            ps.setString(3,p.getModelo());
            ps.setString(4,p.getDescripcion());
            ps.setString(11,String.valueOf(p.getUnidad()));
            ps.setInt(5,p.getMarca());
            ps.setInt(6,p.getProveedor());
            ps.setInt(7, p.getTipoProducto());
            ps.setInt(8,p.getTipoUnidad());
            ps.setInt(9, p.getStock());
            ps.setBytes(10,p.getImagen());
            ps.setDouble(12,p.getPrecio());
            ps.setInt(13, p.getId());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto\n=> "+e);
            return false;
        }
    }
    
    public Boolean eliminarProducto(ModelProduct p){
        Connection con = DatabaseConnection.getInstance().getConnection();
        String query = "delete from producto where id = ? ";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, p.getId());
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
