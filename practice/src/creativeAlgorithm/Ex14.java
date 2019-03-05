package creativeAlgorithm;

import java.util.Scanner;

/*
    오목
        1. 0, 0)부터 (18, 18)까지 행 우선으로 탐색을 시작한다.
        2. 현재 탐색 중인 돌을 기준으로 오목이 완성되었는지 검사한다.
        3. 완성되지 않았으면 탐색을 진행하기 위해 2번으로 간다.
        4. 완성된 돌의 위치와 색깔을 출력한다.
 */
public class Ex14 {
    private static void solution(int[][] arr) {
        for(int i = 1 ; i <= 19 ; i++) {
            for(int j = 1 ; j <= 19 ; j++) {
                if(arr[i][j] != 0) {
                    if(arr[i][j - 1] != arr[i][j] && search1(arr, arr[i][j], i, j)) {
                        System.out.printf("%d\n%d %d", arr[i][j], i, j);
                        return;
                    }       // ->
                    if(arr[i - 1][j - 1] != arr[i][j] && search2(arr, arr[i][j], i, j)) {
                        System.out.printf("%d\n%d %d", arr[i][j], i, j);
                        return;
                    }       // \
                    if(arr[i - 1][j] != arr[i][j] && search3(arr, arr[i][j], i, j)) {
                        System.out.printf("%d\n%d %d", arr[i][j], i, j);
                        return;
                    }       // |
                    if(arr[i + 1][j - 1] != arr[i][j] && search4(arr, arr[i][j], i, j)) {
                        System.out.printf("%d\n%d %d", arr[i][j], i, j);
                        return;
                    }       // /
                }
            }
        }
        System.out.println("0");
        return;
    }

    private static boolean search1(int[][]arr, int color, int i, int j) {
        int cnt = 1;
        for(; color == arr[i][j+1]; j++) {
            cnt++;
        }
        return cnt == 5 ? true : false;
    }
    private static boolean search2(int[][]arr, int color, int i, int j) {
        int cnt = 1;
        for(; color == arr[i+1][j+1]; i++, j++) {
            cnt++;
        }
        return cnt == 5 ? true : false;
    }
    private static boolean search3(int[][]arr, int color, int i, int j) {
        int cnt = 1;
        for(; color == arr[i+1][j]; i++) {
            cnt++;
        }
        return cnt == 5 ? true : false;
    }
    private static boolean search4(int[][]arr, int color, int i, int j) {
        int cnt = 1;
        for(; color == arr[i-1][j+1]; i--, j++) {
            cnt++;
        }
        return cnt == 5 ? true : false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[21][21];

        Scanner sc = new Scanner(System.in);
        for(int i = 1 ; i <= 19 ; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for(int j = 1 ; j <= 19 ; j++) {
                arr[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

/*
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 0, 0, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
*/
        solution(arr);
    }
}
