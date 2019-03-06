package creativeAlgorithm;

import java.util.Scanner;

public class Ex17 {
    // 전체탐색
    private static void solution(int n) {
        int range = (int)Math.pow(10, n);
        int cnt = 0;
        int tmp = (int)Math.pow(10, n - 1);
        while(tmp < range) {
            int tmp2 = tmp;
            while(tmp2 > 0) {
                if(!isPrime(tmp2)) {
                    break;
                }
                tmp2 /= 10;
            }
            if(tmp2 == 0) {
                System.out.println(tmp);
                cnt++;
            }
            tmp++;
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        if(n%10 == 0) {
            return false;
        }
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
