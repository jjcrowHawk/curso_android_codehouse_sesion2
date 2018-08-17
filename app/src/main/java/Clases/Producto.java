package Clases;

public class Producto {

    private String nombre;
    private int cantidad;
    private String descripcion;
    private double precio;

    public Producto(String nombre,String descripcion, int cantidad,double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio= precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
