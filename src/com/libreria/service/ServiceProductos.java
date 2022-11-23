/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.Conexion;
import com.libreria.connection.DatabaseConnection;
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
    
    
    public void add(ModelProduct p) {
        try {
            con.Conectar();
            String query = "insert into producto( nombre, precio) "
                    + "values ('" + p.getNombre()
                    + "'," + p.getPrecio() + ")";
            Statement stmt = con.getStmt();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        con.Desconectar();
    }
    public void update(ModelProduct producto) {
         con.Conectar();
        String query = "update producto " + "set nombre='"
                + producto.getNombre() + "', precio="
                + producto.getPrecio() +  " where id = " 
                + producto.getId();
        try {
            Statement stmt = con.getStmt();  
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Desconectar();
    }
    
    public void remove(int id) {
         con.Conectar();
        String query = "delete from producto where id = " + id + " ";
        try {Statement stmt = con.getStmt();
        stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Desconectar();
    }
    
        public ModelProduct listarID(int id) throws SQLException
    {
        con.Conectar();
        prod=new ModelProduct();
        String query = "select * from producto where id="+id;
        Statement stmt = con.getStmt();
        ResultSet res = stmt.executeQuery(query);
       if (res.next()) {
            prod = new ModelProduct();
            prod.setId(res.getInt("id"));
            prod.setNombre(res.getString("nombre"));
          //  prod.setPrecio(res.getInt("precio"));      
        }
        con.Desconectar();
        return prod;
    }
    
    
      public ModelProduct getByName(String nombre) throws SQLException
    {
        con.Conectar();
        String query = "select * from producto where nombre='"+nombre+"'";
        Statement stmt = con.getStmt();
        ResultSet res = stmt.executeQuery(query);
       if (res.next()) {
            prod = new ModelProduct();
            prod.setId(res.getInt("id"));
            prod.setNombre(res.getString("nombre"));
           // prod.setPrecio(res.getInt("precio"));      
        }
        con.Desconectar();
        return prod;
    }
      public ArrayList<ModelProduct> getAll() throws SQLException
    {
        con.Conectar();
        lista=new ArrayList<ModelProduct>();
        String query = "select * from producto";
        Statement stmt = con.getStmt();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            prod = new ModelProduct();
            prod.setId(res.getInt("id"));
            prod.setNombre(res.getString("nombre"));
           // prod.setPrecio(res.getInt("precio"));      
            lista.add(prod);
        }
        con.Desconectar();
        return lista;
    }
       public ArrayList<ModelProduct> getLikeNombre(String nombre) throws SQLException
    {
        con.Conectar();
        lista=new ArrayList<ModelProduct>();
        String query = "select * from producto where nombre like'"+nombre+"%' ";
        Statement stmt = con.getStmt();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            prod = new ModelProduct();
            prod.setId(res.getInt("id"));
            prod.setNombre(res.getString("nombre"));
          //  prod.setPrecio(res.getInt("precio"));      
            lista.add(prod);
    }
        con.Desconectar();
        return lista;
    }
    
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
