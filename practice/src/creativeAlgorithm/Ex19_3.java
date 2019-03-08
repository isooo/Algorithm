package creativeAlgorithm;

/*
    바뀔 부분을 저장해두었다가 처리하기
 */

import java.util.Arrays;

public class Ex19_3 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static int[][] arr2;

    private static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }
    private static void fill2(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < m) && arr2[x][y] == 0) {
            arr2[x][y] = 2;
            fill2(x, y+1);
            fill2(x+1, y);
            fill2(x, y-1);
            fill2(x-1, y);
        }
    }
    private static void fill3(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < m) && (arr[x][y] == 3 || arr[x][y] == 0)) {
            arr[x][y] = 2;
            fill3(x, y+1);
            fill3(x+1, y);
            fill3(x, y-1);
            fill3(x-1, y);
        }
    }

    private static int check(int x, int y) {
        int t = 0;
        if (arr[x][y + 1] == 2) t++;
        if (arr[x + 1][y] == 2) t++;
        if (arr[x][y - 1] == 2) t++;
        if (arr[x - 1][y] == 2) t++;
        return t;
    }

    public static void main(String[] args) {
        int hour = 0;
        n = 8;
        m = 9;
        arr = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        arr2 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        fill3(0, 0);

        while (true) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && check(i, j) >= 2) {
                        arr2[i][j] = 0;
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(hour);
                break;
            }
            for(int i=0; i<n ;i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j]==1 && arr2[i][j]==0) {
                        fill2(i, j);
                    }
                }
            }
            hour++;
            copy();
        }
    }
}
