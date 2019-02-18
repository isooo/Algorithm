package Feb2019.COSPro1;

import java.util.Arrays;

public class Ex01 {

    public int[] solution(String[] shirtSize) {
        int[] answer = new int[6];

        for(int i = 0 ; i < shirtSize.length ; i++) {
            switch (shirtSize[i]) {
                case "XS" :
                    answer[0] += 1;
                    break;
                case "S" :
                    answer[1] += 1;
                    break;
                case "M" :
                    answer[2] += 1;
                    break;
                case "L" :
                    answer[3] += 1;
                    break;
                case "XL" :
                    answer[4] += 1;
                    break;
                case "XXL" :
                    answer[5] += 1;
                    break;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex01 sol = new Ex01();
        String[] shirtSize = {"XS", "S", "L", "L", "XL", "S"};
        int[] ret = sol.solution(shirtSize);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }

}