import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 2, 7, 4, 0, 6, 1, 3, 10, -5, 12, -1};
        mergeSort(a);
        System.out.println(Arrays.toString(a) + "\n");
    }

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // Разбиваем массив на две равные части
            int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

            // Сортируем каждую часть рекурсивно
            mergeSort(left);
            mergeSort(right);

            // Сливаем отсортированные части
            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        
        // Копируем оставшиеся элементы из левой или правой части, если они есть
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;

        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
        