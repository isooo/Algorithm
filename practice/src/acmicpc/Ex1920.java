package acmicpc;

import java.util.Scanner;

public class Ex1920 {
    public static void solution(int[] arr, int[] arr2) {
        int idx1 = 0;
        int idx2 = 0;

        for(int i = 0, j = 0  ; i < arr2.length ; i++) {
            for(j = 0 ; j < arr.length ; j++) {
                if(arr2[i] == arr[j]) {
                    System.out.println(1);
                    break;
                }
            }
            if (j == arr.length) {
                System.out.println(0);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0 ; i < n2 ; i++) {
            arr2[i] = sc.nextInt();
        }
        solution(arr, arr2);
    }
}
