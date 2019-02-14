package ch06;

import java.util.Scanner;

/*
    피벗 선택하기
    1. 요소 3개 선택하여 정렬.
    2. 가운데 요소와 맨 끝에서 두번째 요소를 교환
    3. 끝에서 두번째 요소를 피벗으로 정함.
                ==> a[left] 는 피벗 이하의 값이고, a[right] 와 a[right], a[right - 1]은 피벗 이상의 값이다.
 */
public class Q15_1 {

    // x[a], x[b], x[c]를 sort (중앙값의 index를 반환)
    static int sort3Elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a])
            swap(x, b, a);
        if (x[c] < x[b])
            swap(x, c, b);
        if (x[b] < x[a])
            swap(x, b, a);
        return b;
    }

    static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = a[i];
//            System.out.println("i :: " + i);
//            System.out.println("tmp :: " + tmp);
            int j;
            for (j = i; j > left && a[j - 1] > tmp; j--) {
//                System.out.println("\tj :: " + j);
//                System.out.println("\ta[j] :: " + a[j]);
//                System.out.println("\ta[j-1] :: " + a[j-1]);
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    // 요소 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }


    // 배열 나누기
    static void quickSort(int[] a, int left, int right) {
        if (right - left < 9) {
            System.out.println("삽입정렬 시작 : " + left + " ~ " + right);
            insertionSort(a, left, right);
        } else {
            System.out.println("퀵정렬 시작 : " + left + " ~ " + right);
            int pl = left;         // 왼쪽
            int pr = right;     // 오른쪽

            int x; // 피벗
            int m = sort3Elem(a, pl, (pl + pr) / 2, pr);
            x = a[m];
            swap(a, m, right - 1);
            pl++;
            pr--;

            System.out.println("피벗 : " + x + " // pl : " + pl + " // pr : " + pr);

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr) {
                    swap(a, pl++, pr--);
                }
            } while (pl <= pr);

            if (pr - left > right - pl) {
                int tmp = left;
                left = pl;
                pl = tmp;
                tmp = right;
                right = pr;
                pr = tmp;
            }

            if (left < pr) {
                quickSort(a, left, pr);
            }
            if (pl < right) {
                quickSort(a, pl, right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int cnt = sc.nextInt();
        int[] x = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, cnt - 1);

        System.out.print("퀵정렬로 오름차순 정렬 완료 : ");
        for (int i = 0; i < cnt; i++) {
            System.out.print(" " + x[i]);
        }
    }
}
