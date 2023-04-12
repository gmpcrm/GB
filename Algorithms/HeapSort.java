import java.util.Comparator;

public class HeapSort<T> {

    private final Comparator<T> comparator;

    public HeapSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(T[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(array[left], array[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(array[right], array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {12, 11, 13, 5, 6, 7};
        HeapSort<Integer> heapSort = new HeapSort<Integer>(Comparator.naturalOrder());
        heapSort.sort(array);

        System.out.println("Sorted array:");
        for (Integer item : array) {
            System.out.print(item + " ");
        }
    }
}
