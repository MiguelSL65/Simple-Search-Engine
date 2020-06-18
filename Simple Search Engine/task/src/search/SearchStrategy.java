package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchStrategy {
    private static boolean exit;
    private SearchEngine searchEngine;

    public SearchStrategy(String[] args) {
        String inputFile = argsParse(args);
        searchEngine = new SearchEngine(readDataFromFile(inputFile));
    }

    private String argsParse(String[] args) {

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("--data")) {
                return args[i + 1];
            }
        }

        return "";
    }

    private static List<String> readDataFromFile(String path) {

        List<String> names = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path);

            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line;

            while ((line = bufferedReader.readLine()) != null) {

                names.add(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }

    public void runTask() {

        Scanner scanner = new Scanner(System.in);

        while (!exit) {

            menu();

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    search(scanner);
                    break;
                case 2:
                    System.out.println(searchEngine.toString());
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }
    }

    private void search(Scanner scanner) {
        System.out.println("\nSelect a matching strategy: ALL," +
                " ANY, NONE");
        String strategy = scanner.nextLine().toLowerCase();

        switch (strategy) {
            case "all":
                searchEngine.setQueryStrategy(new SearchAll());
                break;
            case "any":
                searchEngine.setQueryStrategy(new SearchAny());
                break;
            case "none":
                searchEngine.setQueryStrategy(new SearchNone());
                break;
            default:
                System.out.println("That's not a valid strategy.\n");
                return;
        }

        System.out.println("\nEnter a name or email to search" +
                " all suitable people.");
        String query = scanner.nextLine();
        System.out.println(searchEngine.search(query));
    }

    private void exit() {
        System.out.println("Bye!");
        exit = true;
    }

    private void menu() {
        String menu = String.join("\n",
                "=== Menu ===",
                "1. Find a person",
                "2. Print all people",
                "0. Exit"
        );
        System.out.println(menu);
    }
}
