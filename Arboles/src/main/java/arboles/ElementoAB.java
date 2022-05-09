    package arboles;

public class ElementoAB<T> {
    private T dato;

    private Comparable etiqueta;
    private ElementoAB hijoIzq;
    private ElementoAB hijoDer;
    
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

    public ElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(ElementoAB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public ElementoAB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(ElementoAB hijoDer) {
        this.hijoDer = hijoDer;
    }

    public boolean insertar(ElementoAB<T> unElemento) {
        return true;
    }
    
    public ElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }
    
     public String postOrden(){
        String aux="";
        if(hijoIzq!=null){
            aux = hijoIzq.postOrden();
        }        
        if (hijoDer!=null){
            aux = aux + hijoDer.postOrden();
        }
        aux = aux + " " + etiqueta;
        return aux;
    }
    
    public String inOrden() {
        String aux = "";
        if (hijoIzq != null) {
            aux = hijoIzq.inOrden();
        }
        aux += this.etiqueta;
        if (hijoDer != null) {
            aux = aux + " " + hijoDer.inOrden();
        }
        return aux;
    }
    
    
    
    
    
    
}
