public class ExceptionsExample {
    public static void main(String[] args) {
        try {
            int[] arrayA = {1, 2, 3};
            int[] arrayB = {4, 5, 0};
            int[] result1 = subtractArrays(arrayA, arrayB);
            int[] result2 = divideArrays(arrayA, arrayB);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод может вызвать ArrayIndexOutOfBoundsException и NullPointerException
    public static int[] subtractArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("The length of the arrays is not equal.");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;
    }

    // Метод может вызвать ArrayIndexOutOfBoundsException, NullPointerException и ArithmeticException
    public static int[] divideArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("The length of the arrays is not equal.");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            if (array2[i] == 0) {
                throw new RuntimeException("Division by zero is not allowed.");
            }
            result[i] = array1[i] / array2[i];
        }
        return result;
    }
}
