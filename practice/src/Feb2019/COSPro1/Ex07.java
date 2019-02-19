package Feb2019.COSPro1;
/*
    배열을 받아 조건에 만족하는 요소 체크하기
 */
public class Ex07 {

    public int solution(int[] scores) {
        int count = 0;
        for (int i = 0 ; i < scores.length ; i++)
            if (650 <= scores[i] && scores[i] < 800) {
                count += 1;
            }
        return count;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex07 ex07 = new Ex07();
        int[] scores = {650, 722, 914, 558, 714, 803, 650, 679, 669, 800};
        int ret = ex07.solution(scores);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
