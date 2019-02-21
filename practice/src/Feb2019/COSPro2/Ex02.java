package Feb2019.COSPro2;
/*
    n-소용돌이 수의
    대각선 수들의 합 구하기
 */
public class Ex02 {
    public static int[][] getMap(int n) {
        int[][] map = new int[n][n];
        int[] xAddPattern = {1, 0, -1, 0};
        int[] yAddPattern = {0, 1, 0, -1};
        int num = 0;
        int x = 0;
        int y = 0;

        while (true) {
            for (int i = 0; i < 4; i++) {
                int dx = x;
                int dy = y;
                System.out.println("i=" + i);
                while (true) {
                    if (((0 <= dx && dx < n) && (0 <= dy && dy < n)) && map[dy][dx] == 0) {
                        num = num + 1;
                        map[dy][dx] = num;
                        System.out.println("(" + dx + "," + dy + ")" + "=" + num);
                    }
                    dx = dx + xAddPattern[i];
                    dy = dy + yAddPattern[i];
                    if (((0 <= dx && dx < n) && (0 <= dy && dy < n)) && map[dy][dx] == 0) { // 다음 칸에 대한 예측
                        x = dx;
                        y = dy;
                    } else {
                        // 벽을 만나거나, 비어있지 않은 칸을 만나면
                        break;
                    }
                }
                if (num == (n * n)) {
                    return map;
                } else if (i == 3) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = getMap(4);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        /**
         * (1, 0) = array[0][1]
         * (3, 2) = array[2][3]
         */
    }


















//    int[][] pane;
//    int dx[] = {0, 1, 0, -1};
//    int dy[] = {1, 0, -1, 0};
//    boolean inRange(int i, int j, int n){
//        return 0 <= i && i < n && 0 <= j && j < n;
//    }
//
//    public int solution(int n){
//        pane = new int[n][n];
//        int ci = 0;
//        int cj = 0;
//        int num = 1;
//        while(inRange(ci, cj, n) && pane[ci][cj] == 0){
//            for(int k = 0; k < 4; k++){
//                if(!inRange(ci, cj, n) || pane[ci][cj] != 0) break;
//                while(true){
//                    pane[ci][cj] = num++;
//                    int ni = ci + dy[k];
//                    int nj = cj + dx[k];
//                    if(!inRange(ni, nj, n) || pane[ni][nj] != 0){
//                        ci += dy[(k + 1) % 4];
//                        cj += dx[(k + 1) % 4];
//                        break;
//                    }
//                    ci = ni;
//                    cj = nj;
//                }
//            }
//        }
//        int ans = 0;
//        for(int i = 0; i < n; i++) ans += pane[i][i];
//        return ans;
//    }
//
//
//    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
//    public static void main(String[] args) {
//        Ex02 ex02 = new Ex02();
//        int n1 = 3;
//        int ret1 = ex02.solution(n1);
//
//
//        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
//
//        int n2 = 2;
//        int ret2 = ex02.solution(n2);
//
//        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
//    }
}
