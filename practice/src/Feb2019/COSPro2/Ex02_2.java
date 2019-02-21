package Feb2019.COSPro2;

public class Ex02_2 {

    private int solution(int n) {
        // 완성된 사각형을 담은 배열
        int [][] map = new int[n][n];

        int [] xPattern = {1, 0, -1, 0};
        int [] yPattern = {0, 1, 0, -1};
        // 패턴 인덱스
        int idx = 0;

        // 배열에 들어갈 실제 값
        int value = 0;

        // map의 배열 인덱스
        int xIdx = 0;
        int yIdx = 0;

        while(value < n * n) {

            // 배열 인덱스에 += Pattern[idx % 4]을 하여 그 결과가
            // 0보다 작거나, n을 넘거나, 이미 채워진 요소를 가리키고 있을 경우
            // += 되기 이전의 패턴값([xIdx], [yIdx])으로 되돌리기 위한 장치
            int xIdxT = xIdx;
            int yIdxT = yIdx;

            while(true) {
                xIdx = xIdxT;
                yIdx = yIdxT;
                // 벽을 만나지 않았고, 요소값이 0일때, ++value를 삽입
                if((0 <= xIdxT && xIdxT < n) && (0 <= yIdxT && yIdxT < n) && map[yIdxT][xIdxT] == 0) {
                    map[yIdxT][xIdxT] = ++value;
                }
                System.out.println("map[" + yIdxT + "][" + xIdxT + "] value : " + value);

                xIdxT += xPattern[idx % 4];
                yIdxT += yPattern[idx % 4];

                System.out.println("\tidx : " + idx);

                // 배열 인덱스에 idx패턴을 더했을 때, 조건에 어긋나면 break
                if(!((0 <= xIdxT && xIdxT < n) && (0 <= yIdxT && yIdxT < n) && map[yIdxT][xIdxT] == 0)) {
                    break;
                }
            }
            idx++;
            System.out.println("\t\tidx next : " + idx);
        }

        int result = 0;
        for(int i = 0 ; i < n ; i++) {
            result += map[i][i];
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.printf("%4d", map[i][j]);
            }
            System.out.println();
        }

        return result;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex02_2 ex02_2 = new Ex02_2();
        int n1 = 3;
        int ret1 = ex02_2.solution(n1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 4;
        int ret2 = ex02_2.solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
