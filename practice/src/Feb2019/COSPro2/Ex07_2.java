package Feb2019.COSPro2;
/*
    n일 동안 주식을 단 한 번 살 수 있습니다.
    n일 동안 주식을 단 한 번 팔 수 있습니다.
    주식을 산 날에 바로 팔 수는 없으며, 최소 하루가 지나야 팔 수 있습니다.
    적어도 한 번은 주식을 사야하며, 한 번은 팔아야 합니다.
 */
public class Ex07_2 {
    private int solution(int[] prices) {
        int result = 0;

// 제일 min을때 사야하고, 제일 max일때 팔아야함
// 단 min[i] < max[i]

        for(int i = 0 ; i < prices.length ; i++) {

        }


        return result;
    }

    public static void main(String[] args) {
        Ex07_2 ex07_2 = new Ex07_2();
        int[] prices1 = {1, 2, 3, 2, 6, 3};
        int ret1 = ex07_2.solution(prices1);

        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] prices2 = {3, 1};
        int ret2 = ex07_2.solution(prices2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
