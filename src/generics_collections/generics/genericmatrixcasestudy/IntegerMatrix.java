package generics_collections.generics.genericmatrixcasestudy;

public class IntegerMatrix extends GenericMatrix<Integer>{

    @Override
    protected Integer add(Integer e1, Integer e2) {
        
        return e1.intValue() +e2.intValue();
    }

    @Override
    protected Integer multiply(Integer e1, Integer e2) {
        return e1.intValue() * e2.intValue();
    }

    @Override
    protected Integer zero() {
        return 0;
        
    }
    
}
