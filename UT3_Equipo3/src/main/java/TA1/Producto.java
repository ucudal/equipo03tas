package TA1;

/**
 *
 * @author sebastian.galli
 */
public class Producto {
    private String codigo;
    private String nombre;
    private float precio;
    private int stock;

    public Producto(String codigo, String nombre, float precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto() {
    }
    public Comparable getEtiqueta() {
        return codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void imprimirProducto(){
        System.out.println("Codigo: " + this.codigo + " // Nombre: " + this.nombre + " // Precio: " + this.precio + " // Stock: " + this.stock);
    }
}
