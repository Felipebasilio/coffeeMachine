import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smaller = 0, bigger = 0, equal = 0;
        Integer loopSize = scanner.nextInt();

        for (int i = 0; i < loopSize; i++) {
            Integer current = scanner.nextInt();
            if (current == 0) {
                equal++;
            } else if (current > 0) {
                bigger++;
            } else {
                smaller++;
            }
        }
        System.out.print(equal + " " + bigger + " " + smaller);
    }
}