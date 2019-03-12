package creativeAlgorithm;

import java.util.Scanner;

public class Ex22 {
    private static int solution(int n, int[] list) {
        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int tmp = 0;
                for(int z=i; z<=j; z++) {
                    System.out.print(z + "\t");
                    tmp += list[z];
                }
                System.out.println("\n--------------");
                result = Math.max(result, tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] list = new int[n];
        for(int i=0; i<n; i++) {
            list[i] = sc.nextInt();
        }
        int result = solution(n, list);
        System.out.println(result);
    }
}
