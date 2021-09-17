import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        StringBuilder s = new StringBuilder();
        
        int i = str.length() - 1;
        while (i >= 0) {
            s.append(str.charAt(i));
            i--;
        }
        
        System.out.println((s.toString().equals(str) ? "yes" : "no"));
    }
}
