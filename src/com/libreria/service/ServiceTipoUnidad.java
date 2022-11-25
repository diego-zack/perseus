/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.service;

import com.libreria.connection.Conexion;
import com.libreria.model.ModelTipoUnidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author naxch
 */
public class ServiceTipoUnidad {
    
    PreparedStatement ps;
    ResultSet rs;
    ResultSet res;
    Connection acceso; 
    Conexion con = new Conexion();
    ModelTipoUnidad tipoUnidad;
    ArrayList<ModelTipoUnidad> lista;
    
    public ArrayList<ModelTipoUnidad> getAll(){
        
        lista = new ArrayList<>();
        
        con.Conectar();
        String query = "select * from tipo_unidad";
        Statement stmt = con.getStmt();
        
        try {
            res = stmt.executeQuery(query);
            while(res.next()){
                tipoUnidad = new ModelTipoUnidad();
                tipoUnidad.setId(res.getInt("id"));
                tipoUnidad.setNombre(res.getString("nombre"));
                
                lista.add(tipoUnidad);
            }
        } catch (Exception e) {
            System.out.println("Error => "+e);
        }
        return lista;
    }
    
}
