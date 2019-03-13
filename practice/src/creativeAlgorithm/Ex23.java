package creativeAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex23 {
    private static int solution(final int n) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.size() != 0) {
            int tmp = q.poll();
            if(tmp > n) {
                continue;
            } else if(tmp == n) {
                cnt++;
                continue;
            }
            q.add(tmp + 1);
            q.add(tmp + 2);
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = solution(n);
        System.out.println(result);
    }
}
