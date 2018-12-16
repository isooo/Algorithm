package ch06;

import java.util.Scanner;

public class Q17 {

    // 2의 n 제곱을 구합니다
    static int pow2(int n) {
        int k = 1;

        while (n-- > 0)
            k *= 2;
        return (k);
    }

    // n개의 스페이스를 출력
    static void printSpace(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(' ');
    }

    // 힙을 출력
    static void printHeap(int a[], int n) {
        int i = n;
        int height = 1; // 트리의 높이
        while ((i >>= 1) > 0)
            height++;
        i = 0;
        int w = 1;
        Loop: {
            for (int level = 0; level < height; level++) {
                printSpace(pow2(height - level) - 3);
                for (int k = 0; k < w; k++) {
                    System.out.printf(" %02d", a[i++]);
                    if (i >= n)
                        break Loop;
                    if (k < w - 1)
                        printSpace(pow2(height - level + 1) - 2);
                }
                System.out.println();

                printSpace(pow2(height - level) - 4);
                for (int k = 0; k < w; k++) {
                    if (2 * k + i < n)
                        System.out.print(" ／ ");
                    if (2 * k + i + 1 < n)
                        System.out.print(" ＼ ");
                    if (k < w - 1)
                        printSpace(pow2(height - level + 1) - 4);
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }

    static void swap(int[] a, int idx1, int idx2) {
        System.out.println(a[idx1] + " <----> " + a[idx2]);
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // a[left] ~ a[right] 를 힙으로 만든다
    static void downHeap(int[] a, int left, int right) {
        int tmp = a[left];      // 루트
        int child;              // 큰 값을 가진 노드
        int parent;             // 부모

        for(parent = left ; parent < (right + 1) / 2 ; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;   // 큰 값을 가진 노드를 자식에 대입

            if(tmp >= a[child]) {
                break;
            }
            a[parent] = a[child];
        }
        a[parent] = tmp;
    }

    // 힙 정렬
    static void heapSort(int[] a, int n) {

        // a[i]~a[n-1]를 힙으로 만들기
        for(int i = (n - 1) / 2 ; i >= 0 ; i--) {
            downHeap(a, i, n - 1);
            printHeap(a, n);
        }

        // a[0]~a[i-1]를 힙으로 만들기 (오름차순으로 정렬하기 위해)
        for(int i = n - 1 ; i > 0 ; i--) {
            swap(a, 0, i);      // 가장 큰 요소와, 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a, 0, i - 1);
            printHeap(a, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("요솟수 : ");
//        int cnt = sc.nextInt();
//        int[] x = new int[cnt];
//
//        for (int i = 0; i < cnt; i++) {
//            System.out.print("x[" + i + "] : ");
//            x[i] = sc.nextInt();
//        }

        int cnt = 10;
        int[] x = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};


        heapSort(x, cnt);

        System.out.print("힙정렬로 오름차순 정렬 완료 : ");
        for(int i = 0 ; i < cnt ; i++) {
            System.out.print(" " + x[i]);
        }
    }
}
