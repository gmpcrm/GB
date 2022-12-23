import java.util.LinkedList;
import java.util.List;

public class Reverse {
    public static List<Integer> reverse(List<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        while (!list.isEmpty()) {
            reversed.addLast(list.remove(list.size() - 1));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> reversed = reverse(list);
        System.out.println(reversed); // выведет [5, 4, 3, 2, 1]
    }
}
