package Feb2019.creativeAlgorithm;

import java.util.Scanner;

/*
    n-queen
    n*n체스 보드판에
    n개의 queen을 서로 공격하지 못하도록
    배치하는 방법을 찾아내는 문제
    (dfs로 해결)
 */
public class Ex07 {

    private static int n = 0;
    private static int result = 0;
    private static int[] col = null;    // 열 체크
    private static int[] inc = null;    // 오른쪽 위 대각선
    private static int[] dec = null;    // 오른쪽 아래 대각선

    // r은 행
    // i는 열

    public static void solution(int r) {
        if(r >= n) {
            // r이 n까지 왔다는건 퀸을 배치하는 방법 하나를 찾아낸 상태
            result++;
            return;     // 백트랙
        }
        // r행의 i열에 퀸을 놓기 시작
        for(int i = 0 ; i < n ; i++) {
            if(col[i] != 1 && inc[i + r] != 1 && dec[n + r - i] != 1) {
                col[i] = inc[i + r] = dec[n + r - i] = 1;
                solution(r + 1);
                col[i] = inc[i + r] = dec[n + r - i] = 0;
                // 백트랙 후 흔적 제거
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n];
        inc = new int[2 * n];
        dec = new int[2 * n];
        solution(0);
        System.out.println(result);
    }
}