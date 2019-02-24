package Feb2019.creativeAlgorithm;

import java.util.Scanner;
/*
    9개의 서로 다른 자연수가 주어질 때,
    이들 중 최댓값을 찾고 그 값이 몇 번째 수 인지를 구하는 프로그램을 작성하시오.
 */
public class Ex01 {

    public void solution(int[] arr) {

        int max = arr[0];
        int cnt = 0;

        for(int i = 1 ; i < 9 ; i++) {
            if(arr[i] > max) {
                max = arr[i];
                cnt = i;
            }
        }
        System.out.println(max);
        System.out.println(cnt + 1);
    }

    public static void main(String[] args) {
        Ex01 ex = new Ex01();
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i = 0 ; i < 9 ; i++) {
            arr[i] = sc.nextInt();
        }
        ex.solution(arr);
    }

}
