

public interface INodo {
	/**
	 * Retorna la clave contenida en el nodo.
	 * 
	 * @return Clave contenida en el nodo.
	 */
	public String getClave();
	
	/**
	 * Asigna una clave al nodo.
	 * @param unaClave Clave a asignar.
	 */
	public void setClave(String unaClave);
	
	/**
	 * Asigna el siguiente nodo al nodo actual.
	 * @param nodo Nodo a asignar como siguiente.
	 */
	public void setSiguiente(INodo nodo);
	
	/**
	 * Retorna el siguiente nodo al nodo actual.
	 * @return Siguiente nodo del actual
	 */
	public INodo getSiguiente();
}
