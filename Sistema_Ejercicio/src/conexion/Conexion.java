/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardoecheverria
 */
public class Conexion {

    private String db = "sistema_ejer";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3310/sistema_ejer?useSSL=false";
    public Connection conn = null;

    public Conexion() {

        try {
            //Utilizamos el Driver mysql
            Class.forName("com.mysql.jdbc.Driver");

            //Realizamos la conexión
            conn = DriverManager.getConnection(this.url, this.user, this.pass);

            //Validamos la conexión
            if (conn != null) {
                System.out.println("-- CONEXIÓN ESTABLECIDA --");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Método para cerrar la conexión
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
}
