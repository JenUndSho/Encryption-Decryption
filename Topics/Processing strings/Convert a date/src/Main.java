import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.next().split("-");
        System.out.println(str[1]+'/'+str[2]+'/'+str[0]);
    }
}