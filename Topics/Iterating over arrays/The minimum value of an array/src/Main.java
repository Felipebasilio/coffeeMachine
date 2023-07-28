import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int len = scanner.nextInt(); // reading a length
        int[] array = new int[len];  // creating an array with the specified length
                
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt(); // read the next number of the array
        }

        Arrays.sort(array);

        System.out.println(array[0]);
    }
}
