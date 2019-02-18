package Feb2019.COSPro1;

public class Ex03_2 {
    private int func_a(int month, int day) {
        int [] monthList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int tot = 0;
        for (int i = 0 ; i < month - 1 ; i++) {
            tot += monthList[i];
        }
        tot += day;
        return tot - 1;
    }

    public int solution(int startMonth, int startDay, int endMonth, int endDay) {
        int startTotal = func_a(startMonth, startDay);
        int endTotal = func_a(endMonth, endDay);
        return endTotal - startTotal;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex03_2 ex03_2 = new Ex03_2();
        int startMonth = 1;
        int startDay = 2;
        int endMonth = 2;
        int endDay = 2;
        int ret = ex03_2.solution(startMonth, startDay, endMonth, endDay);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
