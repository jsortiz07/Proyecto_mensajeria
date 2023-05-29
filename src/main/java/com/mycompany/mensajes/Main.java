/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conexion.getConexion();
        System.out.println("Conexion exitosa");
        System.out.println("hola");
        
    }
   
    
}
