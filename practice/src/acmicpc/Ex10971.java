package acmicpc;

import java.util.Scanner;

public class Ex10971 {
    private static int target;
    private static int[][] edge;
    private static int result;
    private static int[] chk;

    public static void solution() {
        for(int i=0; i<target; i++) {
            dfs(i, i, 0, 1);
        }
    }

    public static void dfs(int start, int node, int value, int cnt) {
        if(cnt == target + 1 && node == start) {
            result = Math.min(value, result);
            return;
        }

        for(int i=0; i<target; i++) {
            if(chk[i] == 0 && edge[node][i] != 0) {
                chk[i] = 1;
                value += edge[node][i];
                if(value <= result) {
                    dfs(start, i, value, ++cnt);
                }
                chk[i] = 0;
                cnt--;
                value -= edge[node][i];
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        edge = new int[target][target];
        for(int i=0; i<target; i++) {
            for(int j=0; j<target; j++) {
                edge[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        chk = new int[target];

        result = Integer.MAX_VALUE;
        solution();
        System.out.println(result);
    }
}
