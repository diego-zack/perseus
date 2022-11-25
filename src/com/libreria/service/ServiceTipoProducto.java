/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.Conexion;
import com.libreria.model.ModelTipoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ServiceTipoProducto {
    
    PreparedStatement ps;
    ResultSet rs;
    ResultSet res;
    Connection acceso; 
    Conexion con=new Conexion();
    ModelTipoProducto tipoProd;
    ArrayList<ModelTipoProducto> listaTP;
    
    public ArrayList<ModelTipoProducto> getAll(){
        con.Conectar();
        listaTP = new ArrayList<ModelTipoProducto>();
        String query = "select * from tipo_producto";
        Statement stmt = con.getStmt();
        try{
            ResultSet rs = stmt.executeQuery(query);

           while(rs.next()){
               tipoProd = new ModelTipoProducto();
               tipoProd.setId(rs.getInt("id"));
               tipoProd.setNombre(rs.getString("nombre"));

               listaTP.add(tipoProd);
           }   
        }catch(SQLException e){
            System.out.println("Error => "+e);
        }
        con.Desconectar();
        return listaTP;
    }
}
