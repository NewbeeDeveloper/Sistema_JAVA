/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productosDAO;

import productosDTO.Productos;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardoecheverria
 */
public class ProductosDAOJDBC implements ProductoDAO {

    /*Declaramos atributos que contengan la conexión y las sen tecias SQL*/
    private Conexion conn;

    //Constantes
    private final String SQL_INSERT = "INSERT INTO  productos('nombre','descr','precio') VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE productos SET nombre=?, descr=?, precio=? WHERE id=?";
    private final String SQL_DELETE = "DELETE FROM productos WHERE id = ?";
    private final String SQL_SELECT = "SELECT id, nombre, descr, precio FROM productos";

    //Creamos un constructor vacio y otro que obtenga la conexión
    public ProductosDAOJDBC() {
    }

    public ProductosDAOJDBC(Conexion conn) {
        this.conn = conn;
    }

    @Override
    public int insert(Productos producto) throws SQLException {

        //Variable de conexión
        Conexion conn1 = null;
        PreparedStatement stmt = null;

        int rows = 0;

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_INSERT);

        //Definimos el indice que sustiuirá a los parámetros
        int index = 1;

        //Indicamos el valor nombre
        stmt.setString(index++, producto.getNombre());

        //Indicamos el valor descr
        stmt.setString(index++, producto.getDescr());

        //Por último el valor precio
        stmt.setDouble(index, producto.getImporte());

        //Ejecutamos el insert
        rows = stmt.executeUpdate();

        //Cerramos la conexión
        conn1.close();

        return rows;

    }

    @Override
    public int update(Productos producto) throws SQLException {
        //Variable de conexión
        Conexion conn1 = null;
        PreparedStatement stmt = null;

        int rows = 0;

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_UPDATE);

        //Definimos el indice que sustiuirá a los parámetros
        int index = 1;

        //Indicamos el valor nombre
        stmt.setString(index++, producto.getNombre());

        //Indicamos el valor descr
        stmt.setString(index++, producto.getDescr());

        //Por último el valor precio
        stmt.setDouble(index, producto.getImporte());

        //Ejecutamos el insert
        rows = stmt.executeUpdate();

        //Cerramos la conexión
        conn1.close();

        return rows;
    }

    @Override
    public int delete(Productos producto) throws SQLException {
        //Variable de conexión
        Conexion conn1 = null;
        
        //Variable encargada de ejecutar la operación SQL
        PreparedStatement stmt = null;

        int rows = 0;

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_DELETE);

        //Definimos el indice que sustiuirá a los parámetros
        int index = 1;

        //Indicamos el id a borrar
        stmt.setInt(index++, producto.getId());

        //Ejecutamos el insert
        rows = stmt.executeUpdate();

        //Cerramos la conexión
        conn1.close();

        return rows;
    }

    @Override
    public List<Productos> select() throws SQLException {

        Conexion conn1 = null;
        PreparedStatement stmt = null;

        //Variable que almacenará el resultado de la consulta
        ResultSet rs = null;

        Productos productos = new Productos();

        //Creamos la lista de tipo productos
        List<Productos> productosLista = new ArrayList<Productos>();

        //Si no recibimos la conexión por parámetro, la realizamos desde aquí 
        conn1 = (this.conn != null) ? this.conn : new Conexion();

        //Preparamos la inserción
        stmt = conn1.conn.prepareStatement(SQL_SELECT);
        
        rs = stmt.executeQuery();
        
        while(rs.next()){
            
            //Preparamos el objeto
            productos.setId(rs.getInt(1)) ;
            productos.setNombre(rs.getString(2));
            productos.setDescr(rs.getString(4));
            productos.setImporte(rs.getDouble(4));
            
            //Lo añadimos a la lista       
            productosLista.add(productos);
            
        }
        
        //Cerramos la conexión
        conn1.close();
        
        //Variable de retorno 
        return productosLista;

    }

}
