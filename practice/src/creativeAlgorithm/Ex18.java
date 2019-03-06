package creativeAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    minimum sum : 깊이 우선 탐색(dfs)으로 풀기
 */
public class Ex18 {
    private static int n;
    private static int[][] arr;
    private static int result;
    private static int[] chk;

    private static void solution(int row, int score) {
        if(row == n) {
            result = Math.min(score, result);
            return;
        }
        for(int i=0; i<n; i++) {
            if(chk[i] == 0) {
                chk[i] = 1;
                solution(row+1, score + arr[row][i]);
                chk[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = Integer.MAX_VALUE;
        chk = new int[n];
        for(int i=0; i<n ; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solution(0, 0);
        System.out.println(result);
    }
}
