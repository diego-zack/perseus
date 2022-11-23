package com.libreria.service;

import com.libreria.connection.DatabaseConnection;
import com.libreria.model.ModelProduct;
import com.libreria.model.ModelProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceProveedor {
    
    
    
    public static boolean ingresarProveedor(ModelProveedor proveedor){
        
        
        Connection con = DatabaseConnection.getInstance().getConnection();
        
        try {
        String sql = "INSERT INTO proveedor (rut, razon_social, ciudad, comuna, direccion, telefono, giro, correo)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setString(1, proveedor.getRut());
        sentencia.setString(2, proveedor.getRazonSocial());
        sentencia.setString(3, proveedor.getCiudad());
        sentencia.setString(4, proveedor.getComuna());
        sentencia.setString(5, proveedor.getDireccion());
        sentencia.setString(6, proveedor.getTelefono());
        sentencia.setString(7, proveedor.getGiro());
        sentencia.setString(8, proveedor.getCorreo());
      
        sentencia.executeUpdate();
        return true;
        
        } catch (SQLException e) {
            System.out.println("error: "+ e);
        }
        
      
        return false;
    }
    
    
    public static ArrayList consultarProveedor(){
        
        ArrayList<ModelProveedor> proveedores = new ArrayList();
        ModelProveedor proveedor;
        Connection con = DatabaseConnection.getInstance().getConnection(); 
        
        
        
        try(PreparedStatement ps = con.prepareStatement(
                "SELECT rut, razon_social, ciudad, comuna, direccion, telefono, giro, correo FROM proveedor"
        )){
            try(ResultSet rs = ps.executeQuery()){       
                while(rs.next()){
                    proveedor = new ModelProveedor();
                    proveedor.setRut(rs.getString(1));
                    proveedor.setRazonSocial(rs.getString(2));
                    proveedor.setCiudad(rs.getString(3));
                    proveedor.setComuna(rs.getString(4));
                    proveedor.setDireccion(rs.getString(5));
                    proveedor.setTelefono(rs.getString(6));
                    proveedor.setGiro(rs.getString(7));
                    proveedor.setCorreo(rs.getString(8));
                    
                    proveedores.add(proveedor);
                }                
            }     
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }        
        return proveedores;
    }
}
