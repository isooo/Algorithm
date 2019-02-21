package Feb2019.COSPro2;

import java.util.Arrays;
/*
    최대빈도인 요소 구하기
 */
public class Ex05 {
    public int[] solution(int N, int[] votes) {
    int voteCounter[] = new int[11];
    for (int i = 0; i < votes.length; i++) {
        voteCounter[votes[i]] += 1;
    }
    int maxVal = 0;
    int cnt = 0;

    for (int i = 1; i <= N; i++) {
        if (maxVal < voteCounter[i]) {
            maxVal = voteCounter[i];
            cnt = 1;
        } else if(maxVal == voteCounter[i]){
            cnt += 1;
        }
    }
    int answer[] = new int[cnt];
    for (int i = 1, idx = 0; i <= N; i++){
        if (voteCounter[i] == maxVal) {
            answer[idx] = i;
            idx += 1;
        }
    }
    return answer;
}

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main메소드는 잘못된 부분이 없으니, solution메소드만 수정하세요.
    public static void main(String[] args) {
        Ex05 ex05 = new Ex05();
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        int[] ret1 = ex05.solution(N1, votes1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret1) + " 입니다.");


        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        int[] ret2 = ex05.solution(N2, votes2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret2) + " 입니다.");
    }
}