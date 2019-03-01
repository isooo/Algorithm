package creativeAlgorithm;

import java.util.Scanner;
/*
    1부터 그 수까지 순서대로 공백을 두고 수를 출력하는데,
    3 또는 6 또는 9인 경우 그 수 대신 영문 대문자 X 를 출력한다다 */
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
