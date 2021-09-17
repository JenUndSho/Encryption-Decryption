import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int feetUp = scanner.nextInt();
        int feetDown = scanner.nextInt();

        int passedDistance = 0;
        int days = 0;
        while (passedDistance < height){
            passedDistance+= feetUp;
            days++;
            if (passedDistance < height)
                passedDistance-= feetDown;
            else
                break;
        }

        System.out.println(days);
    }
}
