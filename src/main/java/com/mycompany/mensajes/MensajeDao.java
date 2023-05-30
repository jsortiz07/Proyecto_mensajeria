/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import static com.mycompany.mensajes.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class MensajeDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Mensaje mensaje = new Mensaje();

    //Metodo para listar los registros de la tabla mensajes
    public List<Mensaje> seleccionar() throws ClassNotFoundException {
        String sql = "SELECT *FROM mensajes";

        // Se crea array para guardar el objeto mensaje
        List<Mensaje> mensajes = new ArrayList<>();

        try {
            this.cn = getConexion();
            this.ps = this.cn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            //Se guardan los campos de la DB en cada variable para despues agregarla al arrayList
            while (this.rs.next()) {
                int id = this.rs.getInt("id_mensaje");
                String mensaje = this.rs.getString("mensaje");
                String autor = this.rs.getString("autor");
                String fecha = this.rs.getString("fecha");

                this.mensaje = new Mensaje(id, mensaje, autor, fecha);
                mensajes.add(this.mensaje); // se agrega objeto creado al array
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally { // se cierran las conexiones de PreparedStatement Resultet y Connection
            try {
                Conexion.cerrar(this.cn);
                Conexion.cerrar(this.ps);
                Conexion.cerrar(this.rs);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return mensajes;
    }

    public int insertar(Mensaje msn) throws ClassNotFoundException {
        String sql = "INSERT INTO mensajes(mensaje,autor,fecha) VALUES(?,?,CURRENT_TIME())";
        int registros = 0;

        // Se crea array para guardar el objeto mensaje
        List<Mensaje> mensajes = new ArrayList<>();

        try {
            this.cn = getConexion();
            this.ps = this.cn.prepareStatement(sql);

            this.ps.setString(1, msn.getMensaje());
            this.ps.setString(2, msn.getAutor());

            registros = this.ps.executeUpdate();
            System.out.println("Se inserto" + registros);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally { // se cierran las conexiones de PreparedStatement Resultet y Connection
            try {
                Conexion.cerrar(this.cn);
                Conexion.cerrar(this.ps);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int update(Mensaje msn) throws ClassNotFoundException {
        String sql = "UPDATE mensajes SET mensaje=?, autor=? WHERE id_mensaje=?";
        int registros = 0;

        try {
            this.cn = getConexion();
            this.ps = this.cn.prepareStatement(sql);

            this.ps.setString(1, msn.getMensaje());
            this.ps.setString(2, msn.getAutor());
            this.ps.setInt(3, msn.getId());

            registros = this.ps.executeUpdate();
            System.out.println("Se edito " + registros + "registro");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally { // se cierran las conexiones de PreparedStatement Connection y PreparedStatement
            try {
                Conexion.cerrar(this.cn);
                Conexion.cerrar(this.ps);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int delete(Mensaje msn) throws ClassNotFoundException {
        String sql = "DELETE FROM mensajes WHERE id_mensaje=?";
        int registros = 0;

        try {
            this.cn = getConexion();
            this.ps = this.cn.prepareStatement(sql);

            this.ps.setInt(1, msn.getId());

            registros = this.ps.executeUpdate();
            System.out.println("Se elimino " + registros + "registro");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally { // se cierran las conexiones de PreparedStatement Connection y PreparedStatement
            try {
                Conexion.cerrar(this.cn);
                Conexion.cerrar(this.ps);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }
}
