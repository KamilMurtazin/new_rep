public class RationalFraction {
    protected int num1;
    protected int num2;

    public RationalFraction() {
        this(0, 1);
    }
    public RationalFraction(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
        reduce();
    }

    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }

    public void setNum1(int num1){
        this.num1 = num1;
        reduce();
    }
    public void setNum2(int num2){
        this.num2 = num2;
        reduce();
    }

    public void reduce() {
        int a = num1;
        int b = num2;

        // Находим НОД
        int gcd = 1;
        int min = Math.min(Math.abs(a), Math.abs(b));

        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        if (gcd > 1) {
            num1 = a / gcd;
            num2 = b / gcd;
        }

        // Делаем знаменатель положительным
        if (num2 < 0) {
            num1 = -num1;
            num2 = -num2;
        }
    }

    public RationalFraction add(RationalFraction another) {
        // ФИКС: создаем новый объект вместо использования несуществующей переменной b
        return new RationalFraction(
                this.num1 * another.getNum2() + another.getNum1() * this.num2,
                this.num2 * another.getNum2()
        );
    }

    public void add2(RationalFraction another) {
        setNum1(getNum1() * another.getNum2() + another.getNum1() * getNum2());
        setNum2(getNum2() * another.getNum2());
        // reduce() вызывается автоматически в setNum1() и setNum2()
    }

    public RationalFraction sub(RationalFraction other) {
        return new RationalFraction(getNum1() * other.getNum2() - other.getNum1() * getNum2(), getNum2() * other.getNum2());
    }

    public void sub2(RationalFraction another) {
        setNum1(getNum1() * another.getNum2() - another.getNum1() * getNum2());
        setNum2(getNum2() * another.getNum2());
    }

    public RationalFraction mult(RationalFraction another) {
        return new RationalFraction(getNum1() * another.getNum1(), getNum2() * another.getNum2());
    }

    public void mult2(RationalFraction another) {
        setNum1(getNum1() * another.getNum1());
        setNum2(getNum2() * another.getNum2());
    }

    public RationalFraction div(RationalFraction another) {
        return new RationalFraction(getNum1() * another.getNum2(), getNum2() * another.getNum1());
    }

    public void div2(RationalFraction another) {
        setNum1(getNum1() * another.getNum2());
        setNum2(getNum2() * another.getNum1());
    }

    public String toString() {
        return getNum1() + "/" + getNum2();
    }

    public double value() {
        return ((double) getNum1()) / ((double) getNum2());
    }

    public boolean equals(RationalFraction another) {
        // Сравниваем после сокращения
        RationalFraction temp1 = new RationalFraction(this.num1, this.num2);
        RationalFraction temp2 = new RationalFraction(another.num1, another.num2);
        return temp1.getNum1() == temp2.getNum1() && temp1.getNum2() == temp2.getNum2();
    }

    public int numberPart() {
        // ФИКС: добавили return
        return getNum1() / getNum2();
    }
}