package ch03;

import java.util.Scanner;

/*
    어떤 값을 갖는 배열 안의 모든 요소를 다른 배열에 복사함
 */
public class Q03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int n = sc.nextInt();

        int[] a = new int[n];


        System.out.print("x[0]의 요소 : ");
        a[0] = sc.nextInt();

        for(int i = 1 ; i < n ; i++) {
            System.out.print("x[" + i + "]의 요소 : ");
            a[i] = sc.nextInt();
        }

        System.out.print("찾고자 하는 값 : ");
        int key = sc.nextInt();

        int[] idx = new int[n];

        int count = searchIdx(a, n, key, idx);

        System.out.println(count + "만큼 존재합니다");
        for(int i = 0 ; i < count ; i++) {
            System.out.print(" " + idx[i]);
        }
    }

    static int searchIdx(int[] a, int n, int key, int[] idx) {

        int idxKey = 0;

        for(int i = 0 ; i < n ; i++) {
            if(a[i] == key) {
                idx[idxKey++] = i;
            }
        }

        return idxKey;
    }

}