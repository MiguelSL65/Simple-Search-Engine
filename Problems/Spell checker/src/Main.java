import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numOfRecordsKnown = Integer.parseInt(scanner.nextLine());

        Set<String> listOfKnownWords = new HashSet<>();

        for (int i = 0; i < numOfRecordsKnown; i++) {
            listOfKnownWords.add(scanner.nextLine().toLowerCase());
        }

        Set<String> input = new HashSet<>();
        Set<String> inputSingle = new HashSet<>();

        int linesOfText = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < linesOfText; i++) {
            input.add(scanner.nextLine().toLowerCase());
        }

        for (String s : input) {
            Collections.addAll(inputSingle, s.split(" "));
        }

        for (String s : inputSingle) {
            if (!listOfKnownWords.contains(s)) {
                System.out.println(s);
            }
        }

    }
}