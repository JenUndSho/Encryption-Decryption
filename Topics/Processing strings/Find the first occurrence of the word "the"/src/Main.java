import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ss = s.nextLine().toLowerCase();
        if(ss.contains("the")){
            System.out.println(ss.indexOf("the", 0));
        }
        else
            System.out.println("-1");
    }
}