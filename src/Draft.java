import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Draft {
    public static void main(String[] args) throws IOException {
        List<String> aboba = singlePermutations("aboba");
        for (String s: aboba) {
            System.out.println(s);
        }
    }

    public static String greet(String name){
        StringBuilder builder = new StringBuilder(name.toLowerCase());
        builder.setCharAt(0, name.toUpperCase().charAt(0));
        return "Hello, mr. " + builder + "!";
    }

    public static void checkGreet() throws IOException {
        System.out.println("Введите имя: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(greet(name));
    }
    public static List<String> singlePermutations(String s) {
        if (s.length() == 0) {
            return Collections.emptyList();
        }
        if (s.length() == 1) {
            return Collections.singletonList(s);
        }

        List<String> permutations = new ArrayList<>();

        int factorial = s.length();
        int i = factorial -1;
        while (i > 0) {
            factorial *= i;
            i--;
        }


        for (int j = 0; j < s.length(); j++) {
            for (int a = 0; a < factorial; a++) {
                permutations.add(s.charAt(j) + "" + j);
            }
        }



        return permutations;
    }
}
