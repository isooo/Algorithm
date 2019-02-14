package ch02;

import java.util.Scanner;

/*
    입력 받은 10진수를 2진수 ~36진수로 기수변환하여 나타냄(윗자리부터 배열에 저장)
 */
public class Q06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int no;                     // 변환하는 정수
        int cd;                     // 기수
        //       int dno;                    // 변환 후의 자릿수
        int retry;                  // 프로그램 재실행 여부

        System.out.println("10진수를 기수 변환합니다.");
        do {
            char[] cno = new char[32];  // 변환 후 각 자리의 숫자를 넣어두는 문자의 배열 (do~while 밖에서 선언시, 초기화 되지 않아 문제 발생)

            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = sc.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : ");
                cd = sc.nextInt();
            } while (cd < 2 || cd > 36);

            cno = cardConvR(no, cd, cno);

            System.out.print("\t\t ==> " + cd + "진수로는 ");
            for (int i = 0; i < cno.length; i++) {
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.print("\t한번 더 할까요? (1.예 / 2.아니오) : ");
            retry = sc.nextInt();
        } while (retry == 1);

    } //main()

    static char[] cardConvR(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char tmp = d[i];
            d[i] = d[digits - 1 - i];
            d[digits - 1 - i] = tmp;
        }

        return d;
    }

}
