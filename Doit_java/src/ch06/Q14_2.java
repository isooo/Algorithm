package ch06;

import java.util.Scanner;

public class Q14_2 {

    static int medPivot(int a, int b, int c) {
        if (a >= b) {
            if (b >= c) {
                return b;
            } else if (a <= c) {
                return a;
            } else {
                return c;
            }
        } else if (a > c) {
            return a;
        } else if (b > c) {
            return c;
        } else {
            return b;
        }
    }

    static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > left && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();       // 왼쪽커서
            int pr = right = rstack.pop();      // 오른쪽커서

            System.out.printf("스택에서 분할하는 문제를 꺼냈습니다.a[%d]~a[%d]를 분할합니다.\n", left, right);
            System.out.print("\tlstack ( " + pl + " ) || ");
            lstack.dump();
            System.out.print("\trstack ( " + pr + " ) || ");
            rstack.dump();

            System.out.printf("\t\ta[%d] ~ a[%d] : {", left, right);
            for (int i = left; i < right; i++) {
                System.out.printf("%d , ", a[i]);
            }
            System.out.printf("%d}\n", a[right]);

            if (right - left < 9) {
                System.out.println(" ### 삽입정렬 시작 : " + left + " ~ " + right);

                insertionSort(a, left, right);
            } else {
                System.out.println(" ^^^퀵정렬 시작 : " + left + " ~ " + right);
                int x = medPivot(a[pl], a[(left + right) / 2], a[pr]);      // 피벗

                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr) {
                        swap(a, pl++, pr--);
                    }
                } while (pl <= pr);

                if (pr - left < right - pl) {
                    int tmp = pr;
                    pr = right;
                    right = tmp;
                    tmp = left;
                    left = pl;
                    pl = tmp;
                }

                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }

                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            }
        }
    }

    // 요소 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
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

//        int[] x = {10 , 235 , 59 , 23 , 1 , 900 , 459 , 95 , 34 , 58 , 19 , 340 , 72 , 51 , 8 , 20 , 83 , 31 , 89 , 102 , 77 , 93 , 203 , 401 , 4};

        quickSort(x, 0, cnt - 1);

        System.out.print("퀵정렬로 오름차순 정렬 완료 : ");
        for (int i = 0; i < cnt; i++) {
            System.out.print(" " + x[i]);
        }
    }

}
