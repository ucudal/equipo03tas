/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut3.ta16;

import ucu.edu.uy.tda.ILista;

/**
 *
 * @author nnavarro
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Productora productora = new Productora();
        productora.cargarDatos();
        
        ILista<Pelicula> peliculas = productora.obtenerPeliculasDelParticipante(12);
        ILista<Participante> participantesPeli = productora.obtenerParticipantesPelicula(1278);
        
        System.out.println("\n ***** PELICULAS DEL PARTICIPANTE 12 *****");
        System.out.println(peliculas.imprimir(" - "));
        System.out.println("\n ***** PARTICIPANTES DE LA PELICULA 1278 *****");
        System.out.println(participantesPeli.imprimir(" - "));
    }

}
