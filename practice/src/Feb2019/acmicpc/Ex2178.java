package Feb2019.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex2178 {

    static class Location {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x +
                    ", " + y +
                    ']';
        }
    }

    private static int targetX;
    private static int targetY;

    private static void solution(int[][] arr) {
        for(int i = 0 ; i < targetX ; i++) {
            for(int j = 0 ; j < targetY ; j++) {
                bfs(arr, i, j);
            }
        }

        for(int i = 0 ; i < targetX ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println(arr[targetX - 1][targetY - 1]);
    }

    private static void bfs(int[][] arr, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        LinkedList<Location> q = new LinkedList<>();
        q.add(new Location(x, y));

        while(!q.isEmpty()) {
            Location loc = q.poll();
            for(int i = 0 ; i < 4 ; i++) {
                if(isIn(loc.x + dx[i], loc.y + dy[i], arr)) {
                    arr[loc.x + dx[i]][loc.y + dy[i]] = arr[loc.x][loc.y] + 1;
                    q.add(new Location(loc.x + dx[i], loc.y + dy[i]));
                }
            }
        }
    }

    private static boolean isIn(int x, int y, int[][] arr) {
        return (0 <= x && x < targetX) && (0 <= y && y < targetY) && (arr[x][y] == 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        targetX = sc.nextInt();
        targetY = sc.nextInt();

        int[][] arr = new int[targetX][targetY];
sc.nextLine();
        for(int i = 0 ; i < targetX ; i++) {
            String[] tmp = sc.nextLine().split("");
            for(int j = 0 ; j < targetY ; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        solution(arr);
    }
}
