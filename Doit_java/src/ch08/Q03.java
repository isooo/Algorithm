package ch08;

import java.util.Scanner;

public class Q03 {

    public static int kmpMatch(String txt, String pat) {
        int pt = 1;                             // txt 커버
        int pp = 0;                             // pat 커서
        int[] skip = new int[pat.length() + 1];     // 건너뛰기 표

        // 건너뛰기용 표
        skip[pt] = 0;
        while(pt != pat.length()) {
            if(pat.charAt(pt) == pat.charAt(pp)) {
                skip[++pt] = ++pp;
            } else if(pp == 0) {
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }

        pt = pp = 0;

        // 검색
        while(pt != txt.length() && pp != pat.length()) {
            if(txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if(pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }
        }

        if(pp == pat.length()) {
            return pt - pp;         // pt - pp를 반환
        }

        return -1;                  // 검색 실패
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
