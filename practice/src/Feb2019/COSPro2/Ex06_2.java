package Feb2019.COSPro2;

public class Ex06_2 {
    public int func(int n) {
        if(n == 0) {
            return 2;
        } else if (n == 1) {
            return 0;
        }
        return 1;
    }

    public int solution(int[] recordA, int[] recordB){
        int result = 0;

        for(int i = 0 ; i < recordA.length ; i++) {
            if(recordA[i] == recordB[i]) {
                continue;
            } else if (func(recordA[i]) == recordB[i]) {
                result += 3;
            } else {
                result = Math.max(0, result - 1);
            }
        }

        return result;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex06_2 ex06_2 = new Ex06_2();
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        int ret = ex06_2.solution(recordA, recordB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}