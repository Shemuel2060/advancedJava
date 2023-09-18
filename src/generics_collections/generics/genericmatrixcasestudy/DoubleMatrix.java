package generics_collections.generics.genericmatrixcasestudy;

public class DoubleMatrix extends GenericMatrix<Double> {

    @Override
    protected Double add(Double e1, Double e2) {
        
        return e1.doubleValue() + e2.doubleValue() ;
    }

    @Override
    protected Double multiply(Double e1, Double e2) {
        
        return e1.doubleValue() + e2.doubleValue();
    }

    @Override
    protected Double zero() {
        return 0.0;
    }
    
    
}
