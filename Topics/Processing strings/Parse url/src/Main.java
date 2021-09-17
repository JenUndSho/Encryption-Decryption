import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().split("\\?")[1];
        String[] newStr = str.split("&");
        String pw = "";

        for (String key: newStr){
                switch (key.split("=")[0]){
                    case "pass": map.put("pass", (key.split("=").length > 1) ? key.split("=")[1] : "not found");
                        pw = key.split("=")[1];
                        continue;
                    case "port": map.put("port", (key.split("=").length > 1) ? key.split("=")[1] : "not found");
                        continue;
                    case "cookie": map.put("cookie", (key.split("=").length > 1) ? key.split("=")[1] : "not found");
                        continue;
                    case "host": map.put("host", (key.split("=").length > 1) ? key.split("=")[1] : "not found");
                        continue;
                    case "name": map.put("name", (key.split("=").length > 1) ? key.split("=")[1] : "not found");
                        continue;
                }
        }


        if (map.containsKey("pass"))
            map.put("password", pw);

        map.forEach((x,y) -> System.out.println(x + " : " + y));
//        String pw = "";
//        for (String key: newStr){
//                switch (key.split("=")[0]){
//                    case "pass":
//                        pw =  ((key.split("=").length > 1) ? key.split("=")[1] : null);
//                        if (pw != null)
//                            System.out.println("pass" + " : " + ((key.split("=").length > 1) ? key.split("=")[1] : "not found"));
//                        continue;
//                    case "port":
//                        System.out.println("port" + " : " + ((key.split("=").length > 1) ? key.split("=")[1] : "not found"));
//                        continue;
//                    case "cookie":
//                        System.out.println("cookie" + " : " + ((key.split("=").length > 1) ? key.split("=")[1] : "not found"));
//                        continue;
//                    case "host":
//                        System.out.println("host" + " : " + ((key.split("=").length > 1) ? key.split("=")[1] : "not found"));
//                        continue;
//                    case "name":
//                        System.out.println("name" + " : " + ((key.split("=").length > 1) ? key.split("=")[1] : "not found"));
//                        continue;
//                }
//        }
//        if (str.contains("pass="))
//            System.out.println("password" + " : " + pw);
    }
}