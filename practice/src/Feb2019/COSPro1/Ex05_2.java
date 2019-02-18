package Feb2019.COSPro1;

import java.util.Arrays;

public class Ex05_2 {
    public int[] solution(int[] arr) {
        for(int i = 0 ; i < arr.length / 2 ; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }

        return arr;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex05_2 ex05_2 = new Ex05_2();
        int[] arr = {1, 4, 2, 3};
        int[] ret = ex05_2.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
