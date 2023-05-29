/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Conexion.getConexion();
        System.out.println("Conexion exitosa");
        MensajeDao mensajeDao = new MensajeDao();
        
        List<Mensaje> mensajes = mensajeDao.seleccionar();
        
        // se recorre el array para mostrar los registros de la DB
        for (Mensaje mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }
   
    
}
