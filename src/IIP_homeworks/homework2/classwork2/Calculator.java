package IIP_homeworks.homework2.classwork2;

public class Calculator<T extends Number> {
    public double add(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }

    public double subtract(T a, T b){
        return a.doubleValue() - b.doubleValue();
    }

    public double multiply(T a, T b){
        return a.doubleValue() * b.doubleValue();
    }

    public double divide(T a, T b) {
        if (b.doubleValue() == 0.0) {
            System.out.println("Деление на ноль!");
            return Double.NaN; //подглядел из дип сика, чтобы вернуть не число
        } else {
            return a.doubleValue() / b.doubleValue();
        }
    }
}
