/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Conexion {
    private static final String URL ="jdbc:mysql://localhost/mensajes_db";
    private static final String user = "root";
    private static final String pass = "root";
    
    public static Connection getConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,user,pass);
    }
    // Se sobrecargan metodo para realizar el cierre de conexiones mysql
    
    public static void cerrar(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void cerrar(PreparedStatement ps) throws SQLException{
        ps.close();
    }
    
    public static void cerrar(Connection cn) throws SQLException{
        cn.close();
    }
}
