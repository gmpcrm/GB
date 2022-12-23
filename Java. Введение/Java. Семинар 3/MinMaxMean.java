import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMaxMean {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // Находим минимальное значение
        int min = list.stream().min(Integer::compareTo).get();
        System.out.println("Минимальное значение: " + min);

        // Находим максимальное значение
        int max = list.stream().max(Integer::compareTo).get();
        System.out.println("Максимальное значение: " + max);

        // Находим среднее значение
        double average = list.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println("Среднее значение: " + average);
    }
}
