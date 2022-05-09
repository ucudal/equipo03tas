package TA1;

import com.mycompany.ut4.ta2.ManejadorArchivosGenerico;

public class Almacen {

    private final String nombreAlmacen;
    private TLista<Producto> productos = new TLista();

    public Almacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public TLista getproductos() {
        return this.productos;
    }

    public void agregarProducto(Producto producto) {
        TNodo<Producto> buscado = productos.buscar(producto.getCodigo());
        if (buscado == null) {
            TNodo<Producto> nuevoProducto = new TNodo<>(producto.getCodigo(), producto);
            productos.insertar(nuevoProducto);//Si el producto no esta en la lista
            System.out.println("Se ha agregado un nuevo producto al almacen. El nuevo producto es: " + producto.getNombre() + " con un stock de: " + producto.getStock() + ".");
        } else {
            System.out.println("Producto ya existe");
        }
    }

    public void agregarStockAProducto(int cantidadProductoAgregar, Comparable codigoProducto) {
        TNodo <Producto> busqueda = productos.buscar(codigoProducto);
        
        if (busqueda != null){
            busqueda.getDato().setStock(busqueda.getDato().getStock() + cantidadProductoAgregar);
            System.out.println("El articulo: " + busqueda.getDato().getNombre() + " ha incremento su stock en :" + cantidadProductoAgregar);
            System.out.println("Se ha modificado el stock del producto: " + busqueda.getDato().getNombre() + " ahora tiene en stock: " + busqueda.getDato().getStock());
        } else{
            System.out.println("El producto al que se le quiere agregar stock no se ha encontrado.");
        } 
    }

    public void reducirStock(int cantidadProductoReducir, String codigoProducto) {
        
        TNodo <Producto> busqueda = productos.buscar(codigoProducto);
        
        if (busqueda != null){
            if(cantidadProductoReducir <= busqueda.getDato().getStock()){
                busqueda.getDato().setStock(busqueda.getDato().getStock() - cantidadProductoReducir);
                System.out.println("El articulo: " + busqueda.getDato().getNombre() + " ha reducido su stock en :" + cantidadProductoReducir);
                System.out.println("Se ha modificado el stock del producto: " + busqueda.getDato().getNombre() + " ahora tiene en stock: " + busqueda.getDato().getStock());
            } else{
                busqueda.getDato().setStock(0);
                System.out.println("El articulo: " + busqueda.getDato().getNombre() + " ha reducido su stock en :" + cantidadProductoReducir);
                System.out.println("Se ha modificado el stock del producto: " + busqueda.getDato().getNombre() + " ahora tiene en stock: " + busqueda.getDato().getStock());
            }
            
        } else {
            System.out.println("El producto al que se le quiere reducir stock no se ha encontrado.");
        } 
    }

    public void reducirStockAProductoArchivo(String archivoVentas) {
        int contador = 0;
        float valorDeVenta = 0;
        String[] ventas = ManejadorArchivosGenerico.leerArchivo(archivoVentas);
        for (String lineaLeida : ventas) {
            contador += 1;
            try {
                String[] lineaAProcesar = lineaLeida.split(",");
                if (lineaAProcesar.length == 2){
                    reducirStock(Integer.parseInt(lineaAProcesar[1].trim()), (lineaAProcesar[0].trim()));
                    valorDeVenta += ((productos.buscar(lineaAProcesar[0].trim()).getDato().getPrecio()) * Integer.parseInt(lineaAProcesar[1].trim()));
                } else {
                    System.out.println("La linea " + contador + " del archivo de texto esta corrupta.");
                }
            } catch (Exception e) {
                System.out.println("Fallo en la data de la linea " + contador + ".");
            }
        }
       System.out.println("El valor de la venta fue: " + valorDeVenta); 
    }
    
    public void agregarStockDesdeArchivo(String archivoAltas) {
        String[] altas = ManejadorArchivosGenerico.leerArchivo(archivoAltas);
        try {
            for (String lineaLeida : altas) {
                String[] lineaAProcesar = lineaLeida.split(",");
                if (lineaAProcesar.length == 4){
                    Producto prod = new Producto(lineaAProcesar[0].trim(), lineaAProcesar[1].trim(), Float.parseFloat(lineaAProcesar[2].trim()), Integer.parseInt(lineaAProcesar[3].trim()));
                    if (productos.buscar(lineaAProcesar[0].trim()) == null){
                        agregarProducto(prod);//Si el producto no esta en la lista
                    } else {
                        agregarStockAProducto(Integer.parseInt(lineaAProcesar[3].trim()), lineaAProcesar[0].trim());
                    }
                }            
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo. Archivo corrupto.");
        }
    }

    public void imprimirStock() {
        TNodo<Producto> buscado = productos.getPrimero();
        while (buscado != null) {
            Producto prod = buscado.getDato();
            System.out.println("Codigo: " + prod.getCodigo() + " Item: " + prod.getNombre() + " Stock: " + prod.getStock());
            buscado = buscado.getSiguienteNodo();
        }
    }
    
    public boolean eliminar(String clave) {
        return productos.eliminar(clave);
    }
    
    public String imprimirProductos() {
        return productos.imprimir();
    }
}
