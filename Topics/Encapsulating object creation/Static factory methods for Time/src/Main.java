import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time x = new Time();
        x.hour = 12;
        x.minute = 0;
        x.second = 0;
        return x;

    }

    public static Time midnight() {
        Time x = new Time();
        x.hour = 0;
        x.minute = 0;
        x.second = 0;
        return x;
    }

    public static Time ofSeconds(long seconds) {
        Time x = new Time();
        x.hour = (int) seconds / 3600 % 24;
        x.minute = (int) (int) (seconds % 3600) / 60;
        x.second = (int) seconds % 60;
        return x;
    }

    public static Time of(int hour, int minute, int second) {
        Time x = new Time();
        if (hour <= 23 && hour >=0 && minute <= 59 && minute >=0 && second <= 59 && second >=0){
            x.hour = hour;
            x.minute = minute;
            x.second = second;
            return x;
        }
        else
            return null;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}
