package creativeAlgorithm;

import java.util.LinkedList;
import java.util.Scanner;
/*
    1. 완전탐색을 이용할 경우, 최악은 O(6^40) 까지 갈 수 있으므로 계산량을 줄여야한다
    2. 현재 온도가 목표온도보다 (1.낮을  2.높을) 경우, 온도를 (1.내릴  2.올릴)필요가 없다
    3. 백트래킹을 이용한 깊이우선탐색은 비효율적이다
            모든 호출이 끝나야만 해답을 찾을 수 있기때문
    4. bfs를 이용해서, 목표 온도에 도닳했을 때 탐색을 중단하는 방법으로 해결할 수 있다
 */
public class Ex16 {
    static class Temp {
        int temp;
        int cnt;
        public Temp(int temp, int cnt) {
            this.temp = temp;
            this.cnt = cnt;
        }
    }

    private static void solution(int now, int target) {

        LinkedList<Temp> q = new LinkedList<>();
        q.add(new Temp(now, 0));
        int result = bfs(now, q, target);
        System.out.println(result);
    }

    private static int bfs(int now, LinkedList<Temp> q, int target) {
        int cnt = 0;
        while(!q.isEmpty()) {
            Temp tmp = q.poll();
            if(tmp.temp == target) {
                return tmp.cnt;
            }

            if(tmp.temp < target) {
                q.add(new Temp(tmp.temp + 1, tmp.cnt+1));
                q.add(new Temp(tmp.temp + 5, tmp.cnt+1));
                q.add(new Temp(tmp.temp + 10, tmp.cnt+1));
            } else {
                q.add(new Temp(tmp.temp - 1, tmp.cnt+1));
                q.add(new Temp(tmp.temp - 5, tmp.cnt+1));
                q.add(new Temp(tmp.temp - 10, tmp.cnt+1));
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int now = sc.nextInt();
        int target = sc.nextInt();
        solution(now, target);
    }
}
