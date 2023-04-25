import java.util.Scanner;

public class DZ4 {
    public static void main(String[] args) {
        System.out.println("Введите строку (пустые строки недопустимы):");
        String userInput = readNotEmptyString();
        System.out.println("Вы ввели строку: " + userInput);
    }

    private static String readNotEmptyString() {
        Scanner scanner = new Scanner(System.in);
        String result;

        try {
            while (true) {
                result = scanner.nextLine();
                if (result.isEmpty()) {
                    System.out.println("Пустые строки вводить нельзя!");
                    System.out.println("Пожалуйста, введите строку снова:");
                } else {
                    break;
                }
            }
        } finally {
            scanner.close();
        }

        return result;
    }
}
