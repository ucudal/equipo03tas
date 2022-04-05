package TA1;

public class TLista <T> {

    private TNodo <T> primero ;

    public TLista(TNodo <T> unNodo) {
        primero=unNodo;
    }
    
    public TLista() {
        
    }

    public void insertar(TNodo <T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            TNodo <T> aux = primero;
         while (aux.getSiguienteNodo() != null) {
                aux = aux.getSiguienteNodo();
            }
            aux.setSiguienteNodo(nodo);
        }
    }


    public TNodo <T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            TNodo <T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguienteNodo();
            }
        }
        return null;


    }   
    public TNodo <T> getPrimero() {
        return primero;
    }
    
    public void insertarOrdenado(TNodo <T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            TNodo aux = primero;
            if (nodo.getEtiqueta().compareTo(aux.getEtiqueta())<0){
                nodo.setSiguienteNodo(aux);
                primero = nodo;
            }

            while (aux.getSiguienteNodo() != null) {
                if (nodo.getEtiqueta().compareTo(aux.getEtiqueta())<0){
                    nodo.setSiguienteNodo(aux.getSiguienteNodo());
                    aux.setSiguienteNodo(nodo);
                    return;
                }
                aux = aux.getSiguienteNodo();
            }
            aux.setSiguienteNodo(nodo);
        }
    }

    public boolean esVacia() {
        return primero == null;
    }
}
