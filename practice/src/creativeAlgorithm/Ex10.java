package creativeAlgorithm;

import java.util.Scanner;
/*
    최댓값
    9X9의 격자판에, 81개의 자연수가 주어질 때
    최댓값과 해당 좌표를 출력
 */
public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < 9 ; i++) {
            String[] str = sc.nextLine().split( " ");
            for(int j = 0 ; j < 9 ; j++) {
                int tmp = Integer.parseInt(str[j]);
                if(tmp > max) {
                    max = tmp;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x + " " + y);
    }
}
