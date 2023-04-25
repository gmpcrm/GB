import java.util.InputMismatchException;
import java.util.Scanner;

public class DZ1 {
    public static void main(String[] args) {
        System.out.println("Введите дробное число (типа float):");
        float userInput = readFloat();
        System.out.println("Вы ввели число: " + userInput);
    }

    private static float readFloat() {
        float result;

        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                result = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введено не дробное число. Пожалуйста, введите дробное число:");
            }
        }

        return result;
    }
}
