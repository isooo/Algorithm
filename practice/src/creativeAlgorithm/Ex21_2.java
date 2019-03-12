package creativeAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/*
    깊이 우선 탐색 인접리스트로 작성하기
 */
public class Ex21_2 {
    private static int n;       // 정점의 개수
    private static int m;       // 간선의 개수
    private static ArrayList<Integer>[] g;
    private static int[] visited;

    private static void solution(final int v, final int c) {
        visited[v] = c;
        boolean can = true;
        for(int i=0; i<g[v].size() ;i++) {
            if(visited[g[v].get(i)] == c) {
                can = false;
            }
        }
        if(!can) {
            visited[v] = 0;
            return;
        }
        for(int i=0; i<g[v].size(); i++) {
            if(visited[g[v].get(i)] == 0) {
                solution(g[v].get(i), 1);
                solution(g[v].get(i), 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       // 정점의 개수
        m = sc.nextInt();       // 간선의 개수
        visited = new int[n];
        g = new ArrayList[n];
        for(int i=0; i<n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
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