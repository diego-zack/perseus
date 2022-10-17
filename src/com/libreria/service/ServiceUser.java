package com.libreria.service;

import com.libreria.connection.DatabaseConnection;
import com.libreria.model.ModelLogin;
import com.libreria.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        try (PreparedStatement p = con.prepareStatement("SELECT id, username, email FROM `user` WHERE email=? and password=?")) {
            p.setString(1, login.getEmail());
            p.setString(2, login.getPassword());
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    int userID = r.getInt(1);
                    String userName = r.getString(2);
                    String email = r.getString(3);
                    data = new ModelUser(userID, userName, email,"");
                }
            }catch(SQLException e){
                System.err.println(e); 
            }
        p.close();
        return data;
        }catch(SQLException e){
            System.err.println(e); 
        }
    return null;
    }
}