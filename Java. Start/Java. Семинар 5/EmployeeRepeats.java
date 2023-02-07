import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepeats {
    public static void main(String[] args) {
        String[] employees = {  "Иван Иванов",
                                "Петр Петров",
                                "Сергей Сергеев",
                                "Иван Иванов",
                                "Анна Аннина",
                                "Петр Петров",
                                "Иван Иванов",
                                "Сергей Сергеев",
                                "Анна Аннина",
                                "Дмитрий Дмитриев" };

        Map<String, Integer> employeeCount = Arrays.stream(employees)
        .collect(Collectors.toMap(employee -> employee, employee -> 1, Integer::sum));
        
        employeeCount.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
        .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue() + " повторения"));
    }
}