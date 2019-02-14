package Jan2019;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {
/*
    Implement the canViewAll method, which, given a collection of movies, checks if they all can be viewed completely
    without overlap, efficiently with respect to time used.

    true case
    1/1/2015 20:00-21:30
    1/1/2015 23:10-23:30
    1/1/2015 21:30-23:00
 */


    static class Movie {
        private final LocalDateTime startDate;
        private final LocalDateTime endDate;

        public Movie(LocalDateTime startDate, LocalDateTime endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public LocalDateTime getEndDate() {
            return endDate;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    '}';
        }
    }

    public static boolean canViewAll(List<Movie> movies) {

// 1. 시작일 기준으로 movies 정렬
        List<Movie> sortedMovies = movies.stream()
                .sorted((m1, m2) -> m1.getStartDate().compareTo(m2.getStartDate()))
//                .sorted(Comparator.comparing(Movie::getStartDate))
                .collect(Collectors.toList());


// 2. 종료일이 다음인덱스의 시작일보다 앞 쪽이면 안겹친다! 더 뒤쪽이면 그대로 return false 하면 되것지
        for(int i = 0 ; i < movies.size() - 1 ; i++) {
            if(
                    sortedMovies.get(i).getEndDate()
                            .isAfter(
                                    sortedMovies.get(i + 1).getStartDate()
                            )
                    ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final List<Movie> movies = Arrays.asList(
                new Movie(
                        LocalDateTime.of(2018, 12, 25, 20, 00),
                        LocalDateTime.of(2018, 12, 25, 22, 30)),
                new Movie(
                        LocalDateTime.of(2018, 12, 24, 20, 00),
                        LocalDateTime.of(2018, 12, 24, 22, 30)),
                new Movie(
                        LocalDateTime.of(2018, 12, 25, 22, 30),
                        LocalDateTime.of(2018, 12, 25, 23, 30)),
                new Movie(
                        LocalDateTime.of(2018, 12, 25, 21, 00),
                        LocalDateTime.of(2018, 12, 25, 22, 30)),
                new Movie(
                        LocalDateTime.of(2018, 12, 23, 20, 00),
                        LocalDateTime.of(2018, 12, 23, 22, 30))
        );
        System.out.println("result : " + canViewAll(movies));
    }// main()

}