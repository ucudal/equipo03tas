package TA1;

public class Geant {

    public static void main(String[] args) {
        //Creamos el alamcen
        Almacen almacen = new Almacen("Geant");
        almacen.agregarStockDesdeArchivo("altasPrueba.txt");
        
        /*
        //Creamos algunos productos
        Producto arroz = new Producto("1001", "Arroz Saman", (float) 45.99, 10);
        Producto aceite = new Producto("1002", "Aceite Optimo", (float) 39.99, 15);
        Producto agua = new Producto("1003", "Agua Salus", (float) 89.99, 5);
        Producto fideo = new Producto("1004", "Fideos Adria", (float) 64.99, 23);
        Producto sal = new Producto("1005", "Sal Himalaya", (float) 99.99, 2);
        Producto lechuga = new Producto("1006", "Lechuga crespa", (float) 15.99, 3);
        
        //Agregar productos al stock
        almacen.agregarProducto(arroz);
        almacen.agregarProducto(aceite);
        almacen.agregarProducto(agua);
        almacen.agregarProducto(fideo);
        almacen.agregarProducto(sal);
        almacen.agregarProducto(lechuga);
        
        //Agregar stock a productos ya existentes
        almacen.agregarStockAProducto(10, "1001");
        almacen.agregarStockAProducto(1, "1003");
        almacen.agregarStockAProducto(5, "1006");
        
        //Reducir stock a productos ya existentes
        almacen.reducirStock(2, "1002");
        almacen.reducirStock(1, "1005");
        */
        
        almacen.reducirStockAProductoArchivo("ventasPrueba.txt");
        
        almacen.imprimirStock();
    }
}

































