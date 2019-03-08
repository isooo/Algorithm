package creativeAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
    반복문과 배열2개를 사용해서 해결하기

    ** 배열은 객체이기 때문에 new 하지않고 대입할 경우, shallow copy 가 된다..
 */

public class Ex19 {
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
//        System.out.println("******************");
//        for(int i=0; i<n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println("******************");
    }

    private static void fill(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=m) {
            return;
        }
        if(arr[x][y] == 0) {
            arr[x][y] = 2;
            fill(x, y+1);
            fill(x+1, y);
            fill(x, y-1);
            fill(x-1, y);
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
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        arr = new int[n][m];
//        arr2 = new int[n][m];
//        for(int i=0; i<n; i++) {
//            String[] str = sc.nextLine().split(" ");
//            for(int j=0; j<m; j++) {
//                arr2[i][j] = arr[i][j] = Integer.parseInt(str[j]);
//            }
//        }
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

        while (true) {
            fill(0, 0);
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println("---------------------------------------");

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
            hour++;
            copy();
        }
    }
}
