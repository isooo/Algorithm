package Feb2019.COSPro2;

public class Ex06 {

/*    public int func(int record){
        if (record == 1) {
            return 0;
        } else if (record == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public int solution(int[] recordA, int[] recordB){
        int cnt = 0;

        for(int i = 0 ; i < 10 ; i++) {
            if(recordA[i] == recordB[i]) {
                continue;
            } else if(recordA[i] == func(recordB[i])) {
                cnt -= 1;
                if(cnt < 0) {
                    cnt = 0;
                }
            } else {
                cnt += 3;
            }
        }
        return cnt;
    }*/
    public int func(int record){
        if(record == 0) return 1;
        else if(record == 1) return 2;
        return 0;
    }

    public int solution(int[] recordA, int[] recordB){
        int cnt = 0;
        for(int i = 0; i < recordA.length; i++){
            if(recordA[i] == recordB[i])
                continue;
            else if(recordA[i] == func(recordB[i]))
                cnt = cnt + 3;
            else
                cnt = cnt - 1;
                if(cnt < 0) {
                    cnt = 0;
                }
        }
        return cnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        int ret = ex06.solution(recordA, recordB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
