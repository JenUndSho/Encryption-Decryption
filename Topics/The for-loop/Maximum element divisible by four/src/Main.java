import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int max = 0;
        int temp = 0;
        Scanner s = new Scanner(System.in);
        int[] arr = new int[s.nextInt()];

        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }

        for(int i=0; i<arr.length; i++){
            if (arr[i]%4 == 0)
                temp = arr[i];
            if(temp>max)
                max = temp;
        }

        System.out.println(max);
    }
}