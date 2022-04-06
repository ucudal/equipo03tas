package TA1;



public class TNodo <T> {
    private String etiqueta;
    private TNodo <T> siguienteNodo;
    private T dato;

    public TNodo() {
    }
    
    public TNodo (String  etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
    
    public String getEtiqueta() {
        return etiqueta;
    }

    public T getDato() {
        return dato;
    }
    
    public TNodo <T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(TNodo <T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
    
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
   
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

}
