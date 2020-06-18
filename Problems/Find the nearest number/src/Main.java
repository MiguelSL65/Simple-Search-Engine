import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        List<Integer> storeValues = new ArrayList<>();

        String numbers = scanner.nextLine();
        String[] arr = numbers.split(" ");

        Integer givenNumber = scanner.nextInt();

        // Add given numbers in standard input to <<input>> List.
        for (String s : arr) {
            input.add(Integer.parseInt(s));
        }

        // Retrieve min abs difference between elements in <input> list.
        for (Integer i : input) {
            storeValues.add(Math.abs(i - givenNumber));
        }

        // Use min() method of Collections to store min abs difference
        // retrieved in previous for loop.
        Integer min = Collections.min(storeValues);

        // If storeValues list has an element equal to min diff
        // then we add the value to output. Because it is in the same
        // spot as the value with min diff.
        for (int i = 0; i < storeValues.size(); i++) {
            if (storeValues.get(i).equals(min)) {
                output.add(input.get(i));
            }
        }

        // sort List
        Collections.sort(output);

        // Print it.
        for (Integer integer : output) {
            System.out.print(integer + " ");
        }
    }
}