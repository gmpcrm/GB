import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
  public static void main(String[] args) throws Exception {
    String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

    Pattern pattern = Pattern.compile("\"(.*?)\":\"(.*?)\"");
    Matcher matcher = pattern.matcher(json);

    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM students WHERE ");

    boolean first = true;
    while (matcher.find()) {
      String key = matcher.group(1);
      String value = matcher.group(2);

      if (!value.equals("null")) {
        if (!first) {
          sb.append(" AND ");
          first = false;
        }

        sb.append(key + " = '" + value + "'");
      }
    }

    System.out.println(sb.toString());
  }
}
