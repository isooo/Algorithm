package creativeAlgorithm;

import java.util.Scanner;

/*
    고기잡이 : 전체 탐색 이용
 */
public class Ex12 {

    private static int solution(int n, int w, int[] arr) {
        int result = 0;
        for(int i = 0 ; i < n - w + 1 ; i++) {
            int tmp = 0;
            for(int j = i ; j < i + w ; j++) {
                tmp += arr[j];
            }
            if(tmp > result) {
                result = tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(n, w, arr));
    }
}
