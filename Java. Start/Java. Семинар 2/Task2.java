import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3};

        var logFile = new File("sort-log.txt");
        try (var writer = new FileWriter(logFile)) {
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = 0; j < a.length - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
                writer.write(Arrays.toString(a) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
