package ch08;

import java.util.Scanner;

public class Q04 {

    static int bmMatch(String txt, String pat) {
        int pt;                         // txt 커서
        int pp;                         // pat 커서
        int txtLen = txt.length();      // txt의 문자 개수
        int patLen = pat.length();      // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1];
        int cnt = 0;                    // 비교횟수
        int k = -1;


        // 건너뛰기 표 만들기
        System.out.println("건너뛰기 표 만들기");
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        for (pt = 0; pt < patLen - 1; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1;
            System.out.println("\tskip[" + pat.charAt(pt) + "] ==> " + skip[pat.charAt(pt)] + " ///// patLen : " + patLen + " ///// pt : " + pt);
        }

        // 검색 (pat의 끝 문자에 주목)
        while (pt < txtLen) {
            pp = patLen - 1;        // pat의 마지막 문제에 주목

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
            cnt++;


            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) {
                    return pt;      // 검색 성공
                }
                pp--;
                pt--;
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
                cnt++;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;                  // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트 : ");
        String s1 = sc.next();      // 텍스트용 문자열

        System.out.print("패턴 : ");
        String s2 = sc.next();      // 패턴용 문자열

        int idx = bmMatch(s1, s2);

        System.out.println("검색 결과 : " + (idx + 1) + "번째부터 일치");

    }

}
