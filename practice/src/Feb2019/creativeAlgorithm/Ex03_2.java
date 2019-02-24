package Feb2019.creativeAlgorithm;

import java.util.Scanner;

/*
    linear structure search
    n개로 이루어진 정수 집합에서 원하는 수의 위치를 찾으시오.
 */
public class Ex03_2 {

    public static int solution(int[] arr, int target) {
        int result = solve(target, arr, 0, arr.length - 1);
        return result;
    }

    public static int solve(int target, int[] arr, int pl, int pr) {
        // 이미 오름차순이 되어 있음
        // 가운데 수 찾기
//        final int middle = (pl + pr) / 2;
//        if (arr[middle] == target) {
//            return middle + 1;
//        } else if (arr[middle] < target) {
//            return solve(target, arr, middle + 1, pr);
//        } else if (target < arr[middle]) {
//            return solve(target, arr, pl, middle - 1);
//        } else {
//            return -1;
//        }

//        while(0 <= pl && pr < arr.length) {
            int pv = (pl + pr) / 2;
            if (arr[pv] == target) {
                return pv + 1;
            } else if(arr[pv] > target) {
                return solve(target, arr, pl, pv - 1);
            } else if(arr[pv] < target) {
                return solve(target, arr, pv + 1, pr);
            } else {
                return -1;
            }
//        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println("1 >> " + solution(arr, target));
    }

}
