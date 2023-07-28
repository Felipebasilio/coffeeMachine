import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineOne = scanner.nextLine().toLowerCase().trim().replace(" ", "");  // Read user input
        String lineTwo = scanner.nextLine().toLowerCase().trim().replace(" ", "");  // Read user input

        System.out.println(lineOne.equals(lineTwo));
    }
}