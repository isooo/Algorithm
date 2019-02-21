package Feb2019.COSPro2;

import java.util.Arrays;

/*
    배열 합치고 오름차순 정렬
 */
public class Ex04_3 {
    public int[] solution(int[] arrA, int[] arrB) {
        int aLength = arrA.length;
        int bLength = arrB.length;
        int [] answer = new int[aLength + bLength];
        int aIdx = 0;
        int bIdx = 0;
        int ansIdx = 0;
        while (aIdx < aLength && bIdx < bLength) {
            if(arrA[aIdx] < arrB[bIdx]) {
                answer[ansIdx++] = arrA[aIdx++];
            } else {
                answer[ansIdx++] = arrB[bIdx++];
            }
        }
        while(aIdx < aLength) {
            answer[ansIdx++] = arrA[aIdx++];
        }
        while(bIdx < bLength) {
            answer[ansIdx++] = arrB[bIdx++];
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex04_3 ex04 = new Ex04_3();
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = ex04.solution(arrA, arrB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
