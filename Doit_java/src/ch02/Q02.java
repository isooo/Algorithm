package ch02;

import java.util.Scanner;

/*
    배열 요솟값을 읽어 들여 역순으로 정렬
 */
public class Q02 {

    static int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            sum += a[i];
        }
        return sum;
    }

    static void swap(int[] a, int n, int m) {
        System.out.println("\ta[" + n + "]과 a[" + m + "] 맞교환");
        int t = a[n];
        a[n] = a[m];
        a[m] = t;

        for(int i = 0 ; i < a.length ; i++) {
            System.out.print(a[i] + "  ");
        }
    }

    static void reverse(int[] a) {
        for (int i = 0 ; i < a.length/2 ; i++) {
            swap(a, i, a.length - i - 1);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("요소 개수 : ");
        int count = sc.nextInt();

        int[] arr = new int[count];

        for (int i = 0 ; i < count ; i++) {
            System.out.print(i + "번쨰 요소 : ");
            int num = sc.nextInt();
            arr[i] = num;
        }

        reverse(arr);

        System.out.println("--- 역순 정렬 끝 ---");
        System.out.println("--- 배열 요소의 합 : " + sumOf(arr));
    }// max3()
}
