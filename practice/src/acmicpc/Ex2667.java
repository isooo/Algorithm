package acmicpc;

import java.util.*;

public class Ex2667 {

    // 정사각형 길이
    private static int n = 0;

    private static void solution(int size, int[][] arr) {
        n = size;
        int cnt = 0;
        for(int x = 0 ; x < size ; x++) {
            for(int y = 0 ; y < size ; y++) {
                if(arr[x][y] == 1) {
                    cnt++;
                    dfs(arr, x, y, cnt + 1);
                }
            }
        }
        System.out.println(cnt);
        int[] region = new int[cnt];


        for(int x = 0 ; x < n ; x++) {
            for(int y = 0 ; y < n ; y++) {
                if(arr[x][y] != 0) {
                    region[arr[x][y] - 2]++;
                }
            }
        }
        Arrays.sort(region);

        for(int i = 0 ; i < cnt ; i++) {
            System.out.println(region[i]);
        }
    }

    private static boolean isIn(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    private static void dfs(int[][] arr, int x, int y, int tmp) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        arr[x][y] = tmp;
        for(int i = 0 ; i < 4 ; i++) {
            if(
                    isIn(
                            x + dx[i],
                            y + dy[i]
                    ) && (
                            arr[x + dx[i]][y + dy[i]] == 1
                    )
            ) {
                dfs(arr, x + dx[i], y + dy[i], tmp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        String str = "";
        sc.nextLine();
        for(int i = 0 ; i < size ; i++) {
            str = sc.nextLine();
            for(int j = 0 ; j < size ; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        solution(size, arr);
    }

}
