package com.libreria.service;

import com.libreria.connection.DatabaseConnection;
import com.libreria.model.ModelProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceProveedor {
    
    public static ArrayList consultarProveedor(){
        
    ArrayList<ModelProveedor> proveedores = new ArrayList();
    ModelProveedor proveedor;
    Connection con = DatabaseConnection.getInstance().getConnection(); 
        
        
        
    try(PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM proveedor"
    )){
        try(ResultSet rs = ps.executeQuery()){       
            while(rs.next()){
                proveedor = new ModelProveedor();
                proveedor.setId(Integer.parseInt(rs.getString(1)));
                proveedor.setRut(rs.getString(2));
                proveedor.setNombre(rs.getString(3));
                proveedor.setRazonSocial(rs.getString(4));
                proveedor.setCiudad(rs.getString(5));
                proveedor.setComuna(rs.getString(6));
                proveedor.setDireccion(rs.getString(7));
                proveedor.setTelefono(rs.getString(8));
                proveedor.setGiro(rs.getString(9));
                proveedor.setCorreo(rs.getString(10));
                    
                proveedores.add(proveedor);
            }                
        }     
    } catch (Exception e) {
        System.err.println("Error: "+e);
    }        
    return proveedores;
    }
    
    public static boolean ingresarProveedor(ModelProveedor proveedor){
        
        Connection con = DatabaseConnection.getInstance().getConnection();
        
        try {
        String sql = "INSERT INTO proveedor (rut, nombre,razon_social, ciudad, comuna, direccion, telefono, giro, correo)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setString(1, proveedor.getRut());
        sentencia.setString(2, proveedor.getNombre());
        sentencia.setString(3, proveedor.getRazonSocial());
        sentencia.setString(4, proveedor.getCiudad());
        sentencia.setString(5, proveedor.getComuna());
        sentencia.setString(6, proveedor.getDireccion());
        sentencia.setString(7, proveedor.getTelefono());
        sentencia.setString(8, proveedor.getGiro());
        sentencia.setString(9, proveedor.getCorreo());
      
        sentencia.executeUpdate();
        return true;
        
        } catch (SQLException e) {
            System.out.println("error: "+ e);
        }
        
      
        return false;
    }
    
    public static boolean actualizarProveedor(ModelProveedor proveedor){
        
        Connection con = DatabaseConnection.getInstance().getConnection();
        
        try {
        String sql = "UPDATE proveedor SET"
                    + " rut = ?, nombre = ? ,razon_social = ?, ciudad = ?, comuna = ?, direccion = ?, telefono = ?, giro = ?, correo = ?"
                    + " WHERE id = ?";
        
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setString(1, proveedor.getRut());
        sentencia.setString(2, proveedor.getNombre());
        sentencia.setString(3, proveedor.getRazonSocial());
        sentencia.setString(4, proveedor.getCiudad());
        sentencia.setString(5, proveedor.getComuna());
        sentencia.setString(6, proveedor.getDireccion());
        sentencia.setString(7, proveedor.getTelefono());
        sentencia.setString(8, proveedor.getGiro());
        sentencia.setString(9, proveedor.getCorreo());
        sentencia.setInt(10, proveedor.getId());

      
        sentencia.executeUpdate();
        return true;
        
        } catch (SQLException e) {
            System.out.println("error: "+ e);
        }
        
      
        return false;
    }
    public static boolean eliminarProveedor(ModelProveedor proveedor){
        
        
        Connection con = DatabaseConnection.getInstance().getConnection();
        
        try {
        String sql = "DELETE FROM proveedor WHERE id = ?";
        
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setInt(1, proveedor.getId());

      
        sentencia.executeUpdate();
        return true;
        
        } catch (SQLException e) {
            System.out.println("error: "+ e);
        }
        
      
        return false;
    }
}
