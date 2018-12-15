package ch06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q16 {
    static class PhyscData {
        String name;
        int height;
        double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        static final Comparator<PhyscData> VISION_ORDER = new HeightOrderComparator();
//        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData p1, PhyscData p2) {
                return (p1.vision < p2.vision) ? 1 : (p1.vision > p2.vision) ? -1 : 0;
            }

// 키의 오름차순
/*
            @Override
            public int compare(PhyscData p1, PhyscData p2) {
                return (p1.height > p2.height) ? 1 : (p1.height < p2.height) ? -1 : 0;
            }
*/
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("a", 162, 0.3),
                new PhyscData("b", 122, 1.0),
                new PhyscData("c", 145, 0.5),
                new PhyscData("d", 128, 0.8),
                new PhyscData("e", 146, 1.2),
                new PhyscData("f", 182, 0.1),
                new PhyscData("g", 159, 1.1),
                new PhyscData("h", 171, 0.9),
        };

        Arrays.sort(x, PhyscData.VISION_ORDER);

        System.out.println("이름\t\t키\t시력");
        for(int i = 0 ; i < x.length ; i++) {
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
    }
}
