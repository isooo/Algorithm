package ch01;

/*
    구구단 표를 나타냄 (곱한 수를 나타냄)
 */

public class Q12 {

    public static void main(String[] args) {

        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                System.out.print("  |");
                multi(1);
                System.out.println("--+---------------------------");
            } else {
                System.out.print(i + " |");
                multi(i);
            }
        } //for

    }

    static void multi(int i) {
        for (int j = 1; j <= 9; j++) {
            System.out.printf("%3d", i * j);
        }
        System.out.println("");
    }

    static void multiAnswer() {
        System.out.print("   |");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);
        System.out.println("\n---+---------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 9; j++)
                System.out.printf("%3d", i * j);
            System.out.println();
        }
    }
}
