package Feb2019.COSPro2;

public class Ex07 {
    int solution(int[] prices){
        int INF = 1000000001;
        int tmp = INF;
        int answer = -INF;
        for(int price : prices){
            if(tmp != INF)
                answer = Math.max(answer, price - tmp);
            tmp = Math.min(tmp, price);
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.  main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex07 ex07 = new Ex07();
        int[] prices1 = {1, 2, 3, 2, 6, 3};
        int ret1 = ex07.solution(prices1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] prices2 = {3, 1};
        int ret2 = ex07.solution(prices2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
