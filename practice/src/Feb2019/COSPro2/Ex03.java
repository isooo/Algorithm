package Feb2019.COSPro2;
/*
    체스 나이트(knight)의 이동
 */
public class Ex03 {
    public int solution(String pos) {

        int[] xPattern = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yPattern = {-1, 1, -2, 2, -2, 2, -1, 1};

        int x = pos.charAt(0) - 'A';
        int y = pos.charAt(1) - '0' - 1;

        int answer = 0;

        for(int i = 0 ; i < 8 ; i++) {
            int xTmp = x + xPattern[i];
            int yTmp = y + yPattern[i];
            if((0 <= xTmp && xTmp < 8) && (0 <= yTmp && yTmp < 8)) {
                answer++;
            }
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex03 ex03 = new Ex03();
        String pos = "A7";
        int ret = ex03.solution(pos);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}