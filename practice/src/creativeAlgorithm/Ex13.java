package creativeAlgorithm;

import java.util.Scanner;
/*
    고기잡이
 */
public class Ex13 {
    private static int solution(int n, int m, int w, int h, int[][] arr) {
        int result = 0;

        for(int i = 0 ; i < n - w + 1 ; i++) {
            for(int j = 0 ; j < m - h + 1 ; j++) {
                int sum = 0;
                for(int x = 0 ; x < w ; x++) {
                    for(int y = 0 ; y < h ; y++) {
                        sum += arr[i + x][j + y];
                    }
                }
                if(sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       // 연못의 폭
        int m = sc.nextInt();
        sc.nextLine();
        int w = sc.nextInt();
        int h = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            String[] str = sc.nextLine().split(" ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(solution(n, m, w, h, arr));
    }
}
