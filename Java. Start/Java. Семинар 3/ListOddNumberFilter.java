import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOddNumberFilter {
    public static List<Integer> filter(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                filteredList.add(list.get(i));
            }
        }
        
        return filteredList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredList = ListOddNumberFilter.filter(list);
        System.out.println(filteredList); // выведет [1, 3, 5, 7, 9]
    }
}
