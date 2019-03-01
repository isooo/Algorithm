package creativeAlgorithm;

import java.util.Scanner;
/*
    삼각화단 만들기
 */
public class Ex11 {
    private static int solution(int n) {
        int result = 0;
        for(int a = 1 ; a <= n / 2 ; a++) {
            for(int b = (n - a) / 2 ; b >= a ; b--) {
//                for(int c = b ; c < n ; c++) {
                int c = n - a - b;
                    if(a + b > c) {
                        System.out.println(a + ", " + b + ", " + c);
                        result++;
                    } else {
                        break;
                    }
//                }
            }
        }
        return result;
    }
//    private static int cnt;
//    private static int[][][] chk = new int[100][100][100];
//    private static void solution2(int n, int a, int b, int c) {
//        if(a + b + c == n) {
//            if(a <= b && b <= c && a+ b > c && chk[a][b][c] == 0) {
//                cnt++;
//                chk[a][b][c] = 1;
//            }
//            return;
//        }
//        solution2(n, a + 1, b, c);
//        solution2(n, a, b + 1, c);
//        solution2(n, a, b, c + 1);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
//        solution2(n,1, 1, 1);
//        System.out.println(cnt);
    }
}
