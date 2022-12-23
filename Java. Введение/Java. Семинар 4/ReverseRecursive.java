import java.util.LinkedList;
import java.util.List;

public class ReverseRecursive {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> reversed = reverse(list);
        System.out.println(reversed); // выведет [5, 4, 3, 2, 1]
    }

    public static List<Integer> reverse(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        
        int last = list.remove(0);
        List<Integer> reversed = reverse(list);
        reversed.add(last);
        return reversed;
    }
}
