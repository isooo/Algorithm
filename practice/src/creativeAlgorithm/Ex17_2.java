package creativeAlgorithm;

import java.util.Scanner;

public class Ex17_2 {
    // 특정 조건의 숫자만 탐색하여 시간 단축하기
    private static int digit;
    private static int cnt;
    private static void solution(int num, int len) {
        if(len == digit) {
            if(isPrime(num)) {
                cnt++;
                System.out.println(num);
            }
            return;
        } else {
            if(isPrime(num)) {
                solution(num*10+1, len+1);
                solution(num*10+3, len+1);
                solution(num*10+7, len+1);
                solution(num*10+9, len+1);
            }
        }
    }

    private static boolean isPrime(int n) {
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        digit = sc.nextInt();
        solution(2, 1);
        solution(3, 1);
        solution(5, 1);
        solution(7, 1);
        System.out.println(cnt);
    }
}
