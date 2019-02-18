/*
package Feb2019.COSPro2;

import java.util.*;

public class Ex02 {

    public int solution(int n) {
        int tmp = n - 1;
        int[][] a = new int[tmp][tmp];
        for(int i = 0 ; i < n ; i++) {
            a[0][i] = i;
        }

        for(int i = 0 ; i < n ; i++) {
            a[i + 1][tmp] = i + n;
        }

        for(int i = 0 ; i < n ; i++) {
            a[tmp][tmp + 1 - i] = i + 2n;
        }

        for(int i = 0 ; i < n ; i++) {
            a[tmp + 1 - i][0] =
        }

        int answer = 0;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        int n1 = 3;
        int ret1 = ex02.solution(n1);


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = ex02.solution(n2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
*/
