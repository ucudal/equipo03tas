package arboles;

public class Lista<T> implements ILista<T> {

    Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo <T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo <T> aux = primero;
         while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    public void insertarAlInicio(Nodo<T> newNodo) {
        newNodo.setSiguiente(this.primero);
        this.primero = newNodo;
    }

    public void insertarAlFinal(Nodo<T> newNodo) {
        Nodo<T> aux = this.primero;
        if (aux == null) {
            this.primero = newNodo;
        } else {
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(newNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave)
    {
        Nodo<T> aux = this.primero;
        while (aux != null) {
            if (aux.getEtiqueta().compareTo(clave) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp1 = aux;
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux;
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    public void insertarOrdenado(Nodo<T> newNodo) {
        Nodo<T> aux = this.primero;
        if (aux == null || newNodo.getEtiqueta().compareTo(aux.getEtiqueta()) < 0) {
            newNodo.setSiguiente(this.primero);
            this.primero = newNodo;
        } else {
            while (aux.getSiguiente() != null && aux.getSiguiente().getEtiqueta().compareTo(newNodo.getEtiqueta()) < 0) {
                aux = aux.getSiguiente();
            }
            newNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(newNodo);
        }
    }
}
