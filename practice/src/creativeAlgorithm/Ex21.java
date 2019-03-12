package creativeAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
    깊이 우선 탐색 인접행렬로 작성하기
 */
public class Ex21 {
    private static int n;       // 정점의 개수
    private static int m;       // 간선의 개수
    private static int[][] g;
    private static int[] visited;

    private static void solution(final int v, final int c) {
        visited[v] = c;
        int can = 1;
        for(int i=0; i<n ;i++) {
            if(g[v][i] == 1 && visited[i] == c) {
                can = 0;
            }
        }

        if(can == 0) {
            visited[v] = 0;
            return;
        }
        for(int i=0; i<n ;i++) {
            if(g[v][i] == 1 && visited[i] == 0) {
                solution(i, 1);
                solution(i, 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       // 정점의 개수
        m = sc.nextInt();       // 간선의 개수

        g = new int[n][n];
        visited = new int[n];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a][b] = g[b][a] = 1;
        }
        solution(0, 1);
        int i = 0;
        for(; i<n ;i++) {
            if(visited[i] == 0) {
                System.out.println("impossible");
                break;
            }
        }
        if(i == n) {
            System.out.println("ok");
        }
    }
}