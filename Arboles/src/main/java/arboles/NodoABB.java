package arboles;

public class NodoABB<T> implements INodoABB<T> {
    private T dato;

    private Comparable etiqueta;
    private NodoABB hijoIzq;
    private NodoABB hijoDer;
    
    public int contarHojas() {
        int chi = 0;
        int chd = 0;
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }
        if (hijoIzq != null) {
            chi = hijoIzq.contarHojas();
        }
        if (hijoDer != null) {
            chd = hijoDer.contarHojas();
        }
        return chi + chd;
    }

    public int tamanio() {
        int suma = 1;
        if (hijoIzq != null) {
            suma += hijoIzq.tamanio();
        }
        if (hijoDer != null) {
            suma += hijoDer.tamanio();
        }
        return suma;
    }

    public int altura() {
        int alturaIzq = 0;
        int alturaDer = 0;
        if (hijoIzq == null && hijoDer == null) {
            return 0;
        }
        if (hijoIzq != null) {
            alturaIzq = hijoIzq.altura();
        }
        if (hijoDer != null) {
            alturaDer = hijoDer.altura();
        }
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoABB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoABB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoABB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoABB hijoDer) {
        this.hijoDer = hijoDer;
    }
}
