package AISD_homeworks.HW2;

public class Calculator {
    public static int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack stack = new Stack();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.add(new StackNode(stack.remove().getValue() + stack.remove().getValue()));
                    break;
                case "-":
                    int subtrahend = stack.remove().getValue();
                    int minuend = stack.remove().getValue();
                    stack.add(new StackNode(minuend - subtrahend));
                    break;
                case "*":
                    stack.add(new StackNode(stack.remove().getValue() * stack.remove().getValue()));
                    break;
                default:
                    stack.add(new StackNode(Integer.parseInt(token)));
            }
        }
        return stack.remove().getValue();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("2 3 + 4 *"));
    }
}
