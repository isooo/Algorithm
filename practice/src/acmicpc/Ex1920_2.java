package acmicpc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
    N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
    이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오
 */
public class Ex1920_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++) {
            set.add(sc.nextInt());
        }
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++) {
            System.out.println(set.contains(sc.nextInt())? 1 : 0);
        }
    }
}
