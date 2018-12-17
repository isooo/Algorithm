package ch06;

import java.util.Scanner;

public class Q19 {
    static void printArr(String str, int[] a) {
        System.out.print("\t" + str + "[] : ");
        for(int i = 0 ; i < a.length ; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println("\n");
    }


    static void fSort(int[] a, int n, int min, int max) {
        int[] f = new int[max - min + 1];    // 누적 도수
        int[] b = new int[n];    // 작업용 목적 배열

        System.out.println("1단계 : 도수분포표 만들기");
        for(int i = 0 ; i < n ; i++) {
            f[a[i] - min]++;
            printArr("f", f);
        }

        System.out.println("2단계 : 누적도수분포표 만들기");
        for(int i = 1 ; i < max - min + 1 ; i++) {
            f[i] += f[i - 1];
            printArr("f", f);
        }

        System.out.println("3단계 : 목적배열 만들기");
        for(int i = n - 1 ; i >= 0 ; i--) {
            b[--f[a[i] - min]] = a[i];
            printArr("b", b);
            printArr("f", f);
            System.out.println();
        }

        System.out.println("4단계 : 배열 복사하기");
        for(int i = 0 ; i < n ; i++) {
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int cnt = sc.nextInt();
        int[] x = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            do{
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            } while(x[i] < 0);
        }

        // 배열 x의 최댓값과 최솟값을 구하여 max에 대입
        int max = x[0];
        int min = x[0];
        for(int i = 1 ; i < cnt ; i++) {
            if(x[i] > max) {
                max = x[i];
            } else if(x[i] < min) {
                min = x[i];
            }
        }
        System.out.println(min + " ~ " + max);
        fSort(x, cnt, min,  max);

        System.out.print("도수 정렬로 오름차순 정렬 완료 : ");
        for(int i = 0 ; i < cnt ; i++) {
            System.out.print(" " + x[i]);
        }
    }
}
