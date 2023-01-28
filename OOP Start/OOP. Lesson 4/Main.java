public class Main {

    public static void main(String[] args) {

        try{
            // Пример использования для целочисленных значений
            DynamicArray<Integer> intArray = new DynamicArray<>();
            intArray.insert(5); // 1. Вставка в массив
            intArray.insert(10);
            intArray.insert(15);
            intArray.insert(20);
            intArray.insert(25);
            intArray.insert(30);
            intArray.insert(35);
            intArray.showValues(); // 5 10 15 20 25 30 35
            intArray.showInfo(); // 4,5,6,7 Поиск минимума, максимума, суммы и произведения
            intArray.removeAt(2); // 2. Удаление элемента по индексу
            intArray.removeValue(10); // 3. Удаление всех элементов с заданным значением
            intArray.set(1, 18); // 14. Задание значения элементу массива с заданным индексом
            intArray.showValues(); // 5 18 25 30 35
            System.out.println("Индекс элемента 25 в массиве: " + intArray.findIndex(25)); // 8. Поиск индекса заданного элемента
            System.out.println("Индекс элемента 10 в массиве: " + intArray.findIndex(10)); // 8. Если такого элемента в массиве нет то возвращает -1
            System.out.println("Массив содержит элемент 25 в массиве: " + intArray.contains(25)); // 9. Проверка наличия элемента в массиве
            System.out.println("Массив содержит элемент 10 в массиве: " + intArray.contains(10)); // 9. Если такого элемента в массиве нет то возвращает false
            System.out.println("Элемент массива по индексу: " + intArray.get(1)); // 13. Получение элемента массива по индексу        
            intArray.showSorting(); // 10,11,12 Сортировка массива
            System.out.println();
            
            // Пример использования для строк
            DynamicArray<String> stringArray = new DynamicArray<>();
            stringArray.insert("Привет");
            stringArray.insert("мир");
            stringArray.insert("42");
            stringArray.insert("!");
            stringArray.insert("Привет мир!");
            stringArray.showValues(); // Привет мир 42 ! Привет мир!
            stringArray.showInfo();
            stringArray.removeAt(1);
            stringArray.removeValue("42");
            stringArray.showValues(); // Привет ! Привет мир!
            System.out.println("Индекс элемента Привет в массиве: " + stringArray.findIndex("Привет"));
            System.out.println("Индекс элемента 42 в массиве: " + stringArray.findIndex("42"));
            System.out.println("Массив содержит элемент Привет в массиве: " + stringArray.contains("Привет")); // 9. Проверка наличия элемента в массиве
            System.out.println("Массив содержит элемент Нет в массиве: " + stringArray.contains("Нет")); // 9. Если такого элемента в массиве нет то возвращает false
            System.out.println("Элемент массива по индексу: " + stringArray.get(1)); // 13. Получение элемента массива по индексу        
            stringArray.showSorting(); 
            System.out.println();

            // Пример использования для чисел с плавающей точкой
            DynamicArray<Double> doubleArray = new DynamicArray<>();
            doubleArray.insert(5.0);
            doubleArray.insert(10.0);
            doubleArray.insert(15.0);
            doubleArray.insert(20.0);
            doubleArray.insert(25.0);
            doubleArray.insert(30.0);
            doubleArray.insert(35.0);
            doubleArray.showValues(); // 5.0 10.0 15.0 20.0 25.0 30.0 35.0
            doubleArray.showInfo();
            doubleArray.removeAt(1);
            doubleArray.removeValue(10.0);
            doubleArray.showValues(); // 5.0 15.0 20.0 25.0 30.0 35.0
            System.out.println("Индекс элемента 15.0 в массиве: " + doubleArray.findIndex(15.0));
            System.out.println("Индекс элемента 10.0 в массиве: " + doubleArray.findIndex(10.0));
            System.out.println("Массив содержит элемент 15.0 в массиве: " + doubleArray.contains(15.0)); // 9. Проверка наличия элемента в массиве
            System.out.println("Массив содержит элемент 10.0 в массиве: " + doubleArray.contains(10.0)); // 9. Если такого элемента в массиве нет то возвращает false
            System.out.println("Элемент массива по индексу: " + doubleArray.get(1)); // 13. Получение элемента массива по индексу        
            doubleArray.showSorting();
            System.out.println();

            // Пример использования для логических значений
            DynamicArray<Boolean> booleanArray = new DynamicArray<>();
            booleanArray.insert(true);
            booleanArray.insert(false);
            booleanArray.insert(true);
            booleanArray.insert(false);
            booleanArray.insert(true);
            booleanArray.insert(false);
            booleanArray.insert(true);
            booleanArray.showValues(); // true false true false true false true
            booleanArray.showInfo();
            booleanArray.removeAt(1);
            booleanArray.removeValue(false);
            booleanArray.showValues(); // true true true true
            System.out.println("Индекс элемента true в массиве: " + booleanArray.findIndex(true));
            System.out.println("Массив содержит элемент true в массиве: " + booleanArray.contains(true)); // 9. Проверка наличия элемента в массиве
            System.out.println("Массив содержит элемент false в массиве: " + booleanArray.contains(false)); // 9. Если такого элемента в массиве нет то возвращает false
            System.out.println("Элемент массива по индексу: " + booleanArray.get(1)); // 13. Получение элемента массива по индексу        
            booleanArray.insert(false);
            booleanArray.insert(false);
            booleanArray.showSorting();
            System.out.println();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
}

