package ch06;

import java.util.Scanner;

public class Q09_1 {

    static void shellSort(int[] a, int n) {
        int cnt = 0;
        for(int h = n / 2 ; h > 0 ; h /= 2) {
            for(int i = h ; i < n ; i++) {
                int j;
                int tmp = a[i];
                for(j = i - h ; j >= 0 && a[j] > tmp ; j -= h) {
                    a[j + h] = a[j];
                    cnt++;
                }
                a[j + h] = tmp;
                cnt++;
            }
        }
        System.out.println("이동횟수 : " + cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("셸 정렬(버전1)");
        System.out.print("요솟수 : ");
        int cnt = sc.nextInt();
        int[] x = new int[cnt];

        for(int i = 0 ; i < cnt ; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        shellSort(x, cnt);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0 ; i < cnt ; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

}
