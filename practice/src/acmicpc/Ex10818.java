package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
//        int max = -1000000;
//        int min = 1000000;
//        for(int i = 0 ; i < cnt ; i++) {
//            int tmp = sc.nextInt();
//            if(tmp > max) {
//                max = tmp;
//            }
//            if(tmp < min) {
//                min = tmp;
//            }
//        }
//        System.out.println(min + " " + max);

        int[] list = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
        System.out.println(list[0] + " " + list[cnt - 1]);

    }
}
