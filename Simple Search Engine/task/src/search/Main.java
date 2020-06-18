package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static Boolean exit = false;
    static Scanner scanner = new Scanner(System.in);
    static String[] rows;
    static Map<String, List<Integer>> mappedRows;

    public static void main(String[] args) throws IOException{
        String inputFile = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                inputFile = args[i + 1];
            }

            rows = importRows(inputFile);
            mappedRows = mapRows(rows);
        }

        do {
            menu();
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1:
                    searchRows(scanner, mappedRows);
                    break;
                case 2:
                    printAllRows(rows);
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("Incorrect option! Try again.\n");
            }
        } while (!exit);

    }

    public static String[] importRows(String filename) throws IOException {

        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        bufferedReader.close();

        return lines.toArray(new String[0]);
    }

    private static Map<String, List<Integer>> mapRows(String[] rows) {

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < rows.length; i++) {

            for (String word : rows[i].split(" ")) {

                ArrayList<Integer> indexes = new ArrayList<Integer>();
                word = word.toUpperCase();

                if (map.containsKey(word)) {
                    indexes = (ArrayList<Integer>) map.get(word);
                    indexes.add(i);

                } else {
                    indexes.add(i);
                }

                map.put(word, indexes);
            }
        }

        return map;
    }

    public static void searchRows(Scanner scanner, Map<String, List<Integer>> mappedRows) {

        System.out.println("Enter search query:");
        String search = scanner.nextLine();

        if (mappedRows.containsKey(search.toUpperCase())) {

            for (int index : mappedRows.get(search.toUpperCase())) {
                System.out.println(rows[index]);
            }
        }
    }

    public static void printAllRows(String[] rows) {
        System.out.println("=== List of rows ===");
        for (String row : rows) {
            System.out.println(row);
        }
    }

    public static void exit() {
        System.out.println("Bye!");
        exit = true;
    }

    public static void menu() {
        String menu = String.join("\n",
                "=== Menu ===",
                "1. Search for matching rows",
                "2. Print all rows",
                "0. Exit"
        );
        System.out.println(menu);

    }
}