import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TimeFormat {
    public static void main(String[] args) throws IOException {
        checkTimeConvertion();
    }


    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        int years = seconds / (60 * 60 * 24 * 365);
        seconds -= years * 3600 * 24 * 365;
        int days = seconds / (60 * 60 * 24);
        seconds -= days * 60 * 60 * 24;
        int hours = seconds / (60 * 60);
        seconds -= hours * 3600;
        int minutes = seconds / 60;
        seconds -= minutes * 60;

        List<String> amounts = new ArrayList<>();
        if (years > 0) {
            if (String.valueOf(years).equals("1")) {
                amounts.add(years + " year");
            } else {
                amounts.add(years + " years");
            }
        }
        if (days > 0) {
            if (String.valueOf(days).equals("1")) {
                amounts.add(days + " day");
            } else {
                amounts.add(days + " days");
            }
        }
        if (hours > 0) {
            if (String.valueOf(hours).equals("1")) {
                amounts.add(hours + " hour");
            } else {
                amounts.add(hours + " hours");
            }
        }
        if (minutes > 0) {
            if (String.valueOf(minutes).equals("1")) {
                amounts.add(minutes + " minute");
            } else {
                amounts.add(minutes + " minutes");
            }
        }
        if (seconds > 0) {
            if (String.valueOf(seconds).equals("1")) {
                amounts.add(seconds + " second");
            } else {
                amounts.add(seconds + " seconds");
            }
        }
        if (amounts.size() == 1) {
            return amounts.get(0);
        }
        String result = String.join(", ", amounts.subList(0, amounts.size() - 1));
        result += " and " + amounts.get(amounts.size() - 1);
        return result;
    }

    public static void checkTimeConvertion() throws IOException {
        System.out.println("Enter the number of seconds:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println(formatDuration(num));
        checkTimeConvertion();
    }
}
