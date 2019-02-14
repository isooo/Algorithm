package ch06;

import java.util.Scanner;

public class Q09_2 {

    static void shellSort(int[] a, int cnt) {
        int h;

        int num = 0;
        for (h = 1; h < cnt / 9; h = h * 3 + 1) ;

        for (; h > 0; h /= 3) {
            for (int i = h; i < cnt; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    num++;
                }
                a[j + h] = tmp;
                num++;
            }
        }
        System.out.println("이동횟수 : " + num);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("셸 정렬(버전 2)");
        System.out.print("요솟수 : ");
        int cnt = sc.nextInt();
        int[] x = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        shellSort(x, cnt);

        System.out.println("오름차순으로 정렬했습니다.");

        for (int i = 0; i < cnt; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

}
