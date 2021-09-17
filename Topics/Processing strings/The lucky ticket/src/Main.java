import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] nums = sc.next().toCharArray();
        int f = 0;
        int l = 0;

        for(int i=0; i < nums.length; i++){
            if (i<3)
                f+=Character.getNumericValue(nums[i]);
            else
                l+=Character.getNumericValue(nums[i]);
        }
        System.out.println((f == l) ? "Lucky" : "Regular");
    }
}