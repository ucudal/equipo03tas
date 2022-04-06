package TA1;

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

    public boolean agregarStockAProducto(int cantidadProductoAgregar, Comparable codigoProducto) {
        TNodo<Producto> buscado = productos.getPrimero();
        while (buscado != null) {
            Producto prod = (Producto) buscado.getDato();
            if (buscado.getEtiqueta().equals(codigoProducto)) {
                int stockActual = prod.getStock();
                prod.setStock(stockActual + cantidadProductoAgregar);
                System.out.println("El articulo: " + prod.getNombre() + " incremento stock en :" + cantidadProductoAgregar);
                return true;
            }
            buscado = buscado.getSiguienteNodo();
        }
        return false;
    }

    public void reducirStock(int cantidadProductoReducir, String codigoProducto) {
        TNodo<Producto> primero = productos.getPrimero();
        while (primero != null) {
            Producto prod = primero.getDato();
            if (primero.getEtiqueta().equals(codigoProducto)) {
                if (cantidadProductoReducir >= prod.getStock()) {
                    prod.setStock(0);
                    //return (0);
                    System.out.println("El stock del producto " + prod.getNombre() + "se redujo a " + "0");
                } else {
                    prod.setStock(prod.getStock() - cantidadProductoReducir);
                    System.out.println("El stock del producto " + prod.getNombre() + "se redujo a " + prod.getStock());
                }
            }
            primero = primero.getSiguienteNodo();
        }
        System.out.println("El articulo no existe");
    }

    public void reducirStockAProductoArchivo(String archivoVentas) {
        String[] ventas = ManejadorArchivosGenerico.leerArchivo(archivoVentas);
        for (String lineaLeida : ventas) {
            try {
                String[] lineaAProcesar = lineaLeida.split(",");
                reducirStock(Integer.parseInt(lineaAProcesar[1].trim()), (lineaAProcesar[0].trim()));
            } catch (Exception e) {
                System.out.println("Fallo al leer linea.");
            }
        }
    }
    
    public void agregarStockDesdeArchivo(String archivoAltas) {
        String[] altas = ManejadorArchivosGenerico.leerArchivo(archivoAltas);
        try {
            for (String lineaLeida : altas) {
                String[] lineaAProcesar = lineaLeida.split(",");
                Producto prod = new Producto(lineaAProcesar[0], lineaAProcesar[1], Float.parseFloat(lineaAProcesar[2]), Integer.parseInt(lineaAProcesar[3]));
                boolean checkProduct = agregarStockAProducto(Integer.parseInt(lineaAProcesar[3]), lineaAProcesar[0]);
                if (!checkProduct){
                    agregarProducto(prod);//Si el producto no esta en la lista
                } else{
                    System.out.println("Se ha modificado el stock del producto: " + prod.getNombre() + " y su stock a " + prod.getStock() + ".");
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
