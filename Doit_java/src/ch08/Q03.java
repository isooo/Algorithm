package ch08;

import java.util.Scanner;

public class Q03 {
    static int kmpMatch(String txt, String pat) {
        int pt = 1; // txt를 따라가는 커서
        int pp = 0; // pat를 따라가는 커서
        int count = 0; // 비교횟수
        int[] skip = new int[pat.length() + 1]; // skip 테이블
        int k = -1;

        // skip 테이블 만들기
        System.out.println("skip 테이블 만들기");
        skip[pt] = 0;
        while (pt != pat.length()) {
            if (k == pt - pp)
                System.out.print("    ");
            else {
                System.out.printf("%2d  ", pt - pp);
                k = pt - pp;
            }
            for (int i = 0; i < txt.length(); i++)
                System.out.print(txt.charAt(i) + " ");
            System.out.println();

            for (int i = 0; i < pt * 2 + 4; i++)
                System.out.print(" ");
            System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
            System.out.println();

            for (int i = 0; i < (pt - pp) * 2 + 4; i++)
                System.out.print(" ");

            for (int i = 0; i < pat.length(); i++)
                System.out.print(pat.charAt(i) + " ");
            System.out.println();
            System.out.println();
            count++;
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        // 검색
        System.out.println("검색");
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (k == pt - pp)
                System.out.print("    ");
            else {
                System.out.printf("%2d  ", pt - pp);
                k = pt - pp;
            }
            for (int i = 0; i < txt.length(); i++)
                System.out.print(txt.charAt(i) + " ");
            System.out.println();

            for (int i = 0; i < pt * 2 + 4; i++)
                System.out.print(" ");
            System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
            System.out.println();

            for (int i = 0; i < (pt - pp) * 2 + 4; i++)
                System.out.print(" ");

            for (int i = 0; i < pat.length(); i++)
                System.out.print(pat.charAt(i) + " ");
            System.out.println();
            System.out.println();
            count++;
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }

        System.out.printf("비교는 %d회입니다.\n", count);
        if (pp == pat.length()) // 패턴의 모든 문자를 조사
            return pt - pp;
        return -1; // 검색실패
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트 : ");
        String s1 = sc.next();      // 텍스트용 문자열

        System.out.print("패턴 : ");
        String s2 = sc.next();      // 패턴용 문자열

        int idx = kmpMatch(s1, s2);

        System.out.println("검색 결과 : " + (idx + 1) + "번째부터 일치");

    }

}
