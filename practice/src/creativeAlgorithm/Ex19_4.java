package creativeAlgorithm;

/*
    배열 하나로 해결하기
 */

import java.util.Arrays;

public class Ex19_4 {
    private static int n;
    private static int m;
    private static int[][] arr;

    private static boolean inside(int x, int y) {
        return ((0 <= x && x < n)&&(0 <= y && y < m));
    }

    private static boolean done() {
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == -1 || arr[i][j] > 2) {
                    arr[i][j] = 0;
                } else if(arr[i][j] == 2 || arr[i][j] == 1) {
                    arr[i][j] = 1;
                    cnt++;
                }
            }
        }
        return cnt==0;
    }

    private static void solve(int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        arr[x][y] = -1;
        for(int i=0; i<4; i++) {
            if(inside(x+dx[i], y+dy[i])) {
                if(arr[x+dx[i]][y+dy[i]] == 0) {
                    solve(x+dx[i], y+dy[i]);
                } else if(arr[x+dx[i]][y+dy[i]] > 0) {
                    System.out.println("\tarr[" + (x+dx[i]) + "][" + (y+dy[i]) + "] = " + arr[x+dx[i]][y+dy[i]]);
                    arr[x+dx[i]][y+dy[i]]++;
                }
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        arr = new int[n][m];
//        for(int i=0; i<n; i++) {
//            String[] str = sc.nextLine().split(" ");
//            for(int j=0; j<m; j++) {
//                arr[i][j] = Integer.parseInt(str[j]);
//            }
//        }

//        n = 8;
//        m = 9;
//        arr = new int[][]{
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 1, 0, 0, 0, 0},
//                {0, 0, 0, 1, 1, 0, 1, 1, 0},
//                {0, 0, 1, 1, 1, 1, 1, 1, 0},
//                {0, 0, 1, 1, 1, 1, 1, 0, 0},
//                {0, 0, 1, 1, 0, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0}
//        };

        n = m = 4;
        arr = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 1}
        };

        int result = 0;

        for(; !done(); result++) {
            for(int i=0; i<n; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println("---------------------");
            solve(0, 0);
            for(int i=0; i<n; i++) {
                System.out.println("\t\t" + Arrays.toString(arr[i]));
            }
            System.out.println("------------------------------------------");

        }
        System.out.println(result);
    }
}
