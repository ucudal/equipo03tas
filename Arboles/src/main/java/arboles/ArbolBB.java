package arboles;

public class ArbolBB<T> implements IArbolBB<T> {
    private NodoABB<T> raiz;

    @Override
    public boolean insertar(NodoABB<T> unElemento) {
        return false;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {

    }

    @Override
    public NodoABB<T> buscar(Comparable unaEtiqueta) {
        return null;
    }

    public int contarHojas() {
        if (raiz == null) {
            return 0;
        }
        return raiz.contarHojas();
    }

    public int tamanio() {
        if (raiz == null) {
            return 0;
        }
        return raiz.tamanio();
    }

    public int altura() {
        if (raiz == null) {
            return 0;
        }
        return raiz.altura();
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public NodoABB<T> getRaiz()
    {
        return raiz;
    }

    public void setRaiz(NodoABB<T> nuevaRaiz)
    {
        raiz = nuevaRaiz;
    }
}
