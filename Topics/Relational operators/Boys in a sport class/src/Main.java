import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer first = scanner.nextInt();  // Read user input
        Integer second = scanner.nextInt();  // Read user input
        Integer third = scanner.nextInt();  // Read user input

        System.out.println((first >= second && second >= third) || (third >= second && second >= first));
    }
}