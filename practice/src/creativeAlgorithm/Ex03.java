package creativeAlgorithm;

import java.util.Scanner;

/*
    linear structure search
    n개로 이루어진 정수 집합에서 원하는 수의 위치를 찾으시오.
 */
public class Ex03 {

    public static int solution(int cnt, int[] arr, int target) {
        for(int i = 0 ; i < cnt ; i++) {
            if(arr[i] == target) {
                return i + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println("1 >> " + solution(cnt, arr, target));
    }

}
