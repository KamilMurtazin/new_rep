import java.util.Objects;

public class Fraction extends Number{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("Mistake");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalizeSign();
        reduce();

    }

    @Override
    public int intValue(){
        return numerator / denominator;
    }

    @Override
    public long longValue(){
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue(){
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue(){
        return (double) numerator / denominator;
    }

    public void normalizeSign(){
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    public int nod(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public void reduce(){
        int delitel = nod(numerator, denominator);
        if (delitel > 1){
            numerator /= delitel;
            denominator /= delitel;
        }
    }

    public Fraction add(Fraction other){
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction substract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction multiply(Fraction other){
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction divide(Fraction other){
        if (other.numerator == 0){
            throw new ArithmeticException("Mistake");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction negate() {
        return new Fraction(-numerator, denominator);
    }
    public boolean isProper() {
        return Math.abs(numerator) < Math.abs(denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Fraction t = (Fraction) obj;
        return numerator == t.numerator && denominator == t.denominator;
    }

    @Override
    public int hashCode(){
        return Objects.hash(numerator, denominator);
    }
}
