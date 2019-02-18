package Feb2019.COSPro1;

public class Ex06_2 {
    public int solution(int number) {
        int count = 0;
        boolean flag = true;
        for(int i = 1 ; i <= number ; i++ ) {
            int tmp = i;
            while(tmp > 0) {
                if(tmp % 10 != 0 && (tmp % 10) % 3 == 0) {
                    count++;
                    System.out.print("짝");
                    flag = false;
                }
                tmp /= 10;
            }
            if (flag) {
                System.out.print(i);
            }
            System.out.print("  ");
            flag = true;
        }
        System.out.println();
        return count;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex06_2 ex06_2 = new Ex06_2();
        int number = 40;
        int ret = ex06_2.solution(number);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
