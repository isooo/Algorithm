package ch08;

import java.util.Scanner;

public class Q01 {

    // 가장 앞쪽의 인덱스 반환
    static int bfMatch(String txt, String pat) {
        int pt = 0;     // txt 커서
        int pp = 0;     // pat 커서
        int cnt = 0;    // 비교 횟수

        int k = -1;     // 같은 char가 등장했을 경우(진행상황 표시)

        while (pt != txt.length() && pp != pat.length()) {
            if (k == pt - pp)
                System.out.print("      ");
            else {
                System.out.printf("%2d :: ", pt - pp);
                k = pt - pp;
            }

            // 텍스트 출력
            for (int i = 0; i < txt.length(); i++) {
                System.out.print(txt.charAt(i) + " ");
            }
            System.out.println();

            // 부호 앞 공백 출력
            for (int i = 0; i < pt * 2 + 6; i++) {
                System.out.print(" ");
            }
            System.out.print(txt.charAt(pt) == pat.charAt(pp) ? "+" : "|");
            System.out.println();

            // 패턴 앞 공백 출력
            for (int i = 0; i < (pt - pp) * 2 + 6; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < pat.length(); i++) {
                System.out.print(pat.charAt(i) + " ");
            }
            System.out.println("\n");

            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
            cnt++;
        }

        System.out.println("\t비교는 " + cnt + "회 였습니다.");

        if (pp == pat.length()) {    // 검색 성공
            return pt - pp;
        } else {
            return -1;
        }
    }

    // 가장 뒤쪽의 인덱스 반환
    public static int bfMatchLast(String txt, String pat) {
        int pt = txt.length() - 1;
        int pp = pat.length() - 1;

        while (pt >= 0 && pp >= 0) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt--;
                pp--;
            } else {
                pt = pat.length() - pp + pt - 1 - 1;
                // pp를 기준으로 몇 칸 진행되었는지 확인 후,
                // pt 에다 더하고 -1 하면 --> 현재 확인중인 pt 의 시작지점이 나올 것이고
                // 그 위치에서 -1 하여 새로운 pt 의 위치부터 다시 검색하면 된다
                pp = pat.length() - 1;
            }
        }

        if (pp < 0) {
//            return pt + 1 + pat.length();       // 검색 성공 했을경우엔, txt의 마지막 순서 반환
            return pt + 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트 : ");
        String s1 = sc.next();      // 텍스트용 문자열

        System.out.print("패턴 : ");
        String s2 = sc.next();      // 패턴용 문자열

        int idx = bfMatch(s1, s2);

        if (idx == -1) {
            System.out.println("텍스트에 패턴이 없습니다.");
        } else {
            int len = 0;
            for (int i = 0; i < idx; i++) {
                len += s1.substring(i, i + 1).getBytes().length;
            }
            len += s2.length();
            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
        }

        int idxLast = bfMatchLast(s1, s2);
        System.out.println("idxLast : " + idxLast + " // lastIndexOf : " + s1.lastIndexOf(s2));
    }

}
