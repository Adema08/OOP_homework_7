import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public double getNumber() {
        System.out.print("Введите число: ");
        return scanner.nextDouble();
    }

    public char getOperation() {
        System.out.print("Выберите операцию (+, *, /): ");
        return scanner.next().charAt(0);
    }

    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
    public int getUserChoice() {
        System.out.println("1. Калькулятор");
        System.out.println("2. Выход");
        System.out.print("Выберите действие: ");
        return scanner.nextInt();
    }
}
