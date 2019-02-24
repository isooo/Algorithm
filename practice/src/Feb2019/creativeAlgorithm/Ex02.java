package Feb2019.creativeAlgorithm;

import java.util.Scanner;

public class Ex02 {
    public static void solution(int n) {
        for(int i = 1 ; i <= n ; i++) {
            int tmp = i;
            int flag = 0;
            while(tmp > 0) {
                if(tmp % 10 == 3 || tmp % 10 == 6 || tmp % 10 == 9) {
                    System.out.print("X");
                    flag = 1;
                }
                tmp /= 10;
            }
            if(flag == 0) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
