import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] arr = new int[length];
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        for (int value : arr) {

            if (value == target) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}