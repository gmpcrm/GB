public class Task1 {
  public static void main(String[] args) throws Exception {
    var json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

    var strs = json.replace("\"","").replace("{","").replace("}","").split(",");
    for (var str: strs){
        System.out.println(str);

    }

  }
}
