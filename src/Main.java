public class Main {
    public static void main(String[] args) {
        System.out.println("Сценарий 1:");
        ItemStorage<Integer> script1 = new ItemStorage<>(100);
        script1.compareWith(100);

        System.out.println("Сценарий 2:");
        ItemStorage<Integer> script2 = new ItemStorage<>(200);
        script2.compareWith(200);//выведит true, т.к. в ItemStorage я использовал equals

        System.out.println("Сценарий 3:");
        ItemStorage<Fraction> script3 = new ItemStorage<>(new Fraction(1,2));
        script3.compareWith(new Fraction(1,2));
    }
}