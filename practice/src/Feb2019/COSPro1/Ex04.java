package Feb2019.COSPro1;

public class Ex04 {
    // 1단계 : 배열에 들어있는 각 자연수의 개수를 셉니다
    int[] func_a(int[] arr) {
        int[] counter = new int[1001];
        for(int i = 0; i < arr.length; i++)
            counter[arr[i]]++;
        return counter;
    }

    // 2단계 : 가장 많이 등장하는 수의 개수를 구합니다
    int func_b(int[] arr) {
        int ret = 0;
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(ret < arr[i]) {
                ret = arr[i];
                idx = i;
            }
        }
        return ret;
    }

    // 3단계 :  가장 적게 등장하는 수의 개수를 구합니다
    int func_c(int[] arr) {
        final int INF = 1001;
        int ret = INF;
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && ret > arr[i]) {
                ret = arr[i];
                idx = i;
            }
        }
        return ret;
    }
    public int solution(int[] arr) {
        int[] counter = func_a(arr);
        int maxCnt = func_b(counter);
        int minCnt = func_c(counter);
        return maxCnt / minCnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        int[] arr = {1, 2, 3, 3, 1, 3, 3, 2, 3, 2};
        int ret = ex04.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
