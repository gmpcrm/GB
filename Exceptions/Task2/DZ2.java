public class DZ2 {
    public static void main(String[] args) {
        processArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        processArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        processArray(null);
    }

    private static void processArray(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching out of bounds exception: " + e);
        }
        catch (NullPointerException e) {
            System.out.println("Catching null pointer exception: " + e);
        }
        catch (ArithmeticException e) {
            System.out.println("Catching arithmetic exception: " + e);
        }
        catch (Exception e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
