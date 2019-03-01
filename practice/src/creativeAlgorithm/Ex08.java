package creativeAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
    미로 찾기 : 최단경로의 길이 찾기
    너비 우선 탐색 이용
 */
public class Ex08 {
    private static int h;
    private static int w;
    private static int gX;
    private static int gY;

    static class Location {
        private int x;
        private int y;

        public Location() {
        }

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

    public static int solution(String[][] arr) {
        Location result = new Location();
        for(int x = 0 ; x < h ; x++) {
            for(int y = 0 ; y < w ; y++) {
                if(arr[x][y].equals("S")) {
                    result = bfs(arr, x, y);
                }
            }
        }
        if(result.getX() == gX && result.getY() == gY) {
            return Integer.parseInt(arr[gX][gY]);
        } else {
            return -1;
        }
    }

    public static Location bfs(String[][] arr, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
//        int step = 1;

        LinkedList<Location> q = new LinkedList<>();
        q.add(new Location(x, y));
        int tmpX = 0;
        int tmpY = 0;

        while(!q.isEmpty()) {
            System.out.println(Arrays.toString(q.toArray()));
            Location loc = q.poll();
            tmpX = loc.getX();
            tmpY = loc.getY();
//            System.out.println("\t" + tmpX + " ," + tmpY + " ==> step : " + step);
            if(tmpX == gX && tmpY == gY) {
                break;
            }
            for(int i = 0 ; i < 4 ; i++) {
                if(isIn(tmpX + dx[i], tmpY + dy[i]) && arr[tmpX + dx[i]][tmpY + dy[i]].equals(".")) {
                    arr[tmpX + dx[i]][tmpY + dy[i]] = String.valueOf(
                            Integer.parseInt(
                                    arr[tmpX][tmpY].equals("S") ? "0" : arr[tmpX][tmpY]
                            ) + 1
                    );
                    q.add(new Location(tmpX + dx[i], tmpY + dy[i]));
                }
            }
        }
        Location result = new Location(tmpX, tmpY);
        return result;
    }

    private static boolean isIn(int x, int y) {
        return (0 <= x && x < h) && (0 <= y && y < w);
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int h = Integer.parseInt(st.nextToken());
//        int w = Integer.parseInt(st.nextToken());
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc. nextInt();
        String[][] arr = new String[h][w];
        sc.nextLine();
        for(int i = 0 ; i < h ; i++) {
            arr[i] = sc.nextLine().split("");
            for(int j = 0 ; j < w ; j++) {
                if(arr[i][j].equals("G")) {
                    gX = i;
                    gY = j;
                    arr[i][j] = ".";
                }
            }
        }
//        String[][] arr = {
//                {"#", "S", "#", "#", "#"},
//                {"#", ".", ".", ".", "#"},
//                {"#", ".", "#", ".", "#"},
//                {"#", ".", ".", ".", "."},
//                {"#", "#", "#", ".", "#"}
//        };
//
//        gX = 4;
//        gY = 3;

        int result = solution(arr);
        System.out.println("result : " + result);
    }
}
