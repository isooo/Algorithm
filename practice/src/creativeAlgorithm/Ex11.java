package creativeAlgorithm;

import java.util.Scanner;
/*
    삼각화단 만들기
 */
public class Ex11 {
    private static int solution(int n) {
        int result = 0;
        for(int a = 0 ; a < n ; a++) {
            for(int b = a ; b < n ; b++) {
                for(int c = b ; c < n ; c++) {
                    if(a + b > c && a + b + c == n) {
                        System.out.println(a + ", " + b + ", " + c);
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
