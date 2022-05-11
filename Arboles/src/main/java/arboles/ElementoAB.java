package arboles;

public class ElementoAB<T> implements IElementoAB<T>{
    private T dato;
    private Comparable etiqueta;
    private IElementoAB<T> hijoIzq;
    private IElementoAB<T> hijoDer;

    public ElementoAB(Comparable unaEtiqueta, T dato){
        this.etiqueta = unaEtiqueta;
        this.dato = dato;
    }

    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        if (unElemento == null) return false;

        int comparable = unElemento.getEtiqueta().compareTo(this.etiqueta);
        // Izquierdo
        if (comparable < 0) {
            if (hijoIzq != null) {
                return hijoIzq.insertar(unElemento);
            }
            hijoIzq = unElemento;
            return true;
        }
        // Derecho
        if (comparable > 0) {
            if (hijoDer != null) {
                return hijoDer.insertar(unElemento);
            }
            hijoDer = unElemento;
            return true;
        }
        // Ya existe la etiqueta
        return false;
    }

    @Override
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

    @Override
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

    @Override
    public int altura() {
        int alturaIzq = 0;
        int alturaDer = 0;
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

    @Override
    public IElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public void setHijoIzq(IElementoAB<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    @Override
    public IElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoDer(IElementoAB hijoDer) {
        this.hijoDer = hijoDer;
    }

    @Override
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

    @Override
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
     @Override
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

    @Override
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
