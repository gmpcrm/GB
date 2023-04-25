import java.io.*;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserProcessor {
    public static void main(String[] args) {
        test();

        try (Scanner scanner = new Scanner(System.in, "Cp866")) {
            System.out.println("Введите данные в следующем формате: Фамилия Имя Отчество Дата рождения (dd.MM.yyyy) Номер телефона (число) Пол (m или f):");
            String input = scanner.nextLine();
            String[] inputData = input.split(" ");

            try {
                processUserData(inputData);
                System.out.println("Данные успешно записаны.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Проблема с чтением или записью в файл: " + e.getMessage());
            }
        }
    }

    public static void test() {
        String[][] testCases = {
            {"Иванов", "Иван", "Иванович", "01.01.2000", "1234567890", "m"},
            {"Петров", "Петр", "Петрович", "30.02.2000", "1234567890", "m"},
            {"Сидоров", "Сидр", "Сидорович", "20.11.1999", "abcdefghij", "m"},
            {"Козлов", "Александр", "Алексеевич", "05.05.1985", "9876543210", "x"},
            {"Пупкин", "Василий", "Васильевич", "29.02.2001", "1234567890", "m"},
            {"Лебедев", "Алексей", "Алексеевич", "31.04.1995", "12345678901", "m"},
            {"Жуков", "Михаил", "Михайлович", "32.05.1986", "1234567890", "m"},
            {"Романов", "Роман", "Романович", "15.13.2002", "123456789", "m"},
            {"Карпов", "Карл", "Карлович", "00.05.1999", "1234567890", "m"},
            {"Тихонов", "Тихон", "Тихонович", "01.01.2000", "1234567890", "z"},
            {"Кузнецов", "Игорь", "Игоревич", "15.05.2005", "1234abcd", "m"},
            {"Васильев", "Василий", "Васильевич", "15.05.2005", "-12345678", "m"},
            {"Алексеев", "Алексей", "Алексеевич", "29.02.1900", "1234567890", "m"},
            {"Харитонов", "Харитон", "Харитонович", "29.02.1800", "1234567890", "m"},
            {"Шевченко", "Тарас", "Тарасович", "30.02.1900", "1234567890", "m"},
            {"Шевченко", "Сергей", "Тарасович", "30.02.2030", "1234567890", "m"},
            {"Шевченко", "Тарас", "Тарасович", "30.01.1900", "1234567890", "m"},
            {"Шевченко", "Сергей", "Тарасович", "30.01.2030", "1234567890", "m"},
            {"Баранов", "Борис", "Борисович", "31.09.1988", "1234567890", "m"},
            {"Сергеев", "Сергей", "Сергеевич", "01.01.2100", "1234567890", "m"},
            {"Шишкин", "Илья", "Ильич", "15.08.2000", "1234567890", "y"},
            {"Некорректные", "данные"},
            {"Некорректные", "данные", "данные", "данные", "данные", "данные", "данные"},
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Тестовый случай " + (i + 1) + ":");
            try {
                processUserData(testCases[i]);
                System.out.println("Данные успешно записаны.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Проблема с чтением или записью в файл: " + e.getMessage());
            }
            System.out.println();
        }
    }

    public static void processUserData(String[] inputData) throws IllegalArgumentException, IOException {
        if (inputData.length != 6) {
            throw new IllegalArgumentException("Вы ввели " + (inputData.length < 6 ? "меньше" : "больше") + " данных, чем требуется.");
        }

        String surname = inputData[0];
        String name = inputData[1];
        String patronymic = inputData[2];
        String birthDateString = inputData[3];
        String phoneNumberString = inputData[4];
        String genderString = inputData[5];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        Date birthDate;
        long phoneNumber;
        char gender;

        try {
            birthDate = dateFormat.parse(birthDateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения: " + birthDateString, e);
        }

        try {
            phoneNumber = Long.parseLong(phoneNumberString);
            if (phoneNumber < 0) {
                throw new NumberFormatException();
            }
        } 
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона: " + phoneNumberString, e);
        }

        if (genderString.length() == 1 && (genderString.charAt(0) == 'f' || genderString.charAt(0) == 'm')) {
            gender = genderString.charAt(0);
        } else {
            throw new IllegalArgumentException("Неверный формат пола:" + genderString);
        }

        String output = String.format("<%s><%s><%s><%s><%d><%c>", surname, name, patronymic, birthDateString, phoneNumber, gender);
        Path filePath = Paths.get(surname + ".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(output);
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Проблема с чтением или записью в файл.", e);
        }
    }
}
