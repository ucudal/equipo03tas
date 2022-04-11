/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut3.ta16;

import ucu.edu.uy.tda.ILista;
import ucu.edu.uy.tda.Lista;
import ucu.edu.uy.tda.ListaOrdenada;
import ucu.edu.uy.tda.Nodo;
import ucu.edu.uy.util.ManejadorArchivosGenerico;

/**
 *
 * @author nnavarro
 */
public class Productora
{

    public static final String ARCHIVO_PELIS = "peliculas.csv";
    public static final String ARCHIVO_PERSONAS = "personas.csv";
    public static final String ARCHIVO_PERSONAS_EN_PELIS = "pers_participa_peli.csv";

    public Lista<Pelicula> peliculas = new Lista<>();

    public void cargarDatos()
    {
        this.peliculas = cargarPeliculas();
        Lista<Participante> participantes = cargarParticipantes();
        cargarParticipantesEnPeliculas(participantes, peliculas);
    }

    private Lista<Pelicula> cargarPeliculas()
    {
        System.out.println("\n***** CARGANDO PELICULAS *****");
        int correcto = 0;
        int incorrecto = 0;

        Lista<Pelicula> peliculas = new Lista<>();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ARCHIVO_PELIS);
        for (String linea : lineas)
        {
            String[] datos = linea.split(",");
            try
            {
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int anio = Integer.parseInt(datos[2]);
                int score = Integer.parseInt(datos[3]);
                String genero = datos[4];
                String idiomaOriginal = datos[5];

                Pelicula pelicula = new Pelicula(id, nombre, anio, score, genero, idiomaOriginal);
                Nodo<Pelicula> nodo = new Nodo<>(pelicula.getId(), pelicula);
                peliculas.insertarPrimero(nodo);
                correcto++;
            }
            catch (Exception e)
            {
                System.out.println("Error al leer linea: " + linea + " : " + e.getMessage());
                incorrecto++;
            }
        }

        System.out.println("----- CARGADAS " + correcto + " PELICULAS, "+ incorrecto +" ERRORES -----");
        return peliculas;
    }

    private Lista<Participante> cargarParticipantes()
    {
        System.out.println("\n***** CARGANDO PARTICIPANTES *****");
        int correcto = 0;
        int incorrecto = 0;

        Lista<Participante> participantes = new Lista<>();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ARCHIVO_PERSONAS);
        for (String linea : lineas)
        {
            String[] datos = linea.split(",");
            try
            {
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                Participante participante = new Participante(id, nombre);
                Nodo<Participante> nodo = new Nodo<>(participante.getId(), participante);
                participantes.insertarPrimero(nodo);
                correcto++;
            }
            catch (Exception e)
            {
                System.out.println("Error al leer linea: " + linea + " : " + e.getMessage());
                incorrecto++;
            }
        }

        System.out.println("----- CARGADOS " + correcto + " PARTICIPANTES, " + incorrecto + " ERRORES -----");
        return participantes;
    }

    private void cargarParticipantesEnPeliculas(Lista<Participante> participantes, Lista<Pelicula> peliculas)
    {
        System.out.println("\n***** CARGANDO PARTICIPANTES EN PELICULAS *****");
        int correcto = 0;
        int incorrecto = 0;

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ARCHIVO_PERSONAS_EN_PELIS);
        for (String linea : lineas)
        {
            String[] datos = linea.split(",");
            try
            {
                int idParticipante = Integer.parseInt(datos[0]);
                int idPelicula = Integer.parseInt(datos[1]);

                Nodo<Pelicula> nodoPelicula = peliculas.buscar(idPelicula);
                Nodo<Participante> nodoParticipante = participantes.buscar(idParticipante);

                if (nodoPelicula != null && nodoParticipante != null)
                {
                    nodoPelicula.getDato().getParticipantes().insertarPrimero(nodoParticipante.clonar());
                    correcto++;
                }
                else
                {
                    System.out.println("Participante y/o pelicula no encontrados: " + linea);
                    incorrecto++;
                }
            }
            catch (Exception e)
            {
                System.out.println("Error al leer linea: " + linea + " : " + e.getMessage());
                incorrecto++;
            }
        }

        System.out.println("----- "+ correcto + " RELACIONES PARTICIPANTE-PELICULA CARGADAS, " + incorrecto +" ERRORES -----");
    }

    public ILista<Participante> obtenerParticipantesPelicula(Comparable idPelicula)
    {
        Nodo<Pelicula> nodoEncontrado = peliculas.buscar(idPelicula);
        if (nodoEncontrado != null)
        {
            return nodoEncontrado.getDato().getParticipantes();
        }
        return null;
    }

    public ILista<Pelicula> obtenerPeliculasDelParticipante(Comparable idParticipante)
    {
        
        ListaOrdenada<Pelicula> participoEn = new ListaOrdenada<Pelicula>();
        Nodo<Pelicula> peliAux = peliculas.getPrimero();
        while (peliAux != null)
        {
            if (peliAux.getDato().getParticipantes().buscar(idParticipante) != null)
            {
                Pelicula peli = peliAux.getDato();
                Nodo<Pelicula> nodoAlfabetico = new Nodo<>(peli.getNombre(), peli);
                participoEn.insertar(nodoAlfabetico);
            }
            peliAux = peliAux.getSiguiente();
        }
        return participoEn;
    }
}
