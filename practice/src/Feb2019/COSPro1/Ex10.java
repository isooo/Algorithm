package Feb2019.COSPro1;

public class Ex10 {
    public int solution(int[] data) {
        double total = 0;
        int len = data.length;
        for(int i = 0 ; i < len ; i++)
            total += data[i];
        int cnt = 0;
        double average = total / len;
        for(int i = 0 ; i < len ; i++)
            if (data[i] <= average) {
                cnt += 1;
            }
        return cnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex10 ex10 = new Ex10();
        int[] data1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int ret1 = ex10.solution(data1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] data2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 10};
        int ret2 = ex10.solution(data2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
