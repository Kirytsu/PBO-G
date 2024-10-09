
/**
 * @author Nathanael Valen Susilo
 * @version 0.1
 */
import java.util.HashSet;
import java.util.Scanner;

public class InputReader {
    private Scanner reader;
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text typed by the user),
     * and return it as a set of individual words.
     */
    public HashSet<String> getInput() {
        System.out.print("> "); // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase();
        String[] wordArray = inputLine.split(" ");
        // Add words from the array into the HashSet
        HashSet<String> words = new HashSet<>();
        for (String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}
