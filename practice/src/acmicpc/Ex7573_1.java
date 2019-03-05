package acmicpc;

import java.util.*;

public class Ex7573_1 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 연못 크기
        int netSize = sc.nextInt(); // 그물의 길이
        int targetNum = sc.nextInt(); // 물고기 수

        List<Loc> targetLoc = new ArrayList<>(netSize);
        sc.nextLine();

        for (int i = 0 ; i < targetNum ; i++) {
            final int x = sc.nextInt();
            final int y = sc.nextInt();
            targetLoc.add(new Loc(x, y));
        }

//        int n = 7;
//        int netSize = 10;
//        int targetNum = 6;
//        List<Loc> targetLoc = Arrays.asList(
//                new Loc(2, 2),
//                new Loc(2, 4),
//                new Loc(6, 2),
//                new Loc(7, 4),
//                new Loc(3, 3),
//                new Loc(5, 6)
//        );

        Collections.sort(targetLoc);
        solution3(n, netSize, targetNum, targetLoc);
    }

    private static void solution3(int n, int netSize, int targetNum, List<Loc> targetLoc) {
        int result = 0;
        final int maxLength = netSize / 2;
        for (final Loc a : targetLoc) {
            for (final Loc b : targetLoc) {
//                System.out.println(a + " + : " + b + " ==>" + getLength(a, b));
                if (getLength(a, b) < maxLength) {
                    final Loc leftTopEdge = getLeftTopEdge(a, b);

                    // 사각형 경우의 수대로 그리면서 몇개의 점이 있는지 찾기
                    for (int net = 1; net < maxLength; net++) {
                        int tmp = 0;
                        final int netRangeX = leftTopEdge.x + net;
                        final int netRangeY = leftTopEdge.y + (maxLength - net);

//                        System.out.println("netRangeX: " + netRangeX + ", netRangeY: " + netRangeY);

                        for (final Loc target : targetLoc) {
                            if (
                                    (leftTopEdge.x <= target.x && target.x <= netRangeX)
                                            && (leftTopEdge.y <= target.y && target.y <= netRangeY)
                            ) {
                                tmp++;
                            }
                        }
                        result = Math.max(result, tmp);
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static double getLength(final Loc a, final Loc b) {
        final int x = b.x - a.x;
        final int y = b.y - a.y;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static Loc getLeftTopEdge(final Loc a, final Loc b) {
        final int x = a.x < b.x? a.x : b.x;
        final int y = a.y < b.y? a.y : b.y;
        return new Loc(x, y);
    }

    static class Loc implements Comparable{
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Loc tmp = (Loc)o;
            if(this.x > tmp.x) {
                return 1;
            } else if(this.x == tmp.x) {
                if(this.y > tmp.y) {
                    return 1;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "[" +
                    x +
                    ", " + y +
                    ']';
        }
    }
}
