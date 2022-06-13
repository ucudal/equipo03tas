import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.util.CalculadorMatricesOptimo;

public class CalculadorMatricesOptimoTest {

    String gato = "gato";
    String perro = "perro";
    String raton = "raton";
    String zorro = "zorro";
    String[] claves = {gato, perro, raton, zorro};
    int cantElem = 4;
    int[] frecExito = {5, 3, 4, 2};
    int[] frecNoExito = {1, 3, 1, 3, 7};

    //encontrarOptimoTest
    @Test
    public void encontrarOptimoTest() {
        CalculadorMatricesOptimo calculador = new CalculadorMatricesOptimo(cantElem);
        calculador.encontrarOptimo(cantElem, frecExito, frecNoExito);
        System.out.println("W: ");
        calculador.printW();


    }

}
