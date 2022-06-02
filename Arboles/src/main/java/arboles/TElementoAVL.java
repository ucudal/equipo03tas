package arboles;

public class TElementoAVL<T> extends ElementoAB<T> {

    public TElementoAVL(Comparable unaEtiqueta, T dato) {
        super(unaEtiqueta, dato);
    }

    private int factorEq;

    public int factorEquilibrio(){
        int alturaIzq = 0;
        int alturaDer = 0;
        if (getHijoIzq() == null && getHijoDer() == null){
            return 0;
        }
        if (getHijoIzq() != null) {
            alturaIzq = ((TElementoAVL<T>) getHijoIzq()).factorEquilibrio();
        }
        if (getHijoDer() != null) {
            alturaDer = ((TElementoAVL<T>) getHijoDer()).factorEquilibrio();
        }
        factorEq = alturaDer - alturaIzq;
        return Math.max(alturaDer, alturaIzq) + 1;
    }

    public int getFactorEq() {
        return factorEq;
    }
}
