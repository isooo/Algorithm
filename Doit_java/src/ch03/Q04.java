package ch03;

import java.util.Scanner;

/*
    이진검색 (검색과정을 자세히 출력함)
 */
public class Q04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int num = sc.nextInt();

        int[] x = new int[num];

        System.out.print("x[0]의 요소 : ");
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]의 요소 : ");
                x[i] = sc.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("찾고자 하는 값 : ");
        int value = sc.nextInt();

        int key = binSearch(x, num, value);

        if (key == -1) {
            System.out.println("해당하는 값은 없습니다.");
        } else {
            System.out.println("해당하는 " + value + "의 키는 " + key + "입니다.");
        }

    }

    static int binSearch(int[] x, int num, int value) {

        System.out.print("   |");
        for (int i = 0; i < num; i++)
            System.out.printf("%4d", i);
        System.out.println();

        System.out.print("---+");
        for (int i = 0; i < 4 * num + 2; i++)
            System.out.print("-");
        System.out.println();

        int pl = 0;
        int pr = num - 1;

        do {

            int pc = (pl + pr) / 2;

            System.out.print("   |");

            if (pl != pc)
                System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
            else
                System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
            if (pc != pr)
                System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
            else
                System.out.println("->");

            System.out.printf("%3d|", pc);
            for (int j = 0; j < num; j++) {
                System.out.printf("%4d", x[j]);
            }
            System.out.println("\n   |");

            if (x[pc] == value) {
                return pc;
            } else if (x[pc] < value) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }

        } while (pl <= pr);

        return -1;
    }

}