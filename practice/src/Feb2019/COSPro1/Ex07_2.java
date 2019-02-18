package Feb2019.COSPro1;

public class Ex07_2 {
    public int solution(int[] scores) {
        int count = 0;
        for(int score : scores) {
            if(score >= 650 && score < 800) {
                count++;
            }
        }
        return count;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex07_2 ex07_2 = new Ex07_2();
        int[] scores = {650, 722, 914, 558, 714, 803, 650, 679, 669, 800};
        int ret = ex07_2.solution(scores);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
