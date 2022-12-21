public class Task1 {
  public static void main(String[] args) throws Exception {
    var json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

    var strs = json.replace("\"","").replace("{","").replace("}","").split(",");
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM students WHERE ");
    
    for (var str: strs){
      var key = str.split(":")[0].trim();
      var value = str.split(":")[1].trim();

      if (!value.equals("null")){
        if (sb.length() > 30){
          sb.append(" AND ");
        }

        sb.append(key + " = '" + value + "'");      
      }
    }

    System.out.println(sb.toString());
  }
}
