package Feb2019.creativeAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
    lower bound
    n개로 이루어진 정수 집합에서
    원하는 수 k 이상인 수가 처음으로 등장하는 위치를 찾으시오.
 */
public class Ex04 {

    public static int solution(int[] arr, int target) {
        int pl = 0;
        int pr = arr.length - 1;
        int mid = 0;
        while(pr - pl > 0) {
            for(int i = pl ; i < pr; i++) {
                System.out.printf("%4d", arr[i]);
            }
            System.out.println();
            mid = (pl + pr) / 2;
            System.out.println("\tmid : arr[" + mid + "] == " + arr[mid]);
            if(arr[mid] < target) {
                pl = mid + 1;
            } else {
                pr = mid;
            }
        }
        return pr + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println("result : " + solution(arr, target));
    }
}
