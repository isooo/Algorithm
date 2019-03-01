package Feb2019.acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2501 {
    private static int solution(int n, int k) {
        int result = 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2 ; i <= n ; i++) {
            if(n % i == 0) {
                list.add(i);
            }
        }

        if(list.size() >= k) {
            result = list.get(k - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }
}
