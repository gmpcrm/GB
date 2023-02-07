import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phonebook = new HashMap<>();
        phonebook.put("Иванов Иван", Arrays.asList("+7-999-555-44-32", "+7-888-444-44-44"));
        phonebook.put("Петров Петр", Arrays.asList("+7-777-444-22-11"));
        phonebook.put("Сидоров Сидр", Arrays.asList("+7-666-333-33-11", "+7-666-333-22-33"));
        phonebook.put("Кузнецов Кузьма", Arrays.asList("+7-999-999-99-99"));
        phonebook.put("Смирнов Андрей", Arrays.asList("+7-777-777-77-77", "+7-555-555-55-55"));
        phonebook.put("Павлов Павел", Arrays.asList("+7-666-666-66-66", "+7-555-555-55-55", "+7-444-444-44-44"));
        phonebook.put("Лебедев Илья", Arrays.asList("+7-444-444-44-44", "+7-333-333-33-33", "+7-222-222-22-22", "+7-111-111-11-11"));
        phonebook.put("Григорьев Григорий", Arrays.asList("+7-333-333-33-33"));
        phonebook.put("Соколов Александр", Arrays.asList("+7-111-111-11-11", "+7-999-999-99-99", "+7-888-888-88-88"));
        
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