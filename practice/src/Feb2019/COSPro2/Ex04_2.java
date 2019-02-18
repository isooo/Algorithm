package Feb2019.COSPro2;

import java.util.Arrays;

public class Ex04_2 {
    public int[] solution(int[] arrA, int[] arrB) {
        int [] answer = new int[arrA.length + arrB.length];

        for(int i = 0 ; i < arrA.length ; i++) {
            answer[i] = arrA[i];
        }
        for(int i = 0 ; i < arrB.length ; i++) {
            answer[i + arrA.length] = arrB[i];
        }

        Arrays.sort(answer);

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex04_2 ex04 = new Ex04_2();
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = ex04.solution(arrA, arrB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
