package ch02;

import java.util.Scanner;

/*
    날짜 클래스 만들기
 */
public class Q11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quit = 0;

        while (true) {

            System.out.print("1. 몇 일 전 구하기 / 2. 몇 일 후 구하기 / 3. 그만하기 : ");
            quit = sc.nextInt();

            if (quit == 3) {
                break;
            }

            System.out.print("년 : ");
            int y = sc.nextInt();
            System.out.print("월 : ");
            int m = sc.nextInt();
            System.out.print("일 : ");
            int d = sc.nextInt();

            YMD ymd = new YMD(y, m, d);

            System.out.print("원하는 일 수 : ");
            int num = sc.nextInt();

            if (quit == 1) {
                System.out.println(ymd + "로 부터 " + num + "일 전은 ==> " + ymd.before(num));
            } else if (quit == 2) {
                System.out.println(ymd + "로 부터 " + num + "일 후는 ==> " + ymd.after(num));
            }
        }
    }
}

class YMD {
    int y;
    int m;
    int d;

    // 평년, 윤년
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // n일 뒤의 날짜를 반환
    YMD after(int n) {

        if (n < 0) {
            return (before(-n));
        }

        YMD tmpYMD = new YMD(this.y, this.m, this.d);

        tmpYMD.d += n;

        while (tmpYMD.d > mdays[isLeap(tmpYMD.y)][tmpYMD.m - 1]) {
            tmpYMD.d -= mdays[isLeap(tmpYMD.y)][tmpYMD.m - 1];

            if (++tmpYMD.m > 12) {
                tmpYMD.y++;
                tmpYMD.m = 1;
            }
        }

        return tmpYMD;
    }

    // n일 앞의 날짜를 반환
    YMD before(int n) {

        if (n < 0) {
            return (after(-n));
        }

        YMD tmpYMD = new YMD(this.y, this.m, this.d);

        tmpYMD.d -= n;

        while (tmpYMD.d < 1) {
            if (--tmpYMD.m < 1) {
                tmpYMD.y--;
                tmpYMD.m = 12;
            }
            tmpYMD.d += mdays[isLeap(tmpYMD.y)][tmpYMD.m - 1];
        }

        return tmpYMD;
    }

    @Override
    public String toString() {
        return y + "년 " + m + "월 " + d + "일";
    }
}
