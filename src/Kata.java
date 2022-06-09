import java.util.ArrayList;
import java.util.List;

public class Kata {
    public static void main(String[] args) {
        String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sa\"\n" +
                "            + \"gittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusc\"\n" +
                "            + \"e at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. V\"\n" +
                "            + \"ivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, no\"\n" +
                "            + \"n dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at f\"\n" +
                "            + \"ermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum vel\"\n" +
                "            + \"it ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellent\"\n" +
                "            + \"esque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla\"\n" +
                "            + \" et dolor.";
        String s = "123 45 6";
        System.out.println(justify(LIPSUM, 30));
    }

    public static String justify(String text, int width) {
        if (text.length() == 0) {
            return "";
        }
        text = text.trim();
        text = text.replaceAll("\n", "");
        text = text.replaceAll("\\s+", " ");
        text = text.replaceAll("\" \\+ \"", "");
        StringBuilder newText = new StringBuilder();
        String[] words = text.split(" ");
        int count = words[0].length();
        newText.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            count += words[i].length() + 1;
            if (count >= width + 1) {
                newText.append('\n' + words[i]);
                count = words[i].length();
            } else {
                newText.append(" " + words[i]);
            }
        }
        String[] split = newText.toString().split("\n");
        newText = new StringBuilder();
        for (String s : split) {
            StringBuilder builder = new StringBuilder(s);
            if (s.split("\\s+").length > 1 && s.length() < width) {
                while (builder.length() < width) {
                    for (int i = 1; i < builder.length(); i++) {
                        if (Character.isWhitespace(builder.charAt(i - 1)) && !Character.isWhitespace(builder.charAt(i))) {
                            builder.insert(i - 1, ' ');
                            i++;
                        }
                        if (builder.length() == width) break;
                    }
                }
            }

            newText.append(builder.toString() + '\n');
        }
        String toInsert = split[split.length - 1];
        String[] split1 = newText.toString().split("\n");
        String toReplace = split1[split1.length - 1];
        newText.deleteCharAt(newText.length() - 1);
        String toReturn = newText.toString().replace(toReplace, toInsert);

        return toReturn;
    }
}
