import java.util.Random;

public class DynamicArray<T extends Comparable<T>> {
    private T[] data;
    private int size;

    // Конструктор по умолчанию
    public DynamicArray() {
        this.data = (T[]) new Comparable[10];
        this.size = 0;
    }

    // Конструктор с указанием начальных данных
    public DynamicArray(T[] array) {
        this.size = array.length;
        this.data = (T[]) new Comparable[this.size];
        for (int i = 0; i < this.size; i++) {
            this.data[i] = array[i];
        }
    }

    // оперция сложения для элементов массива
    private T add(T op1, T op2) {
        if (op1 instanceof Integer) {
            return (T) (Integer) ((Integer) op1 + (Integer) op2);
        } else if (op1 instanceof Double) {
            return (T) (Double) ((Double) op1 + (Double) op2);
        } else if (op1 instanceof Boolean) {
            return (T) (Boolean) ((Boolean) op1 || (Boolean) op2);
        } else if (op1 instanceof String) {
            return (T) ((String) op1 + (String) op2);
        }

        throw new UnsupportedOperationException("Операция сложения не поддерживается для типа " + op1.getClass().getName() + "");
    }

    // операция умножения для элементов массива
    private T mul(T op1, T op2) {
        if (op1 instanceof Integer) {
            return (T) (Integer) ((Integer) op1 * (Integer) op2);
        } else if (op1 instanceof Double) {
            return (T) (Double) ((Double) op1 * (Double) op2);
        } else if (op1 instanceof Boolean) {
            return (T) (Boolean) ((Boolean) op1 && (Boolean) op2);
        } else if (op1 instanceof String) {
            return (T) ((String) op1 + "*" + (String) op2);
        }
        
        throw new UnsupportedOperationException("Операция умножения не поддерживается для типа " + op1.getClass().getName() + "");
    }

    // Вставляет элемент в массив
    public void insert(T element) {
        if (size == data.length) {
            resize();
        }

        data[size++] = element;
    }

    // Увеличивает размер массива в 2 раза
    public void resize() {
        T[] newData = (T[]) new Comparable[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    // Удаляет элемент из массива
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекс " + index + " выходит за границы массива");
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    // Удаляет все элементы из массива по значению
    public void removeValue(T value) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!data[i].equals(value)) {
                data[newSize++] = data[i];
            }
        }

        size = newSize;
    }

    // Находит минимальный элемент в массиве
    public T findMin() {
        if (size == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        T min = data[0];
        for (int i = 1; i < size; i++) {
            if (min.compareTo(data[i]) > 0) {
                min = data[i];
            }
        }

        return min;
    }

    // Находит максимальный элемент в массиве
    public T findMax() {
        if (size == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        T max = data[0];
        for (int i = 1; i < size; i++) {
            if (max.compareTo(data[i]) < 0) {
                max = data[i];
            }
        }
        
        return max;
    }

    // Находит сумму элементов в массиве
    public T findSum() {
        if (size == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        T sum = data[0];
        for (int i = 1; i < size; i++) {
            sum = add(sum, data[i]);
        }

        return sum;
    }

    // Находит произведение элементов в массиве
    public T findProduct() {
        if (size == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        T product = data[0];
        for (int i = 1; i < size; i++) {
            product = mul(product, data[i]);
        }

        return product;
    }

    // Находит индекс элемента в массиве
    public int findIndex(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].compareTo(element) == 0) {
                return i;
            }
        }
        
        return -1;
    }

    // получение элемента по индексу
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекс " + index + " выходит за границы массива");
        }

        return data[index];
    }

    // изменение элемента по индексу
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекс " + index + " выходит за границы массива");
        }

        data[index] = element;
    }

    // возвращает размер массива
    public int size() {
        return size;
    }

    // Проверяет, содержится ли элемент в массиве
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }

        return false;
    }

    // сортировка пузырьком
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // сортировка вставками
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            T key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].compareTo(key) > 0) {
                data[j + 1] = data[j];
                j = j - 1;
            }

            data[j + 1] = key;
        }
    }

    // сортировка выбором
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            T temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    // показывает массив значений
    public void showValues(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    // перемешивает массив
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(size);
            T temp = data[i];
            data[i] = data[randomIndex];
            data[randomIndex] = temp;
        }
    }

    // показывает сортировку массива разными способами
    public void showSorting() {
        System.out.println("Сортировка пузырьком");
        System.out.print("Исходный массив: ");
        shuffle();
        showValues();
        System.out.print("Отсортированный массив: ");
        bubbleSort();
        showValues();

        System.out.println("Сортировка вставками");
        System.out.print("Исходный массив: ");
        shuffle();
        showValues();
        System.out.print("Отсортированный массив: ");
        insertionSort();
        showValues();

        System.out.println("Сортировка выбором");
        System.out.print("Исходный массив: ");
        shuffle();
        showValues();
        System.out.print("Отсортированный массив: ");
        selectionSort();
        showValues();
    }

    public void showInfo() {
        System.out.println("Размер массива: " + size());
        System.out.println("Минимальное значение в массиве: " + findMin());
        System.out.println("Максимальное значение в массиве: " + findMax());
        System.out.println("Сумма значений в массиве: " + findSum());
        System.out.println("Произведение значений в массиве: " + findProduct());
    }
}