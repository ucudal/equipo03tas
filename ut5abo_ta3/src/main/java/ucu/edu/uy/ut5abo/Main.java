/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut5abo;

import ucu.edu.uy.tda.IArbolBB;
import ucu.edu.uy.tda.INodo;
import ucu.edu.uy.tda.Lista;
import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.util.CalculadorMatricesOptimo;
import ucu.edu.uy.util.ManejadorArchivosGenerico;

/**
 *
 * @author nnavarro
 */
public class Main
{

    public static void main(String[] args)
    {
      
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
        
    } 
}
