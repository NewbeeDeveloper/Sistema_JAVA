/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_ejercicio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import productosDTO.Productos;
import productosDAO.ProductosDAOJDBC;

/**
 *
 * @author eduardoecheverria
 */
public class Sistema_Ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creamos un lista de productos
        List<Productos> prods = new ArrayList<>();
        
        //Creamos nuestra clase que realizará las consultas MySQL
        ProductosDAOJDBC prds = new ProductosDAOJDBC();
        
        try {
            // Intentamos ejecutar la consulta y obtener una lista de objetos tipo productos
            prods = prds.select();
            
            //Iteramos sobre la lista he imprimimos uno a uno los objetos obtenidos
            for(Productos prod:prods){
                System.out.println(prod.toString());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    }
    
}
