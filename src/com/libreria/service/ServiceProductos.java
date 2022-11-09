/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.DatabaseConnection;
import com.libreria.model.ModelProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServiceProductos {
    
    public static ArrayList getAllProductos(){
        
        ArrayList<ModelProduct> productos = new ArrayList();
        ModelProduct p;
        Connection con = DatabaseConnection.getInstance().getConnection(); 
        
        
        
        try(PreparedStatement ps = con.prepareStatement(
                "SELECT producto.id,codigo,producto.descripcion,precio,stock,proveedor.descripcion,marca.descripcion "
            +   "FROM producto "
            +   "INNER JOIN proveedor ON proveedor.id = producto.proveedor_id "
            +   "INNER JOIN marca ON marca.id = producto.marca_id"
        )){
            try(ResultSet rs = ps.executeQuery()){       
                while(rs.next()){
                    p = new ModelProduct();
                    p.setId(rs.getInt(1));
                    p.setCodigo(rs.getInt(2));
                    p.setDescripcion(rs.getString(3));
                    p.setPrecio(rs.getDouble(4));
                    p.setStock(rs.getInt(5));
                    p.setProveedor(rs.getString(6));
                    p.setMarca(rs.getString(7));
                    
                    productos.add(p);
                }                
            }     
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }        
        return productos;
    }
}
