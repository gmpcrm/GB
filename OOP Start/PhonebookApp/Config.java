package PhonebookApp;

import java.time.format.DateTimeFormatter;

public class Config {
    public static String dateFormat = "dd.MM.yyyy";
    public static String pathDb = "data.db";

    public static DateTimeFormatter ofPattern() {
        return DateTimeFormatter.ofPattern(dateFormat);
    }
}
