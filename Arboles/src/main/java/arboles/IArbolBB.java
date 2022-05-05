package arboles;

public interface IArbolBB<T> {
    public boolean insertar(NodoABB<T> unElemento);
    public void eliminar(Comparable unaEtiqueta);
    public NodoABB<T> buscar(Comparable unaEtiqueta);
    public int tamanio();
    public int	altura();
    public	int contarHojas();
    public boolean esVacio();
}
