import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phonebook = new HashMap<>();
        phonebook.put("Иванов Иван", Arrays.asList("+7-999-555-44-32", "+7-888-444-44-44"));
        phonebook.put("Петров Петр", Arrays.asList("+7-777-444-22-11"));
        phonebook.put("Сидоров Сидр", Arrays.asList("+7-666-333-33-11", "+7-666-333-22-33"));

        for (var entry : phonebook.entrySet()) {
            System.out.print("Пользователь: " + entry.getKey() + " " + "Номера телефонов: ");
            List<String> phones = entry.getValue();
            for (int i = 0; i < phones.size(); i++) {
                if (i > 0)  System.out.print(", ");
                System.out.print(phones.get(i));
            }
            System.out.println();
        }
    }
}