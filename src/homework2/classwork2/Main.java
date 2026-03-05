package homework2.classwork2;

import homework1.Fraction;

public class Main {
    public static void main(String[] args){
        System.out.println("Детектор стирания");
        Box<Integer> box1 = new Box<>(100);
        Box<Double> box2 = new Box<>(1053.0);

        System.out.println(box1.getClass() == box2.getClass());

        System.out.println("Калькулятор");

        Calculator<Integer> intCalc = new Calculator<>();
        System.out.println(intCalc.add(10, 17));

        Calculator<Double> doubleCalc = new Calculator<>();
        System.out.println(doubleCalc.multiply(10.9, 7.5));
        
        Calculator<Fraction> fractionCalc = new Calculator<>();
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(3, 4);
        System.out.println(fractionCalc.subtract(f1, f2));
        System.out.println(fractionCalc.divide(f1, f2));

        Calculator<Double> doubleCalc2 = new Calculator<>();
        System.out.println(doubleCalc2.divide(10.0,0.0));

    }
}
