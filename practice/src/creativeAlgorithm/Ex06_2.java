package creativeAlgorithm;

import java.util.*;

/*
    두더지 굴 (bfs로 풀기)
 */
public class Ex06_2 {
    static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "[" + x +
                    ", " + y +
                    ']';
        }
    }

    private static int n = 0;

    private static void solution(int[][] arr) {
        int cnt = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                    bfs(i, j, cnt + 1, arr);
                }
            }
        }

        int[] size = new int[cnt];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] != 0) {
                    size[arr[i][j] - 2]++;
                }
            }
        }
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

        size = Arrays.stream(size)
                .boxed()
                .sorted(comparator)
                .mapToInt(n -> n.intValue())
                .toArray();

        System.out.println("굴의 개수 : " + cnt);
        System.out.println("" + Arrays.toString(size));
    }

    private static void bfs(int x, int y, int value, int[][] arr) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        LinkedList<Location> q = new LinkedList<>();
        q.add(new Location(x, y));

        while(q.size() != 0) {
//            System.out.println("\t queue : " + Arrays.toString(q.toArray()));
            int tmpX = q.peek().getX();
            int tmpY = q.peek().getY();
            q.poll();
            if(arr[tmpX][tmpY] == 1) {
                arr[tmpX][tmpY] = value;
                for(int i = 0 ; i < 4 ; i++) {
                    if(isIn(tmpX + dx[i], tmpY + dy[i]) && arr[tmpX + dx[i]][tmpY + dy[i]] == 1) {
                        q.add(new Location(tmpX + dx[i], tmpY + dy[i]));
                    }
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        int[][] arr = new int[n][n];
//        for(int i = 0 ; i < n ; i++) {
//            for(int j = 0 ; j < n ; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//            sc.nextLine();
//        }

        n = 7;
        int[][] arr = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}};

        solution(arr);
    }
}
