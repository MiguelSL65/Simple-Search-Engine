import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] set = line.split(" ");
        boolean alphabetic = false;

        for (int i = 0; i < set.length - 1; i++) {

            alphabetic = set[i].compareTo(set[i + 1]) <= 0;
        }

        System.out.println(alphabetic);
    }
}