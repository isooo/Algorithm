package Feb2019.COSPro1;

public class Ex06 {

    public int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            int current = i;
            int temp = count;
            while (current != 0) {
                if ((current % 10) != 0 && (current % 10) % 3 == 0){
                    count++;
                    System.out.print("짝");
                }
                current /= 10;
            }
            if(temp == count)
                System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        return count;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        int number = 40;
        int ret = ex06.solution(number);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
