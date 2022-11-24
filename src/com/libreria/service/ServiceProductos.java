/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.Conexion;
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
    Conexion con=new Conexion();
    ModelProduct prod = new ModelProduct();
    ArrayList<ModelProduct> lista=new ArrayList<ModelProduct>();
   
    
      public ArrayList<ModelProduct> getAll() throws SQLException{        
        con.Conectar();
        lista=new ArrayList<ModelProduct>();
        String query = "select * from producto";
        Statement stmt = con.getStmt();
        ResultSet res = stmt.executeQuery(query);
        
        while (res.next()) {
            prod = new ModelProduct();
            prod.setId(res.getInt("id"));
            prod.setCodigo(res.getString("codigo"));
            prod.setTipoProducto(res.getInt("tipo_producto_id"));
            prod.setNombre(res.getString("nombre"));
            prod.setModelo(res.getString("modelo"));
            prod.setDescripcion(res.getString("descripcion"));
            prod.setMarca(res.getInt("marca_id"));
            prod.setProveedor(res.getInt("proveedor_id"));
            prod.setUnidad(res.getString("unidad"));
            prod.setTipoUnidad(res.getInt("tipo_unidad_id"));
            prod.setPrecio(res.getDouble("precio"));
            prod.setStock(res.getInt("stock"));
            prod.setFoto(res.getInt("foto_id"));
              
            lista.add(prod);
        }
        con.Desconectar();
        return lista;
    }
}
