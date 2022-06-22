/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut5abo;

import ucu.edu.uy.tda.*;
import ucu.edu.uy.util.CalculadorMatricesOptimo;
import ucu.edu.uy.util.ManejadorArchivosGenerico;

public class Main
{

    public static void main(String[] args)
    {
        /* TA2 y TA3
        TArbolBB elArbol = new TArbolBB();
        // cargar CLAVES y FRECUENCIAS DE BUSQUEDAS EXITOSAS
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("palabras2.txt");
        int cantElementos = lineas.length;
        String[] claves = new String[cantElementos+1];
        int[] frecExito = new int[cantElementos+1];
        for (int i = 1; i <= lineas.length; i++) {
            String linea = lineas[i-1];
            String[] valores = linea.split(" ");
            claves[i] = valores[0];
            frecExito[i] = Integer.valueOf(valores[1]);

          }
        
        
        // cargar FRECUENCIAS DE BUSQUEDAS NO EXITOSAS
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("nopalabras2.txt");

        int[] frecNoExito = new int[cantElementos+1];
        for (int j = 0; j < lineas2.length; j++) {
            String linea = lineas2[j];
            frecNoExito[j] = Integer.valueOf(linea);
        }
        
        CalculadorMatricesOptimo calculadorABO = new CalculadorMatricesOptimo(cantElementos);
        calculadorABO.encontrarOptimo(cantElementos, frecExito, frecNoExito);

        // IMPRIMIR RAIZ A PARTIR DE MATRIZ R
        
        //
        // MOSTRAR MATRIZ R
        System.out.println("Matriz R: ");
       CalculadorMatricesOptimo.imprimirMatriz(calculadorABO.R);
         // MOSTRAR MATRIZ P
       System.out.println("Matriz P: ");
       CalculadorMatricesOptimo.imprimirMatriz(calculadorABO.P);
         // MOSTRAR MATRIZ W
        System.out.println("Matriz W: ");
        CalculadorMatricesOptimo.imprimirMatriz(calculadorABO.W);

        System.out.println(elArbol.calcularCosto(frecExito, frecNoExito));
*/



        /* TA15
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("palabras2.txt");
        int cantElementos = lineas.length;
        String[] claves = new String[cantElementos+1];
        int[] frecExito = new int[cantElementos+1];
        ArrayList<String> listLineas = new ArrayList<>(cantElementos);
        Collections.addAll(listLineas, lineas);
        Collections.shuffle(listLineas);
        for (int i = 0; i < listLineas.size(); i++) {
            String linea = listLineas.get(i);
            String[] valores = linea.split(" ");
            claves[i + 1] = valores[0];
            frecExito[i + 1] = Integer.valueOf(valores[1]);
        }
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("nopalabras2.txt");

        int[] frecNoExito = new int[cantElementos+1];
        for (int j = 0; j < lineas2.length; j++) {
            String linea = lineas2[j];
            frecNoExito[j] = Integer.valueOf(linea);
        }

        CalculadorMatricesOptimo calculadorABO = new CalculadorMatricesOptimo(cantElementos);
        calculadorABO.encontrarOptimo(cantElementos, frecExito, frecNoExito);
        TArbolBB<String> elArbol = new TArbolBB<>();
        calculadorABO.armarArbolBinario(0, cantElementos, claves, elArbol);
        System.out.println("LongTrayInterna " + elArbol.longTrayInterna());

         */

        // TA9
        // 1 - Leer un archivo de palabras claves, y con cada una de ellas armar un árbol binario de
        //búsqueda.
        String[] lineasKW = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        String[] keywords = new String[lineasKW.length];
        for (int i = 0; i < lineasKW.length; i++) {
            String[] split = lineasKW[i].split(" ");
            keywords[i] = split[0];
        }
        TArbolBB<String> arbolKW = new TArbolBB<>();
        // TO-DO - Hacer shuffle
        for (String keyword : keywords) {
            TElementoAB<String> elemento = new TElementoAB<>(keyword, keyword);
            arbolKW.insertar(elemento);
        }

        // 2 - Leer un texto, y por cada palabra de ese texto, buscarla en ese árbol binario de
        //búsqueda, y... (contFrec)
        String[] lineasArchivo = ManejadorArchivosGenerico.leerArchivo("codigoJava.txt");
        Lista<String> listaPalabras = new Lista<>();
        for (String linea : lineasArchivo) {
            String[] split = linea.split(" ");
            for (String palabra : split) {
                Nodo<String> nodo = new Nodo<>(palabra, palabra);
                listaPalabras.insertar(nodo);
            }
        }
        // contFrec de cada palabra
        Nodo<String> aux = listaPalabras.getPrimero();
        while (aux != null) {
            arbolKW.cuentaFrec(aux.getDato());
            aux = aux.getSiguiente();
        }

        // 3 - Instanciar un vector de frecuencias exitosas, un vector de frecuencias no exitosas y un
        //vector de claves, para ser usados como entradas en la confección del árbol óptimo.
        int cantElementos = lineasKW.length;
        int[] frecExito = new int[cantElementos + 1];
        int[] frecNoExito = new int[cantElementos + 1];

        //se usa cantElementos + 1 porque el primer elemento del vector claves siempre queda vacio.
        String[] claves = new String[cantElementos + 1];
        for (int i = 0; i < keywords.length; i++) {
            claves[i + 1] = keywords[i];
        }

        // 4 - Recorrer el árbol para cargar los valores de esos vectores a partir de los valores
        //contenidos en cada elemento.

        arbolKW.completaVectores(claves, frecExito, frecNoExito);

        // 5 - A partir de los vectores obtenidos, construir el árbol binario de búsqueda óptima de las
        //palabras claves.

        CalculadorMatricesOptimo calculadorABO = new CalculadorMatricesOptimo(cantElementos);
        calculadorABO.encontrarOptimo(cantElementos, frecExito, frecNoExito);
        TArbolBB<String> arbolCodigo = new TArbolBB<>();
        calculadorABO.armarArbolBinario(0, cantElementos, claves, arbolCodigo);

        Lista<String> inorden = arbolCodigo.inOrden();
        System.out.println("Inorden: \n" + inorden.imprimir("\n"));

    }
}
