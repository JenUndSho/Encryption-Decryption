import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] seq = s.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<seq.length; i++){
            sb.append(seq[i]);
            sb.append(seq[i]);
        }
        System.out.println(sb);
    }
}