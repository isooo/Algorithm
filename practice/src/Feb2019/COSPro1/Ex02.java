package Feb2019.COSPro1;

import java.util.*;

public class Ex02 {
    public int solution(int price, String grade) {
        HashMap<String, Integer> table = new HashMap<>();
        table.put("S", 5);
        table.put("G", 10);
        table.put("V", 15);

        int answer = price - (price * table.get(grade) / 100);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        int price1 = 2500;
        String grade1 = new String("V");
        int ret1 = ex02.solution(price1, grade1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int price2 = 96900;
        String grade2 = new String("S");
        int ret2 = ex02.solution(price2, grade2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
