package Feb2019.creativeAlgorithm;

import java.util.Scanner;

/*
    n-queen
    n*n체스 보드판에
    n개의 queen을 서로 공격하지 못하도록
    배치하는 방법을 찾아내는 문제
 */
public class Ex07 {

    private static int n = 0;
    private static int result = 0;
    private static int[] col = null;
    private static int[] inc = null;
    private static int[] dec = null;

    // r은 행
    // i는 열

    public static void solution(int r) {
        if(r >= n) {
            result++;
            return;
        }
        for(int i = 0 ; i < n ; i++) {
            if(col[i] != 1 && inc[i + r] != 1 && dec[n + r - i] != 1) {
                col[i] = inc[i + r] = dec[n + r - i] = 1;
                solution(r + 1);
                col[i] = inc[i + r] = dec[n + r - i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n];
        inc = new int[2 * n - 1];
        dec = new int[2 * n - 1];
        solution(0);
        System.out.println(result);
    }
}