import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine().toLowerCase();
        String second = scanner.nextLine().toLowerCase();

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : firstArr) {

            if (map1.get(c) == null) {
                map1.put(c, 1);

            } else {
                int d = map1.get(c);
                map1.put(c, ++d);
            }
        }

        for (char c : secondArr) {

            if (map2.get(c) == null) {
                map2.put(c, 1);

            } else {
                int d = map2.get(c);
                map2.put(c, ++d);
            }
        }

        if (Objects.equals(map1, map2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}