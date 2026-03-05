package homework3.classwork3;

public class UniversalCalculator {
    public static double add(Number a, Number b){
        return a.doubleValue() + b.doubleValue();
    }

    public static double subtract(Number a, Number b){
        return a.doubleValue() - b.doubleValue();
    }

    public static double multiply(Number a, Number b){
        return a.doubleValue() * b.doubleValue();
    }

    public static double divide(Number a, Number b) {
        if (b.doubleValue() == 0.0) {
            throw new ArithmeticException("Деление на ноль!");
        } else {
            return a.doubleValue() / b.doubleValue();
        }
    }
}

