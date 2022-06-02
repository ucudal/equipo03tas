/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package arboles;

public class Main {

    public static void main(String[] args) {

        /*
        ArbolBB<Integer> arbol = new ArbolBB<>();

        String[] consultas = ManejadorArchivosGenerico.leerArchivo("Claves1.txt");  // Leer un arvhivo
        for (String string : consultas) {
            String[] linea = string.trim().split(",");
            try { //manejo de excepciones
                ElementoAB<Integer> unElementoAB = new ElementoAB<>(Integer.parseInt(linea[0]), Integer.parseInt(linea[0]));
                arbol.insertar(unElementoAB);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }

        System.out.println("Altura " + arbol.altura());
        System.out.println("Hojas " + arbol.contarHojas());
        System.out.println("Tamanio " + arbol.tamanio());
        IElementoAB<Integer> busqueda = arbol.buscar(412);
        System.out.println(busqueda.getEtiqueta());
        System.out.println(arbol.inOrden());
        System.out.println(arbol.preOrden());
        System.out.println(arbol.postOrden());
        */

        TArbolAVL<Integer> arbolAVL = new TArbolAVL<>();
        Integer uno = 1;
        Integer dos = 2;
        Integer tres = 3;
        Integer cuatro = 4;
        Integer cinco = 5;
        
        TElementoAVL<Integer> elementoUno = new TElementoAVL<>(uno, uno);
        TElementoAVL<Integer> elementoDos = new TElementoAVL<>(dos, dos);
        TElementoAVL<Integer> elementoTres = new TElementoAVL<>(tres, tres);
        TElementoAVL<Integer> elementoCuatro = new TElementoAVL<>(cuatro, cuatro);
        TElementoAVL<Integer> elementoCinco = new TElementoAVL<>(cinco, cinco);

        arbolAVL.insertar(elementoDos);
        arbolAVL.insertar(elementoCuatro);
        arbolAVL.insertar(elementoUno);
        arbolAVL.insertar(elementoTres);

        System.out.println(arbolAVL.factorEquilibrio());
    }
}
