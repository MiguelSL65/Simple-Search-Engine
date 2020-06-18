import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] values = expression.split(" ");

        long firstOperand = Long.parseLong(values[0]);
        long secondOperand = Long.parseLong(values[2]);

        String operator = values[1];

        switch (operator) {
            case "+":
                System.out.println(firstOperand + secondOperand);
                break;
            case "-":
                System.out.println(firstOperand - secondOperand);
                break;
            case "/":
                if (secondOperand == 0) {
                    System.out.println("Division by 0!");
                } else {
                    System.out.println(firstOperand / secondOperand);
                }
                break;
            case "*":
                System.out.println(firstOperand * secondOperand);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}