package Feb2019.COSPro2;

import java.util.Arrays;

public class Ex05_2 {
    private int[] solution(int cnt, int[] votes) {
        int [] score = new int [10];
        for(int i = 0 ; i < votes.length ; i++) {
            score[votes[i] - 1]++;
        }

        int maxScore = 0;
        int maxCnt = 0;
        for(int i = 0 ; i < score.length ; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                maxCnt = 0;
            }
            if(score[i] != 0 && score[i] == maxScore) {
                maxCnt++;
            }
        }

        int answer [] = new int[maxCnt];
        int j = 0;
        for(int i = 0 ; i < score.length ; i++) {
            if (score[i] == maxScore) {
                answer[j++] = i + 1;
            }
        }
        Arrays.sort(answer);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main메소드는 잘못된 부분이 없으니, solution메소드만 수정하세요.
    public static void main(String[] args) {
        Ex05_2 ex05_2 = new Ex05_2();
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        int[] ret1 = ex05_2.solution(N1, votes1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret1) + " 입니다.");


        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        int[] ret2 = ex05_2.solution(N2, votes2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret2) + " 입니다.");
    }

}
