package acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list = new int[9];
        int max = 0;
        int idx = 0;
        for(int i = 0 ; i < 9 ; i++) {
            int tmp = sc.nextInt();
            if(tmp > max) {
                max = tmp;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx + 1);
    }
}
