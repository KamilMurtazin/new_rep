package IIP_homeworks.homework3.classwork3;

public class NumberBox<T extends Number> {
    private T[] numbers;

    public NumberBox(T[] numbers) {
        this.numbers = numbers;
    }

    public T[] getNumbers() {
        return numbers;
    }
    public void setNumbers(T[] numbers) {
        this.numbers = numbers;
    }

    public static void printSquared(NumberBox<? extends Number> box){
        for (int i = 0; i < box.numbers.length; i ++){
            double square = UniversalCalculator.multiply(box.numbers[i], box.numbers[i]);
            System.out.println(square + "  ");
        }
        System.out.println();
    }

    public static double sum(NumberBox<? extends Number> box){
        double sum = 0;
        for (int i = 0; i < box.numbers.length; i ++){
            sum = UniversalCalculator.add(sum, box.numbers[i]);
        }
        return sum;
    }

    public static void fillWithRandom(NumberBox<? super Double> box){
        Double[] randomNum = new Double[box.numbers.length];
        for (int i = 0; i < randomNum.length; i++){
            randomNum[i] = Math.random();
        }
    }

    public static void copy(NumberBox<? extends Number> box1, NumberBox<? extends Number> box2){
        if (box1.getNumbers().length != box2.getNumbers().length){
            throw new IllegalArgumentException("Different sizes");
        }
        Object[] box3 = box2.getNumbers();
        for (int i = 0; i < box1.getNumbers().length; i ++){
            box3[i] = box1.getNumbers()[i];
        }
    }

    public static NumberBox<Double> addBoxes(NumberBox<? extends Number> box1, NumberBox<? extends Number> box2){
        if (box1.getNumbers().length != box2.getNumbers().length){
            throw new IllegalArgumentException();
        }
        Double[] result = new Double[box1.getNumbers().length];
        for (int i = 0; i < box1.getNumbers().length; i++) {
            result[i] = UniversalCalculator.add(box1.getNumbers()[i], box2.getNumbers()[i]);

        }
        return new NumberBox<>(result);
    }
}
