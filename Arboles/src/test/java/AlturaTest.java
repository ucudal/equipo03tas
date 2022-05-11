package Test;

import arboles.ArbolBB;
import arboles.Cedula;
import arboles.ElementoAB;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlturaTest {
    private Cedula cedula1;
    private Cedula cedula2;
    private Cedula cedula3;
    private ArbolBB arbol1;
    private ElementoAB elem1;
    private ElementoAB elem2;
    private ElementoAB elem3;
                    
    public AlturaTest() {
    }
   
    public void setUp() {
        cedula1 = new Cedula("Sebastian",50820842);
        cedula2 = new Cedula("Marcelo",123123122);
        cedula3 = new Cedula("Sandra",12389123);
        
        arbol1 = new ArbolBB();
        elem1 = new ElementoAB(1,cedula1);
        elem2 = new ElementoAB(2,cedula2);
        elem3 = new ElementoAB(3,cedula3);
    }

    @Test
    public void alturaArbolTest(){
        setUp();
        assertTrue(arbol1.esVacio());
        arbol1.insertar(elem1);
        int alturaArbol = arbol1.altura();
        assertEquals(alturaArbol,1);
        
        arbol1.insertar(elem2);
        alturaArbol = arbol1.altura();     
        assertEquals(alturaArbol,2);
        
        arbol1.insertar(elem3);
        alturaArbol = arbol1.altura();
        assertEquals(alturaArbol,3);
    }
}