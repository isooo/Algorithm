package Feb2019.COSPro2;

import java.util.*;

public class Ex01 {
    public long solution(long num) {
        long answer = num + 1;
        String str = String.valueOf(answer);
        str = str.replace('0', '1');
        answer = Long.parseLong(str);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        long num = 9949999;
        long ret = ex01.solution(num);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
