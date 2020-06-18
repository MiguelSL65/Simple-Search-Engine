import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int[] nums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int count = 0;

        for (int i = nums[0]; i <= nums[1]; i++) {

            if (i % nums[2] == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}