import java.util.Scanner;

public class ShowNumbers {
    public static void main(String[] args) {
        System.out.print("Введите число n:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int triangularNumber = 0;
        for (int i = 1; i <= n; i++) {
            triangularNumber += i;
        }
        System.out.println("" + n + "-ое треугольного число: " + triangularNumber);

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);
        
        scan.close();
    }        
}
