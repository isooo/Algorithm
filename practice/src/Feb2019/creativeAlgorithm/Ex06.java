package Feb2019.creativeAlgorithm;

import java.util.*;

/*
    두더지 굴 (dfs로 풀기)
    이 지도는 정사각형이고
    가로 세로 영역을 0 또는 1로 표현한다.
    0은 땅이고 1은 두더지 굴을 나타낸다.
    1이 상하좌우로 연결되어 있으면
    한 마리의 두더지가 사는 집으로 정의할 수 있다

    output :
    첫째 줄에 두더지 굴의 수를 출력한다.
    둘째 줄부터 각 두더지 굴의 크기를 내림 차순으로 한 줄에 하나씩 출력
 */
public class Ex06 {

    // 정사각형 길이
    public static int n = 0;

    public static void solution(int k, int[][] arr) {
        n = k;

        // 굴 개수 체크용
        int cnt = 0;

        for(int x = 0 ; x < n ; x++) {
            for(int y = 0 ; y < n ; y++) {
                if(arr[x][y] == 1) {
                    cnt++;
                    dfs(arr, x, y, cnt + 1);
                }
            }
        }

        int[] size = new int[cnt];
        for(int x = 0 ; x < n ; x++) {
            for(int y = 0 ; y < n ; y++) {
                if(arr[x][y] != 0) {
                    size[arr[x][y] - 2]++;
                }
            }
        }

//        Comparator<Integer> comparator = Comparator.comparingInt(o -> o); // 오름차순
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

        size = Arrays.stream(size)
                .boxed()
                .sorted(comparator)
                .mapToInt(n -> n.intValue())
                .toArray();

        System.out.println("굴의 개수 : " + cnt);
        System.out.println("size2 : " + Arrays.toString(size));
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }

    }

    // x랑 y가 정사각형 안에 있는지
   public static boolean isIn(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    public static void dfs(int[][] arr, int x, int y, int tmp) {
        arr[x][y] = tmp;
        if(isIn(x + 1, y) && arr[x + 1][y] == 1) {
            dfs(arr, x + 1, y, tmp);
        }
        if(isIn(x - 1, y) && arr[x - 1][y] == 1) {
            dfs(arr, x - 1, y, tmp);
        }
        if(isIn(x, y + 1) && arr[x][y + 1] == 1) {
            dfs(arr, x, y + 1, tmp);
        }
        if(isIn(x, y - 1) && arr[x][y - 1] == 1) {
            dfs(arr, x, y - 1, tmp);
        }
    }

    public static void dfs2(int[][] arr, int x, int y, int tmp) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        arr[x][y] = tmp;
        for(int i = 0 ; i < 4 ; i++) {
            if(isIn(x + dx[i], y + dy[i]) && arr[x + dx[i]][y + dy[i]] == 1) {
                dfs2(arr, x + dx[i], y + dy[i], tmp);
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int[][] arr = new int[size][size];
//        for(int i = 0 ; i < size ; i++) {
//            for(int j = 0 ; j < size ; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//            sc.nextLine();
//        }


// 만약, 입력받을 때 띄워쓰기 없이 이어서 배열 숫자를 받을 경우
//        String str = "";
//        sc.nextLine();
//        for(int i = 0 ; i < size ; i++) {
//            str = sc.nextLine();
//            for(int j = 0 ; j < size ; j++) {
//                arr[i][j] = str.charAt(j) - '0';
//            }
//        }
//        solution(size, arr);


        int size = 7;
        int[][] arr = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}};


        solution(size, arr);
    }
}
