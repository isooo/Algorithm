//package acmicpc;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;
///*
//    1. 전체 탐색. 시간초과
//    2. 물고기가 있는 위치를 왼쪽 위 모서리로 보고 그물 펼치기. 틀림
//    3...?
// */
//
//public class Ex7573 {
//    private static void solution(int n, int netSize, int targetNum, int[][] targetLoc, int[] maxMin) {
////        int[][] netCase = getNetCase(netSize);
//        int result = 0;
//        for(int i = maxMin[1] ; i < maxMin[0] - 1 ; i++) {
//            for(int j = maxMin[3] ; j < maxMin[2] - 1 ; j++) {
//                for(int h = 1 ; h < netSize / 2 ; h++) {
////                    if(i + netCase[h][0] < n && j + netCase[h][1] < n) {
//                    if(i + h < n && j + (netSize / 2 - h) < n) {
//                        int tmp = 0;
////                        int rangeX = i + netCase[h][0];
////                        int rangeY = j + netCase[h][1];
//                        int rangeX = i + h;
//                        int rangeY = j + (netSize / 2) - h;
//                        for(int t = 0 ; t < targetNum ; t++) {
//                            if((i <= targetLoc[t][0] && targetLoc[t][0] <= rangeX) && (j <= targetLoc[t][1] && targetLoc[t][1] <= rangeY)) {
//                                tmp++;
//                            }
//                        }
//                        if(tmp > result) {
//                            result = tmp;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(result);
//    }
//
//    private static void solution2(int n, int netSize, int targetNum, ArrayList<Loc> targetLoc) {
//        int result = 0;
//        for(int i = 0 ; i < targetNum ; i++) {
//            int targetX = targetLoc.get(i).x;
//            int targetY = targetLoc.get(i).y;
//            System.out.println(targetX + ", " + targetY);
//            for(int h = 1 ; h < netSize / 2 ; h++) {
//                int tmp = 0;
//                if (targetX + h < n && targetY + (netSize / 2 - h) < n) {
//                    int rangeX = targetX + h;
//                    int rangeY = targetY + (netSize / 2) - h;
//                    for(int t = 0 ; t < targetNum ; t++) {
//                        if((targetX <= targetLoc.get(t).x && targetLoc.get(t).x <= rangeX) && (targetY <= targetLoc.get(t).y && targetLoc.get(t).y <= rangeY)) {
//                            System.out.println("--");
//                            tmp++;
//                        }
//                    }
//                }
////                else if(targetX == n - 1 || targetY == n - 1) {
////
////                }
//                if(tmp > result) {
//                    result = tmp;
//                }
//            }
//        }
//        System.out.println(result);
//    }
//
//    private static void solution3(int n, int netSize, int targetNum, ArrayList<Loc> targetLoc) {
//        int result = 0;
//        final int maxLength = netSize / 2;
//        for (final Loc a : targetLoc) {
//            for (final Loc b : targetLoc) {
////                System.out.println(a + " + : " + b + " ==>" + getLength(a, b));
//                if (getLength(a, b) < maxLength) {
//                    final Loc leftTopEdge = getLeftTopEdge(a, b);
//
//                    // 사각형 경우의 수대로 그리면서 몇개의 점이 있는지 찾기
//                    for(int net = 1 ; net < maxLength ; net++) {
//                        int tmp = 0;
//                        int netRangeX = leftTopEdge.x + net;
//                        int netRangeY = leftTopEdge.y + (maxLength - net);
//                        for(final Loc target : targetLoc) {
////                            System.out.println("\t target : " + target);
//                            if((netRangeX < n + 1 && netRangeY < n + 1)
//                                    && (leftTopEdge.x <= target.x && target.x <= netRangeX)
//                                    && (leftTopEdge.y <= target.y && target.y <= netRangeY)
//                            ) {
//                                System.out.println("\t" + leftTopEdge.x + " ~ " + netRangeX
//                                 + " :: " + leftTopEdge.y + " ~ " + netRangeY);
//                                tmp++;
//                            }
//                        }
//                        result = Math.max(result, tmp);
//                        System.out.println("----------------");
//                    }
//                }
//            }
//        }
//        System.out.println(result);
//    }
//
//    private static double getLength(final Loc a, final Loc b) {
//        final int x = b.x - a.x;
//        final int y = b.y - a.y;
//        return Math.sqrt(x^2 + y^2);
//    }
//
//    private static Loc getLeftTopEdge(final Loc a, final Loc b) {
//        final int x = a.x < b.x? a.x : b.x;
//        final int y = a.y < b.y? a.y : b.y;
//        return new Loc(x, y);
//    }
//
//    static class Loc implements Comparable{
//        int x;
//        int y;
//
//        public Loc(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public int compareTo(Object o) {
//            Loc tmp = (Loc)o;
//            if(this.x > tmp.x) {
//                return 1;
//            } else if(this.x == tmp.x) {
//                if(this.y > tmp.y) {
//                    return 1;
//                }
//            }
//            return -1;
//        }
//
//        @Override
//        public String toString() {
//            return "[" +
//                    x +
//                    ", " + y +
//                    ']';
//        }
//    }
//
//
//    // 반만 조사해도 되는데, 나중에 어차피 그물의 경우의 수를 다 훑어봐야하니 일단 다 넣음
//    private static int[][] getNetCase(int netSize) {
//        int[][] netCase = new int[netSize/2][2];
//        for(int i = 0 ; i < netSize/2 ; i++) {
//            netCase[i][0] = i;
//            netCase[i][1] = netSize/2 - i;
//        }
//        return netCase;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();       // 연못 크기
//        int netSize = sc.nextInt();       // 그물의 길이
//        int targetNum = sc.nextInt();       // 물고기 수
////        int[][] targetLoc = new int[targetNum][2];
//
//        ArrayList<Loc> targetLoc = new ArrayList<>(netSize);
//
//        sc.nextLine();
//
//        for(int i = 0 ; i < targetNum ; i++) {
////            targetLoc[i][0] = sc.nextInt() - 1;
////            targetLoc[i][1] = sc.nextInt() - 1;
//            targetLoc.add(new Loc(sc.nextInt() - 1, sc.nextInt() - 1));
//        }
//        Collections.sort(targetLoc);
////        System.out.println(targetLoc.toString());
////        solution2(n, netSize, targetNum, targetLoc);
//        solution3(n, netSize, targetNum, targetLoc);
//
////        solution(n, netSize, targetNum, targetLoc, maxMin);
//    }
//}