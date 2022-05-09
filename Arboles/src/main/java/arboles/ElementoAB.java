    package arboles;

public class ElementoAB<T> implements IElementoAB<T>{
    private T dato;
    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;

    public ElementoAB(Comparable unaEtiqueta, T dato){
        this.etiqueta = unaEtiqueta;
        this.dato = dato;
    }

    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        int comparable = unElemento.getEtiqueta().compareTo(this.etiqueta);
        // Izquierdo
        if (comparable < 0) {
            if (hijoIzq != null) {
                return hijoIzq.insertar(unElemento);
            }
            hijoIzq = (ElementoAB) unElemento;
            return true;
        }
        // Derecho
        if (comparable > 0) {
            if (hijoDer != null) {
                return hijoDer.insertar(unElemento);
            }
            hijoDer = (ElementoAB) unElemento;
            return true;
        }
        // Ya existe la etiqueta
        return false;
    }

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

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(IElementoAB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public IElementoAB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(IElementoAB hijoDer) {
        this.hijoDer = hijoDer;
    }

    public IElementoAB<T> buscar(Comparable unaEtiqueta) {

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

    public String preOrden() {
        String aux="";
        aux = aux + " " + etiqueta;
        if(hijoIzq!=null){
            aux = aux + hijoIzq.postOrden();
        }
        if (hijoDer!=null){
            aux = aux + hijoDer.postOrden();
        }
        return aux;
    }
     public String postOrden(){
        String aux="";
        if(hijoIzq!=null){
            aux = aux + hijoIzq.postOrden();
        }        
        if (hijoDer!=null){
            aux = aux + hijoDer.postOrden();
        }
        aux = aux + " " + etiqueta;
        return aux;
    }

    @Override
    public T getDatos() {
        return dato;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        return null;
    }

    public String inOrden() {
        String aux = "";
        if (hijoIzq != null) {
            aux = aux + hijoIzq.inOrden();
        }
        aux += " " + this.etiqueta;
        if (hijoDer != null) {
            aux = aux + hijoDer.inOrden();
        }
        return aux;
    }
    
    
    
    
    
    
}
