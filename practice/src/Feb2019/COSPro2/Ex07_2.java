package Feb2019.COSPro2;

public class Ex07_2 {
    private int solution(int[] prices) {
        int tmp = 1000001;
        int result = -tmp;

        for(int price : prices) {
            result = Math.max(result, price - tmp);
            tmp = Math.min(price, tmp);
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
