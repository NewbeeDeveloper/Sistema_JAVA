/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productosDAO;

import productosDTO.Productos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eduardoecheverria
 */
public interface ProductoDAO {

    /*Definimos lo métodos que realizaran las operaciones básicas */
    
    public int insert(Productos producto) //Definición del método que insertará
            throws SQLException;

    public int update(Productos producto) //Definición del método que actualizará
            throws SQLException;

    public int delete(Productos producto) //Definición del método que borrará
            throws SQLException;

    public List<Productos> select()       //Definición del método que Seleccionará
            throws SQLException;

}
