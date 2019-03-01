package Feb2019.creativeAlgorithm;

import java.util.Scanner;

public class Ex09 {
    private static int solution(int n) {
        int result = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(n % i == 0) {
                result += i;
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
