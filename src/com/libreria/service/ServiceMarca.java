/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.Conexion;
import com.libreria.model.ModelMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceMarca {
    
    PreparedStatement ps;
    ResultSet rs;
    ResultSet res;
    Connection acceso; 
    Conexion con = new Conexion();
    ModelMarca marca;
    ArrayList<ModelMarca> lista;
    
    public ArrayList<ModelMarca> getAll(){
        
        con.Conectar();
        String query = "select * from marca";
        Statement stmt = con.getStmt();
        lista = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                marca = new ModelMarca();
                marca.setId(rs.getInt("id"));
                marca.setNombre(rs.getString("nombre"));
                
                lista.add(marca);
            }
            
        } catch (SQLException e) {
            System.out.println("Error => "+e);
        }
        return lista;
    }
    
}
