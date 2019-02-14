package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
    신체검사 데이터 배열에서 특정 시력 검색
    (배열의 요소는 시력순이라는 가정하에..)
 */
public class Q07 {

    public static void main(String[] args) {

        PhyscData[] x = {
                new PhyscData("a", 162, 0.3),
                new PhyscData("b", 162, 0.4),
                new PhyscData("c", 162, 0.5),
                new PhyscData("d", 162, 0.7),
                new PhyscData("e", 162, 0.9),
                new PhyscData("f", 162, 1.2),
                new PhyscData("g", 162, 1.5),
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("찾고자 하는 시력을 입력하세요 : ");
        int vision = sc.nextInt();

        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", 0, vision),
                PhyscData.VISION_ORDER);

        if (idx < 0) {
            System.out.println("요소가 없습니다.");
        } else {
            System.out.println("x[" + idx + "] 에 있습니다 ==> " + x[idx]);
        }
    }


    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.vision > o2.vision) ? 1 :
                        (o1.vision < o2.vision) ? -1 : 0;
            }
        }
    }
}
