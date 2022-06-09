import java.util.ArrayList;
import java.util.List;

public class Text {
    public static void main(String[] args) {
        System.out.println(fixCutPaste("Hey!!!"));
    }

    public static String fixCutPaste(String text) {
        List<String> list = new ArrayList<>();
        for (String s : text.split("\\s{1}")) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        return String.join(" ", list);
    }
}
