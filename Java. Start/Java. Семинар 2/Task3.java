import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) throws Exception {
    var json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
    
    var pattern = Pattern.compile("\\{\"фамилия\":\"(.*?)\",\"оценка\":\"(.*?)\",\"предмет\":\"(.*?)\"\\}");
    var matcher = pattern.matcher(json);
    
    StringBuilder sb = new StringBuilder();
    while (matcher.find()) {
        if (sb.length() > 0) sb.append("\n");
        sb.append("Студент " + matcher.group(1));
        sb.append(" получил " + matcher.group(2));
        sb.append(" по предмету " + matcher.group(3));
        sb.append(".");
    }
    System.out.println(sb.toString());
  }
}
  