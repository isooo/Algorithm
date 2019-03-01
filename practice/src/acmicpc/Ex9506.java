package acmicpc;

import java.util.*;

public class Ex9506 {
    private static void solution(List<Integer> list) {
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            List<Integer> ele = new ArrayList<>();
            int n = (Integer)(iter.next());
            int result = 0;
            for(int i = 1 ; i < n ; i++) {
                if(n % i == 0) {
                    result += i;
                    ele.add(i);
                }
            }
            System.out.print(n);
            if(result == n) {
                System.out.print(" = ");
                for(int i = 0 ; i < ele.size() - 1 ; i++) {
                    System.out.print(ele.get(i) + " + ");
                }
                System.out.println(ele.get(ele.size() - 1));
            } else {
                System.out.println(" is NOT perfect.");
            }
        }
    }

    private static void solution2(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            StringBuilder sb = new StringBuilder();
            int n = iter.next();
            sb.append(n).append(" = 1");
            int result = 1;
            for(int i = 2 ; i <= n/2 ; i++) {
                if(n % i == 0) {
                    result += i;
                    sb.append(" + ").append(i);
                }
            }
            if(result == n) {
                System.out.println(sb.toString());
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(true) {
            int n = sc.nextInt();
            if(n == -1) {
                break;
            } else {
                list.add(n);
            }
        }
        solution2(list);
    }
}
