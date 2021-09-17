import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int upperCounts = s.nextInt();
        int lowerCounts = s.nextInt();
        int digitsCounts = s.nextInt();
        int length = s.nextInt();

        if (upperCounts == 0 && lowerCounts == 0 && digitsCounts == 0){
            for (int i = 0; i<length; i++){
                if (i%2 == 0)
                    System.out.print("$");
                else
                    System.out.print("*");
            }
        }
        else{
            while (sb.length() < length) {
                for (int j = 0; j < upperCounts; j++) {
                    if (sb.length() == length) break;

                    char[] ch = sb.toString().toCharArray();
                    int n = random.nextInt(26);
                    if(ch.length > 0) {
                        while ((char) n == ch[ch.length-1])
                            n = random.nextInt(26);
//                    if(ch[ch.length-1] == (char) n)
//                        sb.append((char) (random.nextInt(26) + 'A'));
//                    else
                        sb.append((char) (n + 'A'));
                        while(sb.toString().toCharArray()[sb.length()-1] == sb.toString().toCharArray()[sb.length()-2]){
                            sb.deleteCharAt(sb.length()-1);
                            sb.append((char) (random.nextInt(26) + 'A'));
                        }
                    }
                    else {
                        sb.append((char) (n + 'A'));
                    }

                }

                for (int j = 0; j < lowerCounts; j++) {
                    if (sb.length() == length) break;
                    char[] ch = sb.toString().toCharArray();
                    int n = random.nextInt(26);
                    if (ch.length > 0) {
                        while ((char) n == ch[ch.length-1])
                            n = random.nextInt(26);
//                    if(ch[ch.length-1] == (char) n)
//                        sb.append((char) (random.nextInt(26) + 'a'));
//                    else
                        sb.append((char) (n + 'a'));
                        while(sb.toString().toCharArray()[sb.length()-1] == sb.toString().toCharArray()[sb.length()-2]){
                            sb.deleteCharAt(sb.length()-1);
                            sb.append((char) (random.nextInt(26) + 'a'));
                        }
                    }
                    else {
                        sb.append((char) (n + 'a'));
                    }

                }

                for (int j = 0; j < digitsCounts; j++) {
                    if (sb.length() == length) break;
                    char[] ch = sb.toString().toCharArray();
                    int n = random.nextInt(10);
                    if (ch.length > 0) {
                        while ((char) n == ch[ch.length-1])
                            n = random.nextInt(10);
//                    if((int) ch[ch.length-1] == n)
//                        sb.append(random.nextInt(10));
//                    else
                        sb.append(n);
                        while(sb.toString().toCharArray()[sb.length()-1] == sb.toString().toCharArray()[sb.length()-2]){
                            sb.deleteCharAt(sb.length()-1);
                            sb.append(random.nextInt(10));
                        }
                    }
                    else {
                        sb.append(n);
                    }
                }
            }
            System.out.println(sb);
        }



    }
}