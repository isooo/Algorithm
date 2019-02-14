package ch02;

import java.util.Random;

/*
    배열의 요소의 최댓값을 출력  (요솟수와 값을 난수로 생성)
 */
public class Q01 {

    static int maxOf(int[] n) {
        int max = n[0];

        for (int i = 1; i < n.length; i++) {
            if (n[i] > max) max = n[i];
        }

        return max;
    }

    public static void main(String[] args) {
        Random rd = new Random();

        int count = rd.nextInt(10);
        System.out.println("사람 수 : " + count);

        int[] height = new int[count];

        for (int i = 0; i < count; i++) {
            height[i] = rd.nextInt(99) + 100;
            System.out.println(i + "번째 사람의 키 : " + height[i]);
        }

        System.out.println("가장 큰 키 : " + maxOf(height));
    }
}
