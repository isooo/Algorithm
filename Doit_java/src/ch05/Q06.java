package ch05;

import java.util.Scanner;

public class Q06 {

    static char[] arr;

    static String[] name = {"A기둥", "B기둥", "C기둥"};

    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {

        if(no > 1) {
            move(no - 1, x, 6 - x - y);
        }

        System.out.println("원반[" + no + "] ==> " + arr[x - 1] + "기둥에서 " + arr[y - 1] + "기둥으로 옮김");
//        System.out.println("원반[" + no + "]를 " + name[x - 1] + "에서 " + name[y - 1] + "으로 옮김");


        if(no > 1) {
            move(no - 1, 6 - x - y, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = sc.nextInt();

        arr = new char[n];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = (char)(65 + i);
            System.out.println("==> " + arr[i]);
        }

        move(n, 1, 3);
    }
}
