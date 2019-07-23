/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productosDTO;

/**
 *
 * @author eduardoecheverria
 */
public class Productos {

    //Constructor vacio
    public Productos() {
    }
    
    //Constructor  ID

    public Productos(int id) {
        this.id = id;
    }
    
    //Definimos los atributos que corresponderan a los campos de nuestra entidad
    
    private int id;
    private String nombre;
    private String descr;
    private Double importe; 
    
    /*Definimos Getters y Setters, métodos que nos permitiran leer y modificar 
      los valores de nuestras variables privadas
      Click derecho -> Insert Code -> Getter y Setters
    */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Productos{" + "id=" + id + ", nombre=" + nombre + ", descr=" + descr + ", importe=" + importe + '}';
    }
    
}
