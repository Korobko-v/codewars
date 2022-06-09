import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = " ";
//
//        do {
//            System.out.println("Нажмите нужную клавишу, а затем Enter");
//            s = reader.readLine();
//        }
//        while (s.charAt(0) != 'q');
        char c = '1';
        int i = c;
        System.out.println(i);
    }

    public static int sortDesc(final int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        StringBuilder builder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        return Integer.parseInt(builder.toString());
    }

    public void checkSort() throws IOException {
        System.out.println("Введите число: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println(sortDesc(num));
    }

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static void checkSquare() throws IOException {
        System.out.println("Введите число: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        if (isSquare(num)) {
            System.out.println("Это квадрат");
        }
        else {
            System.out.println("Ты мудила");
        }
        checkSquare();
    }

    public static long findNextSquare(long sq) {
        if (Math.sqrt(sq) % 1 != 0) {
            return -1;
        }
        return (long) Math.pow(Math.sqrt(sq) + 1, 2);
    }

    public static void checkNextSquare() throws IOException {
        System.out.println("Введите число: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println("Следующий квадрат: " + findNextSquare(num));
        checkNextSquare();
    }

    public static int parseInt(String numStr) {
        int num = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);

        Map<String, Integer> decimal = new HashMap<>();
        decimal.put("hundred", 100);
        decimal.put("thousand", 1000);

        if (numStr.equals("zero")) {
            return 0;
        }

        if (numStr.equals("one million")) {
            return 1_000_000;
        }

        String[] array = numStr.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("hundred") && i > 0) {
                String[] dashSplit = array[i - 1].split("-");
                if (dashSplit.length == 1) {
                    num += map.get(array[i-1]) * decimal.get(array[i]);
                } else {
                    num += (map.get(dashSplit[0]) + map.get(dashSplit[1])) * decimal.get(array[i]);
                }
            }
            if (array[i].equals("thousand")) {
                if (!decimal.containsKey(array[i-1])) {
                    String[] dashSplit = array[i-1].split("-");
                    for (String s : dashSplit) {
                        num += map.get(s);
                    }
                }
                num *= 1000;
            }
            if (!decimal.containsKey(array[i]) && i == array.length - 1) {
                String[] dashSplit = array[i].split("-");
                for (String s : dashSplit) {
                    num += map.get(s);
                }
            }
        }

        return num;
    }

    public static void checkParsing() throws IOException {
        System.out.println("Введите число прописью: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numStr = reader.readLine();
        System.out.println(parseInt(numStr));
        checkParsing();
    }

    public static String makeReadable(int seconds) {
        if (seconds > 359999 || seconds < 0) {
            return "Wrong";
        }
        int hours = seconds / (60 * 60);
        seconds -= hours * 60 * 60;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        String hh = hours >= 10 ? Integer.toString(hours) : "0" + hours;
        String mm = minutes >= 10 ? Integer.toString(minutes) : "0" + minutes;
        String ss = seconds >= 10 ? Integer.toString(seconds) : "0" + seconds;

        return hh + ":" + mm + ":" + ss;
    }

    public static void checkReadable() throws IOException {
        System.out.println("Введите количество секунд: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println(makeReadable(num));
        checkReadable();
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        StringBuilder builder = new StringBuilder();
        for (String s : lines) {
            for (String symbol : commentSymbols) {
                if (s.contains(symbol)) {
                    s = s.substring(0, s.indexOf(symbol));
                }
            }
            while (s.endsWith(" ")) {
                s = s.substring(0, s.length() - 1);
            }
            builder.append(s + "\n");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
