package creativeAlgorithm;

import java.util.Scanner;

public class Ex15 {
    static class Graph {
        int V;
        int[][] list;

        public Graph(int v) {
            V = v;
            list = new int[V + 1][];
            for(int i = 1 ; i < list.length ; i++) {
                list[i] = new int[V + 1];
            }
        }

        void addEdge(int start, int end, int value) {
            list[start][end] = value;
        }
    }

    private static int target;
    private static int result;
    private static Graph g;
    private static int[] chk;

    public static void solution(int node, int loc) {
        System.out.println("node : " + node + " // target : " + target);
        System.out.println("loc : " + loc + "\n---------");
        if(node == target) {
            if (loc < result) {
                result = loc;
                System.out.println("\t\tresult : " + result);
                return;
            }
        }
        for(int i=1; i<=target; i++) {
            if(chk[i] == 0 && g.list[node][i] != 0) {
                // i가 방문한 적이 없고, node와 i간에 edge가 있다면(== 가중치가 있다면)
                System.out.println("\t" + node + " - " + i);
                chk[i] = 1;
                solution(i, (loc + g.list[node][i]));
                chk[i] = 0;
                System.out.println("\t\t 백트랙 : " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        int edgeCnt = sc.nextInt();
        g = new Graph(target);
        // g내부에 V값은 target와 동일하지만
        // list의 length는 target + 1이다
        //      ==> 가중치 줄 때마다 node에 -1 하는게 번거러워서
        //             아예 노드를 1부터 nodeCnt 까지 만들고 0은 쓰지 않을 예정
/*        for(int i = 0 ; i < edgeCnt ; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int value = sc.nextInt();
            g.addEdge(node1, node2, value);
            g.addEdge(node2, node1, value);
            // 역방향으로도 움직일 수 있다했기 때문에, 두 node에 교차로 다 연결시켜줘야한다
        }
*/

        g.addEdge(1, 2, 47);
        g.addEdge(2, 1, 47);
        g.addEdge(1, 3, 69);
        g.addEdge(3, 1, 69);
        g.addEdge(2, 4, 57);
        g.addEdge(4, 2, 57);

        g.addEdge(2, 5, 124);
        g.addEdge(5, 2, 124);
        g.addEdge(3, 4, 37);
        g.addEdge(4, 3, 37);
        g.addEdge(3, 5, 59);
        g.addEdge(5, 3, 59);
        g.addEdge(3, 6, 86);
        g.addEdge(6, 3, 86);
        g.addEdge(4, 6, 27);
        g.addEdge(6, 4, 27);
        g.addEdge(4, 7, 94);
        g.addEdge(7, 4, 94);
        g.addEdge(5, 7, 21);
        g.addEdge(7, 5, 21);
        g.addEdge(6, 7, 40);
        g.addEdge(7, 6, 40);
// 149

        result = 200 * target;
        chk = new int[target+1];
        chk[1] = 1;
        solution(1, 0);
        // node 1까지 방문한 상태이고, 이동거리는 200*target(나올 수 있는 가장 큰 가중치값)
        System.out.println(result == 0 ? -1 : result);


    }
}
