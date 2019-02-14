package ch02;


import java.util.Scanner;

/*
    연내의 경과 일 수를 구합니다(while문을 사용).
 */
public class Q08 {

    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d) {
        while (m > 1) {
            d += mdays[isLeap(y)][--m - 1];
        }
        return d;
    }

    static int leftDayOfYear(int y, int m, int d) {
        int days = mdays[isLeap(y)][m - 1] - d;
        for (int i = 12; i > m; i--) {
            days += mdays[isLeap(y)][i - 1];
        }
        return days;
    }

    static int leftDayOfYearAnswer(int y, int m, int d) {
        int days = d; // 일수

        for (int i = 1; i < m; i++) // 1월~(m-1)월의 일 수를 더함
            days += mdays[isLeap(y)][i - 1];
        return 365 + isLeap(y) - days;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int retry;

        do {
            System.out.print("1. 경과 일 수 구하기 / 2. 남은 일 수 구하기 : ");
            int select = sc.nextInt();

            System.out.print("년 : ");
            int year = sc.nextInt();
            System.out.print("월 : ");
            int month = sc.nextInt();
            System.out.print("일 : ");
            int day = sc.nextInt();

            if (select == 1) {
                System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
            } else {
                System.out.println(year + "년은 " + leftDayOfYear(year, month, day) + "일이 남았습니다.");
            }

            System.out.print("한번 더 할까요? (1. 예 / 0. 아니오) : ");
            retry = sc.nextInt();

        } while (retry != 0);

    }

}