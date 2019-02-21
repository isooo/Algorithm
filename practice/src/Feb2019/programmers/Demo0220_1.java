package Feb2019.programmers;

import java.util.Arrays;

/*
    직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때,
    나머지 한 점의 좌표를 구하려고 합니다.
    점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때,
    직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록
    solution 함수를 완성해주세요.
    단, 직사각형의 각 변은 x축, y축에 평행하며,
    반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.

    제한사항
        v는 세 점의 좌표가 들어있는 2차원 배열입니다.
        v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
        좌표값은 1 이상 10억 이하의 자연수입니다.
        직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
 */

public class Demo0220_1 {
    public int[] solution(int[][] v) {
        int[] x_tmp = new int[3];
        int[] y_tmp = new int[3];

        for(int i = 0, j = 0 ; i < v.length ; i++, j++) {
            x_tmp[j] = v[i][0];
            y_tmp[j] = v[i][1];
        }

        int x = func(x_tmp);
        int y = func(y_tmp);
        int[] answer = {x, y};
        return answer;
    }

    private int func(int[] tmp) {
        Arrays.sort(tmp);
        if(tmp[0] == tmp[1]) {
            return tmp[2];
        } else {
            return tmp[0];
        }
    }


    public static void main(String[] args) {
        Demo0220_1 t = new Demo0220_1();
//        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        int[] result = t.solution(v);
        System.out.println("result : " + Arrays.toString(result));
    }
}
