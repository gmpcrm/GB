import java.util.Scanner;

public class InputScanner {
    private static InputScanner instance;
    private Scanner input;

    private InputScanner() {
        input = new Scanner(System.in, "Cp866");
    }

    public static InputScanner getInstance() {
        if (instance == null) {
            instance = new InputScanner();
        }
        
        return instance;
    }

    public static int getInt(String message) {
        if(message != null){
            System.out.println(message);
        }
        
        while(true)
        {
            try{
                return Integer.parseInt(InputScanner.getInstance().input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод, попробуйте снова");
            }
        }
    }

    public static String getString(String message) {
        if(message != null){
            System.out.println(message);
        }

        return InputScanner.getInstance().input.nextLine();
    }

    public static boolean getBoolean(String message) {
        if(message != null){
            System.out.println(message);
        }

        while(true)
        {
            try{
                return Boolean.parseBoolean(InputScanner.getInstance().input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод, попробуйте снова");
            }
        }
    }

    public static Scanner getScanner() {
        return InputScanner.getInstance().input;
    }
}
