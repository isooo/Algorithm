package Feb2019.COSPro1;

public class Ex04_2 {
    // 1 : 배열에 들어있는 각 자연수의 개수를 셉니다
    int[] func_a(int[] arr){
        int [] list = new int[1000];

        for(int i = 0 ; i < arr.length ; i++) {
            list[arr[i] - 1]++;
        }

        return list;
    }

    // 2 : 가장 많이 등장하는 수의 개수를 구합니다
    int func_b(int[] arr){
        int maxCnt = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(maxCnt < arr[i]) {
                maxCnt = arr[i];
            }
        }
        return maxCnt;
    }

    // 3 : 가장 적게 등장하는 수의 개수를 구합니다
    int func_c(int[] arr){
        int minCnt = 1000;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] != 0 && arr[i] < minCnt) {
                minCnt = arr[i];
            }
        }
        return minCnt;
    }

    // 4 : 가장 많이 등장하는 수가 가장 적게 등장하는 수보다 몇 배 더 많은지 구합니다
    public int solution(int[] arr) {
        int [] list = func_a(arr);

        int maxCnt = func_b(list);
        int minCnt = func_c(list);

        return maxCnt / minCnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex04_2 ex04_2 = new Ex04_2();
        int[] arr = {1, 2, 3, 3, 1, 3, 3, 2, 3, 2};
        int ret = ex04_2.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
