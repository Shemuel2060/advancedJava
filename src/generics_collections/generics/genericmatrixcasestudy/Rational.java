package generics_collections.generics.genericmatrixcasestudy;

/**
 * The Rational class represents operations on fractions. 
 */
public class Rational extends Number implements Comparable<Rational> {
    private long numerator =0; // the numerator of this rational number
    private long denominator =1; // the denominator of this rational number

    public Rational() {
        this(0, 1); // invoking the second constructor.
    } // end of no-arg constructor -- uses the 2-arg constructor

    /**
     * construct a rational with specified numerator and denominator
     * @param numerator
     * @param denominator
     */
    public Rational(long numerator, long denominator) {
        
        long gcd = gcd(numerator, denominator);
        this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    } // overloaded constructor.

    /**
     * Returns the greatest common divisor of n and d. 
     * @param n
     * @param d
     * @return
     */
    private long gcd(long n, long d) {
        n = Math.abs(n);
        d = Math.abs(d);
        int gcd = 1;    

        for (int k = 1; k <= n && k <= d; k++) {
            if (n % k == 0 && d % k == 0) // n and d are divisible by k
                gcd = k; // by the end of the loop, the greatest common divisor got
        }
        return gcd;
        
    } // end of the gcd() nethod.

    /**
     * Returns numerator of this rational number.
     * @return
     */
    public long getNumerator() {
        return numerator;
    }

    // public void setNumerator(long numerator) {
    //     this.numerator = numerator;
    // }

    /**
     * Returns denominator of this rational number
     * @return
     */
    public long getDenominator() {
        return denominator;
    }

    // public void setDenominator(long denominator) {
    //     this.denominator = denominator;
    // }

    /**
     * Returns the addition of this rational number with another
     *  
     * @param secondRational
     * @return
     */
    public Rational add(Rational secondRational) {
        long n = (this.numerator * secondRational.denominator) + (this.denominator * secondRational.numerator);
        long d = this.denominator * secondRational.denominator;

        return  new Rational(n,d); // create a new Rational object
    }
    
    /**
     * Returns the product of this number with another
     * @param secondRational
     * @return
     */
    public Rational multiply(Rational secondRational) {
        long n = numerator * secondRational.numerator;
        long d = denominator * secondRational.denominator;

        return new Rational(n,d);
    }

    /**
     * Returns the difference of this number with another.
     * @param secondRational
     * @return
     */
    public Rational subtract(Rational secondRational) {
        long n = (this.numerator * secondRational.denominator) - (this.denominator * secondRational.numerator);
        long d = this.denominator * secondRational.denominator;

        return new Rational(n, d); // create a new Rational object
    }

    /**
     * Returns the quotient of this number with another. 
     * @param secondRational
     * @return
     */
    public Rational divide(Rational secondRational) {
        return multiply(reciprocal(secondRational));
    }

    /**
     * This method converts the input rational number to its reciprocal.
     * @param number
     * @return
     */
    public Rational reciprocal(Rational number) {
        long temp = number.denominator;
        number.denominator = number.numerator; // 
        number.numerator = temp;

        return number;
        
    }
    
    
    /* ================= overridden methods ===================== */
    @Override
    public int intValue() {
        
        return (int)doubleValue();
    }

    @Override
    public long longValue() {
    
        return (long)doubleValue();
    }

    @Override
    public float floatValue() {
        
        return (float)doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator*1.0 / denominator;
    }

    @Override
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator() > 0) // this rational number is greater than o
            return 1;
        else if (this.subtract(o).getNumerator() < 0) // this rational number is less than o
            return -1;
        else // both this and o are equal. 
            return 0;
        
    }

    @override
    /**
     * Returns a string in the form “numerator/denominator.” Returns
     * the numerator if denominator is 1.
     */
    public String toString() {
        if (denominator == 1)
            return numerator + " ";
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (numerator ^ (numerator >>> 32));
        result = prime * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Rational other = (Rational) obj;
        if (numerator != other.numerator)
            return false;
        if (denominator != other.denominator)
            return false;
        return true;
    }

}
