package arboles;

public class ArbolBB<T> implements IArbolBB<T> {
    private ElementoAB<T> raiz;

    @Override
    public boolean insertar(ElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        }
        return raiz.insertar(unElemento);
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {

    }

    @Override
    public ElementoAB<T> buscar(Comparable unaEtiqueta) {
       if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        return null;
    }

    @Override
    public String inOrden() {
        return null;
    }

    @Override
    public String postOrden() {
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

    public ElementoAB<T> getRaiz()
    {
        return raiz;
    }

    public void setRaiz(ElementoAB<T> nuevaRaiz)
    {
        raiz = nuevaRaiz;
    }
}
