import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/5254ca2719453dcc0b00027d/train/java
public class Permutations {

    public static void main(String[] args) {
        List<String> abb = singlePermutations("abc");
        abb.forEach(System.out::println);
    }

    public static List<String> singlePermutations(String s) {
        if (s.length() == 0) {
            return Collections.emptyList();
        }
        if (s.length() == 1) {
            return Collections.singletonList(s);
        }

        List<String> permutations = new ArrayList<>();
        int count = 0;

        //first letters
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < factorial(s.length() - 1); j++) {
                permutations.add(s.charAt(i) + "" + i);
            }
        }

        //number of words for each first letter
        for (int j = 0; j < factorial(s.length() - 1); j++) {

            //number of letters
            for (int i = 0; i < s.length(); i++) {

                //loop for a next letter
                for (int k = 0; k < s.length(); k++) {
                    String toAdd = permutations.get(count) + s.charAt(k) + k;

                    if (!permutations.get(count).contains(s.charAt(k) + "" + k) && !(permutations.contains(toAdd) && permutations.get(count).length() == s.length())
                            && permutations.stream().filter(p -> p.equals(toAdd)).collect(Collectors.toList()).size() < factorial(s.length() - toAdd.length()*2)) {
                        permutations.set(count, toAdd);
                        k = 0;
                        if (count < permutations.size() - 1) {
                            count++;
                        }
                    }
                }
            }
            count = 0;
        }
        List<String> finalPerms = new ArrayList<>();
        permutations.forEach(p -> finalPerms.add(p.replaceAll("\\d", "")));

        return finalPerms.stream().filter(f -> f.length() == s.length()).distinct().collect(Collectors.toList());
    }

    public static int factorial(int i) {
        int factorialInt = 1;
        for (int j = 1; j <= i; j++) {
            factorialInt *= j;
        }
        return factorialInt;
    }
}
