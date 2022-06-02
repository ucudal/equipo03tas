package arboles;

public class TArbolAVL<T> extends ArbolBB<T> {
    public int factorEquilibrio(){
        if (getRaiz() == null){
            return 0;
        }
        return ( (TElementoAVL<T>)getRaiz()).getFactorEq();
    }
}
