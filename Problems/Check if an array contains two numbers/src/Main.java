import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] unsorted = new int[length];
        boolean nextToEachOther = false;

        for (int i = 0; i < unsorted.length; i++) {

            unsorted[i] = scanner.nextInt();
        }

        int[] targets = new int[2];

        for (int i = 0; i < targets.length; i++) {

            targets[i] = scanner.nextInt();
        }

        for (int i = 0; i < unsorted.length - 1; i++) {

            if ((unsorted[i] == targets[0] ||
                    unsorted[i] == targets[1]) &&
                    (unsorted[i + 1] == targets[1] ||
                                unsorted[i + 1] == targets[0])) {
                nextToEachOther = true;
                break;
            }
        }

        System.out.println(nextToEachOther);
    }
}