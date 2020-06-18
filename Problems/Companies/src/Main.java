import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        List<String> strings = new ArrayList<>(Arrays.asList(input));

        String output = strings.toString();

        System.out.println(output);
    }
}