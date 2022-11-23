
package com.libreria.model;

import com.libreria.connection.DatabaseConnection;

public class ModelProveedor {
    private int id;
    private String rut;
    private String razon_social;
    private String ciudad;
    private String comuna;
    private String direccion;
    private String telefono;
    private String giro;
    private String correo;

    public ModelProveedor() {}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    
    public String getRazonSocial(){
        return razon_social;
    }
    public void setRazonSocial(String razon_social){
        this.razon_social = razon_social;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public String getComuna(){
        return comuna;
    }
    public void setComuna(String comuna){
        this.comuna = comuna;
    }
 
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
   
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getGiro(){
        return giro;
    }
    public void setGiro(String giro){
        this.giro = giro;
    }
    
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public ModelProveedor(String rut, String razon_social, String ciudad, String comuna, String direccion, String telefono, String giro, String correo) {
        this.rut = rut;
        this.razon_social = razon_social;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.direccion = direccion;
        this.telefono = telefono;
        this.giro = giro;
        this.correo = correo;
    }
   
}
