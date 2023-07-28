import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays;

class Main {
    public static void main(String[] args) {    
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int len = scanner.nextInt();  // Read user input

        int[] array = new int[len];  // creating an array with the specified length
        int biggerProduct = 0;
        int product = 0;
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt(); // read the next number of the array
            if (i > 0) {
                product = array[i] * array[i-1];
                if (biggerProduct < product) {
                    biggerProduct = product;
                }
            }
        }

        System.out.println(biggerProduct);

    }
}
