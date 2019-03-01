package creativeAlgorithm;

import java.util.Scanner;

/*
    upper bound
    n개로 이루어진 정수 집합에서
    원하는 수 k보다 큰 수가 처음으로 등장하는 위치를 찾으시오.
 */
public class Ex05 {
    public static int solution(int[] arr, int target) {
        int mid = 0;
        int pl = 0;
        int pr = arr.length - 1;
        while(pr - pl > 0) {
            mid = (pr + pl) / 2;
            if(arr[mid] <= target) {
                pl = mid + 1;
            } else {
                pr = mid;
            }
        }
        if(arr[pr] <= target) {
            pr++;
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
