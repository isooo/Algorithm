package ch03;

import java.util.Scanner;

/*
    이진검색 (같은 맨 앞 요소를 찾습니다)
        : 실수한 부분은
            1.
                x[pc] == value 일 때, 더 앞쪽 요소가 있는지 검색하는 부분에서
                pc는 pl 보다 크면 되는데, for문 상에서 pc가 0이 될 때까지 순환시킨 부분과
            2.
                x[pc] == value 부분
                (x[pc - 1] < value 로 체크하여도 되는데..)
 */
public class Q05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int num = sc.nextInt();

        int[] x = new int[num];

        System.out.print("x[0]의 요소 : ");
        x[0] = sc.nextInt();

        for (int i = 1 ; i < num ; i++) {
            do{
                System.out.print("x[" + i + "]의 요소 : ");
                x[i] = sc.nextInt();
            } while(x[i] < x[i - 1]);
        }

        System.out.print("찾고자 하는 값 : ");
        int value = sc.nextInt();

        int key = binSearchXAnswer(x, num, value);

        if (key == -1) {
            System.out.println("해당하는 값은 없습니다.");
        } else {
            System.out.println("해당하는 " + value + "의 가장 앞쪽 키는 " + key + "입니다.");
        }

    }

    static int binSearch(int[] x, int num, int value) {

        int pl = 0;
        int pr = num - 1;
        int result = -1;

        do{
            int pc = (pl + pr) / 2;
            if(x[pc] == value) {
                result = binSearch(x, pc, value);
                break;
            } else if(x[pc] < value) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }

        } while(pl <= pr);

        return result;
    }

    static int binSearchX(int[] x, int key, int value){

        int result = key;
        for(int i = key ; i >= 0 ; i--) {
            if(x[i] == value) {
               result = i;
            }
        }
        return result;
    }

    static int binSearchXAnswer(int[] x, int num, int value) {

        int pl = 0;
        int pr = num - 1;

        do{
            int pc = (pl + pr) / 2;
            if(x[pc] == value) {
                for(; pc > pl ; pc--) {
                    if(x[pc - 1] < value) {
                        break;
                    }
                }
                return pc;
            } else if(x[pc] < value) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }

        } while(pl <= pr);

        return -1;
    }

}