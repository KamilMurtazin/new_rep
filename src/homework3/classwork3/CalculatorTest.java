package homework3.classwork3;

public class CalculatorTest {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 3;

        System.out.println(UniversalCalculator.add(a, b));
        System.out.println(UniversalCalculator.subtract(a, b));
        System.out.println(UniversalCalculator.multiply(a, b));
        System.out.println(UniversalCalculator.divide(a, b));

        System.out.println(" ");
        double aa = 5.5;
        double bb = 2.2;

        System.out.println(UniversalCalculator.add(aa, bb));
        System.out.println(UniversalCalculator.subtract(aa, bb));
        System.out.println(UniversalCalculator.multiply(aa, bb));
        System.out.println(UniversalCalculator.divide(aa, bb));

        System.out.println(" ");
        double aaa = 5.5;
        Fraction bbb = new Fraction(1, 2);

        System.out.println(UniversalCalculator.add(aaa, bbb));
        System.out.println(UniversalCalculator.subtract(aaa, bbb));
        System.out.println(UniversalCalculator.multiply(aaa, bbb));
        System.out.println(UniversalCalculator.divide(aaa, bbb));
    }


}
